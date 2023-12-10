package com.example.mohamedalibourilsi3_tp2.Controller;
import com.example.mohamedalibourilsi3_tp2.Model.*;

public class Controller {
    private Patient patient;

    public void createPatient(int age,boolean isFasting,float glucoseValue) {
        this.patient = new Patient(age,isFasting,glucoseValue);
    }

    public String getResponse() {
        return patient.calcule();
    }
}
