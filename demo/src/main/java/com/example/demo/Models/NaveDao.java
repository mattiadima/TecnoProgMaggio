package com.example.demo.Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.Entity.nave;

public class NaveDao {
    private final String url = "jdbc:mysql://localhost:3306/terminal";
    private final String user = "root";
    private final String password = "";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void inserisci(String nome, String tipo) {
        String sql = "INSERT INTO nave (nome, tipo) VALUES (?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, tipo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<nave> visualizza() {
        List<nave> lista = new ArrayList<>();
        String sql = "SELECT * FROM nave";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                nave n = new nave(
                    rs.getInt("ID"),
                    rs.getString("nome"),
                    rs.getString("tipo")
                );
                lista.add(n);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void cancella(int id) {
        String sql = "DELETE FROM nave WHERE ID = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
