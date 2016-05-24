package edu.ucas.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import edu.ucas.action.MessageHandleAction;

@SuppressWarnings("serial")
public class PublishMessage extends JFrame implements ActionListener{
    private Container con;
    private final JLabel msTitleLabel;
    private JTextField msTitleText;
    private JTextArea msBodyArea;
    private JScrollPane sp;
    private JButton publishButton;
    private MessageList msList;
    
    private MessageHandleAction msHandle;
    
    public PublishMessage(MessageList msList){
        super("发布消息");
        this.msList = msList;
        con = getContentPane();
        msTitleLabel = new JLabel("消息标题：");
        msTitleText = new JTextField();
        msBodyArea = new JTextArea();
        sp = new JScrollPane(msBodyArea);
        publishButton = new JButton("发布");
        publishButton.addActionListener(this);
    }
    
    public void init() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setLocation((screenWidth - 800) / 2, (screenHeight - 600) / 2);
        
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        con.setLayout(null);
        con.add(msTitleLabel);
        msTitleLabel.setBounds(20, 0, 80, 30);
        con.add(msTitleText);
        msTitleText.setBounds(90, 0, 690, 30);
        con.add(sp);
        msBodyArea.setEditable(true);
        msBodyArea.setFont(new Font("宋体", Font.BOLD, 14));
        msBodyArea.setBorder(BorderFactory.createTitledBorder("消息正文"));
        msBodyArea.setForeground(Color.BLUE);
        msBodyArea.setAutoscrolls(true);
        msBodyArea.setLineWrap(true);
        sp.setBounds(20, 40, 760, 490);
        con.add(publishButton);
        publishButton.setBounds(360, 530, 80, 30);
        
        msHandle = new MessageHandleAction(msList);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == publishButton) {
            String msTitle = msTitleText.getText();
            String msBody = msBodyArea.getText();
            if (msHandle.publishMessage(msTitle, msBody)) {
                this.dispose();
            }
        }
    }
}
