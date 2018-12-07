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
        Cambiar();
        Consulta();

    }

    //Metodos
    public void Registrar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        ContentValues registro= new ContentValues();

        int cod = 2;
        String name = "Demian Chocolito";
        String uni = "Universidad Diego Portales";
        String emp = "Sensei sugoi";
        String cel = "+56 9 8765 4321";
        String mal = "demian.chocolito@mail.udp.cl";

        registro.put( "codigo", cod);
        registro.put( "nombre", name);
        registro.put( "universidad", uni);
        registro.put( "compania", emp);
        registro.put( "celular", cel);
        registro.put( "mail", mal);

        BaseDeDatos.insert("Perfil", null, registro);
        BaseDeDatos.close();
        Toast.makeText(this, "Se agrego yay", Toast.LENGTH_SHORT).show();


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

    public void Cambiar() {
        Button nextButton = (Button)findViewById(R.id.botoncambiar);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Perfilis.this, ActivityContacto.class));
            }
        });
    }



}
