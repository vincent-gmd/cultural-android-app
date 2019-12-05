package com.example.culturaladriodapp.dao;

import android.content.Context;

import com.example.culturaladriodapp.dao.helpers.DaoHelperString;
import com.example.culturaladriodapp.model.dto.api.LoginDto;

public class LoginDao  extends DaoHelperString<LoginDto> {
    public LoginDao(Context c) {
        super(c, LoginDto.class);
    }
}
