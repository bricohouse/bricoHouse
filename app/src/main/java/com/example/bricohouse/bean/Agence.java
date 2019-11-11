package com.example.bricohouse.bean;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Agence implements Serializable {


    private Long id;
    private String email;
    private String nom;
    private int nombreEmploye;
    private String siteWeb;
    private String phone;
    private String description;
    private String adresseComplement;
    private Ville ville;
    private Secteur secteur;
    private Service service;
    private List<Employe> employes;
    private User user;
    private List<DemandeService> demandeServices;


    public Agence() {
    }

    public Agence(String email, String nom, int nombreEmploye, String siteWeb, String phone, String description, String adresseComplement, Ville ville, Secteur secteur, User user) {
        this.email = email;
        this.nom = nom;
        this.nombreEmploye = nombreEmploye;
        this.siteWeb = siteWeb;
        this.phone = phone;
        this.description = description;
        this.adresseComplement = adresseComplement;
        this.ville = ville;
        this.secteur = secteur;
        this.user = user;
    }

    public Agence(String email, String nom, int nombreEmploye, String siteWeb, String phone, String description, String adresseComplement, Ville ville, Secteur secteur, Service service, List<Employe> employes, User user, List<DemandeService> demandeServices) {
        this.email = email;
        this.nom = nom;
        this.nombreEmploye = nombreEmploye;
        this.siteWeb = siteWeb;
        this.phone = phone;
        this.description = description;
        this.adresseComplement = adresseComplement;
        this.ville = ville;
        this.secteur = secteur;
        this.service = service;
        this.employes = employes;
        this.user = user;
        this.demandeServices = demandeServices;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresseComplement() {
        return adresseComplement;
    }

    public void setAdresseComplement(String adresseComplement) {
        this.adresseComplement = adresseComplement;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNombreEmploye() {
        return nombreEmploye;
    }

    public void setNombreEmploye(int nombreEmploye) {
        this.nombreEmploye = nombreEmploye;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<DemandeService> getDemandeServices() {
        return demandeServices;
    }

    public void setDemandeServices(List<DemandeService> demandeServices) {
        this.demandeServices = demandeServices;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Agence other = (Agence) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return nom;
    }

}
