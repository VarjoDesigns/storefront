package storefront.storefront.web;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import storefront.storefront.domain.User;
import storefront.storefront.domain.UserRepository;
import storefront.storefront.domain.RegisterUser;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/registerNewUser")
	public String addNewUser(Model model) {
		System.out.println("Register new user");
		model.addAttribute("registerUser", new RegisterUser());
		return "register";
	}
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("registerUser") RegisterUser registerUser, BindingResult bindingResult) {
		System.out.println("saveUser-metodi");
		if (!bindingResult.hasErrors()) { // validation errors
			if (registerUser.getPassword().equals(registerUser.getPwdcheck())) { // check password match
				String pwd = registerUser.getPassword();
				BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
				String hashPwd = bc.encode(pwd);

				User newUser = new User();
				newUser.setFirstName(registerUser.getFirstName());
				newUser.setLastName(registerUser.getLastName());
				newUser.setPasswordHash(hashPwd);
				newUser.setUsername(registerUser.getUsername());
				newUser.setRole(registerUser.getRole().toUpperCase());
				if (userRepository.findByUsername(registerUser.getUsername()) == null) { // Check if user exists
					userRepository.save(newUser);
				} else {
					bindingResult.rejectValue("username", "err.username", "Username already exists");
					return "register";
				}
			} else {
				bindingResult.rejectValue("passwordCheck", "err.passCheck", "Passwords does not match");
				return "register";
			}
		} else {
			return "register";
		}
		return "redirect:/login";
	}
}
