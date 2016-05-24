package database.dao;

import java.util.ArrayList;
import entity.Message;
import entity.Student;

public interface UserInterface{
    public Student getStudentById(String phoneNumber);
    public boolean haveUser(String phoneNumber);
    public boolean setUser(String phoneNumber, String name, String password);
    public String getPassWord(String phoneNumber);
    
    public ArrayList<Message> getMessage();
    public ArrayList<Message> getMessage(String phoneNumber);
    public boolean setMessage(String owner, String msTitle, String msBody);
    public boolean deleteMessage(int msId);
    
}
