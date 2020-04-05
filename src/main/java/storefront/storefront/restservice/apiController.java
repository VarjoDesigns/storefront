package storefront.storefront.restservice;

import java.util.List;
import storefront.storefront.domain.Game;
import storefront.storefront.domain.GameRepository;
import storefront.storefront.domain.Livery;
import storefront.storefront.domain.LiveryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class apiController {
	
	// Injektoidaan repot mukaan:
	@Autowired
	private LiveryRepository repository;
	@Autowired
	private GameRepository grepository;
	
	
@GetMapping(value = "/liveries")
public @ResponseBody List<Livery> liveryListRest() {
	return (List<Livery>) repository.findAll();
}

@GetMapping(value = "/games")
public @ResponseBody List<Game> gameListRest() {
	return (List<Game>) grepository.findAll();
}

}
