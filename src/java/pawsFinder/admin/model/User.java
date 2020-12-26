/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pawsFinder.admin.model;

import java.sql.Date;

/**
 *
 * @author user
 */
public class User {
    protected int userID;
    protected String firstName;
    protected String lastName;
    protected String name;
    protected Date userDOB;
    protected int age;
    protected String userEmailID;
    protected long userPhone;
    protected int userPostalCode;
    protected String userCity;

    public User(int userID, String name, String userEmailID, long userPhone, int userPostalCode, String userCity, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.userEmailID = userEmailID;
        this.userPhone = userPhone;
        this.userPostalCode = userPostalCode;
        this.userCity = userCity;
    }

    public User(int userID, String firstName, String lastName, String userEmailID, long userPhone, int userPostalCode, String userCity, int age) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.userEmailID = userEmailID;
        this.userPhone = userPhone;
        this.userPostalCode = userPostalCode;
        this.userCity = userCity;
    }
    
    
    public User(String firstName, String lastName, Date userDOB, String userEmailID, long userPhone, int userPostalCode, String userCity) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userDOB = userDOB;
        this.userEmailID = userEmailID;
        this.userPhone = userPhone;
        this.userPostalCode = userPostalCode;
        this.userCity = userCity;
    }

    public User(int userID, String firstName, String lastName, Date userDOB, String userEmailID, long userPhone, int userPostalCode, String userCity) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userDOB = userDOB;
        this.userEmailID = userEmailID;
        this.userPhone = userPhone;
        this.userPostalCode = userPostalCode;
        this.userCity = userCity;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getUserDOB() {
        return userDOB;
    }

    public void setUserDOB(Date userDOB) {
        this.userDOB = userDOB;
    }

    public String getUserEmailID() {
        return userEmailID;
    }

    public void setUserEmailID(String userEmailID) {
        this.userEmailID = userEmailID;
    }

    public long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }

    public int getUserPostalCode() {
        return userPostalCode;
    }

    public void setUserPostalCode(int userPostalCode) {
        this.userPostalCode = userPostalCode;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }    
    
    public int getAge() {
        return age;
    }
}
