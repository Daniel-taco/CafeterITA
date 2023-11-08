package com.example.cafeterita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    private Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ImageButton botonIrAHome = findViewById(R.id.btnhome);
        ImageButton botonIrAComida = findViewById(R.id.btncomida);
        ImageButton botonIrAFila = findViewById(R.id.btnfila);
        ImageButton botonIrAOpciones = findViewById(R.id.btnopciones);

        // Agrega un listener al botón para manejar el clic
        botonIrAHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para cambiar a la actividad "Home"
                Intent intent = new Intent(Menu.this, Home.class);

                // Iniciar la actividad "Home"
                startActivity(intent);
            }
        });
        botonIrAComida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para cambiar a la actividad "Menu"
                Intent intent = new Intent(Menu.this, Menu.class);

                // Iniciar la actividad "Home"
                startActivity(intent);
            }
        });
        botonIrAFila.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para cambiar a la actividad "Fila"
                Intent intent = new Intent(Menu.this, FilaListas.class);

                // Iniciar la actividad "Home"
                startActivity(intent);
            }
        });
        botonIrAOpciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para cambiar a la actividad "Ayuda"
                Intent intent = new Intent(Menu.this, Ayuda.class);
                startActivity(intent);
            }
        });


        spinner1= (Spinner) findViewById(R.id.spinner);

        String [] opciones = {"Comida", "Bebidas", "Snacks"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_cafeterita, opciones);
        spinner1.setAdapter(adapter);
    }

    public void Reenviar (View view){

        String seleccion = spinner1.getSelectedItem().toString();
        if(seleccion.equals("Comida")){
            Intent intent = new Intent(Menu.this, Comida.class);
            startActivity(intent);
        } else if (seleccion.equals("Bebidas")){
            Intent intent = new Intent(Menu.this, Bebidas.class);
            startActivity(intent);
        } else if (seleccion.equals("Snacks")) {
            Intent intent = new Intent(Menu.this, Snacks.class);
            startActivity(intent);
        }
    }
}