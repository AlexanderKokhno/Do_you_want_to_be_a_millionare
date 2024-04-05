import java.util.Random;

public class Ask_audience_lifeLine {
  static void ask_crowd(String[] a) {
    int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    Random random = new Random();
    int randomIndex = random.nextInt(numbers.length);
    int randomNumber = numbers[randomIndex];
    if (randomNumber < 4) {
      System.out.println(a[0] + " is the answer");
    }
    if ((randomNumber <= 5) && (randomNumber > 3)) {
      System.out.println(a[1] + " is wrong");
    }
    if ((randomNumber <= 8) && (randomNumber > 5)) {
      System.out.println("*Unintelligible*");
    }
    if ((randomNumber <= 10) && (randomNumber > 8)) {
      System.out.println(a[0] + "    .... no! Its " + a[3] + "! *Unintelligible*");
    }
    System.out.println("You cannot use this hint anymore!");
  }
}
