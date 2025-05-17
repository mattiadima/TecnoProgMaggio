package com.example.demo.Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.Entity.cliente;
import com.example.demo.Entity.utente;


public class ClienteDao {
    private final String url = "jdbc:mysql://localhost:3306/terminal";
    private final String user = "root";
    private final String password = "";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void inserisci(String nome, String cognome, String mail, String tel, String password, String indirizzo) {
        String sql = "INSERT INTO cliente (nome, cognome, mail, tel, password, indirizzo) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, cognome);
            stmt.setString(3, mail);
            stmt.setString(4, tel);
            stmt.setString(5, password);
            stmt.setString(6, indirizzo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<cliente> visualizza() {
        List<cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                cliente c = new cliente(
                    rs.getInt("ID"),
                    rs.getString("nome"),
                    rs.getString("cognome"),
                    rs.getString("mail"),
                    rs.getString("tel"),
                    rs.getString("password"),
                    rs.getString("indirizzo")
                );
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void cancella(int id) {
        String sql = "DELETE FROM cliente WHERE ID = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public utente loginCliente(String mail, String passwordInput) {
        String sql = "SELECT * FROM cliente WHERE mail = ? AND password = ?";
    
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, mail);
            stmt.setString(2, passwordInput);
    
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new utente(
                        rs.getInt("ID"),
                        rs.getString("mail"),
                        "cliente"
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return null; // Login fallito
    }
    
}
