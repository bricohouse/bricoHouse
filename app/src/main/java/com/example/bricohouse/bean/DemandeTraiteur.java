package com.example.bricohouse.bean;

import java.io.Serializable;
import java.util.List;

public class DemandeTraiteur implements Serializable {

    private Long id;
    private int nbrTable;
    private EventType eventType;
    private DemandeService demandeService;
    private List<ListPlat> listPlats;

    public DemandeTraiteur() {
    }

    public DemandeTraiteur(int nbrTable, EventType eventType, DemandeService demandeService, List<ListPlat> listPlats) {
        this.nbrTable = nbrTable;
        this.eventType = eventType;
        this.demandeService = demandeService;
        this.listPlats = listPlats;
    }

    public DemandeTraiteur(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNbrTable() {
        return nbrTable;
    }

    public void setNbrTable(int nbrTable) {
        this.nbrTable = nbrTable;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public DemandeService getDemandeService() {
        return demandeService;
    }

    public void setDemandeService(DemandeService demandeService) {
        this.demandeService = demandeService;
    }

    public List<ListPlat> getListPlats() {
        return listPlats;
    }

    public void setListPlats(List<ListPlat> listPlats) {
        this.listPlats = listPlats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DemandeTraiteur that = (DemandeTraiteur) o;
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
        return "DemandeTraiteur{" +
                "id=" + id +
                ", nbrTable=" + nbrTable +
                ", eventType=" + eventType +
                ", demandeService=" + demandeService +
                ", listPlats=" + listPlats +
                '}';
    }
}
