package com.example.liadrosenberg.application.Classes;

import com.example.liadrosenberg.application.Classes.Gate;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.List;

@IgnoreExtraProperties
public class User {
      public String Fname,Lname,uid,mail;

    public  User()
    {

    }
    public  User(String Fname,String Lname,String Mail,String UID)
    {
        this.uid=UID;
        this.mail=Mail;
        this.Fname=Fname;
        this.Lname=Lname;
    }

}
