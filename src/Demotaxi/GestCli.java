/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demotaxi;

/**
 *
 * @author CASHCONVERTERS
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import taxi.DAO.ClientDAO;
import taxi.DAO.DAO;
import taxi.metier.API_CLIENT1;
import myconnnections.DBConnection;
public class GestCli {
    Scanner sc = new Scanner(System.in);
    API_CLIENT1 clActuel = null;
    DAO<API_CLIENT1> clientDAO = null;

    public GestCli() {

    }
    public void gestion() {
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
            System.exit(1);
        }

        System.out.println("connexion établie");

        clientDAO = new ClientDAO();
        clientDAO.setConnection(dbConnect);

        int ch = 0;
        do {
            System.out.println("1.nouveau \n2.recherche\n3.modification\n4.suppression\n5.recherche sur nom\n6.dernière commande\n7.fin");
            System.out.print("choix :");
            ch = sc.nextInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    nouveau();
                    break;
                case 2:
                    //recherche();
                    break;
                case 3:
                    //modif();
                    break;
                case 4:
                    //sup();
                    break;
                case 5:
                    //rechnom();
                    break;
                case 6:
                    //derncom();
                    break;
                case 7:
                    System.out.println("bye");
                    break;
                default:
                    System.out.println("choix incorrect");
            }

        } while (ch != 7);
        DBConnection.closeConnection();
    }
     public void nouveau() {

        System.out.print("Nom :");
        String nom = sc.nextLine();
        System.out.print("Prénom :");
        String prenom = sc.nextLine();
        System.out.print("tel :");
        String tel = sc.nextLine();
        clActuel = new API_CLIENT1(0, nom, prenom, tel);
        try {
            clActuel = clientDAO.create(clActuel);
            System.out.println("client actuel : " + clActuel);
        } catch (SQLException e) {
            System.out.println("erreur :" + e);
        }

    }
     
     
     
     
     public static void main(String[] args) {
        GestCli gc = new GestCli();
        gc.gestion();

    }
}
