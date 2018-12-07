package com.example.sebastian.helper;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ActivityAnadirEvento extends AppCompatActivity {

    private EditText et_titulo, et_fecha_ini, et_fecha_fin, et_descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_evento);

        et_titulo = (EditText)findViewById(R.id.txt_titulo);
        et_fecha_ini = (EditText)findViewById(R.id.txt_ini);
        et_fecha_fin = (EditText)findViewById(R.id.txt_fin);
        et_descripcion = (EditText)findViewById(R.id.txt_descripcion);
    }

    public void Registrar(View view) throws IOException {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String titulo = et_titulo.getText().toString();
        String fecha_ini = et_fecha_ini.getText().toString();
        String fecha_fin = et_fecha_fin.getText().toString();
        String descripcion = et_descripcion.getText().toString();

        ContentValues registro = new ContentValues();
        registro.put("titulo", titulo);
        registro.put("fecha_inicio", fecha_ini);
        registro.put("fecha_fin", fecha_fin);
        registro.put("descripcion", descripcion);

        BaseDeDatos.insert("EVENTO", null, registro);
        BaseDeDatos.close();

        et_titulo.setText("");
        et_fecha_ini.setText("");
        et_fecha_fin.setText("");
        et_descripcion.setText("");

        Toast.makeText(this, "Registro exitoso", Toast.LENGTH_LONG).show();

    }
}
