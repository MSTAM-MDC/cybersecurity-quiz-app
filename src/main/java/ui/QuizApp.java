package ui;

import database.QuizDatabase;
import models.Question;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class QuizApp extends Application {

    private int currentQuestionIndex = 0;  // Track the current question
    private int score = 0;  // Track the user's score
    private List<Question> questions;  // List of quiz questions

    @Override
    public void start(Stage primaryStage) {
        // Load questions from the database
        questions = QuizDatabase.getQuestions();

        // Check if there are any questions
        if (questions.isEmpty()) {
            System.out.println("No questions found in the database.");
            return;
        }

        // Initialize the UI
        VBox layout = new VBox(20); // 20px spacing between components
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");

        // Question Label (with text wrapping)
        Label questionLabel = new Label();
        questionLabel.setWrapText(true); // Allow text wrapping
        questionLabel.setMaxWidth(550); // Limit the width for readability
        questionLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: #333333;"); // Font size and color

        // Options (Radio Buttons)
        ToggleGroup optionsGroup = new ToggleGroup(); // Group for radio buttons
        RadioButton option1 = new RadioButton();
        RadioButton option2 = new RadioButton();
        RadioButton option3 = new RadioButton();
        option1.setToggleGroup(optionsGroup);
        option2.setToggleGroup(optionsGroup);
        option3.setToggleGroup(optionsGroup);

        // Buttons and Layout for Options
        VBox optionsBox = new VBox(10); // Spacing between options
        optionsBox.getChildren().addAll(option1, option2, option3);

        // Submit Button
        Button submitButton = new Button("Submit");
        submitButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10 20;");
        submitButton.setOnAction(e -> {
            RadioButton selectedOption = (RadioButton) optionsGroup.getSelectedToggle();
            if (selectedOption != null) {
                checkAnswer(selectedOption.getText(), primaryStage, questionLabel, option1, option2, option3);
            }
        });

        // Add all elements to the layout
        layout.getChildren().addAll(questionLabel, optionsBox, submitButton);

        // Display the first question
        displayQuestion(questionLabel, option1, option2, option3);

        // Create the scene and display it
        Scene scene = new Scene(layout, 600, 400);
        primaryStage.setTitle("Cybersecurity Quiz App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Displays the current question and updates the UI components.
     *
     * @param questionLabel The label displaying the question
     * @param option1       The first radio button for answers
     * @param option2       The second radio button for answers
     * @param option3       The third radio button for answers
     */
    private void displayQuestion(Label questionLabel, RadioButton option1, RadioButton option2, RadioButton option3) {
        Question currentQuestion = questions.get(currentQuestionIndex);
        questionLabel.setText(currentQuestion.getQuestionText()); // Set the question text
        String[] options = currentQuestion.getPotentialAnswers(); // Get potential answers
        option1.setText(options[0]);
        option2.setText(options[1]);
        option3.setText(options[2]);
    }

    /**
     * Checks if the selected answer is correct and proceeds to the next question.
     *
     * @param selectedAnswer The answer selected by the user
     * @param primaryStage   The primary stage
     * @param questionLabel  The label displaying the question
     * @param option1        The first radio button
     * @param option2        The second radio button
     * @param option3        The third radio button
     */
    private void checkAnswer(String selectedAnswer, Stage primaryStage, Label questionLabel, RadioButton option1, RadioButton option2, RadioButton option3) {
        Question currentQuestion = questions.get(currentQuestionIndex);
        if (selectedAnswer.equals(currentQuestion.getCorrectAnswer())) {
            score++;
        }

        currentQuestionIndex++;
        if (currentQuestionIndex < questions.size()) {
            displayQuestion(questionLabel, option1, option2, option3);
        } else {
            showResults(primaryStage);
        }
    }

    /**
     * Displays the results screen at the end of the quiz.
     *
     * @param primaryStage The primary stage
     */
    private void showResults(Stage primaryStage) {
        ResultsController resultsController = new ResultsController();
        resultsController.showResults(primaryStage, score, questions.size());
    }

    public static void main(String[] args) {
        launch(args);
    }
}

