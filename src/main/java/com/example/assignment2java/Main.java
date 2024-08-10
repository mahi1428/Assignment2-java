package com.example.assignment2java;

// Import necessary JavaFX classes
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The main class for the JavaFX Weather Application.
 * Extends {@link Application} to create a JavaFX application with a primary stage.
 */
public class Main extends Application {

    /**
     * The entry point for JavaFX applications. This method is called by the JavaFX runtime to
     * initialize the application and display the main window.
     *
     * @param stage The primary stage for this application, onto which the application scene will be set.
     * @throws IOException If the FXML file cannot be loaded.
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Load the FXML file for the primary view of the application
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("weather-view.fxml"));

        // Create a scene with the loaded FXML and set its dimensions
        Scene scene = new Scene(fxmlLoader.load(), 500, 600);

        // Set the title of the application window
        stage.setTitle("Weather App");

        // Set the scene on the stage (window)
        stage.setScene(scene);

        // Display the stage
        stage.show();
    }


    public static void main(String[] args) {
        // Launch the JavaFX application
        launch();
    }
}
