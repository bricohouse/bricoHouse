package com.example.bricohouse.bean;

public class DemandePhotographie {

    private Long id;
    private int nbrPhoto;
    private int nbrCamera;
    private int nbrVideographie;
    private EventType eventType;
    private DemandeService demandeService;

    public DemandePhotographie() {
    }

    public DemandePhotographie(int nbrPhoto, int nbrCamera, int nbrVideographie, EventType eventType, DemandeService demandeService) {
        this.nbrPhoto = nbrPhoto;
        this.nbrCamera = nbrCamera;
        this.nbrVideographie = nbrVideographie;
        this.eventType = eventType;
        this.demandeService = demandeService;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNbrPhoto() {
        return nbrPhoto;
    }

    public void setNbrPhoto(int nbrPhoto) {
        this.nbrPhoto = nbrPhoto;
    }

    public int getNbrCamera() {
        return nbrCamera;
    }

    public void setNbrCamera(int nbrCamera) {
        this.nbrCamera = nbrCamera;
    }

    public int getNbrVideographie() {
        return nbrVideographie;
    }

    public void setNbrVideographie(int videographie) {
        this.nbrVideographie = videographie;
    }

    public DemandeService getDemandeService() {
        return demandeService;
    }

    public void setDemandeService(DemandeService demandeService) {
        this.demandeService = demandeService;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DemandePhotographie)) return false;
        DemandePhotographie that = (DemandePhotographie) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "DemandePhotographie{" +
                "id=" + id +
                ", nbrPhoto=" + nbrPhoto +
                ", nbrCamera=" + nbrCamera +
                ", videographie=" + nbrVideographie +
                ", demandeService=" + demandeService +
                '}';
    }
}
