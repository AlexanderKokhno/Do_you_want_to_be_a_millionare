
import org.json.JSONObject;
import org.json.JSONArray;
import java.util.Arrays;

public class TriviaQuestionParser {

  public static boolean parseAndDisplayQuestion(String jsonResponse) {
    JSONObject jsonObject = new JSONObject(jsonResponse);
    JSONArray results = jsonObject.getJSONArray("results");
    JSONObject firstResult = results.getJSONObject(0);
    String question = firstResult.getString("question");
    String questionDifficulty = firstResult.getString("difficulty");
    String correctAnswer = firstResult.getString("correct_answer");
    String[] incorrectAnswers = JSONtoJAVA.convertJSONArrayToStringArray(firstResult.getJSONArray("incorrect_answers"));

    System.out.println("Question: " + question);

    String[] in = incorrectAnswers;
    String[] allAnswers = new String[in.length + 1]; // Create new array with same size
    allAnswers[0] = correctAnswer;

    for (int i = 1; i <= in.length; i++) {
      allAnswers[i] = in[i - 1];
    }
    System.out.println("DELEATE THIS IS FOR DEBUG " + correctAnswer);
    boolean gotAnsCorrect;
    gotAnsCorrect = Question.questionF(question, allAnswers, correctAnswer, questionDifficulty);
    return gotAnsCorrect;

  }

}
