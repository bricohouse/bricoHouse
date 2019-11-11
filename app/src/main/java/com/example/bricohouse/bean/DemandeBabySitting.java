package com.example.bricohouse.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class DemandeBabySitting implements Serializable {


    private Long id;
    private DemandeService demandeService;
    private BigDecimal nbrHeures;
    private BigDecimal nbrKids;
    private IntervalOfAge intervalOfAge;
    private int genre; // 1= mal, 2= femmal
    private Boolean fulltime;

    public Boolean getFulltime() {
        return fulltime;
    }

    public void setFulltime(Boolean fulltime) {
        this.fulltime = fulltime;
    }

    public DemandeBabySitting() {
    }

    public DemandeBabySitting(DemandeService demandeService, BigDecimal nbrHeures,IntervalOfAge intervalOfAge, int genre, Boolean fulltime) {
        this.demandeService = demandeService;
        this.nbrHeures = nbrHeures;
        this.nbrKids = nbrKids;
        this.intervalOfAge = intervalOfAge;
        this.genre = genre;
        this.fulltime = fulltime;
    }


    public DemandeService getDemandeService() {
        return demandeService;
    }

    public void setDemandeService(DemandeService demandeService) {
        this.demandeService = demandeService;
    }

    public BigDecimal getNbrHeures() {
        return nbrHeures;
    }

    public void setNbrHeures(BigDecimal nbrHeures) {
        this.nbrHeures = nbrHeures;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getNbrKids() {
        return nbrKids;
    }

    public void setNbrKids(BigDecimal nbrKids) {
        this.nbrKids = nbrKids;
    }

    public IntervalOfAge getIntervalOfAge() {
        return intervalOfAge;
    }

    public void setIntervalOfAge(IntervalOfAge intervalOfAge) {
        this.intervalOfAge = intervalOfAge;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
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
        if (!(object instanceof DemandeBabySitting)) {
            return false;
        }
        DemandeBabySitting other = (DemandeBabySitting) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DemandeBabySitting{" + "id=" + id + ", nbrHeures=" + nbrHeures + ", fulltime=" + fulltime + '}';
    }
}
