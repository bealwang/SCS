package service;

import database.manager.UserImpl;
import entity.Message;
import entity.Student;

public class SCSImpl implements SCSInterface{
    @Override
    public Student signIn(String phoneNumber) {
        UserImpl user = UserImpl.getInstance();
        return user.getStudentById(phoneNumber);
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
    public boolean publishMessage(Message ms) {
        UserImpl user = UserImpl.getInstance();
        return user.setMessage(ms.getOwnerId(), ms.getMsTitle(),
                ms.getMsBody());
    }
    
}
