package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private GridView gV;
    private List<Personas> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //conecto el gridview con su id
        gV = findViewById(R.id.gV);
        //añado a la lista las personas
        list  = new ArrayList<>();
        list.add(new Personas("Miguel", "Lopez Sanchez", "H", "ASIR"));
        list.add(new Personas("Juan", "Pérez Pérez", "H", "DAW"));
        list.add(new Personas("Maria", "Martínez Fernández", "M", "DAM"));
        list.add(new Personas("Antonio", "González García", "H", "DAM"));
        list.add(new Personas("Ana", "Díaz Torres", "M", "ASIR"));

        Miadaptador miadaptador = new Miadaptador(this, R.layout.elementos_per, list);
        //meto el adaptador en el gridview y le asocio un evento
        gV.setAdapter(miadaptador);
        gV.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intentMod = new Intent(this, ActivityModulos.class);
        intentMod.putExtra("ciclo", list.get(position).getCiclo());
        startActivity(intentMod);
    }
}