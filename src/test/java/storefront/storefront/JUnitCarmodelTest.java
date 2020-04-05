package storefront.storefront;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import storefront.storefront.domain.cars.Carmodel;
import storefront.storefront.domain.cars.Country;
import storefront.storefront.domain.cars.Manufacturer;

@SpringBootTest
public class JUnitCarmodelTest {

	@Test
	public void thisclass() {
		Carmodel carmodel = new Carmodel();
		carmodel.setName("918 Spyder");
		assertThat(carmodel.getName().contentEquals("918 Spyder"));
	}
	
	@Test
	public void settersandgetters() {
		Carmodel carmodel = new Carmodel();
		Manufacturer manufacturer = new Manufacturer("Porsche");
		Country country = new Country("Germany");
		manufacturer.setCountry(country);
		
		carmodel.setManufacturer(manufacturer);
		assertThat(carmodel.getManufacturer().getName().contentEquals("Porsche"));
		assertThat(carmodel.getManufacturer().getCountry().getName().contentEquals("Germany"));
	}

}
