package edu.ucas.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import edu.ucas.action.SignAction;

@SuppressWarnings("serial")
public class SignUp extends JFrame implements ActionListener{
    private Container con;
    private final JLabel phoneNumberLabel;
    private final JLabel userNameLabel;
    private final JLabel passWordLabel;
    private JButton signUpButton;
    private JTextField phoneNumberText;
    private JTextField userNameText;
    private JPasswordField passWordText;
    private SignAction action;
    
    public SignUp(){
        super("用户注册");
        con = getContentPane();
        phoneNumberLabel = new JLabel("手机号：");
        phoneNumberText = new JTextField(12);
        userNameLabel = new JLabel("昵称：");
        userNameText = new JTextField(12);
        passWordLabel = new JLabel("密码：");
        passWordText = new JPasswordField(13);
        signUpButton = new JButton("注册");
        action = new SignAction();
        signUpButton.addActionListener(this);
    }
    
    public void init() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setLocation((screenWidth - 300) / 2, (screenHeight - 200) / 2);
        
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(true);
        con.setLayout(new GridLayout(4, 1));
        JPanel panel0 = new JPanel();
        panel0.add(phoneNumberLabel);
        panel0.add(phoneNumberText);
        JPanel panel1 = new JPanel();
        panel1.add(userNameLabel);
        panel1.add(userNameText);
        JPanel panel2 = new JPanel();
        panel2.add(passWordLabel);
        panel2.add(passWordText);
        passWordText.setToolTipText("6～15位，数字、字符、连接符\"-\"");
        passWordText.setEchoChar('*');
        JPanel panel3 = new JPanel();
        panel3.add(signUpButton);
        
        con.add(panel0);
        con.add(panel1);
        con.add(panel2);
        con.add(panel3);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == signUpButton) {
            String phoneNumber = phoneNumberText.getText();
            String userName = userNameText.getText();
            String passWord = String.valueOf(passWordText.getPassword());
            if (action.signUp(phoneNumber, userName, passWord)) {
                this.dispose();
            }
        }
    }
}
