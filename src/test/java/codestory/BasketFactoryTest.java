package codestory;

import static java.util.Collections.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.*;
import org.junit.runner.*;
import org.mockito.*;
import org.mockito.runners.*;

@RunWith(MockitoJUnitRunner.class)
public class BasketFactoryTest {
	@Mock
	Developers developers;
	@Mock
	Tags tags;

	@InjectMocks
	BasketFactory basketFactory;

	@Test
	public void empty_basket() {
		Basket basket = basketFactory.basket(emptyList());

		assertThat(basket.sum).isZero();
	}
}