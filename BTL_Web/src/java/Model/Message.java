/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author trung
 */
/*import lombok.Data;*/

import java.util.Date;

public class Message {

    private String content;
    private String sender;
    private Date received;

    public Message() {
    }
    
    public String getContent() {
        return content;
    }

    public Message(String content, String sender, Date received) {
        this.content = content;
        this.sender = sender;
        this.received = received;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Date getReceived() {
        return received;
    }

    public void setReceived(Date received) {
        this.received = received;
    }
    
    
}