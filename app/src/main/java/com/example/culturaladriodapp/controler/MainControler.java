package com.example.culturaladriodapp.controler;

import android.app.Activity;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.culturaladriodapp.R;
import com.example.culturaladriodapp.dao.LoginDao;
import com.example.culturaladriodapp.model.dto.api.Artist;
import com.example.culturaladriodapp.model.dto.api.LegalEntity;
import com.example.culturaladriodapp.model.dto.api.LoginDto;
import com.example.culturaladriodapp.model.dto.api.Person;
import com.example.culturaladriodapp.model.dto.api.UserDto;
import com.example.culturaladriodapp.view.CadastraActivity;
import com.example.culturaladriodapp.view.ListArtistaActivity;
import com.example.culturaladriodapp.view.MainActivity;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

public class MainControler {
    private Activity activity;
    private EditText etNome;
    private EditText etSenha;
    private Button btnLogin;
    private Button btnCadasrar;
    private LoginDao loginDao;


    public MainControler(MainActivity mainActivity) {
        activity= mainActivity;
        loginDao = new LoginDao(activity);
        initComponents();
    }

    private void initComponents() {
        etNome=activity.findViewById(R.id.etNome);
        etSenha=activity.findViewById(R.id.etSenha);
        btnLogin=activity.findViewById(R.id.btnLoguin);
        btnCadasrar=activity.findViewById(R.id.btnCadastrar);
    }

    public void loguin() {
        loguinOnline();
    }

    public void cadastrar() {
        Intent it = new Intent(activity, CadastraActivity.class);
        activity.startActivity(it);
    }
    private void desabilitarForm(){
        etNome.setEnabled(false);
        etSenha.setEnabled(false);
        btnLogin.setEnabled(false);
        btnCadasrar.setEnabled(false);

    }

    private void habilitarForm(){
        etNome.setEnabled(true);
        etSenha.setEnabled(true);
        btnLogin.setEnabled(true);
        btnCadasrar.setEnabled(true);

    }

    private void limparDados(){
        etNome.setText("");
        etSenha.setText("");
    }

    private void loguinOnline(){

        final LoginDto loginDto=new LoginDto();
        loginDto.setEmailOrRegistration(etNome.getText().toString());
        loginDto.setPassword(etSenha.getText().toString());
        Gson g = new Gson();

        StringEntity se = null;
        try {
            se = new StringEntity(g.toJson(loginDto));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(activity,"http://10.0.2.2:9080/v1/login", se,"application/json", new AsyncHttpResponseHandler() {

            @Override
            public void onStart() {
                super.onStart();
                Toast.makeText(activity, "Iniciou", Toast.LENGTH_SHORT).show();
                desabilitarForm();
                etNome.setText("...");
                etSenha.setText("...");
            }

            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                //Retorno em String do via cep
                try {
                    String okJson = new String(bytes);
                    Toast.makeText(activity, okJson, Toast.LENGTH_SHORT).show();


                    //Conversão da string json para objeto
                    Gson gson = new Gson();

                    //Conversão direta
                    Person person= null;
                    UserDto u = gson.fromJson(okJson, UserDto.class);
                    Artist user=u.getUser();
                    if (user != null) {
                        if (user.getSubTypeId() == 1969736551||true) {
                            Artist artist = (Artist) user;
                            loguinSucess(artist,loginDto);
                        } else {
                            LegalEntity legalEntity = (LegalEntity) person;
                            loguinSucess(legalEntity,loginDto);
                        }
                    } else {
                        Toast.makeText(activity, "person null not ok", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                habilitarForm();
                limparDados();
            }
            @Override
            public void onRetry(int retryNo) {
                super.onRetry(retryNo);
                Toast.makeText(activity, "Tentativa "+retryNo, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                if(!loguinOfline(loginDto)){
                    Toast.makeText(activity, "loguin failure", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    private boolean loguinOfline(LoginDto loginDto){
        LoginDto loginDtoDb=null;
        try {
            loginDtoDb= loginDao.getDao().queryForId(loginDto.getEmailOrRegistration());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        boolean loginOK;
        if(loginOK=(loginDtoDb!=null&&loginDtoDb.getPassword().equals(loginDto.getPassword()))){
            Intent it = new Intent(activity, ListArtistaActivity.class);
            it.putExtra("online",false);
            activity.startActivity(it);
            Toast.makeText(activity, "loguin ofline", Toast.LENGTH_SHORT).show();
        }
        habilitarForm();
        limparDados();
        return loginOK;

    }
    private void updateLoguin(LoginDto loginDto){
        List<LoginDto> loguins=null;
        try {
            loguins= loginDao.getDao().queryForAll();
            loginDao.getDao().delete(loguins);
            loginDao.getDao().create(loginDto);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void loguinSucess(Artist artist, LoginDto loginDto) {
        updateLoguin(loginDto);

        Toast.makeText(activity, "loguin sucess artist", Toast.LENGTH_SHORT).show();
        Intent it = new Intent(activity, ListArtistaActivity.class);
        it.putExtra("online",true);
        activity.startActivity(it);
    }
    private void loguinSucess(LegalEntity legalEntity, LoginDto loginDto) {
        updateLoguin(loginDto);

        Toast.makeText(activity, "loguin sucess legal", Toast.LENGTH_SHORT).show();
        Intent it = new Intent(activity, ListArtistaActivity.class);
        it.putExtra("online",true);
        activity.startActivity(it);
    }
}
