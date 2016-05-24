package service;

import database.manager.UserImpl;
import entity.Message;
import entity.Student;

public class SCSImpl implements SCSInterface{
    @Override
    public Student signIn(String phoneNumber, String passWord) {
        UserImpl user = UserImpl.getInstance();
        Student stu = user.getStudentById(phoneNumber);
        if (null != stu) {
            if (stu.getPassWord().equals(passWord)) {
                return stu;
            }
        }
        return null;
    }
    @Override
    public boolean signUp(String phoneNumber, String userName, String passWord) {
        UserImpl user = UserImpl.getInstance();
        if (user.haveUser(phoneNumber)) {
            return false;
        } else {
            return user.setUser(phoneNumber, userName, passWord);
        }
    }
    
    public String forgotPassWord(String phoneNumber) {
        UserImpl user = UserImpl.getInstance();
        return user.getPassWord(phoneNumber);
    }
    
    @Override
    public Message[] getAllMessage() {
        UserImpl user = UserImpl.getInstance();
        return user.getMessage().toArray(new Message[0]);
    }
    
    @Override
    public Message[] getMyMessage(String phoneNumber) {
        UserImpl user = UserImpl.getInstance();
        return user.getMessage(phoneNumber).toArray(new Message[0]);
    }
    
    @Override
    public boolean deleteMessage(int msId) {
        UserImpl user = UserImpl.getInstance();
        return user.deleteMessage(msId);
    }
    
    @Override
    public boolean publishMessage(String ownerId, String msTitle, String msBody) {
        UserImpl user = UserImpl.getInstance();
        return user.setMessage(ownerId, msTitle, msBody);
    }
}
