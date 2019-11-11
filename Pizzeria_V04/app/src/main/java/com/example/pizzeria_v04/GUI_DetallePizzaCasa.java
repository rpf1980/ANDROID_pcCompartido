package com.example.pizzeria_v04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class GUI_DetallePizzaCasa extends AppCompatActivity
{
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui__detalle_pizza_casa);

        img = findViewById(R.id.idFotoDetalleCasa);

        ArrayList<Datos> arrayItems = new ArrayList<Datos>();

        // Vamos a rellenar la lista
        arrayItems.add(new Datos(1,"Boloñesa", "Mejor de la casa", R.drawable.img1));
        arrayItems.add(new Datos(2, "Vegetariana", "Mejor de la casa", R.drawable.img2));
        arrayItems.add(new Datos(3,"Kebab", "Mejor de la casa", R.drawable.img3));

        // Recuperamos el item clicado
        int value = getIntent().getExtras().getInt("idpizza");
        img.setImageResource(arrayItems.get(value-1).getImagen());
        Toast.makeText(this, value+"", Toast.LENGTH_LONG).show();
    }
}
