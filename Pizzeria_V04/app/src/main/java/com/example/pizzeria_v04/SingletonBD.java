package com.example.pizzeria_v04;

import java.util.ArrayList;

public class SingletonBD
{
    private static SingletonBD instance = null;
    private static ArrayList<Datos> pizzas = null;

    private SingletonBD()
    {

    };

    public static synchronized SingletonBD getInstance()
    {
        if(instance == null)
        {
            instance = new SingletonBD();
            pizzas = new ArrayList<Datos>();
        }

        return (instance);
    }

    // Añadir pizza
    public static void AddPizza(Datos pizza)
    {
        System.out.println("Añadiendo pizza" + pizza);
        pizzas.add(pizza);
    }

    // Devuelve lista
    public static ArrayList<Datos> getPizza()
    {
        return pizzas;
    }

}
