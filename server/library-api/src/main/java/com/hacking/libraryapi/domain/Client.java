package com.hacking.libraryapi.domain;

public class Client {
    private Integer id;
    private String typeid;
    private String firstName;
    private String secondName;
    private String username;
    private String password;

    public Client(Integer id, String typeid, String firstName, String secondName, String username, String password) {
        this.id = id;
        this.typeid = typeid;
        this.firstName = firstName;
        this.secondName = secondName;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
