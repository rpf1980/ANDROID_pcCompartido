package com.example.pizzeria_v04;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DatosAdapter  extends RecyclerView.Adapter<DatosAdapter.MyViewHolder>
{
    private ArrayList<Datos> datosObjeto;
    private Context context;

    public DatosAdapter(ArrayList<Datos> datosObjeto, Context context)
    {
        this.datosObjeto = datosObjeto;
        this.context = context;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView titulo;
        TextView descripcion;
        ImageView imagen;
        Button btnItem;
        public MyViewHolder(View v)
        {
            super(v);
            titulo = (TextView) v.findViewById(R.id.textTitulo);
            descripcion = (TextView) v.findViewById(R.id.txtDetalle);
            imagen = (ImageView) v.findViewById(R.id.imageView);
            btnItem = (Button) v.findViewById(R.id.idBtnItemRecycler);
        }
    }

    @Override
    public DatosAdapter.MyViewHolder
    onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = 	LayoutInflater.from(parent.getContext()).inflate(R.layout.itemrecycler, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        context = parent.getContext();
        return vh;
    }

    //Asigna las cosas del array a la vista
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position)
    {
        holder.titulo.setText(String.valueOf(datosObjeto.get(position).getTitulo()));
        holder.descripcion.setText(datosObjeto.get(position).getDetalle());
        holder.imagen.setImageResource(datosObjeto.get(position).getImagen());
        holder.btnItem.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(context, GUI_DetallePizzaCasa.class);
                Bundle extras = new Bundle();
                extras.putInt("idpizza", datosObjeto.get(position).getId());
                intent.putExtras(extras); // Enviamos el item mediante su id
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return datosObjeto.size();
    }
}
