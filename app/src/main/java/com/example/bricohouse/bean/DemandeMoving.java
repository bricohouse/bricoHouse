package com.example.bricohouse.bean;

import java.io.Serializable;

public class DemandeMoving implements Serializable {

    private DemandeService demandeService;
    private Long id;
    private Ville villeDepart;
    private String adresseDepart;
    private Ville villeArrive;
    private String adresseArrive;
    private String typeMoving; //national, international
    private Boolean storage;
    private Boolean handyman;

    public DemandeMoving() {
    }

    public DemandeMoving(DemandeService demandeService, Ville villeDepart, String adresseDepart, Ville villeArrive, String adresseArrive, String typeMoving, Boolean storage, Boolean handyman) {
        this.demandeService = demandeService;
        this.villeDepart = villeDepart;
        this.adresseDepart = adresseDepart;
        this.villeArrive = villeArrive;
        this.adresseArrive = adresseArrive;
        this.typeMoving = typeMoving;
        this.storage = storage;
        this.handyman = handyman;
    }

    public DemandeService getDemandeService() {
        if (demandeService == null) {
            demandeService = new DemandeService();
        }
        return demandeService;
    }

    public void setDemandeService(DemandeService demandeService) {
        this.demandeService = demandeService;
    }

    public Ville getVilleDepart() {
        if (villeDepart == null) {
            villeDepart = new Ville();
        }
        return villeDepart;
    }

    public void setVilleDepart(Ville villeDepart) {
        this.villeDepart = villeDepart;
    }

    public String getAdresseDepart() {
        return adresseDepart;
    }

    public void setAdresseDepart(String adresseDepart) {
        this.adresseDepart = adresseDepart;
    }

    public Ville getVilleArrive() {
        if (villeArrive == null) {
            villeArrive = new Ville();
        }
        return villeArrive;
    }

    public void setVilleArrive(Ville villeArrive) {
        this.villeArrive = villeArrive;
    }

    public String getAdresseArrive() {
        return adresseArrive;
    }

    public void setAdresseArrive(String adresseArrive) {
        this.adresseArrive = adresseArrive;
    }

    public Boolean getStorage() {
        return storage;
    }

    public void setStorage(Boolean storage) {
        this.storage = storage;
    }

    public Boolean getHandyman() {
        return handyman;
    }

    public void setHandyman(Boolean handyman) {
        this.handyman = handyman;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeMoving() {
        return typeMoving;
    }

    public void setTypeMoving(String typeMoving) {
        this.typeMoving = typeMoving;
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
        if (!(object instanceof DemandeMoving)) {
            return false;
        }
        DemandeMoving other = (DemandeMoving) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.DemandeMoving[ id=" + id + " ]";
    }

}
