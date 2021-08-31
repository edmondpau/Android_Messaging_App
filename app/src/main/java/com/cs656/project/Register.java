package com.Messaging App.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    //component variables
    private EditText C_Email;
    private EditText C_Password;
    private EditText C_Username;
    private Button C_Register_button;
    private Button C_GoToLogin;

    //firebase variables
    FirebaseAuth fAuth;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //assigns components to variables
        C_Email = findViewById(R.id.Register_Email);
        C_Password = findViewById(R.id.Register_Password);
        C_Register_button = findViewById(R.id.Register_Button);
        C_Username = findViewById(R.id.Register_Username);
        C_GoToLogin = findViewById(R.id.Register_Go_To_Login);

        //Initializing  Firebase Autho instance
        fAuth = FirebaseAuth.getInstance();

        //firebase database
        db = FirebaseFirestore.getInstance();
        // setting up go to Login event handler
        C_GoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this,MainActivity.class);
                startActivity(intent);
            }
        });
        //set onclick event  on Login button
        C_Register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input_email = C_Email.getText().toString();
                String input_password = C_Password.getText().toString();
                String input_username = C_Username.getText().toString();

                if (input_email.isEmpty() || input_password.isEmpty() ||input_username.isEmpty()){
                    Toast.makeText(Register.this,"Please enter all the details correctly", Toast.LENGTH_SHORT).show();
                    return;
                }
                RegisterUser(input_email,input_password,input_username);


            }
        });
    }
    private boolean RegisterUser(String email, String password,String username){
        fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @org.jetbrains.annotations.NotNull Task<AuthResult> task) {
                //registering was successful
                if(task.isSuccessful()){
                    Toast.makeText(Register.this,"User Created",Toast.LENGTH_SHORT).show();
                    Map<String,Object> user = new HashMap<>();
                    user.put("username",username);
                    user.put("groupchats", Arrays.asList());
                    user.put("friends",Arrays.asList());
                    db.collection("users").document(fAuth.getUid()).set(user);
                    startActivity(new Intent(Register.this, LoggedIn.class));
                }
                else{
                    Toast.makeText(Register.this,"Error: " +task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });

        return false;
    }
}