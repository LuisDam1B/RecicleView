package com.example.recicleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter implements View.OnClickListener {

    ArrayList<Persona> datos;
    View.OnClickListener listenerClick;


    public Adaptador(ArrayList<Persona> datos)
    {

        this.datos = datos;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.linear_recycle,parent,false);
        //la vista que se carga en ese momento hay que ponerla a escuchar
        view.setOnClickListener(this);
        Holder holder = new Holder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {
        ((Holder)holder).binHolder(datos.get(position));

    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void OnClickListerner(View.OnClickListener listener){
        //el listener que pulsamos lo adjuntamos a nuestro listenerClick
        listenerClick = listener;
    }

    @Override
    public void onClick(View view) {
        if (listenerClick != null) listenerClick.onClick(view);
    }
}


class Holder extends RecyclerView.ViewHolder
{
    TextView nombre;
    TextView email;

    public Holder(@NonNull View itemView) {
        super(itemView);
        nombre = itemView.findViewById(R.id.nombre);
        email = itemView.findViewById(R.id.email);

    }

    public void binHolder(Persona persona)
    {
        nombre.setText(persona.nombre);
        email.setText(persona.email);
    }
}