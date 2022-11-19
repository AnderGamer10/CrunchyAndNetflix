package com.example.crunchyandnetflix.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crunchyandnetflix.IntroActivity;
import com.example.crunchyandnetflix.Modelos.SerieItem;
import com.example.crunchyandnetflix.SerieActivity;
import com.example.crunchyandnetflix.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private final Context context;
    private final List<SerieItem> list;

    public ItemAdapter(Context context, ArrayList<SerieItem> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.serie_card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SerieItem model = list.get(position);
        Picasso.get().load(model.getImageUrl()).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
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
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.idImages);
        }
    }
}
