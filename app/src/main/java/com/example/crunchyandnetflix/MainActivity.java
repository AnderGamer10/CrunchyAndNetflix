package com.example.crunchyandnetflix;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.crunchyandnetflix.Modelos.Data;
import com.example.crunchyandnetflix.ui.obtencionLista;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.crunchyandnetflix.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<Data> listaCompleta = new ArrayList<>();
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getListaCompleta();

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



    }


    public ArrayList<Data> getListaCompleta() {
        String url = "https://api.tvmaze.com/shows";
        StringRequest postResquest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonObject = new JSONArray(response);

                    for (int i = 0; i < jsonObject.length(); i++) {
                        JSONObject j = jsonObject.getJSONObject(i);
                        listaCompleta.add(new Data(j.getInt("id"),j.getString("name"),j.getJSONArray("genres"),j.getJSONObject("rating").getString("average"),j.getJSONObject("image").getString("medium"),j.getJSONObject("image").getString("original"),j.getString("summary")));


//                        TODO: Codigo para obtener los generos(separados) de cada serie
//                        ArrayList<String> exampleList = new ArrayList<String>();
//                        JSONArray genre = j.getJSONArray("genres");
//
//                        for (int a = 0; a < genre.length(); a++) {
//                            exampleList.add((String) genre.get(a));
//                        }
//                        int size = exampleList.size();
//                        String[] stringArray = exampleList.toArray(new String[size]);
//
//                        Log.i("asdfasdass","Output String array will be : ");
//                        for (String s : stringArray) {
//                            Log.i("saaa",s);
//                        }

                    }

//                    TODO: Codigo para obtener las series con mayor valoracion
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                        listaCompleta.removeIf(o -> Objects.equals(o.getRating(), "null"));
//                        listaCompleta.sort((o1,o2)->o1.getRating().compareTo(o2.getRating()));
//                    }
//                    Collections.reverse(listaCompleta);
//                    for (int i = 0; i < 10; i++) {
//                        Log.i("s", String.valueOf(listaCompleta.get(i).getRating()));
//                        Log.i("s", String.valueOf(listaCompleta.get(i).getGenres()));
//                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", error.getMessage());
            }
        });
        Volley.newRequestQueue(this).add(postResquest);

        return listaCompleta;
    }
}