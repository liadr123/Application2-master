package com.example.liadrosenberg.application.Classes;


import android.print.PrinterId;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Gate {

public String name;
public String ip;
public String specialKey;


public  Gate()
{
    //default constructor required for firebase Datasnapshot.getvalue(Gate.class)
}

public  Gate(String name,String key,String specialKey)
{
    this.name=name;
    this.ip=ip;
    this.specialKey=specialKey;
}


}
