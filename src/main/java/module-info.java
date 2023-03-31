module com.entrepaginas {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.entrepaginas to javafx.fxml;
    exports com.entrepaginas;
}
