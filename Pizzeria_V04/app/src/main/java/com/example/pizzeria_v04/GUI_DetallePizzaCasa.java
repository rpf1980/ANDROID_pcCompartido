package com.example.pizzeria_v04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class GUI_DetallePizzaCasa extends AppCompatActivity
{
    ImageView img;
    Button btnDetallePizzaCasa;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui__detalle_pizza_casa);

        img = findViewById(R.id.idFotoDetalleCasa);
        btnDetallePizzaCasa = findViewById(R.id.idBtnDetalleCasa);

        btnDetallePizzaCasa.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getApplicationContext(), GUI_PizzaEnCamino.class);
                startActivity(i);
            }
        });

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
