module com {
    requires javafx.controls;
    requires javafx.fxml;


    opens com to javafx.fxml;
    exports com;
    exports com.sorts;
    opens com.sorts to javafx.fxml;
}