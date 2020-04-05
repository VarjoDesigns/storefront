package storefront.storefront;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import storefront.storefront.domain.users.User;


@SpringBootTest
public class JUnitUserTest {

	@Test
	public void thisclass() {
		User user = new User ("Varjo Designs", "$2y$12$tRl5sXhlrNz2dMS05GjPWei5CEScNEQLlnSNBDUTGIcWJxLKb/ddK", "USER");
		
		assertThat(user.getUsername().contentEquals("Varjo Designs"));
		assertThat(user.getPasswordHash().contentEquals("$2y$12$tRl5sXhlrNz2dMS05GjPWei5CEScNEQLlnSNBDUTGIcWJxLKb/ddK"));
		assertThat(user.getRole().contentEquals("USER"));
	}
}
