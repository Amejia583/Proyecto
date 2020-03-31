package com.example.nas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.nas.condiciones.usuario;

public class Actualizarninera extends AppCompatActivity {

    private EditText ed_Cedula, ed_Telefono, ed_Direccion, ed_Correo;
    Button btnActualizarpadre, btnbuscar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizarninera);

        ed_Cedula=(EditText)findViewById(R.id.cedula2);
        ed_Telefono=(EditText)findViewById(R.id.telefono2);
        ed_Direccion=(EditText)findViewById(R.id.direccion2);
        ed_Correo=(EditText)findViewById(R.id.correo2);
        btnbuscar1=(Button)findViewById(R.id.btnbuscar1);

        final registroSQLite registroSQLite = new registroSQLite(getApplicationContext());

        btnbuscar1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                usuario usuario=new usuario();
                registroSQLite.buscar(usuario, ed_Cedula.getText().toString());
                ed_Telefono.setText(usuario.getTelefono());
                ed_Correo.setText(usuario.getCorreo());
                ed_Direccion.setText(usuario.getDireccion());
            }
        });

    }

}
