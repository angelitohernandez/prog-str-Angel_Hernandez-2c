module com.example.demopruebapractica {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demopruebapractica to javafx.fxml;
    exports com.example.demopruebapractica;
}