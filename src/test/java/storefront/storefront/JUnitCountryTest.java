package storefront.storefront;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import storefront.storefront.domain.cars.Country;

@SpringBootTest
public class JUnitCountryTest {

	@Test
	public void settersandgetters() {
		Country country = new Country();
		country.setName("Germany");
		assertThat(country.getName().contentEquals("germany"));
	}

}
