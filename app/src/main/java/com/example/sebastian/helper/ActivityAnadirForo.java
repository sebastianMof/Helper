package com.example.sebastian.helper;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityAnadirForo extends AppCompatActivity {

    private EditText et_ramo, et_titulo, et_descrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_foro);

        et_ramo = (EditText)findViewById(R.id.ram_txt);
        et_titulo = (EditText)findViewById(R.id.tit_txt);
        et_descrip = (EditText)findViewById(R.id.des_txt);
    }

    public void Registrar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String ramo = et_ramo.getText().toString();
        String titulo = et_titulo.getText().toString();
        String descripcion = et_descrip.getText().toString();

        ContentValues registro = new ContentValues();
        registro.put("titulo", titulo);
        registro.put("ramo", ramo);
        registro.put("descripcion", descripcion);

        BaseDeDatos.insert("FORO", null, registro);
        BaseDeDatos.close();

        et_titulo.setText("");
        et_ramo.setText("");
        et_descrip.setText("");

        Toast.makeText(this, "Registro exitoso", Toast.LENGTH_LONG).show();

    }
}
