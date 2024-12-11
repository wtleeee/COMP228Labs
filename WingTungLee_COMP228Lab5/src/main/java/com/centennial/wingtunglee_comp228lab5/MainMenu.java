package com.centennial.wingtunglee_comp228lab5;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenu extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //set title for the stage
        stage.setTitle("Game Main Menu");
        //page content
        Label label = new Label("Welcome to the game!");
        Button createUserButton = new Button("Create New User");
        Button updateUserButton = new Button("Update Existing User");
        //create a textfield to input the player id
        Label gameTitleLabel = new Label("Display player with id:");
        TextField playerIdField = new TextField();

        Button displayUsersButton = new Button("Display");
        //set the button actions
        createUserButton.setOnAction(e -> CreateUser.display());
        updateUserButton.setOnAction(e -> UpdateUser.display());
        displayUsersButton.setOnAction(e -> {
                    String playerId = playerIdField.getText();
                    if (playerId != null && !playerId.isEmpty()) {
                        DisplayUser.display(playerId);
                    } else {
                        System.out.println("Player ID is required.");
                    }
                });
        //create a VBox
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);

        //add to the VBox
        vbox.getChildren().addAll(label, createUserButton, updateUserButton, gameTitleLabel, playerIdField, displayUsersButton);        //create a scene
        Scene scene = new Scene(vbox, 500, 300);
        //set the scene for the stage
        stage.setScene(scene);
        //show the stage
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
