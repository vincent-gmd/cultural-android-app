package com.example.culturaladriodapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.culturaladriodapp.R;
import com.example.culturaladriodapp.controler.CadastraControler;

public class CadastraActivity extends AppCompatActivity {
    private CadastraControler control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra);
        control = new CadastraControler(this);

    }
    public void loguin(View v){
        control.loguin();
    }
    public void cadastrar(View v){
        control.cadastrar();
    }
}
