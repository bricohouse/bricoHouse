package com.example.bricohouse.bean;

import java.io.Serializable;


    public class DemandeGardening implements Serializable {

        private Long id;
        private DemandeService demandeService;
        private GardeningType gardeningType;
        private HomeType home;
        private boolean extermination;


        public DemandeGardening() {
        }

        public DemandeGardening(DemandeService demandeService, GardeningType gardeningType, HomeType home, boolean extermination) {
            this.demandeService = demandeService;
            this.gardeningType = gardeningType;
            this.home = home;
            this.extermination = extermination;
        }

        public boolean isExtermination() {
            return extermination;
        }

        public void setExtermination(boolean extermination) {
            this.extermination = extermination;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public DemandeService getDemandeService() {
            return demandeService;
        }

        public void setDemandeService(DemandeService demandeService) {
            this.demandeService = demandeService;
        }

        public GardeningType getGardeningType() {
            return gardeningType;
        }

        public void setGardeningType(GardeningType gardeningType) {
            this.gardeningType = gardeningType;
        }

        public HomeType getHome() {
            return home;
        }

        public void setHome(HomeType home) {
            this.home = home;
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
            if (!(object instanceof DemandeGardening)) {
                return false;
            }
            DemandeGardening other = (DemandeGardening) object;
            if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "bean.DemandeGardening[ id=" + id + " ]";
        }

    }


