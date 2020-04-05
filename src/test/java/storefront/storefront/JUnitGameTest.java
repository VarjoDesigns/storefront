package storefront.storefront;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import storefront.storefront.domain.Game;

@SpringBootTest
public class JUnitGameTest {

	@Test
	public void thisclass() {
		Game game = new Game("Forza Horizon 4", "FH4");
		assertThat(game.getName().contentEquals("Forza Horizon 4"));
		assertThat(game.getAbbreviation().contentEquals("FH4"));
	}
}