package com.example.pizzeria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_gui__registro.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        idBtnRegistrarseInicio.setOnClickListener {
            startActivity(Intent(this@MainActivity, Gui_Registro::class.java))
        }

        idBtnInicaSesion.setOnClickListener {
            startActivity(Intent(this@MainActivity, Gui_Login::class.java))
        }

    }
}
