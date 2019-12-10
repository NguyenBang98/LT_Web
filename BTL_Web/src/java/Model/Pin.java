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
public class Pin {
    
    private int PinID;
    private Person person;
    private Post post;

    public Pin() {
    }

    public Pin(Person person, Post post) {
        this.person = person;
        this.post = post;
    }

    public int getPinID() {
        return PinID;
    }

    public void setPinID(int PinID) {
        this.PinID = PinID;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
    
    
    
}
