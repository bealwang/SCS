package edu.ucas.entity;

import java.io.Serializable;

public class Student implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String phoneNumber;
    private String userName;
    
    public Student(){};
    public Student(String phoneNumber, String userName){
        this.phoneNumber = phoneNumber;
        this.userName = userName;
    }
    
    public void show() {
        System.out.println("phone_number:" + this.phoneNumber + "  user_name:"
                + this.userName);
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
