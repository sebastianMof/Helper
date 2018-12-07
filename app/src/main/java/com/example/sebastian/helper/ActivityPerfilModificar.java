package com.example.sebastian.helper;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class ActivityPerfilModificar extends AppCompatActivity {

    private EditText et_nombreC;
    private EditText et_universidadC;
    private EditText et_CompaniaC;
    private EditText et_CelularC;
    private EditText et_MailC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_modificar);

        et_nombreC = (EditText)findViewById(R.id.modificarContactoNombre);
        et_universidadC = (EditText)findViewById(R.id.modificarContactoUniversidad);
        et_CompaniaC = (EditText)findViewById(R.id.modificarContactoCompania);
        et_CelularC = (EditText)findViewById(R.id.modificarContactoCelular);
        et_MailC = (EditText)findViewById(R.id.modificarContactoMail);


    }

    public void Registrar(View view) throws IOException {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String nombreNew = et_nombreC.getText().toString();
        String universidadNew = et_universidadC.getText().toString();
        String companiaNew = et_CompaniaC.getText().toString();
        String celularNew = et_CelularC.getText().toString();
        String mailNew = et_MailC.getText().toString();

        ContentValues registro = new ContentValues();

        registro.put("nombre", nombreNew);
        registro.put("universidad", universidadNew);
        registro.put("compania", companiaNew);
        registro.put("celular", celularNew);
        registro.put("mail", mailNew);

        BaseDeDatos.execSQL("UPDATE YO SET nombre = '"+ nombreNew +"', universidad = '"+universidadNew+"', compania = '"+companiaNew+"', celular = '"+celularNew+"', mail = '"+mailNew+"' WHERE id = 1");

        BaseDeDatos.close();

        finish();
        Intent i = new Intent(ActivityPerfilModificar.this, ActivityPerfil.class);
        startActivity(i);

    }


}
