package com.example.cafeterita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;

public class Ayuda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);
        ImageButton botonIrAHome = findViewById(R.id.btnhome);
        ImageButton botonIrAComida = findViewById(R.id.btncomida);
        ImageButton botonIrAFila = findViewById(R.id.btnfila);
        ImageButton botonIrAOpciones = findViewById(R.id.btnopciones);


        WebView myWebView = findViewById(R.id.webview);

        myWebView.setWebViewClient(new WebViewClient());
        // Cargar una URL
        myWebView.loadUrl("https://www.facebook.com/caferita.2023?mibextid=LQQJ4d");

        // Agrega un listener al botón para manejar el clic
        botonIrAHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para cambiar a la actividad "Home"
                Intent intent = new Intent(Ayuda.this, Home.class);

                // Iniciar la actividad "Home"
                startActivity(intent);
            }
        });
        botonIrAComida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para cambiar a la actividad "Menu"
                Intent intent = new Intent(Ayuda.this, Menu.class);

                // Iniciar la actividad "Home"
                startActivity(intent);
            }
        });
        botonIrAFila.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para cambiar a la actividad "Fila"
                Intent intent = new Intent(Ayuda.this, FilaListas.class);

                // Iniciar la actividad "Home"
                startActivity(intent);
            }
        });
        botonIrAOpciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para cambiar a la actividad "Ayuda"
                Intent intent = new Intent(Ayuda.this, Ayuda.class);
                startActivity(intent);
            }
        });

    }
}