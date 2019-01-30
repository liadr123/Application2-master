package com.example.liadrosenberg.application.Actions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.liadrosenberg.application.Classes.Building;
import com.example.liadrosenberg.application.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddBuilding extends AppCompatActivity implements View.OnClickListener {

    EditText BuildingAddress;
    Button addBuildingButton;
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth firebaseAuth;
    DatabaseReference BuildingRef, users, buildings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_building);

        firebaseDatabase=FirebaseDatabase.getInstance();

        users = firebaseDatabase.getReference("Users");
        buildings = firebaseDatabase.getReference("Buildings");
        firebaseAuth = FirebaseAuth.getInstance();


        BuildingAddress=(EditText)findViewById(R.id.BuildingAddress);
        addBuildingButton=(Button)findViewById(R.id.AddbuildingButton);

        addBuildingButton.setOnClickListener(this);
    }


    public void  AddBuilding()                                                                       //add gate to firebase. action gets: name of the gate, his ip,uid and special key
    {
        if(firebaseAuth.getUid() != null) {
            Building B = new Building(BuildingAddress.getText().toString(), "");

            BuildingRef = firebaseDatabase.getReference(("Buildings")).push();
            B.specialkey = BuildingRef.getKey();
            BuildingRef.setValue(B);
            users.child(firebaseAuth.getUid()).child("Buildings").child(B.specialkey).setValue("");

            buildings.child(B.specialkey).child("Users").child(firebaseAuth.getUid()).setValue("");

        }
    }

    @Override
    public void onClick(View v) {
        AddBuilding();
        Toast.makeText(this,"added building",Toast.LENGTH_LONG).show();
    }
}
