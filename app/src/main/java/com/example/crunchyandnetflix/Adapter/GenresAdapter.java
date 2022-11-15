package com.example.crunchyandnetflix.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crunchyandnetflix.GenreActivity;
import com.example.crunchyandnetflix.R;

import java.util.ArrayList;
import java.util.List;

public class GenresAdapter extends RecyclerView.Adapter<GenresAdapter.ViewHolder> {

    private final Context context;
    private final List<String> list;

    public GenresAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.catalogue_card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String model = list.get(position);
        holder.textView.setText(model);
        holder.cardView.setOnClickListener(view -> {
            Intent newActivity = new Intent(context, GenreActivity.class);
            newActivity.putExtra("genero", model);
            context.startActivity(newActivity);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final CardView cardView;
        public ViewHolder(@NonNull View genreView) {
            super(genreView);
            textView = genreView.findViewById(R.id.genreName);
            cardView = genreView.findViewById(R.id.cardGenres);
        }
    }
}
