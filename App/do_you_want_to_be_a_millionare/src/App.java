import org.json.JSONObject;

import org.json.JSONArray;

public class App {

    public static void main(String[] args) throws Exception {
        int amount = 1;
        String type = "multiple";
        String difficulty = "medium";

        // GameServer.startServer();

        TriviaQuestionParser.parseAndDisplayQuestion(QuestionFetcher.fetchTriviaQuestions(amount, type, difficulty));
        System.out.println(TriviaQuestionParser.question);

    }
}
