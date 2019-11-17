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
        arrayItems.add(new Datos(1,"Carbonara", "Suave crema de nata", R.drawable.img1));
        arrayItems.add(new Datos(2, "Vegetariana", "Para veganos en invierno", R.drawable.img4));
        arrayItems.add(new Datos(3,"Kebab", "Sabores de oriente", R.drawable.pizza6));
        arrayItems.add(new Datos(4,"4 estaciones", "Tierra y mar", R.drawable.pizza7));
        arrayItems.add(new Datos(5,"Boloñesa", "Cremosa y suave", R.drawable.img2));
        arrayItems.add(new Datos(6,"Mejicana", "Para los más atrevidos", R.drawable.img3));
        arrayItems.add(new Datos(7,"Pepperoni", "Toma salami !!!", R.drawable.img5));
        arrayItems.add(new Datos(8,"4 Quesos", "Intenso sabor...", R.drawable.pizza8));

        arrayItems.add(new Datos(9,"Cerveza", "Cerveza mejicana", R.drawable.beer));
        arrayItems.add(new Datos(10, "Cola", "Refresco cola", R.drawable.soda));
        arrayItems.add(new Datos(11,"Agua", "Solo una cabra", R.drawable.water));
        arrayItems.add(new Datos(12,"Doble Burger", "Para los más carnívoros", R.drawable.burger));
        arrayItems.add(new Datos(13,"Cheese Burger", "Cremosa y carnosa", R.drawable.cheeseburger));
        arrayItems.add(new Datos(14,"Muffin frambuesa", "Dulces del bosque", R.drawable.muffin));
        arrayItems.add(new Datos(15,"Bizcocho Gallego", "Extremo dulzor", R.drawable.pancakes));
        arrayItems.add(new Datos(16,"Ensalada", "Ligerito pero rico", R.drawable.salad));

        mAdapter = new DatosAdapter(arrayItems, getApplicationContext());

        // Asociamos el adaptador al recyclerview
        mRecyclerView.setAdapter(mAdapter);
    }
}
