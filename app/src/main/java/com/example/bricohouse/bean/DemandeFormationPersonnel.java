package com.example.bricohouse.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class DemandeFormationPersonnel implements Serializable {

    private Long id;
    private int nbrPersonne;
    private BigDecimal nbrHeurs;
    private Boolean adomicile;
    private DemandeService demandeService;
    private Matiere matiere;
    private Filiere filiere;

    public DemandeFormationPersonnel() {
    }

    public DemandeFormationPersonnel(int nbrPersonne, BigDecimal nbrHeurs, Boolean adomicile, DemandeService demandeService, Matiere matiere, Filiere filiere) {
        this.nbrPersonne = nbrPersonne;
        this.nbrHeurs = nbrHeurs;
        this.adomicile = adomicile;
        this.demandeService = demandeService;
        this.matiere = matiere;
        this.filiere = filiere;
    }

    public BigDecimal getNbrHeurs() {
        return nbrHeurs;
    }

    public void setNbrHeurs(BigDecimal nbrHeurs) {
        this.nbrHeurs = nbrHeurs;
    }

    public int getNbrPersonne() {
        return nbrPersonne;
    }

    public void setNbrPersonne(int nbrpersonne) {
        this.nbrPersonne = nbrpersonne;
    }

    public Boolean getAdomicile() {
        return adomicile;
    }

    public void setAdomicile(Boolean adomicile) {
        this.adomicile = adomicile;
    }

    public DemandeService getDemandeService() {
        if (demandeService == null) {
            demandeService = new DemandeService();
        }
        return demandeService;
    }

    public void setDemandeService(DemandeService demandeService) {
        this.demandeService = demandeService;
    }

    public Matiere getMatiere() {
        if (matiere == null) {
            matiere = new Matiere();
        }
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Filiere getFiliere() {
        if(filiere == null){
            filiere = new Filiere();
        }
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
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
        if (!(object instanceof DemandeFormationPersonnel)) {
            return false;
        }
        DemandeFormationPersonnel other = (DemandeFormationPersonnel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DemandeFormationPersonnel{" +
                "id=" + id +
                ", nbrPersonne=" + nbrPersonne +
                ", nbrHeurs=" + nbrHeurs +
                ", adomicile=" + adomicile +
                ", demandeService=" + demandeService +
                ", matiere=" + matiere +
                ", filiere=" + filiere +
                '}';
    }
}
