package com.example.crunchyandnetflix.ui;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.crunchyandnetflix.MainActivity;
import com.example.crunchyandnetflix.Modelos.Data;
import com.example.crunchyandnetflix.Modelos.showConID;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
public class obtencionLista extends MainActivity{

//                        lista.add(j.getString("name"));
//                        JSONObject o = new JSONObject();
//                        String imagen = j.getJSONObject("image").getString("original");
//                        Log.i("Probando imagenes", imagen);
    public ArrayList<Data> getListaCompleta() {
        ArrayList<Data> lista = new ArrayList<>();
        String url = "https://api.tvmaze.com/shows";
        StringRequest postResquest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonObject = new JSONArray(response);
                    for (int i = 0; i < 10; i++) {
                        JSONObject j = jsonObject.getJSONObject(i);
                        lista.add(new Data(j.getInt("id"),j.getString("name"),j.getJSONArray("genres"),j.getJSONObject("rating").getString("average"),j.getJSONObject("image").getString("medium"),j.getJSONObject("image").getString("original"),j.getString("summary")));
                    }
                    for (int i = 0; i < lista.size(); i++) {
                        Log.i("s", String.valueOf(lista.get(i).getGenres()));
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

    public ArrayList<Object> getShowWithId(int id) {
        ArrayList<Object> lista = new ArrayList<>();
        String url = "https://api.tvmaze.com/shows/" + id;
        StringRequest postResquest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonObject = new JSONArray(response);

                    for (int i = 0; i < jsonObject.length(); i++) {
                        JSONObject j = jsonObject.getJSONObject(i);
                        lista.add(j.getString("name"));
                        String imagen = j.getString("image");
                        Log.i("asdasd",imagen);
//                        lista.add(new showConID(j.getString("name"), j.getString("image")));
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
