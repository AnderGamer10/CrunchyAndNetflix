package com.example.crunchyandnetflix.ui.home;

import android.content.Intent;
import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.crunchyandnetflix.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {
//    private final MutableLiveData<String> mText;

    public HomeViewModel() {
//        mText = new MutableLiveData<>();
//        mText.setValue("This is home fragment");
    }

    //    public LiveData<String> getText() {
//        return mText;
//    }
    public interface listas {

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
//                        lista.add(new Universidad(j.getString("name"), j.getString("domains").substring(2,j.getString("domains").length()-2)));
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
        Volley.newRequestQueue(new MainActivity()).add(postResquest);

        return lista;
    }
}
