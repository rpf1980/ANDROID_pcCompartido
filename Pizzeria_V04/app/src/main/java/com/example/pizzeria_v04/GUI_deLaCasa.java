package com.example.pizzeria_v04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class GUI_deLaCasa extends AppCompatActivity
{
    ListView listaDatos;
    ArrayList<Datos> Lista;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui_de_la_casa);

        /*listaDatos = findViewById(R.id.lstDatos);

        // Lista de Objetos Datos
        Lista = new ArrayList<Datos>();

        // Cargar datos a la lista
        Lista.add(new Datos(1, "Boloñesa", "Pizza extra de mozzarella", R.drawable.img1));
        Lista.add(new Datos(2, "Vegetariana", "Ideal para veganos", R.drawable.img2));
        Lista.add(new Datos(3, "Barbacoa", "Para los amantes del ketchup", R.drawable.img3));

        Adaptador miadaptador = new Adaptador(getApplicationContext(), Lista);
        listaDatos.setAdapter(miadaptador);

        listaDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Obj tendrá todoel objeto en la posición indicada
                Datos obj = (Datos) parent.getItemAtPosition(position);

                //Vamos a otra Actividad para mostrar el detalle

            }
        });*/

    }
}
