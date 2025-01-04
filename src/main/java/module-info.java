module com.example.firstprogram_snakeandladder {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.firstprogram_snakeandladder to javafx.fxml;
    exports com.example.firstprogram_snakeandladder;
}