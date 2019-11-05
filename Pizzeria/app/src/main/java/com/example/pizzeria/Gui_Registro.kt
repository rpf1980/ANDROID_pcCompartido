package com.example.pizzeria

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Gui_Registro : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gui__registro)

        val edtUsuario = findViewById<EditText>(R.id.idEdtUsuarioGuiRegistro) as EditText
        val edtEmail = findViewById<EditText>(R.id.idEdtEmailGuiRegistro) as EditText
        val edtPass = findViewById<EditText>(R.id.idEdtPassGuiRegistro) as EditText
        val btnGuardar = findViewById<Button>(R.id.idBtnGuiRegistro) as Button

        btnGuardar.setOnClickListener {

            // Guardamos datos en SharedPreferences
            val sharedPref: SharedPreferences = getSharedPreferences(edtUsuario.text.toString()+"dataRegister", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putString("name", edtUsuario.text.toString())
            editor.putString("email", edtEmail.text.toString())
            editor.putString("password", edtPass.text.toString())
            editor.apply()

            var datosUser = sharedPref.getString("email", "defautVALUE")
            getToast(datosUser.toString())
        }
    }

    // Mensajes TOAST
    fun getToast(message: String)
    {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}

