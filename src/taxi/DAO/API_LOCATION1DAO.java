/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxi.DAO;
import taxi.metier.API_LOCATION1;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Clive TCHOKOUANDEU
 */
public class API_LOCATION1DAO extends DAO <API_LOCATION1> {
    /**
     * Récupération des données d'une location sur base de son identifiant
     * @throws SQLException code inconnu
     * @param idloc identifiant de la Location
     * @return Location trouvé..
     */
    @Override
    public API_LOCATION1 read(int idloc) throws SQLException {
        String req = "select * from API_LOCATION1 where idloc = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, idloc);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    LocalDate dateloc = rs.getDate("DATELOC").toLocalDate();
                    int kmtotal = rs.getInt("KMTOTAL");
                    float acompte = rs.getFloat("ACOMPTE");
                    float total = rs.getFloat("TOTAL");
                    int idclient = rs.getInt("IDCLIENT");
                    int idtaxi = rs.getInt("IDTAXI");
                    int id_deb = rs.getInt("ID_DEB");
                    int id_fin = rs.getInt("ID_FIN");

                    return new API_LOCATION1(idloc, dateloc, kmtotal, acompte, total,  idtaxi, idclient, id_deb, id_fin);

                } else {
                    throw new SQLException("Code inconnu");
                }

            }
        }
    }

    @Override
    public API_LOCATION1 readstring(String s) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * création d'une Location 
     * @throws SQLException Erreur de création
     * @param obj location à créer
     * @return location créé
     */
    @Override
    public API_LOCATION1 create(API_LOCATION1 obj) throws SQLException {
       String req1 = "INSERT INTO  API_LOCATION1 (dateloc,kmtotal,acompte,total,idclient,idtaxi,id_deb,id_fin) VALUES(?,?,?,?,?,?,?,?)";
        String req2 = "SELECT idloc FROM API_LOCATION1 WHERE dateloc=? AND kmtotal=? AND acompte=? AND total=? AND idclient=? AND idtaxi=? AND id_deb=? AND id_fin=?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
            pstm1.setDate(1, java.sql.Date.valueOf(obj.getDateloc()));
            pstm1.setInt(2, obj.getKmtotal());
            pstm1.setFloat(3, obj.getAcompte());
            pstm1.setFloat(4, obj.getTotal());
            pstm1.setInt(5, obj.getId_client());
            pstm1.setInt(6, obj.getId_taxi());
            pstm1.setInt(7, obj.getId_deb());
            pstm1.setInt(8, obj.getId_fin());
            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de création de la location, aucune ligne créée");
            }
            pstm2.setDate(1, java.sql.Date.valueOf(obj.getDateloc()));
            pstm2.setInt(2, obj.getKmtotal());
            pstm2.setFloat(3, obj.getAcompte());
            pstm2.setFloat(4, obj.getTotal());

            pstm2.setInt(5, obj.getId_client());
            pstm2.setInt(6, obj.getId_taxi());
            pstm2.setInt(7, obj.getId_deb());
            pstm2.setInt(8, obj.getId_fin());

            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idloc = rs.getInt(1);
                    obj.setIdloc(idloc);
                    return read(idloc);
                } else {
                    throw new SQLException("erreur de création de la nouvelle Location, enregistrement introuvable");
                }
            }
        }
    }

    /**
     * Update des informations sur la Location
     * @return Location
     * @param obj location à mettre à jour
     * @throws SQLException erreur de mis à jour
     */
    @Override
    public API_LOCATION1 update(API_LOCATION1 obj) throws SQLException {
        String req = "UPDATE API_LOCATION1 SET dateloc=?,kmtotal=?,acompte=?,total=?,idclient=?,idtaxi=?,id_deb=?,id_fin=? WHERE idloc= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(9, obj.getIdloc());
            pstm.setDate(1, java.sql.Date.valueOf(obj.getDateloc()));
            pstm.setInt(2, obj.getKmtotal());
            pstm.setFloat(3, obj.getAcompte());
            pstm.setFloat(4, obj.getTotal());
            pstm.setInt(5, obj.getId_client());
            pstm.setInt(6, obj.getId_taxi());
            pstm.setInt(7, obj.getId_deb());
            pstm.setInt(8, obj.getId_fin());
            
            int n = pstm.executeUpdate();
            System.out.println(req);
            if (n == 0) {
                throw new SQLException("aucune ligne location mis à jour");
            }
            return read(obj.getIdloc());
        }
    }

    /**
     * Suppression de la location à partir de son identifiant
     * @throws SQLException erreur de suppression
     * @param obj Location à Supprimer
     */
    @Override
    public void delete(API_LOCATION1 obj) throws SQLException {
        String req = "DELETE FROM API_LOCATION1 WHERE idloc= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, obj.getIdloc());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne Location supprimée");
            }

        }
    }
     /**
     *Affiche Les Locations liées à un Taxi sur base de son id
     * @param idT
     * @return Locations
     * @throws SQLException
     */
    public List<API_LOCATION1> AfficheLocTaxi(int idT) throws SQLException {
        List<API_LOCATION1> l = new ArrayList();
        String req = "SELECT * FROM API_LOCATION1 WHERE idtaxi=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1, idT);
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    int idloc = rs.getInt("IDLOC");
                    LocalDate dateloc = rs.getDate("DATELOC").toLocalDate();
                    int kmtotal = rs.getInt("KMTOTAL");
                    float acompte = rs.getFloat("ACOMPTE");
                    float total = rs.getFloat("TOTAL");
                    int idclient = rs.getInt("IDCLIENT");
                    int idtaxi = rs.getInt("IDTAXI");
                    int id_deb = rs.getInt("ID_DEB");
                    int id_fin = rs.getInt("ID_FIN");
                    l.add(new API_LOCATION1(idloc, dateloc, kmtotal, acompte, total, id_deb, id_fin,  idtaxi, idclient));
                }
            }
        }
        return l;
    }
    
    /**
     * Affiche les locations 
     * @return une liste
     */
     public List<API_LOCATION1> afficheAll() throws SQLException {
        List<API_LOCATION1> loc = new ArrayList();
        String req = "SELECT * FROM API_LOCATION1";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    int idloc = rs.getInt("IDLOC");
                    LocalDate dateloc = rs.getDate("DATELOC").toLocalDate();
                    int kmtotal = rs.getInt("KMTOTAL");
                    float acompte = rs.getFloat("ACOMPTE");
                    float total = rs.getFloat("TOTAL");
                    int idclient = rs.getInt("IDCLIENT");
                    int idtaxi = rs.getInt("IDTAXI");
                    int id_deb = rs.getInt("ID_DEB");
                    int id_fin = rs.getInt("ID_FIN");
                    loc.add(new API_LOCATION1(idloc, dateloc, kmtotal, acompte, total, id_deb, id_fin,  idtaxi, idclient));
                }
            }
        }
        return loc;
    }
}
