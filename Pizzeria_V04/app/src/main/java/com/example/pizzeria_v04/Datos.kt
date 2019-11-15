package com.example.pizzeria_v04

import java.io.Serializable

class Datos(Id: Int, Titulo: String, detalle: String, imagen: Int):Serializable
{
    var Id: Int = Id
    var Titulo: String = Titulo
    var detalle: String = detalle
    var imagen: Int = imagen

}