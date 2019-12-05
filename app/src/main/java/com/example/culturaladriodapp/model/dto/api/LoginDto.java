package com.example.culturaladriodapp.model.dto.api;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable
public class LoginDto implements Serializable {

    @DatabaseField
    private String password;
    @DatabaseField(id = true)
    private String emailOrRegistration;

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmailOrRegistration() {
        return emailOrRegistration;
    }
    public void setEmailOrRegistration(String emailOrRegistration) {
        this.emailOrRegistration = emailOrRegistration;
    }


}
