/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demotaxi;

import java.sql.*;
import java.util.Scanner;
import myconnnections.DBConnection;


/**
 *
 * @author CASHCONVERTERS
 */
public class Taxi {
    Connection dbConnect = DBConnection.getConnection();
       
     public void creation(){
         Scanner sc = new Scanner(System.in);
         if (dbConnect == null) {
            System.exit(1);
        }
        System.out.println("connexion établie");
        String query1 = "INSERT INTO API_TAXI1(IMMATRICULATION,CARBURANT,PRIXKM,DESCRIPTION) VALUES(?,?,?,?) ";
        String query2 = "SELECT IDTAXI FROM API_TAXI1 WHERE IMMATRICULATION=? AND CARBURANT=? AND PRIXKM=? AND DESCRIPTION=?";
        
        try(PreparedStatement pstm1 = dbConnect.prepareStatement(query1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(query2);)
        {
            System.out.println("Nouveau Taxi :");
            System.out.print("Immatriculation :");
            String immatriculation = sc.nextLine();
            System.out.print("Carburant :");
            String carburant = sc.nextLine();
            System.out.print("Description :");
            String description = sc.nextLine();
            System.out.print("Prix au Km :");
            float prix = sc.nextFloat();
            
            pstm1.setString(1,immatriculation);
            pstm1.setString(2,carburant);
            pstm1.setFloat(3,prix);
            pstm1.setString(4,description);
            
            int n1 = pstm1.executeUpdate();
            System.out.println(n1+" ligne(s) inserée(s)");
            pstm2.setString(1,immatriculation);
            pstm2.setString(2,carburant);
            pstm2.setFloat(3,prix);
            pstm2.setString(4,description);
            
            try(ResultSet rs = pstm2.executeQuery()){
                if(rs.next()){
                    int num = rs.getInt(1);
                    System.out.println("Id du Taxi: "+num);
                }
                else
                {
                    System.out.println("Erreur lors de l'insertion, Taxi Introuvable");
                }
            }
            
        } catch (SQLException e) {
            System.out.println("erreur SQL " + e);
        }
        
        DBConnection.closeConnection();
    }
    
     public void modification(){
         Scanner sc = new Scanner(System.in);
         if (dbConnect == null) {
            System.exit(1);
        }
        //String query = "UPDATE API_CLIENT1 SET NOM = ? WHERE IDCLIENT = ?";
        String query2 = "SELECT IDTAXI FROM API_TAXI1 WHERE IMMATRICULATION=? ";
        String query = "UPDATE API_TAXI1 SET CARBURANT = ? WHERE IDTAXI = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query);
                PreparedStatement pstm2 = dbConnect.prepareStatement(query2);){
            System.out.println("Immatriculation: ");
            String immatri = sc.next();
            pstm2.setString(1, immatri);
            ResultSet rs = pstm2.executeQuery();
            if(rs.next()){
                    int num = rs.getInt(1);
                    System.out.println("Id du Taxi: "+num);
                }
                else
                {
                    System.out.println("Erreur lors de la recherche, Taxi Introuvable");
                }
           /* try(ResultSet rs = pstm2.executeQuery()){
                if(rs.next()){
                    int num = rs.getInt(1);
                    System.out.println("Id du Taxi: "+num);
                }
                else
                {
                    System.out.println("Erreur lors de la recherche, Taxi Introuvable");
                }
            }
            
        } */
        
            
            //
            System.out.println("Identifiant du Taxi(-1 pour terminer): ");
             int idtaxi = sc.nextInt();
             while(!(idtaxi== -1)){
                 System.out.println("Nouveau Carburant: ");
                 String carburant = sc.next();
                 pstm.setString(1,carburant);
                 pstm.setInt(2,idtaxi);
                 int n1 = pstm.executeUpdate();
                 if(n1==0) System.out.println("Taxi Introuvable!");
                 System.out.println(n1+" ligne inseré");
                 System.out.println("Identifiant du Taxi(-1 pour terminer): ");
                 idtaxi = sc.nextInt();
        }
        }catch(SQLException e){
            System.out.println("Erreur lors de la Modification, Client Introuvable");
        }
        DBConnection.closeConnection();
     }
     public void Recherche(){
         Scanner sc = new Scanner(System.in);
         if (dbConnect == null) {
            System.exit(1);
        }
         
        System.out.println("connexion établie");
        System.out.println("Immatriculation du Taxi recherché : ");
        String nomrech = sc.nextLine();
        try(Statement stmt = dbConnect.createStatement();
             ResultSet rs = stmt.executeQuery(
                        "SELECT *  FROM API_TAXI1 WHERE IMMATRICULATION = '"
                        + nomrech + "'");){
          
            boolean trouve = false;
            while (rs.next()) {
                trouve = true;
                String carburant = rs.getString("CARBURANT");
                String description = rs.getString("DESCRIPTION");
                
                System.out.println(nomrech + ":" + carburant + " " + description);
            }
            if (!trouve) {
                System.out.println("immatriculation inconnu");
            }
        }catch (SQLException e) {
            System.out.println("erreur SQL =" + e);
        }
        DBConnection.closeConnection();
         
         
     }

    public static void main(String[] args) {
        Taxi pgm = new Taxi();
        pgm.modification();
    }
    
    
}
