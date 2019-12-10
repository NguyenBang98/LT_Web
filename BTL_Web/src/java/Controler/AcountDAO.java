/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Acount;
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
public class AcountDAO extends DAO {

    private Connection connection;

    public AcountDAO() {
        this.connection = getConnection();
    }

    public Acount getUserByID(Acount a) {
        
        // encode pass 
        
        String encode = Utils.Function.getSHAHash(""+a.getPassword());
        
        if(Utils.Function.CheckSqlInjection(a.getUsername()) == false){
            a.setID(-1);
            return a;
        }
        
        String cmd = "SELECT * FROM Acounts WHERE username = '";
        cmd = cmd + a.getUsername() + "' AND password = '" + encode + "';";

        try {
            Statement preparedStatement = connection.createStatement();
            ResultSet resultSet = preparedStatement.executeQuery(cmd);
            while (resultSet.next()) {
                a.setID(resultSet.getInt("AcountID"));
                return a;
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(AcountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        a.setID(-1);
        return a;
    }

    public boolean checkEmail(String email) {
        String cmd = "SELECT * FROM Acounts WHERE email = '" + email + "';";
        try {
            Statement preparedStatement = connection.createStatement();
            ResultSet resultSet = preparedStatement.executeQuery(cmd);
            while (resultSet.next()) {
                return true;
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(AcountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void changePassword(String email, String password){
        
        String cmd = "UPDATE Acounts SET password = '" + password+ "' WHERE email = '" + email + "';"; 
        try {
            Statement statement = this.connection.createStatement();
            System.out.println(cmd);
            statement.executeUpdate(cmd);
            
        } catch (SQLException ex) {
            Logger.getLogger(AcountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public void updateEmail(String email, int AccountID) {

        String query = "update Acounts set email='" + email + "' where AcountID =" + AccountID + ";";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);

        } catch (SQLException ex) {
            Logger.getLogger(EditInforServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public Acount getAccount(int accountID) {
        Acount account = new Acount();
        String cmd = "SELECT * FROM Acounts WHERE AcountID=" + accountID + ";";
        
        try {
            Statement preparedStatement = connection.createStatement();
            ResultSet resultSet = preparedStatement.executeQuery(cmd);
            while (resultSet.next()) {
                account.setID(resultSet.getInt("AcountID"));
                account.setEmail(resultSet.getString("email"));
                account.setUsername(resultSet.getString("username"));
                account.setPassword(resultSet.getString("password"));
                return account;
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(AcountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return account;
    }
    
    public void addAccount(Acount account) throws SQLException {

        String query = "insert into Acounts(username, password, email) "
                + "values('" + account.getUsername() + "','" + account.getPassword() + "','" + account.getEmail() + "');";

        Statement statement = connection.createStatement();
        statement.executeUpdate(query);

    }

    public Acount getAccountByUsername(String username) {
        String cmd = "SELECT * FROM Acounts WHERE username = '" + username + "';";
        Acount a = new Acount();

        try {
            Statement preparedStatement = connection.createStatement();
            ResultSet resultSet = preparedStatement.executeQuery(cmd);
            while (resultSet.next()) {
                a.setID(resultSet.getInt("AcountID"));
                a.setEmail(resultSet.getString("email"));
                a.setUsername(resultSet.getString("username"));
                a.setUsername(resultSet.getString("password"));
                return a;
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(AcountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        a.setID(-1);
        return a;
    }
    
    public boolean checkEmailExist(String email)
    {
        String cmd = "SELECT * FROM Acounts WHERE email = '" + email+"';";
        try {
            Statement preparedStatement = connection.createStatement();
            ResultSet resultSet = preparedStatement.executeQuery(cmd);
            while (resultSet.next()) {
                return true;
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(AcountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean checkUserExist(String email)
    {
        String cmd = "SELECT * FROM Acounts WHERE username = '" + email+"';";
        try {
            Statement preparedStatement = connection.createStatement();
            ResultSet resultSet = preparedStatement.executeQuery(cmd);
            while (resultSet.next()) {
                return true;
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(AcountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
