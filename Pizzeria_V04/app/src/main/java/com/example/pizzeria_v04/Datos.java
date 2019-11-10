package com.example.pizzeria_v04;

import java.io.Serializable;

public class Datos implements Serializable
{
    private int Id;
    private String Titulo;

    public Datos(int id, String titulo, String detalle, int imagen)
    {
        Id = id;
        Titulo = titulo;
        Detalle = detalle;
        Imagen = imagen;
    }

    private String Detalle;


    public int getId()
    {
        return Id;
    }

    public void setId(int id)
    {
        Id = id;
    }

    public String getTitulo()
    {
        return Titulo;
    }

    public void setTitulo(String titulo)
    {
        Titulo = titulo;
    }

    public String getDetalle()
    {
        return Detalle;
    }

    public void setDetalle(String detalle)
    {
        Detalle = detalle;
    }

    public int getImagen()
    {
        return Imagen;
    }

    public void setImagen(int imagen)
    {
        Imagen = imagen;
    }

    private int Imagen;
}
