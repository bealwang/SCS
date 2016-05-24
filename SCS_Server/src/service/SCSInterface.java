package service;

import entity.Message;
import entity.Student;

public interface SCSInterface{
    public Student signIn(String phoneNumber, String passWord);
    public boolean signUp(String phoneNumber, String userName, String passWord);
    public String forgotPassWord(String phoneNumber);
    
    public Message[] getAllMessage();
    public Message[] getMyMessage(String phoneNumber);
    public boolean deleteMessage(int msId);
    public boolean publishMessage(String ownerId, String msTitle, String msBody);
}
