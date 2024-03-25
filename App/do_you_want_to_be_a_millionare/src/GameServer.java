import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class GameServer {
  public static void startServer() {
    try {
      HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
      server.createContext("/game", (exchange -> {
        String response = "<html><body> <h1>Who Wants to Be a Millionaire Coder</h1><p>Welcome to the game!</p></body></html>";
        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
      }));

      server.start();
      System.out.println("Server started at http://localhost:8000/game");
    } catch (IOException e) {

    }
  }
}