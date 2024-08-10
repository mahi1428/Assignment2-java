package com.example.assignment2java;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.scene.control.Button;

/**
 * Controller class for managing the second view of the JavaFX application.
 * Handles navigation back to the primary weather view.
 */
public class SecondViewController {

    /** Button used to navigate back to the primary weather view. */
    @FXML
    private Button backButton;

    /**
     * Handles the action to navigate back to the primary weather view when the back button is clicked.
     *
     * @throws IOException If the FXML file for the primary view cannot be loaded.
     */
    @FXML
    private void goBack() throws IOException {
        // Get the current stage from the back button's scene
        Stage stage = (Stage) backButton.getScene().getWindow();

        // Load the FXML file for the primary view (weather-view.fxml)
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("weather-view.fxml"));

        // Create a new scene with the loaded FXML content and set its dimensions
        Scene scene = new Scene(fxmlLoader.load(), 500, 600);

        // Set the new scene on the stage (window)
        stage.setScene(scene);
}
}