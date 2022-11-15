package com.example.crunchyandnetflix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.crunchyandnetflix.Adapter.GenreItemAdapter;
import com.example.crunchyandnetflix.Modelos.Data;
import com.example.crunchyandnetflix.Modelos.SerieItem;

import java.util.ArrayList;
import java.util.Objects;

public class GenreActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    GenreItemAdapter genreItemAdapter;
    LinearLayoutManager linearLayoutManager;
    String genero;
    TextView nombreGenero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_genre);

        genero = getIntent().getStringExtra("genero");
        nombreGenero = findViewById(R.id.idTxtNombreGenero);
        nombreGenero.setText(genero);

        ArrayList<Data> datosArrayAParsear = IntroActivity.listaCompleta;

        ArrayList<SerieItem> listGenre = new ArrayList<>();

        for (int i = 0; i < datosArrayAParsear.size();i++){
            for (int j = 0; j < datosArrayAParsear.get(i).getGenres().length;j++){
                if (datosArrayAParsear.get(i).getGenres()[j].equals(genero)){
                    listGenre.add(new SerieItem(datosArrayAParsear.get(i).getId(), datosArrayAParsear.get(i).getName(), datosArrayAParsear.get(i).getImageMedium(),datosArrayAParsear.get(i).getRating(),datosArrayAParsear.get(i).getGenres(),datosArrayAParsear.get(i).getDescripcion(),datosArrayAParsear.get(i).getStatus(),datosArrayAParsear.get(i).getMediaTiempo(),datosArrayAParsear.get(i).getFechaEstreno(),datosArrayAParsear.get(i).getFechaFinalizacion()));
                }
            }
        }

        recyclerView = findViewById(R.id.idGeneroSeries);
        genreItemAdapter = new GenreItemAdapter(this, listGenre);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(genreItemAdapter);


    }
}