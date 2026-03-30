module org.alunostm {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.alunostm to javafx.fxml;
    opens org.alunostm.controller to javafx.fxml;
    exports org.alunostm;
}