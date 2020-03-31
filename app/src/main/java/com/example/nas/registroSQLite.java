package com.example.nas;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.widget.Toast;

import com.example.nas.condiciones.usuario;

public class registroSQLite extends SQLiteOpenHelper{
    public registroSQLite(Context context) {
        super(context, "nas",  null, 1);
    }

    public boolean validar(String Correo, String Contrasena, String rol){
        String sql ="select count(*) from usuarios where Correo='" +Correo+"' and Contrasena='"+Contrasena+"' and rol='"+rol+"'";
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

        nas.execSQL("create table usuarios(Cedula integer primary key ,Nombre text," +
                "Telefono int,Direccion text,Correo text,Contrasena text, rol text)");

        nas.execSQL("create table tbl_solicitud(id_solicitud integer primary key AUTOINCREMENT,Cantidad_soli float," +
                "Horasoli float,Precio_soli float, Especificar_soli text)");

        nas.execSQL("create table tbl_reserva(id_reserva integer primary key AUTOINCREMENT,Nombre_reser text," +
                "Precio_reser float, Numeroni_reser int, Fecha_reser data, Hora_reser time)");

        //nas.execSQL("insert into usuarios(Correo,Contrasena) values ('andreatehortua613@gmal.com','123')");
    }
    @Override
    public void onUpgrade(SQLiteDatabase nas, int oldVersion, int newVersion) {
        nas.execSQL("drop table if exists usuarios");
        nas.execSQL("create table usuarios(Cedula integer primary key ,Nombre text," +
                "Telefono int,Direccion text,Correo text,Contrasena text, rol text)");

        nas.execSQL("drop table if exists solicitud");
        nas.execSQL("create table tbl_solicitud(id_solicitud integer primary key AUTOINCREMENT,Cantidad_soli float," +
                "Horasoli float,Precio_soli float, Especificar_soli text)");

        nas.execSQL("drop table if exists reserva");
        nas.execSQL("create table tbl_reserva(id_reserva integer primary key AUTOINCREMENT,Nombre_reser text," +
                "Precio_reser float, Numeroni_reser int, Fecha_reser data, Hora_reser time)");

    }
    public usuario buscar(usuario usuario, String Cedula){
        SQLiteDatabase registroSQLite= getReadableDatabase();
        Cursor cursor =registroSQLite.rawQuery("select Cedula, Telefono, Correo, Direccion  from usuarios where Cedula='"+Cedula+"'", null);
        if(cursor.moveToFirst()){
            do{
                usuario.setTelefono(cursor.getString(1));
                usuario.setCorreo(cursor.getString(2));
                usuario.setDireccion(cursor.getString(3));
            }while(cursor.moveToNext());
        }
        return usuario;
    }
    public void actualizar(String Cedula, String Telefono, String Correo, String Direccion){
        SQLiteDatabase registroSQLite=getWritableDatabase();
        if(registroSQLite!=null){
            registroSQLite.execSQL("update usuarios set Telefono='"+Telefono+"', Correo='"+Correo+"', Direccion='"+Direccion+"'" +
                    " where Cedula='"+Cedula+"'");
            registroSQLite.close();
        }
    }
    public void eliminar(String Cedula){
        SQLiteDatabase registroSQLite=getWritableDatabase();
        if(registroSQLite!=null){
            registroSQLite.execSQL("delete from usuarios where Cedula='"+Cedula+"'");
            registroSQLite.close();
        }
    }
}
