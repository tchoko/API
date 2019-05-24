/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxi.metier;

/**
 *classe métier de gestion d'un taxi
 * @author Clive TCHOKOUANDEU
 * version 1.0
 */
public class API_TAXI1 {
     /**
     * identifiant unique du taxi
   */
    protected int idtaxi;
     /**
     * imatriculation du taxi
   */
    protected String immatriculation;
     /**
     * carburant
   */
    protected String carburant;
     /**
     * prix au Km
   */
    protected float prixkm;
     /**
     * description de l'état du taxi
   */
    protected String description;
    
    /**
 * constructeur par défaut
 */
    public API_TAXI1(){
        
    }
    public API_TAXI1(String immatriculation){
        this.immatriculation = immatriculation;
    }
    
    public API_TAXI1(String immatriculation, String description){
        this.immatriculation = immatriculation;
        this.description = description;
    }

   /**
 * constructeur paramétré
 * @param idtaxi identifiant unique du taxi, affecté par la base de données
 * @param immatriculation l'immatriculation du taxi
 * @param carburant carburant du taxi
 * @param prixkm Prix au Kilomètre
 * @param description décrit l'état du taxi
 */
    public API_TAXI1(int idtaxi, String immatriculation, String carburant, float prixkm, String description) {
        this.idtaxi = idtaxi;
        this.immatriculation = immatriculation;
        this.carburant = carburant;
        this.prixkm = prixkm;
        this.description = description;
    }
 /**
    * getter idtaxi
    * @return identifiant du taxi
    */
    public int getIdtaxi() {
        return idtaxi;
    }
    /**
     * setter idtaxi
     * @param idtaxi identifiant du taxi
     */
    public void setIdtaxi(int idtaxi) {
        this.idtaxi = idtaxi;
    }
/**
    * getter immatriculation
    * @return immatriculation du taxi
    */
    public String getImmatriculation() {
        return immatriculation;
    }
/**
     * setter immatriculation
     * @param immatriculation identifie le taxi
     */
    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }
/**
    * getter carburant
    * @return carburant du taxi
    */
    public String getCarburant() {
        return carburant;
    }
/**
     * setter carburant
     * @param carburant identifie le type de carburant du véhicule
     */
    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }
/**
    * getter prixkm
    * @return prixkm de la comission
    */
    public float getPrixkm() {
        return prixkm;
    }
/**
     * setter prixkm
     * @param prixkm affecte le prix à la commission
     */
    public void setPrixkm(float prixkm) {
        this.prixkm = prixkm;
    }
/**
    * getter description
    * @return description de l'état du taxi
    */
    public String getDescription() {
        return description;
    }
/**
     * setter description
     * @param description affecte une description à l'état du taxi
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    /**
 * méthode toString
 * @return informations complètes
 */
    public String toString() {
        return "Taxi{" + "idtaxi=" + idtaxi + ", immatriculation=" + immatriculation + ", carburant=" + carburant + ", prixkm=" + prixkm + ", desription=" + description + '}';
    }
    
     
}
