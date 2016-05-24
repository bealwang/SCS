package edu.ucas.ui;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import edu.ucas.utils.Utils;

@SuppressWarnings("serial")
public class SignPanel extends JPanel{
    private final JLabel userNameLabel;
    private final JLabel passWordLabel;
    private JButton signInButton;
    private JButton signUpButton;
    private JButton forgotPswButton;
    private JTextField userNameText;
    private JPasswordField passWordText;
    
    private JLabel welcome;
    private JButton signOutButton;
    private Color color = new Color(23, 232, 160, 1);
    
    public SignPanel(ActionListener as){
        super(null);
        setSize(350, 200);
        userNameLabel = new JLabel("手机号：");
        userNameText = new JTextField();
        passWordLabel = new JLabel("密码：");
        passWordText = new JPasswordField();
        signInButton = new JButton("登陆");
        signUpButton = new JButton("注册");
        forgotPswButton = new JButton("忘记密码");
        
        welcome = new JLabel();
        signOutButton = new JButton("注销");
        
        signInButton.addActionListener(as);
        signUpButton.addActionListener(as);
        signOutButton.addActionListener(as);
        forgotPswButton.addActionListener(as);
        
    }
    
    public void init() {
        this.setBorder(BorderFactory.createTitledBorder("用户信息"));
        add(userNameLabel);
        userNameLabel.setBounds(30, 20, 80, 30);
        add(userNameText);
        userNameText.setToolTipText("使用手机号登陆");
        userNameText.setBounds(130, 20, 170, 30);
        add(passWordLabel);
        passWordLabel.setBounds(30, 60, 80, 30);
        add(passWordText);
        passWordText.setToolTipText("6～15位，数字、字符、连接符\"-\"");
        passWordText.setEchoChar('*');
        passWordText.setBounds(130, 60, 170, 30);
        add(signInButton);
        signInButton.setBounds(30, 100, 100, 30);
        add(signUpButton);
        signUpButton.setBounds(200, 100, 100, 30);
        add(forgotPswButton);
        forgotPswButton.setBounds(30, 140, 270, 30);
        this.setBackground(color);
        
        add(welcome);
        welcome.setBounds(30, 20, 300, 120);
        add(signOutButton);
        signOutButton.setBounds(30, 140, 270, 30);
        
        notSigned();
    }
    
    public void notSigned() {
        userNameLabel.setVisible(true);
        userNameText.setVisible(true);
        passWordLabel.setVisible(true);
        passWordText.setVisible(true);
        passWordText.setText("");
        signInButton.setVisible(true);
        signUpButton.setVisible(true);
        forgotPswButton.setVisible(true);
        welcome.setVisible(false);
        signOutButton.setVisible(false);
    }
    
    public void signed(String userName) {
        userNameLabel.setVisible(false);
        userNameText.setVisible(false);
        passWordLabel.setVisible(false);
        passWordText.setVisible(false);
        signInButton.setVisible(false);
        signUpButton.setVisible(false);
        forgotPswButton.setVisible(false);
        welcome.setText(Utils.proString("欢迎回来:" + userName, 4, "666"));
        welcome.setVisible(true);
        signOutButton.setVisible(true);
    }
    
    public JTextField getuserNameText() {
        return userNameText;
    }
    
    public JPasswordField getpassWordText() {
        return passWordText;
    }
    
    /**
     * @return the signInButton
     */
    public JButton getsignInButton() {
        return signInButton;
    }
    
    /**
     * @return the signUpButton
     */
    public JButton getsignUpButton() {
        return signUpButton;
    }
    
    public JButton getForgotPswButton() {
        return forgotPswButton;
    }
    
    public String getUserName() {
        return userNameText.getText();
    }
    
    public String getPassWord() {
        return String.valueOf(passWordText.getPassword());
    }
    
    public JButton getSignOutButton() {
        return signOutButton;
    }
}
