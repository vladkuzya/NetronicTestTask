package com.netronic;

import com.netronic.controller.AbstractController;
import com.netronic.util.SpringFxmlLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        AbstractController controller =
                (AbstractController) SpringFxmlLoader.load("/listAllUsers.fxml");
        Scene scene = new Scene((Parent) controller.getView(), 600, 400);
        primaryStage.setTitle("Netronic");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
