/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxi.metier;

/**
 *classe métier de gestion d'un client
 * @author Clive TCHOKOUANDEU
 * version 1.0
 */
public class API_CLIENT1 {
    /**
     * identifiant unique du client
   */
    protected int idclient;
    /**
   * nom du client
   */
    protected String nom;
    /**
   * prénom du client
   */
    protected String prenom;
    /**
   * téléphone du client
   */
    protected String tel;
    /**
    * constructeur par défaut
 */
    public API_CLIENT1(){
        
    }
/**
 * constructeur paramétré
 * @param idclient identifiant unique du client, affecté par la base de données
 * @param nom nom du client
 * @param prenom prénom du client
 * @param tel téléphone du client
 */
    public API_CLIENT1(int idclient, String nom, String prenom, String tel) {
        this.idclient = idclient;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "API_CLIENT1{" + "idclient=" + idclient + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + '}';
    }
    
}
