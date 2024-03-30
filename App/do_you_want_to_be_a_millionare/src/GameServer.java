import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class GameServer {

  private static final String HTML_FILE_PATH = "App/do_you_want_to_be_a_millionare/src/index.html";

  public static void startServer() throws Exception {

    HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
    server.createContext("/", new FileHandler());
    server.setExecutor(null);
    server.start();
    System.out.println("Attempting Server Launch.... please stand by");
    System.out.println("Press Enter to stop the server");
    System.in.read(); // Wait for user to press Enter

    closeServer(server);

  }

  public static void closeServer(HttpServer server) {
    if (server != null) {
      server.stop(0);
      System.out.println("Server Killed");
    }

  }

  static class FileHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
      File file = new File(HTML_FILE_PATH);

      if (!file.exists()) {
        exchange.sendResponseHeaders(404, 0);
        exchange.getResponseBody().close();
        return;

      }

      exchange.sendResponseHeaders(200, file.length());
      try (FileInputStream in = new FileInputStream(file);
          OutputStream out = exchange.getResponseBody()) {
        byte[] buffer = new byte[1024];
        int length;
        while ((length = in.read(buffer)) != -1) {
          out.write(buffer, 0, length);
        }
        System.out.println("Server started at http://localhost:8000/game");
      }
    }
  }
}