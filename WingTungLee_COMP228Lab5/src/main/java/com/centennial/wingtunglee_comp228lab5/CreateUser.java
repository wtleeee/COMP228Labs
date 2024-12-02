package com.centennial.wingtunglee_comp228lab5;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.*;
import java.time.LocalDate;

public class CreateUser {
    public static void display() {
        //create a new stage
        Stage stage = new Stage();
        stage.setTitle("Create New User");

        //create a Gridpane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        //Page content
        //Player Information
        Text titleText = new Text("Player Information:");
        grid.add(titleText, 0, 0, 3, 1);

        Label nameLabel = new Label("Name:");
        grid.add(nameLabel, 0, 1);
        TextField firstNameField = new TextField();
        firstNameField.setPromptText("First name");
        grid.add(firstNameField, 1, 1);
        TextField lastNameField = new TextField();
        lastNameField.setPromptText("Last name");
        grid.add(lastNameField, 2, 1);

        Label addressLabel = new Label("Address:");
        grid.add(addressLabel, 0, 2);
        TextField addressField = new TextField();
        grid.add(addressField, 1, 2);

        Label postalCodeLabel = new Label("Postal Code:");
        grid.add(postalCodeLabel, 0, 3);
        TextField postalCodeField = new TextField();
        grid.add(postalCodeField, 1, 3);

        Label provinceLabel = new Label("Province:");
        grid.add(provinceLabel, 0, 4);
        TextField provinceField = new TextField();
        grid.add(provinceField, 1, 4);

        Label phoneNumberLabel = new Label("Phone Number:");
        grid.add(phoneNumberLabel, 0, 5);
        TextField phoneNumberField = new TextField();
        grid.add(phoneNumberField, 1, 5);

        //Game Information
        Text gameText = new Text("Game Information:");
        grid.add(gameText, 0, 7, 3, 1);

        Label gameTitleLabel = new Label("Game Title:");
        grid.add(gameTitleLabel, 0, 8);
        TextField gameTitleField = new TextField();
        grid.add(gameTitleField, 1, 8);

        Label playingDateLabel = new Label("Playing Date:");
        grid.add(playingDateLabel, 0, 9);
        DatePicker playingDateField = new DatePicker();
        grid.add(playingDateField, 1, 9);

        Label gameScoreLabel = new Label("Game Score:");
        grid.add(gameScoreLabel, 0, 10);
        TextField gameScoreField = new TextField();
        grid.add(gameScoreField, 1, 10);

        //create a button to submit the form
        Button submitButton = new Button("Submit");
        grid.add(submitButton, 0, 11);

        //set the button action
        submitButton.setOnAction(e -> {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String address = addressField.getText();
            String postalCode = postalCodeField.getText();
            String province = provinceField.getText();
            String phoneNumber = phoneNumberField.getText();
            String gameTitle = gameTitleField.getText();
            LocalDate playingDate = playingDateField.getValue();
            int gameScore = Integer.parseInt(gameScoreField.getText());;

            addProfile(firstName, lastName, address, postalCode, province, phoneNumber, gameTitle, playingDate, gameScore);
        });
        //create a scene
        Scene scene = new Scene(grid, 800, 600);
        stage.setScene(scene);
        //show the stage
        stage.show();
    }

    //method to add a new player and game profile to the database
    public static void addProfile(String firstName, String lastName, String address, String postalCode, String province, String phoneNumber, String gameTitle, LocalDate playingDate, int gameScore) {
        try{
            Connection conn = DatabaseConnection.connect();

            // 1. Insert Player
            String insertPlayerQuery = "INSERT INTO WingTung_Lee_player (first_name, last_name, address, postal_code, province, phone_number) VALUES ( ?, ?, ?, ?, ?, ?)";
            String getPlayerIdQuery = "SELECT WingTung_Lee_player_seq.CURRVAL FROM DUAL";
            PreparedStatement pstmtPlayer = conn.prepareStatement(insertPlayerQuery);
            pstmtPlayer.setString(1, firstName);
            pstmtPlayer.setString(2, lastName);
            pstmtPlayer.setString(3, address);
            pstmtPlayer.setString(4, postalCode);
            pstmtPlayer.setString(5, province);
            pstmtPlayer.setString(6, phoneNumber);
            pstmtPlayer.executeUpdate();

            // Get the playerId
            int playerId = 0;
            PreparedStatement pstmtGetPlayerId = conn.prepareStatement(getPlayerIdQuery);
            ResultSet rsPlayer = pstmtGetPlayerId.executeQuery();
            if (rsPlayer.next()) {
                playerId = rsPlayer.getInt(1);
            } else {
                throw new SQLException("Failed to retrieve Player ID.");
            }
            System.out.println("Player information added successfully.");

            // 2. Insert Game
            String insertGameQuery = "INSERT INTO WingTung_Lee_game (game_title) VALUES (?)";
            String getGameIdQuery = "SELECT WingTung_Lee_game_seq.CURRVAL FROM DUAL";

            PreparedStatement pstmtGame = conn.prepareStatement(insertGameQuery);
            pstmtGame.setString(1, gameTitle);
            pstmtGame.executeUpdate();

            // Get the gameId
            int gameId = 0;
            PreparedStatement pstmtGetGameId = conn.prepareStatement(getGameIdQuery);
            ResultSet rsGame = pstmtGetGameId.executeQuery();
            if (rsGame.next()) {
                gameId = rsGame.getInt(1);
            } else {
                throw new SQLException("Failed to retrieve Game ID.");
            }
            System.out.println("Game information added successfully.");

            // 3. Insert Player and Game Relationship
            String insertPlayerGameQuery = "INSERT INTO WingTung_Lee_player_and_game (player_id, game_id, playing_date, score) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmtPlayerGame = conn.prepareStatement(insertPlayerGameQuery);
            pstmtPlayerGame.setInt(1, playerId);
            pstmtPlayerGame.setInt(2, gameId);
            pstmtPlayerGame.setDate(3, java.sql.Date.valueOf(playingDate));
            pstmtPlayerGame.setInt(4, gameScore);
            pstmtPlayerGame.executeUpdate();
            System.out.println("Player and game information added successfully.");

            conn.close(); // Close the connection
        } catch (SQLException e) {
            System.out.println("Error adding data: " + e.getMessage());
        }
    }
}
