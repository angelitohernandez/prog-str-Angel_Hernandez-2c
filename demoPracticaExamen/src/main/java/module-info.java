module com.example.demopracticaexamen {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demopracticaexamen to javafx.fxml;
    exports com.example.demopracticaexamen;
}