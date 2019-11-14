package com.example.pizzeria_v04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
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

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Asociamos los id's de los componentes
        edtUsuRegistro = findViewById(R.id.idEdtUsuRegistro);
        edtEmailRegistro = findViewById(R.id.idEdtEmailRegistro);
        edtPassRegistro = findViewById(R.id.idEdtPassRegistro);
        btnRegistro = findViewById(R.id.idBtnRegistro);

        // Mandamos password a la GUI_ConfigUser
        // En GUI_ConfigUser recibirá el pass y podrá acceder, mostrar y
        // modificar los datos del usuario registrado
        /*pass = edtPassRegistro.getText().toString();
        Intent i = new Intent(getApplicationContext(), GUI_ConfigUser.class);
        i.putExtra("password", pass);
        startActivity(i);*/

        // Evento btn GUARDAR registro
        btnRegistro.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Guardamos los datos de los campos en variables
                usuario = edtUsuRegistro.getText().toString().trim();
                email = edtEmailRegistro.getText().toString().trim();
                pass = edtPassRegistro.getText().toString().trim();

                // Entero contador para controlar que el registro esté Ok
                // Si todas las validaciones son correctas ( contador suma 3 )
                // entonces damos paso al panel de opciones
                int registroOk = 0;

                if(camposIsEmpty(usuario, email, pass))
                {
                    registroOk += 1;

                    // Registramos en SharedPreferences
                    SharedPreferences sp = getSharedPreferences(usuario+"data", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();

                    editor.putString("usuario", usuario);

                    if(validarEmail(email))
                    {
                        registroOk += 1;
                        editor.putString("email", email);
                    }
                    else
                    {
                        getToast("Email no válido");
                    }

                    if(validarPassWord(pass))
                    {
                        registroOk += 1;
                        editor.putString("pass", pass);
                    }
                    else
                    {
                        getToast("Introduce una contraseña entre 8 y 16 caracteres.");
                    }

                    editor.commit();

                    if(registroOk == 3)
                    {
                        // Después del registro pasamos al PANEL DE OPCIONES
                        Intent intent = new Intent(getApplicationContext(), GUI_PANEL_OPCIONES.class);
                        startActivity(intent);

                        getToast("Gracias por registrarte, "+usuario);
                    }

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
