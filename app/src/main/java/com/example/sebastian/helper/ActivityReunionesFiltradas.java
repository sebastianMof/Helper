package com.example.sebastian.helper;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class ActivityReunionesFiltradas extends AppCompatActivity {

    ListView et_listViewEve;
    ArrayList<String> listaTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reuniones_filtradas);

        et_listViewEve = (ListView)findViewById(R.id.listViewReunionesFiltradas);

        String dato = getIntent().getStringExtra("dato");

        consultarLista(dato);

        ArrayAdapter adaptador = new ArrayAdapter(this,android.R.layout.simple_list_item_2,android.R.id.text1,listaTitulo);
        et_listViewEve.setAdapter(adaptador);

        configureListViewClick(et_listViewEve);

        configureButtonVolverADespliegueProyecto(dato);
    }

    private void consultarLista(String dato) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        listaTitulo = new ArrayList<String>();

        Cursor filatit = BaseDeDatos.rawQuery("SELECT REUNION.nombre FROM REUNION INNER JOIN PROYECTO ON PROYECTO.id = REUNION.id_proyecto WHERE PROYECTO.nombre = ? ",new String[]{dato});

        while(filatit.moveToNext()){
            listaTitulo.add(filatit.getString(0));
        }

    }

    private void configureListViewClick(final ListView et_listViewEve) {

        et_listViewEve.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object item = et_listViewEve.getItemAtPosition(position);
                String name = item.toString();

                Intent i = new Intent(ActivityReunionesFiltradas.this, ActivityDespliegueReunion.class);
                i.putExtra("dato", name);
                startActivity(i);
                finish();

            }
        });
    }

    private void configureButtonVolverADespliegueProyecto(final String dato) {
        Button nextButton = (Button)findViewById(R.id.botonVolverADespliegueProyecto);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityReunionesFiltradas.this, ActivityDespliegueProyecto.class);
                i.putExtra("dato", dato);
                startActivity(i);
                finish();
            }
        });
    }


}
