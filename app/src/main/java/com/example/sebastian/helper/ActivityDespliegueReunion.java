package com.example.sebastian.helper;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class ActivityDespliegueReunion extends AppCompatActivity {

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_despliegue_reunion);

        tv1 = (TextView)findViewById(R.id.despliegueReunionNombre);
        tv2 = (TextView)findViewById(R.id.despliegueReunionDescripcion);
        tv3 = (TextView)findViewById(R.id.despliegueLugarReunion);
        tv4 = (TextView)findViewById(R.id.despliegueReunionFecha1);
        tv5 = (TextView)findViewById(R.id.despliegueReunionFecha2);


        String dato = getIntent().getStringExtra("dato");
        consultarReunion(dato);

        configureButtonVolverAAgregarProyectos();
    }

    private void consultarReunion(String dato) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        Cursor miQuery = BaseDeDatos.rawQuery("SELECT lugar , nombre, descripcion, fecha_hora_inicio, fecha_hora_fin FROM REUNION WHERE nombre = ?",new String[] {dato});

        if (miQuery.moveToFirst()) {

            tv1.setText("Nombre de la reunión: " + miQuery.getString(miQuery.getColumnIndex("nombre")));
            tv2.setText("Descripcion: " + miQuery.getString(miQuery.getColumnIndex("descripcion")));
            tv3.setText("Lugar: " + miQuery.getString(miQuery.getColumnIndex("lugar")));
            tv4.setText("Inicio: " + miQuery.getString(miQuery.getColumnIndex("fecha_hora_inicio")));
            tv5.setText("Fin: " + miQuery.getString(miQuery.getColumnIndex("fecha_hora_fin")));


        }
    }

    private void configureButtonVolverAAgregarProyectos() {
        Button nextButton = (Button)findViewById(R.id.botonRegresarAProyecto2);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityDespliegueReunion.this, ActivityProyecto.class);
                startActivity(i);
                finish();
            }
        });
    }



}
