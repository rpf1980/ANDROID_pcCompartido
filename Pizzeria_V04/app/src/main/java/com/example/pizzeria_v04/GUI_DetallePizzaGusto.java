package com.example.pizzeria_v04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GUI_DetallePizzaGusto extends AppCompatActivity
{
    Button btnDetPizGusto;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui__detalle_pizza_gusto);

        btnDetPizGusto = findViewById(R.id.idBtnDetallesPizzaGusto);

        btnDetPizGusto.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                getToast("Ok click");

                Intent i = new Intent(getApplicationContext(), GUI_PizzaEnCamino.class);
                startActivity(i);
            }
        });
    }

    public void getToast(String msg)
    {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
}
