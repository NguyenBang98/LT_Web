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
public class Notification {
    
    private int ID;
    private Person pSend;
    private Person pReceive;
    private String content;
    private Post post;

    public Notification() {
    }

    public Notification(Person pSend, Person pReceive, String content, Post post) {
        this.pSend = pSend;
        this.pReceive = pReceive;
        this.content = content;
        this.post = post;
    }

    public Person getpSend() {
        return pSend;
    }

    public void setpSend(Person pSend) {
        this.pSend = pSend;
    }

    public Person getpReceive() {
        return pReceive;
    }

    public void setpReceive(Person pReceive) {
        this.pReceive = pReceive;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    @Override
    public String toString() {
        return "Notification{" + "pSend=" + pSend + ", pReceive=" + pReceive + ", content=" + content + ", post=" + post + '}';
    }
}
