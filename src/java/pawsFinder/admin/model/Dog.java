/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pawsFinder.admin.model;

import java.sql.Blob;

/**
 *
 * @author user
 */
public class Dog {
    protected int dogID;
    protected String dogName;
    protected int dogAge;
    protected String dogSize;
    protected String gender;
    protected String breed;
    protected String color;
    protected String city;
    protected String description;
    protected String adoptionStatus;
    protected String friendly;
    protected float price;
    protected Blob photo;

    public Dog(String dogName, int dogAge, String dogSize, String gender, String breed, String color, String city, String description, String adoptionStatus, String friendly, float price, Blob photo) {
        this.dogName = dogName;
        this.dogAge = dogAge;
        this.dogSize = dogSize;
        this.gender = gender;
        this.breed = breed;
        this.color = color;
        this.city = city;
        this.description = description;
        this.adoptionStatus = adoptionStatus;
        this.friendly = friendly;
        this.price = price;
        this.photo = photo;
    }

    public Dog(int dogID, String dogName, int dogAge, String dogSize, String gender, String breed, String color, String city, String description, String adoptionStatus, String friendly, float price, Blob photo) {
        this.dogID = dogID;
        this.dogName = dogName;
        this.dogAge = dogAge;
        this.dogSize = dogSize;
        this.gender = gender;
        this.breed = breed;
        this.color = color;
        this.city = city;
        this.description = description;
        this.adoptionStatus = adoptionStatus;
        this.friendly = friendly;
        this.price = price;
        this.photo = photo;
    }

    public Dog(int dogID, String dogName, String breed, String adoptionStatus, float price) {
        this.dogID = dogID;
        this.dogName = dogName;
        this.breed = breed;
        this.adoptionStatus = adoptionStatus;
        this.price = price;
    }
    

    public Dog() {
    }
    
    public Dog(String dogName, int dogAge, String dogSize, String gender, String breed, String color, String city, String description, String adoptionStatus, String friendly, float price) {
        this.dogName = dogName;
        this.dogAge = dogAge;
        this.dogSize = dogSize;
        this.gender = gender;
        this.breed = breed;
        this.color = color;
        this.city = city;
        this.description = description;
        this.adoptionStatus = adoptionStatus;
        this.friendly = friendly;
        this.price = price;
    }

    public Dog(String dogName, int dogAge, String dogSize, String gender, String breed, String color, String city, String description, String friendly, float price) {
        this.dogName = dogName;
        this.dogAge = dogAge;
        this.dogSize = dogSize;
        this.gender = gender;
        this.breed = breed;
        this.color = color;
        this.city = city;
        this.description = description;
        this.friendly = friendly;
        this.price = price;
    }

    public Dog(int dogID, String dogName, int dogAge, String dogSize, String gender, String breed, String color, String city, String description, String adoptionStatus, String friendly, float price) {
        this.dogID = dogID;
        this.dogName = dogName;
        this.dogAge = dogAge;
        this.dogSize = dogSize;
        this.gender = gender;
        this.breed = breed;
        this.color = color;
        this.city = city;
        this.description = description;
        this.adoptionStatus = adoptionStatus;
        this.friendly = friendly;
        this.price = price;
    }

    public int getDogID() {
        return dogID;
    }

    public void setDogID(int dogID) {
        this.dogID = dogID;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public int getDogAge() {
        return dogAge;
    }

    public void setDogAge(int dogAge) {
        this.dogAge = dogAge;
    }

    public String getDogSize() {
        return dogSize;
    }

    public void setDogSize(String dogSize) {
        this.dogSize = dogSize;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdoptionStatus() {
        return adoptionStatus;
    }

    public void setAdoptionStatus(String adoptionStatus) {
        this.adoptionStatus = adoptionStatus;
    }

    public String getFriendly() {
        return friendly;
    }

    public void setFriendly(String friendly) {
        this.friendly = friendly;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
