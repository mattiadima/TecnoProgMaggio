package com.example.demo.Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.Entity.fornitore;
import com.example.demo.Entity.utente;

public class FornitoreDao {
    private final String url = "jdbc:mysql://localhost:3306/terminal";
    private final String user = "root";
    private final String password = "";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void inserisci(String nome, String cognome, String password, String tel, String mail) {
        String sql = "INSERT INTO fornitore (nome, cognome, password, tel, mail) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, cognome);
            stmt.setString(3, password);
            stmt.setString(4, tel);
            stmt.setString(5, mail);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<fornitore> visualizza() {
        List<fornitore> lista = new ArrayList<>();
        String sql = "SELECT * FROM fornitore";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                fornitore f = new fornitore(
                    rs.getInt("ID"),
                    rs.getString("nome"),
                    rs.getString("cognome"),
                    rs.getString("mail"),
                    rs.getString("tel"),
                    rs.getString("password")
                );
                lista.add(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void cancella(int id) {
        String sql = "DELETE FROM fornitore WHERE ID = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public utente loginFornitore(String mail, String passwordInput) {
    String sql = "SELECT * FROM fornitore WHERE mail = ? AND password = ?";

    try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, mail);
        stmt.setString(2, passwordInput);

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return new utente(
                    rs.getInt("ID"),
                    rs.getString("mail"),
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
