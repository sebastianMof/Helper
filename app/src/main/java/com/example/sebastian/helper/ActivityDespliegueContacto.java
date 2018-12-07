package com.example.sebastian.helper;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityDespliegueContacto extends AppCompatActivity {


    private TextView tv1c;
    private TextView tv2c;
    private TextView tv3c;
    private TextView tv4c;
    private TextView tv5c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_despliegue_contacto);

        tv1c = (TextView)findViewById(R.id.nombreContacto);
        tv2c = (TextView)findViewById(R.id.universidadContacto);
        tv3c = (TextView)findViewById(R.id.companiaContacto);
        tv4c = (TextView)findViewById(R.id.celularContacto);
        tv5c = (TextView)findViewById(R.id.mailContacto);

        String dato = getIntent().getStringExtra("dato");
        consultarContacto(dato);

    }

    private void consultarContacto(String dato) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        Cursor miQuery = BaseDeDatos.rawQuery("SELECT nombre, universidad , compania, celular, mail FROM PERFIL WHERE nombre = ?",new String[] {dato});

        if (miQuery.moveToFirst()) {

            tv1c.setText("Nombre: " + miQuery.getString(miQuery.getColumnIndex("nombre")));
            tv2c.setText("Universidad: " + miQuery.getString(miQuery.getColumnIndex("universidad")));
            tv3c.setText("Compañia: " + miQuery.getString(miQuery.getColumnIndex("compania")));
            tv4c.setText("Celular: " + miQuery.getString(miQuery.getColumnIndex("celular")));
            tv5c.setText("Mail: " + miQuery.getString(miQuery.getColumnIndex("mail")));

        }

    }





}
