package storefront.storefront;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import storefront.storefront.domain.cars.Country;
import storefront.storefront.domain.cars.Manufacturer;

@SpringBootTest
public class JUnitManufacturerTest {

	@Test
	public void thisclass() {
		Manufacturer manufacturer = new Manufacturer();
		manufacturer.setName("Porsche");
		assertThat(manufacturer.getName().contentEquals("Porsche"));
	}
	
	@Test
	public void settersandgetters() {
		Manufacturer manufacturer = new Manufacturer();
		Country country = new Country("Germany");
		
		manufacturer.setName("Porsche");
		manufacturer.setCountry(country);
		assertThat(manufacturer.getName().contentEquals("Porsche"));
		assertThat(manufacturer.getCountry().getName().contentEquals("Germany"));
	}

}
