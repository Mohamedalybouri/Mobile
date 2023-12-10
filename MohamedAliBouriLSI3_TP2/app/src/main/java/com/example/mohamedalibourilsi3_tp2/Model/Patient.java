package com.example.mohamedalibourilsi3_tp2.Model;

import android.view.View;
import android.widget.Toast;

import com.example.mohamedalibourilsi3_tp2.Vue.MainActivity;

public class Patient {
    private int age ;
    private boolean boutton;
    private double value;
    public Patient(int age, boolean boutton, double value){
        this.age=age;
        this.boutton=boutton;
        this.value=value;
    }
    public void SetAge(int age){
        this.age=age;
    }
    public void SetButton( boolean boutton){
        this.boutton=boutton;
    }
    public void SetAge(double value){
        this.value=value;
    }
    public int getAge(){
        return age;
    }
    public boolean getBoutton(){
        return boutton;
    }
    public double getValue(){
        return value;
    }
    public String calcule(){
        if (boutton) {
            if (age > 13) {
                if (value >= 5.0 && value <= 7.2) {

                    return "Niveau de glycémie est normale";
                } else if (value < 5.0) {

                    return "Niveau de glycémie est trop bas";
                } else if (value > 7.2) {

                    return "Niveau de glycémie est trop élevée";
                }
            } else if (age >= 6 && age <= 12) {
                if (value >= 5.0 && value <= 10.0) {

                    return "Niveau de glycémie est normale";
                } else {
                    return "Niveau de glycémie est trop bas";
                }
            } else if (age < 6) {
                if (value >= 5.5 && value <= 10.0) {

                    return "Niveau de glycémie est normale";
                } else {
                    return "Niveau de glycémie est trop bas";
                }
            }
        } else {
            if (value < 10.5) {

                return "Niveau de glycémie est normale";
            } else {
                return "Niveau de glycémie est trop élevée";
            }
        }
        return null;
    }
}
