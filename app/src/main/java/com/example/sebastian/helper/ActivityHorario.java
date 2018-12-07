package com.example.sebastian.helper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityHorario extends AppCompatActivity {

    private EditText et_codigo, et_lua, et_lub, et_luc, et_lud, et_lue, et_luf, et_maa, et_mab, et_mac, et_mad, et_mae, et_maf, et_mia, et_mib, et_mic, et_mid, et_mie, et_mif, et_jua, et_jub, et_juc, et_jud, et_jue, et_juf, et_via, et_vib, et_vic, et_vid, et_vie, et_vif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario);

        et_codigo = (EditText)findViewById(R.id.txt_codigo);
        et_lua = (EditText)findViewById(R.id.txt_lua);
        et_lub = (EditText)findViewById(R.id.txt_lub);
        et_luc = (EditText)findViewById(R.id.txt_luc);
        et_lud = (EditText)findViewById(R.id.txt_lud);
        et_lue = (EditText)findViewById(R.id.txt_lue);
        et_luf = (EditText)findViewById(R.id.txt_luf);
        et_maa = (EditText)findViewById(R.id.txt_maa);
        et_mab = (EditText)findViewById(R.id.txt_mab);
        et_mac = (EditText)findViewById(R.id.txt_mac);
        et_mad = (EditText)findViewById(R.id.txt_mad);
        et_mae = (EditText)findViewById(R.id.txt_mae);
        et_maf = (EditText)findViewById(R.id.txt_maf);
        et_mia = (EditText)findViewById(R.id.txt_mia);
        et_mib = (EditText)findViewById(R.id.txt_mib);
        et_mic = (EditText)findViewById(R.id.txt_mic);
        et_mid = (EditText)findViewById(R.id.txt_mid);
        et_mie = (EditText)findViewById(R.id.txt_mie);
        et_mif = (EditText)findViewById(R.id.txt_mif);
        et_jua = (EditText)findViewById(R.id.txt_jua);
        et_jub = (EditText)findViewById(R.id.txt_jub);
        et_juc = (EditText)findViewById(R.id.txt_juc);
        et_jud = (EditText)findViewById(R.id.txt_jud);
        et_jue = (EditText)findViewById(R.id.txt_jue);
        et_juf = (EditText)findViewById(R.id.txt_juf);
        et_via = (EditText)findViewById(R.id.txt_via);
        et_vib = (EditText)findViewById(R.id.txt_vib);
        et_vic = (EditText)findViewById(R.id.txt_vic);
        et_vid = (EditText)findViewById(R.id.txt_vid);
        et_vie = (EditText)findViewById(R.id.txt_vie);
        et_vif = (EditText)findViewById(R.id.txt_vif);
    }

    public void Registrar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();
        String lua = et_lua.getText().toString();
        String lub = et_lub.getText().toString();
        String luc = et_luc.getText().toString();
        String lud = et_lud.getText().toString();
        String lue = et_lue.getText().toString();
        String luf = et_luf.getText().toString();
        String maa = et_maa.getText().toString();
        String mab = et_mab.getText().toString();
        String mac = et_mac.getText().toString();
        String mad = et_mad.getText().toString();
        String mae = et_mae.getText().toString();
        String maf = et_maf.getText().toString();
        String mia = et_mia.getText().toString();
        String mib = et_mib.getText().toString();
        String mic = et_mic.getText().toString();
        String mid = et_mid.getText().toString();
        String mie = et_mie.getText().toString();
        String mif = et_mif.getText().toString();
        String jua = et_jua.getText().toString();
        String jub = et_jub.getText().toString();
        String juc = et_juc.getText().toString();
        String jud = et_jud.getText().toString();
        String jue = et_jue.getText().toString();
        String juf = et_juf.getText().toString();
        String via = et_via.getText().toString();
        String vib = et_vib.getText().toString();
        String vic = et_vic.getText().toString();
        String vid = et_vid.getText().toString();
        String vie = et_vie.getText().toString();
        String vif = et_vif.getText().toString();

        ContentValues registro = new ContentValues();
        registro.put("codigo", codigo);
        registro.put("dialua", lua);
        registro.put("dialub", lub);
        registro.put("dialuc", luc);
        registro.put("dialud", lud);
        registro.put("dialue", lue);
        registro.put("dialuf", luf);
        registro.put("diamaa", maa);
        registro.put("diamab", mab);
        registro.put("diamac", mac);
        registro.put("diamad", mad);
        registro.put("diamae", mae);
        registro.put("diamaf", maf);
        registro.put("diamia", mia);
        registro.put("diamib", mib);
        registro.put("diamic", mic);
        registro.put("diamid", mid);
        registro.put("diamie", mie);
        registro.put("diamif", mif);
        registro.put("diajua", jua);
        registro.put("diajub", jub);
        registro.put("diajuc", juc);
        registro.put("diajud", jud);
        registro.put("diajue", jue);
        registro.put("diajuf", juf);
        registro.put("diavia", via);
        registro.put("diavib", vib);
        registro.put("diavic", vic);
        registro.put("diavid", vid);
        registro.put("diavie", vie);
        registro.put("diavif", vif);

        BaseDeDatos.insert("HORARIO", null, registro);
        BaseDeDatos.close();

        et_lua.setText("");
        et_lub.setText("");
        et_luc.setText("");
        et_lud.setText("");
        et_lue.setText("");
        et_luf.setText("");
        et_maa.setText("");
        et_mab.setText("");
        et_mac.setText("");
        et_mad.setText("");
        et_mae.setText("");
        et_maf.setText("");
        et_mia.setText("");
        et_mib.setText("");
        et_mic.setText("");
        et_mid.setText("");
        et_mie.setText("");
        et_mif.setText("");
        et_jua.setText("");
        et_jub.setText("");
        et_juc.setText("");
        et_jud.setText("");
        et_jue.setText("");
        et_juf.setText("");
        et_via.setText("");
        et_vib.setText("");
        et_vic.setText("");
        et_vid.setText("");
        et_vie.setText("");
        et_vif.setText("");

        Toast.makeText(this, "Registro exitoso", Toast.LENGTH_LONG).show();
    }

    //metodo para consultar

    public void Buscar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();

        if(!codigo.isEmpty()){
            Cursor fila = BaseDeDatos.rawQuery("SELECT dialua, dialub, dialuc, dialud, dialue, dialuf, diamaa, diamab, diamac, diamad, diamae, diamaf, diamia, diamib, diamic, diamid, diamie, diamif, diajua, diajub, diajuc, diajud, diajue, diajuf, diavia, diavib, diavic, diavid, diavie, diavif FROM HORARIO WHERE codigo =" + codigo,null);

            if (fila.moveToFirst()) {
                et_lua.setText(fila.getString(0));
                et_lub.setText(fila.getString(1));
                et_luc.setText(fila.getString(2));
                et_lud.setText(fila.getString(3));
                et_lue.setText(fila.getString(4));
                et_luf.setText(fila.getString(5));
                et_maa.setText(fila.getString(6));
                et_mab.setText(fila.getString(7));
                et_mac.setText(fila.getString(8));
                et_mad.setText(fila.getString(9));
                et_mae.setText(fila.getString(10));
                et_maf.setText(fila.getString(11));
                et_mia.setText(fila.getString(12));
                et_mib.setText(fila.getString(13));
                et_mic.setText(fila.getString(14));
                et_mid.setText(fila.getString(15));
                et_mie.setText(fila.getString(16));
                et_mif.setText(fila.getString(17));
                et_jua.setText(fila.getString(18));
                et_jub.setText(fila.getString(19));
                et_juc.setText(fila.getString(20));
                et_jud.setText(fila.getString(21));
                et_jue.setText(fila.getString(22));
                et_juf.setText(fila.getString(23));
                et_via.setText(fila.getString(24));
                et_vib.setText(fila.getString(25));
                et_vic.setText(fila.getString(26));
                et_vid.setText(fila.getString(27));
                et_vie.setText(fila.getString(28));
                et_vif.setText(fila.getString(29));
                BaseDeDatos.close();
            } else{
                Toast.makeText(this, "No existe el horario", Toast.LENGTH_LONG).show();
                BaseDeDatos.close();
            }


        } else{
            Toast.makeText(this, "Introduce el numero de horario", Toast.LENGTH_LONG).show();
        }
    }

    //metodo para modificar

    public void Modificar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();
        String lua = et_lua.getText().toString();
        String lub = et_lub.getText().toString();
        String luc = et_luc.getText().toString();
        String lud = et_lud.getText().toString();
        String lue = et_lue.getText().toString();
        String luf = et_luf.getText().toString();
        String maa = et_maa.getText().toString();
        String mab = et_mab.getText().toString();
        String mac = et_mac.getText().toString();
        String mad = et_mad.getText().toString();
        String mae = et_mae.getText().toString();
        String maf = et_maf.getText().toString();
        String mia = et_mia.getText().toString();
        String mib = et_mib.getText().toString();
        String mic = et_mic.getText().toString();
        String mid = et_mid.getText().toString();
        String mie = et_mie.getText().toString();
        String mif = et_mif.getText().toString();
        String jua = et_jua.getText().toString();
        String jub = et_jub.getText().toString();
        String juc = et_juc.getText().toString();
        String jud = et_jud.getText().toString();
        String jue = et_jue.getText().toString();
        String juf = et_juf.getText().toString();
        String via = et_via.getText().toString();
        String vib = et_vib.getText().toString();
        String vic = et_vic.getText().toString();
        String vid = et_vid.getText().toString();
        String vie = et_vie.getText().toString();
        String vif = et_vif.getText().toString();

        if(!codigo.isEmpty() && !lua.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("dialua", lua);
            registro.put("dialub", lub);
            registro.put("dialuc", luc);
            registro.put("dialud", lud);
            registro.put("dialue", lue);
            registro.put("dialuf", luf);
            registro.put("diamaa", maa);
            registro.put("diamab", mab);
            registro.put("diamac", mac);
            registro.put("diamad", mad);
            registro.put("diamae", mae);
            registro.put("diamaf", maf);
            registro.put("diamia", mia);
            registro.put("diamib", mib);
            registro.put("diamic", mic);
            registro.put("diamid", mid);
            registro.put("diamie", mie);
            registro.put("diamif", mif);
            registro.put("diajua", jua);
            registro.put("diajub", jub);
            registro.put("diajuc", juc);
            registro.put("diajud", jud);
            registro.put("diajue", jue);
            registro.put("diajuf", juf);
            registro.put("diavia", via);
            registro.put("diavib", vib);
            registro.put("diavic", vic);
            registro.put("diavid", vid);
            registro.put("diavie", vie);
            registro.put("diavif", vif);

            int cantidad = BaseDeDatos.update("HORARIO", registro, "codigo=" + codigo, null);
            BaseDeDatos.close();
            if(cantidad == 1){
                Toast.makeText(this,"Articulo nodificado correctamente", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "Debes llenar los campos de código", Toast.LENGTH_LONG).show();
            }

        }else{
            Toast.makeText(this, "Debes llenar los campos", Toast.LENGTH_LONG).show();
        }

    }
}
