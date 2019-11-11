package com.example.bricohouse.bean;

import java.io.Serializable;

public class Filiere implements Serializable {

    private Long id;
    private String nom;
    private NiveauScolaire niveauScolaire;

    public Filiere() {
    }

    public Filiere(Long id) {
        this.id = id;
    }

    public Filiere(Long id, String nom, NiveauScolaire niveauScolaire) {
        this.id = id;
        this.nom = nom;
        this.niveauScolaire = niveauScolaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public NiveauScolaire getNiveauScolaire() {
        return niveauScolaire;
    }

    public void setNiveauScolaire(NiveauScolaire niveauScolaire) {
        this.niveauScolaire = niveauScolaire;
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
        if (!(object instanceof Filiere)) {
            return false;
        }
        Filiere other = (Filiere) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Filiere{" + "id=" + id + ", nom=" + nom + '}';
    }

}
