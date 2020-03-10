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
import storefront.storefront.domain.cars.Country;
import storefront.storefront.domain.cars.CountryRepository;
import storefront.storefront.domain.cars.Manufacturer;
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
	@Autowired
	private CountryRepository crepository;
	
	
// Login page
	
	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}
	
	
//Index page
		
	

	
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
	
// Carmodel
	
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
	public String deleteCarmodel(@PathVariable("id") Long carmodelid, Model model) { // Path variable poimii requestista "path variable" -tiedon (ID)
		System.out.println("Poisto metodi" + carmodelid);
		cmrepository.deleteById(carmodelid);
		return "redirect:../carmodellist";
	}
	
// Manufacturer
	
	// List Carmodels
		@RequestMapping("/carmanufacturerlist")
		public String carmanufacturerList(Model model) {
			model.addAttribute("Manufacturers", mrepository.findAll());
			return "carmanufacturerlist";
		}
	
	// Add manufacturer
	@RequestMapping("/addcarmanufacturer")
	public String addManufacturer(Model model) {
	model.addAttribute("newCarmanufacturer", new Manufacturer()); // Luo uuden tyhjän olion
	model.addAttribute("countries", crepository.findAll());
	return "addcarmanufacturer";
	}
	
	// Save added manufacturer
	@RequestMapping(value = "/saveCarmanufacturer", method = RequestMethod.POST)
	public String saveManufacturer(Manufacturer manufacturer) {
	mrepository.save(manufacturer);
	return "redirect:carmanufacturerlist";
	}
	
	// Edit manufacturer
	
	@RequestMapping(value = "/editcarmanufacturer/{id}", method = RequestMethod.GET)
	public String editCarmanufacturer(@PathVariable("id") Long manid, Model model) {
		model.addAttribute("editCarmanufacturer", mrepository.findById(manid).get());
		model.addAttribute("countries", crepository.findAll());
		System.out.println("Manufacturer id: " + manid + "onko olemassa? ");
		return "editcarmanufacturer";
	}
		
	// Delete manufacturer
	@RequestMapping(value = "/deletecarmanufacturer/{id}", method = RequestMethod.GET)
	public String deleteManufacturer(@PathVariable("id") Long manufacturerid, Model model) { // Path variable poimii requestista "path variable" -tiedon (ID)
		System.out.println("Poisto metodi" + manufacturerid);
		mrepository.deleteById(manufacturerid);
		return "redirect:../carmanufacturerlist";
}

//Country
	
	// List Countries
		@RequestMapping("/countrylist")
		public String countryList(Model model) {
			model.addAttribute("countries", crepository.findAll());
			return "countrylist";
		}
		
	// Add country
	@RequestMapping("/addcountry")
	public String addCountry(Model model) {
	model.addAttribute("newCountry", new Country()); // Luo uuden tyhjän olion
	return "addcountry";
	}
	
	// Save added country
	@RequestMapping(value = "/saveCountry", method = RequestMethod.POST)
	public String saveCountry(Country country) {
	crepository.save(country);
	return "redirect:countrylist";
	}
	
	// Edit country
	@RequestMapping(value = "/editcountry/{id}", method = RequestMethod.GET)
	public String editCountry(@PathVariable("id") Long cid, Model model) {
		model.addAttribute("editCountry", crepository.findById(cid).get());
		return "editcountry";
	}
		
	// Delete country
	@RequestMapping(value = "/deletecountry/{id}", method = RequestMethod.GET)
	public String deleteCountry(@PathVariable("id") Long countryid, Model model) { // Path variable poimii requestista "path variable" -tiedon (ID)
		System.out.println("Poisto metodi" + countryid);
		crepository.deleteById(countryid);
		return "redirect:../countrylist";
}
}

