package edu.ucas.entity;

import java.io.Serializable;

public class Message implements Serializable{
    /**
     * 
     */
    private String msId;
    private String ownerName;
    private String msTitle;
    private String msBody;
    private String msTime;
    private String ownerId;
    
    private static final long serialVersionUID = 1L;
    public Message(){};
    public Message(String ownerId, String ownerName, String msTime,
            String msTitle,
            String msBody){
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.msTitle = msTitle;
        this.msBody = msBody;
        this.msTime = msTime;
    }
    
    public void show() {
        System.out.println("ms_id:" + this.msId + "  owner_id:" + this.ownerId
                + "owner_name" + this.ownerName
                + "ms_time" + this.msTime
                + "\n ms_title:" + this.msTitle
                + "\n ms_body:" + this.msBody);
    }
    public String getMsId() {
        return msId;
    }
    public void setMsId(String msId) {
        this.msId = msId;
    }
    public String getMsTitle() {
        return msTitle;
    }
    public void setMsTitle(String msTitle) {
        this.msTitle = msTitle;
    }
    public String getMsBody() {
        return msBody;
    }
    public void setMsBody(String msBody) {
        this.msBody = msBody;
    }
    public String getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
    public String getOwnerName() {
        return ownerName;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public String getMsTime() {
        return msTime;
    }
    public void setMsTime(String msTime) {
        this.msTime = msTime;
    }
    
}
