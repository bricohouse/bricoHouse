package com.example.bricohouse.bean;

import java.io.Serializable;
import java.util.List;

public class Categorie implements Serializable {

    private Long id;
    private String nom;
    private List<Service> services;


    public Categorie() {
    }

    public Categorie(String nom, List<Service> services) {
        this.nom = nom;
        this.services = services;
    }

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

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
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
        if (!(o instanceof Categorie)) return false;
        Categorie that = (Categorie) o;
        return getId().equals(that.getId()) &&
                getNom().equals(that.getNom());
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
