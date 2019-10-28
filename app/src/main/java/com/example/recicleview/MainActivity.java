package com.example.recicleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycle);
        final ArrayList<Persona> datos = new ArrayList<>();
        datos.add(new Persona("pepe","erwer@sedfsd.com"));
        datos.add(new Persona("juan","erwer@sedfsd.com"));
        datos.add(new Persona("luis","erwer@sedfsd.com"));
        datos.add(new Persona("xavi","erwer@sedfsd.com"));

        Adaptador adaptador = new Adaptador(datos);
        adaptador.OnClickListerner(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int posicion = recyclerView.getChildAdapterPosition(view);

                Toast.makeText(MainActivity.this,"pulsando " +datos.get(posicion).toString(),Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adaptador);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true));
        //recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        //recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,1));
    }
}
