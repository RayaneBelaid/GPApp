package com.example.rayane.gestionparkings;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import android.widget.ArrayAdapter;



public class VehiculeInfoActivity extends AppCompatActivity {


    private TextView compinfo;
    private Spinner marque;
    private Spinner couleur;
    private EditText Immatricule;
    private EditText type;
    private Button envoyer;

    private Spinner spinner, spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicule_info);

        addItemsOnSpinner();
        addItemsOnSpinner2();


        compinfo = (TextView)findViewById(R.id.completerVihecule);
        marque = (Spinner)findViewById(R.id.ListeMarque);
        couleur = (Spinner) findViewById(R.id.ListeCouleur);
        Immatricule = (EditText)findViewById(R.id.immClient);
        type = (EditText)findViewById(R.id.typevihecule);
        envoyer = (Button)findViewById(R.id.envoyerButton);


        envoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String matricule = Immatricule.getText().toString();
                String typevihecule = type.getText().toString();

                if(!matricule.equals("") && !typevihecule.equals("")){

                Intent intent = new Intent(VehiculeInfoActivity.this, LoginActivity.class);
                startActivity(intent);
                }else if(matricule.isEmpty() && typevihecule.isEmpty()){
                    Immatricule.setError("Insérer votre immatricule");
                    type.setError("Insérer votre type");
                }else if(matricule.isEmpty()){
                    Immatricule.setError("Insérer votre immatricule");
                }else if(typevihecule.isEmpty()){
                    type.setError("Insérer votre type");
                }
            }
        });




    }

    // add items into spinnerColor dynamically
    public void addItemsOnSpinner() {

        spinner = (Spinner) findViewById(R.id.ListeCouleur);
        List<String> list = new ArrayList<String>();
        list.add("Blanc");
        list.add("Noir");
        list.add("Gris");
        list.add("Argent");
        list.add("Bleu");
        list.add("Violet");
        list.add("Rouge");
        list.add("jaune");
        list.add("Orange");
        list.add("Vert");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }

    // add items into spinnerMarque dynamically
    public void addItemsOnSpinner2() {

        spinner2 = (Spinner) findViewById(R.id.ListeMarque);
        List<String> list = new ArrayList<String>();
        list.add("Citroën");
        list.add("Peugeot");
        list.add("Renault");
        list.add("Dacia");
        list.add("Toyota ");
        list.add("Hyundai");
        list.add("Volkswagen");
        list.add("Seat");
        list.add("KIA");
        list.add("Chevrolet");
        list.add("Suzuki");
        list.add("Nissan");
        list.add("Skoda");
        list.add("Ford ");
        list.add("Greatwall ");
        list.add("Audi");
        list.add("Mercedes-Ben");
        list.add("Mitsubishi");
        list.add("Daihatsu");
        list.add("Fiat");
        list.add("Opel");
        list.add("Mazda");
        list.add("Abarth");
        list.add("Alfa Romeo");
        list.add("Alpine");
        list.add("Artega");
        list.add("Aston Martin");
        list.add("Bentley");
        list.add("BMW");
        list.add("Bmw Alpina");
        list.add("Cadillac");
        list.add("Caterham");
        list.add("Chevrolet");
        list.add("Chrysler");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);
    }



}
