package com.example.culturaladriodapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.culturaladriodapp.R;
import com.example.culturaladriodapp.controler.ListArtistaControler;

public class ListArtistaActivity extends AppCompatActivity {
    private ListArtistaControler control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_artista);
        control = new ListArtistaControler(this);

    }
}
