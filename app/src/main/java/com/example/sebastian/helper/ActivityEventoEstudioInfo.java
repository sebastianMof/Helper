package com.example.sebastian.helper;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ActivityEventoEstudioInfo extends AppCompatActivity {

    private EditText titulo, fechainicio, fechafinal, descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento_estudio_info);

        TextView titulo, inicio, fin, descripcion;

        String sessionId= getIntent().getStringExtra("EXTRA_SESSION_ID");

        titulo = (TextView)findViewById(R.id.tit);
        inicio = (TextView)findViewById(R.id.fecini);
        fin = (TextView)findViewById(R.id.fecfin);
        descripcion = (TextView)findViewById(R.id.descri);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        Cursor filatit = BaseDeDatos.rawQuery("SELECT titulo FROM EVENTO WHERE titulo = ?; ", new String[]{sessionId});
        Cursor filaini = BaseDeDatos.rawQuery("SELECT fecha_inicio FROM EVENTO WHERE titulo = ?; ", new String[]{sessionId});
        Cursor filafin = BaseDeDatos.rawQuery("SELECT fecha_fin FROM EVENTO WHERE titulo = ?; ", new String[]{sessionId});
        Cursor filadesc = BaseDeDatos.rawQuery("SELECT descripcion FROM EVENTO WHERE titulo = ?; ", new String[]{sessionId});

        if(filatit.moveToFirst() && filaini.moveToFirst() && filafin.moveToFirst() && filadesc.moveToFirst()) {
            titulo.setText(filatit.getString(0));
            inicio.setText(filaini.getString(0));
            fin.setText(filafin.getString(0));
            descripcion.setText(filadesc.getString(0));
            BaseDeDatos.close();
        }

    }

}
