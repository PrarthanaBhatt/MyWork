package com.prarthana.myworkapplication.data_Activity;

import android.widget.CheckBox;
import android.widget.RadioGroup;

public class User {
    String name,lastName;
//    CheckBox Female,Male;
//    RadioGroup java,kotlin,swift;


    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
