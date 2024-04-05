
import java.util.ArrayList;

public class App {
    public static String difficulty;
    public static String type;
    public static boolean playingGame;
    public static boolean hasHint_50_50 = true;
    public static boolean hashint_call_friend = true;
    public static boolean hashint_ask_audience = true;
    public static int playerScore = 0;

    public static void set_difficulty(String a) {
        difficulty = a;
    }

    public static void set_type(String a) {
        type = a;
    }

    public static void playingGameB(boolean a) {
        playingGame = a;
    }

    public static void removeHint_50_50(boolean a) {
        hasHint_50_50 = a;
    }

    public static void removeHint_call_friend(boolean a) {
        hashint_call_friend = a;
    }

    public static void removeHint_ask_audience(boolean a) {
        hashint_ask_audience = a;
    }

    public static void addScore() {
        playerScore = playerScore + 1;
    }

    public static void gameSetUp() {
        ArrayList<Object> settingsList = new ArrayList<>();
        settingsList = GameSettings.selectSettings();

        set_difficulty((String) settingsList.get(0));
        set_type((String) settingsList.get(1));

    }

    public static void playGame() {
        // GameServer.startServer();

        boolean isCorrect;

        isCorrect = TriviaQuestionParser
                .parseAndDisplayQuestion(QuestionFetcher.fetchTriviaQuestions(difficulty, type));

        if (isCorrect == true) {
            addScore();
            if (playingGame == true) {
                System.out.println("Correct! Your score is " + playerScore);
                playGame();
            }
            if (playingGame == false) {
                System.out.println("Correct!");
                System.exit(0);
            }

        } else {
            System.out.println("you lose");
            System.exit(0);
        }
    }

    public static void main(String[] args) throws Exception {
        gameSetUp();
        playGame();

    }

}
