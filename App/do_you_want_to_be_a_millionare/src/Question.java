
import java.util.Scanner;

public class Question {
  private String questionText;
  private String[] options;
  private String correctAnswer;
  private String difficulty;

  public Question(String questionText, String[] a, String correctAnswer, String difficulty) {
    this.questionText = questionText;
    this.correctAnswer = correctAnswer;
    this.difficulty = difficulty;

  }

  static boolean questionF(String questionText, String[] a, String correctAnswer, String difficulty) {
    String[] options = a;
    boolean isCorrect;

    System.out.println("Question difficulty: " + difficulty);
    if ((App.hasHint_50_50 == true) || (App.hashint_call_friend == true)) {
      System.out.println("Get help for 4 answer questions!");
    }
    if (App.hasHint_50_50 == true) {
      System.out.println("Type '50/50' to remove half the answers!");
    }
    if (App.hashint_call_friend == true) {
      System.out.println("Type 'call friend' and hope he knows!");
    }
    if (App.hashint_ask_audience == true) {
      System.out.println("Type 'ask audience' and hope they agree!");
    }

    for (int i = 0; i < options.length; i++) {
      int randomIndex = (int) (Math.random() * options.length);
      String temp = options[i];
      options[i] = options[randomIndex];
      options[randomIndex] = temp;
    }

    for (String option : options) {
      System.out.print(option + ", ");
    }

    System.out.println();
    System.out.println("-------------------------------");

    isCorrect = checkAns(a, correctAnswer);

    return isCorrect;

  }

  static boolean checkAns(String[] a, String correctAnswer) {
    boolean isCorrect = false;
    System.out.println("Input answer");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();

    if (input.equalsIgnoreCase(correctAnswer) || input.equals(a[0])) {
      isCorrect = true;
    } else if (input.equals(a[1])) {
      isCorrect = false;
    } else if (a.length > 2 && (input.equals(a[2]) || input.equals(a[3]))) {
      isCorrect = false;
    } else if ((a.length > 2) && (App.hasHint_50_50 == true) && (input.equalsIgnoreCase("50/50"))) {
      Half_and_half_lifeLine.fiftyFifty(a);
      App.removeHint_50_50(false);
      return checkAns(a, correctAnswer);
    } else if ((a.length > 2) && (App.hashint_call_friend == true) && (input.equalsIgnoreCase("call friend"))) {
      Phone_a_friend_lifeLine.Phone_a_friend(a);
      App.removeHint_call_friend(false);
      return checkAns(a, correctAnswer);
    } else if ((a.length > 2) && (App.hashint_ask_audience == true) && (input.equalsIgnoreCase("ask audience"))) {
      Ask_audience_lifeLine.ask_crowd(a);
      App.removeHint_ask_audience(false);
      return checkAns(a, correctAnswer);
    } else {
      System.out.println("Input not understood, try again!");
      return checkAns(a, correctAnswer);
    }

    return isCorrect;
  }

  // Additional methods as needed
}
