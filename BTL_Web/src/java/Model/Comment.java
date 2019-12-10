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
public class Comment {
    
    private Person person;
    private String content;
    private Post post;
    private String time;

    public Comment(Person person, String content, Post post) {
        this.person = person;
        this.content = content;
        this.post = post;
    }

    public Comment() {
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Comment{" + "person=" + person + ", content=" + content + ", post=" + post + ", time=" + time + '}';
    }
    
    
    
}
