package com.example.cafeterita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ImageButton;

public class basededatos extends AppCompatActivity {

    private EditText et_categoria, et_code, et_name, et_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basededatos);

        et_categoria = findViewById(R.id.categoria);
        et_code = findViewById(R.id.code);
        et_name = findViewById(R.id.nameProd);
        et_price = findViewById(R.id.priceprod);

        ImageButton botonIrAHome = findViewById(R.id.btnhome);
        ImageButton botonIrAComida = findViewById(R.id.btncomida);
        ImageButton botonIrAFila = findViewById(R.id.btnfila);
        ImageButton botonIrAOpciones = findViewById(R.id.btnopciones);
        ImageButton botonIrAAgenda = findViewById(R.id.btnagenda);

        botonIrAHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para cambiar a la actividad "Home"
                Intent intent = new Intent(basededatos.this, Home.class);

                // Iniciar la actividad "Home"
                startActivity(intent);
            }
        });
        botonIrAComida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para cambiar a la actividad "Menu"
                Intent intent = new Intent(basededatos.this, Menu.class);

                // Iniciar la actividad "Home"
                startActivity(intent);
            }
        });
        botonIrAFila.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para cambiar a la actividad "Fila"
                Intent intent = new Intent(basededatos.this, FilaListas.class);

                // Iniciar la actividad "Home"
                startActivity(intent);
            }
        });
        botonIrAOpciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para cambiar a la actividad "Ayuda"
                Intent intent = new Intent(basededatos.this, Ayuda.class);
                startActivity(intent);
            }
        });
        botonIrAAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para cambiar a la actividad "Ayuda"
                Intent intent = new Intent(basededatos.this, SharedAgenda.class);
                startActivity(intent);
            }
        });


    }
    public void Registrar(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String categoria = et_categoria.getText().toString();
        String code = et_code.getText().toString();
        String name = et_name.getText().toString();
        String price = et_price.getText().toString();

        if (!categoria.isEmpty() && !code.isEmpty() && !name.isEmpty() && !price.isEmpty()) {
            ContentValues registro = new ContentValues();
            registro.put("code", code);
            registro.put("name", name);
            registro.put("price", price);
            BaseDeDatos.insert(categoria, null, registro);


            BaseDeDatos.close();

            et_categoria.setText("");
            et_code.setText("");
            et_name.setText("");
            et_price.setText("");

            Toast.makeText(this, "Registro exitoso.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_LONG).show();

        }
    }

    public void Buscar (View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String categoria = et_categoria.getText().toString();
        String code = et_code.getText().toString();

        if(!code.isEmpty() && !categoria.isEmpty()){
            Cursor fila = BaseDeDatos.rawQuery
                    ("select name, price from " + categoria + " where code ="+ code , null);
            if(fila.moveToFirst()){
                et_name.setText(fila.getString(0));
                et_price.setText(fila.getString(1));
                BaseDeDatos.close();
            }else{
                Toast.makeText(this, "Este producto no existe", Toast.LENGTH_LONG).show();
                BaseDeDatos.close();
            }

        } else {
            Toast.makeText(this, "Debes de introducir el código del articulo y la categoria", Toast.LENGTH_SHORT).show();
        }
    }

    public void Eliminar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper
                (this, "administracion", null, 1);
        SQLiteDatabase BaseDatabase = admin.getWritableDatabase();

        String categoria = et_categoria.getText().toString();
        String code = et_code.getText().toString();

        if(!code.isEmpty() && !categoria.isEmpty()){

            int cantidad = BaseDatabase.delete(categoria, "code=" + code, null);
            BaseDatabase.close();

            et_categoria.setText("");
            et_code.setText("");
            et_name.setText("");
            et_price.setText("");

            if(cantidad == 1){
                Toast.makeText(this, "Producto eliminado exitosamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "El producto no existe", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Debes introducir el código del producto y la categoria", Toast.LENGTH_SHORT).show();
        }
    }

    public void Modificar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDatabase = admin.getWritableDatabase();

        String categoria = et_categoria.getText().toString();
        String code = et_code.getText().toString();
        String name = et_name.getText().toString();
        String price = et_price.getText().toString();

        if(!code.isEmpty() && !categoria.isEmpty() && !name.isEmpty() && !price.isEmpty()){

            ContentValues registro = new ContentValues();
            registro.put("code", code);
            registro.put("name", name);
            registro.put("price", price);

            int cantidad = BaseDatabase.update(categoria, registro, "code=" + code, null);
            BaseDatabase.close();

            if(cantidad == 1){
                Toast.makeText(this, "Producto modificado correctamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "El producto no existe", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

}