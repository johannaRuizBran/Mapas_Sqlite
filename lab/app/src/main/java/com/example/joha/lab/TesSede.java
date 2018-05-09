package com.example.joha.lab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import junit.framework.TestCase;

import java.util.ArrayList;

public class TesSede {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String nombre;
    private String latitud;
    private String longitud;
    private String descripcion;

    public TesSede(String nombre, String latitud, String longitud, String descripcion,String id) {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.descripcion = descripcion;
        this.id= id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public long insertar(Context context) {

        long newRowId = 0;
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DataBaseContract.DataBaseEntry._ID, getId());
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_NOMBRE, getNombre());
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_LATTUD, getLatitud());
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_LONGITUD, getLongitud());
        values.put(DataBaseContract.DataBaseEntry.COLUMN_NAME_DESCRIPCION, getDescripcion());
        newRowId = db.insert(DataBaseContract.DataBaseEntry.TABLE_TEC, null, values);

        return newRowId;
    }

    public ArrayList<TesSede> leer (Context context){
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);
        SQLiteDatabase db = dataBaseHelper.getReadableDatabase();
        String[] projection = {DataBaseContract.DataBaseEntry._ID, DataBaseContract.DataBaseEntry.COLUMN_NAME_NOMBRE,
                DataBaseContract.DataBaseEntry.COLUMN_NAME_LATTUD, DataBaseContract.DataBaseEntry.COLUMN_NAME_DESCRIPCION,
                DataBaseContract.DataBaseEntry.COLUMN_NAME_LONGITUD
        };

        Cursor cursor = db.query(
                DataBaseContract.DataBaseEntry.TABLE_TEC, // tabla
                projection, // columnas
                null, // where
                null, // valores del where
                null, // agrupamiento
                null, // filtros por grupo
                null // orden
        );

        ArrayList<TesSede> lista = new ArrayList<TesSede>();
        if (cursor.moveToFirst()){
            String nombre = cursor.getString(cursor.getColumnIndex(DataBaseContract.DataBaseEntry.COLUMN_NAME_NOMBRE));
            String longi = cursor.getString(cursor.getColumnIndex(DataBaseContract.DataBaseEntry.COLUMN_NAME_LONGITUD));
            String latitud = cursor.getString(cursor.getColumnIndex(DataBaseContract.DataBaseEntry.COLUMN_NAME_LATTUD));
            String desc = cursor.getString(cursor.getColumnIndex(DataBaseContract.DataBaseEntry.COLUMN_NAME_DESCRIPCION));
            String id = cursor.getString(cursor.getColumnIndex(DataBaseContract.DataBaseEntry._ID));

            TesSede nuevo= new TesSede(nombre,latitud,longi,desc,id);
            lista.add(nuevo);

            while(cursor.moveToNext()){
                nombre = cursor.getString(cursor.getColumnIndex(DataBaseContract.DataBaseEntry.COLUMN_NAME_NOMBRE));
                longi = cursor.getString(cursor.getColumnIndex(DataBaseContract.DataBaseEntry.COLUMN_NAME_LONGITUD));
                latitud = cursor.getString(cursor.getColumnIndex(DataBaseContract.DataBaseEntry.COLUMN_NAME_LATTUD));
                desc = cursor.getString(cursor.getColumnIndex(DataBaseContract.DataBaseEntry.COLUMN_NAME_DESCRIPCION));
                id = cursor.getString(cursor.getColumnIndex(DataBaseContract.DataBaseEntry._ID));
                nuevo= new TesSede(nombre,latitud,longi,desc,id);
                lista.add(nuevo);
            }
        }
        return lista;
    }

    public void leer (Context context, String identificacion){
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);
        SQLiteDatabase db = dataBaseHelper.getReadableDatabase();
        String[] projection = {DataBaseContract.DataBaseEntry._ID, DataBaseContract.DataBaseEntry.COLUMN_NAME_NOMBRE,
                DataBaseContract.DataBaseEntry.COLUMN_NAME_LATTUD, DataBaseContract.DataBaseEntry.COLUMN_NAME_DESCRIPCION,
                DataBaseContract.DataBaseEntry.COLUMN_NAME_LONGITUD
        };
        String selection = DataBaseContract.DataBaseEntry._ID + " = ?";
        String[] selectionArgs = {identificacion};
        Cursor cursor = db.query(
                DataBaseContract.DataBaseEntry.TABLE_TEC, // tabla
                projection, // columnas
                selection, // where
                selectionArgs, // valores del where
                null, //agrupamiento
                null, // filtros por grupo
                null // orden
        );

        if (cursor.moveToFirst() && cursor.getCount() > 0) {

        }
    }
}
