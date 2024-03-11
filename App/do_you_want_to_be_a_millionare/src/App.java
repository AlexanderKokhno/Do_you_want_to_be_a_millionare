import org.json.JSONObject;

public class App {
    public static void main(String[] args) throws Exception {
        String ff;

        // System.out.println(Player.score);

        TriviaQuestionParser.parseAndDisplayQuestion(QuestionFetcher.fetchTriviaQuestions());

    }
}
