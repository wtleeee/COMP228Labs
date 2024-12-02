package com.centennial.wingtunglee_comp228lab5;
import java.sql.*;

public class DatabaseConnection {
    private static final String URL = "jdbc:oracle:thin:@199.212.26.208:1521:SQLD";
    private static final String USER = "COMP228_F24_soh_17";
    private static final String PASSWORD = "lwt1011";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
