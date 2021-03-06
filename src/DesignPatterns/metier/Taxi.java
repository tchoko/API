package DesignPatterns.metier;
import DesignPatterns.metier.builder.*;
import DesignPatterns.metier.Location;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.*;
/**
 *
 * @author Clive TCHOKOUANDEU
 */
public class Taxi {
    private int idtaxi;
    private String immatriculation;
    private String carburant;
    private Double prixkm;
    private Set<Location> location = new HashSet();
    
    private Taxi() {
    this.idtaxi = idtaxi;
    this.immatriculation = immatriculation;
    this.carburant = carburant;
    this.prixkm = prixkm;

    }

    public int getIdtaxi() {
        return idtaxi;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public String getCarburant() {
        return carburant;
    }

    public Double getPrixkm() {
        return prixkm;
    }

    public Set<Location> getLocation() {
        return location;
    }

    public void setIdtaxi(int idtaxi) {
        this.idtaxi = idtaxi;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public void setPrixkm(Double prixkm) {
        this.prixkm = prixkm;
    }


    
    @Override
    public String toString() {
        return "Taxi{" + "idtaxi=" + idtaxi + ", immatriculation=" + immatriculation + ", prixkm=" + prixkm + '}';
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.idtaxi;
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
        final Taxi other = (Taxi) obj;
        if (this.idtaxi != other.idtaxi) {
            return false;
        }
        return true;
    }
   
}
    

