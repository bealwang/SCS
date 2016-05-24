package edu.ucas.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class MessageHandle extends JPanel{
    private JButton allMessageButton;
    private JButton myMessageButton;
    private JButton publishMessageButton;
    private JButton deleteMessageButton;
    private JTextArea messageDetailArea;
    private JScrollPane sp;
    private final Color color = new Color(239, 236, 220, 1);
    
    public MessageHandle(ActionListener as){
        super(null);
        setSize(350, 500);
        this.setBorder(BorderFactory.createTitledBorder("消息操作"));
        messageDetailArea = new JTextArea();
        sp = new JScrollPane(messageDetailArea);
        allMessageButton = new JButton("所有消息");
        myMessageButton = new JButton("只看我的");
        publishMessageButton = new JButton("发布消息");
        deleteMessageButton = new JButton("删除消息");
        allMessageButton.addActionListener(as);
        myMessageButton.addActionListener(as);
        publishMessageButton.addActionListener(as);
        deleteMessageButton.addActionListener(as);
    }
    
    public void init() {
        add(allMessageButton);
        allMessageButton.setBounds(30, 20, 100, 30);
        add(myMessageButton);
        myMessageButton.setBounds(200, 20, 100, 30);
        add(publishMessageButton);
        publishMessageButton.setBounds(30, 70, 100, 30);
        add(deleteMessageButton);
        deleteMessageButton.setEnabled(false);
        deleteMessageButton.setBounds(200, 70, 100, 30);
        add(sp);
        messageDetailArea.setEditable(false);
        messageDetailArea.setFont(new Font("宋体", Font.BOLD, 14));
        messageDetailArea.setBackground(color);
        messageDetailArea.setForeground(Color.BLUE);
        messageDetailArea.setAutoscrolls(true);
        messageDetailArea.setLineWrap(true);
        messageDetailArea.setBorder(BorderFactory.createTitledBorder("消息详情"));
        this.setBackground(color);
        sp.setBounds(0, 120, 350, 400);
    }
    
    /**
     * @return the allMessageButton
     */
    public JButton getAllMessageButton() {
        return allMessageButton;
    }
    
    /**
     * @return the myMessageButton
     */
    public JButton getMyMessageButton() {
        return myMessageButton;
    }
    
    public JButton getPublishMessageButton() {
        return publishMessageButton;
    }
    
    public JButton getDeleteMessageButton() {
        return deleteMessageButton;
    }
    
    public JTextArea getMessageDetail() {
        return messageDetailArea;
    }
}
