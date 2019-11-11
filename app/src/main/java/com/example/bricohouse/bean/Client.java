package com.example.bricohouse.bean;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Client implements Serializable {

    private Long id;
    private String email;
    private String nom;
    private String prenom;
    private String phone;
    private String adresseComplement;
    private User user;
    private List<DemandeService> demandeServices;



    public Client() {
    }

    public Client(String email, String nom, String prenom, String phone, String adresseComplement, User user) {
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.phone = phone;
        this.adresseComplement = adresseComplement;
        this.user = user;
    }

    public Client(String nom, String prenom, String email, String phone, String adresseComplement) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.phone = phone;
        this.adresseComplement = adresseComplement;
    }

    public Client(String email, String nom, String prenom, String phone, String adresseComplement, Client client, List<DemandeService> demandeServices) {
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.phone = phone;
        this.adresseComplement = adresseComplement;
        this.user = user;
        this.demandeServices = demandeServices;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresseComplement() {
        return adresseComplement;
    }

    public void setAdresseComplement(String adresseComplement) {
        this.adresseComplement = adresseComplement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<DemandeService> getDemandeServices() {
        return demandeServices;
    }

    public void setDemandeServices(List<DemandeService> demandeServices) {
        this.demandeServices = demandeServices;
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
        Client user = (Client) o;
        return id.equals(user.id);
    }

    @Override
    public String toString() {
        return "Client{" +
                "email='" + email + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", phone='" + phone + '\'' +
                ", adresseComplement='" + adresseComplement + '\'' +
                '}';
    }

}
