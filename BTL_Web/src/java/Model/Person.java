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
public class Person extends Acount{
    /*,[FullName]
      ,[Work]
      ,[Address]
      ,[Study]
      ,[Flower]
      ,[AcountID]
      ,[Avatar]
      ,[Cover]*/
    private int PersonID;
    private String FullName;
    private String Work;
    private String Address;
    private String Study;
    private int Flower;
    private String Avatar;
    private String Cover;
    private String Quotes;

    public Person(String FullName, String Work, String Address, String Study, int Flower, String Avatar, String Cover) {
        this.FullName = FullName;
        this.Work = Work;
        this.Address = Address;
        this.Study = Study;
        this.Flower = Flower;
        this.Avatar = Avatar;
        this.Cover = Cover;
    }

    public Person(String Work, String Address, String Study, int Flower, String Quotes) {
        this.Work = Work;
        this.Address = Address;
        this.Study = Study;
        this.Flower = Flower;
        this.Quotes = Quotes;
    }
    
    
    
    public String getQuotes() {
        return Quotes;
    }

    public void setQuotes(String Quotes) {
        this.Quotes = Quotes;
    }
    
    
    
    public Person() {
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getWork() {
        return Work;
    }

    public void setWork(String Work) {
        this.Work = Work;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getStudy() {
        return Study;
    }

    public void setStudy(String Study) {
        this.Study = Study;
    }

    public int getFlower() {
        return Flower;
    }

    public void setFlower(int Flower) {
        this.Flower = Flower;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String Avatar) {
        this.Avatar = Avatar;
    }

    public String getCover() {
        return Cover;
    }

    public void setCover(String Cover) {
        this.Cover = Cover;
    }

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int PersonID) {
        this.PersonID = PersonID;
    }

    @Override
    public String toString() {
        return "Person{" + "PersonID=" + PersonID + ", FullName=" + FullName + ", Work=" + Work + ", Address=" + Address + ", Study=" + Study + ", Flower=" + Flower + ", Avatar=" + Avatar + ", Cover=" + Cover + '}';
    }
    
    
    
    
   
    
}
