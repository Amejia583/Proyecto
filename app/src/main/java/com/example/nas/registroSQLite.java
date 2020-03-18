package com.example.nas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class registroSQLite extends SQLiteOpenHelper{
    public registroSQLite(Context context) {
        super(context, "nas",  null, 1);
    }
    public boolean validar(String Correo, String Contrasena){
        String sql ="select count(*) from usuarios where Correo='" +Correo+"' and Contrasena='"+Contrasena+"'";
        SQLiteStatement statement= getReadableDatabase().compileStatement(sql);
        long valor=statement.simpleQueryForLong();
        if(valor==1){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public void onCreate(SQLiteDatabase nas) {
        nas.execSQL("create table usuarios(id_usuario integer primary key AUTOINCREMENT,Nombre text,Cedula int," +
                "Telefono int,Direccion text,Correo text,Contrasena text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
