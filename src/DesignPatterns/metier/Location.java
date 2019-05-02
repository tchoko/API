
package DesignPatterns.metier;
import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Clive TCHOKOUANDEU
 */
public class Location {
    private int idloc;
    private Date dateloc;
    private int kmtotal;
    private Double acompte;
    private Double total;
    private Adresse adrDebut;
    private Adresse adrFin;
    private Client client;
    private Taxi vehicule;
    
    public Location(int idloc, Date dateloc, int kmtotal, Double acompte, Double total){
        this.idloc = idloc;
        this.dateloc = dateloc;
        this.kmtotal = kmtotal;
        this.acompte = acompte;
        this.total = total;
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
    
}
