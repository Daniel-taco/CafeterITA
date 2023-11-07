package com.example.cafeterita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Snacks extends AppCompatActivity {

    List<ListElement> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snacks);

        init();
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