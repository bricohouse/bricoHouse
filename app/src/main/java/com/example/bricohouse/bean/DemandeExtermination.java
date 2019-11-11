package com.example.bricohouse.bean;

import java.io.Serializable;

public class DemandeExtermination implements Serializable {

    private Long id;
    private DemandeService demandeService;
    private ExterminationType exterminationType;
    private HomeType homeType;

    public DemandeExtermination() {
    }

    public DemandeExtermination(DemandeService demandeService, ExterminationType exterminationType, HomeType home) {
        this.demandeService = demandeService;
        this.exterminationType = exterminationType;
        this.homeType = home;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DemandeService getDemandeService() {
        return demandeService;
    }

    public void setDemandeService(DemandeService demandeService) {
        this.demandeService = demandeService;
    }

    public ExterminationType getExterminationType() {
        return exterminationType;
    }

    public void setExterminationType(ExterminationType exterminationType) {
        this.exterminationType = exterminationType;
    }

    public HomeType getHomeType() {
        return homeType;
    }

    public void setHomeType(HomeType home) {
        this.homeType = home;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DemandeExtermination that = (DemandeExtermination) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "DemandeExtermination{" +
                "id=" + id +
                ", demandeService=" + demandeService +
                ", exterminationType=" + exterminationType +
                ", home=" + homeType +
                '}';
    }
}
