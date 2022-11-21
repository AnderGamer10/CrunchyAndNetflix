package com.example.crunchyandnetflix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SerieActivity extends AppCompatActivity {
    String[] genres;
    String  name, image,rating, descripcion, status, mediaTiempo, fechaEstreno,fechaFinalizacion;
    TextView txtGeneros, txtNombre, txtStatus, txtMediaTiempo, txtFechaEstreno, txtFechaFinalizacion, txtDescripcion;
    ImageView mainImageView;
    ImageButton favoriteButtton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_serie);

        txtGeneros = findViewById(R.id.idTxtGeneros);
        txtNombre = findViewById(R.id.idTxtNombre);
        txtStatus = findViewById(R.id.idTxtStatus);
        txtMediaTiempo = findViewById(R.id.idTxtMediaTiempo);
        txtFechaEstreno = findViewById(R.id.idTxtFechaEstreno);
        txtFechaFinalizacion = findViewById(R.id.idTxtFechaFinalizacion);
        txtDescripcion = findViewById(R.id.idTxtDescripcion);

        favoriteButtton = findViewById(R.id.idFavoritebtn);
        mainImageView = findViewById(R.id.mainImageView);

        name = getIntent().getStringExtra("serieName");
        image = getIntent().getStringExtra("imageUrl");
        rating = getIntent().getStringExtra("rating");
        genres = getIntent().getStringArrayExtra("genres");
        descripcion = getIntent().getStringExtra("descripcion");
        status = getIntent().getStringExtra("status");
        mediaTiempo = getIntent().getStringExtra("mediaTiempo");
        fechaEstreno = getIntent().getStringExtra("fechaEstreno");
        fechaFinalizacion = getIntent().getStringExtra("fechaFinalizacion");

        Picasso.get().load(image).into(mainImageView);
        txtNombre.setText(name + "  " + rating + " ⭐");
        txtStatus.setText("Estado: " + status);
        txtMediaTiempo.setText("Media (mins/ep): " + mediaTiempo + " mins");
        txtFechaEstreno.setText("Fecha de estreno: " + fechaEstreno);
        if (fechaFinalizacion.equalsIgnoreCase("null")){
            txtFechaFinalizacion.setText("Fecha de finalizacion: Sin finalizar");
        }else{
            txtFechaFinalizacion.setText("Fecha de finalizacion: " + fechaFinalizacion);
        }
        txtDescripcion.setText("Descripcion: " + descripcion.replaceAll("<[^>]*>", ""));
        txtGeneros.setText("Generos: " + Arrays.toString(genres).replaceAll("\\[|\\]", ""));

        for (int i = 0; i < IntroActivity.listaFavoritos.size();i++){
            if (IntroActivity.listaFavoritos.get(i).equals(name)){
                favoriteButtton.setImageResource(R.drawable.bookmark_filled);
            }
        }

        favoriteButtton.setOnClickListener(view -> {
            if (favoriteButtton.getDrawable().getConstantState().equals(favoriteButtton.getContext().getDrawable(R.drawable.bookmark).getConstantState())){
                favoriteButtton.setImageResource(R.drawable.bookmark_filled);
                IntroActivity.listaFavoritos.add(name);

                SharedPreferences preferences = getSharedPreferences("favoritos", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                Set<String> set = new HashSet<>();
                set.addAll(IntroActivity.listaFavoritos);
                editor.putStringSet("idList", set);
                editor.apply();

            }else {
                favoriteButtton.setImageResource(R.drawable.bookmark);
                for (int i = 0; i < IntroActivity.listaFavoritos.size();i++){
                    if (IntroActivity.listaFavoritos.get(i).equals(name)){
                        IntroActivity.listaFavoritos.remove(i);
                        SharedPreferences preferences = getSharedPreferences("favoritos", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        Set<String> set = new HashSet<>();
                        set.addAll(IntroActivity.listaFavoritos);
                        editor.putStringSet("idList", set);
                        editor.apply();
                        break;
                    }
                }
            }
        });
    }
}