package service;

import entity.Message;
import entity.Student;

public interface SCSInterface{
    public Student signIn(String phoneNumber);
    public boolean signUp(String phoneNumber, String userName, String passWord);
    
    public Message[] getAllMessage();
    public Message[] getMyMessage(String phoneNumber);
    public boolean deleteMessage(int msId);
    public boolean publishMessage(Message ms);
}
