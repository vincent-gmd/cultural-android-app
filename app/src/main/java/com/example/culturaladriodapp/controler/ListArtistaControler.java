package com.example.culturaladriodapp.controler;

import android.app.Activity;
import android.widget.ListView;
import android.widget.Toast;

import com.example.culturaladriodapp.R;
import com.example.culturaladriodapp.dao.ArtistDao;
import com.example.culturaladriodapp.model.dto.api.Artist;
import com.example.culturaladriodapp.model.dto.api.LegalEntity;
import com.example.culturaladriodapp.model.dto.api.LoginDto;
import com.example.culturaladriodapp.model.dto.api.Person;
import com.example.culturaladriodapp.view.ListArtistaActivity;
import com.example.culturaladriodapp.view.adapter.AdapterArtista;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

public class ListArtistaControler {
    private Activity activity;
    private Boolean online;
    private ListView lvArtista;
    private AdapterArtista adapterArtista;

    private List<Person> personList;
    private List<Artist> artistList;
    private List<LegalEntity> legalList;

    public ListArtistaControler(ListArtistaActivity listArtistaActivity) {
        activity = listArtistaActivity;
        online = activity.getIntent().getBooleanExtra("online", false);
        initComponents();
    }

    private void initComponents() {
        lvArtista=activity.findViewById(R.id.listaArtista);
        personList =new ArrayList<>();
        artistList=new ArrayList<>();
        legalList=new ArrayList<>();
        adapterArtista =new AdapterArtista( personList,activity);
        lvArtista.setAdapter(adapterArtista);
        configListView();
    }

    private void configListView() {
        if (online) {
            queryOnline();
        } else {
            queryOffline();
        }
    }

    private void queryOffline() {
        ArtistDao artistDao = new ArtistDao(activity);
        try {
            updateListArtis( artistDao.getDao().queryForAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateList() {
        personList=new ArrayList<>();
        personList.addAll(artistList);
        personList.addAll(legalList);
        adapterArtista.setList(personList);

    }
    private void updateListArtis(List<Artist> artistList) {
        this.artistList = artistList;
        updateList();
    }
    private void updateListLegal(List<LegalEntity> legalList) {
        this.legalList = legalList;
        updateList();
    }


    private void queryOnline() {

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(activity, "http://10.0.2.2:9080/v1/artist", new AsyncHttpResponseHandler() {

            @Override
            public void onStart() {
                super.onStart();
                Toast.makeText(activity, "Iniciou", Toast.LENGTH_SHORT).show();
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
                    Artist[] artists = gson.fromJson(okJson, Artist[].class);
                    if (artists != null) {
                        updateListArtis( Arrays.asList(artists));
                    } else {
                        Toast.makeText(activity, "artists null not ok", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onRetry(int retryNo) {
                super.onRetry(retryNo);
                Toast.makeText(activity, "Tentativa " + retryNo, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                online = false;
                queryOffline();
                Toast.makeText(activity, "online failure", Toast.LENGTH_SHORT).show();


            }
        });

    }
}
