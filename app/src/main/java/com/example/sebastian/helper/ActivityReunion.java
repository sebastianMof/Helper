package com.example.sebastian.helper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

public class ActivityReunion extends AppCompatActivity {

    ListView et_listViewEve;
    ArrayList<String> listaTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reunion);

        et_listViewEve = (ListView)findViewById(R.id.listViewReuniones);

        consultarLista();
        configureNextButtonAgregarReuniones();

        ArrayAdapter adaptador = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaTitulo);
        et_listViewEve.setAdapter(adaptador);

    }

    @Override
    public void onResume() {
        super.onResume();
        setContentView(R.layout.activity_reunion);
        et_listViewEve = (ListView)findViewById(R.id.listViewReuniones);
        consultarLista();
        configureNextButtonAgregarReuniones();
        ArrayAdapter adaptador = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaTitulo);
        et_listViewEve.setAdapter(adaptador);

    }

    private void consultarLista() {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        listaTitulo = new ArrayList<String>();

        Cursor filatit = BaseDeDatos.rawQuery("SELECT nombre FROM REUNION ",null);
        //Cursor filaini = BaseDeDatos.rawQuery("SELECT fecha_inicio FROM EVENTO ",null);
        //Cursor filafin = BaseDeDatos.rawQuery("SELECT fecha_fin FROM EVENTO ",null);
        //Cursor filadesc = BaseDeDatos.rawQuery("SELECT descripcion FROM EVENTO ",null);

        while(filatit.moveToNext()){
            listaTitulo.add(filatit.getString(0));
        }

    }

    private void configureNextButtonAgregarReuniones() {
        Button nextButton = (Button)findViewById(R.id.botonIrAAgregarReunion);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityReunion.this, ActivityAgregarReunion.class));
            }
        });
    }

}