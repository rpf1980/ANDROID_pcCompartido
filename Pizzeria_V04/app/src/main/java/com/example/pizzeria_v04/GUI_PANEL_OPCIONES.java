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

    String contrasenia = "";
    String contraDelLogin = "";
    String nombFichRegistro = "";
    String nomFichLogin = "";

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

        // Recibimos la CONTRASEÑA que se generó en GUI_REGISTRO
        Intent intentpass = getIntent();
        contrasenia = intentpass.getStringExtra("password");

        // Recibimos la CONTRASEÑA que se escribe en GUI_LOGIN
        Intent intentLoginPass = getIntent();
        contraDelLogin = intentLoginPass.getStringExtra("mandamosPassLogin");

        // Recibimos el del FICHERO XML desde GUI_REGISTRO
        Intent intentFicheroReg = getIntent();
        nombFichRegistro = intentFicheroReg.getStringExtra("nombreFicheroXML");

        // Recibimos el nombre del FICHERO XML desde GUI_LOGIN
        Intent intentNombFichLogin = getIntent();
        nomFichLogin = intentNombFichLogin.getStringExtra("mandamosNombrFichDelLogin");

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
                // Nos llega la contraseña del registro, o bien del login para pasarla
                // a la GUI_ConfigUser

                Intent i = new Intent(getApplicationContext(), GUI_ConfigUser.class);

                // Mandamos la contraseña del campo fichero xml SharedPreferences desde LOGIN y desde REGISTRO
                i.putExtra("mandamosPassRegistro", contrasenia);
                i.putExtra("mandamosPassLogin", contraDelLogin);

                // Mandamos el nombre del fichero xml SharedPreferences desde LOGIN y desde REGISTRO
                i.putExtra("mandamosNomFicheroDesdeLogin", nomFichLogin);
                i.putExtra("mandamosNomFichDesdeRegistro", nombFichRegistro);
                startActivity(i);
            }
        });
    }

    public void getToast(String msg)
    {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
}
