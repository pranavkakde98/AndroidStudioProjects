package com.example.hp.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth firebaseAuth;

    private TextView textvieww,textView;
    private Button button;
    private Button drawerButton;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

        textvieww = findViewById(R.id.textvieww);


        textvieww.setText("Welcome:  "+"  ID: "+user.getEmail());
        button = findViewById(R.id.button);
        drawerButton = findViewById(R.id.drawerButton);

        button.setOnClickListener(this);
        drawerButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == button){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }

        if(v == drawerButton){
            startActivity(new Intent(this,NavigationDrawerActivity.class ));
        }
    }
}
