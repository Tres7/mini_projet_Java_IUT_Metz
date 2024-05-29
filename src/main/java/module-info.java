module com.example.tp_note {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.tp_note to javafx.fxml;
    exports com.example.tp_note;
}