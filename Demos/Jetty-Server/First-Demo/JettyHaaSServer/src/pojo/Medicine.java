/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import com.google.gson.Gson;
import java.util.ArrayList;

/**
 *
 * @author Shall
 */
public class Medicine {

    private int medicineId;
    private String medicineName;
    private String medicineImage;
    private int medicineDose;
    private String medicineType;
    private String medicineDate;
    private String medicineTime;
    private int medicineRepition;
    private String userEmail;

    public Medicine() {
    }

    public Medicine(int medicineId, String medicineName, String medicineImage, int medicineDose, String medicineType, String medicineDate, String medicineTime, int medicineRepition,String userEmail) {
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.medicineImage = medicineImage;
        this.medicineDose = medicineDose;
        this.medicineType = medicineType;
        this.medicineDate = medicineDate;
        this.medicineTime = medicineTime;
        this.medicineRepition = medicineRepition;
        this.userEmail = userEmail;
    }

    public Medicine(String medicineName, int medicineDose, String medicineType, String medicineDate, String medicineTime, int medicineRepition, String userEmail) {
        this.medicineName = medicineName;
        this.medicineDose = medicineDose;
        this.medicineType = medicineType;
        this.medicineDate = medicineDate;
        this.medicineTime = medicineTime;
        this.medicineRepition = medicineRepition;
        this.userEmail = userEmail;
    }

    
    public Medicine(String medicineName, String medicineImage, int medicineDose, String medicineType, String medicineDate, String medicineTime, int medicineRepition, String userEmail) {
        this.medicineName = medicineName;
        this.medicineImage = medicineImage;
        this.medicineDose = medicineDose;
        this.medicineType = medicineType;
        this.medicineDate = medicineDate;
        this.medicineTime = medicineTime;
        this.medicineRepition = medicineRepition;
        this.userEmail = userEmail;
    }

    
    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineImage() {
        return medicineImage;
    }

    public void setMedicineImage(String medicineImage) {
        this.medicineImage = medicineImage;
    }

    public int getMedicineDose() {
        return medicineDose;
    }

    public void setMedicineDose(int medicineDose) {
        this.medicineDose = medicineDose;
    }

    public String getMedicineType() {
        return medicineType;
    }

    public void setMedicineType(String medicineType) {
        this.medicineType = medicineType;
    }

    public String getMedicineDate() {
        return medicineDate;
    }

    public void setMedicineDate(String medicineDate) {
        this.medicineDate = medicineDate;
    }

    public String getMedicineTime() {
        return medicineTime;
    }

    public void setMedicineTime(String medicineTime) {
        this.medicineTime = medicineTime;
    }

    public int getMedicineRepition() {
        return medicineRepition;
    }

    public void setMedicineRepition(int medicineRepition) {
        this.medicineRepition = medicineRepition;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    
    @Override
    public String toString() {
        return "Medicine{" +
                "medicineId=" + medicineId +
                ", medicineName='" + medicineName + '\'' +
                ", medicineImage=" + medicineImage +
                ", medicineDose=" + medicineDose +
                ", medicineType='" + medicineType + '\'' +
                ", medicineDate='" + medicineDate + '\'' +
                ", medicineTime=" + medicineTime +
                ", medicineRepition=" + medicineRepition +
                '}';
    }
    
    public String convertMedicineIntoJson(Medicine medicine){
        Gson gson = new Gson();
        return gson.toJson(medicine);
    }
    
     public String convertMedicinesIntoJson(ArrayList<Medicine> medicines){
        Gson gson = new Gson();
        return gson.toJson(medicines);
    }
}