/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pawsFinder.admin.model;

import java.util.Date;

/**
 *
 * @author user
 */
public class AdoptionRequest {
    protected int requestID;
    protected int dogID;
    protected int userID;

    public AdoptionRequest(int requestID, String dogName, String firstName, String adoptionStatus, float price, String status) {
        this.requestID = requestID;
        this.dogName = dogName;
        this.firstName = firstName;
        this.adoptionStatus = adoptionStatus;
        this.price = price;
        this.status = status;
    }
    protected String dogName;
    protected String firstName;
    protected String adoptionStatus;
    protected float price;
    protected String status;
    protected Date adoptionDate;

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public int getDogID() {
        return dogID;
    }

    public void setDogID(int dogID) {
        this.dogID = dogID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAdoptionStatus() {
        return adoptionStatus;
    }

    public void setAdoptionStatus(String adoptionStatus) {
        this.adoptionStatus = adoptionStatus;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public Date getAdoptionDate() {
        return adoptionDate;
    }

    public void setAdoptionDate(Date adoptionDate) {
        this.adoptionDate = adoptionDate;
    }

    public AdoptionRequest(int requestID, String dogName, String firstName, String adoptionStatus, float price, String status, Date adoptionDate) {
        this.requestID = requestID;
        this.dogName = dogName;
        this.firstName = firstName;
        this.adoptionStatus = adoptionStatus;
        this.price = price;
        this.status = status;
        this.adoptionDate = adoptionDate;
    }

    public AdoptionRequest(int requestID, int dogID, int userID, String dogName, String firstName, String adoptionStatus, float price, String status, Date adoptionDate) {
        this.requestID = requestID;
        this.dogID = dogID;
        this.userID = userID;
        this.dogName = dogName;
        this.firstName = firstName;
        this.adoptionStatus = adoptionStatus;
        this.price = price;
        this.status = status;
        this.adoptionDate = adoptionDate;
    }
}