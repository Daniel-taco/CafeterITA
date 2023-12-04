package com.example.cafeterita;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class Comida extends AppCompatActivity {
    List<ListElement> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comida);
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
                Intent intent = new Intent(Comida.this, Home.class);
                startActivity(intent);
            }
        });
        botonIrAComida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para cambiar a la actividad "Menu"
                Intent intent = new Intent(Comida.this, Menu.class);
                startActivity(intent);
            }
        });
        botonIrAFila.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para cambiar a la actividad "Fila"
                Intent intent = new Intent(Comida.this, FilaListas.class);
                startActivity(intent);
            }
        });
        botonIrAOpciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para cambiar a la actividad "Ayuda"
                Intent intent = new Intent(Comida.this, Ayuda.class);
                startActivity(intent);
            }
        });
        botonIrAAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para cambiar a la actividad "Ayuda"
                Intent intent = new Intent(Comida.this, SharedAgenda.class);
                startActivity(intent);
            }
        });
    }

    public void init() {
        elements = new ArrayList<>();
        Cursor cursor = getItemsFromDatabase("comidas");

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int code = cursor.getInt(cursor.getColumnIndex("code"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                int price = cursor.getInt(cursor.getColumnIndex("price"));

                // Agrega los elementos a la lista
                elements.add(new ListElement(name, "$" + price, String.valueOf(code)));
            } while (cursor.moveToNext());

            cursor.close();
        }

        ListAdapter listAdapter = new ListAdapter(elements, this);
        RecyclerView recyclerView = findViewById(R.id.comidaRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }
    private Cursor getItemsFromDatabase(String tableName) {
        AdminSQLiteOpenHelper dbHelper = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        return dbHelper.getAllItems(tableName);
    }
}