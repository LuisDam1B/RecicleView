package com.example.recicleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter implements OnClickListener {

    ArrayList<Persona> datos;
    OnClickListener listenerClick;
    Context context;
    IUsuario listenerImagen;


    public Adaptador(ArrayList<Persona> datos, Context context)
    {
        this.context = context;
        this.datos = datos;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.linear_recycle,parent,false);
        //la vista que se carga en ese momento hay que ponerla a escuchar
        view.setOnClickListener(this);
        Holder holder = new Holder(view,context);
        holder.OnClickEmail(new IUsuario() {
            @Override
            public void clickPersona(Persona persona) {

                listenerImagen.clickPersona(persona);
            }
            });

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

    public void OnClickImagen(IUsuario listener){
        listenerImagen = listener;
    }

    public void OnClickListerner(OnClickListener listener){
        //el listener que pulsamos lo adjuntamos a nuestro listenerClick
        listenerClick = listener;
    }

    @Override
    public void onClick(View view) {
        if (listenerClick != null) listenerClick.onClick(view);
    }
}


class Holder extends RecyclerView.ViewHolder implements OnClickListener
{
    TextView nombre;
    TextView email;
    LinearLayout fondo;
    Context context;
    ImageView correo;
    Persona persona;
    IUsuario listener;
    //OnClickListener listener;

    public Holder(@NonNull View itemView,Context context) {
        super(itemView);
        nombre = itemView.findViewById(R.id.nombre);
        email = itemView.findViewById(R.id.email);
        fondo = itemView.findViewById(R.id.fondo);
        correo = itemView.findViewById(R.id.send);
        correo.setOnClickListener(this);
        this.context = context;
    }

    public void binHolder(Persona persona)
    {
        this.persona = persona;
        nombre.setText(persona.nombre);
        email.setText(persona.email);
        correo.setVisibility(View.INVISIBLE);
        if (persona.edad < 10) fondo.setBackgroundColor(context.getResources().getColor(R.color.menores10));
        else if (persona.edad < 25 )  fondo.setBackgroundColor(context.getResources().getColor(R.color.menores25));
        else{
            correo.setVisibility(View.VISIBLE);
            fondo.setBackgroundColor(context.getResources().getColor(R.color.mayores25));
        }
    }

    public void OnClickEmail(IUsuario listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener!=null) listener.clickPersona(persona);
    }
}