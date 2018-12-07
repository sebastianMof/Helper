package com.example.sebastian.helper;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityPerfil extends AppCompatActivity {

    private TextView tv1p;
    private TextView tv2p;
    private TextView tv3p;
    private TextView tv4p;
    private TextView tv5p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        tv1p = (TextView)findViewById(R.id.nombreYo);
        tv2p = (TextView)findViewById(R.id.universidadYo);
        tv3p = (TextView)findViewById(R.id.companiaYo);
        tv4p = (TextView)findViewById(R.id.celularYo);
        tv5p = (TextView)findViewById(R.id.mailYo);

        consultarYo();
        buttonModificar();
    }

    private void consultarYo() {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        Cursor miQuery = BaseDeDatos.rawQuery("SELECT nombre, universidad , compania, celular, mail FROM YO WHERE id = 1",null);

        if (miQuery.moveToFirst()) {

            tv1p.setText("Nombre: " + miQuery.getString(miQuery.getColumnIndex("nombre")));
            tv2p.setText("Universidad: " + miQuery.getString(miQuery.getColumnIndex("universidad")));
            tv3p.setText("Compañia: " + miQuery.getString(miQuery.getColumnIndex("compania")));
            tv4p.setText("Celular: " + miQuery.getString(miQuery.getColumnIndex("celular")));
            tv5p.setText("Mail: " + miQuery.getString(miQuery.getColumnIndex("mail")));

        }


    }

    private void buttonModificar() {
        Button nextButton = (Button)findViewById(R.id.buttonModificar);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityPerfil.this, ActivityPerfilModificar.class);
                startActivity(i);
                finish();
            }
        });
    }


}
