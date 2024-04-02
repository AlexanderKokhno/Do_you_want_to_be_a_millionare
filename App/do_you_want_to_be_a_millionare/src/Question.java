
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
    boolean hint = true;

    System.out.println("Question difficulty: " + difficulty);
    if (hint == true) {
      System.out.println("Type 50/50 to remove half the answers!");
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
    } else if ((a.length > 2) && (App.hasHint == true) && (input.equalsIgnoreCase("50/50"))) {
      Half_and_half_lifeLine.fiftyFifty(a);
      App.removeHint(false);
      return checkAns(a, correctAnswer);
    } else {
      System.out.println("Answer not understood, try again!");
      return checkAns(a, correctAnswer);
    }

    return isCorrect;
  }

  // Additional methods as needed
}
