package org.yesser.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.yesser.SystemInfo;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Principal.fxml"));

        try {
            BorderPane root = loader.load();
            Scene escenaPrincipal = new Scene(root);
            stage.setScene(escenaPrincipal);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        //var scene = new Scene(new StackPane(label), 640, 480);
        //stage.setScene(scene);
        //stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
