package com.example.liadrosenberg.application.Classes;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Building {
   public String Address,specialkey;




    public  Building(){
                               //empty constructor required for firebase
    }
    public  Building(String Address,String specialkey)
    {
        this.Address=Address;
        this.specialkey=specialkey;
    }
}

