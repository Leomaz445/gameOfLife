module com.example.conway {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.conway to javafx.fxml;
    exports com.example.conway;
}