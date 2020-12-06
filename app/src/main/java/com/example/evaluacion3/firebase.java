package com.example.evaluacion3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.FirebaseApp;

import java.util.UUID;

import Datos.Clientes;

public class firebase extends AppCompatActivity {
    private EditText nombrefr, destinofr, promocionfr;
    private Button guardar;

    FirebaseDatabase firebase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

        nombrefr= (EditText)findViewById(R.id.nombrefirebase);
        destinofr= (EditText)findViewById(R.id.destinofirebase);
        promocionfr= (EditText)findViewById(R.id.promocionfirebase);
        guardar= (Button)findViewById(R.id.guardarbutt);
        inicializar();
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((!nombrefr.getText().equals(""))&&(!destinofr.getText().equals("")) && (!promocionfr.getText().equals(""))){
                    Clientes c= new Clientes();

                    c.setId(UUID.randomUUID().toString());
                    c.setNombre(nombrefr.getText().toString());
                    c.setDestino(destinofr.getText().toString());
                    c.setPromocion(promocionfr.getText().toString());

                    databaseReference.child("Clientes").child(c.getId()).setValue(c);



                }
            }
        });

    }

    public void inicializar (){
        FirebaseApp.initializeApp(this);
        firebase= FirebaseDatabase.getInstance();
        databaseReference= firebase.getReference();
    }
    public void listado (View v){
        Intent i= new Intent(getBaseContext(), Listado.class);
        startActivity(i);
    }

}