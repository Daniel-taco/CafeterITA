package com.example.cafeterita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class SharedAgenda extends AppCompatActivity {

    private EditText et_dia, et_datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_agenda);

        ImageButton botonIrAHome = findViewById(R.id.btnhome);
        ImageButton botonIrAComida = findViewById(R.id.btncomida);
        ImageButton botonIrAFila = findViewById(R.id.btnfila);
        ImageButton botonIrAOpciones = findViewById(R.id.btnopciones);
        ImageButton botonIrAAgenda = findViewById(R.id.btnagenda);


        et_dia = (EditText) findViewById(R.id.txt_dia);
        et_datos = (EditText) findViewById(R.id.txt_datos);


        botonIrAHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para cambiar a la actividad "Home"
                Intent intent = new Intent(SharedAgenda.this, Home.class);

                // Iniciar la actividad "Home"
                startActivity(intent);
            }
        });
        botonIrAComida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para cambiar a la actividad "Menu"
                Intent intent = new Intent(SharedAgenda.this, Menu.class);

                // Iniciar la actividad "Home"
                startActivity(intent);
            }
        });
        botonIrAFila.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para cambiar a la actividad "Fila"
                Intent intent = new Intent(SharedAgenda.this, FilaListas.class);

                // Iniciar la actividad "Home"
                startActivity(intent);
            }
        });
        botonIrAOpciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para cambiar a la actividad "Ayuda"
                Intent intent = new Intent(SharedAgenda.this, Ayuda.class);
                startActivity(intent);
            }
        });
        botonIrAAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para cambiar a la actividad "Ayuda"
                Intent intent = new Intent(SharedAgenda.this, SharedAgenda.class);
                startActivity(intent);
            }
        });
    }
    //Metodo para el boton guardar
    public void Guardar (View view){
        String dia = et_dia.getText().toString();
        String datos = et_datos.getText().toString();

        SharedPreferences preferencias = getSharedPreferences( "agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferencias.edit();
        obj_editor.putString(dia,datos);
        obj_editor.commit();

        Toast.makeText(this, "La Informacion ha sido guardada", Toast.LENGTH_SHORT).show();

    }
    //Metodo para el boton buscar
    public void Buscar(View view){
        String dia = et_dia.getText().toString();

        SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        String datos = preferencias.getString(dia,"");

        if(datos.length() == 0){
            Toast.makeText(this, "No se encontro ningun registro", Toast.LENGTH_SHORT).show();
        } else {
            et_datos.setText(datos);
        }
    }

}