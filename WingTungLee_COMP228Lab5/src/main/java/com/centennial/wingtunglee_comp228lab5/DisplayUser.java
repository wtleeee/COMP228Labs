package com.centennial.wingtunglee_comp228lab5;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisplayUser {
    JFrame f;
    JTable j;

    // Constructor
    public DisplayUser(String playerId) {
        // Initialize JFrame
        f = new JFrame();
        f.setTitle("Display player record for id: " + playerId);
        // Fetch data from the database
        String[][] data = fetchPlayerData(playerId);
        // Define column names
        String[] columnNames = {"First Name", "Last Name", "Address", "Postal Code", "Province", "Phone Number", "Game Title", "Playing Date", "Score"};

        // Initialize the JTable
        j = new JTable(data, columnNames);
        j.setBounds(30, 40, 400, 300);

        // Add the table to JScrollPane
        JScrollPane sp = new JScrollPane(j);
        f.add(sp);

        f.setSize(800, 400);
        f.setVisible(true);
    }

    // Method to fetch player data
    private String[][] fetchPlayerData(String playerId) {
        String query = "SELECT p.first_name, p.last_name, p.address, p.postal_code, p.province, p.phone_number, g.game_title, pg.playing_date, pg.score FROM WingTung_Lee_player p JOIN WingTung_Lee_player_and_game pg ON p.player_id = pg.player_id JOIN WingTung_Lee_game g ON pg.game_id = g.game_id WHERE  p.player_id = ?";

        List<String[]> data = new ArrayList<>();

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, playerId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // setting the columns
                String[] row = new String[9];
                row[0] = rs.getString("first_name");
                row[1] = rs.getString("last_name");
                row[2] = rs.getString("address");
                row[3] = rs.getString("postal_code");
                row[4] = rs.getString("province");
                row[5] = rs.getString("phone_number");
                row[6] = rs.getString("game_title");
                row[7] = rs.getString("playing_date");
                row[8] = rs.getString("score");
                data.add(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error fetching data: " + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        }

        return data.toArray(new String[0][0]);
    }

    // Method to display the table
    public static void display(String playerId) {
        new DisplayUser(playerId);
    }
}