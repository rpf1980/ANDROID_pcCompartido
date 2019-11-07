package com.example.apppizzeria_v03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class GUI_Registro extends AppCompatActivity
{

    // Componentes de la GUI
    EditText edtUsuarioGuiRegistro;
    EditText edtEmailGuiRegistro;
    EditText edtPassGuiRegistro;
    Button btnGuiRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui__registro);
        //Relacionamos los id's con los componentes de la GUI
        edtUsuarioGuiRegistro = findViewById(R.id.idEdtUsuarioGuiRegistro);
        edtEmailGuiRegistro = findViewById(R.id.idEdtEmailGuiRegistro);
        edtPassGuiRegistro = findViewById(R.id.idEdtPassGuiRegistro);
        btnGuiRegistro = findViewById(R.id.idBtnGuiRegistro);

    }

    // Btn GUARDAR
    public void onClickGuardaRegistro(View v)
    {
        // Guardamos los datos en ámbito Global de Clase
        String usuario = edtUsuarioGuiRegistro.getText().toString();
        String email = edtEmailGuiRegistro.getText().toString();
        String pass = edtPassGuiRegistro.getText().toString();

        if(camposIsEmpty(usuario, email, pass))
        {
            getToast("ENTRAMOS");
            // Preparamos el registro SharedPreferences
            SharedPreferences sp = getSharedPreferences(usuario+"RegisterDATA", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();

            editor.putString("Usuario", usuario);

            if(validarEmail(email))
            {
                editor.putString("Email", email);
            }
            else
            {
                getToast("Email no válido !!!");
            }

            if(validarPassWord(pass))
            {
                editor.putString("Pass", pass);
            }
            else
            {
                getToast("Introduce una contraseña de 8 a 16 caracteres");
            }

            String dataUser = sp.getString("Usuario", "Error pasando usuario");
            String dataPass = sp.getString("Pass", "Error pasando contraseña");

            mandamosDatos(dataUser);

            editor.commit();
        }
        else
        {
            getToast("Error, hay campos vacíos");
        }
    }

    // Método valida campos vacíos
    public boolean camposIsEmpty(String usuario, String email, String pass)
    {
        boolean isEmptyOk = false;

        if(!usuario.equals("") && !email.equals("") && !pass.equals(""))
        {
            isEmptyOk = true;
        }

        return isEmptyOk;
    }

    // Método validar EMAIL
    public boolean validarEmail(String email) {
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

    private void mandamosDatos(String nombreUsuario)
    {
        Intent i = new Intent(GUI_Registro.this, GUI_Login.class);
        i.putExtra("DatoUsuario", nombreUsuario);
        startActivity(i);
    }
}
