package com.example.pizzeria_v04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class GUI_DetallePizzaCasa extends AppCompatActivity
{
    ImageView img;
    Button btnDetallePizzaCasa;
    Button btnSuma, btnResta;
    TextView tvContador;
    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui__detalle_pizza_casa);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        img = findViewById(R.id.idFotoDetalleCasa);
        btnDetallePizzaCasa = findViewById(R.id.idBtnDetalleCasa);
        btnSuma = findViewById(R.id.idBtnSumaDetallePizzaCasa);
        btnResta = findViewById(R.id.idBtnRestaDetallePizzaCasa);
        tvContador = findViewById(R.id.idTvContador);

        // Evento para pasar a la siguiente VISTA
        btnDetallePizzaCasa.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getApplicationContext(), GUI_PizzaEnCamino.class);
                startActivity(i);
            }
        });

        // Btn SUMA
        btnSuma.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                contador = Integer.parseInt(tvContador.getText().toString());
                contador += 1;
                tvContador.setText(String.valueOf(contador));
            }
        });

        btnResta.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                contador = Integer.parseInt(tvContador.getText().toString());
                if(contador > 0)
                {
                    contador -= 1;
                }
                tvContador.setText(String.valueOf(contador));
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
        //Toast.makeText(this, value+"", Toast.LENGTH_LONG).show();
    }
}
