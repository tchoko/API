/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns.metier.observer;

//import DesignPatterns.metier.observer.Subject;

/**
 *
 * @author CASHCONVERTERS
 */
public class gestionTaxi {
     public static void main(String[] args)  {
         Client cl1= new Client(1,"Dupont","Annie","0466348977");
         Client cl2= new Client(2,"Dufour","Louis","0466348977");
         Location l1 = new Location(1,"02/02/2019",5.92,10.50);
         Location l2 = new Location(2,"02/02/2019",5.92,10.52);
         l1.addObserver(cl1);
         l1.addObserver(cl2);
         l2.addObserver(cl2);
         
         l1.setIdloc(2);
         l2.setIdloc(1);
    
     
     }
}
