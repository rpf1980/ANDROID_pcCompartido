package com.example.pizzeria_v04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

public class GUI_ConfigUser extends AppCompatActivity
{
    EditText edtViejaPass;
    EditText edtUserConfig;
    EditText edtEmailConfig;
    EditText edtPassConfig;
    Button btnConfig;

    String nombre, email, pass;

    String passDelRegistro = "";
    String nomFicheroDesdeRegistro = "";
    String passDelLogin = "";
    String nomFichDesdeLogin = "";
    boolean semaforo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui__config_user);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        edtViejaPass = findViewById(R.id.idEdtViejaPass);
        edtUserConfig = findViewById(R.id.idEdtConfigNombre);
        edtEmailConfig = findViewById(R.id.idEdtConfigEmail);
        edtPassConfig = findViewById(R.id.idEdtConfigPass);
        btnConfig = findViewById(R.id.idBtnConfig);

        // INTENT que nos trae datos de registro y login
        Intent intenpass = getIntent();

        //Recibimos el string pass desde PANEL OPCIONES ( REGISTRO >> pass >> PANEL OPCIONES >> CONFIGURACION )
        passDelRegistro = intenpass.getStringExtra("mandamosPassRegistro");

        //Recibimos el nombre del FICHERO XML desde PANEL OPCIONES ( a su vez llega desde el LOGIN ==> LOGIN >> PANEL OPIONES >> CONFIGURACION )
        nomFicheroDesdeRegistro = intenpass.getStringExtra("mandamosNomFichDesdeRegistro");

        //Recibimos el nombre del FICHERO XML del registro desde REGISTRO ( a su vez llega desde el REGISTRO ==> REGISTRO >> PANEL OPIONES >> CONFIGURACION )
        nomFichDesdeLogin = intenpass.getStringExtra("mandamosNomFicheroDesdeLogin");

        //Recibimos el string pass desde Login
        passDelLogin = intenpass.getStringExtra("mandamosPassLogin"); // Pass del LOGIN

        btnConfig.setOnClickListener(new View.OnClickListener()
        {
            //En este evento generaremos un nuevo registro del usuario
            @Override
            public void onClick(View v)
            {
                // Comprobamos el usuario logeado
                File carpeta = new File("/data/data/com.example.pizzeria_v04/shared_prefs");
                String[] archivos = carpeta.list();

                //Guardamos vieja contraseña que se introduce en el EditText
                String viejaPass = edtViejaPass.getText().toString().toLowerCase();

                int contador = 1;
                //Recorremos los ficheros que contiene el directorio SharedPreferences
                for(int i = 0; i < archivos.length; i++)
                {
                    SharedPreferences prefs = getApplicationContext().getSharedPreferences(archivos[i].substring(0, archivos[i].indexOf('.'))
                            , Context.MODE_PRIVATE);

                    //Vamos guardando las contraseñas de los xml ubicados en SharedPreferences
                    String strDelPassword = prefs.getString("pass", "pass no encontrado");

                    //Comprobamos que la contraseña vieja coincide con alguna de las que hay registradas en los xml del directorio SharedPreferences
                    if(strDelPassword.equals(viejaPass))
                    {
                        semaforo = true;
                        //Guardamos strings de los campos EditText
                        nombre = edtUserConfig.getText().toString().toLowerCase();
                        email = edtEmailConfig.getText().toString().toLowerCase();
                        pass = edtPassConfig.getText().toString().toLowerCase();
                        String nombreArchivoXml = archivos[i]; //Guardamos nombre del fichero

                        //Instanciamos la clase SharedPreferences para el NUEVO REGISTRO
                        SharedPreferences leemosXml = getSharedPreferences(nombre+"data", MODE_PRIVATE); // Mistro estructura para el nombre del fichero que usamos en REGISTRO ( nombre+data )

                        //Preparamos el editor
                        SharedPreferences.Editor editor = leemosXml.edit();

                        //Registramos los nuevos campos en el fichero
                        editor.putString("usuario", nombre);
                        editor.putString("email", email);
                        editor.putString("pass", pass);
                        editor.apply();

                        // Como hemos encontrado el fichero ( contiene la pass buscada ),
                        // paramos el bucle
                        i = archivos.length;

                        getToast("Cambios efectuados con éxito");
                    }
                    else
                    {
                        semaforo = false;
                    }
                }

                if(!semaforo)
                {
                    getToast("Revise su anterior contraseña");
                    semaforo = true;
                }

                // Iteramos nuevamente sobre el directorio ( ficheros xml )
                // para buscar el antiguo registro y borrarlo

                for(int i = 0; i < archivos.length; i++)
                {
                    //Vamos guardando los nombres de los ficheros xml
                    String strNombreFichero = archivos[i];

                    //Condicional a true si el elemento del array (nombre del fichero xml) es igual al
                    //nombre del fichero que venimos trayendo desde LOGIN o REGISTRO
                    if(strNombreFichero.equals(nomFichDesdeLogin) || strNombreFichero.equals(nomFicheroDesdeRegistro))
                    {
                        //Borramos el fichero del directorio que genera SharedPreferences
                        File file = new File("/data/data/com.example.pizzeria_v04/shared_prefs/"+strNombreFichero);
                        file.delete();

                        //Paramos el bucle
                        i = archivos.length;
                    }
                }
            }
        });
    }

    public void getToast(String msg)
    {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
