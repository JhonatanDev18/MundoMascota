package com.crystal.mundomascota.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.crystal.mundomascota.R;
import com.crystal.mundomascota.clases.Mascota;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MascotasRecyclerViewAdapter extends RecyclerView.Adapter<MascotasRecyclerViewAdapter.MascotasViewHolder>{

    List<Mascota> listaMascotas;

    public MascotasRecyclerViewAdapter(List<Mascota> listaMascotas) {
        this.listaMascotas = listaMascotas;
    }

    @NonNull
    @NotNull
    @Override
    public MascotasViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_mascotas, parent, false);
        return new MascotasRecyclerViewAdapter.MascotasViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull @NotNull MascotasRecyclerViewAdapter.MascotasViewHolder holder, int position) {
        holder.ivFotoMascota.setImageResource(listaMascotas.get(position).getFoto());
        holder.tvNombreMascota.setText(listaMascotas.get(position).getNombre());
        holder.tvCantHuesoLike.setText(Integer.toString(listaMascotas.get(position).getCantHuesoLike()));
    }

    @Override
    public int getItemCount() {
        return listaMascotas.size();
    }

    public static class MascotasViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final View view;
        public final ImageView ivFotoMascota, ivHuesoLikeBlanco, ivHuesoLike;
        public final TextView tvNombreMascota, tvCantHuesoLike;
        public Context contexto;

        public MascotasViewHolder(@NonNull @NotNull View v) {
            super(v);
            view = v;
            contexto = view.getContext();
            ivFotoMascota = view.findViewById(R.id.ivFotoMascota);
            ivHuesoLikeBlanco = view.findViewById(R.id.ivHuesoLikeBlanco);
            tvNombreMascota = view.findViewById(R.id.tvNombreMascota);
            tvCantHuesoLike = view.findViewById(R.id.tvCantHuesoLike);
            ivHuesoLike = view.findViewById(R.id.ivHuesoLike);

            ivHuesoLikeBlanco.setOnClickListener(this);
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.ivHuesoLikeBlanco){
                int cantHuesoLike = Integer.parseInt(tvCantHuesoLike.getText().toString())+1;
                String nombre = tvNombreMascota.getText().toString();
                Toast.makeText(contexto, "Hueso like '"+nombre+"'", Toast.LENGTH_SHORT).show();
                tvCantHuesoLike.setText(Integer.toString(cantHuesoLike));
            }
        }
    }
}
