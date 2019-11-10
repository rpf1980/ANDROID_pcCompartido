package com.example.pizzeria_v04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Adaptador extends BaseAdapter
{
    Context contexto;
    List<Datos> ListaObjetos;

    public Adaptador(Context contexto, List<Datos> listaObjetos)
    {
        this.contexto = contexto;
        this.ListaObjetos = listaObjetos;
    }

    @Override
    public int getCount()
    {
        // Retorna cantidad de elementos de la lista
        return ListaObjetos.size();
    }

    @Override
    public Object getItem(int position)
    {
        // Retorna objeto de la posición indicada
        return ListaObjetos.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        // Retorna id de la posición indicada
        return ListaObjetos.get(position).getId();
    }

    // Se ejecutará en cada secuencia que se quiera cargar el item de objetos
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View vista = convertView;

        //Con esto podemos inyectar items de listView y colocarlo dentro de la lista
        //Obtenemos referencia de ese item
        LayoutInflater inflate = LayoutInflater.from(contexto);
        //vista = inflate.inflate(R.layout.itemlistview, null);

        // Referencia a la imagen
        ImageView imagen = (ImageView) vista.findViewById(R.id.imageView);
        TextView titulo = (TextView) vista.findViewById(R.id.textTitulo);
        TextView detalle = (TextView) vista.findViewById(R.id.txtDetalle);

        // Cargamos en el nuevo item que estamos generando los elementos correspondientes
        titulo.setText(ListaObjetos.get(position).getTitulo().toString());
        detalle.setText(ListaObjetos.get(position).getDetalle().toString());
        imagen.setImageResource(ListaObjetos.get(position).getImagen());

        return vista;
    }
}
