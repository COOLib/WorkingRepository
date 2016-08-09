package com.chisw.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "auth_user")
public class AuthUser {


    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Integer id;

    @Column(name = "login")
    private String login;

    @Column(name = "pass")
    private String pass;

    @Column(name = "site")
    private String site;

    public AuthUser(String login, String pass, String site) {
        this.login = login;
        this.pass = pass;
        this.site = site;
    }

    public AuthUser() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthUser authUser = (AuthUser) o;

        if (login != null ? !login.equals(authUser.login) : authUser.login != null) return false;
        if (pass != null ? !pass.equals(authUser.pass) : authUser.pass != null) return false;
        return site != null ? site.equals(authUser.site) : authUser.site == null;

    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (pass != null ? pass.hashCode() : 0);
        result = 31 * result + (site != null ? site.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AuthUser{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", site='" + site + '\'' +
                '}';
    }
}
