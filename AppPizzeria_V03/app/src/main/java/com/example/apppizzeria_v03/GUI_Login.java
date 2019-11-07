package com.example.apppizzeria_v03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class GUI_Login extends AppCompatActivity
{
    EditText edtUsuarioLogin;
    EditText edtPassLogin;
    Button btnLogin;
    CheckBox checkLogin;

    String dataPrueba = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui__login);

        edtUsuarioLogin = findViewById(R.id.idEdtUsuarioLogin);
        edtPassLogin = findViewById(R.id.idEdtPassLogin);
        btnLogin = findViewById(R.id.idBtnLogin);
        checkLogin = findViewById(R.id.idCheckBoxLogin);

        btnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String usuario = edtUsuarioLogin.getText().toString();
                String pass = edtPassLogin.getText().toString();
                String usuData = "";
                String passData = "";


                // **AQUÍ**... estoy probando si accedo a los datos registrados en SharedPrefernces
                dataPrueba = reciboDatos();

                getToast(dataPrueba);

                //Comprobamos que el usuario y contraseña estén registrados
                //en File Explorer Device ( data/ data/ .... LOS REGISTROS DE
                //SharedPreferences
            }
        });

    }

    public void getToast(String msg)
    {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    public String reciboDatos()
    {
        String dato = getIntent().getExtras().getString("DatoUsuario");
        return dato;
    }
}
