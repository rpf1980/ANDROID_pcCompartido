package com.example.pizzeria_v04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class GUI_PANEL_OPCIONES extends AppCompatActivity
{
    Switch wifi;
    Button btnWeb;
    Button btnPedido;
    Button btnConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui__panel__opciones);

        // Asociamos id's
        wifi = findViewById(R.id.idWifi);
        btnWeb = findViewById(R.id.idBtnWeb);
        btnPedido = findViewById(R.id.idBtnPedido);
        btnConfig = findViewById(R.id.idBtnConfig);

        // Btn WEB
        btnWeb.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Uri uri = Uri.parse("https://www.telepizza.es");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        // Btn PEDIDO
        btnPedido.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });
    }
}
