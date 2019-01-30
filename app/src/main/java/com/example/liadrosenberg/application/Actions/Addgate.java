package com.example.liadrosenberg.application.Actions;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liadrosenberg.application.Classes.Gate;
import com.example.liadrosenberg.application.Classes.User;
import com.example.liadrosenberg.application.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Addgate extends AppCompatActivity implements View.OnClickListener {
    Button submitBtn;
    EditText ip,name;
    TextView AddgateTV;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference GateRef,userRef,BuildingRef;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addgate);

        firebaseDatabase=FirebaseDatabase.getInstance();
        firebaseAuth= FirebaseAuth.getInstance();
        userRef=firebaseDatabase.getReference("Users");
        BuildingRef=firebaseDatabase.getReference("Buildings");

        AddgateTV=(TextView)findViewById(R.id.AddgateTV);
        submitBtn=(Button)findViewById(R.id.AddGateButton);
        name=(EditText) findViewById(R.id.GateName);
        ip=(EditText)findViewById(R.id.GateKey);

        submitBtn.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        AddGates();
        Toast.makeText(Addgate.this,"successfully registerd",Toast.LENGTH_LONG).show();
    }
    public  void  AddGates()                                                                       //add gate to firebase. action gets: name of the gate, his ip,uid and special key
    {
        if (firebaseAuth.getUid()!=null) {
            Gate g = new Gate(name.getText().toString(), ip.getText().toString(), "");
            GateRef = firebaseDatabase.getReference("Gates").push();
            g.specialKey = GateRef.getKey();
            GateRef.setValue(g);

            userRef.child(firebaseAuth.getUid()).child("Gates").child(g.specialKey).setValue(name.getText().toString());



        }

    }
}
