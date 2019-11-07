package com.example.apppizzeria_v03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    // Componentes de la App
    Button btnInciarSesion;
    Button btnRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asociamos los id's
        btnInciarSesion = findViewById(R.id.idBtnInitSesionEnInicio);
        btnRegistrarse = findViewById(R.id.btnRegistraseEnInicio);

        // Evento INICIAR SESIÓN
        btnInciarSesion.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), GUI_Login.class);
                startActivity(intent);
            }
        });

        // Evento REGISTRARSE
        btnRegistrarse.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), GUI_Registro.class);
                startActivity(intent);
            }
        });
    }

}
