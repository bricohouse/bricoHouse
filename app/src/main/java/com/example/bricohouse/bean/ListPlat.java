package com.example.bricohouse.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class ListPlat  implements Serializable {

    private Long id;
    private String nom;
    private BigDecimal prixPlat;

    public ListPlat() {
    }

    public ListPlat(String nom, BigDecimal prixPlat) {
        this.nom = nom;
        this.prixPlat = prixPlat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public BigDecimal getPrixPlat() {
        return prixPlat;
    }

    public void setPrixPlat(BigDecimal prixPlat) {
        this.prixPlat = prixPlat;
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
        if (!(object instanceof ListPlat)) {
            return false;
        }
        ListPlat other = (ListPlat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ListPlat{" + "id=" + id + ", nom=" + nom + '}';
    }
}
