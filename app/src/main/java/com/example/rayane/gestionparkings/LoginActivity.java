package com.example.rayane.gestionparkings;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.material.tabs.TabLayout;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private TextView connectezvous;
    private TextView textView2;
    private Button suivant;
    private Button creercompte;
    private EditText email;

    //PASSWORD PATTERN

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile(
                    
                    "[0-9a-zA-Z]" + "[-@$%&#]"+ "{4,10}"+ "$");

  //NAME PATTERN

    private static final Pattern NAME_PATTERN =
            Pattern.compile(
                    
                            "[0-9a-zA-Z]"+
                            "{4,15}"+
                            "$");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.mdpclient);
        connectezvous = (TextView) findViewById(R.id.tvconnectezvous);
        textView2 = (TextView)findViewById(R.id.tvinscrivezvous);
        suivant = (Button)findViewById(R.id.svtbutton);
        creercompte =(Button)findViewById(R.id.creercompte);
        email = (EditText) findViewById(R.id.mailclient);

        //CREER UN NOUVEAU COMPTE

        creercompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                    startActivity(intent);

            }
        });


        //SE CONNECTER ET ALLER VERS LA PAGE SUIVANTE

        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String PASSWORD = password.getText().toString().trim();
                String EMAIL = email.getText().toString().trim();
                String NAME = name.getText().toString().trim();


                if(isValieName(NAME)&& isValideEmail(EMAIL) && isValidePassword(PASSWORD)){
                    Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                    startActivity(intent);
                }
            }
        });




    }


    //Validation du Mot de paase

    private boolean isValidePassword(String passwordInput){
        passwordInput = password.getText().toString().trim();

        if(passwordInput.isEmpty()){
            password.setError("Insérer votre mot de passe !");
            return false;
        }else if(!PASSWORD_PATTERN.matcher(passwordInput).matches()){
            password.setError("votre mot de passe est faible !");
            return false;
        }else {
            password.setError(null);
            return true;
        }

    }

  //Validation de l'email

    private boolean isValideEmail(String emailInput){
        emailInput = email.getText().toString().trim();

        if(emailInput.isEmpty()){
            email.setError("Insérer votre email !");
            return false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
            email.setError("Insérer correctement votre email !");
            return false;
        }else {
            email.setError(null);
            return true;
        }

    }


    //Validation du Nom

    private boolean isValieName(String nameInput){

        nameInput = name.getText().toString().trim();

        if(nameInput.isEmpty()){
            name.setError("Insérer votre nom");
            return false;
        }else if (!NAME_PATTERN.matcher(nameInput).matches()){
            name.setError("Non valide !");
            return false;
        }else {
            name.setError(null);
            return true;
        }



    }




}




