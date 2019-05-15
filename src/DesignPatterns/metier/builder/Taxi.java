package DesignPatterns.metier.builder;
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
    
    private Taxi(TaxiBuilder tb) {
    this.idtaxi = tb.idtaxi;
    this.immatriculation = tb.immatriculation;
    this.carburant = tb.carburant;
    this.prixkm = tb.prixkm;

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
    public static class TaxiBuilder{
        private int idtaxi;
        private String immatriculation;
        private String carburant;
        private Double prixkm;
        
         public TaxiBuilder setIdtaxi(int idtaxi) {
            this.idtaxi = idtaxi;
            return this;
        }
          public TaxiBuilder setImmatriculation(String immatriculation) {
            this.immatriculation = immatriculation;
            return this;
        }
           public TaxiBuilder setCarburant(String carburant) {
            this.carburant = carburant;
            return this;
        }
            public TaxiBuilder setPrixkm(double prixkm) {
            this.prixkm = prixkm;
            return this;
        }
            public Taxi build() throws Exception{
            if(idtaxi<=0 || immatriculation==null || prixkm==null) throw new Exception("informations de construction incomplètes");
            return new Taxi(this);
        }
    }
    
}
