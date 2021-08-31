package com.Messaging App.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    //component variables
    private EditText C_Email;
    private EditText C_Password;
    private Button C_Login_button;
    private TextView C_Attemps;
    private Button C_GoToRegister;


    //flags
    int counter = 5;

    //Firebase variables
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assigns components to variables
        C_Email = findViewById(R.id.Login_Email);
        C_Password = findViewById(R.id.Login_Password);
        C_Login_button = findViewById(R.id.Login_Button);
        C_Attemps = findViewById(R.id.Login_Attemps);
        C_GoToRegister = findViewById(R.id.Login_Go_To_Register);

        //Initializing  Firebase variables
        fAuth = FirebaseAuth.getInstance();
        if (fAuth.getCurrentUser() != null){
            startActivity(new Intent(MainActivity.this, LoggedIn.class));
            finish();
        }
        //set onclick event  on Login button
        C_Login_button.setOnClickListener(new LoginOnClick());
        //set onclick event on go to register button
        C_GoToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Register.class);
                startActivity(intent);

            }
        });
    }
    //Login click handler
    class LoginOnClick  implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String input_email = C_Email.getText().toString().trim();
            String input_password = C_Password.getText().toString().trim();

            if (input_email.isEmpty()) {
                C_Email.setError("Email is required!!");
                return;
            }

            if (input_password.isEmpty()) {
                C_Password.setError("Password is required!!");
                return;
            }
            if (counter > 0) {
                Signin(input_email, input_password);
            }
        }
    }

    private void Signin(String email, String password){
        //add code here, send request and get data back
        fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @org.jetbrains.annotations.NotNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity.this,"User has been Logged in",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, LoggedIn.class));
                }
                else{
                    counter--;
                    C_Attemps.setText("No. of tries left: " + counter);
                    if (counter == 0){
                        C_Login_button.setEnabled(false);
                    }
                    Toast.makeText(MainActivity.this,"Error: " +task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}