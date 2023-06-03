module gestor.eventos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.base;
    requires javafx.graphics;
    requires java.base;

    opens gestor.eventos to javafx.fxml;
    exports gestor.eventos;
}
