package com.example.pizzeria

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

class Gui_Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gui__login)

        val edtUsuario = findViewById<EditText>(R.id.idEdtUsuarioLogin) as EditText
        val edtPass = findViewById<EditText>(R.id.idEdtPassLogin) as EditText
        val btnLogin = findViewById<Button>(R.id.idBtnLogin) as Button
        val checkingBox = findViewById<CheckBox>(R.id.idCheckLogin) as CheckBox



        // Evento del BOTÓN
        checkingBox.setOnClickListener {

            // Debemos comprobar que el usuario esté registrado ( SharedPreferences del Usuario en Registro )

            if(checkingBox.isChecked) // Si usuario hace click en CheckBox
            {
                // Guardamos los datos en un xml SharedPreferences
                val sharedPref: SharedPreferences = getSharedPreferences(edtUsuario.text.toString() + ".dataLogin", Context.MODE_PRIVATE)
                val editor = sharedPref.edit()

                editor.putString("Pref_Name: ", edtUsuario.text.toString())
                editor.putString("Pref_Pass: ", edtPass.text.toString())
            }
        }
    }

    fun fileExist(file: String): Boolean
    {
        var exist: Boolean = false;

        //val sharedPref: SharedPreferences = getSharedPreferences()

        /*var datosUser = sharedPref.getString("Pref_Name: ", "defautVALUE")
        var datosEmail = sharedPref.getString("Pref_Email: ", "defalutVALUE")
        var datosPass = sharedPref.getString("Pref_PassWord: ", "defaultValue")
*/
        return exist;
    }
}
