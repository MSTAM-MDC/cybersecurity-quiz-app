package ui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ResultsController {

    public void showResults(Stage primaryStage, int score, int totalQuestions) {
        VBox layout = new VBox(20);
        layout.setStyle("-fx-padding: 20;");
        layout.setAlignment(Pos.CENTER);

        Label resultsLabel = new Label("Quiz Completed!");
        resultsLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Label scoreLabel = new Label("Your score: " + score + " / " + totalQuestions);
        scoreLabel.setStyle("-fx-font-size: 18px;");

        // Replay Button
        Button replayButton = new Button("Replay Quiz");
        replayButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-padding: 10 20;");
        replayButton.setOnAction(e -> {
            QuizApp quizApp = new QuizApp();
            try {
                quizApp.start(primaryStage);  // Restart the quiz
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Exit Button
        Button exitButton = new Button("Exit");
        exitButton.setStyle("-fx-background-color: #D32F2F; -fx-text-fill: white; -fx-padding: 10 20;");
        exitButton.setOnAction(e -> primaryStage.close());

        layout.getChildren().addAll(resultsLabel, scoreLabel, replayButton, exitButton);

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
    }
}