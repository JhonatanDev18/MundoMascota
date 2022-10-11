package com.crystal.mundomascota.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crystal.mundomascota.R;
import com.crystal.mundomascota.adapter.MascotasRecyclerViewAdapter;
import com.crystal.mundomascota.clases.Mascota;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class InicioFragment extends Fragment {
    RecyclerView rvMascotas;
    MascotasRecyclerViewAdapter adaptador;
    List<Mascota> listaMascotas;
    View view;

    public InicioFragment(List<Mascota> listaMascotas){
        this.listaMascotas = listaMascotas;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;
        inicializar();
    }

    private void inicializar() {
        rvMascotas = view.findViewById(R.id.rvMascotas);
        rvMascotas.setLayoutManager(new LinearLayoutManager(getContext()));

        adaptador = new MascotasRecyclerViewAdapter(listaMascotas);
        rvMascotas.setAdapter(adaptador);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }
}