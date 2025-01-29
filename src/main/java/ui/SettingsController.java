package ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SettingsController {

    public void showSettings(Stage primaryStage) {
        VBox layout = new VBox(20);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Label textSizeLabel = new Label("Adjust Text Size:");
        Slider textSizeSlider = new Slider(12, 30, 18);
        textSizeSlider.setShowTickMarks(true);
        textSizeSlider.setShowTickLabels(true);

        // Apply Button
        Button applyButton = new Button("Apply");
        applyButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-padding: 10 20;");
        applyButton.setOnAction(e -> {
            primaryStage.getScene().getRoot().setStyle("-fx-font-size: " + textSizeSlider.getValue() + "px;");
        });

        // Back Button
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> new QuizApp().start(primaryStage));

        layout.getChildren().addAll(textSizeLabel, textSizeSlider, applyButton, backButton);

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
    }
}
