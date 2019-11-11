package com.example.bricohouse.bean;

import java.io.Serializable;
import java.util.Objects;

public class IntervalOfAge implements Serializable {

    private Long id;
    private String nom;

    public IntervalOfAge() {

    }

    public IntervalOfAge(Long id) {
        this.id = id;
    }

    public IntervalOfAge(Long id, String nom) {
        this.id = id;
        this.nom = nom;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntervalOfAge that = (IntervalOfAge) o;
        return id.equals(that.id) &&
                nom.equals(that.nom);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "IntervalOfAge{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}

