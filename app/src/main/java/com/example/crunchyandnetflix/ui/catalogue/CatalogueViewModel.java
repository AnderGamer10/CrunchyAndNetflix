package com.example.crunchyandnetflix.ui.catalogue;

import android.view.View;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crunchyandnetflix.Adapter.GenresAdapter;
import com.example.crunchyandnetflix.R;

import java.util.ArrayList;

public class CatalogueViewModel extends ViewModel {

    RecyclerView recyclerView;
    GenresAdapter genresAdapter;
    LinearLayoutManager linearLayoutManager;

    public CatalogueViewModel() {

    }


    public void mostrarGeneros(View root){
        ArrayList<String> listGenres = new ArrayList<>();
        listGenres.add("Drama");
        listGenres.add("Action");
        listGenres.add("Horror");
        listGenres.add("Science-Fiction");
        listGenres.add("Thriller");
        listGenres.add("Crime");
        listGenres.add("Romance");
        listGenres.add("Adventure");
        listGenres.add("Music");
        listGenres.add("Comedy");
        listGenres.add("Mystery");
        listGenres.add("Sports");
        listGenres.add("War");
        listGenres.add("Western");
        listGenres.add("Family");
        listGenres.add("Legal");
        listGenres.add("Medical");
        listGenres.add("Espionage");
        listGenres.add("Supernatural");
        listGenres.add("Fantasy");

        recyclerView = root.findViewById(R.id.idTxtMediaTiempo);
        genresAdapter = new GenresAdapter(root.getContext(), listGenres);
        linearLayoutManager = new LinearLayoutManager(root.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(genresAdapter);

    }
}