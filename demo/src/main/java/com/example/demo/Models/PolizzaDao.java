package com.example.demo.Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.Entity.polizza;
import com.example.demo.Entity.porto;
import com.example.demo.Entity.viaggio;
import com.example.demo.Entity.cliente;
import com.example.demo.Entity.fornitore;
import com.example.demo.Entity.nave;

public class PolizzaDao {
    private final String url = "jdbc:mysql://localhost:3306/terminal";
    private final String user = "root";
    private final String password = "";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void inserisci(int viaggioId, double peso, String data, String merce, int clienteId) {
        String sql = "INSERT INTO polizza (viaggio, peso, data, merce, cliente) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, viaggioId);
            stmt.setDouble(2, peso);
            stmt.setString(3, data);
            stmt.setString(4, merce);
            stmt.setInt(5, clienteId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<polizza> visualizza() {
        List<polizza> lista = new ArrayList<>();

        String sql = """
            SELECT 
                p.ID AS polizza_id,
                p.peso,
                p.data,
                p.merce,

                v.ID AS viaggio_id,
                v.data_arrivo,
                v.data_partenza,
                f.ID AS fornitore_id, f.nome AS f_nome, f.cognome AS f_cognome, f.mail AS f_mail, f.tel AS f_tel, f.password AS f_password,
                pp.ID AS partenza_id, pp.nome AS pp_nome, pp.rotta AS pp_rotta, pp.nazione AS pp_nazione,
                pa.ID AS arrivo_id, pa.nome AS pa_nome, pa.rotta AS pa_rotta, pa.nazione AS pa_nazione,
                n.ID AS nave_id, n.nome AS n_nome, n.tipo AS n_tipo,

                c.ID AS cliente_id, c.nome AS c_nome, c.cognome AS c_cognome, c.mail AS c_mail, c.tel AS c_tel, c.password AS c_password, c.indirizzo AS c_indirizzo

            FROM polizza p
            JOIN viaggio v ON p.viaggio = v.ID
            JOIN fornitore f ON v.fornitore = f.ID
            JOIN porto pp ON v.porto_partenza = pp.ID
            JOIN porto pa ON v.porto_arrivo = pa.ID
            JOIN nave n ON v.nave = n.ID
            JOIN cliente c ON p.cliente = c.ID
        """;

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                // fornitore
                fornitore f = new fornitore(
                    rs.getInt("fornitore_id"),
                    rs.getString("f_nome"),
                    rs.getString("f_cognome"),
                    rs.getString("f_mail"),
                    rs.getString("f_tel"),
                    rs.getString("f_password")
                );

                // porti
                porto partenza = new porto(
                    rs.getInt("partenza_id"),
                    rs.getString("pp_nome"),
                    rs.getString("pp_rotta"),
                    rs.getString("pp_nazione")
                );

                porto arrivo = new porto(
                    rs.getInt("arrivo_id"),
                    rs.getString("pa_nome"),
                    rs.getString("pa_rotta"),
                    rs.getString("pa_nazione")
                );

                // nave
                nave n = new nave(
                    rs.getInt("nave_id"),
                    rs.getString("n_nome"),
                    rs.getString("n_tipo")
                );

                // viaggio
                viaggio v = new viaggio(
                    rs.getInt("viaggio_id"),
                    f,
                    rs.getString("data_arrivo"),
                    rs.getString("data_partenza"),
                    partenza,
                    arrivo,
                    n
                );

                // cliente
                cliente c = new cliente(
                    rs.getInt("cliente_id"),
                    rs.getString("c_nome"),
                    rs.getString("c_cognome"),
                    rs.getString("c_mail"),
                    rs.getString("c_tel"),
                    rs.getString("c_password"),
                    rs.getString("c_indirizzo")
                );

                // polizza
                polizza p = new polizza(
                    rs.getInt("polizza_id"),
                    c,
                    v,
                    rs.getString("merce"),
                    rs.getString("data"),
                    rs.getDouble("peso")
                );

                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void cancella(int id) {
        String sql = "DELETE FROM polizza WHERE ID = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
