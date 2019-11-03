package com.example.pizzeria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Gui_Registro : AppCompatActivity()
{
    // Asociamos los id a los componentes
    val edtUsuario = findViewById<EditText>(R.id.idEdtUsuarioGuiRegistro)
    val edtEmail = findViewById<EditText>(R.id.idEdtEmailGuiRegistro)
    val edtPass = findViewById<EditText>(R.id.idEdtPassGuiRegistro)
    val btnGuardar = findViewById<Button>(R.id.idBtnGuiRegistro)

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gui__registro)

        btnGuardar.setOnClickListener {

            // Comprobamos que los campos de los editText no estén vacíos
            if(camposIsEmpty())
            {
                // Guardamos datos en SharedPreferences
            }
        }
    }

    // Mensajes TOAST
    fun getToast(message: String)
    {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    // Función para comprobar que los campos no estén vacíos
    fun camposIsEmpty(): Boolean
    {
        var emptyOk: Boolean = false;

        if(!edtUsuario.text.equals("") && !edtEmail.text.equals("") && !edtPass.text.equals(""))
        {
            emptyOk = true;
        }

        return emptyOk;
    }
}

