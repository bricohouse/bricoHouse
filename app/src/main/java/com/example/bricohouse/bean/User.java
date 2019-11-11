package com.example.bricohouse.bean;

import java.io.Serializable;

public class User implements Serializable {
    private Long id;
    private String login;
    private String password;
    private String typeCompte;

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public User(String login, String password, String typeCompte) {
        this.login = login;
        this.password = password;
        this.typeCompte = typeCompte;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", typeCompte=" + typeCompte +
                '}';
    }
}
