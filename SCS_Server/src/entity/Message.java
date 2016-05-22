package entity;

import java.io.Serializable;

public class Message implements Serializable{
    /**
     * 
     */
    private int msId;
    private String msTitle;
    private String msBody;
    private String ownerId;
    
    private static final long serialVersionUID = 1L;
    public Message(){};
    public Message(String ownerId, String msTitle, String msBody){
        this.ownerId = ownerId;
        this.msTitle = msTitle;
        this.msBody = msBody;
    }
    
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
    
}
