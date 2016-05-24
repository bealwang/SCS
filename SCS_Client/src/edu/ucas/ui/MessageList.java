package edu.ucas.ui;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import edu.ucas.entity.Message;
import edu.ucas.utils.Utils;

@SuppressWarnings("serial")
public class MessageList extends JPanel{
    private JScrollPane lineScroll;
    @SuppressWarnings("rawtypes")
    private JList linesList;
    @SuppressWarnings("unused")
    private JTextArea linesArea;
    @SuppressWarnings("rawtypes")
    DefaultListModel model;
    private final Color color = Color.WHITE;
    
    @SuppressWarnings("rawtypes")
    public MessageList(ListSelectionListener ls){
        super(null);
        setSize(650, 700);
        linesList = new JList();
        lineScroll = new JScrollPane(linesList);
        model = new DefaultListModel();
        linesList.addListSelectionListener(ls);
    }
    
    @SuppressWarnings("unchecked")
    public void init() {
        setBackground(color);
        add(lineScroll);
        lineScroll.setBounds(0, 0, 650, 700);
        linesList.setFixedCellHeight(30);
        linesList.setModel(model);
        linesList.setBorder(BorderFactory.createTitledBorder("消息标题"));
        linesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        linesList.setBackground(color);
    }
    @SuppressWarnings("unchecked")
    public void setMessageList(ArrayList<Message> ms) {
        model.removeAllElements();
        for (Message temp : ms) {
            model.addElement(Utils.proString(temp.getMsTitle(), 4, "666"));
        }
    }
    
    public void removeElement(int index) {
        model.removeElementAt(index);
    }
    
    public int getSelctedMsIndex() {
        return linesList.getSelectedIndex();
    }
}
