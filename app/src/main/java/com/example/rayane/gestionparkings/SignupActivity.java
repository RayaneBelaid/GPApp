package com.example.rayane.gestionparkings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignupActivity extends AppCompatActivity {

    private EditText prenom;
    private EditText nom;
    private TextView bienvenu;
    private TextView profil;
    private Button suivant2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        prenom = (EditText)findViewById(R.id.prenomclient);
        nom = (EditText)findViewById(R.id.nomclient);
        bienvenu = (TextView)findViewById(R.id.tvbienvenu);
        profil = (TextView)findViewById(R.id.tvprofil);
        suivant2 =(Button)findViewById(R.id.svtbutton2);

        suivant2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             String name =   nom.getText().toString();
             String firstname =   prenom.getText().toString();
             if(!name.equals("")&& !firstname.equals("")){
                Intent intent = new Intent(SignupActivity.this, Signup2Activity.class);
                startActivity(intent);
             }else if (name.isEmpty() && firstname.isEmpty()){
                 nom.setError("Insérer votre nom !");
                 prenom.setError("Insérer votre prénom !");
             } else if(name.isEmpty()){
                 nom.setError("Insérer votre nom !");
             }else if (firstname.isEmpty()){
                 prenom.setError("Insérer votre prénom !");
             }
            }
        });

    }


}
