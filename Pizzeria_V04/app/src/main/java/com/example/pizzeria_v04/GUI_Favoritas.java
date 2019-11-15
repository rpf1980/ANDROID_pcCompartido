package com.example.pizzeria_v04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import java.util.ArrayList;

public class GUI_Favoritas extends AppCompatActivity
{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui__favoritas);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Referenciamos al RecyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        // Mejoramos rendimiento con esta configuración
        mRecyclerView.setHasFixedSize(true);
        // Creamos un LinearLayoutManager para gestionar el item.xml creado antes
        mLayoutManager = new LinearLayoutManager(this);
        // Lo asociamos al RecyclerView
        mRecyclerView.setLayoutManager(mLayoutManager);

        SingletonBD singleton = SingletonBD.getInstance();
        ArrayList<Datos> arrayItems = singleton.getPizza();




        mAdapter = new DatosAdapter(arrayItems, getApplicationContext());

        // Asociamos el adaptador al recyclerview
        mRecyclerView.setAdapter(mAdapter);
    }
}
