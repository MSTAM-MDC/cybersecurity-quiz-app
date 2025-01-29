package models;

public class Question {
    private String questionText;  // The text of the question
    private String[] potentialAnswers;  // Array of possible answers
    private String correctAnswer;  // The correct answer

    /**
     * Constructor for the Question class.
     *
     * @param questionText     The text of the question
     * @param potentialAnswers An array of potential answers
     * @param correctAnswer    The correct answer
     */
    public Question(String questionText, String[] potentialAnswers, String correctAnswer) {
        this.questionText = questionText;
        this.potentialAnswers = potentialAnswers;
        this.correctAnswer = correctAnswer;
    }

    // Getters and Setters
    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String[] getPotentialAnswers() {
        return potentialAnswers;
    }

    public void setPotentialAnswers(String[] potentialAnswers) {
        this.potentialAnswers = potentialAnswers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    /**
     * Returns the potential answers as a single comma-separated string.
     *
     * @return A string representation of the potential answers
     */
    public String getPotentialAnswersAsString() {
        return String.join(", ", potentialAnswers);
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionText='" + questionText + '\'' +
                ", potentialAnswers=" + getPotentialAnswersAsString() +
                ", correctAnswer='" + correctAnswer + '\'' +
                '}';
    }
}