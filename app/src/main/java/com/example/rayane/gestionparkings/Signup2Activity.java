package com.example.rayane.gestionparkings;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class Signup2Activity extends AppCompatActivity {


    private TextView text;
    private TextView anniversaire;
    private EditText datenaiss;
    private EditText email;
    private EditText adresse;
    private Button suivant;

    private DatePickerDialog.OnDateSetListener setListener;

    private static final String TAG = "Signup2Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);

        text =(TextView)findViewById(R.id.tvpresque);
        anniversaire = (TextView)findViewById(R.id.tvanniverssaire);
        datenaiss = (EditText)findViewById(R.id.datenaissclient);
        email = (EditText)findViewById(R.id.emailclient);
        adresse = (EditText)findViewById(R.id.adresseclient);
        suivant = (Button)findViewById(R.id.svtbutton3);


        String date = datenaiss.getText().toString();


//CALENDRIER POUR DATE DE NAISSANCE

        Calendar Cal = Calendar.getInstance();
        final int year = Cal.get(Calendar.YEAR);
        final int month = Cal.get(Calendar.MONTH);
        final int day = Cal.get(Calendar.DAY_OF_MONTH);

        datenaiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog dialog = new DatePickerDialog(Signup2Activity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        setListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Log.d(TAG, "onDateSet: mm/dd/yyy:" + month + "/" + dayOfMonth + "/" + year + "/");
                String date = month + "/" + dayOfMonth + "/" + year;
                datenaiss.setText(date);
            }
        };



        //BOUTON SUIVANT

        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mail = email.getText().toString();
                String address = adresse.getText().toString();
                String date = datenaiss.getText().toString();




                if(!date.equals("") && !mail.equals("") && !address.equals("")){
                Intent intent = new Intent(Signup2Activity.this, VehiculeInfoActivity.class);
                startActivity(intent);
                }else if(date.isEmpty() && mail.isEmpty() && address.isEmpty()){
                    datenaiss.setError("Insérer votre date de naissance ");
                    email.setError("Insérer votre email");
                    adresse.setError("Insérer votre adresse");
                }else if (date.isEmpty()){
                    datenaiss.setError("Insérer votre date de naissance ");
                }else if (mail.isEmpty()){
                    email.setError("Insérer votre email");
                }else if(address.isEmpty()){
                    adresse.setError("Insérer votre adresse");
                }
            }
        });




    }

    //Validation de L'email

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


    // Validation de la Date de naissance

    private boolean isValideDateNaissance(Integer datenaissance){
        datenaissance = Integer.parseInt(datenaiss.getText().toString());

        if(datenaissance == 0 ){
            datenaiss.setError("Insérer votre date de naissance !");
            return false;
        }else{
            datenaiss.setError(null);
            return  true;
        }




    }

}


