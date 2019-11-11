package com.example.bricohouse.bean;

import java.io.Serializable;
import java.util.Date;

public class DemandeStorage implements Serializable {
    private Long id;
    private Date dateDebut;
    private Date dateFin;
    private int nbrJours;
    private Ville ville;
    private TypeStorage typeStorage;
    private DemandeService demandeService;

    public DemandeStorage() {
    }

    public DemandeStorage(Date dateDebut, Date dateFin, int nbrJours, Ville ville, TypeStorage typeStorage) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbrJours = nbrJours;
        this.ville = ville;
        this.typeStorage = typeStorage;
    }

    public DemandeStorage(Date dateDebut, Date dateFin, int nbrJours, Ville ville, TypeStorage typeStorage, DemandeService demandeService) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbrJours = nbrJours;
        this.ville = ville;
        this.typeStorage = typeStorage;
        this.demandeService = demandeService;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getNbrJours() {
        return nbrJours;
    }

    public void setNbrJours(int nbrJours) {
        this.nbrJours = nbrJours;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public TypeStorage getTypeStorage() {
        return typeStorage;
    }

    public void setTypeStorage(TypeStorage typeStorage) {
        this.typeStorage = typeStorage;
    }

    public DemandeService getDemandeService() {
        return demandeService;
    }

    public void setDemandeService(DemandeService demandeService) {
        this.demandeService = demandeService;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DemandeStorage that = (DemandeStorage) o;
        return id.equals(that.id);
    }

    @Override
    public String toString() {
        return "DemandeStorage{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", nbrJours=" + nbrJours +
                ", ville=" + ville +
                ", typeStorage=" + typeStorage +
                '}';
    }
}
