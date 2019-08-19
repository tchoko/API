/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxi.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import taxi.metier.API_ADRESSE1;

/**
 *
 * @author CASHCONVERTERS
 */
public class AdresseDAO extends DAO<API_ADRESSE1>{

    @Override
    public API_ADRESSE1 read(int idadr) throws SQLException {
        String req = "SELECT * FROM API_ADRESSE1 WHERE idadr= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) 
        {
            pstm.setInt(1, idadr);
            try (ResultSet rs = pstm.executeQuery()) 
            {
                if (rs.next()) 
                {
                    String cp = rs.getString("CP");
                    String localite = rs.getString("LOCALITE");
                    String rue = rs.getString("RUE");
                    String num = rs.getString("NUM");
                    return new API_ADRESSE1(idadr, cp, localite, rue, num);

                } else {
                    throw new SQLException("Code Adressse Inconnu");
                }
            }
        }
    }

    @Override
    public API_ADRESSE1 readstring(String s) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
     public API_ADRESSE1 create(API_ADRESSE1 obj) throws SQLException {
        String req1 = "INSERT INTO API_ADRESSE1 (cp,localite,rue,num) values(?,?,?,?)";
        String req2 = "SELECT idadr FROM API_ADRESSE1 WHERE cp=? and localite=? and rue=? and num=?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
            pstm1.setString(1, obj.getCp());
            pstm1.setString(2, obj.getLocalite());
            pstm1.setString(3, obj.getRue());
            pstm1.setString(4, obj.getNum());

            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation de l'adresse");
            }

            pstm2.setString(1, obj.getCp());
            pstm2.setString(2, obj.getLocalite());
            pstm2.setString(3, obj.getRue());
            pstm2.setString(4, obj.getNum());

            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idadr = rs.getInt(1);
                    obj.setIdadr(idadr);
                    return read(idadr);
                } else {
                    throw new SQLException("erreur de création de l'adresse");
                }
            }
        }

    }

    @Override
     public API_ADRESSE1 update(API_ADRESSE1 obj) throws SQLException {
        String req = "UPDATE API_ADRESSE1 SET cp=?,localite=?,rue=?,num=? WHERE idadr=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req))
        {
            pstm.setString(1, obj.getCp());
            pstm.setString(2, obj.getLocalite());
            pstm.setString(3, obj.getRue());
            pstm.setString(4, obj.getNum());
            pstm.setInt(5, obj.getIdadr());
            int n = pstm.executeUpdate();
            System.out.println(req);
            if (n == 0) {
                throw new SQLException("aucune adresse mis à jour");
            }
            return read(obj.getIdadr());
        }

    }

    @Override
    public void delete(API_ADRESSE1 obj) throws SQLException {
        String req = "DELETE FROM API_ADRESSE1 WHERE idadr= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req))
        {
            pstm.setInt(1, obj.getIdadr());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune  adresse supprimée");
            }

        }
    }
    
     public List<API_ADRESSE1> affiche() throws SQLException{
        List<API_ADRESSE1> adr = new ArrayList();
        String req = "SELECT * FROM API_ADRESSE1";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) 
        {
            try (ResultSet rs = pstm.executeQuery())
            {
                while (rs.next()) 
                {
                    int id = rs.getInt("IDADR");
                    String cp = rs.getString("CP");
                    String localite = rs.getString("LOCALITE");
                    String rue = rs.getString("RUE");
                    String num = rs.getString("NUM");
                    adr.add(new API_ADRESSE1(id,cp,localite,rue,num));
                }
            }
        }
        return adr;
    }
    
}
