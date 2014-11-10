package codestory;

import static org.assertj.core.api.Assertions.*;

import org.junit.*;

public class DevelopersTest {
	Developers developers = new Developers();

	@Test
	public void load_developers() {
		Developer[] all = developers.findAll();

		assertThat(all).hasSize(7);
	}
}