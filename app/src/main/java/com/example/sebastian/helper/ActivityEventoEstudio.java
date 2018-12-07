package com.example.sebastian.helper;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ActivityEventoEstudio extends AppCompatActivity {

    ListView et_listViewEve;
    ArrayList<String> listaTitulo;
    ArrayList<String> listaIni;
    ArrayList<String> listaFin;
    ArrayList<String> listaDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento_estudio);

        // Get reference of widgets from XML layout
        ListView lv = (ListView) findViewById(R.id.listViewEve);


        // Initializing a new String Array
        String[] fruits = new String[30];


        int i = 0;
        while(i < 30){
            fruits[i] = "";

            i = i + 1;
        }

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        Cursor filatit = BaseDeDatos.rawQuery("SELECT titulo FROM EVENTO ",null);
        Cursor filaini = BaseDeDatos.rawQuery("SELECT fecha_inicio FROM EVENTO ",null);
        Cursor filafin = BaseDeDatos.rawQuery("SELECT fecha_fin FROM EVENTO ",null);
        Cursor filadesc = BaseDeDatos.rawQuery("SELECT descripcion FROM EVENTO ",null);

        i = 0;
        while(filatit.moveToNext()){
            fruits[i] = (filatit.getString(0));

            i = i + 1;
        }

        // Create a List from String Array elements
        List<String> fruits_list = new ArrayList<String>(Arrays.asList(fruits));

        // Create a ArrayAdapter from List
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, fruits_list);

        // Populate ListView with items from ArrayAdapter
        lv.setAdapter(arrayAdapter);

        // Set an item click listener for ListView
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item text from ListView
                String selectedItem = (String) parent.getItemAtPosition(position);


                Intent intent = new Intent(getBaseContext(), ActivityEventoEstudioInfo.class);

                intent.putExtra("EXTRA_SESSION_ID", selectedItem);
                startActivity(intent);

            }
        });
    }

}