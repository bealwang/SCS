package edu.ucas.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import edu.ucas.axis2client.AxisClient;
import edu.ucas.entity.Student;
import edu.ucas.ui.SignPanel;

public class SignAction{
    private SignPanel signPanel;
    private static Student student = null;
    
    public SignAction(){}
    
    public SignAction(SignPanel signPanel){
        this.signPanel = signPanel;
    }
    
    public static Student getStudent() {
        return student;
    }
    
    public void signIn() {
        String userName = signPanel.getUserName();
        String passWord = signPanel.getPassWord();
        if (!checkPhoneNumber(userName) || !checkPassWord(passWord)) {
            JOptionPane.showMessageDialog(null,
                    "用户名或密码不符合规范", "登陆结果",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        student = AxisClient.signIn(userName, passWord);
        if (student != null) {
            signPanel.signed(student.getUserName());
        } else {
            JOptionPane.showMessageDialog(null,
                    "用户名或密码错误", "登陆结果",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void signOut() {
        student = null;
        signPanel.notSigned();
    }
    
    public boolean signUp(String phoneNumber, String userName, String passWord) {
        if (!checkPhoneNumber(phoneNumber)) {
            JOptionPane.showMessageDialog(null,
                    "请正确填写手机号", "用户注册",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!checkPassWord(passWord)) {
            JOptionPane.showMessageDialog(null,
                    "密码不符合规范", "用户注册",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (userName.trim().equals("")) {
            JOptionPane.showMessageDialog(null,
                    "昵称不能为空", "用户注册",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            if (!AxisClient.signUp(phoneNumber, userName.trim(), passWord)) {
                JOptionPane.showMessageDialog(null,
                        "手机号已被注册，请直接登陆", "用户注册",
                        JOptionPane.ERROR_MESSAGE);
                return true;
            }
        }
        return true;
    }
    
    public void forgotPsw() {
        String phoneNumber = JOptionPane.showInputDialog(null,
                "手机号", "找回密码", JOptionPane.QUESTION_MESSAGE);
        if (!checkPhoneNumber(phoneNumber)) {
            JOptionPane.showMessageDialog(null,
                    "请正确填写手机号", "找回密码",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            String response = AxisClient.forgotPassWord(phoneNumber);
            if (response.equals("")) {
                JOptionPane.showMessageDialog(null,
                        "找回失败", "找回密码",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                        "您的密码为:" + response + "请牢记！", "找回密码",
                        JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
    
    private boolean checkPhoneNumber(String userName) {
        String regExp = "^[1][358][0-9]{9}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(userName);
        return m.find();
    }
    private boolean checkPassWord(String passWord) {
        if (passWord.length() > 15 || passWord.length() < 6) {
            return false;
        }
        String regExp = "[A-Z,a-z,0-9,-]";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(passWord);
        return m.find();
    }
}
