/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.metier.builder;

/**
 *
 * @author CASHCONVERTERS
 */
public class gestionTaxi {
     public static void main(String[] args)  {
     
     try {
            Taxi t1 = new Taxi.TaxiBuilder().
                    setIdtaxi(1).
                    setImmatriculation("AE50-US1").
                    setPrixkm(8.50).
                    setDescription("Tres OK").
                    build();
            System.out.println(t1);
        } catch (Exception e) {
            System.out.println("erreur "+e);
        }
     
      try {
            Taxi t2 = new Taxi.TaxiBuilder().
                    setIdtaxi(2).
                    setImmatriculation("ZE50-US1").
                    setDescription("OK").
                    build();
            System.out.println(t2);
        } catch (Exception e) {
            System.out.println("erreur "+e);
        }
     
     
     }
}
