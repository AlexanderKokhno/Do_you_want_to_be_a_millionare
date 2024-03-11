
import org.json.JSONObject;
import org.json.JSONArray;

public class TriviaQuestionParser {

  public static void parseAndDisplayQuestion(String jsonResponse) {
    JSONObject jsonObject = new JSONObject(jsonResponse);
    JSONArray results = jsonObject.getJSONArray("results");
    JSONObject firstResult = results.getJSONObject(0);
    String question = firstResult.getString("question");
    String correctAnswer = firstResult.getString("correct_answer");
    JSONArray incorrectAnswers = firstResult.getJSONArray("incorrect_answers");
    System.out.println("Question: " + question);
    System.out.println("Correct Answer: " + correctAnswer);
    System.out.println("Incorrect Answers: " + incorrectAnswers.join(", "));
  }
}
