package database;

import models.Question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuizDatabase {

    /**
     * Fetches all quiz questions from the database.
     *
     * @return A list of Question objects
     */
    public static List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();
        String query = "SELECT question_text, potential_answers, correct_answer FROM questions";

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String questionText = resultSet.getString("question_text");
                String potentialAnswers = resultSet.getString("potential_answers");
                String correctAnswer = resultSet.getString("correct_answer");

                // Convert potential answers into an array
                String[] answersArray = potentialAnswers.split(",");

                // Create a Question object and add it to the list
                questions.add(new Question(questionText, answersArray, correctAnswer));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching questions: " + e.getMessage());
        }

        return questions;
    }

    /**
     * Inserts a new question into the database.
     *
     * @param questionText     The text of the question
     * @param potentialAnswers The potential answers (comma-separated)
     * @param correctAnswer    The correct answer
     */
    public static void insertQuestion(String questionText, String potentialAnswers, String correctAnswer) {
        String query = "INSERT INTO questions (question_text, potential_answers, correct_answer) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, questionText);
            preparedStatement.setString(2, potentialAnswers);
            preparedStatement.setString(3, correctAnswer);

            preparedStatement.executeUpdate();
            System.out.println("Question inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting question: " + e.getMessage());
        }
    }
}
