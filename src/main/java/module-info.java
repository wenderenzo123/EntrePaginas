module com.entrepaginas {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    exports com.entrepaginas.view to javafx.graphics;

    opens com.entrepaginas.view to javafx.fxml;
    opens com.entrepaginas.model to javafx.base;
    exports com.entrepaginas;
}
