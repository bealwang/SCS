package entity;

import java.io.Serializable;

public class Message implements Serializable{
    /**
     * 
     */
    private int msId;
    private String msTitle;
    private String msBody;
    private String msTime;
    private String ownerId;
    private String ownerName;
    
    private static final long serialVersionUID = 1L;
    public Message(){};
    
    public int getMsId() {
        return msId;
    }
    public void setMsId(int msId) {
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
