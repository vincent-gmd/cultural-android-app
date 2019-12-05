package com.example.culturaladriodapp.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.culturaladriodapp.R;
import com.example.culturaladriodapp.model.dto.api.Artist;
import com.example.culturaladriodapp.model.dto.api.LegalEntity;
import com.example.culturaladriodapp.model.dto.api.Person;

import java.util.List;

public class AdapterArtista extends BaseAdapter {

    private LayoutInflater inflater;
    private List<Person> listArtist;
    private Context context;

    public AdapterArtista(List<Person> listPessoas, Context context) {
        this.listArtist = listPessoas;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listArtist.size();
    }

    @Override
    public Object getItem(int i) {
        return listArtist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return listArtist.get(i).getId();
    }

    public void add(Person p){
        listArtist.add(p);
        this.notifyDataSetChanged();
    }

    public void remove(Person p){
        listArtist.remove(p);
        this.notifyDataSetChanged();
    }

    public void setList(List<Person> listPessoas){
        this.listArtist = listPessoas;
        this.notifyDataSetChanged();
    }

    @Override
    public View getView(int i, View viewIn, ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.item_listview_artist, null);
        final Person person=listArtist.get(i);
        final Artist artist;
        final LegalEntity legalEntity ;
        ImageView ivIcon = view.findViewById(R.id.ivIcon);
        TextView tvNome = view.findViewById(R.id.tvNome);
        TextView tvEmail = view.findViewById(R.id.tvEmail);

        if(person.getSubTypeId()== 1969736551){
            artist =(Artist) person;
            tvNome.setText(String.format("%s %s", artist.getName(), artist.getLastName()));
            ivIcon.setImageResource(R.drawable.artist);

        } else{
            legalEntity =(LegalEntity) person;
            tvNome.setText(legalEntity.getCompanyName());
            ivIcon.setImageResource(R.drawable.legal_entity);

        }
        tvEmail.setText(String.valueOf(person.getEmail() ));



        //Ao clicar na imagem mostrar um Toast dizendo
        //se é Artist ou LegalEntityr
        ivIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(person.getSubTypeId()== 1969736551){
                    Toast.makeText(context, "Artist", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "LegalEntityr", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

}
