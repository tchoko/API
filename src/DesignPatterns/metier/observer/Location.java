
package DesignPatterns.metier.observer;
import DesignPatterns.metier.*;
import DesignPatterns.metier.builder.Taxi;
import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Clive TCHOKOUANDEU
 */
public class Location extends Subject{
    private int idloc;
    private String dateloc;
    private int kmtotal;
    private Double acompte;
    private Double total;
    private Adresse adrDebut;
    private Adresse adrFin;
    private Client client;
    private Taxi vehicule;
    
    public Location(int idloc, String dateloc, int kmtotal, Double acompte, Double total){
        this.idloc = idloc;
        this.dateloc = dateloc;
        this.kmtotal = kmtotal;
        this.acompte = acompte;
        this.total = total;
    }
    public Location(int idloc, String dateloc, int kmtotal, Double acompte, Double total,Client client){
        this.idloc = idloc;
        this.dateloc = dateloc;
        this.kmtotal = kmtotal;
        this.acompte = acompte;
        this.total = total;
        this.client = client;
    }

    Location(int idloc, String dateloc, double acompte, double total) {
        this.idloc = idloc;
        this.dateloc = dateloc;
        this.acompte = acompte;
        this.total = total;
    }

    public int getIdloc() {
        return idloc;
    }

    public void setIdloc(int idloc) {
        this.idloc = idloc;
        notifyObservers();
    }

    public String getDateloc() {
        return dateloc;
    }

    public void setDateloc(String dateloc) {
        this.dateloc = dateloc;
    }

    public int getKmtotal() {
        return kmtotal;
    }

    public void setKmtotal(int kmtotal) {
        this.kmtotal = kmtotal;
    }

    public Double getAcompte() {
        return acompte;
    }

    public void setAcompte(Double acompte) {
        this.acompte = acompte;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Adresse getAdrDebut() {
        return adrDebut;
    }

    public void setAdrDebut(Adresse adrDebut) {
        this.adrDebut = adrDebut;
    }

    public Adresse getAdrFin() {
        return adrFin;
    }

    public void setAdrFin(Adresse adrFin) {
        this.adrFin = adrFin;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Taxi getVehicule() {
        return vehicule;
    }

    public void setVehicule(Taxi vehicule) {
        this.vehicule = vehicule;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.idloc;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Location other = (Location) obj;
        if (this.idloc != other.idloc) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Location{" + "idloc=" + idloc + ", dateloc=" + dateloc + ", kmtotal=" + kmtotal + ", acompte=" + acompte + ", total=" + total + ", adrDebut=" + adrDebut + ", adrFin=" + adrFin + ", client=" + client + ", vehicule=" + vehicule + '}';
    }

    @Override
    public String getNotification() {
         return "nouvelle location avec pour nouvel id = "+idloc;
    }
}
