package com.example.pizzeria_v04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
    CheckBox checkCasa;
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
        checkCasa = findViewById(R.id.idCheckMarcaFavorita);

        final ArrayList<Datos> arrayItems = new ArrayList<Datos>();

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

        // Recuperamos el item clicado
        final int value = getIntent().getExtras().getInt("idpizza");
        img.setImageResource(arrayItems.get(value-1).getImagen());
        //Toast.makeText(this, value+"", Toast.LENGTH_LONG).show();

        // Evento para pasar a la siguiente VISTA
        btnDetallePizzaCasa.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                if(checkCasa.isChecked())
                {
                    SingletonBD singleton = SingletonBD.getInstance();
                    singleton.AddPizza(arrayItems.get(value-1));
                }
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


    }
}
