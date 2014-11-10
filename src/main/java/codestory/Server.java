package codestory;

import net.codestory.http.*;
import net.codestory.http.routes.*;

public class Server {
	public static void main(String[] args) {
		new WebServer(new ServerConfiguration()).start();
	}

	public static class ServerConfiguration implements Configuration {
		@Override
		public void configure(Routes routes) {
			routes
					.add(IndexResource.class)
					.add(BasketResource.class);
		}
	}
}
