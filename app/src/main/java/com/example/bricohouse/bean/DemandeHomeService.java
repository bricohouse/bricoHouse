package com.example.bricohouse.bean;

public class DemandeHomeService {
    private Long id;
    private TypeService typeService;
    private DemandeService demandeService;
    private HomeType home;

    public DemandeHomeService() {
    }

    public DemandeHomeService(Long id, TypeService typeService, DemandeService demandeService, Boolean handyman, HomeType home) {
        this.id = id;
        this.typeService = typeService;
        this.demandeService = demandeService;
        this.home = home;
    }

    public DemandeHomeService(TypeService typeService, DemandeService demandeService, Boolean handyman, HomeType home) {
        this.typeService = typeService;
        this.demandeService = demandeService;
        this.home = home;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeService getTypeService() {
        return typeService;
    }

    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }

    public DemandeService getDemandeService() {
        return demandeService;
    }

    public void setDemandeService(DemandeService demandeService) {
        this.demandeService = demandeService;
    }

    public HomeType getHome() {
        return home;
    }

    public void setHome(HomeType home) {
        this.home = home;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DemandeHomeService)) return false;
        DemandeHomeService that = (DemandeHomeService) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "DemandeHomeService{" +
                "id=" + id +
                ", typeService=" + typeService +
                ", demandeService=" + demandeService +
                ", home=" + home +
                '}';
    }
}
