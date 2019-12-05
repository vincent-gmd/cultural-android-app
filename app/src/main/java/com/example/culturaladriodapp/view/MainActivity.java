package com.example.culturaladriodapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.culturaladriodapp.R;
import com.example.culturaladriodapp.controler.MainControler;

public class MainActivity extends AppCompatActivity {
    private MainControler control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        control = new MainControler(this);
    }

    public void loguin(View v){
        control.loguin();
    }
    public void cadastrar(View v){
        control.cadastrar();
    }


}
