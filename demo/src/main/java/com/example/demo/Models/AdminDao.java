package com.example.demo.Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.demo.Entity.utente;

public class AdminDao {

     private final String url = "jdbc:mysql://localhost:3306/terminal";
    private final String user = "root";
    private final String password = "";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    
    public utente loginAdmin(String nome, String passwordInput) {
    String sql = "SELECT * FROM admin WHERE nome = ? AND password = ?";

    try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, nome);
        stmt.setString(2, passwordInput);

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return new utente(
                    -1,
                    rs.getString("nome"),
                    rs.getString("password")
                );
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null; // Login fallito
}

}
