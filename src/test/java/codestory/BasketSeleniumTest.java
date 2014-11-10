package codestory;

import static codestory.Server.*;

import net.codestory.http.*;
import net.codestory.simplelenium.*;

import org.junit.*;

public class BasketSeleniumTest extends SeleniumTest {
	WebServer webServer = new WebServer(new ServerConfiguration()).startOnRandomPort();

	@Override
	public String getDefaultBaseUrl() {
		return "http://localhost:" + webServer.port();
	}

	@Test
	public void list_developers() {
		goTo("/");

		find(".developer").should().haveSize(7);
		find(".developer").should().contain("David", "Jean-Laurent");
	}

	@Test
	public void add_one_developer() {
		goTo("/");

		find("#David .add").click();

		find("#basket .test:not(.ng-hide)").should().haveSize(1);
		find("#basket .back:not(.ng-hide)").should().haveSize(1);
		find("#basket .database:not(.ng-hide)").should().beEmpty();
		find("#basket .front:not(.ng-hide)").should().haveSize(2);
		find("#basket .hipster:not(.ng-hide)").should().haveSize(1);
	}

	@Test
	public void add_two_developers() {
		goTo("/");

		find("#David .add").click();
		find("#Mathilde .add").click();

		find("#basket .price").should().contain("1700");
	}
}
