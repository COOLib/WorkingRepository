package com.chisw.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MyResource {

    private long id;
    private String contentName;
    private String contentSurname;

    public MyResource() {
    }

    public MyResource(long id, String contentName, String contentSurname) {
        this.id = id;
        this.contentName = contentName;
        this.contentSurname = contentSurname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    public String getContentSurname() {
        return contentSurname;
    }

    public void setContentSurname(String contentSurname) {
        this.contentSurname = contentSurname;
    }
}
