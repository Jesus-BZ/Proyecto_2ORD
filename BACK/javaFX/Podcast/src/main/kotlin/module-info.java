module org.example.podcast {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires java.sql;


    opens org.example.podcast to javafx.fxml;
    exports org.example.podcast;
}