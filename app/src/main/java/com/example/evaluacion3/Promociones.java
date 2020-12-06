package com.example.evaluacion3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import Datos.Clientes;

public class Promociones extends AppCompatActivity {
    private Spinner spincliente, spinpromo;
    private TextView mostrar, total;
    private Button calcular;
    int pizzapromo, masterpizza, pizzamax;
    private EditText envio;

    FirebaseDatabase firebase;
    DatabaseReference databaseReference;

    Clientes clientesSelected;
    private ArrayList<Clientes> listclientes= new ArrayList<Clientes>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promociones);

        spincliente = (Spinner) findViewById(R.id.spincliente);
        spinpromo= (Spinner) findViewById(R.id.spinpromo);
        mostrar =(TextView) findViewById(R.id.mostext);
        total =(TextView) findViewById(R.id.textoresult);
        envio= (EditText)findViewById(R.id.valorenvio);
        pizzapromo=5990;
        masterpizza=12990;
        pizzamax=18500;

        String[] listapromo ={"Pizzas promo", "Master Pizza", "Pizza Max"};
        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listapromo);
        spinpromo.setAdapter(adapt);

        inicializarbase();

        databaseReference.child("Clientes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot objSnapshot :  snapshot.getChildren()){
                    Clientes c = objSnapshot.getValue(Clientes.class);
                    listclientes.add(c);

                    ArrayAdapter adapt= new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1, listclientes);
                    spincliente.setAdapter(adapt);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });











    }
    String spinpromot = spinpromo.getSelectedItem().toString();

    public void calculo(View v){


        if(spinpromot.equalsIgnoreCase("Pizza Promo")){
            int costo= Integer.parseInt(envio.getText().toString());
            total.setText(pizzapromo+costo);
            mostrar.setVisibility(View.VISIBLE);








        }
        if(spinpromot.equalsIgnoreCase("Master Pizza")){
            int costo= Integer.parseInt(envio.getText().toString());
            total.setText(pizzapromo+costo);
            mostrar.setVisibility(View.VISIBLE);







        }
        if(spinpromot.equalsIgnoreCase("Pizza Max")){
            int costo= Integer.parseInt(envio.getText().toString());
            total.setText(pizzapromo+costo);
            mostrar.setVisibility(View.VISIBLE);







        }

    }






    public void inicializarbase(){
        FirebaseApp.initializeApp(this);
        firebase= FirebaseDatabase.getInstance();
        databaseReference= firebase.getReference();

    }


}