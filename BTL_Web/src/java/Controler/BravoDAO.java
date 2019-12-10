/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Bravo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trung
 */
public class BravoDAO extends DAO{
    
    private Connection connection;

    public BravoDAO() {
        this.connection = getConnection();
    }
    
    public void delete(Bravo b){
        
        
        String cmd = "DELETE FROM BRAVO WHERE (PersonID = " + b.getPerson().getPersonID() + " AND PostID = " 
                + b.getPost().getID() + " );";
        System.out.println(cmd);
        try {
            Statement statement = this.connection.createStatement();
            statement.executeUpdate(cmd);
        } catch (SQLException ex) {
            Logger.getLogger(BravoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void save(Bravo  b){
        
        try {
            Statement statement = this.connection.createStatement();
            String sql = "INSERT INTO BRAVO(PersonID, PostID ) VALUES ( " + b.getPerson().getPersonID()
                    + "," + b.getPost().getID() + ");";
            System.out.println(sql);
            
            int rs = statement.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(BravoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public boolean checkBravo(int PersonID, int PostID)
    {
        String cmd = "SELECT * FROM BRAVO AS Num WHERE (PersonID = " + PersonID + " AND PostID = " 
                + PostID + ");";
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
            Logger.getLogger(BravoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public void deleteBRAVO(int PostID){
        
        
        String cmd = "DELETE FROM BRAVO WHERE PostID = " + PostID + ";";
        try {
            Statement statement = this.connection.createStatement();
            System.out.println(cmd);
            statement.executeUpdate(cmd);
            
        } catch (SQLException ex) {
            Logger.getLogger(BravoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
   
    
}
