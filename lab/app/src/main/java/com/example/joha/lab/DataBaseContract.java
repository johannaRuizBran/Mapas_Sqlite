package com.example.joha.lab;

import android.provider.BaseColumns;

public class DataBaseContract {
    private DataBaseContract(){}

    // Implementa la interfaz BaseColumns para heredar campos estandar del marco de Android _ID

    public static class DataBaseEntry implements BaseColumns {
        public static final String TABLE_TEC = "TEC";
        public static final String COLUMN_NAME_NOMBRE = "nombre";
        public static final String COLUMN_NAME_LATTUD = "latitud";
        public static final String COLUMN_NAME_LONGITUD = "longitud";
        public static final String COLUMN_NAME_DESCRIPCION = "descripcion";
    }

// Construir las tablas de la base de datos

    private static final String TEXT_TYPE = " TEXT";

    private static final String INTEGER_TYPE = " INTEGER";

    private static final String REAL_TYPE = " REAL";

    private static final String COMMA_SEP = ",";


    // Creacion de tablas Persona, Estudiante, Funcionario

    public static final String SQL_CREATE_TEC =
            "CREATE TABLE " + DataBaseEntry.TABLE_TEC + " (" +
                    DataBaseEntry._ID + TEXT_TYPE + "PRIMARY KEY" +COMMA_SEP+
                    DataBaseEntry.COLUMN_NAME_NOMBRE + TEXT_TYPE + COMMA_SEP +
                    DataBaseEntry.COLUMN_NAME_LATTUD + TEXT_TYPE + COMMA_SEP +
                    DataBaseEntry.COLUMN_NAME_DESCRIPCION + TEXT_TYPE + COMMA_SEP +
                    DataBaseEntry.COLUMN_NAME_LONGITUD + TEXT_TYPE + " )";

    public static final String SQL_DELETE_TEC =
            "DROP TABLE IF EXISTS " + DataBaseEntry.TABLE_TEC;
}
