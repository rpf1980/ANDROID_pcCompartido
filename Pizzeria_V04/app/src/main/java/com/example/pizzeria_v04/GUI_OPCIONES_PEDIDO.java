package com.example.pizzeria_v04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class GUI_OPCIONES_PEDIDO extends AppCompatActivity
{
    Button btnDeLaCasa;
    Button btnEligeIngredientes;
    Button btnFavoritaGuiOpcionesPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui__opciones__pedido);

        btnDeLaCasa = findViewById(R.id.idBtnCasaPedido);
        btnEligeIngredientes = findViewById(R.id.idBtnEligeIngredientes);
        btnFavoritaGuiOpcionesPedido = findViewById(R.id.idBtnFavoritaPedido);

    }

    // Evento Btn DE LA CASA
    public void onClickDeCasa(View v)
    {
        Intent intent = new Intent(getApplicationContext(), GUI_deLaCasa.class);
        startActivity(intent);
    }
}
