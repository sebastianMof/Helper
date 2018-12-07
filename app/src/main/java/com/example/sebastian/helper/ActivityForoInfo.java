package com.example.sebastian.helper;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityForoInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foro_info);

        TextView titulo, descripcion;

        String sessionId = getIntent().getStringExtra("EXTRA_SESSION_ID2");

        titulo = (TextView) findViewById(R.id.titinfo);
        descripcion = (TextView) findViewById(R.id.descinfo);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        Cursor filatit = BaseDeDatos.rawQuery("SELECT titulo FROM FORO WHERE titulo = ?; ", new String[]{sessionId});
        Cursor filadesc = BaseDeDatos.rawQuery("SELECT descripcion FROM FORO WHERE titulo = ?; ", new String[]{sessionId});

        if (filatit.moveToFirst() && filadesc.moveToFirst()) {
            titulo.setText(filatit.getString(0));
            descripcion.setText(filadesc.getString(0));
            BaseDeDatos.close();
        }
    }
}
