module ucr.laboratorio5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ucr.laboratorio5 to javafx.fxml;
    exports ucr.laboratorio5;
}