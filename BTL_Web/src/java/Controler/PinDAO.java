/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Bravo;
import Model.Person;
import Model.Pin;
import Model.Post;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trung
 */
public class PinDAO extends DAO{
    
    private Connection connection;

    public PinDAO() {
        this.connection = getConnection();
    }
    
    public boolean checkPined(int PersonID, String UrlImg)
    {
        String cmd = "SELECT * FROM PIN AS Num WHERE (PersonID = " + PersonID + " AND UrlImg = '" 
                + UrlImg + "' );";
//        System.out.println(cmd);
        Statement preparedStatement;
        try {
            preparedStatement = connection.createStatement();
            ResultSet resultSet = preparedStatement.executeQuery(cmd);
            
            while(resultSet.next())
            {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PinDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
    
    public void save(Pin p){
        
        try {
            Statement statement = this.connection.createStatement();
            String sql = "INSERT INTO PIN(PersonID, UrlImg ) VALUES ( " + p.getPerson().getPersonID()
                    + ", '" + p.getPost().getUrlImg() + " ');";
            System.out.println(sql);
            
            int rs = statement.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(PinDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Pin> getPinByPersonID(int PersonID)
    {
        String cmd = "SELECT * FROM PIN WHERE PersonID = " + PersonID  + " ;";
        
        List<Pin> list = new ArrayList<Pin>();
        
         try {
            Statement preparedStatement = connection.createStatement();
            ResultSet resultSet = preparedStatement.executeQuery(cmd);
            Pin pin = new Pin();
            
            while(resultSet.next())
            {
                String urlImg = resultSet.getString("UrlImg");
                Person person = new Person(); person.setID(PersonID);
                Post post = new Post(); post.setUrlImg(urlImg);
//                pin = new Pin( new Person().setID(PersonID), new Post().setUrlImg(urlImg) );
                pin = new Pin(person, post);
                list.add(pin);
            }
            resultSet.close();
        }  
        catch (SQLException ex) {
            Logger.getLogger(PinDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
  

    
}
