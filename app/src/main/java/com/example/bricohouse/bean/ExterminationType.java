package com.example.bricohouse.bean;

import java.io.Serializable;

public class ExterminationType implements Serializable {

    private Long id;
    private String nom;

    public ExterminationType() {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExterminationType)) {
            return false;
        }
        ExterminationType other = (ExterminationType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ExterminationType{" + "id=" + id + ", nom=" + nom + '}';
    }
}
