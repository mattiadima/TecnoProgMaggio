package com.example.demo.Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.Entity.autista;

public class AutistaDao {
    private final String url = "jdbc:mysql://localhost:3306/terminal";
    private final String user = "root";
    private final String password = "";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void inserisci(String nome, String username, String password) {
        String sql = "INSERT INTO autista (nome, username, password) VALUES (?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, username);
            stmt.setString(3, password);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<autista> visualizza() {
        List<autista> lista = new ArrayList<>();
        String sql = "SELECT * FROM autista";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                autista a = new autista(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("username"),
                    rs.getString("password")
                );
                lista.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void cancella(int id) {
        String sql = "DELETE FROM autista WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

