package com.example.pizzeria_v04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GUI_OPCIONES_PEDIDO extends AppCompatActivity
{
    Button btnDeCasa;
    Button btnEligeIngredientes;
    Button btnFavoritaGuiOpcionesPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui__opciones__pedido);

        btnDeCasa = findViewById(R.id.idBtnOpPediCasa);
        btnEligeIngredientes = findViewById(R.id.idBtnEligeIngredientes);
        btnFavoritaGuiOpcionesPedido = findViewById(R.id.idBtnFavoritaPedido);

        btnDeCasa.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                getToast("De la casa Ok!!");
                /*Intent intent = new Intent(getApplicationContext(), GUI_deLaCasa.class);
                startActivity(intent);*/
            }
        });

    }


    public void getToast(String msg)
    {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
}
