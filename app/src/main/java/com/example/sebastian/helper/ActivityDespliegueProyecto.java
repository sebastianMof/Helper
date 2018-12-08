package com.example.sebastian.helper;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivityDespliegueProyecto extends AppCompatActivity {

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_despliegue_proyecto);

        tv1 = (TextView)findViewById(R.id.despliegueProyectoNombre);
        tv2 = (TextView)findViewById(R.id.despliegueProyectoDescripcion);
        tv3 = (TextView)findViewById(R.id.despliegueProyectoFecha1);
        tv4 = (TextView)findViewById(R.id.despliegueProyectoFecha2);
        tv5 = (TextView)findViewById(R.id.despliegueProyectoID);

        String dato = getIntent().getStringExtra("dato");
        consultarProyecto(dato);

        configureButtonVolverAAgregarProyectos();
        configureButtonIrAReunionesFiltradas(dato);
        configureButtonIrATareasFiltradas(dato);
    }


    private void consultarProyecto(String dato) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        Cursor miQuery = BaseDeDatos.rawQuery("SELECT id, nombre, descripcion, fecha_inicio, fecha_fin FROM PROYECTO WHERE nombre = ?",new String[] {dato});

        if (miQuery.moveToFirst()) {

            tv1.setText("Nombre del Proyecto: " + miQuery.getString(miQuery.getColumnIndex("nombre")));
            tv2.setText("Descripcion del Proyecto: " + miQuery.getString(miQuery.getColumnIndex("descripcion")));
            tv3.setText("Fecha inicio del Proyecto: " + miQuery.getString(miQuery.getColumnIndex("fecha_inicio")));
            tv4.setText("Fecha fin del Proyecto: " + miQuery.getString(miQuery.getColumnIndex("fecha_fin")));
            tv5.setText("ID Proyecto: " + miQuery.getString(miQuery.getColumnIndex("id")));

        }
     }

    private void configureButtonVolverAAgregarProyectos() {
        Button nextButton = (Button)findViewById(R.id.botonRegresarAProyecto);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityDespliegueProyecto.this, ActivityProyecto.class));
            }
        });
    }


    private void configureButtonIrATareasFiltradas(final String dato) {
        Button nextButton = (Button)findViewById(R.id.irATareasFiltradas);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityDespliegueProyecto.this, ActivityTareasFiltradas.class);
                i.putExtra("dato", dato);
                startActivity(i);
                finish();

            }
        });
    }

    private void configureButtonIrAReunionesFiltradas(final String dato) {
        Button nextButton = (Button)findViewById(R.id.irAReunionesFiltradas);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityDespliegueProyecto.this, ActivityReunionesFiltradas.class);
                i.putExtra("dato", dato);
                startActivity(i);
                finish();

            }
        });
    }

}









