package storefront.storefront.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import storefront.storefront.domain.GameRepository;
import storefront.storefront.domain.Livery;
import storefront.storefront.domain.LiveryRepository;
import storefront.storefront.domain.cars.Carmodel;
import storefront.storefront.domain.cars.CarmodelRepository;
import storefront.storefront.domain.cars.ManufacturerRepository;
import storefront.storefront.domain.users.UserRepository;
@Controller
public class LiveryController {
	
	// Injektoidaan repositoryt
	@Autowired
	private LiveryRepository repository;
	
	@Autowired
	private GameRepository grepository;
	
	@Autowired
	private CarmodelRepository cmrepository;
	
	@Autowired
	private ManufacturerRepository mrepository;
	
	@Autowired
	private UserRepository urepository;
	
	
// Login page
	
	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}
		
//Index page
		
	@GetMapping("/*")
	public String index(Model model) {
		return "index";
	}

	
// Livery
	
	// List liveries
	@RequestMapping("/liverylist")
	public String liveryList(Model model) {
		model.addAttribute("Liveries", repository.findAll());
		return "liverylist";
	}
		
	// Add livery
	@RequestMapping("/addlivery")
		public String addLivery(Model model) {
		model.addAttribute("newLivery", new Livery()); // Luo uuden tyhjän Livery olion, joka lähetetään addlivery.html
		model.addAttribute("games", grepository.findAll()); // hakee kaikki GameRepositoryn tiedot, ja lähettää ne lomakkeelle
		model.addAttribute("carmodels", cmrepository.findAll());
		model.addAttribute("manufacturers", mrepository.findAll());
		model.addAttribute("users", urepository.findAll());
		
		return "addlivery";
	}
	
	// Save added livery
		@RequestMapping(value = "/saveLivery", method = RequestMethod.POST)
		public String saveLivery(Livery livery) {
		repository.save(livery);
		return "redirect:liverylist";
		}
	
	// Change livery
		@RequestMapping(value = "/editlivery/{id}", method = RequestMethod.GET)
		public String editLivery(@PathVariable("id") Long id, Model model) {
			System.out.println("Edit livery" + id);
			model.addAttribute("editLivery", repository.findById(id).get());
			model.addAttribute("games", grepository.findAll());
			model.addAttribute("carmodels", cmrepository.findAll());	// Lähetetään automallit. Livery on sidottu automalliin
			model.addAttribute("manufacturers", mrepository.findAll()); // Lähetetään automerkit. Livery on mallin kautta kiinni merkissä
			model.addAttribute("users", urepository.findAll());
			return "editlivery";
		}
	
	// Delete livery
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteLivery(@PathVariable("id") Long liveryId, Model model) { // Path variable poimii requestista "path variable" -tiedon (ID)
		System.out.println("Poisto metodi" + liveryId);
		repository.deleteById(liveryId);
		return "redirect:../liverylist";
	}
	
	// List Carmodels
	@RequestMapping("/carmodellist")
	public String carmodelList(Model model) {
		model.addAttribute("Carmodels", cmrepository.findAll());
		return "carmodellist";
	}
	
	// Add carmodel
	@RequestMapping("/addcarmodel")
	public String addCarmodel(Model model) {
	model.addAttribute("newCarmodel", new Carmodel()); // Luo uuden tyhjän Livery olion, joka lähetetään addlivery.html
	model.addAttribute("manufacturers", mrepository.findAll());
	return "addcarmodel";
	}
	
	// Save added carmodel
	@RequestMapping(value = "/saveCarmodel", method = RequestMethod.POST)
	public String saveCarmodel(Carmodel carmodel) {
	cmrepository.save(carmodel);
	return "redirect:carmodellist";
	}
	
	// Edit carmodel
	
	@RequestMapping(value = "/editcarmodel/{id}", method = RequestMethod.GET)
	public String editCarmodel(@PathVariable("id") Long cmid, Model model) {
		model.addAttribute("editCarmodel", cmrepository.findById(cmid).get());
		model.addAttribute("manufacturers", mrepository.findAll());
		return "editcarmodel";
	}
	
	// Delete carmodel
	@RequestMapping(value = "/deletecarmodel/{id}", method = RequestMethod.GET)
	public String deleteCarmodel(@PathVariable("id") Long carmodelId, Model model) { // Path variable poimii requestista "path variable" -tiedon (ID)
		System.out.println("Poisto metodi" + carmodelId);
		cmrepository.deleteById(carmodelId);
		return "redirect:../carmodellist";
	}
}
