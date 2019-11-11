package com.example.bricohouse.bean;

import java.io.Serializable;
import java.util.Objects;

public class Employe implements Serializable {

    private Long id;
    private String nom;
    private String prenom;
    private int age;
    private String genre; //  male , female
    private String phone;
    private String adresse;

    public Employe() {
    }

    public Employe(String nom, String prenom, int age, String genre, String phone, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.genre = genre;
        this.phone = phone;
        this.adresse = adresse;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return
                id.equals(employe.id);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
}
