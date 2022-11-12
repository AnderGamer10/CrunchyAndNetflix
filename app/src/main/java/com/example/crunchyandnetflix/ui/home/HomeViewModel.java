package com.example.crunchyandnetflix.ui.home;

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
import com.example.crunchyandnetflix.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.Random;

public class HomeViewModel extends ViewModel {

    public HomeViewModel() {

    }

    public void mostrarSeries(View root){
        ArrayList<Data> datosArrayAParsear = IntroActivity.listaCompleta;
//        TODO: Un "cartel" random cada vez
        Random r = new Random();
        int randomNumber = r.nextInt(datosArrayAParsear.size());

        Picasso.get().load(datosArrayAParsear.get(randomNumber).getImageMedium()).into((ImageView) root.findViewById(R.id.mainImageView));

//        TODO: Mas populares por "rating"
        ArrayList<SerieItem> dataMasPopular = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            datosArrayAParsear.removeIf(o -> Objects.equals(o.getRating(), "null"));
            datosArrayAParsear.sort(Comparator.comparing(Data::getRating));
        }
        Collections.reverse(datosArrayAParsear);

        for (int i = 0; i < 10; i++){
            dataMasPopular.add(new SerieItem(datosArrayAParsear.get(i).getId(), datosArrayAParsear.get(i).getName(), datosArrayAParsear.get(i).getImageMedium(),datosArrayAParsear.get(i).getRating()));
        }
        RecyclerView recyclerView = root.findViewById(R.id.listMasPopulares);
        ItemAdapter itemAdapter = new ItemAdapter(root.getContext(), dataMasPopular);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(root.getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(itemAdapter);
    }
}
