import java.util.Scanner;

import java.util.ArrayList;

public class GameSettings {

  int amount;
  String type;
  String difficulty;

  static String scannerTemplateS() {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    return input;
  }

  static void errorMessage() {
    System.out.println("Input unknown, using default setting");
  }

  static void displayChoices(String[] a) {
    String[] settingsArray = a;
    for (String settingsArra : settingsArray) {
      System.out.print(settingsArra + ", ");
    }
    System.out.println(" ");
  }

  static ArrayList<Object> selectSettings() {
    ArrayList<Object> settingsList = new ArrayList<>();

    int defaultSettings = 0;
    defaultSettings = defaultSettings();
    if (defaultSettings == 1) {
      System.out.println("Using default settings!");
      settingsList.add("any");
      settingsList.add("any");
    } else {
      System.out.println("Select setting; type the name or type the number");
      settingsList.add(selectDifficulty());
      settingsList.add(selectType());
    }
    return settingsList;

  }

  static int defaultSettings() {
    int defaultSettings = 0;
    System.out.println("Use default settings? Y/N");
    String input = scannerTemplateS();
    if (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("yes")) {
      defaultSettings = 1;
    } else if (input.equalsIgnoreCase("N") || input.equalsIgnoreCase("no")) {
      defaultSettings = 0;
    } else {
      errorMessage();
      defaultSettings = 1;
    }
    return defaultSettings;
  }

  static String selectDifficulty() {
    String[] difficulty = { "easy", "medium", "hard", "any" };
    System.out.println("Select difficulty");
    displayChoices(difficulty);
    String difficultyChoice;

    String input = scannerTemplateS();
    if (input.equalsIgnoreCase("easy") || input.equalsIgnoreCase("1")) {
      difficultyChoice = difficulty[0];
    } else if (input.equalsIgnoreCase("medium") || input.equalsIgnoreCase("2")) {
      difficultyChoice = difficulty[1];
    } else if (input.equalsIgnoreCase("hard") || input.equalsIgnoreCase("3")) {
      difficultyChoice = difficulty[2];
    } else if (input.equalsIgnoreCase("any") || input.equalsIgnoreCase("4")) {
      difficultyChoice = difficulty[3];
    } else {
      errorMessage();
      difficultyChoice = difficulty[3];
    }
    System.out.println("----------------------------------");
    return difficultyChoice;
  }

  static String selectType() {
    String[] type = { "multiple choice", "True/false", "any" };
    String typeChoice;
    System.out.println("Select question type");
    displayChoices(type);

    String input = scannerTemplateS();
    if (input.equalsIgnoreCase(type[0]) || input.equalsIgnoreCase("1")) {
      typeChoice = "multiple";
    } else if (input.equalsIgnoreCase(type[1]) || input.equalsIgnoreCase("2")) {
      typeChoice = "boolean";
    } else if (input.equalsIgnoreCase(type[2]) || input.equalsIgnoreCase("3")) {
      typeChoice = "any"; // don't include
    } else {
      errorMessage();
      typeChoice = "any";
    }
    System.out.println("----------------------------------");
    return typeChoice;
  }
}
