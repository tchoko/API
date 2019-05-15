/**
 *classe  de gestion d'un taxi
 * @author Clive TCHOKOUANDEU
 * version 1.0
 */
package Demotaxi;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import taxi.DAO.API_TAXI1DAO;
import taxi.DAO.DAO;
import taxi.metier.API_TAXI1;
import myconnnections.DBConnection;
/**
 *
 * @author CASHCONVERTERS
 */
public class GestionTaxi {
    Scanner sc = new Scanner(System.in);
    API_TAXI1 tAct = null;
    DAO<API_TAXI1> txDAO = null;
    public GestionTaxi(){
        
    }
     public void gestion() {
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connexon invalide");
            System.exit(1);
        }

        System.out.println("connexion établie");

        txDAO = new API_TAXI1DAO();
        txDAO.setConnection(dbConnect);

        int ch = 0;
        do {
            System.out.println("1.nouveau \n2.recherche exacte\n3.recherche partielle\n4.modification\n5.suppression\n6.fin");
            System.out.print("choix :");
            ch = sc.nextInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    nouveau();
                    break;
                case 2:
                    recherche();
                    break;
                case 3:
                    recherchePart();
                    break;
                case 4:
                    modification();
                    break;
                case 5:
                    sup();
                    break;
                case 6:
                    System.out.println("bye");
                    break;
                default:
                    System.out.println("choix incorrect");
            }

        } while (ch != 6);
        DBConnection.closeConnection();
    }
     public void nouveau() {

        System.out.print("Immatriculation: ");
        String immatriculation = sc.nextLine();
        System.out.print("Carburant: ");
        String carburant = sc.nextLine();
        System.out.print("Prix km: ");
        float prixkm = sc.nextFloat();
        sc.skip("\n");
        System.out.print("Description: ");
        String description = sc.nextLine();
        tAct = new API_TAXI1(0, immatriculation, carburant, prixkm, description);
        try {
            tAct = txDAO.create(tAct);
            System.out.println("taxi actuel : " + tAct);
        } catch (SQLException e) {
            System.out.println("erreur :" + e);
        }

    }
     public void recherche() {
        try {
            System.out.println("immatriculation recherchée :");
            String nc = sc.nextLine();
            tAct = txDAO.readstring(nc);
            System.out.println("taxi actuel : " + tAct);

        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }
     
     public void modification() {
        try {
            //todo 
            System.out.println("Immatriculation du taxi à modifier: ");
            String immat = sc.nextLine();
            //tAct = new API_TAXI1(immat);
            tAct = txDAO.readstring(immat);
            System.out.println(tAct);
             System.out.println("Description: ");
            String desc = sc.nextLine();
            tAct.setDescription(desc);
            
            txDAO.update(tAct);
            System.out.println(txDAO.readstring(immat));
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }
    public void sup() {
        try {
            System.out.println("Immatriculation: ");
            String immat = sc.nextLine();
           // tAct = new API_TAXI1(0,immat,"",0,"");
           // tAct = new API_TAXI1(immat);
            tAct = txDAO.readstring(immat);
            System.out.println(tAct);
            txDAO.delete(tAct);
            System.out.println("Ligne Supprimée");
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
       
    }
    public void recherchePart() {
        
            System.out.println("description recherchée :");
            String nc = sc.nextLine();
            try {
            List<API_TAXI1> taxi = ((API_TAXI1DAO) txDAO).rechp(nc);
            for (API_TAXI1 cl : taxi) {
                System.out.println(cl);
            }
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }
    
    
      public static void main(String[] args) {
        GestionTaxi gt = new GestionTaxi();
        gt.gestion();

    }
}
