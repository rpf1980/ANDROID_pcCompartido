package com.example.pizzeria_v04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GUI_ConfigUser extends AppCompatActivity
{
    EditText edtUserConfig;
    EditText edtEmailConfig;
    EditText edtPassConfig;
    Button btnConfig;

    String nombre, email, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui__config_user);

        edtUserConfig = findViewById(R.id.idEdtConfigNombre);
        edtEmailConfig = findViewById(R.id.idEdtConfigEmail);
        edtPassConfig = findViewById(R.id.idEdtConfigPass);
        btnConfig = findViewById(R.id.idBtnConfig);

        // Cargamos datos en los campos al inicio de APP ( datos del registro del usuario )

        // 1. Traemos nombre del usuario que inicia la app
        Intent recibir = getIntent();
        String dato = recibir.getStringExtra("password");

        getToast(dato.toString());
        // Btn GUARDAR cambios de configuración del usuario

    }

    public void getToast(String msg)
    {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
