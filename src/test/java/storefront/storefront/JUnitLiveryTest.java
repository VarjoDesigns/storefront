package storefront.storefront;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import storefront.storefront.domain.Game;
import storefront.storefront.domain.Livery;
import storefront.storefront.domain.cars.Carmodel;
import storefront.storefront.domain.cars.Country;
import storefront.storefront.domain.cars.Manufacturer;
import storefront.storefront.domain.users.User;

@SpringBootTest
public class JUnitLiveryTest {

	@Test
	public void liverytest() {
		Livery livery = new Livery();
		
		livery.setName("Martini");
		livery.setDescription("asdasdasdasdasd");
		livery.setSharecode("123456789");
		
		assertThat(livery.getName().contentEquals("Martini"));
		assertThat(livery.getDescription().contentEquals("asdasdasdasdasd"));
		assertThat(livery.getSharecode().contentEquals("123456789"));
	}
	
	@Test
	public void relationUser() {
		Livery livery = new Livery();
		User user = new User("Varjo Designs", "$2y$12$tRl5sXhlrNz2dMS05GjPWei5CEScNEQLlnSNBDUTGIcWJxLKb/ddK", "USER");
		
		livery.setName("Martini");
		livery.setDescription("asdasdasdasdasd");
		livery.setSharecode("123456789");
		livery.setUser(user);
		
		assertThat(livery.getUser().getUsername().contentEquals("Varjo Designs"));
	}
	
	@Test
	public void relationGame() {
		Livery livery = new Livery();
		Game game = new Game("Forza Horizon 4", "FH4");
		
		livery.setGame(game);
		
		assertThat(livery.getGame().getName().contentEquals("Forza Horizon 4"));
	}
	
	@Test
	public void relationCar() {
		Livery livery = new Livery();
		
		Country country = new Country("Germany");
		Manufacturer manufacturer = new Manufacturer("Porsche", country);
		Carmodel carmodel = new Carmodel("Rauh Welt Begriff 993", manufacturer);
		
		livery.setName("Martini");
		livery.setDescription("asdasdasdasdasd");
		livery.setSharecode("123456789");
		manufacturer.setCountry(country);
		carmodel.setManufacturer(manufacturer);
		livery.setCarmodel(carmodel);
		
		assertThat(livery.getCarmodel().getManufacturer().getCountry().getName().contentEquals("Germany"));
		assertThat(livery.getCarmodel().getManufacturer().getName().contentEquals("Porsche"));
		assertThat(livery.getCarmodel().getName().contentEquals("Rauh Welt Begriff 993"));
	}
	
	@Test
	public void relationAll() {
		Livery livery = new Livery();
		Game game = new Game("Forza Horizon 4", "FH4");
		
		Country country = new Country("Germany");
		Manufacturer manufacturer = new Manufacturer("Porsche", country);
		Carmodel carmodel = new Carmodel("Rauh Welt Begriff 993", manufacturer);
		User user = new User("Varjo Designs", "$2y$12$tRl5sXhlrNz2dMS05GjPWei5CEScNEQLlnSNBDUTGIcWJxLKb/ddK", "USER");
		
		livery.setName("Martini");
		livery.setDescription("asdasdasdasdasd");
		livery.setSharecode("123456789");
		livery.setGame(game);
		
		manufacturer.setCountry(country);
		carmodel.setManufacturer(manufacturer);
		livery.setCarmodel(carmodel);
		livery.setUser(user);
		
		assertThat(livery.getGame().getName().contentEquals("Forza Horizon 4"));
		assertThat(livery.getCarmodel().getManufacturer().getCountry().getName().contentEquals("Germany"));
		assertThat(livery.getCarmodel().getManufacturer().getName().contentEquals("Porsche"));
		assertThat(livery.getCarmodel().getName().contentEquals("Rauh Welt Begriff 993"));
		assertThat(livery.getUser().getUsername().contentEquals("Varjo Designs"));
	}

}
