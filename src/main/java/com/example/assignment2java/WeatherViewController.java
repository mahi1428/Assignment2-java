package com.example.assignment2java;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class for managing the main weather view.
 * Handles user interactions and updates the UI based on weather data.
 */
public class WeatherViewController implements Initializable {

    /** The text field for entering the city name. */
    @FXML
    private TextField cityTextField;

    /** The button to initiate the weather search. */
    @FXML
    private Button searchButton;

    /** The button to switch to a different scene. */
    @FXML
    private Button switchButton;

    /** The label displaying the weather description. */
    @FXML
    private Label weatherLabel;

    /** The label displaying the temperature. */
    @FXML
    private Label tempLabel;

    /** The image view for displaying the weather icon. */
    @FXML
    private ImageView weatherIcon;

    /** The progress bar shown during data fetching. */
    @FXML
    private ProgressBar progressBar;

    /**
     * Handles the weather search when the "Search" button is clicked.
     * Fetches weather data based on the city name entered by the user and updates the UI.
     */
    @FXML
    private void searchWeather() {
        progressBar.setVisible(true);

        new Thread(() -> {
            // Fetch the weather data based on the city name entered by the user
            WeatherResponse weatherResponse = APIUtility.getWeather(cityTextField.getText());

            Platform.runLater(() -> {
                progressBar.setVisible(false);

                // Check if the response is valid and contains weather information
                if (weatherResponse != null && !weatherResponse.getWeather().isEmpty()) {
                    // Get the first weather condition from the response
                    Weather weather = weatherResponse.getWeather().get(0);

                    // Display the temperature and weather description on the labels
                    tempLabel.setText(String.format("%.2f°C", weatherResponse.getMain().getTemp()));
                    weatherLabel.setText(weather.getMain() + ": " + weather.getDescription());

                    // Load and display the corresponding weather icon
                    String iconUrl = "http://openweathermap.org/img/wn/" + weather.getIcon() + "@2x.png";
                    weatherIcon.setImage(new Image(iconUrl));
                } else {
                    // Handle cases where weather data is not found
                    weatherLabel.setText("Weather data not found.");
                    tempLabel.setText("");
                    weatherIcon.setImage(null);
                }
            });
        }).start();
    }

    /**
     * Switches to the second scene when the "Switch" button is clicked.
     *
     * @throws IOException If loading the FXML file fails.
     */
    @FXML
    private void switchScene() throws IOException {
        Stage stage = (Stage) switchButton.getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("second-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 500, 600);
        stage.setScene(scene);
    }

    /**
     * Initializes the controller. Sets the progress bar to be invisible initially.
     *
     * @param url The URL location of the FXML file.
     * @param resourceBundle The resources used to localize the root object.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        progressBar.setVisible(false);
    }
}
