package com.example.pizzeria_v04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class GUI_deLaCasa extends AppCompatActivity
{
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui_de_la_casa);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Referenciamos al RecyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        // Mejoramos rendimiento con esta configuración
        mRecyclerView.setHasFixedSize(true);
        // Creamos un LinearLayoutManager para gestionar el item.xml creado antes
        mLayoutManager = new LinearLayoutManager(this);
        // Lo asociamos al RecyclerView
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<Datos> arrayItems = new ArrayList<Datos>();

        // Vamos a rellenar la lista
        arrayItems.add(new Datos(1,"Boloñesa", "Mejor de la casa", R.drawable.img1));
        arrayItems.add(new Datos(2, "Vegetariana", "Mejor de la casa", R.drawable.img2));
        arrayItems.add(new Datos(3,"Kebab", "Mejor de la casa", R.drawable.img3));

        mAdapter = new DatosAdapter(arrayItems, getApplicationContext());

        // Asociamos el adaptador al recyclerview
        mRecyclerView.setAdapter(mAdapter);
    }
}
