package br.com.buylist.models;

import java.util.Date;

/**
 * Created by Igor on 14/03/2016.
 */
public class Account {

    private String id;
    private String name;
    private Date birth;
    private String email;
    private boolean isActive;
    private String token;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirth() {
        return birth;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getToken() {
        return token;
    }
}
