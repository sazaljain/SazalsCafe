package com.sazal.sazalscafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class ActivityGoogle extends AppCompatActivity {

    TextView nameg,emailg,idg;
    ImageView photog;
    Button done;
    GoogleSignInClient mGoogleSignInClient;
    private Object Glide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Account Information");
        setContentView(R.layout.activity_google);

        nameg= findViewById(R.id.nameg);
        emailg= findViewById(R.id.emailg);
        idg= findViewById(R.id.idg);
        photog= findViewById(R.id.photog);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
// Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            String personName = acct.getDisplayName();
            String personGivenName = acct.getGivenName();
            String personFamilyName = acct.getFamilyName();
            String personEmail = acct.getEmail();
            String personId = acct.getId();
            Uri personPhoto = acct.getPhotoUrl();
            com.bumptech.glide.Glide.with(this).load(String.valueOf(personPhoto)).into(photog);
            Toast.makeText(this, "User email:"+personEmail, Toast.LENGTH_SHORT).show();

            nameg.setText("Name: "+personName);
            emailg.setText("Email: "+personEmail);
            idg.setText("Id: "+personId);



        }


        done = findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ActivityGoogle.this,ActivityHomepage.class);
                startActivity(intent);

            }
        });
    }
}