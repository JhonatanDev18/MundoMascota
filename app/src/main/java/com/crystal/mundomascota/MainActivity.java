package com.crystal.mundomascota;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.crystal.mundomascota.adapter.MascotasRecyclerViewAdapter;
import com.crystal.mundomascota.clases.Mascota;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView ivPatitaActionBar;
    TextView tvTituloCantHard;
    RecyclerView rvMascotas;
    MascotasRecyclerViewAdapter adaptador;
    List<Mascota> listaMascotas;
    List<Mascota> listaMascotasFavoritas;
    FloatingActionButton fabSubirFotoMascota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        crearMascotas();
        inializar();
        eventos();

        adaptador = new MascotasRecyclerViewAdapter(listaMascotas);
        rvMascotas.setAdapter(adaptador);
    }

    private void crearMascotas() {
        listaMascotas = new ArrayList<>();
        listaMascotas.add(new Mascota(R.drawable.odie, "Odie", 231, true));
        listaMascotas.add(new Mascota(R.drawable.snoopy, "Snoopy", 199, true));
        listaMascotas.add(new Mascota(R.drawable.slinky, "Slinky", 180, true));
        listaMascotas.add(new Mascota(R.drawable.toto, "Toto", 123, false));
        listaMascotas.add(new Mascota(R.drawable.balto, "Balto", 101, true));
        listaMascotas.add(new Mascota(R.drawable.marley, "Marley", 96, false));
        listaMascotas.add(new Mascota(R.drawable.bolt, "Bolt", 77, true));
        listaMascotas.add(new Mascota(R.drawable.golfo, "Golfo", 23, false));

        listaMascotasFavoritas = new ArrayList<>();
        for (Mascota mascota: listaMascotas) {
            if(mascota.isFavorita()){
                listaMascotasFavoritas.add(mascota);
            }
        }
    }

    private void inializar() {
        ivPatitaActionBar = findViewById(R.id.ivPatitaActionBar);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.ActionBar);
        setSupportActionBar(myToolbar);
        tvTituloCantHard = findViewById(R.id.tvTituloCantHard);
        rvMascotas = findViewById(R.id.rvMascotas);
        rvMascotas.setLayoutManager(new LinearLayoutManager(this));
        fabSubirFotoMascota = findViewById(R.id.fabSubirFotoMascota);
    }

    private void eventos() {
        ivPatitaActionBar.setOnClickListener(this);
        tvTituloCantHard.setOnClickListener(this);
        fabSubirFotoMascota.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.ivPatitaActionBar){
            Toast.makeText(this, "Patita principal", Toast.LENGTH_SHORT).show();
        }else if(v.getId() == R.id.tvTituloCantHard){
            irMascotasFavoritas();
        }else if(v.getId() == R.id.fabSubirFotoMascota){
            //Aca se puede implementar el metodo para abrir la camara.
            Toast.makeText(this, "Abriendo camara...", Toast.LENGTH_SHORT).show();
        }
    }

    private void irMascotasFavoritas() {
        Intent i = new Intent(MainActivity.this, MascotasHardcodeadasActivity.class);
        i.putExtra(getResources().getString(R.string.mascotasFavoritas), (Serializable) listaMascotasFavoritas);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflaterMenu = getMenuInflater();
        inflaterMenu.inflate(R.menu.menuperrito, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.mItemMenuPerrito) {
            Toast.makeText(this, "En construcción menú perrito", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}