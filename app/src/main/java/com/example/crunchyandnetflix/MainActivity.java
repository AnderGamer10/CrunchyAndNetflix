package com.example.crunchyandnetflix;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.example.crunchyandnetflix.Adapter.ItemAdapter;
import com.example.crunchyandnetflix.Modelos.SerieItem;
import com.example.crunchyandnetflix.Modelos.Data;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crunchyandnetflix.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());





        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_search, R.id.navigation_catalogue)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

//        TODO: La carga de la api se hace en el activity Intro(antes de iniciar el activity main)
//        Log.i("adasdasdasd", String.valueOf(IntroActivity.listaCompleta.size()));
//        for (Data data : IntroActivity.listaCompleta) {
//            Log.i("adsasd", String.valueOf(data.getRating()));
//        }


        ArrayList<Data> datosArrayAParsear = IntroActivity.listaCompleta;
        ArrayList<SerieItem> dataMasPopular = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            datosArrayAParsear.removeIf(o -> Objects.equals(o.getRating(), "null"));
            datosArrayAParsear.sort(Comparator.comparing(Data::getRating));
        }
        Collections.reverse(datosArrayAParsear);

        for (int i = 0; i < 10; i++){
            dataMasPopular.add(new SerieItem(datosArrayAParsear.get(i).getId(), datosArrayAParsear.get(i).getName(), datosArrayAParsear.get(i).getImageMedium(),datosArrayAParsear.get(i).getRating()));
        }

        for (int i = 0; i < dataMasPopular.size(); i++) {
            Log.i("Seriaza", dataMasPopular.get(i).getSerieName());
            Log.i("Seriaza", dataMasPopular.get(i).getRating());
        }
        RecyclerView recyclerView = findViewById(R.id.listMasPopulares);
        ItemAdapter itemAdapter = new ItemAdapter(this, dataMasPopular);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(itemAdapter);




    }
}