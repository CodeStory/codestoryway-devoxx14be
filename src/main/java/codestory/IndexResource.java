package codestory;

import net.codestory.http.annotations.*;
import net.codestory.http.templating.*;

public class IndexResource {
	private final Developers developers;

	public IndexResource(Developers developers) {
		this.developers = developers;
	}

	@Get("/")
	public Model index() {
		return Model.of("developers", developers.findAll());
	}
}
