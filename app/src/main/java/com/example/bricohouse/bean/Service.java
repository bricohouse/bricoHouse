package com.example.bricohouse.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class Service implements Serializable {

    private Long id;
    private String nom;
    private BigDecimal prixService;
    private String details;
    private Categorie categorie;

    public Service() {
    }

    public Service(String nom, Categorie categorie) {
        this.nom = nom;
        this.categorie = categorie;
    }

    public Service(String nom, BigDecimal prixService, String details, Categorie categorie) {
        this.nom = nom;
        this.prixService = prixService;
        this.details = details;
        this.categorie = categorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public BigDecimal getPrixService() {
        return prixService;
    }

    public void setPrixService(BigDecimal prixService) {
        this.prixService = prixService;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
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
        if (!(object instanceof Service)) {
            return false;
        }
        Service other = (Service) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nom;
    }



}
