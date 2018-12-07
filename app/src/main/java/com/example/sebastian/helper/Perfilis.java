package com.example.sebastian.helper;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sebastian.helper.AdminSQLiteOpenHelper;


public class Perfilis extends AppCompatActivity {

    private EditText nombre, universidad, compania, celular, mail;
    //private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfilis);

        String dato = getIntent().getStringExtra("dato");

        nombre= (EditText)findViewById(R.id.Nombre);
        universidad = (EditText)findViewById(R.id.Universidad);
        compania = (EditText)findViewById(R.id.Compania);
        celular = (EditText)findViewById(R.id.Celular);
        mail = (EditText)findViewById(R.id.Mail);

        nombre.setText("");
        universidad.setText("");
        compania.setText("");
        mail.setText("");
        celular.setText("");


        Consulta();

    }

    //Metodos
    public void Registrar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String nombreNew = nombre.getText().toString();
        String universidadNew = universidad.getText().toString();
        String companiaNew = compania.getText().toString();
        String celularNew = celular.getText().toString();
        String mailNew = mail.getText().toString();

        ContentValues registro = new ContentValues();

        registro.put("nombre", nombreNew);
        registro.put("universidad", universidadNew);
        registro.put("compania", companiaNew);
        registro.put("mail", mailNew);
        registro.put("celular", celularNew);

        BaseDeDatos.insert("Perfil", null, registro);
        BaseDeDatos.close();

        nombre.setText("");
        universidad.setText("");
        compania.setText("");
        mail.setText("");
        celular.setText("");

        Toast.makeText(this, "Registro exitoso", Toast.LENGTH_LONG).show();

    }

    //metodo de consulta
    public void Consulta(){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        int codigo = 1;
        Cursor fila = BaseDeDatos.rawQuery("select nombre, universidad, compania, celular, mail from Perfil where codigo =" + codigo, null);
        if(fila.moveToFirst()) {
            nombre.setText(fila.getString(0));
            universidad.setText(fila.getString(1));
            compania.setText(fila.getString(2));
            celular.setText(fila.getString(3));
            mail.setText(fila.getString(4));
            BaseDeDatos.close();
        }

    }





}
