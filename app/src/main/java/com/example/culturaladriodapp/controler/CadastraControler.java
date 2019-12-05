package com.example.culturaladriodapp.controler;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

import com.example.culturaladriodapp.R;
import com.example.culturaladriodapp.view.CadastraActivity;

public class CadastraControler {
    private Activity activity;
    private EditText etNome;
    private EditText etSenha;
    private EditText etEmail;
    private Button btnLogin;
    private Button btnCadasrar;



    public CadastraControler(CadastraActivity cadastraActivity) {
        activity= cadastraActivity;
        initComponents();
    }

    private void initComponents() {
        etNome=activity.findViewById(R.id.etNome);
        etSenha=activity.findViewById(R.id.etSenha);
        etEmail=activity.findViewById(R.id.etEmail);
        btnLogin=activity.findViewById(R.id.btnLoguin);
        btnCadasrar=activity.findViewById(R.id.btnCadastrar);

    }
    private void desabilitarForm(){
        etNome.setEnabled(false);
        etSenha.setEnabled(false);
        etEmail.setEnabled(false);
        btnLogin.setEnabled(false);
        btnCadasrar.setEnabled(false);

    }

    private void habilitarForm(){
        etNome.setEnabled(true);
        etSenha.setEnabled(true);
        etEmail.setEnabled(true);
        btnLogin.setEnabled(true);
        btnCadasrar.setEnabled(true);

    }

    private void limparDados(){
        etNome.setText("");
        etSenha.setText("");
        etEmail.setText("");
    }

    public void loguin() {
        activity.finish();
    }

    public void cadastrar() {

    }


}
