package com.example.sebastian.helper;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Log;

public class ActivityAgregarTarea extends AppCompatActivity {

    private EditText et_nombre, et_descripcion, et_fecha_inicio, et_fecha_fin, et_id_proyecto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_tarea);

        et_nombre = (EditText)findViewById(R.id.nombreTarea);
        et_descripcion = (EditText)findViewById(R.id.descripcionTarea);
        et_fecha_inicio = (EditText)findViewById(R.id.fechaInicioTarea);
        et_fecha_fin = (EditText)findViewById(R.id.fechaFinTarea);
        et_id_proyecto = (EditText)findViewById(R.id.idProyectoTarea);

    }

    public void AgregarTarea(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String nombreNew = et_nombre.getText().toString();
        String descripcionNew = et_descripcion.getText().toString();
        String fecha_inicioNew = et_fecha_inicio.getText().toString();
        String fecha_finNew = et_fecha_fin.getText().toString();
        String id_proyectoNew = et_id_proyecto.getText().toString();

        ContentValues registro = new ContentValues();
        registro.put("nombre", nombreNew);
        registro.put("descripcion", descripcionNew);
        registro.put("fecha_inicio", fecha_inicioNew);
        registro.put("fecha_fin", fecha_finNew);
        registro.put("id_proyecto", id_proyectoNew);

        BaseDeDatos.insert("TAREA", null, registro);
        BaseDeDatos.close();

        et_nombre.setText("");
        et_descripcion.setText("");
        et_fecha_inicio.setText("");
        et_fecha_fin.setText("");
        et_id_proyecto.setText("");

        Toast.makeText(this, "Agregada.", Toast.LENGTH_LONG).show();

        Intent anterior = new Intent(this, ActivityTarea.class);
        startActivity(anterior);
        finish();
    }

}
