package com.example.liadrosenberg.application;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liadrosenberg.application.Actions.AddBuilding;
import com.example.liadrosenberg.application.Actions.Addgate;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity implements View.OnClickListener {
EditText edmail,edpassword;
Button btnlogin;
TextView tvReg;
private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edmail=(EditText)findViewById(R.id.email);
        edpassword=(EditText)findViewById(R.id.password);
        btnlogin=(Button)findViewById(R.id.btn_login);
        tvReg=(TextView)findViewById(R.id.link_signup);

        mAuth = FirebaseAuth.getInstance();

        tvReg.setOnClickListener(this);
        btnlogin.setOnClickListener(this);
    }

    public void Login()
    {
        mAuth.signInWithEmailAndPassword(edmail.getText().toString(), edpassword.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(login.this,"Login succeeded",Toast.LENGTH_SHORT).show();
                            if(edmail.getText().toString().equals("admin@admin.com")&&edpassword.getText().toString().equals("admin123")) {
                                ToAdminControlPanel();
                                Toast.makeText(login.this, "adminLOGIN", Toast.LENGTH_LONG).show();
                            }
                            else
                            Tomain();

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(login.this,"Login failed",Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }
    public void Tomain()
    {

        Intent intent= new Intent(this, Addgate.class);
        startActivity(intent);
    }
    public void ToAdminControlPanel()
    {
        Intent intent= new Intent(this, AdminActivity.class);
        startActivity(intent);
    }
    @Override
    public void onClick(View v) {
        if (v==tvReg) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        if (v==btnlogin)
            Login();
    }

}
