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
public class Relation {
    
    private int ID;
    private Person p1;
    private Person p2;

    public Relation() {
    }

    public Relation(Person p1, Person p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
    
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Person getP1() {
        return p1;
    }

    public void setP1(Person p1) {
        this.p1 = p1;
    }

    public Person getP2() {
        return p2;
    }

    public void setP2(Person p2) {
        this.p2 = p2;
    }
    
    
    
}
