package com.example.sebastian.helper;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Log;

public class ActivityAgregarReunion extends AppCompatActivity {

    private EditText et_nombre, et_descripcion, et_lugar ,et_fecha_hora_inicio, et_fecha_hora_fin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_reunion);

        et_nombre = (EditText)findViewById(R.id.nombreReunion);
        et_descripcion = (EditText)findViewById(R.id.descripcionReunion);
        et_lugar = (EditText)findViewById(R.id.lugarReunion);
        et_fecha_hora_fin = (EditText)findViewById(R.id.fechaHoraInicioReunion);
        et_fecha_hora_inicio = (EditText)findViewById(R.id.fechaHoraFinReunion);

    }

    public void AgregarReunion(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String nombreNew = et_nombre.getText().toString();
        String descripcionNew = et_descripcion.getText().toString();
        String lugarNew = et_lugar.getText().toString();
        String fecha_hora_inicioNew = et_fecha_hora_inicio.getText().toString();
        String fecha_hora_finNew = et_fecha_hora_fin.getText().toString();

        ContentValues registro = new ContentValues();
        registro.put("nombre", nombreNew);
        registro.put("descripcion", descripcionNew);
        registro.put("lugar", lugarNew);
        registro.put("fecha_hora_inicio", fecha_hora_inicioNew);
        registro.put("fecha_hora_fin", fecha_hora_finNew);

        BaseDeDatos.insert("REUNION", null, registro);
        BaseDeDatos.close();

        et_nombre.setText("");
        et_descripcion.setText("");
        et_lugar.setText("");
        et_fecha_hora_inicio.setText("");
        et_fecha_hora_fin.setText("");

        Toast.makeText(this, "Agregada.", Toast.LENGTH_LONG).show();

    }

}
