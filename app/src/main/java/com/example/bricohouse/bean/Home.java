package com.example.bricohouse.bean;

import java.io.Serializable;

public class Home implements Serializable {


    private Long id;
    private int nombrePieces;
    private String piecesType;


    public Home() {
    }

    public Home(int nombrePieces, String piecesType) {
        this.nombrePieces = nombrePieces;
        this.piecesType = piecesType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNombrePieces() {
        return nombrePieces;
    }

    public void setNombrePieces(int nombrePieces) {
        this.nombrePieces = nombrePieces;
    }

    public String getHomeType() {
        return piecesType;
    }

    public void setHomeType(String homeType) {
        this.piecesType = homeType;
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
        if (!(object instanceof Home)) {
            return false;
        }
        Home other = (Home) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Home[ id=" + id + " ]";
    }
}
