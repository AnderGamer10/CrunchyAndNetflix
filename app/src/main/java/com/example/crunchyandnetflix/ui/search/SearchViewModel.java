package com.example.crunchyandnetflix.ui.search;

import android.view.View;
import android.widget.SearchView;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crunchyandnetflix.Adapter.GenreItemAdapter;
import com.example.crunchyandnetflix.IntroActivity;
import com.example.crunchyandnetflix.Modelos.Data;
import com.example.crunchyandnetflix.Modelos.SerieItem;
import com.example.crunchyandnetflix.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class SearchViewModel extends ViewModel implements SearchView.OnQueryTextListener {
    RecyclerView recyclerView;
    GenreItemAdapter genreItemAdapter;
    LinearLayoutManager linearLayoutManager;
    SearchView searchView;
    public SearchViewModel() {

    }
    public void mostrarSeries(View root){
        ArrayList<Data> datosArrayAParsear = IntroActivity.listaCompleta;
        ArrayList<SerieItem> lista = new ArrayList<>();
        for (int i = 0; i < datosArrayAParsear.size();i++){
            lista.add(new SerieItem(datosArrayAParsear.get(i).getId(), datosArrayAParsear.get(i).getName(), datosArrayAParsear.get(i).getImageMedium(),datosArrayAParsear.get(i).getRating(),datosArrayAParsear.get(i).getGenres(),datosArrayAParsear.get(i).getDescripcion(),datosArrayAParsear.get(i).getStatus(),datosArrayAParsear.get(i).getMediaTiempo(),datosArrayAParsear.get(i).getFechaEstreno(),datosArrayAParsear.get(i).getFechaFinalizacion()));
        }
        recyclerView = root.findViewById(R.id.idSeriesBuscadas);
        genreItemAdapter = new GenreItemAdapter(root.getContext(), lista);
        linearLayoutManager = new LinearLayoutManager(root.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(genreItemAdapter);

        searchView = root.findViewById(R.id.idSearch);
        searchView.setOnQueryTextListener(this);
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        genreItemAdapter.filter(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        genreItemAdapter.filter(newText);
        return false;
    }
}