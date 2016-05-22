/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucas.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author huipu
 */
public class IOPanel extends JPanel{
    private final JLabel startLabel;
    private final JLabel endLabel;
    private JButton minTimeButton;
    private JButton minTranButton;
    private JTextField startStationText;
    private JTextField endStationText;
    private JTextArea resultArea;
    private JScrollPane sp;
    private JCheckBox isBusy;
    private final Color color = Color.LIGHT_GRAY;
    
    public IOPanel(ActionListener as){
        super(null);
        setSize(343,362);
        startLabel = new JLabel("起始站：");
        startStationText = new JTextField();
        endLabel = new JLabel("终点站：");
        endStationText = new JTextField();
        resultArea = new JTextArea();
        sp = new JScrollPane(getResultArea());
        isBusy = new JCheckBox("高峰时间");
        minTimeButton = new JButton("最短时间");
        minTranButton = new JButton("最少换乘");
        minTimeButton.addActionListener(as);
        minTranButton.addActionListener(as);
    }
    
    public void init(){
        setBackground(color);
        add(startLabel);
        startLabel.setBounds(30,20,80,30);
        add(startStationText);
        startStationText.setBounds(130, 20, 170, 30);
        startStationText.setBackground(color);
        add(endLabel);
        endLabel.setBounds(30, 70, 80, 30);
        add(endStationText);
        endStationText.setBounds(130, 70, 170, 30);
        endStationText.setBackground(color);
        add(isBusy);
        isBusy.setBounds(130, 120, 170, 40);
        isBusy.setBackground(color);
        add(minTimeButton);
        minTimeButton.setBounds(30, 170, 100, 30);
        add(minTranButton);
        minTranButton.setBounds(200, 170, 100, 30);
        add(sp);
        resultArea.setEditable(false);
        resultArea.setFont(new Font("宋体",Font.BOLD,14));
        resultArea.setForeground(Color.BLUE);
        resultArea.setBackground(color);
        resultArea.setAutoscrolls(true);
        resultArea.setLineWrap(true);
        resultArea.setBorder(BorderFactory.createTitledBorder("详细信息"));
        sp.setBounds(0,210,340,152);
    }
    
    public JTextField getStartStationText(){
        return startStationText;
    }
    
    public JTextField getEndStationText(){
        return endStationText;
    }

    /**
     * @return the minTimeButton
     */
    public JButton getMinTimeButton() {
        return minTimeButton;
    }

    /**
     * @return the minTranButton
     */
    public JButton getMinTranButton() {
        return minTranButton;
    }

    /**
     * @return the resultArea
     */
    public JTextArea getResultArea() {
        return resultArea;
    }

    /**
     * @return the isBusy
     */
    public JCheckBox getIsBusy() {
        return isBusy;
    }
}
