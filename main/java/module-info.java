module com.trabalholp.trabalholp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.trabalholp.trabalholp to javafx.fxml;
    exports com.trabalholp.trabalholp;
}