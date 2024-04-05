import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

public class QuestionFetcher {
  String token = "TESTTOKENradomChancePreventer3hdYF8996SP";

  public static String fetchTriviaQuestions(String IncomingDifficulty, String type) {
    String difficulty;
    if (App.playingGame == true) {
      if ((App.playerScore < 6) || (App.playerScore == 0)) {
        difficulty = "easy";
      }
      if (App.playerScore < 11) {
        difficulty = "medium";
      }
      if (App.playerScore > 10) {
        difficulty = "hard";
      } else {
        difficulty = "any";
        System.out.println("ERROR IN QUESTION FETCHER!");
      }
    } else if (App.playingGame == false) {
      difficulty = IncomingDifficulty;
    } else {
      difficulty = "any";
      System.out.println(App.playingGame);
      System.out.println("ERROR IN QUESTION FETCHER! /");
    }

    QuestionFetcher Qfetcher = new QuestionFetcher();
    int amount = 1;

    HttpClient client = HttpClient.newHttpClient();
    String url = "https://opentdb.com/api.php?"
        + "amount=" + amount
    // + "&token=" + Qfetcher.token // not functional rn
    ;
    if (difficulty == "any") {

    } else {
      url = url + "&difficulty=" + difficulty;
    }
    if (type == "any") {

    } else {
      url = url + "&type=" + type;
    }
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
