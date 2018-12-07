package com.example.sebastian.helper;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import android.view.View;

public class ActivityTarea extends AppCompatActivity {

    ListView et_listViewEve;
    ArrayList<String> listaTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarea);

        et_listViewEve = (ListView)findViewById(R.id.listViewTareas);

        consultarLista();
        configureNextButtonAgregarTareas();

        ArrayAdapter adaptador = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaTitulo);
        et_listViewEve.setAdapter(adaptador);

    }

    @Override
    public void onResume() {
        super.onResume();
        setContentView(R.layout.activity_tarea);
        et_listViewEve = (ListView)findViewById(R.id.listViewTareas);
        consultarLista();
        configureNextButtonAgregarTareas();
        ArrayAdapter adaptador = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaTitulo);
        et_listViewEve.setAdapter(adaptador);

    }

    private void consultarLista() {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        listaTitulo = new ArrayList<String>();

        Cursor filatit = BaseDeDatos.rawQuery("SELECT nombre FROM TAREA ",null);
        //Cursor filaini = BaseDeDatos.rawQuery("SELECT fecha_inicio FROM EVENTO ",null);
        //Cursor filafin = BaseDeDatos.rawQuery("SELECT fecha_fin FROM EVENTO ",null);
        //Cursor filadesc = BaseDeDatos.rawQuery("SELECT descripcion FROM EVENTO ",null);

        while(filatit.moveToNext()){
            listaTitulo.add(filatit.getString(0));
        }

    }

    private void configureNextButtonAgregarTareas() {
        Button nextButton = (Button)findViewById(R.id.botonIrAAgregarTarea);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startActivity(new Intent(ActivityTarea.this, ActivityAgregarTarea.class));
            finish();
            }
        });
    }

}