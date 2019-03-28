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
    protected int idloc;
    protected Date dateloc;
    protected int kmtotal;
    protected float acompte;
    protected float total;
    protected int id_deb;
    protected int id_fin;
    protected int id_taxi;
    protected int id_client;
    
    public API_LOCATION1(){
        
    }

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

    public int getIdloc() {
        return idloc;
    }

    public void setIdloc(int idloc) {
        this.idloc = idloc;
    }

    public Date getDateloc() {
        return dateloc;
    }

    public void setDateloc(Date dateloc) {
        this.dateloc = dateloc;
    }

    public int getKmtotal() {
        return kmtotal;
    }

    public void setKmtotal(int kmtotal) {
        this.kmtotal = kmtotal;
    }

    public float getAcompte() {
        return acompte;
    }

    public void setAcompte(float acompte) {
        this.acompte = acompte;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getId_deb() {
        return id_deb;
    }

    public void setId_deb(int id_deb) {
        this.id_deb = id_deb;
    }

    public int getId_fin() {
        return id_fin;
    }

    public void setId_fin(int id_fin) {
        this.id_fin = id_fin;
    }

    public int getId_taxi() {
        return id_taxi;
    }

    public void setId_taxi(int id_taxi) {
        this.id_taxi = id_taxi;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    @Override
    public String toString() {
        return "API_LOCATION1{" + "idloc=" + idloc + ", dateloc=" + dateloc + ", kmtotal=" + kmtotal + ", acompte=" + acompte + ", total=" + total + ", id_deb=" + id_deb + ", id_fin=" + id_fin + ", id_taxi=" + id_taxi + ", id_client=" + id_client + '}';
    }
    
    
}
