package org.example.mitchell_csc311_module6hw;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This application takes in user information,
 * checks the given information against regular expression patterns,
 * then allows the information to be displayed back to the user if all the information is valid.
 *
 * @author Jared Mitchell
 */
public class FormApplication extends Application {
    public static Form display;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FormApplication.class.getResource("formFiller-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 800);
        stage.setTitle("Fill out this form");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}