package com.example.bricohouse.bean;


import java.io.Serializable;
import java.math.BigDecimal;

public class DemandeHandyMan implements Serializable {

    private Long id;
    private BigDecimal nbrHeures;
    private BigDecimal nbrHandyMan;
    private HandymanType handymanType;
    private DemandeService demandeService;

    public DemandeHandyMan(BigDecimal nbrHeures, BigDecimal nbrHandyMan, HandymanType handymanType, DemandeService demandeService) {
        this.nbrHeures = nbrHeures;
        this.nbrHandyMan = nbrHandyMan;
        this.handymanType = handymanType;
        this.demandeService = demandeService;
    }

    public DemandeService getDemandeService() {
        return demandeService;
    }

    public void setDemandeService(DemandeService demandeService) {
        this.demandeService = demandeService;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getNbrHeures() {
        if(nbrHeures == null){
            nbrHeures = new BigDecimal(0);
        }
        return nbrHeures;
    }

    public void setNbrHeures(BigDecimal nbrHeures) {
        this.nbrHeures = nbrHeures;
    }

    public BigDecimal getNbrHandyMan() {
        if(nbrHandyMan == null){
            nbrHandyMan = new BigDecimal(0);
        }
        return nbrHandyMan;
    }

    public void setNbrHandyMan(BigDecimal nbrHandyMan) {
        this.nbrHandyMan = nbrHandyMan;
    }

    public HandymanType getHandymanType() {
        return handymanType;
    }

    public void setHandymanType(HandymanType handymanType) {
        this.handymanType = handymanType;
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
        if (!(object instanceof DemandeHandyMan)) {
            return false;
        }
        DemandeHandyMan other = (DemandeHandyMan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.DemandeHandyMan[ id=" + id + " ]";
    }
}
