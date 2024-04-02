import org.json.JSONObject;

import org.json.JSONArray;

import java.security.PublicKey;
import java.util.ArrayList;

public class App {
    public static boolean hasHint = true;
    public static int playerScore = 0;

    public static void removeHint(boolean a) {
        hasHint = a;
    }

    public static void addScore() {
        playerScore = playerScore + 1;
    }

    public static void playGame() {
        ArrayList<Object> settingsList = new ArrayList<>();
        settingsList = GameSettings.selectSettings();

        String difficulty = (String) settingsList.get(0);
        String type = (String) settingsList.get(1);
        // GameServer.startServer();

        boolean isCorrect;

        isCorrect = TriviaQuestionParser
                .parseAndDisplayQuestion(QuestionFetcher.fetchTriviaQuestions(difficulty, type));

        if (isCorrect == true) {
            addScore();
            System.out.println("Your score is " + playerScore);
            playGame();
        } else {
            System.out.println("you lose");
        }
    }

    public static void main(String[] args) throws Exception {
        playGame();

    }

}
