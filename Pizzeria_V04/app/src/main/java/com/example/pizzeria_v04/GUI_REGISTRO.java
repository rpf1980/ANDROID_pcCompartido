package com.example.pizzeria_v04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class GUI_REGISTRO extends AppCompatActivity
{
    EditText edtUsuRegistro;
    EditText edtEmailRegistro;
    EditText edtPassRegistro;
    Button btnRegistro;

    String usuario, email, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui__registro);

        //Asociamos los id's de los componentes
        edtUsuRegistro = findViewById(R.id.idEdtUsuRegistro);
        edtEmailRegistro = findViewById(R.id.idEdtEmailRegistro);
        edtPassRegistro = findViewById(R.id.idEdtPassRegistro);
        btnRegistro = findViewById(R.id.idBtnRegistro);

        // Evento btn GUARDAR registro
        btnRegistro.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Guardamos los datos de los campos en variables
                usuario = edtUsuRegistro.getText().toString();
                email = edtEmailRegistro.getText().toString();
                pass = edtPassRegistro.getText().toString();

                if(camposIsEmpty(usuario, email, pass))
                {
                    getToast("Entramos no campos vacíos");

                    // Registramos en SharedPreferences
                    SharedPreferences sp = getSharedPreferences(usuario+"data", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();

                    editor.putString("usuario", usuario);

                    if(validarEmail(email))
                    {
                        editor.putString("email", email);
                    }
                    else
                    {
                        getToast("Email no válido");
                    }

                    if(validarPassWord(pass))
                    {
                        editor.putString("pass", pass);
                    }
                    else
                    {
                        getToast("Introduce una contraseña entre 8 y 16 caracteres.");
                    }

                    editor.commit();
                }
                else
                {
                    getToast("¡Error: campos vacíos!");
                }
            }
        });
    }

    // Método para validar campos no estén VACÍOS
    public boolean camposIsEmpty(String usuario, String email, String pass)
    {
        boolean isEmpty = false;
        if(!usuario.equals("") && !email.equals("") && !pass.equals(""))
        {
            isEmpty = true;
        }

        return isEmpty;
    }

    // Método validar EMAIL
    public boolean validarEmail(String email)
    {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }

    // Método validar PASSWORD
    public boolean validarPassWord(String pass)
    {
        boolean passOk = false;
        if(pass.length() > 8 && pass.length() < 16)
        {
            passOk = true;
        }
        return passOk;
    }

    // Método TOAST
    public void getToast(String str)
    {
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
    }
}
