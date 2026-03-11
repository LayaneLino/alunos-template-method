package org.alunostm.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/org/alunostm/hello-view.fxml")));
        primaryStage.setTitle("Sistema de Gestão de Alunos");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}