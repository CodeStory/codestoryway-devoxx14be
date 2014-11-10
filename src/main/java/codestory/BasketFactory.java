package codestory;

import java.util.*;
import java.util.stream.*;

public class BasketFactory {
	private final Developers developers;
	private final Tags tags;

	public BasketFactory(Developers developers, Tags tags) {
		this.developers = developers;
		this.tags = tags;
	}

	public Basket basket(List<String> emails) {
		Basket basket = new Basket();

		Stream<Developer> developers = emails.stream().map(email -> this.developers.find(email));

		developers.forEach(developer -> {
			basket.test += tags.count("test", developer.tags);
			basket.back += tags.count("back", developer.tags);
			basket.database += tags.count("database", developer.tags);
			basket.front += tags.count("front", developer.tags);
			basket.hipster += tags.count("hipster", developer.tags);
			basket.sum += developer.price;
		});

		return basket;
	}
}
