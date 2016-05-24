package edu.ucas.action;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import edu.ucas.axis2client.AxisClient;
import edu.ucas.entity.Message;
import edu.ucas.ui.MessageHandle;
import edu.ucas.ui.MessageList;
import edu.ucas.utils.Utils;

public class MessageHandleAction{
    private MessageList msList;
    private MessageHandle msHandle;
    private static ArrayList<Message> ms;
    
    public MessageHandleAction(){}
    public MessageHandleAction(MessageList msList){
        this.msList = msList;
    }
    public MessageHandleAction(MessageList msList, MessageHandle msHandle){
        this.msList = msList;
        this.msHandle = msHandle;
    }
    
    public static ArrayList<Message> getMessageList() {
        return ms;
    }
    
    public void getAllMessage() {
        if (!Utils.isSigned()) {
            JOptionPane.showMessageDialog(null,
                    "请先登陆", "操作失败",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        ms = AxisClient.getAllMessage();
        msList.setMessageList(ms);
    }
    
    public void getMyMessage() {
        if (!Utils.isSigned()) {
            JOptionPane.showMessageDialog(null,
                    "请先登陆", "操作失败",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        ms = AxisClient.getMyMessage(SignAction.getStudent().getPhoneNumber());
        msList.setMessageList(ms);
    }
    
    public void deleteMessage() {
        if (!Utils.isSigned()) {
            JOptionPane.showMessageDialog(null,
                    "请先登陆", "操作失败",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        int msIndex = msList.getSelctedMsIndex();
        if (AxisClient.deleteMessage(ms.get(msIndex).getMsId())) {
            ms.remove(msIndex);
            msList.removeElement(msIndex);
            msHandle.getMessageDetail().setText("");
        } else {
            JOptionPane.showMessageDialog(null,
                    "删除失败", "操作失败",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean publishMessage(String msTitle, String msBody) {
        if (msTitle.trim().equals("")) {
            JOptionPane.showMessageDialog(null,
                    "标题不能为空", "消息发布",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (msBody.trim().equals("")) {
            JOptionPane.showMessageDialog(null,
                    "内容不能为空", "消息发布",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!checkTitle(msTitle)) {
            JOptionPane.showMessageDialog(null,
                    "标题过长", "消息发布",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!checkBody(msBody)) {
            JOptionPane.showMessageDialog(null,
                    "内容过长", "消息发布",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            String phoneNumber = SignAction.getStudent().getPhoneNumber();
            if (!AxisClient.publishMessage(phoneNumber, msTitle, msBody)) {
                JOptionPane.showMessageDialog(null,
                        "发布失败", "消息发布",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }
    
    private boolean checkTitle(String msTitle) {
        if (msTitle.length() > 50) {
            return false;
        } else {
            return true;
        }
    }
    private boolean checkBody(String msBody) {
        if (msBody.length() > 500) {
            return false;
        } else {
            return true;
        }
    }
}
