module com.trabalholp.trabalholp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.google.gson;


    opens com.trabalholp.trabalholp to javafx.fxml;
    exports com.trabalholp.trabalholp;
}