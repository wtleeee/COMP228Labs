package com.centennial.wingtunglee_comp228lab5;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UpdateUser {
    public static void display() {
        //create a new stage
        Stage stage = new Stage();
        stage.setTitle("Update User");

        //create a Gridpane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        //Page content
        Label idLabel = new Label("Player ID To be updated:");
        grid.add(idLabel, 0, 0);
        TextField idField = new TextField();
        grid.add(idField, 1, 0);

        Text titleText = new Text("Update Information:");
        grid.add(titleText, 0, 1, 3, 1);

        Label nameLabel = new Label("Name:");
        grid.add(nameLabel, 0, 2);
        TextField firstNameField = new TextField();
        firstNameField.setPromptText("First name");
        grid.add(firstNameField, 1, 2);
        TextField lastNameField = new TextField();
        lastNameField.setPromptText("Last name");
        grid.add(lastNameField, 2, 2);

        Label addressLabel = new Label("Address:");
        grid.add(addressLabel, 0, 3);
        TextField addressField = new TextField();
        grid.add(addressField, 1, 3);

        Label postalCodeLabel = new Label("Postal Code:");
        grid.add(postalCodeLabel, 0, 4);
        TextField postalCodeField = new TextField();
        grid.add(postalCodeField, 1, 4);

        Label provinceLabel = new Label("Province:");
        grid.add(provinceLabel, 0, 5);
        TextField provinceField = new TextField();
        grid.add(provinceField, 1, 5);

        Label phoneNumberLabel = new Label("Phone Number:");
        grid.add(phoneNumberLabel, 0, 6);
        TextField phoneNumberField = new TextField();
        grid.add(phoneNumberField, 1, 6);

        //create a button to update information
        Button updateButton = new Button("Update");
        grid.add(updateButton, 0, 7);

        //set the button action
        updateButton.setOnAction(e -> {
            int playerId = Integer.parseInt(idField.getText());
            ;
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String address = addressField.getText();
            String postalCode = postalCodeField.getText();
            String province = provinceField.getText();
            String phoneNumber = phoneNumberField.getText();

            updateProfile(playerId, firstName, lastName, address, postalCode, province, phoneNumber);
        });

        //create a scene
        Scene scene = new Scene(grid, 800, 600);
        stage.setScene(scene);
        //show the stage
        stage.show();
    }

    //method to update player profile
    public static void updateProfile(int playerId, String firstName, String lastName, String address, String postalCode, String province, String phoneNumber) {
        try (Connection conn = DatabaseConnection.connect()) {
            List<String> updateFields = new ArrayList<>();
            List<Object> updateValues = new ArrayList<>();

            if (firstName != null && !firstName.isEmpty()) {
                updateFields.add("first_name = ?");
                updateValues.add(firstName);
            }
            if (lastName != null && !lastName.isEmpty()) {
                updateFields.add("last_name = ?");
                updateValues.add(lastName);
            }
            if (address != null && !address.isEmpty()) {
                updateFields.add("address = ?");
                updateValues.add(address);
            }
            if (postalCode != null && !postalCode.isEmpty()) {
                updateFields.add("postal_code = ?");
                updateValues.add(postalCode);
            }
            if (province != null && !province.isEmpty()) {
                updateFields.add("province = ?");
                updateValues.add(province);
            }
            if (phoneNumber != null && !phoneNumber.isEmpty()) {
                updateFields.add("phone_number = ?");
                updateValues.add(phoneNumber);
            }

            // update query string
            String updatePlayerQuery = "UPDATE WingTung_Lee_player SET " + String.join(", ", updateFields) + " WHERE player_id = ?";

            //set the prepared statement parameters
            try (PreparedStatement pstmt = conn.prepareStatement(updatePlayerQuery)) {
                for (int i = 0; i < updateValues.size(); i++) {
                    pstmt.setObject(i + 1, updateValues.get(i));
                }
                pstmt.setInt(updateValues.size() + 1, playerId);

                // Execute the update
                int rowsUpdated = pstmt.executeUpdate();
                System.out.println(rowsUpdated > 0 ? "Data updated successfully." : "No row found with the specified ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating data: " + e.getMessage());
        }
    }
}