
import org.json.JSONObject;
import org.json.JSONArray;
import java.util.Arrays;
import java.util.Random;

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
    System.out.println(incorrectAnswers);

    convertJSONArrayToStringArray(incorrectAnswers);
    testfun(incorrectAnswers);

  }

  public static String[] convertJSONArrayToStringArray(JSONArray jsonArray) {
    String[] stringArray = new String[jsonArray.length()];
    for (int i = 0; i < jsonArray.length(); i++) {
      stringArray[i] = jsonArray.getString(i);
    }

    return stringArray;

  }

  static void testfun(JSONArray jsonArray) {
    String[] stringArray = convertJSONArrayToStringArray(jsonArray);
    System.out.println("---------------");
    System.out.println(Arrays.toString(stringArray));
    System.out.println(stringArray[1]);
  }

}
