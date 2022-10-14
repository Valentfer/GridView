package com.example.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;
//definimos el adapter
public class Miadaptador extends ArrayAdapter {
    //creacion de variables para usar con la clase getview
    private Context ctx;
    private int layoutTemplate;
    private List<Personas> personasList;

    //constructor
    public Miadaptador(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.ctx = context;
        this.layoutTemplate = resource;
        this.personasList = objects;
    }

    public View getView(int position, View converView, ViewGroup parent) {
        //definimos view
        View v = LayoutInflater.from(ctx).inflate(layoutTemplate,parent,false);
        //creo la persona
        Personas personaActual = personasList.get(position);
        //conectamos las variables de cada tipo con su id
        ImageView imageAlu = v.findViewById(R.id.imagAlum);
        TextView txtNombre = v.findViewById(R.id.txtNombre);
        TextView txtApell = v.findViewById(R.id.txtApellidos);
        TextView txtCiclo = v.findViewById(R.id.txtCiclo);


        txtNombre.setText(personaActual.getNombre());
        txtApell.setText(personaActual.getApellidos());
        txtCiclo.setText(personaActual.getCiclo());
        //decidimos según el sexo el tipo de imagen
        if (personaActual.getSexo().equals("H")) {
            imageAlu.setImageResource(R.drawable.boy);
        } else if (personaActual.getSexo().equals("M")){
            imageAlu.setImageResource(R.drawable.student_avatar_icon_133986);
        }

        return v;
    }

}
