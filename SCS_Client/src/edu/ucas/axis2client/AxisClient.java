package edu.ucas.axis2client;

import java.util.ArrayList;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.Constants;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import edu.ucas.entity.Message;
import edu.ucas.entity.Student;
import edu.ucas.utils.Utils;

public class AxisClient{
    private static EndpointReference targetEPR =
            new EndpointReference(
                    "http://localhost:8080/axis2/services/SCSService");
    
    public static Student signIn(String phoneNumber, String passWord) {
        OMFactory fac = OMAbstractFactory.getOMFactory();
        OMNamespace omNs = fac.createOMNamespace(
                "http://service", "tns");
        
        OMElement method = fac.createOMElement("signIn", omNs);
        OMElement value1 = fac.createOMElement("phoneNumber", omNs);
        value1.addChild(fac.createOMText(value1, phoneNumber));
        method.addChild(value1);
        OMElement value2 = fac.createOMElement("passWord", omNs);
        value2.addChild(fac.createOMText(value2, passWord));
        method.addChild(value2);
        
        Options options = new Options();
        options.setTo(targetEPR);
        options.setTransportInProtocol(Constants.TRANSPORT_HTTP);
        
        ServiceClient sender;
        try {
            sender = new ServiceClient();
            sender.setOptions(options);
            OMElement result = sender.sendReceive(method);
            return Utils.getStudentFromXML(result);
        } catch (AxisFault e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
        
    }
    
    public static boolean signUp(String phoneNumber, String userName,
            String passWord) {
        OMFactory fac = OMAbstractFactory.getOMFactory();
        OMNamespace omNs = fac.createOMNamespace(
                "http://service", "tns");
        
        OMElement method = fac.createOMElement("signUp", omNs);
        OMElement value1 = fac.createOMElement("phoneNumber", omNs);
        value1.addChild(fac.createOMText(value1, phoneNumber));
        method.addChild(value1);
        OMElement value2 = fac.createOMElement("userName", omNs);
        value2.addChild(fac.createOMText(value2, userName));
        method.addChild(value2);
        OMElement value3 = fac.createOMElement("passWord", omNs);
        value3.addChild(fac.createOMText(value3, passWord));
        method.addChild(value3);
        
        Options options = new Options();
        options.setTo(targetEPR);
        options.setTransportInProtocol(Constants.TRANSPORT_HTTP);
        
        ServiceClient sender;
        try {
            sender = new ServiceClient();
            sender.setOptions(options);
            OMElement result = sender.sendReceive(method);
            String response = result.getFirstElement().getText();
            if (response.equals("true")) {
                return true;
            }
        } catch (AxisFault e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean deleteMessage(String msId) {
        OMFactory fac = OMAbstractFactory.getOMFactory();
        OMNamespace omNs = fac.createOMNamespace(
                "http://service", "tns");
        
        OMElement method = fac.createOMElement("deleteMessage", omNs);
        OMElement value = fac.createOMElement("msId", omNs);
        value.addChild(fac.createOMText(value, msId));
        method.addChild(value);
        
        Options options = new Options();
        options.setTo(targetEPR);
        options.setTransportInProtocol(Constants.TRANSPORT_HTTP);
        
        ServiceClient sender;
        try {
            sender = new ServiceClient();
            sender.setOptions(options);
            OMElement result = sender.sendReceive(method);
            String response = result.getFirstElement().getText();
            if (response.equals("true")) {
                return true;
            }
        } catch (AxisFault e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    
    public static ArrayList<Message> getAllMessage() {
        ArrayList<Message> ms = new ArrayList<Message>();
        OMFactory fac = OMAbstractFactory.getOMFactory();
        OMNamespace omNs = fac.createOMNamespace(
                "http://service", "tns");
        OMElement method = fac.createOMElement("getAllMessage", omNs);
        
        Options options = new Options();
        options.setTo(targetEPR);
        options.setTransportInProtocol(Constants.TRANSPORT_HTTP);
        
        ServiceClient sender;
        try {
            sender = new ServiceClient();
            sender.setOptions(options);
            OMElement result = sender.sendReceive(method);
            ms = Utils.getMessageFromXML(result);
        } catch (AxisFault e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ms;
    }
    
    public static ArrayList<Message> getMyMessage(String phoneNumber) {
        ArrayList<Message> ms = new ArrayList<Message>();
        OMFactory fac = OMAbstractFactory.getOMFactory();
        OMNamespace omNs = fac.createOMNamespace(
                "http://service", "tns");
        
        OMElement method = fac.createOMElement("getMyMessage", omNs);
        OMElement value = fac.createOMElement("phoneNumber", omNs);
        value.addChild(fac.createOMText(value, phoneNumber));
        method.addChild(value);
        
        Options options = new Options();
        options.setTo(targetEPR);
        options.setTransportInProtocol(Constants.TRANSPORT_HTTP);
        
        ServiceClient sender;
        try {
            sender = new ServiceClient();
            sender.setOptions(options);
            OMElement result = sender.sendReceive(method);
            ms = Utils.getMessageFromXML(result);
        } catch (AxisFault e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ms;
    }
    
    public static String forgotPassWord(String phoneNumber) {
        OMFactory fac = OMAbstractFactory.getOMFactory();
        OMNamespace omNs = fac.createOMNamespace(
                "http://service", "tns");
        
        OMElement method = fac.createOMElement("forgotPassWord", omNs);
        OMElement value = fac.createOMElement("phoneNumber", omNs);
        value.addChild(fac.createOMText(value, phoneNumber));
        method.addChild(value);
        
        Options options = new Options();
        options.setTo(targetEPR);
        options.setTransportInProtocol(Constants.TRANSPORT_HTTP);
        
        ServiceClient sender;
        try {
            sender = new ServiceClient();
            sender.setOptions(options);
            OMElement result = sender.sendReceive(method);
            String response = result.getFirstElement().getText();
            return response;
        } catch (AxisFault e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "null";
    }
    
    public static boolean publishMessage(String phoneNumber, String msTitle,
            String msBody) {
        OMFactory fac = OMAbstractFactory.getOMFactory();
        OMNamespace omNs = fac.createOMNamespace(
                "http://service", "tns");
        
        OMElement method = fac.createOMElement("publishMessage", omNs);
        OMElement value1 = fac.createOMElement("ownerId", omNs);
        value1.addChild(fac.createOMText(value1, phoneNumber));
        method.addChild(value1);
        OMElement value2 = fac.createOMElement("msTitle", omNs);
        value2.addChild(fac.createOMText(value2, msTitle));
        method.addChild(value2);
        OMElement value3 = fac.createOMElement("msBody", omNs);
        value3.addChild(fac.createOMText(value3, msBody));
        method.addChild(value3);
        
        Options options = new Options();
        options.setTo(targetEPR);
        options.setTransportInProtocol(Constants.TRANSPORT_HTTP);
        
        ServiceClient sender;
        try {
            sender = new ServiceClient();
            sender.setOptions(options);
            OMElement result = sender.sendReceive(method);
            String response = result.getFirstElement().getText();
            if (response.equals("true")) {
                return true;
            }
        } catch (AxisFault e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
}