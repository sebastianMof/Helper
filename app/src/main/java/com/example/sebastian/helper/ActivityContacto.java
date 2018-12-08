package com.example.sebastian.helper;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityContacto extends AppCompatActivity {

    ListView et_listViewEve;
    ArrayList<String> listaTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitycontacto);


        et_listViewEve = (ListView) findViewById(R.id.lista);
        consultarLista();

        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaTitulo);
        et_listViewEve.setAdapter(adaptador);
        configureListViewClick(et_listViewEve);

        anadirC();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activitycontacto);


        et_listViewEve = (ListView) findViewById(R.id.lista);
        consultarLista();

        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaTitulo);
        et_listViewEve.setAdapter(adaptador);
        configureListViewClick(et_listViewEve);

        anadirC();
    }

    private void consultarLista() {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        listaTitulo = new ArrayList<String>();
        //Registrar1();

        Cursor filatit = BaseDeDatos.rawQuery("SELECT nombre FROM PERFIL ", null);
        //Cursor filaini = BaseDeDatos.rawQuery("SELECT fecha_inicio FROM EVENTO ",null);
        //Cursor filafin = BaseDeDatos.rawQuery("SELECT fecha_fin FROM EVENTO ",null);
        //Cursor filadesc = BaseDeDatos.rawQuery("SELECT descripcion FROM EVENTO ",null);

        while (filatit.moveToNext()) {
            listaTitulo.add(filatit.getString(0));
        }
    }


    private void configureListViewClick(final ListView et_listViewEve) {

        et_listViewEve.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object item = et_listViewEve.getItemAtPosition(position);
                String name = item.toString();

                Intent i = new Intent(ActivityContacto.this, ActivityDespliegueContacto.class);
                i.putExtra("dato", name);
                startActivity(i);
            }
        });


    }

    public void anadirC() {
        Button nextButton = (Button)findViewById(R.id.anadirContacto);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( ActivityContacto.this, Perfilis.class));
                onStop();
            }
        });
    }





}
