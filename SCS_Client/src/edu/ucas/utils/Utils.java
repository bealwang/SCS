package edu.ucas.utils;

import java.util.ArrayList;
import java.util.Iterator;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMNode;
import org.apache.axis2.AxisFault;
import org.apache.axis2.databinding.utils.BeanUtil;
import org.apache.axis2.engine.DefaultObjectSupplier;
import edu.ucas.action.SignAction;
import edu.ucas.entity.Message;
import edu.ucas.entity.Student;

public class Utils{
    
    public static String proString(String source, int fontSize, String fontColor) {
        return "<html><font size=" + fontSize + " color=\"#" + fontColor
                + "\">" + source + "</font></html>";
    }
    
    public static boolean isSigned() {
        if (SignAction.getStudent() == null) {
            return false;
        } else {
            return true;
        }
    }
    
    public static Student getStudentFromXML(OMElement result) {
        Student stu = null;
        @SuppressWarnings("unchecked")
        Iterator<OMElement> iterator = result.getChildElements();
        if (iterator.hasNext()) {
            OMNode omNode = (OMNode) iterator.next();
            if (omNode.getType() == OMNode.ELEMENT_NODE) {
                OMElement omElement = (OMElement) omNode;
                if (omElement.getLocalName().toLowerCase().equals("return")) {
                    try {
                        stu = (Student) BeanUtil.processObject(
                                omElement,
                                Student.class, null, true,
                                new DefaultObjectSupplier(), null);
                    } catch (AxisFault e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
        return stu;
    }
    
    public static ArrayList<Message> getMessageFromXML(OMElement result) {
        Message ms = null;
        ArrayList<Message> message = new ArrayList<Message>();
        @SuppressWarnings("unchecked")
        Iterator<OMElement> iterator = result.getChildElements();
        while (iterator.hasNext()) {
            OMNode omNode = (OMNode) iterator.next();
            if (omNode.getType() == OMNode.ELEMENT_NODE) {
                OMElement omElement = (OMElement) omNode;
                if (omElement.getLocalName().toLowerCase().equals("return")) {
                    try {
                        ms = (Message) BeanUtil.processObject(
                                omElement,
                                Message.class, null, true,
                                new DefaultObjectSupplier(), null);
                        message.add(ms);
                    } catch (AxisFault e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
        return message;
    }
    
}
