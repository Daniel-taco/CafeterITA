package com.example.cafeterita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class Snacks extends AppCompatActivity {

    List<ListElement> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snacks);

        init();

        ImageButton botonIrAHome = findViewById(R.id.btnhome);
        ImageButton botonIrAComida = findViewById(R.id.btncomida);
        ImageButton botonIrAFila = findViewById(R.id.btnfila);
        ImageButton botonIrAOpciones = findViewById(R.id.btnopciones);
        ImageButton botonIrAAgenda = findViewById(R.id.btnagenda);

        // Agrega un listener al botón para manejar el clic
        botonIrAHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para cambiar a la actividad "Home"
                Intent intent = new Intent(Snacks.this, Home.class);

                // Iniciar la actividad "Home"
                startActivity(intent);
            }
        });
        botonIrAComida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para cambiar a la actividad "Menu"
                Intent intent = new Intent(Snacks.this, Menu.class);

                // Iniciar la actividad "Home"
                startActivity(intent);
            }
        });
        botonIrAFila.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para cambiar a la actividad "Fila"
                Intent intent = new Intent(Snacks.this, FilaListas.class);

                // Iniciar la actividad "Home"
                startActivity(intent);
            }
        });
        botonIrAOpciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para cambiar a la actividad "Fila"
                Intent intent = new Intent(Snacks.this, Ayuda.class);
                startActivity(intent);
            }
        });
        botonIrAAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para cambiar a la actividad "Ayuda"
                Intent intent = new Intent(Snacks.this, SharedAgenda.class);
                startActivity(intent);
            }
        });
    }

    public void init() {
        elements = new ArrayList<>();
        elements.add(new ListElement("Galletas Chokis", "$20", R.mipmap.galletachokis));
        elements.add(new ListElement("Galletas Principe", "$15", R.mipmap.galletaprincipe));
        elements.add(new ListElement("Mazapan", "$10", R.mipmap.mazapan));

        ListAdapter listAdapter = new ListAdapter(elements, this);
        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }
    
}