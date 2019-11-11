package com.example.bricohouse.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DemandeService implements Serializable {
    private Long id;
    private Date datedemande;
    private Client client;
    private Agence agence;
    private String detail;
    private BigDecimal prixTotal;
    private Service service;
    private Planning planning;
    private Date dateAction;// la date de l'acceptation ou refuser
    private String typeAction; // accepter & refuser


    public DemandeService() {

    }

    public DemandeService(Long id) {
        this.id = id;
    }

    public DemandeService(Long id, Date datedemande, Client client, Agence agence, String detail, BigDecimal prixTotal, Service service, Planning planning, Date dateAction, String typeAction) {
        this.id = id;
        this.datedemande = datedemande;
        this.client = client;
        this.agence = agence;
        this.detail = detail;
        this.prixTotal = prixTotal;
        this.service = service;
        this.planning = planning;
        this.dateAction = dateAction;
        this.typeAction = typeAction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatedemande() {
        return datedemande;
    }

    public void setDatedemande(Date datedemande) {
        this.datedemande = datedemande;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public BigDecimal getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(BigDecimal prixTotal) {
        this.prixTotal = prixTotal;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Planning getPlanning() {
        return planning;
    }

    public void setPlanning(Planning planning) {
        this.planning = planning;
    }

    public Date getDateAction() {
        return dateAction;
    }

    public void setDateAction(Date dateAction) {
        this.dateAction = dateAction;
    }

    public String getTypeAction() {
        return typeAction;
    }

    public void setTypeAction(String typeAction) {
        this.typeAction = typeAction;
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
        if (!(object instanceof DemandeService)) {
            return false;
        }
        DemandeService other = (DemandeService) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DemandeService{" +
                "id=" + id +
                ", datedemande=" + datedemande +
                ", client=" + client +
                ", agence=" + agence +
                ", detail='" + detail + '\'' +
                ", prixTotal=" + prixTotal +
                ", service=" + service +
                ", planning=" + planning +
                ", dateAction=" + dateAction +
                ", typeAction=" + typeAction +
                '}';
    }

}
