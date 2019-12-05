package com.example.culturaladriodapp.dao.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.culturaladriodapp.model.dto.api.Artist;
import com.example.culturaladriodapp.model.dto.api.LoginDto;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;


public class MyORMLiteHelper extends OrmLiteSqliteOpenHelper{
    private static final String DATABASE_NAME = "cultural";
    private static final int DATABASE_VERSION = 2;
    public MyORMLiteHelper(Context c){
        super(c, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
             TableUtils.createTable(connectionSource, Artist.class);
             TableUtils.createTable(connectionSource, LoginDto.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try {
            TableUtils.dropTable(connectionSource, Artist.class, true);
            TableUtils.dropTable(connectionSource, LoginDto.class, true);
            onCreate(sqLiteDatabase, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
