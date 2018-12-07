package com.example.sebastian.helper;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityDespliegueTarea extends AppCompatActivity {

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_despliegue_tarea);

        tv1 = (TextView)findViewById(R.id.despliegueTareaNombre);
        tv2 = (TextView)findViewById(R.id.despliegueTareaDescripcion);
        tv3 = (TextView)findViewById(R.id.despliegueTareaFecha1);
        tv4 = (TextView)findViewById(R.id.despliegueTareaFecha2);

        String dato = getIntent().getStringExtra("dato");
        consultarTarea(dato);

        configureButtonVolverAProyectos();
    }

    private void consultarTarea(String dato) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        Cursor miQuery = BaseDeDatos.rawQuery("SELECT  nombre, descripcion, fecha_inicio, fecha_fin FROM TAREA WHERE nombre = ?",new String[] {dato});

        if (miQuery.moveToFirst()) {

            tv1.setText("Nombre de la reunión: " + miQuery.getString(miQuery.getColumnIndex("nombre")));
            tv2.setText("Descripcion: " + miQuery.getString(miQuery.getColumnIndex("descripcion")));
            tv3.setText("Inicio: " + miQuery.getString(miQuery.getColumnIndex("fecha_inicio")));
            tv4.setText("Fin: " + miQuery.getString(miQuery.getColumnIndex("fecha_fin")));


        }
    }

    private void configureButtonVolverAProyectos() {
        Button nextButton = (Button)findViewById(R.id.botonRegresarAProyecto3);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityDespliegueTarea.this, ActivityProyecto.class);
                startActivity(i);
                finish();
            }
        });
    }


}
