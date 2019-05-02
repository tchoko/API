package DesignPatterns.metier;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
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
    
    public Taxi(int idtaxi, String immatriculation, String carburant, Double prixKm){
        this.idtaxi = idtaxi;
        this.immatriculation = immatriculation;
        this.carburant = carburant;
        this.prixkm = prixkm;
    }

    public int getIdtaxi() {
        return idtaxi;
    }

    public void setIdtaxi(int idtaxi) {
        this.idtaxi = idtaxi;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public Double getPrixkm() {
        return prixkm;
    }

    public void setPrixkm(Double prixkm) {
        this.prixkm = prixkm;
    }

    public Set<Location> getLocation() {
        return location;
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
