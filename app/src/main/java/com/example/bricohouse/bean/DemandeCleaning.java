package com.example.bricohouse.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class DemandeCleaning implements Serializable {

    private Long id;
    private DemandeService demandeService;
    private Boolean bringEquipement = false;
    private BigDecimal nbrHeures;
    private BigDecimal nbrCleaner;
    private Home home;
    private TypeCleaning typeCleaning;

    public BigDecimal getNbrCleaner() {
        if(nbrCleaner == null){
            nbrCleaner = new BigDecimal(0);
        }
        return nbrCleaner;
    }

    public void setNbrCleaner(BigDecimal nbrCleaner) {
        this.nbrCleaner = nbrCleaner;
    }

    public DemandeCleaning() {
    }

    public DemandeCleaning(DemandeService demandeService, BigDecimal nbrHeures, Boolean bringEquipement, BigDecimal nbrCleaner, Home home, TypeCleaning typeCleaning) {
        this.demandeService = demandeService;
        this.nbrHeures = nbrHeures;
        this.bringEquipement = bringEquipement;
        this.nbrCleaner = nbrCleaner;
        this.home = home;
        this.typeCleaning = typeCleaning;
    }

    public DemandeService getDemandeService() {
        if(demandeService == null){
            demandeService = new DemandeService();
        }
        return demandeService;
    }

    public void setDemandeService(DemandeService demandeService) {
        this.demandeService = demandeService;
    }

    public BigDecimal getNbrHeures() {
        if(nbrHeures == null){
            nbrHeures = new BigDecimal(0);
        }
        return nbrHeures;
    }

    public void setNbrHeures(BigDecimal nbrHeures) {
        this.nbrHeures = nbrHeures;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public TypeCleaning getTypeCleaning() {
        return typeCleaning;
    }

    public void setTypeCleaning(TypeCleaning typeCleaning) {
        this.typeCleaning = typeCleaning;
    }

    public Boolean getBringEquipement() {
        return bringEquipement;
    }

    public void setBringEquipement(Boolean bringEquipement) {
        this.bringEquipement = bringEquipement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DemandeCleaning)) {
            return false;
        }
        DemandeCleaning other = (DemandeCleaning) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DemandeCleaning{" +
                "id=" + id +
                ", demandeService=" + demandeService +
                ", bringEquipement=" + bringEquipement +
                ", nbrHeures=" + nbrHeures +
                ", nbrCleaner=" + nbrCleaner +
                ", home=" + home +
                ", typeCleaning=" + typeCleaning +
                '}';
    }
}
