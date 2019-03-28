/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxi.metier;

/**
 *classe métier de gestion d'une adresse
 * @author Clive TCHOKOUANDEU
 * version 1.0
 */
public class API_ADRESSE1 {
     /**
     * identifiant unique de l'adresse
   */
    protected int idadr;
     /**
     * code postal 
   */
    protected String cp;
     /**
     * localité
   */
    protected String localite;
     /**
     * rue
   */
    protected String rue;
     /**
     * numéro de la rue
   */
    protected String num;
    
    /**
    * constructeur par défaut
    */
    public API_ADRESSE1(){
        
    }

    /**
 * constructeur paramétré
 * @param idadr identifiant unique de l'adresse du client, affecté par la base de données
 * @param cp code postal du client
 * @param localite localité du client
 * @param rue rue du client
 * @param num numéro de l'appartement du client
 */
    public API_ADRESSE1(int idadr, String cp, String localite, String rue, String num) {
        this.idadr = idadr;
        this.cp = cp;
        this.localite = localite;
        this.rue = rue;
        this.num = num;
    }

     /**
    * getter idadr
    * @return idadr identifiant unique de l'adresse
    */
    public int getIdadr() {
        return idadr;
    }

    /**
     * setter idadr
     * @param idadr affecte une adresse 
     */
    public void setIdadr(int idadr) {
        this.idadr = idadr;
    }

     /**
    * getter cp
    * @return cp code postal
    */
    public String getCp() {
        return cp;
    }

    /**
     * setter cp
     * @param cp affecte un code postal
     */
    public void setCp(String cp) {
        this.cp = cp;
    }

     /**
    * getter localite
    * @return localite du client
    */
    public String getLocalite() {
        return localite;
    }

    /**
     * setter localite
     * @param localite affecte une localité
     */
    public void setLocalite(String localite) {
        this.localite = localite;
    }

     /**
    * getter rue
    * @return rue  du client
    */
    public String getRue() {
        return rue;
    }

    /**
     * setter rue
     * @param rue affecte une rue 
     */
    public void setRue(String rue) {
        this.rue = rue;
    }

     /**
    * getter num
    * @return num du client
    */
    public String getNum() {
        return num;
    }

    /**
     * setter num
     * @param num affecte un numéro de la rue
     */
    public void setNum(String num) {
        this.num = num;
    }

    @Override
     /**
       * méthode toString
       * @return informations complètes
      */
    public String toString() {
        return "API_ADRESSE1{" + "idadr=" + idadr + ", cp=" + cp + ", localite=" + localite + ", rue=" + rue + ", num=" + num + '}';
    }
    
}
