package com.example.pizzeria

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class Gui_Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gui__login)

        val edtUsuario = findViewById<EditText>(R.id.idEdtUsuarioLogin) as EditText
        val edtPass = findViewById<EditText>(R.id.idEdtPassLogin) as EditText
        val btnLogin = findViewById<Button>(R.id.idBtnLogin) as Button
        val checkingBox = findViewById<CheckBox>(R.id.idCheckLogin) as CheckBox

        // Evento del BOTÓN
        btnLogin.setOnClickListener {
            // Debemos comprobar que el usuario esté registrado ( SharedPreferences del Usuario en Registro )
            val name = edtUsuario.text.toString()
            val pass = edtPass.text.toString()
            val nameFile = name+"dataRegister"

            if(fileExist(nameFile))
            {
                getToast("Usuario existe...")
            }
        }

        // Evento del CheckBox
        checkingBox.setOnClickListener {

            // Debemos comprobar que el usuario esté registrado ( SharedPreferences del Usuario en Registro )
            val name = edtUsuario.text.toString()
            val pass = edtPass.text.toString()
            val nameFile = name+"dataRegister"

            if(fileExist(nameFile))
            {
                getToast("Usuario existe...")
            }

            /*if(checkingBox.isChecked) // Si usuario hace click en CheckBox
            {
                // Guardamos los datos en un xml SharedPreferences
                val sharedPref: SharedPreferences = getSharedPreferences(edtUsuario.text.toString() + "dataLogin", Context.MODE_PRIVATE)
                val editor = sharedPref.edit()

                editor.putString("name", edtUsuario.text.toString())
                editor.putString("password", edtPass.text.toString())

                var datosUser = sharedPref.getString("name", "defautVALUE")
                getToast(datosUser.toString())
            }
*/

        }
    }

    fun fileExist(file: String): Boolean
    {
        var exist: Boolean = false;

        val sharedPref: SharedPreferences = getSharedPreferences(file, Context.MODE_PRIVATE)

        var datosUser = sharedPref.getString("name", "defautVALUE")
        var datosEmail = sharedPref.getString("email", "defalutVALUE")
        var datosPass = sharedPref.getString("password", "defaultValue")

        if(!datosUser.toString().equals("defautVALUE") &&
                !datosPass.toString().equals("defautVALUE"))
        {
            exist = true;
        }
        return exist;
    }

    fun getToast(msg:String)
    {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}
