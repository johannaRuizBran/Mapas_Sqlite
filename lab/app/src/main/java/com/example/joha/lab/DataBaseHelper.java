package com.example.joha.lab;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class DataBaseHelper extends SQLiteOpenHelper {

    // Cada vez que cambie el esquema de la base de datos DataBaseContract,

    // debemos incrementar la version de la base de datos
    public static final int DATABASE_VERSION = 2;
    // Nombre de la base de datos
    public static final String DATABASE_NAME = "AndroidStorage.db";

    // constructor de la clase, el contexto tiene la informacion global sobre el ambiente de la app
    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    /*
        public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
            super(context, name, factory, version, errorHandler);
        }
    */
    // implementamos el metodo para la creacion de la base de datos
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Crear la base de datos de la app
        sqLiteDatabase.execSQL(DataBaseContract.SQL_CREATE_TEC);
    }

    public void insertarUsuario(){

    }

    // implementamos el metodo para la actualizacion de la base de datos
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
// Administracion de actualizaciones

        sqLiteDatabase.execSQL(DataBaseContract.SQL_DELETE_TEC);
        onCreate(sqLiteDatabase);
    }

    // inplementamos el metodo para volver a la version anterior de la base de datos
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
}