package com.example.wingtunglee_comp228lab4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml")); //getting the fxml file
        GridPane root = fxmlLoader.load(); //loading the fxml file into a gridpane
        Scene scene = new Scene(root, 1100, 500); //create the scene

        stage.setTitle("Student Information");
        stage.setScene(scene); //set the scene to the stage
        stage.show();
    }

    public static void main(String[] args) {
        launch();//calling the start method to run the application
    }
}