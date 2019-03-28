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

public class taxiDAO extends DAO<API_TAXI1>{
    /**
     * création d'un taxi sur base des valeurs de son objet métier
     *
     * @throws SQLException erreur de création
     * @param obj taxi à créer
     * @return taxi créé
     */
        @Override
    public API_TAXI1 create(API_TAXI1 obj) throws SQLException{
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
    public API_TAXI1 read(int idtaxi) throws SQLException{
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
       String req = "UPDATE API_TAXI1 set immatriculation=?,carburant=?,prixkm=?,description=? where idtaxi= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(5, obj.getIdtaxi());
            pstm.setString(1, obj.getImmatriculation());
            pstm.setString(2, obj.getCarburant());
            pstm.setFloat(3, obj.getPrixkm());
            pstm.setString(4, obj.getDescription());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne taxi mise à jour");
            }
            return read(obj.getIdtaxi());
        }
    }
    
     /**
     * effacement du taxi sur base de son identifiant
     *
     * @throws SQLException erreur d'effacement
     * @param obj taxi à effacer
     */
    @Override
    public void delete(API_TAXI1 obj) throws SQLException{
         String req = "delete from API_TAXI1 where idtaxi= ?";
         try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, obj.getIdtaxi());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne taxi effacée");
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
     public API_TAXI1 readstring(String immat) throws SQLException{
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
     
     public List<API_TAXI1> rechp(String desc) throws SQLException {
        List<API_TAXI1> plusieurs = new ArrayList<>();
        String req = "select idtaxi,immatriculation,carburant,prixkm,description from API_TAXI1 where description like ? ";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setString(1, "%"+desc+"%");
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    int idtaxi = rs.getInt("IDTAXI");
                    String immatriculation = rs.getString("IMMATRICULATION");
                    String carburant = rs.getString("CARBURANT");
                    float prixkm = rs.getFloat("PRIXKM");
                    String description = rs.getString("DESCRIPTION");
                    plusieurs.add(new API_TAXI1(idtaxi, immatriculation, carburant, prixkm, description));
                }

                if (!trouve) {
                    throw new SQLException("nom inconnu");
                } else {
                    return plusieurs;
                }
            }
        }
        
        
    }
     
      public void suppression(API_TAXI1 obj) throws SQLException{
         String req = "delete from API_TAXI1 where immatriculation= ?";
         try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setString(1, obj.getImmatriculation());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne taxi effacée");
            }

        }
    }
}
