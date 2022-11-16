package com.example.crunchyandnetflix.Adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crunchyandnetflix.Modelos.SerieItem;
import com.example.crunchyandnetflix.R;
import com.example.crunchyandnetflix.SerieActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class GenreItemAdapter extends RecyclerView.Adapter<GenreItemAdapter.ViewHolder> {

    private final Context context;
    private final List<SerieItem> list;
    private final List<SerieItem> listCopia;
    public GenreItemAdapter(Context context, ArrayList<SerieItem> list) {
        this.context = context;
        this.list = list;
        this.listCopia= new ArrayList<>();
        this.listCopia.addAll(list);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.genre_card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SerieItem model = list.get(position);
        holder.nombre.setText(model.getSerieName());
        holder.rating.setText(model.getRating() + " ⭐");
        holder.generos.setText(Arrays.toString(model.getGenres()).replaceAll("\\[|\\]", ""));
        holder.status.setText(model.getStatus());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newActivity = new Intent(context, SerieActivity.class);
                newActivity.putExtra("id", model.getId());
                newActivity.putExtra("serieName", model.getSerieName());
                newActivity.putExtra("imageUrl", model.getImageUrl());
                newActivity.putExtra("rating", model.getRating());
                newActivity.putExtra("genres", model.getGenres());
                newActivity.putExtra("descripcion", model.getDescripcion());
                newActivity.putExtra("status", model.getStatus());
                newActivity.putExtra("mediaTiempo", model.getMediaTiempo());
                newActivity.putExtra("fechaEstreno", model.getFechaEstreno());
                newActivity.putExtra("fechaFinalizacion", model.getFechaFinalizacion());
                context.startActivity(newActivity);
            }
        });
        Picasso.get().load(model.getImageUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final CardView cardView;
        private final TextView nombre, generos, status, rating;

        public ViewHolder(@NonNull View genreView) {
            super(genreView);
            imageView = genreView.findViewById(R.id.idImage);
            nombre = genreView.findViewById(R.id.idName);
            generos = genreView.findViewById(R.id.idAllGenres);
            status = genreView.findViewById(R.id.idStatus);
            rating = genreView.findViewById(R.id.idRating);
            cardView = genreView.findViewById(R.id.cardGenre);

        }
    }

    public void filter(String text) {
        list.clear();
        if(text.isEmpty()){
            list.addAll(listCopia);
        } else{
            text = text.toLowerCase();
            for(SerieItem item: listCopia){
                if(item.getSerieName().toLowerCase().contains(text)){
                    list.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }

}