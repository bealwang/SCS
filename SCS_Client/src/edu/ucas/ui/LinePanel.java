/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucas.ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author huipu
 */
public class LinePanel extends JPanel{
    private JScrollPane lineScroll;
    private JScrollPane linesResult;
    private JList linesList;
    private JTextArea linesArea;
    private String[] lines= {"1号线","2号线","4号线","5号线","6号线","8号线","9号线","10号线","13号线"};
    private final Color color = Color.LIGHT_GRAY;
    
    public LinePanel(ListSelectionListener ls){
        super(null);
        setSize(343,396);
        linesList = new JList();
        lineScroll = new JScrollPane(linesList);
        linesArea = new JTextArea();
        linesResult = new JScrollPane(linesArea);
        linesList.addListSelectionListener(ls);
    }
    
    public void init(){
        setBackground(color);
        add(lineScroll);
        lineScroll.setBounds(0,0, 343, 190);
        DefaultListModel model = new DefaultListModel ( ) ;
        linesList.setModel( model ) ;
    	linesList.setBorder(BorderFactory.createTitledBorder("选择线路")) ;
    	linesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION) ;
         for(int element = 0;element < lines.length;element ++){
    	  model.addElement(lines[element]) ;
    	}
        linesList.setBackground(color);
        
        add(linesResult);
        linesArea.setEditable(false);
        linesArea.setFont(new Font("宋体",Font.BOLD,14));
        linesArea.setForeground(Color.BLUE);
        linesArea.setAutoscrolls(true);
        linesArea.setLineWrap(true);
        linesArea.setBorder(BorderFactory.createTitledBorder("线路信息"));
        linesArea.setBackground(color);
        linesResult.setBounds(0,190,343,196); 
    }
    
    public JTextArea getLinesArea(){
        return linesArea;
    }
    
}
