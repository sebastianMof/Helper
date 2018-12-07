package com.example.sebastian.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) {
        BaseDeDatos.execSQL("CREATE TABLE HORARIO (codigo integer primary key, id_usuario text, dialua text, dialub text, dialuc text, dialud text, dialue text, dialuf text, diamaa text, diamab text, diamac text, diamad text, diamae text, diamaf text, diamia text, diamib text, diamic text, diamid text, diamie text, diamif text, diajua text, diajub text, diajuc text, diajud text, diajue text, diajuf text, diavia text, diavib text, diavic text, diavid text, diavie text, diavif text, FOREIGN KEY (id_usuario) REFERENCES USUARIO(rut))");
        BaseDeDatos.execSQL("CREATE TABLE REUNION (id integer primary key, id_proyecto integer, nombre text, descripcion text, lugar text, fecha_hora_inicio numeric, fecha_hora_fin numeric, FOREIGN KEY (id_proyecto) REFERENCES PROYECTO(id)) ");
        BaseDeDatos.execSQL("CREATE TABLE PROYECTO (id integer primary key, nombre text, descripcion text, fecha_inicio numeric, fecha_fin numeric)");
        BaseDeDatos.execSQL("CREATE TABLE TAREA (id integer primary key, id_proyecto integer, fecha_inicio numeric, fecha_fin numeric, nombre text, descripcion text, FOREIGN KEY (id_proyecto) REFERENCES PROYECTO(id))");
        BaseDeDatos.execSQL("CREATE TABLE CONTACTO (id integer primary key, id_usuario text, nombre text, correo text, fono text, FOREIGN KEY (id_usuario) REFERENCES USUARIO(rut))");
        BaseDeDatos.execSQL("CREATE TABLE USUARIO (rut text primary key, id_curso text, id_proyecto integer, pass text, universidad text, nombre text, apellido, text, correo text, carrera text, FOREIGN KEY (id_curso) REFERENCES CURSO(id), FOREIGN KEY (id_proyecto) REFERENCES PROYECTO(id))");
        BaseDeDatos.execSQL("CREATE TABLE ACTIVIDAD (id integer primary key, id_curso text, nombre text, descripcion text, fecha_inicio numeric, fecha_fin numeric, FOREIGN KEY (id_curso) REFERENCES CURSO(id))");
        BaseDeDatos.execSQL("CREATE TABLE CURSO (id text primary key, id_catedra integer, nombre text, nombre_profesor text, bloque_ayudantia text, FOREIGN KEY (id_catedra) REFERENCES CATEDRA(id))");
        BaseDeDatos.execSQL("CREATE TABLE CATEDRA (id integer primary key, bloque text)");
        BaseDeDatos.execSQL("CREATE TABLE NOTA (id integer primary key, id_curso text, tipo text, calificacion real, FOREIGN KEY (id_curso) REFERENCES CURSO(id))");
        BaseDeDatos.execSQL("CREATE TABLE EVENTO (id integer primary key autoincrement, titulo text, fecha_inicio text, fecha_fin text, descripcion text)");
        BaseDeDatos.execSQL("CREATE TABLE FORO (id integer primary key autoincrement, ramo text, titulo text, descripcion text)");
        BaseDeDatos.execSQL("CREATE TABLE PERFIL (id integer primary key, nombre text, universidad text, compania text, celular text, mail text)");
        BaseDeDatos.execSQL("CREATE TABLE YO (id integer primary key, nombre text, universidad text, compania text, celular text, mail text)");
        BaseDeDatos.execSQL("INSERT INTO YO (id,nombre, universidad, compania, celular, mail) VALUES (1,'','','','','')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase BaseDeDatos, int oldVersion, int newVersion) {

    }
}
