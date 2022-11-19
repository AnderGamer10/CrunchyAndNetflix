package com.example.crunchyandnetflix.ui.favorite;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crunchyandnetflix.Adapter.GenreItemAdapter;
import com.example.crunchyandnetflix.IntroActivity;
import com.example.crunchyandnetflix.Modelos.Data;
import com.example.crunchyandnetflix.Modelos.SerieItem;
import com.example.crunchyandnetflix.R;

import java.util.ArrayList;

public class FavoriteViewModel extends ViewModel {

    RecyclerView recyclerView;
    GenreItemAdapter genreItemAdapter;
    LinearLayoutManager linearLayoutManager;
    TextView textView;
    public FavoriteViewModel() {

    }


    public void mostrarFavoritos(View root){
        ArrayList<SerieItem> listFavorites = new ArrayList<>();
        ArrayList<Data> datosArrayAParsear = IntroActivity.listaCompleta;
        textView = root.findViewById(R.id.idFavoritosTxt);
        if (IntroActivity.listaFavoritos.size() == 0){
            textView.setText("Favoritos");
        }else {
            for (int i = 0; i < datosArrayAParsear.size();i++){
                for (int j = 0; j < IntroActivity.listaFavoritos.size();j++){
                    if (datosArrayAParsear.get(i).getName().equalsIgnoreCase(IntroActivity.listaFavoritos.get(j))){
                        listFavorites.add(new SerieItem(datosArrayAParsear.get(i).getId(), datosArrayAParsear.get(i).getName(), datosArrayAParsear.get(i).getImageMedium(),datosArrayAParsear.get(i).getRating(),datosArrayAParsear.get(i).getGenres(),datosArrayAParsear.get(i).getDescripcion(),datosArrayAParsear.get(i).getStatus(),datosArrayAParsear.get(i).getMediaTiempo(),datosArrayAParsear.get(i).getFechaEstreno(),datosArrayAParsear.get(i).getFechaFinalizacion()));
                    }
                }
            }
        }

        recyclerView = root.findViewById(R.id.idListFavoritosRc);
        genreItemAdapter = new GenreItemAdapter(root.getContext(), listFavorites);
        linearLayoutManager = new LinearLayoutManager(root.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(genreItemAdapter);
    }
}