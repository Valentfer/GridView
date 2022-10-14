package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityModulos extends AppCompatActivity implements View.OnClickListener {

    private ImageView icono;
    private TextView txtDescr;
    private Button btnVolver;
    private View fondo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulos);

        icono = findViewById(R.id.imgIcono);
        txtDescr = findViewById(R.id.txtDesc);
        btnVolver = findViewById(R.id.btnVolver);
        fondo = findViewById(R.id.fondo);

        btnVolver.setOnClickListener(this);

        Bundle dato = getIntent().getExtras();
        String ciclo = dato.getString("ciclo");

        if(String.valueOf(ciclo).equals("ASIR")){
            icono.setImageResource(R.drawable.asir);
            txtDescr.setText("Estás en el ciclo ASIR");
            fondo.setBackgroundColor(Color.parseColor("#b675ff"));
        }else if(String.valueOf(ciclo).equals("DAW")){
            icono.setImageResource(R.drawable.daw);
            txtDescr.setText("Estás en el ciclo DAW");
            fondo.setBackgroundColor(Color.parseColor("#ff5436"));
        }else if(String.valueOf(ciclo).equals("DAM")){
            icono.setImageResource(R.drawable.dam);
            txtDescr.setText("Estás en el ciclo DAM");
            fondo.setBackgroundColor(Color.parseColor("#c1ff65"));
        }

    }

    @Override
    public void onClick(View v) {
        Intent intentMa = new Intent(this, MainActivity.class);
        startActivity(intentMa);
    }
}