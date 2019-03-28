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
    protected int idadr;
    protected String cp;
    protected String localite;
    protected String rue;
    protected String num;
    
    public API_ADRESSE1(){
        
    }

    public API_ADRESSE1(int idadr, String cp, String localite, String rue, String num) {
        this.idadr = idadr;
        this.cp = cp;
        this.localite = localite;
        this.rue = rue;
        this.num = num;
    }

    public int getIdadr() {
        return idadr;
    }

    public void setIdadr(int idadr) {
        this.idadr = idadr;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getLocalite() {
        return localite;
    }

    public void setLocalite(String localite) {
        this.localite = localite;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "API_ADRESSE1{" + "idadr=" + idadr + ", cp=" + cp + ", localite=" + localite + ", rue=" + rue + ", num=" + num + '}';
    }
    
}
