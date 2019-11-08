package com.example.pizzeria_v04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class GUI_LOGIN extends AppCompatActivity
{

    EditText edtUsuLogin;
    EditText edtPassLogin;
    Button btnLogin;
    CheckBox checkLogin;

    String usuario, password;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui__login);

        // Asociamos los id's
        edtUsuLogin = findViewById(R.id.idEdtUsuLogin);
        edtPassLogin = findViewById(R.id.idEdtPassLogin);
        btnLogin = findViewById(R.id.idBtnLogin);
        checkLogin = findViewById(R.id.idCheckLogin);

        // Evento btn SIGUIENTE
        btnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                // Guardamos los datos introducidos por el usuario
                usuario = edtUsuLogin.getText().toString();
                password = edtPassLogin.getText().toString();

                // Leemos datos del SharedPreferences
                SharedPreferences sp = getSharedPreferences("MARIAdata", MODE_PRIVATE);
                String usu = sp.getString("usuario", "Error usuario");
                String pass = sp.getString("pass", "Error contraseña");

                // Comprobar que los datos estén en Registrados
                if(usuario.equals(usu) && password.equals(pass))
                {
                    getToast("Usuario registrado");
                }
                else
                {
                    getToast("Compruebe nombre y contraseña");
                }
            }
        });
    }

    // Método TOAST
    public void getToast(String msg)
    {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
}
