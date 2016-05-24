package entity;

import java.io.Serializable;

public class Student implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String phoneNumber;
    private String userName;
    private String passWord;
    
    public Student(){};
    public Student(String phoneNumber, String userName, String passWord){
        this.phoneNumber = phoneNumber;
        this.userName = userName;
        this.passWord = passWord;
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
    public String getPassWord() {
        return passWord;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
