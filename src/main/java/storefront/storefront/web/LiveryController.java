package storefront.storefront.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import storefront.storefront.domain.Game;
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
	
	// Delete livery
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteLivery(@PathVariable("id") Long liveryId, Model model) { // Path variable poimii requestista "path variable" -tiedon (ID)
		repository.deleteById(liveryId);
		return "redirect:../liverylist";
	}
	
}
