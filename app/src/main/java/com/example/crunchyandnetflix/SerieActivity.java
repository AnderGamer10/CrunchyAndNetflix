package com.example.crunchyandnetflix;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.Objects;

public class SerieActivity extends AppCompatActivity {
    String[] genres;
    String  name, image,rating, descripcion, status, mediaTiempo, fechaEstreno,fechaFinalizacion;
    TextView txtGeneros, txtNombre, txtStatus, txtMediaTiempo, txtFechaEstreno, txtFechaFinalizacion, txtDescripcion;
    ImageView mainImageView;
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


    }
}