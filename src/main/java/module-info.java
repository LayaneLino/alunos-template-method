module org.alunostm {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.alunostm.view to javafx.fxml;
    opens org.alunostm.controller to javafx.fxml;
    exports org.alunostm.view;
}