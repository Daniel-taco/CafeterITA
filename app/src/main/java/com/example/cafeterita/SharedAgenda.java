package com.example.cafeterita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SharedAgenda extends AppCompatActivity {

    private EditText et_dia, et_datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_agenda);

        et_dia = (EditText) findViewById(R.id.txt_dia);
        et_datos = (EditText) findViewById(R.id.txt_datos);

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