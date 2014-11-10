package codestory;

import static codestory.Server.*;
import static com.jayway.restassured.RestAssured.*;
import static java.util.Arrays.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

import net.codestory.http.*;
import net.codestory.http.injection.*;

import org.junit.*;

public class BasketRestTest {
	WebServer webServer = new WebServer(new ServerConfiguration()).startOnRandomPort();

	@Test
	public void query_basket() {
		given().port(webServer.port())
				.when().get("/basket?emails=david@devoxx.io,jeanlaurent@devoxx.io")
				.then().contentType("application/json").statusCode(200)
				.and().body("sum", equalTo(2000));
	}

	@Test
	public void query_scores() {
		BasketFactory basketFactory = mock(BasketFactory.class);
		Basket basket = basket(4, 3, 0, 3, 5, 2000);
		when(basketFactory.basket(asList("david@devoxx.io", "jeanlaurent@devoxx.io"))).thenReturn(basket);

		// Mock the BasketFactory
		webServer.configure(routes -> {
			new ServerConfiguration().configure(routes);

			Singletons singletons = new Singletons();
			singletons.register(BasketFactory.class, basketFactory);
			routes.setIocAdapter(singletons);
		});

		given().port(webServer.port())
				.when().get("/basket?emails=david@devoxx.io,jeanlaurent@devoxx.io")
				.then().body("test", equalTo(4)).
				and().body("back", equalTo(3)).
				and().body("database", equalTo(0)).
				and().body("front", equalTo(3)).
				and().body("hipster", equalTo(5)).
				and().body("sum", equalTo(2000));
	}

	private static Basket basket(int test, int back, int database, int front, int hipster, int sum) {
		Basket basket = new Basket();
		basket.test = test;
		basket.back = back;
		basket.database = database;
		basket.front = front;
		basket.hipster = hipster;
		basket.sum = sum;
		return basket;
	}
}
