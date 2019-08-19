package taxi.DAO;

/**
 * classe de mappage poo-relationnel taxi
 *
 * @author Clive TCHOKOUANDEU
 * @version 1.0
 * @see API_TAXI1
 */
import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import taxi.metier.API_TAXI1;

public class API_TAXI1DAO extends DAO<API_TAXI1> {

    /**
     * création d'un taxi sur base des valeurs de son objet métier
     *
     * @throws SQLException erreur de création
     * @param obj taxi à créer
     * @return taxi créé
     */
    @Override
    public API_TAXI1 create(API_TAXI1 obj) throws SQLException {
        String req1 = "insert into API_TAXI1(immatriculation,carburant,prixkm,description) values(?,?,?,?)";
        String req2 = "select idtaxi from API_TAXI1 where immatriculation=? and carburant=? and prixkm=? and description=?";

        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
            pstm1.setString(1, obj.getImmatriculation());
            pstm1.setString(2, obj.getCarburant());
            pstm1.setFloat(3, obj.getPrixkm());
            pstm1.setString(4, obj.getDescription());
            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation taxi, aucune ligne créée");
            }
            pstm2.setString(1, obj.getImmatriculation());
            pstm2.setString(2, obj.getCarburant());
            pstm2.setFloat(3, obj.getPrixkm());
            pstm2.setString(4, obj.getDescription());
            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idtaxi = rs.getInt(1);
                    return read(idtaxi);
                } else {
                    throw new SQLException("erreur de création taxi, record introuvable");
                }
            }
        }
    }

    /**
     * récupération des données d'un taxi sur base de son identifiant
     *
     * @throws SQLException code inconnu
     * @param idtaxi identifiant du taxi
     * @return taxi trouvé
     */
    @Override
    public API_TAXI1 read(int idtaxi) throws SQLException {
        String req = "select * from API_TAXI1 where idtaxi = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1, idtaxi);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    String immatriculation = rs.getString("IMMATRICULATION");
                    String carburant = rs.getString("CARBURANT");
                    float prixkm = rs.getFloat("PRIXKM");
                    String description = rs.getString("DESCRIPTION");
                    return new API_TAXI1(idtaxi, immatriculation, carburant, prixkm, description);

                } else {
                    throw new SQLException("Code inconnu");
                }

            }
        }

    }

    /**
     * mise à jour des données du taxi sur base de son identifiant
     *
     * @return API_TAXI1
     * @param obj taxi à mettre à jour
     * @throws SQLException erreur de mise à jour
     */
    @Override
    public API_TAXI1 update(API_TAXI1 obj) throws SQLException {
      //  String req2 = "SELECT idtaxi from API_TAXI1 where immatriculation = ?";
        String req = "UPDATE API_TAXI1 set description=? where immatriculation= ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(req) ) {

            pstm.setString(2, obj.getImmatriculation());
            pstm.setString(1, obj.getDescription());
            
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne taxi mise à jour");
            }
            return readstring(obj.getImmatriculation());
        }
    }

    /**
     * effacement du taxi sur base de son identifiant
     *
     * @throws SQLException erreur d'effacement
     * @param obj taxi à effacer
     */
    @Override
    public void delete(API_TAXI1 obj) throws SQLException {
        String req = "DELETE FROM API_TAXI1 WHERE immatriculation = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            
            
            pstm.setString(1, obj.getImmatriculation());
            int n = pstm.executeUpdate();

            if (n == 0) {
                throw new SQLException("aucune ligne location supprimée");
            }

        }
    }

    /**
     * récupération des données d'un taxi sur base de son immatriculation
     *
     * @throws SQLException code inconnu
     * @param immat identifiant du taxi
     * @return taxi trouvé
     */
    @Override
    public API_TAXI1 readstring(String immat) throws SQLException {
        String req = "select * from API_TAXI1 where immatriculation = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setString(1, immat);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    int idtaxi = rs.getInt("IDTAXI");
                    String immatriculation = rs.getString("IMMATRICULATION");
                    String carburant = rs.getString("CARBURANT");
                    float prixkm = rs.getFloat("PRIXKM");
                    String description = rs.getString("DESCRIPTION");
                    return new API_TAXI1(idtaxi, immatriculation, carburant, prixkm, description);

                } else {
                    throw new SQLException("Code inconnu");
                }

            }
        }
    }

    /**
     * récupération des données d'un taxi sur base de sa description
     *
     * @throws SQLException description inconnu
     * @param desc description du taxi
     * @return taxi trouvé
     */
    public List<API_TAXI1> rechp(String desc) throws SQLException {
        List<API_TAXI1> plusieurs = new ArrayList<>();
        String req = "select idtaxi,immatriculation,carburant,prixkm,description from API_TAXI1 where lower(description) like ? ";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setString(1, "%" + desc + "%");
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    int idtaxi = rs.getInt("IDTAXI");
                    String immatriculation = rs.getString("IMMATRICULATION");
                    String carburant = rs.getString("CARBURANT");
                    float prixkm = rs.getFloat("PRIXKM");
                    String description = rs.getString("DESCRIPTION").toLowerCase();
                    plusieurs.add(new API_TAXI1(idtaxi, immatriculation, carburant, prixkm, description));
                }

                if (!trouve) {
                    throw new SQLException("description inconnu");
                } else {
                    return plusieurs;
                }
            }
        }

    }
    /**
     * récupération de toutes les données d'un taxi 
     *
     * @throws SQLException 
     * @param idtaxi 
     * @param immatriculation
     * @param carburant
     * @param prixkm
     * @param description
     * @return l'ensemble des taxis
     */
      public List<API_TAXI1> Affiche() throws SQLException {
        List<API_TAXI1> t = new ArrayList();
        String req = "SELECT * FROM API_TAXI1";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) 
        {
            try (ResultSet rs = pstm.executeQuery())
            {
                while (rs.next()) 
                {
                    int idtaxi = rs.getInt("IDTAXI");
                    String immatriculation = rs.getString("IMMATRICULATION");
                    String carburant = rs.getString("CARBURANT");
                    Float prixkm = rs.getFloat("PRIXKM");
                    String description = rs.getString("DESCRIPTION");
                    t.add(new API_TAXI1(idtaxi, immatriculation, carburant, prixkm, description));
                }
            }
        }
        return t;
    }

    /**
     * suppréssion des données d'un taxi sur base de son immatriculation
     *
     * @throws SQLException immatriculation inconnu
     * @param immat identifiant du taxi
     */
    /*
    public void suppression(API_TAXI1 obj) throws SQLException {
        String req = "delete from API_TAXI1 where immatriculation= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setString(1, obj.getImmatriculation());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne taxi effacée");
            }

        }
    }*/
}
