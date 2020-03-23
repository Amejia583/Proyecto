package com.example.nas;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }

    //metodo boton anterior
    public void niñera(View view){
        Intent niñera =new Intent(this, registro.class );
        startActivity(niñera);
    }
    public void padre(View view){
        Intent padre =new Intent(this, registropadre.class );
        startActivity(padre);
    }
    public void atras(View view){
        Intent atras =new Intent(this, MainActivity.class );
        startActivity(atras);
    }
}
