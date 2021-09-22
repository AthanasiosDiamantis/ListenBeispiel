package com.example.listenbeispiel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // Ich lege ein Objekt rv an um die xml weiter unten mit diesem Objekt zu verbinden
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // hier wird die xml mit dem RecyclerView verknüpft
        rv = findViewById(R.id.rv);
        // wir erstellen eine neue Klasse mit dem Namen MainListAdapter
        MainListAdapter mainListAdapter = new MainListAdapter();
        rv.setAdapter(mainListAdapter);

    }
}