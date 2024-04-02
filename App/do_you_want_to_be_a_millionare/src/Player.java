public class Player {
  private int score = 0;

  private boolean[] lifelinesUsed = new boolean[3]; // Represents the lifelines; false means available

  public void useLifeline(int lifeline) {
    lifelinesUsed[lifeline] = true;
    // Lifeline logic here
  }

  public void updateScore(int value) {
    score += value;
  }
  // Additional methods as needed
}
