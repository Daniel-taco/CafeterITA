package com.example.cafeterita;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Bebidas extends AppCompatActivity {

    List<ListElement> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebidas);

        init();
    }

    public void init() {
        elements = new ArrayList<>();
        elements.add(new ListElement("Coca-Cola 600ml", "$18", R.mipmap.cocacola));
        elements.add(new ListElement("Agua Ciel 1L", "$15", R.mipmap.aguaciel));
        elements.add(new ListElement("Delaware Punch 600ml", "$18", R.mipmap.delaware));

        ListAdapter listAdapter = new ListAdapter(elements, this);
        RecyclerView recyclerView = findViewById(R.id.bebidasRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }
}