/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxi.DAO;

/**
 *
 * @author CASHCONVERTERS
 */
import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import taxi.metier.API_CLIENT1;
public class ClientDAO extends DAO<API_CLIENT1>{
    /**
     * création d'un client sur base des valeurs de son objet métier
     *
     * @throws SQLException erreur de création
     * @param obj client à créer
     * @return client créé
     */
    @Override
    public API_CLIENT1 create(API_CLIENT1 obj) throws SQLException{
        String req1 = "insert into API_CLIENT1(nom,prenom,tel) values(?,?,?)";
        String req2 = "select idclient from API_CLIENT1 where nom=? and prenom=? and tel=?";
        
         try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
            pstm1.setString(1, obj.getNom());
            pstm1.setString(2, obj.getPrenom());
            pstm1.setString(3, obj.getTel());
            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation client, aucune ligne créée");
            }
            pstm2.setString(1, obj.getNom());
            pstm2.setString(2, obj.getPrenom());
            pstm2.setString(3, obj.getTel());
            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idclient = rs.getInt(1);
                    return read(idclient);
                } else {
                    throw new SQLException("erreur de création client, record introuvable");
                }
            }
        }
    }
    
    @Override
    /**
     * récupération des données d'un client sur base de son identifiant
     *
     * @throws SQLException code inconnu
     * @param idclient identifiant du taxi
     * @return client trouvé
     */
    public API_CLIENT1 read(int idclient) throws SQLException{
       String req = "select * from API_CLIENT1 where idclient = ?";
       try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, idclient);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    String nom = rs.getString("NOM");
                    String prenom = rs.getString("PRENOM");
                    String tel = rs.getString("TEL");
                    return new API_CLIENT1(idclient, nom, prenom, tel);

                } else {
                    throw new SQLException("Code inconnu");
                }

            }
        }
        
    }
    
    @Override
    /**
     * mise à jour des données du client sur base de son identifiant
     *
     * @return API_CLIENT1
     * @param obj client à mettre à jour
     * @throws SQLException erreur de mise à jour
     */
    public API_CLIENT1 update(API_CLIENT1 obj) throws SQLException {
       
        return new API_CLIENT1();
    }
    @Override
    
     /**
     * effacement du client sur base de son identifiant
     *
     * @throws SQLException erreur d'effacement
     * @param obj client à effacer
     */
    public void delete(API_CLIENT1 obj) throws SQLException{
        
    }
    @Override
     /**
     * récupération des données d'un client sur base de son nom
     *
     * @throws SQLException code inconnu
     * @param nom nom du client
     * @return client trouvé
     */
    public API_CLIENT1 readstring(String nom) throws SQLException{
        return new API_CLIENT1();
    }
}
