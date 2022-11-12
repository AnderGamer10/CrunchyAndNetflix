package com.example.crunchyandnetflix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
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

public class IntroActivity extends AppCompatActivity {
    public static ArrayList<Data> listaCompleta = new ArrayList<>();
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