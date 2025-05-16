package com.example.demo.Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.Entity.viaggio;
import com.example.demo.Entity.fornitore;
import com.example.demo.Entity.porto;
import com.example.demo.Entity.nave;

public class ViaggioDao {
    private final String url = "jdbc:mysql://localhost:3306/terminal";
    private final String user = "root";
    private final String password = "";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void inserisci(int fornitoreId, int portoPartenzaId, int portoArrivoId, String dataArrivo, String dataPartenza, int naveId) {
        String sql = "INSERT INTO viaggio (fornitore, porto_partenza, porto_arrivo, data_arrivo, data_partenza, nave) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, fornitoreId);
            stmt.setInt(2, portoPartenzaId);
            stmt.setInt(3, portoArrivoId);
            stmt.setString(4, dataArrivo);
            stmt.setString(5, dataPartenza);
            stmt.setInt(6, naveId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<viaggio> visualizza() {
        List<viaggio> lista = new ArrayList<>();
        String sql = """
            SELECT 
                v.ID AS viaggio_id,
                v.data_arrivo, 
                v.data_partenza,
                
                f.ID AS fornitore_id, f.nome AS f_nome, f.cognome AS f_cognome, f.mail AS f_mail, f.tel AS f_tel, f.password AS f_password,
                pp.ID AS partenza_id, pp.nome AS pp_nome, pp.rotta AS pp_rotta, pp.nazione AS pp_nazione,
                pa.ID AS arrivo_id, pa.nome AS pa_nome, pa.rotta AS pa_rotta, pa.nazione AS pa_nazione,
                n.ID AS nave_id, n.nome AS n_nome, n.tipo AS n_tipo
                
            FROM viaggio v
            JOIN fornitore f ON v.fornitore = f.ID
            JOIN porto pp ON v.porto_partenza = pp.ID
            JOIN porto pa ON v.porto_arrivo = pa.ID
            JOIN nave n ON v.nave = n.ID
            """;
    
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                fornitore f = new fornitore(
                    rs.getInt("fornitore_id"),
                    rs.getString("f_nome"),
                    rs.getString("f_cognome"),
                    rs.getString("f_mail"),
                    rs.getString("f_tel"),
                    rs.getString("f_password")
                );
    
                porto portoPartenza = new porto(
                    rs.getInt("partenza_id"),
                    rs.getString("pp_nome"),
                    rs.getString("pp_rotta"),
                    rs.getString("pp_nazione")
                );
    
                porto portoArrivo = new porto(
                    rs.getInt("arrivo_id"),
                    rs.getString("pa_nome"),
                    rs.getString("pa_rotta"),
                    rs.getString("pa_nazione")
                );
    
                nave n = new nave(
                    rs.getInt("nave_id"),
                    rs.getString("n_nome"),
                    rs.getString("n_tipo")
                );
    
                viaggio v = new viaggio(
                    rs.getInt("viaggio_id"),
                    f,
                    rs.getString("data_arrivo"),
                    rs.getString("data_partenza"),
                    portoPartenza,
                    portoArrivo,
                    n
                );
    
                lista.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return lista;
    }
    

    public void cancella(int id) {
        String sql = "DELETE FROM viaggio WHERE ID = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
