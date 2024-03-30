import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

public class QuestionFetcher {
  String token = "TESTTOKENradomChancePreventer3hdYF8996SP";

  public static String fetchTriviaQuestions(int amount, String type, String difficulty) {
    QuestionFetcher Qfetcher = new QuestionFetcher();

    HttpClient client = HttpClient.newHttpClient();
    String url = "https://opentdb.com/api.php?" +
        "amount=" + amount
        + "&difficulty=" + difficulty
        + "&type=" + type
    // + "&token=" + Qfetcher.token // not functional rn
    ;
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .build();
    try {
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
      return response.body();
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
      return null; // Simplified error handling|
    }

  }

  public static String resetTriviaToken() {
    QuestionFetcher Qfetcher = new QuestionFetcher();
    HttpClient client = HttpClient.newHttpClient();
    String url = "https://opentdb.com/api_token.php?command=reset" + "&token" + Qfetcher.token;
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .build();
    try {
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
      return "Token Reset";
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
      return null; // Simplified error handling|
    }

  }

  // public static void main(String[] args) {
  // String ff;
  // ff = fetchTriviaQuestions();
  // System.out.println(ff);
  // }
}
