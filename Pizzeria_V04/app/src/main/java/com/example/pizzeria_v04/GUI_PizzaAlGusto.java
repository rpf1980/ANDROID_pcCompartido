package com.example.pizzeria_v04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class GUI_PizzaAlGusto extends AppCompatActivity
{
    TextView tvContador;
    Button arrowLeft, arrowRight;
    CheckBox checkMiniGusto, checkMiddleGusto, checkBigGusto;
    CheckBox checkQueso, checkJamon, checkSalchicha, checkYork, checkAtun, checkOliva, checkBacon;
    CheckBox checkFavorita;
    Button btnListoGusto;
    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui__pizza_al_gusto);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Asociamos los id's
        tvContador = findViewById(R.id.idTvContadorGusto);
        arrowLeft = findViewById(R.id.idBtnLeftGusto);
        arrowRight = findViewById(R.id.idBtnRightGusto);
        checkMiniGusto = findViewById(R.id.idCheckMinGusto);
        checkMiddleGusto = findViewById(R.id.idCheckMiddleGusto);
        checkBigGusto = findViewById(R.id.idCheckBigGusto);
        checkQueso = findViewById(R.id.idCheckQueso);
        checkJamon = findViewById(R.id.idCheckJamon);
        checkSalchicha = findViewById(R.id.idCheckSalchicha);
        checkYork = findViewById(R.id.idCheckYork);
        checkAtun = findViewById(R.id.idCheckAtun);
        checkOliva = findViewById(R.id.idCheckOliva);
        checkBacon = findViewById(R.id.idCheckBacon);
        btnListoGusto = findViewById(R.id.idBtnLIstoGusto);
        checkFavorita = findViewById(R.id.idCheckFavoritaMarcas);

        // Evento SUMA contador
        arrowRight.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                contador = Integer.parseInt(tvContador.getText().toString());
                contador += 1;
                tvContador.setText(String.valueOf(contador));
            }
        });

        // Evento RESTA contador
        arrowLeft.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                contador = Integer.parseInt(tvContador.getText().toString());
                if(contador > 0)
                {
                    contador -= 1;
                }
                tvContador.setText(String.valueOf(contador));
            }
        });

        // Evento Btn LISTO !!!
        btnListoGusto.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                if(checkFavorita.isChecked())
                {
                    String ingredientes = "";
                    //checkQueso, checkJamon, checkSalchicha, checkYork, checkAtun, checkOliva, checkBacon;
                    if(checkQueso.isChecked())
                    {
                        ingredientes += "Queso ";
                    }
                    if(checkJamon.isChecked())
                    {
                        ingredientes += "Jamón ";
                    }
                    if(checkSalchicha.isChecked())
                    {
                        ingredientes += "Salchicha ";
                    }
                    if(checkYork.isChecked())
                    {
                        ingredientes += "York ";
                    }
                    if(checkAtun.isChecked())
                    {
                        ingredientes += "Atún ";
                    }
                    if(checkOliva.isChecked())
                    {
                        ingredientes += "Olivas ";
                    }
                    if(checkBacon.isChecked())
                    {
                        ingredientes += "Bacon ";
                    }

                    SingletonBD singleton = SingletonBD.getInstance();
                    Datos pizza = new Datos(0, "Pizza al gusto", ingredientes, R.drawable.img1);
                    singleton.AddPizza(pizza);
                }
                Intent i = new Intent(getApplicationContext(), GUI_DetallePizzaGusto.class);
                startActivity(i);
            }
        });

    }
}
