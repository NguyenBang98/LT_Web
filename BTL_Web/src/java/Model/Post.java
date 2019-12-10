/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controler.RelationshipDAO;

/**
 *
 * @author trung
 */
public class Post {
    
    private int ID;
    private String Content;
    private String UrlImg;
    private String Date;
    private Person p;
    private int NBravo;
    
    
    public Post(String Content, String UrlImg, String Date) {
        this.Content = Content;
        this.UrlImg = UrlImg;
        this.Date = Date;
    }

    public Post(int ID, String Content, String UrlImg, String Date, Person p) {
        this.ID = ID;
        this.Content = Content;
        this.UrlImg = UrlImg;
        this.Date = Date;
        this.p = p;
    }
    
    public Post(int ID, String Content, String UrlImg, String Date) {
        this.ID = ID;
        this.Content = Content;
        this.UrlImg = UrlImg;
        this.Date = Date;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    
    public Post() {
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public String getUrlImg() {
        return UrlImg;
    }

    public void setUrlImg(String UrlImg) {
        this.UrlImg = UrlImg;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
    }

    public int getNBravo() {
        return NBravo;
    }

    public void setNBravo(int NBravo) {
        this.NBravo = NBravo;
    }
    
    @Override
    public String toString() {
        return "Post{" + "ID=" + ID + ", Content=" + Content + ", UrlImg=" + UrlImg + ", Date=" + Date + ", p=" + p + '}';
    }

    
    
}
