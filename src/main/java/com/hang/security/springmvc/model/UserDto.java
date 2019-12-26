package com.hang.security.springmvc.model;

import java.util.Set;

public class UserDto {

    public static final String SESSION_USER_KEY="_user";
    private String id;
    private String username;
    private String password;
    private String fullname;
    private String mobilephone;

    private Set<String> authentices;

    public UserDto() {
    }

    public UserDto(String id, String username, String password, String fullname, String mobilephone , Set<String> authentices) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.mobilephone = mobilephone;
        this.authentices = authentices;
    }

    public Set<String> getAuthentices() {
        return authentices;
    }

    public void setAuthentices(Set<String> authentices) {
        this.authentices = authentices;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }
}
