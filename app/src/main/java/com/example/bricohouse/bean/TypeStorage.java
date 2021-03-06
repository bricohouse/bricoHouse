package com.example.bricohouse.bean;

import java.io.Serializable;

public class TypeStorage implements Serializable {

    private Long id;
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypeStorage)) return false;
        TypeStorage that = (TypeStorage) o;
        return getId().equals(that.getId()) &&
                getNom().equals(that.getNom());
    }

    @Override
    public String toString() {
        return "TypeStorage{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
