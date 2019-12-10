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
public class Acount {
    
    private int ID;
    private String username;
    private String password;
    private String email;
    
    public Acount() {
    }

    public Acount(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
    
    public Acount(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Acount{" + "ID=" + ID + ", username=" + username + ", password=" + password + ", email=" + email + '}';
    }
    
    
}
