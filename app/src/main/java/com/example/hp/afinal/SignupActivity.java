package com.example.hp.afinal;

import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.hp.afinal.databinding.ActivitySignupBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener{
ActivitySignupBinding binding;

    private Button button_signup;
    private EditText et_email_address;
    private EditText et_password;
    private EditText et_full_name;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_signup);

        firebaseAuth = FirebaseAuth.getInstance();

        databaseReference = FirebaseDatabase.getInstance().getReference();

        if(firebaseAuth.getCurrentUser()!=null){
            //profile activity
            finish();
            startActivity(new Intent(getApplicationContext(),NavigationDrawerActivity.class));
        }

        progressDialog = new ProgressDialog(this);

        button_signup = (Button) findViewById(R.id.button_signup);
        et_email_address = (EditText) findViewById(R.id.et_email_address);
        et_password = (EditText) findViewById(R.id.et_password);
        et_full_name = (EditText) findViewById(R.id.et_full_name);

        button_signup.setOnClickListener(this);
    }

    public void login(View view){
        startActivity(new Intent(this,LoginActivity.class));
    }


    private void registerUser(){
        String email = et_email_address.getText().toString().trim();
        String password = et_password.getText().toString().trim();
        String full_name = et_full_name.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            //email is empty
            Toast.makeText(this,"Please enter Email",Toast.LENGTH_SHORT).show();
            //stopping the function from executing further
            return;
        }

        if(TextUtils.isEmpty(password)){
            //password is empty
            Toast.makeText(this,"Please enter Password",Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(full_name)){
            //name is empty
            Toast.makeText(this,"Please enter Name",Toast.LENGTH_SHORT).show();
            return;
        }
        //if validations ok
        //Show progress bar

        progressDialog.setMessage("Registering");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        progressDialog.dismiss();

                        if(task.isSuccessful()){
                            //user is successfully registered
                            //Start profile activity here
                            saveUserInfo();

                            finish();
                            startActivity(new Intent(getApplicationContext(),NavigationDrawerActivity.class));
                        }
                        else {
                            Toast.makeText(SignupActivity.this,"Registration failed",Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return true;
    }

    private void saveUserInfo(){
        String name = et_full_name.getText().toString().trim();

        UserInfo userInfo = new UserInfo(name);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        databaseReference.child(user.getUid()).setValue(userInfo);
    }

    @Override
    public void onClick(View v) {
        if(v == button_signup){
            registerUser();
        }
    }
}
