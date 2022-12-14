package com.example.crunchyandnetflix.ui.home;

import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crunchyandnetflix.Adapter.ItemAdapter;
import com.example.crunchyandnetflix.IntroActivity;
import com.example.crunchyandnetflix.Modelos.Data;
import com.example.crunchyandnetflix.Modelos.SerieItem;
import com.example.crunchyandnetflix.SerieActivity;
import com.example.crunchyandnetflix.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.Random;

public class HomeViewModel extends ViewModel {
    RecyclerView recyclerView;
    ItemAdapter itemAdapter;
    LinearLayoutManager linearLayoutManager;

    public HomeViewModel() {

    }

    public void mostrarSeries(View root){
        ArrayList<Data> datosArrayAParsear = IntroActivity.listaCompleta;

//        TODO: Mas populares por "rating"
        ArrayList<SerieItem> dataMasPopular = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            datosArrayAParsear.removeIf(o -> Objects.equals(o.getRating(), "null"));
            datosArrayAParsear.sort(Comparator.comparing(Data::getRating));
        }
        Collections.reverse(datosArrayAParsear);

        for (int i = 0; i < 10; i++){
            dataMasPopular.add(new SerieItem(datosArrayAParsear.get(i).getId(), datosArrayAParsear.get(i).getName(), datosArrayAParsear.get(i).getImageMedium(),datosArrayAParsear.get(i).getRating(),datosArrayAParsear.get(i).getGenres(),datosArrayAParsear.get(i).getDescripcion(),datosArrayAParsear.get(i).getStatus(),datosArrayAParsear.get(i).getMediaTiempo(),datosArrayAParsear.get(i).getFechaEstreno(),datosArrayAParsear.get(i).getFechaFinalizacion()));
        }

        recyclerView = root.findViewById(R.id.listMasPopulares);
        itemAdapter = new ItemAdapter(root.getContext(), dataMasPopular);
        linearLayoutManager = new LinearLayoutManager(root.getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(itemAdapter);

//        TODO: Series Anime
        ArrayList<SerieItem> listAnime = new ArrayList<>();
        for (int i = 0; i < datosArrayAParsear.size();i++){
            for (int j = 0; j < datosArrayAParsear.get(i).getGenres().length;j++){
                if (datosArrayAParsear.get(i).getGenres()[j].equals("Anime")){
                    listAnime.add(new SerieItem(datosArrayAParsear.get(i).getId(), datosArrayAParsear.get(i).getName(), datosArrayAParsear.get(i).getImageMedium(),datosArrayAParsear.get(i).getRating(),datosArrayAParsear.get(i).getGenres(),datosArrayAParsear.get(i).getDescripcion(),datosArrayAParsear.get(i).getStatus(),datosArrayAParsear.get(i).getMediaTiempo(),datosArrayAParsear.get(i).getFechaEstreno(),datosArrayAParsear.get(i).getFechaFinalizacion()));
                }
            }
        }
        recyclerView = root.findViewById(R.id.animeList);
        itemAdapter = new ItemAdapter(root.getContext(), listAnime);
        linearLayoutManager = new LinearLayoutManager(root.getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(itemAdapter);

//        TODO: 10 Series de terror/horror random
        ArrayList<SerieItem> listTerror = new ArrayList<>();
        Collections.shuffle(datosArrayAParsear);
        for (int i = 0; i < datosArrayAParsear.size();i++){
            for (int j = 0; j < datosArrayAParsear.get(i).getGenres().length;j++){
                if (datosArrayAParsear.get(i).getGenres()[j].equals("Horror")){
                    listTerror.add(new SerieItem(datosArrayAParsear.get(i).getId(), datosArrayAParsear.get(i).getName(), datosArrayAParsear.get(i).getImageMedium(),datosArrayAParsear.get(i).getRating(),datosArrayAParsear.get(i).getGenres(),datosArrayAParsear.get(i).getDescripcion(),datosArrayAParsear.get(i).getStatus(),datosArrayAParsear.get(i).getMediaTiempo(),datosArrayAParsear.get(i).getFechaEstreno(),datosArrayAParsear.get(i).getFechaFinalizacion()));
                }
            }
        }
        recyclerView = root.findViewById(R.id.horrorList);
        itemAdapter = new ItemAdapter(root.getContext(), listTerror);
        linearLayoutManager = new LinearLayoutManager(root.getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(itemAdapter);


//        TODO: Un "cartel" random cada vez
        Random r = new Random();
        int randomNumber = r.nextInt(datosArrayAParsear.size());

        Picasso.get().load(datosArrayAParsear.get(randomNumber).getImageMedium()).into((ImageView) root.findViewById(R.id.mainImageView));

        ImageView imageView = root.findViewById(R.id.mainImageView);
        imageView.setOnClickListener(view -> {
            Intent newActivity = new Intent(root.getContext(), SerieActivity.class);
            newActivity.putExtra("id", datosArrayAParsear.get(randomNumber).getId());
            newActivity.putExtra("serieName", datosArrayAParsear.get(randomNumber).getName());
            newActivity.putExtra("imageUrl", datosArrayAParsear.get(randomNumber).getImageMedium());
            newActivity.putExtra("rating", datosArrayAParsear.get(randomNumber).getRating());
            newActivity.putExtra("genres", datosArrayAParsear.get(randomNumber).getGenres());
            newActivity.putExtra("descripcion", datosArrayAParsear.get(randomNumber).getDescripcion());
            newActivity.putExtra("status", datosArrayAParsear.get(randomNumber).getStatus());
            newActivity.putExtra("mediaTiempo", datosArrayAParsear.get(randomNumber).getMediaTiempo());
            newActivity.putExtra("fechaEstreno", datosArrayAParsear.get(randomNumber).getFechaEstreno());
            newActivity.putExtra("fechaFinalizacion", datosArrayAParsear.get(randomNumber).getFechaFinalizacion());
            root.getContext().startActivity(newActivity);
        });

    }
}
