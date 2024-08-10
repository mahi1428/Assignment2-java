module com.example.assignment2java {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;

    opens com.example.assignment2java to javafx.fxml, com.google.gson;
    exports com.example.assignment2java;
}
