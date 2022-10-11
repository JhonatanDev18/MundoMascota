package com.crystal.mundomascota;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

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
import com.crystal.mundomascota.adapter.PageAdapter;
import com.crystal.mundomascota.clases.Mascota;
import com.crystal.mundomascota.common.Utilidades;
import com.crystal.mundomascota.fragment.InicioFragment;
import com.crystal.mundomascota.fragment.PerfilFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView ivPatitaActionBar;
    TextView tvTituloCantHard;
    List<Mascota> listaMascotas;
    List<Mascota> listaMascotasFavoritas;
    FloatingActionButton fabSubirFotoMascota;
    PageAdapter pageAdapter;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Utilidades.ocultarBarraEstado(getWindow());

        crearMascotas();
        inializar();
        eventos();
        setUpViewPager();
    }

    private ArrayList<Fragment> agregarFragment(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new InicioFragment(listaMascotas));
        fragments.add(new PerfilFragment());

        return fragments;
    }

    private void setUpViewPager(){
        pageAdapter = new PageAdapter(getSupportFragmentManager(), agregarFragment());
        viewPager.setAdapter(pageAdapter);
        tabLayout.setupWithViewPager(viewPager);
        Objects.requireNonNull(tabLayout.getTabAt(0)).setIcon(R.drawable.icon_casaperro);
        Objects.requireNonNull(tabLayout.getTabAt(1)).setIcon(R.drawable.icon_caraperro);
        Objects.requireNonNull(tabLayout.getTabAt(0)).setText(getResources().getString(R.string.tab_inicio));
        Objects.requireNonNull(tabLayout.getTabAt(1)).setText(getResources().getString(R.string.tab_perfil));
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

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        tvTituloCantHard = findViewById(R.id.tvTituloCantHard);
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
        if (item.getItemId() == R.id.mItemMenuContacto) {
            irContacto();
        }else if(item.getItemId() == R.id.mItemMenuAcercaDe){
            irInfoDesarrollador();
        }
        return super.onOptionsItemSelected(item);
    }

    private void irInfoDesarrollador() {
        Intent i = new Intent(MainActivity.this, InfoDesarrolladorActivity.class);
        startActivity(i);
    }

    private void irContacto() {
        Intent i = new Intent(MainActivity.this, EnviarComentarioActivity.class);
        startActivity(i);
    }
}