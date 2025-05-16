package com.example.demo.Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.Entity.ritiro;
import com.example.demo.Entity.autista;
import com.example.demo.Entity.camion;

public class RitiroDao {
    private final String url = "jdbc:mysql://localhost:3306/terminal";
    private final String user = "root";
    private final String password = "";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void inserisci(String targa, int autistaId, double peso, String data) {
        String sql = "INSERT INTO ritiro (targa, autista, peso, data) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, targa);
            stmt.setInt(2, autistaId);
            stmt.setDouble(3, peso);
            stmt.setString(4, data);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ritiro> visualizza() {
    List<ritiro> lista = new ArrayList<>();
    String sql = """
        SELECT 
            r.ID AS ritiro_id,
            r.peso,
            r.data,
            
            -- Autista
            a.ID AS autista_id,
            a.nome AS a_nome,
            a.username AS a_username,
            a.password AS a_password,

            -- Camion
            c.targa AS camion_targa,
            c.modello AS camion_modello

        FROM ritiro r
        JOIN autista a ON r.autista = a.ID
        JOIN camion c ON r.targa = c.targa
    """;

    try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {
            autista aut = new autista(
                rs.getInt("autista_id"),
                rs.getString("a_nome"),
                rs.getString("a_username"),
                rs.getString("a_password")
            );

            camion cam = new camion(
                rs.getString("camion_targa"),
                rs.getString("camion_modello")
            );

            ritiro r = new ritiro(
                rs.getInt("ritiro_id"),
                cam,
                aut,
                rs.getDouble("peso"),
                rs.getString("data")
            );

            lista.add(r);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
}


    public void cancella(int id) {
        String sql = "DELETE FROM ritiro WHERE ID = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
