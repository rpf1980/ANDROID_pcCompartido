package com.example.pizzeria_v04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

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

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

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
                Intent i = new Intent(getApplicationContext(), GUI_OPCIONES_PEDIDO.class);
                startActivity(i);
            }
        });

        // Btn CONFIGURACIÓN
        btnConfig.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                // Accedemos al registro SharedPreferences que tenga
                // su campo boleano a true, así sabremos qué usuario es
                // el que está activo

                // Acceder a ficheros xml en SharedPreferences

                // Recorrer con un bucle los xml

                // Hacemos substring sobre los nombres de los ficheros ( substring hasta el punto )

                Intent i = new Intent(getApplicationContext(), GUI_ConfigUser.class);
                startActivity(i);
            }
        });
    }

    public void getToast(String msg)
    {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
}
