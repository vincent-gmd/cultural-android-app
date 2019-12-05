package com.example.culturaladriodapp.dao;

import android.content.Context;

import com.example.culturaladriodapp.dao.helpers.DaoHelper;
import com.example.culturaladriodapp.model.dto.api.Artist;

public class ArtistDao extends DaoHelper<Artist> {
    public ArtistDao(Context c) {
        super(c, Artist.class);
    }
}
