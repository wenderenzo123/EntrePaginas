module com.entrepaginas {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    exports com.entrepaginas.view to javafx.graphics;

    opens com.entrepaginas to javafx.fxml;
    exports com.entrepaginas;
}
