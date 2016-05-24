package edu.ucas.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import edu.ucas.action.MessageHandleAction;
import edu.ucas.action.MessageListAction;
import edu.ucas.action.SignAction;
import edu.ucas.utils.Utils;

@SuppressWarnings("serial")
public class Client extends JFrame implements ActionListener,
        ListSelectionListener{
    private SignPanel signPanel;
    private MessageList messageList;
    private MessageHandle messageHandle;
    private Container con;
    SignAction signAction;
    MessageHandleAction msHandleAction;
    MessageListAction msListAction;
    
    public Client(){
        super("学生交流管理系统");
        con = getContentPane();
        signPanel = new SignPanel(this);
        messageList = new MessageList(this);
        messageHandle = new MessageHandle(this);
    }
    
    public void init() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setLocation((screenWidth - 1000) / 2, (screenHeight - 700) / 2);
        
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        con.setLayout(null);
        
        signPanel.init();
        con.add(signPanel);
        signPanel.setLocation(650, 0);
        messageHandle.init();
        con.add(messageHandle);
        messageHandle.setLocation(650, 200);
        messageList.init();
        con.add(messageList);
        messageList.setLocation(0, 0);
        
        signAction = new SignAction(signPanel);
        msHandleAction = new MessageHandleAction(messageList, messageHandle);
        msListAction = new MessageListAction(messageHandle);
        
        setVisible(true);
    }
    public static void main(String args[]) {
        Client client = new Client();
        client.init();
    }
    
    /**
     * 监听按钮
     * 
     * @param e
     */
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == signPanel.getsignInButton()) {
            signAction.signIn();
            this.repaint();
        }
        else if (source == signPanel.getSignOutButton()) {
            signAction.signOut();
            this.repaint();
        }
        else if (source == signPanel.getsignUpButton()) {
            SignUp signUp = new SignUp();
            signUp.init();
        }
        else if (source == signPanel.getForgotPswButton()) {
            signAction.forgotPsw();
        }
        else if (source == messageHandle.getAllMessageButton()) {
            msHandleAction.getAllMessage();
            this.repaint();
        }
        else if (source == messageHandle.getMyMessageButton()) {
            msHandleAction.getMyMessage();
            this.repaint();
        }
        else if (source == messageHandle.getPublishMessageButton()) {
            if (Utils.isSigned()) {
                PublishMessage publishMessage = new PublishMessage(messageList);
                publishMessage.init();
            } else {
                JOptionPane.showMessageDialog(null,
                        "请先登陆", "操作失败",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (source == messageHandle.getDeleteMessageButton()) {
            msHandleAction.deleteMessage();
            this.repaint();
        }
    }
    /**
     * 监听选中消息事件
     * 
     * @param e
     * 
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            @SuppressWarnings("rawtypes")
            JList list = (JList) e.getSource();
            int messageIndex = list.getSelectedIndex();
            if (messageIndex != -1) {
                msListAction.messageClicked(messageIndex);
                this.repaint();
            }
        }
    }
}
