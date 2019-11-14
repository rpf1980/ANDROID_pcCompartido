package com.example.pizzeria_v04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity
{
    Button btnInitGuiInicio;
    Button btnRegisGuiInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        btnInitGuiInicio = findViewById(R.id.idBtnInitGuiInicio);
        btnRegisGuiInicio = findViewById(R.id.idBtnRegisGuiInicio);

        //Evento btn nos lleva a GUI_INICIO
        btnInitGuiInicio.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getApplicationContext(), GUI_LOGIN.class);
                startActivity(i);
            }
        });

        //Evento btn nos lleva a GUI_REGISTRO
        btnRegisGuiInicio.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getApplicationContext(), GUI_REGISTRO.class);
                startActivity(i);
            }
        });
    }
}
