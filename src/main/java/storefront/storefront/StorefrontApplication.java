package storefront.storefront;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import storefront.storefront.domain.Game;
import storefront.storefront.domain.GameRepository;
import storefront.storefront.domain.Livery;
import storefront.storefront.domain.LiveryRepository;
import storefront.storefront.domain.User;
import storefront.storefront.domain.UserRepository;


@SpringBootApplication
public class StorefrontApplication {

	public static void main(String[] args) {
		SpringApplication.run(StorefrontApplication.class, args);
	}
	
	@Bean // Command line runner for H2 database testing, remove before MariaDB application!
	public CommandLineRunner demo(LiveryRepository repository, GameRepository grepository, UserRepository urepository) {
	return (args) -> {
		
		// Games testdata
		grepository.save(new Game("Forza Motorsport 7", "FM7"));
		grepository.save(new Game("Forza Horizon 4", "FH4"));
		
		// Livery testdata
		repository.save(new Livery("Martini","This Porsche 918 Spyder has been wrapped in Martini livery","010200345", grepository.findByName("Forza Motorsport 7").get(0)));
		repository.save(new Livery("Don Joewon Song","This RWB 993 was custom created for Don Joewon Song","010600345", grepository.findByName("Forza Horizon 4").get(0)));
		repository.save(new Livery("Ghiaccio","Bugatti Chiron with style - ice cold sharpie livery shared!","010400345", grepository.findByName("Forza Horizon 4").get(0)));
		
		// Ajon aikaiset demokäyttäjät
		urepository.save(new User ("user", "$2y$12$tRl5sXhlrNz2dMS05GjPWei5CEScNEQLlnSNBDUTGIcWJxLKb/ddK", "USER")); //Makkarasalaatti12
		urepository.save(new User ("admin", "$2y$12$vC8phhrYcaMQW1QY6AjvWuT92ThI2bWay44CMiqa5.zJUhvqD5f76", "Admin")); //Makkarasalaatti53
		
	};
	}
}
