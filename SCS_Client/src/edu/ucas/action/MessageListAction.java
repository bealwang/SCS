package edu.ucas.action;

import javax.swing.JOptionPane;
import edu.ucas.entity.Message;
import edu.ucas.ui.MessageHandle;
import edu.ucas.utils.Utils;

public class MessageListAction{
    private MessageHandle msHandle;
    
    public MessageListAction(){}
    
    public MessageListAction(MessageHandle msHandle){
        this.msHandle = msHandle;
    }
    
    public void messageClicked(int msIndex) {
        if (!Utils.isSigned()) {
            JOptionPane.showMessageDialog(null,
                    "请先登陆", "操作失败",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        Message targetMessage = MessageHandleAction.getMessageList().get(
                msIndex);
        if (targetMessage.getOwnerId().equals(
                SignAction.getStudent().getPhoneNumber())) {
            msHandle.getDeleteMessageButton().setEnabled(true);
        } else {
            msHandle.getDeleteMessageButton().setEnabled(false);
        }
        msHandle.getMessageDetail().setText(getMessageDetail(targetMessage));
    }
    
    private String getMessageDetail(Message ms) {
        StringBuffer sb = new StringBuffer(ms.getOwnerName());
        sb.append("  发表于  ");
        sb.append(ms.getMsTime());
        sb.append("\n消息内容：\n");
        sb.append(ms.getMsBody());
        return sb.toString();
    }
}
