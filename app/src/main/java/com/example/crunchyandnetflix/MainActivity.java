package com.example.crunchyandnetflix;

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

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLista();
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
    public ArrayList<Object> getLista() {
        ArrayList<Object> lista = new ArrayList<>();
        String url = "https://api.tvmaze.com/shows";
        StringRequest postResquest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonObject = new JSONArray(response);
//                    jsonObject.sort()

                    for (int i = 0; i < 10; i++) {
                        JSONObject j = jsonObject.getJSONObject(i);
                        lista.add(j.getString("name"));
//                        JSONObject o = new JSONObject();
                        String imagen = j.getJSONObject("image").getString("original");
                        Log.i("asdasd", imagen);
//                        lista.add(new Universidad(j.getString("name"), j.getString("domains").substring(2,j.getString("domains").length()-2)));
                        lista.add(new Data(j.getInt("id"),j.getString("name"),j.getJSONArray("genres"),j.getJSONObject("rating").getString("average"),j.getJSONObject("image").getString("medium"),j.getJSONObject("image").getString("original"),j.getString("summary")));
                    }
                    for (int i = 0; i < lista.size(); i++) {
                        Log.i("s", (String) lista.get(i));
                    }


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

        return lista;
    }
}