/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxi.metier;

/**
 *classe métier de gestion de la vue vue_prixtotal_location
 * @author Clive TCHOKOUANDEU
 * version 1.0
 */
public class API_VUE_PRIXTOTAL_LOCATION {
     /**
     * identifiant unique de la location
   */
    protected int idloc;
    
    /**
     * Prix total de la location
   */
    protected int prixtotal;
    
      /**
 * constructeur sans paramétes
 */
    public API_VUE_PRIXTOTAL_LOCATION(){
        
    }
    
     /**
 * constructeur paramétré
 * @param idloc identifiant unique de la location, affecté par la base de données
 * @param prixtotal Prix total de la location
 */
    public API_VUE_PRIXTOTAL_LOCATION( int idloc, int prixtotal){
        this.idloc = idloc;
        this.prixtotal = prixtotal;
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
     * @param idloc identifiant de location
     */
    public void setIdloc(int idloc) {
        this.idloc = idloc;
    }
    
    /**
    * getter prixtotal
    * @return prix total de la course
    */
    public int getPrixtotal() {
        return prixtotal;
    }

    /**
     * setter prixtotal
     * @param prixtotal prix de location
     */
    public void setPrixtotal(int prixtotal) {
        this.prixtotal = prixtotal;
    }

    @Override
     /**
 * méthode toString
 * @return informations complètes
 */
    public String toString() {
        return "API_VUE_PRIXTOTAL_LOCATION{" + "idloc=" + idloc + ", prixtotal=" + prixtotal + '}';
    }
    
    
}
