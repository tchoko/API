/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxi.metier;

import java.sql.Date;



/**
 *classe métier de gestion de la vue vue_location
 * @author Clive TCHOKOUANDEU
 * version 1.0
 */
public class API_VUE_LOCATION {
    
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
     * immatricualation du taxi
   */
    protected String immatriculation;
    
    /**
     * prix au kilomètre de la location
   */
    protected float prixkm;
    
    /**
     * id du client
   */
    protected int id_client;
    
    /**
     * nom du client
   */
    protected String nom;

     /**
      * constructeur sans paramétes
    */
    public API_VUE_LOCATION() {
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
     * @param id_taxi   identifiant du taxi
     * @param immatriculation immatriculation du taxi
     * @param prixkm    prix au kilomètre de la location
     * @param id_client identifiant du client
     * @param nom nom du client
   */  
    public API_VUE_LOCATION(int idloc, Date dateloc, int kmtotal, float acompte, float total, int id_deb, int id_fin, int id_taxi, String immatriculation, float prixkm, int id_client, String nom) {
        this.idloc = idloc;
        this.dateloc = dateloc;
        this.kmtotal = kmtotal;
        this.acompte = acompte;
        this.total = total;
        this.id_deb = id_deb;
        this.id_fin = id_fin;
        this.id_taxi = id_taxi;
        this.immatriculation = immatriculation;
        this.prixkm = prixkm;
        this.id_client = id_client;
        this.nom = nom;
    }

    /**
    * getter idloc
    * @return idloc identifiant de la location
    */
    public int getIdloc() {
        return idloc;
    }

    /**
    * getter dateloc
    * @return dateloc date de la location
    */
    public Date getDateloc() {
        return dateloc;
    }

    /**
    * getter kmtotal
    * @return kmtotal  du trajet
    */
    public int getKmtotal() {
        return kmtotal;
    }

    /**
    * getter acompte
    * @return acompte de la course
    */
    public float getAcompte() {
        return acompte;
    }

    /**
    * getter total
    * @return total prix de la course
    */
    public float getTotal() {
        return total;
    }

    public int getId_deb() {
        return id_deb;
    }

    /**
    * getter id_fin
    * @return id_fin
    */
    public int getId_fin() {
        return id_fin;
    }

    /**
    * getter id_taxi
    * @return id_taxi identifiant du taxi
    */
    public int getId_taxi() {
        return id_taxi;
    }

    /**
    * getter immatriculation
    * @return immatriculation du taxi
    */
    public String getImmatriculation() {
        return immatriculation;
    }

    /**
    * getter prixkm
    * @return prixkm  du trajet
    */
    public float getPrixkm() {
        return prixkm;
    }

    /**
    * getter id_client
    * @return id_client l'identifiant du client
    */
    public int getId_client() {
        return id_client;
    }

    /**
    * getter nom
    * @return nom du client
    */
    public String getNom() {
        return nom;
    }
    
     /**
     * setter idloc
     * @param idloc identifiant de location
     */
    public void setIdloc(int idloc) {
        this.idloc = idloc;
    }

     /**
     * setter dateloc
     * @param dateloc date de la location
     */
    public void setDateloc(Date dateloc) {
        this.dateloc = dateloc;
    }

     /**
     * setter kmtotal
     * @param kmtotal kilomètre total du trajet
     */
    public void setKmtotal(int kmtotal) {
        this.kmtotal = kmtotal;
    }

     /**
     * setter acompte
     * @param acompte acompte de la location
     */
    public void setAcompte(float acompte) {
        this.acompte = acompte;
    }

     /**
     * setter total
     * @param total prix total de location
     */
    public void setTotal(float total) {
        this.total = total;
    }

     /**
     * setter id_deb
     * @param id_deb 
     */
    public void setId_deb(int id_deb) {
        this.id_deb = id_deb;
    }

     /**
     * setter id_fin
     * @param id_fin 
     */
    public void setId_fin(int id_fin) {
        this.id_fin = id_fin;
    }

     /**
     * setter id_taxi
     * @param id_taxi identifiant du taxi
     */
    public void setId_taxi(int id_taxi) {
        this.id_taxi = id_taxi;
    }

     /**
     * setter immatriculation
     * @param immatriculation l'immatriculation du véhicule
     */
    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

     /**
     * setter prixkm
     * @param prixkm prix au km
     */
    public void setPrixkm(float prixkm) {
        this.prixkm = prixkm;
    }
    
     /**
     * setter id_client
     * @param id_client identifiant du client
     */
    public void setId_client(int id_client) {
        this.id_client = id_client;
    }
    
     /**
     * setter nom
     * @param nom nom du client
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
       /**
 * méthode toString
 * @return informations complètes
 */
    public String toString() {
        return "API_VUE_LOCATION{" + "idloc=" + idloc + ", dateloc=" + dateloc + ", kmtotal=" + kmtotal + ", acompte=" + acompte + ", total=" + total + ", id_deb=" + id_deb + ", id_fin=" + id_fin + ", id_taxi=" + id_taxi + ", immatriculation=" + immatriculation + ", prixkm=" + prixkm + ", id_client=" + id_client + ", nom=" + nom + '}';
    }
    
    
    
    
    
}
