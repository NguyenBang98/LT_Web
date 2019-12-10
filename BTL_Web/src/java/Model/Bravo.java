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
public class Bravo {
    
    private Person person;
    
    private Post post;

    public Bravo(Person person, Post post) {
        this.person = person;
        this.post = post;
    }

    public Bravo() {
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
