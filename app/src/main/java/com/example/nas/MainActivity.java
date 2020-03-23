package com.example.nas;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends registro {
    SQLiteDatabase.CursorFactory factory;
    registroSQLite nas;
    private EditText ed_Correo, ed_Contrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nas= new registroSQLite(this);
        ed_Correo=(EditText)findViewById(R.id.txtcorreoL);
        ed_Contrasena=(EditText)findViewById(R.id.txtcontraseñaL);
    }
    public void siguiente(View view){
        try {
            registroSQLite reg = new registroSQLite(this);
            SQLiteDatabase registroSQLite= reg.getWritableDatabase();

            String Correo=ed_Correo.getText().toString();
            String Contrasena=ed_Contrasena.getText().toString();

            if(Correo=="andreatehortua613@gmail.com" && Contrasena=="123"){

            }else{
                if(!Correo.isEmpty() && !Contrasena.isEmpty() ){
                    if (nas.validar(Correo,Contrasena)){
                        Intent atras =new Intent(this, padre.class );
                        startActivity(atras);

                         ed_Correo.setText("");
                        ed_Contrasena.setText("");
                    }else{
                        Toast.makeText(this,"El usuario o contraseña son incorrectos",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    String errorString = "Debe llenar todos los campos";
                    Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
                }

            }


        }catch (Exception e){
            System.err.print("Error"+e);
        }
    }
    public void registro(View view){
        Intent registro =new Intent(this, registro.class );
        startActivity(registro);
    }

}
