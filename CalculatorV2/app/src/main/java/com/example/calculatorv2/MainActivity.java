package com.example.calculatorv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    //Semáforo de control para el control de estado
    boolean decimal = false;
    boolean sum = false;
    boolean res = false;
    boolean mul = false;
    boolean div = false;

    //Array tipo double que servirá para el cálculo de los operadores
    Double[] numero = new Double[20];
    Double dato; //Resultado

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Con esta línea evita que se gire a modo HORIZONTAL ( Landscape )
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Asociación de id's de los componentes

        Button btnEqual = findViewById(R.id.idBtnEqual);
        btnEqual.setOnClickListener(this);
        Button btn7 = findViewById(R.id.idBtnN7);
        btn7.setOnClickListener(this);
        Button btn8 = findViewById(R.id.idBtnN8);
        btn8.setOnClickListener(this);
        Button btn9 = findViewById(R.id.idBtnN9);
        btn9.setOnClickListener(this);
        Button btn4 = findViewById(R.id.idBtnN4);
        btn4.setOnClickListener(this);
        Button btn5 = findViewById(R.id.idBtnN5);
        btn5.setOnClickListener(this);
        Button btn6 = findViewById(R.id.idBtnN6);
        btn6.setOnClickListener(this);
        Button btn1 = findViewById(R.id.idBtnN1);
        btn1.setOnClickListener(this);
        Button btn2 = findViewById(R.id.idBtnN2);
        btn2.setOnClickListener(this);
        Button btn3 = findViewById(R.id.idBtnN3);
        btn3.setOnClickListener(this);
        Button btn0 = findViewById(R.id.idBtnN0);
        btn0.setOnClickListener(this);
        Button btnReset = findViewById(R.id.idBtnReset);
        btnReset.setOnClickListener(this);
        Button btnPoint = findViewById(R.id.idBtnPoint);
        btnPoint.setOnClickListener(this);
        Button btnDivide = findViewById(R.id.idBtnDivide);
        btnDivide.setOnClickListener(this);
        Button btnMultiply = findViewById(R.id.idBtnMultiply);
        btnMultiply.setOnClickListener(this);
        Button btnSubtract = findViewById(R.id.idBtnSubtract);
        btnSubtract.setOnClickListener(this);
        Button btnAdd = findViewById(R.id.idBtnAdd);
        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        TextView screen = (TextView)findViewById(R.id.idTvResult); //Muestra pantalla resultados
        int selector = v.getId();  //Identifica el botón presionado
        String x = screen.getText().toString(); //Guarda el valor de lo presionado

        try
        {
            switch (selector)
            {
                case R.id.idBtnN0:
                {
                    screen.setText(x + "0");
                }
                break;
                case R.id.idBtnN1:
                {
                    screen.setText(x + "1");
                }
                break;
                case R.id.idBtnN2:
                {
                    screen.setText(x + "2");
                }
                break;
                case R.id.idBtnN3:
                {
                    screen.setText(x + "3");
                }
                break;
                case R.id.idBtnN4:
                {
                    screen.setText(x + "4");
                }
                break;
                case R.id.idBtnN5:
                {
                    screen.setText(x + "5");
                }
                break;
                case R.id.idBtnN6:
                {
                    screen.setText(x + "6");
                }
                break;
                case R.id.idBtnN7:
                {
                    screen.setText(x + "7");
                }
                break;
                case R.id.idBtnN8:
                {
                    screen.setText(x + "8");
                }
                break;
                case R.id.idBtnN9:
                {
                    screen.setText(x + "9");
                }
                break;
                case R.id.idBtnPoint:
                    //Aquí aplicamos el semáforo (evita usar más de una vez el punto)
                    if(decimal == false)
                    {
                        screen.setText(x + ".");
                        decimal = true; //Cambiamos la variable después de usarla
                    }else{return;}
                    break;

                case R.id.idBtnMultiply:
                    mul = true; //Semáforo del operador multiplicar
                    numero[0] = Double.parseDouble(x); //Almacenamos el valor del string x en la primera pos del array
                    screen.setText("");
                    decimal = false;
                    break;

                case R.id.idBtnDivide:
                    div = true; //Semáforo del operador dividir
                    numero[0] = Double.parseDouble(x); //Almacenamos el valor del string x en la primera pos del array
                    screen.setText("");
                    decimal = false;
                    break;

                case R.id.idBtnAdd:
                    sum = true; //Semáforo del operador sumar
                    numero[0] = Double.parseDouble(x); //Almacenamos el valor del string x en la primera pos del array
                    screen.setText("");
                    decimal = false;
                    break;

                case R.id.idBtnSubtract:
                    res = true; //Semáforo del operador restar
                    numero[0] = Double.parseDouble(x); //Almacenamos el valor del string x en la primera pos del array
                    screen.setText("");
                    decimal = false;
                    break;

                case R.id.idBtnEqual:
                    numero[1] = Double.parseDouble(x);
                    //Con este if conseguimos que cuando se pulse btn suma se guarde la suma de
                    //la posicón 0 y 1 del array de datos
                    if(sum == true){
                        dato = numero[0] + numero[1];
                        screen.setText(String.valueOf(dato));
                    }else if(res == true){
                        dato = numero[0] - numero[1];
                        screen.setText(String.valueOf(dato));
                    }else if(mul == true){
                        dato = numero[0] * numero[1];
                        screen.setText(String.valueOf(dato));
                    }else if(div == true){
                        dato = numero[0] / numero[1];
                        screen.setText(String.valueOf(dato));
                    }
                    //Devolvemos estados de los semáforos de control
                    decimal = false;
                    sum = false;
                    res = false;
                    mul = false;
                    div = false;
                    break;

                case R.id.idBtnReset:
                {
                    screen.setText("");
                    decimal = false; //Depués de borrar devolvemos estado a la variable del semáfor
                }
                break;
            }
        }
        catch (Exception e)
        {
            screen.setText("ERROR");
        }
    }
}
