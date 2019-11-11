package com.example.bricohouse.bean;

import java.io.Serializable;
import java.util.Date;


public class Planning implements Serializable {

    private Long id;
    private Date dateDebut;
    private Date dateFin;
    private Date dateOnce;

    public Planning() {
    }

    public Planning(Date dateDebut, Date dateFin, Date dateOnce) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.dateOnce = dateOnce;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Date getDateOnce() {
        return dateOnce;
    }

    public void setDateOnce(Date dateOnce) {
        this.dateOnce = dateOnce;
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
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planning)) {
            return false;
        }
        Planning other = (Planning) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Planning[ id=" + id + " ]";
    }
}
