package com.example.liadrosenberg.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.liadrosenberg.application.Actions.AddUsers;
import com.example.liadrosenberg.application.Actions.Addgate;
import com.example.liadrosenberg.application.Actions.ManageGates;
import com.example.liadrosenberg.application.Actions.ManageUsers;

public class AdminActivity extends AppCompatActivity implements View.OnClickListener {

    Button AddGatesbtn,ManageGatesBtn,AddUsersBtn,ManageUsersBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        AddGatesbtn=(Button)findViewById(R.id.ToaddGates);
        ManageGatesBtn=(Button)findViewById(R.id.MangeGates);
        AddUsersBtn=(Button)findViewById(R.id.ToaddUsers);
        ManageUsersBtn=(Button)findViewById(R.id.ToMangeUsers);


        AddGatesbtn.setOnClickListener(this);
        ManageUsersBtn.setOnClickListener(this);
        AddUsersBtn.setOnClickListener(this);
        ManageUsersBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v==AddGatesbtn)
        {
            Intent intent=new Intent(this, Addgate.class);
            startActivity(intent);
        }
         if (v==ManageGatesBtn)
        {
            Intent intent=new Intent(this, ManageGates.class);
            startActivity(intent);
        }
          if (v==AddUsersBtn)
        {
            Intent intent=new Intent(this, AddUsers.class);
            startActivity(intent);
        }
          if (v==ManageUsersBtn)
        {
            Intent intent=new Intent(this, ManageUsers.class);
            startActivity(intent);
        }

    }
}
