package com.example.evaluacion3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import Datos.Clientes;

public class Listado extends AppCompatActivity {

    private ListView list;
    FirebaseDatabase firebase;
    DatabaseReference databaseReference;

    Clientes clientesSelected;
    private ArrayList<Clientes> listclientes= new ArrayList<Clientes>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        list=(ListView)findViewById(R.id.listado);

        inicializarbase();
        databaseReference.child("Clientes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot objSnapshot :  snapshot.getChildren()){
                    Clientes c = objSnapshot.getValue(Clientes.class);
                    listclientes.add(c);

                    ArrayAdapter adapt= new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1, listclientes);
                    list.setAdapter(adapt);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                clientesSelected = (Clientes) parent.getItemAtPosition(position);

            }
        });
    }

    public void eliminar (View v){
        Clientes c= new Clientes();
        c.setId(clientesSelected.getId());
        databaseReference.child("Clientes").child(c.getId()).removeValue();

    }
    public void inicializarbase(){
        FirebaseApp.initializeApp(this);
        firebase= FirebaseDatabase.getInstance();
        databaseReference= firebase.getReference();

    }








}