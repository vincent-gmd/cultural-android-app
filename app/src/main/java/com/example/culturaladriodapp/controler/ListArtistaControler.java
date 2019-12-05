package com.example.culturaladriodapp.controler;

import android.app.Activity;

import com.example.culturaladriodapp.model.dto.api.Artist;
import com.example.culturaladriodapp.view.ListArtistaActivity;

import java.util.ArrayList;
import java.util.List;

public class ListArtistaControler {
    private Activity activity;
    private Boolean online;
    private List<Artist> artistList;

    public ListArtistaControler(ListArtistaActivity listArtistaActivity) {
        activity= listArtistaActivity;
        online =activity.getIntent().getBooleanExtra("online",false);
        initComponents();
    }

    private void initComponents() {
        configListView();
    }

    private void configListView() {
        artistList = new ArrayList<>();

    }
}
