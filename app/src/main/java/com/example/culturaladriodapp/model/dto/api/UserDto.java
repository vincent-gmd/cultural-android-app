package com.example.culturaladriodapp.model.dto.api;

import java.io.Serializable;

public class UserDto implements Serializable {
    Artist user ;

    public Artist getUser() {
        return user;
    }

    public void setUser(Artist user) {
        this.user = user;
    }
}
