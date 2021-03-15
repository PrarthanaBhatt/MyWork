package com.prarthana.myworkapplication.data_binding;

import android.widget.CheckBox;

import com.prarthana.myworkapplication.BR;
import com.prarthana.myworkapplication.R;

import java.util.ArrayList;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class User extends BaseObservable {

    String userName;
    String password;
    String email;
    String gender;
    String qualification;
    ArrayList<String> language;
    int selectedRadioButton;
    private City city;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Bindable
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
        notifyPropertyChanged(BR.gender);
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getSelectedRadioButton() {
        return selectedRadioButton;
    }

    public void setSelectedRadioButton(int selectedRadioButton) {
        this.selectedRadioButton = selectedRadioButton;
        if (selectedRadioButton == R.id.rbMale)
            setGender("Male");
        else
            setGender("Female");
    }

    public void setLanguage(CheckBox checkBox) {
        if (checkBox.isChecked()) {
            if (language == null)
                language = new ArrayList<>();
            if (!language.contains(checkBox.getText().toString()))
                language.add(checkBox.getText().toString());
        } else {
            language.remove(checkBox.getText().toString());
        }
        notifyPropertyChanged(BR.language);
    }

    @Bindable
    public ArrayList<String> getLanguage() {
        return language;
    }

    public void setLanguage(ArrayList<String> language) {
        this.language = language;
    }
}
