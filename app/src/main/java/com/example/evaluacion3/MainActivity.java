package com.example.evaluacion3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public EditText nombre, pass, edit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void inicio(View v){
        String nombre= ((EditText)findViewById(R.id.usuario)).getText().toString();
        String pass= ((EditText)findViewById(R.id.contraseña)).getText().toString();
        if (nombre.equalsIgnoreCase("Android")&& pass.equalsIgnoreCase("123")){
            Intent i=new Intent(getBaseContext(),menu.class) ;
            startActivity(i);


        }

    }


}