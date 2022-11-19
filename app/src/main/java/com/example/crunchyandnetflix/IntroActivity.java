package com.example.crunchyandnetflix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.crunchyandnetflix.Modelos.Data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntroActivity extends AppCompatActivity {
    public static ArrayList<Data> listaCompleta = new ArrayList<>();
    public static List<String> listaFavoritos = new ArrayList<>();

    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//            Para poner la aplicacion en modo "NOCHE"
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        progressBar = findViewById(R.id.dataCarga);
        new Task1().execute();
    }

    class Task1 extends AsyncTask<String, Void, String>{
        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
            cargarPreferencias();
            getListaCompleta();
        }
        @Override
        protected String doInBackground(String... strings) {
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(String s) {
            progressBar.setVisibility(View.INVISIBLE);
            Intent newActivity = new Intent(IntroActivity.this, MainActivity.class);
            IntroActivity.this.startActivity(newActivity);
        }
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
                        
//                        TODO: Codigo para obtener los generos(separados) de cada serie
                        JSONArray genres = j.getJSONArray("genres");
                        ArrayList<String> genresList = new ArrayList<>();
                        for (int a = 0; a < genres.length(); a++) {
                            genresList.add((String) genres.get(a));
                        }
                        int size = genresList.size();
                        String[] GenresArray = genresList.toArray(new String[size]);
                        listaCompleta.add(new Data(j.getInt("id"),j.getString("name"),GenresArray,j.getJSONObject("rating").getString("average"),j.getJSONObject("image").getString("medium"),j.getJSONObject("image").getString("original"),j.getString("summary"),j.getString("status"),j.getString("averageRuntime"),j.getString("premiered"),j.getString("ended")));
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

        return listaCompleta;
    }
    private void cargarPreferencias() {
        SharedPreferences preferences = getSharedPreferences("favoritos", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = getSharedPreferences("favoritos", MODE_PRIVATE).edit();
//        editor.clear().apply();
        Set<String> set = preferences.getStringSet("idList", new HashSet<String>());
        listaFavoritos.addAll(set);
        for (int i = 0; i < listaFavoritos.size();i++){
            Log.i("mostrando", listaFavoritos.get(i));
        }
    }
//    SharedPreferences preferences = context.getSharedPreferences("favoritos", Context.MODE_PRIVATE);
//    SharedPreferences.Editor editor = preferences.edit();
//    Set<String> set = new HashSet<>();
//                set.addAll(IntroActivity.listaFavoritos);
//                editor.putStringSet("idList", set);
//                editor.apply();
}