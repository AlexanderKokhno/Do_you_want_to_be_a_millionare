import org.json.JSONObject;

public class App {

    public static void main(String[] args) throws Exception {
        int amount = 1;
        String type = "multiple";
        String difficulty = "medium";

        TriviaQuestionParser.parseAndDisplayQuestion(QuestionFetcher.fetchTriviaQuestions(amount, type, difficulty));



    }
}
