
import org.json.JSONObject;
import org.json.JSONArray;

public class TriviaQuestionParser {

  public static void parseAndDisplayQuestion (String jsonResponse) { 
    JSONObject jsonObject = new JSONObject(jsonResponse);
    JSONArray results = jsonObject.getJSONArray( key: "results"); 
    JSONObject firstResult = results.getJSONObject(index: 0);
    String question = firstResult.getString( key: "question");
    String correctAnswer = firstResult.getString( key: "correct_answer"); 
    JSONArray incorrectAnswers = firstResult.getJSONArray( key: "incorrect_answers");
    System.out.println("Question: "+ question);
    System.out.println("Correct Answer: " + correctAnswer);
    System.out.println("Incorrect Answers: " +  incorrectAnswers.join( separator: ", "));
  }
}
