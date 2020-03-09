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
@Controller
public class LiveryController {
	
	// Injektoidaan repositoryt
	@Autowired
	private LiveryRepository repository;
	
	@Autowired
	private GameRepository grepository;
	
	@RequestMapping("/liverylist")
	public String liveryList(Model model) {
		model.addAttribute("Liveries", repository.findAll());
		return "liverylist";
	}
	
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
	
	// Add livery
	@RequestMapping("/addlivery")
		public String addLivery(Model model) {
		model.addAttribute("newLivery", new Livery()); // Luo uuden tyhjän Livery olion, joka lähetetään addlivery.html
		model.addAttribute("games", grepository.findAll()); // hakee kaikki GameRepositoryn tiedot, ja lähettää ne lomakkeelle
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
			System.out.println("Edit metodi" + id);
			model.addAttribute("editLivery", repository.findById(id).get());
			model.addAttribute("games", grepository.findAll());
			return "editlivery";
		}
	
	// Delete livery
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteLivery(@PathVariable("id") Long liveryId, Model model) { // Path variable poimii requestista "path variable" -tiedon (ID)
		System.out.println("Poisto metodi" + liveryId);
		repository.deleteById(liveryId);
		return "redirect:../liverylist";
	}
	
}
