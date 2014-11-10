package codestory;

import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.*;
import org.junit.runner.*;
import org.mockito.*;
import org.mockito.runners.*;

@RunWith(MockitoJUnitRunner.class)
public class BasketResourceTest {
	@Mock
	BasketFactory basketFactory;

	@InjectMocks
	BasketResource resource;

	@Test
	public void create_basket_for_emails() {
		Basket expectedBasket = new Basket();
		when(basketFactory.basket(asList("david@devoxx.io", "jeanlaurent@devoxx.io"))).thenReturn(expectedBasket);

		Basket basket = resource.basket("david@devoxx.io,jeanlaurent@devoxx.io");

		assertThat(basket).isSameAs(expectedBasket);
	}
}
