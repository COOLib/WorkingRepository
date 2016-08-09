package com.chisw.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "token")
public class MyToken {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Integer id;

    @Column(name = "token_body")
    private String tokenBody;

    public MyToken(String tokenBody) {
        this.tokenBody = tokenBody;
    }

    public MyToken() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTokenBody() {
        return tokenBody;
    }

    public void setTokenBody(String tokenBody) {
        this.tokenBody = tokenBody;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyToken myToken = (MyToken) o;

        return tokenBody != null ? tokenBody.equals(myToken.tokenBody) : myToken.tokenBody == null;

    }

    @Override
    public int hashCode() {
        return tokenBody != null ? tokenBody.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "MyToken{" +
                "id=" + id +
                ", tokenBody='" + tokenBody + '\'' +
                '}';
    }
}
