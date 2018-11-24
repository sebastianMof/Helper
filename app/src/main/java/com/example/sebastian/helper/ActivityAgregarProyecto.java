package com.example.sebastian.helper;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Log;

public class ActivityAgregarProyecto extends AppCompatActivity {

    private EditText et_nombre, et_descripcion, et_fecha_inicio, et_fecha_fin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_proyecto);

        et_nombre = (EditText)findViewById(R.id.nombreProyecto);
        et_descripcion = (EditText)findViewById(R.id.descripcionProyecto);
        et_fecha_inicio = (EditText)findViewById(R.id.fechaInicioProyecto);
        et_fecha_fin = (EditText)findViewById(R.id.fechaFinProyecto);

    }

    public void AgregarProyecto(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String nombreNew = et_nombre.getText().toString();
        String descripcionNew = et_descripcion.getText().toString();
        String fecha_inicioNew = et_fecha_inicio.getText().toString();
        String fecha_finNew = et_fecha_fin.getText().toString();

        ContentValues registro = new ContentValues();
        registro.put("nombre", nombreNew);
        registro.put("descripcion", descripcionNew);
        registro.put("fecha_inicio", fecha_inicioNew);
        registro.put("fecha_fin", fecha_finNew);

        BaseDeDatos.insert("PROYECTO", null, registro);
        BaseDeDatos.close();

        et_nombre.setText("");
        et_descripcion.setText("");
        et_fecha_inicio.setText("");
        et_fecha_fin.setText("");

        Toast.makeText(this, "Agregado.", Toast.LENGTH_LONG).show();

    }


}
