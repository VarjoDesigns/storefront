package storefront.storefront;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import storefront.storefront.domain.Game;
import storefront.storefront.domain.GameRepository;
import storefront.storefront.domain.Livery;
import storefront.storefront.domain.LiveryRepository;
import storefront.storefront.domain.cars.Carmodel;
import storefront.storefront.domain.cars.CarmodelRepository;
import storefront.storefront.domain.cars.Country;
import storefront.storefront.domain.cars.CountryRepository;
import storefront.storefront.domain.cars.Manufacturer;
import storefront.storefront.domain.cars.ManufacturerRepository;
import storefront.storefront.domain.users.User;
import storefront.storefront.domain.users.UserRepository;


@SpringBootApplication
public class StorefrontApplication {

	public static void main(String[] args) {
		SpringApplication.run(StorefrontApplication.class, args);
	}
	
	@Bean // Command line runner for H2 database testing, remove before MariaDB application!
	public CommandLineRunner demo(
			LiveryRepository repository, 
			GameRepository grepository, 
			UserRepository urepository, 
			CountryRepository crepository,
			ManufacturerRepository mrepository,
			CarmodelRepository cmrepository) {
		
	return (args) -> {
		
		// Countries testdata
		crepository.save(new Country("Japan"));
		crepository.save(new Country("Germany"));
		crepository.save(new Country("France"));
		crepository.save(new Country("USA"));
		
		// Manufacturer testdata
		mrepository.save(new Manufacturer("Porsche", crepository.findByName("Germany").get(0)));
		mrepository.save(new Manufacturer("Bugatti", crepository.findByName("France").get(0)));
		
		// Carmodel testdata
		cmrepository.save(new Carmodel("Rauh Welt Begriff 993", mrepository.findByName("Porsche").get(0)));
		cmrepository.save(new Carmodel("918 Spyder", mrepository.findByName("Porsche").get(0)));
		cmrepository.save(new Carmodel("Chiron", mrepository.findByName("Bugatti").get(0)));
				
		// Games testdata
		grepository.save(new Game("Forza Motorsport 7", "FM7"));
		grepository.save(new Game("Forza Horizon 4", "FH4"));
		
		// Livery testdata
		repository.save(new Livery("Martini","Porsche 918 Spyder","010200345", grepository.findByName("Forza Motorsport 7").get(0), cmrepository.findByName("918 Spyder").get(0)));
		repository.save(new Livery("Don Joewon Song","This RWB 993 was custom created for Don Joewon Song","010600345", grepository.findByName("Forza Horizon 4").get(0), cmrepository.findByName("Rauh Welt Begriff 993").get(0)));
		repository.save(new Livery("Ghiaccio","Bugatti Chiron with style - ice cold sharpie livery shared!","010400345", grepository.findByName("Forza Horizon 4").get(0), cmrepository.findByName("Chiron").get(0)));

		// Ajon aikaiset demokäyttäjät
		urepository.save(new User ("user", "$2y$12$tRl5sXhlrNz2dMS05GjPWei5CEScNEQLlnSNBDUTGIcWJxLKb/ddK", "USER")); //Makkarasalaatti12
		urepository.save(new User ("admin", "$2y$12$vC8phhrYcaMQW1QY6AjvWuT92ThI2bWay44CMiqa5.zJUhvqD5f76", "ADMIN")); //Makkarasalaatti53
		urepository.save(new User ("asdasd", "$2y$12$BR6qPHpeL22LhjZ3SkHrbuEFTbVktN7cQBozeZlnDPp4V6/bhsitG", "ADMIN")); //Makkarasalaatti53
		
	};
	}
}
