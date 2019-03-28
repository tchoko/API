/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxi.metier;

import java.sql.Date;

/**
 *classe métier de gestion d'une location
 * @author Clive TCHOKOUANDEU
 * version 1.0
 */
public class API_LOCATION1 {
     /**
     * identifiant unique de la location
   */
    protected int idloc;
    /**
     * date de la location
   */
    protected Date dateloc;
    /**
     * kilomètre total  de la location
   */
    protected int kmtotal;
     /**
     * l'acompte de la location
   */
    protected float acompte;
     /**
     * montant total de la location
   */
    protected float total;
    /**
     * id du debut du trajet
   */
    protected int id_deb;
     /**
     * id de fin du trajet
   */
    protected int id_fin;
    /**
     * id du taxi
   */
    protected int id_taxi;
     /**
     * id du client
   */
    protected int id_client;
    
     /**
      * constructeur sans paramétes
    */
    public API_LOCATION1(){
        
    }

     /**
     * constructeur paramétré
     * @param idloc identifiant unique de la location, affecté par la base de données
     * @param dateloc date de la location
     * @param kmtotal kilomètre total parcouru
     * @param acompte acompte de la location
     * @param total Prix total de la location
     * @param id_deb
     * @param id_fin
     * @param id_taxi
     * @param id_client identifiant du client
   */  
    public API_LOCATION1(int idloc, Date dateloc, int kmtotal, float acompte, float total, int id_deb, int id_fin, int id_taxi, int id_client) {
        this.idloc = idloc;
        this.dateloc = dateloc;
        this.kmtotal = kmtotal;
        this.acompte = acompte;
        this.total = total;
        this.id_deb = id_deb;
        this.id_fin = id_fin;
        this.id_taxi = id_taxi;
        this.id_client = id_client;
    }

    /**
    * getter idloc
    * @return identifiant de la location
    */
    public int getIdloc() {
        return idloc;
    }

    /**
     * setter idloc
     * @param idloc affecte un identifiant à la location
     */
    public void setIdloc(int idloc) {
        this.idloc = idloc;
    }

    /**
    * getter dateloc
    * @return dateloc date de la location
    */
    public Date getDateloc() {
        return dateloc;
    }

    /**
     * setter dateloc
     * @param dateloc affecte une date à la location
     */
    public void setDateloc(Date dateloc) {
        this.dateloc = dateloc;
    }

    /**
    * getter kmtotal
    * @return kmtotal nbre de kilomètre parcouru
    */
    public int getKmtotal() {
        return kmtotal;
    }

    /**
     * setter kmtotal
     * @param kmtotal affecte une valeur au kilomètre parcouru
     */
    public void setKmtotal(int kmtotal) {
        this.kmtotal = kmtotal;
    }

    /**
    * getter acompte
    * @return acompte de la location
    */
    public float getAcompte() {
        return acompte;
    }

    /**
     * setter acompte
     * @param acompte affecte un acompte pour la location
     */
    public void setAcompte(float acompte) {
        this.acompte = acompte;
    }

    /**
    * getter total
    * @return total prix à payer de la location
    */
    public float getTotal() {
        return total;
    }

    /**
     * setter total
     * @param total affecte un prix total à la location
     */
    public void setTotal(float total) {
        this.total = total;
    }

    /**
    * getter id_deb
    * @return id_deb
    */
    public int getId_deb() {
        return id_deb;
    }

    /**
     * setter id_deb
     * @param id_deb affecte un identifiant  
     */
    public void setId_deb(int id_deb) {
        this.id_deb = id_deb;
    }

    /**
    * getter id_fin
    * @return id_fin
    */
    public int getId_fin() {
        return id_fin;
    }

    /**
     * setter id_fin
     * @param id_fin affecte unidentifiant 
     */
    public void setId_fin(int id_fin) {
        this.id_fin = id_fin;
    }

    /**
    * getter id_taxi
    * @return id_taxi identifiant du taxi
    */
    public int getId_taxi() {
        return id_taxi;
    }

    /**
     * setter id_taxi
     * @param id_taxi affecte un identifiant au taxi
     */
    public void setId_taxi(int id_taxi) {
        this.id_taxi = id_taxi;
    }

    /**
    * getter id_client
    * @return id_client identifiant du client
    */
    public int getId_client() {
        return id_client;
    }

    /**
     * setter id_client
     * @param id_client affecte un identifiant au client
     */
    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    @Override
      /**
      * méthode toString
      * @return informations complètes
      */
    public String toString() {
        return "API_LOCATION1{" + "idloc=" + idloc + ", dateloc=" + dateloc + ", kmtotal=" + kmtotal + ", acompte=" + acompte + ", total=" + total + ", id_deb=" + id_deb + ", id_fin=" + id_fin + ", id_taxi=" + id_taxi + ", id_client=" + id_client + '}';
    }
    
    
}
