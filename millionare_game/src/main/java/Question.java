
public class Question {
  private String questionText;
  private String[] options;
  private String correctAnswer;
  private String difficulty;

  public Question(String questionText, String[] options, String correctAnswer, String difficulty) {
    this.questionText = questionText;
    this.options = options;
    this.correctAnswer = correctAnswer;
    this.difficulty = difficulty;
  }

  public boolean checkAnswer(String userAnswer) {
    return userAnswer.equalsIgnoreCase(correctAnswer);
  }

  // Additional methods as needed
}