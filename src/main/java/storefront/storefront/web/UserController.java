package storefront.storefront.web;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import storefront.storefront.domain.Livery;
import storefront.storefront.domain.users.RegisterUser;
import storefront.storefront.domain.users.User;
import storefront.storefront.domain.users.UserRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/register")
	public String addNewUser(Model model) {
		System.out.println("Register new user");
		model.addAttribute("registerUser", new RegisterUser());
		return "/register";
	}
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("registerUser") RegisterUser registerUser, BindingResult bindingResult) {
		System.out.println("saveUser-metodi");
		if (!bindingResult.hasErrors()) { // validation errors
			System.out.println("Validation has errors");
			if (registerUser.getPassword().equals(registerUser.getPwdcheck())) { // check password match
				String pwd = registerUser.getPassword();
				BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
				String hashPwd = bc.encode(pwd);

				User newUser = new User();
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
				bindingResult.rejectValue("passwordCheck", "err.passCheck", "Password does not match");
				return "register";
			}
		} else {
			System.out.println("Return registration");
			return "register";
		}
		System.out.println("Login");
		return "redirect:/login";
	}
	
	

	// Users
	
		// List users
		@RequestMapping("/userlist")
		public String userlist(Model model) {
			model.addAttribute("Users", userRepository.findAll());
			return "userlist";
		}
		
		// Add user on user controllerin puolella
		
		// Change user
		@RequestMapping(value = "/edituser/{id}", method = RequestMethod.GET)
		public String editUser(@PathVariable("id") Long id, Model model) {
			System.out.println("Edit user" + id);
			model.addAttribute("editUser", userRepository.findById(id).get());
			return "edituser";
		}
		
		// Delete user
		@RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.GET)
		public String deleteUser(@PathVariable("id") Long userid, Model model) { // Path variable poimii requestista "path variable" -tiedon (ID)
			System.out.println("Deleting user: " + userid);
			userRepository.deleteById(userid);
			return "redirect:../userlist";
		}

}
