package codestory;

import java.util.*;

import net.codestory.http.annotations.*;

import com.google.common.base.*;

public class BasketResource {
	private final BasketFactory basketFactory;

	public BasketResource(BasketFactory basketFactory) {
		this.basketFactory = basketFactory;
	}

	@Get("/basket?emails=:emails")
	public Basket basket(String emailList) {
		List<String> emails = Splitter.on(",").omitEmptyStrings().splitToList(emailList);

		return basketFactory.basket(emails);
	}
}
