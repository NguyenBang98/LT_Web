/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Person;
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
public class PersonDAO extends DAO{
    
    private Connection connection;
    public PersonDAO(){
        this.connection = getConnection();
    }
    
    public Person getPersonByID(int ID) {
        /*,[FullName]
      ,[Work]
      ,[Address]
      ,[Study]
      ,[Flower]
      ,[AcountID]
      ,[Avatar]
      ,[Cover]*/
        Person p = new Person();
        String cmd = "SELECT * FROM Persons WHERE PersonID = " + ID + ";";
        try {
            Statement preparedStatement = connection.createStatement();
            ResultSet resultSet = preparedStatement.executeQuery(cmd);
            while (resultSet.next()) {
                p = new Person(resultSet.getNString("FullName"), resultSet.getNString("Work"),
                        resultSet.getNString("Address"), resultSet.getNString("Study"),
                        resultSet.getInt("AcountID"), resultSet.getNString("Avatar"), resultSet.getString("Cover"));
                p.setQuotes(resultSet.getNString("Quotes"));
                p.setFlower(resultSet.getInt("Flower"));
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return p;
    }
    
    public Person getPersonByAcountID(int acountID) {
        Person p = new Person();
        String cmd = "SELECT * FROM Persons WHERE AcountID = " + acountID + ";";
        try {
            Statement preparedStatement = connection.createStatement();
            ResultSet resultSet = preparedStatement.executeQuery(cmd);
            while (resultSet.next()) {
                p = new Person(resultSet.getNString("FullName"), resultSet.getNString("Work"),
                        resultSet.getNString("Address"), resultSet.getNString("Study"),
                        resultSet.getInt("AcountID"), resultSet.getNString("Avatar"), resultSet.getString("Cover"));
                p.setPersonID(resultSet.getInt("PersonID"));

                p.setQuotes(resultSet.getNString("Quotes"));

                return p;
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    public void updateInfor(Person p, int PersonID) {

        String query = "update Persons set Work='" + p.getWork() + "', Address ='" + p.getAddress() + "', Study='" + p.getStudy() + "',Flower ='" + p.getFlower()
                + "',Quotes ='" + p.getQuotes() + "' where PersonID = " + PersonID + ";";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);

        } catch (SQLException ex) {
            Logger.getLogger(EditInforServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateCover(Person p) {

        String query = "UPDATE Persons SET Cover ='" + p.getCover() + "' WHERE PersonID = " + p.getPersonID()+ ";";
        System.out.println(query);
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);

        } catch (SQLException ex) {
            Logger.getLogger(EditInforServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void updateAvatar(Person p) {

        String query = "UPDATE Persons SET Avatar ='" + p.getAvatar() + "' WHERE PersonID = " + p.getPersonID()+ ";";
        System.out.println(query);
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);

        } catch (SQLException ex) {
            Logger.getLogger(EditInforServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void addPersonByAccID(int AccountID) throws SQLException {
        String query = "insert into Persons(AcountID,Avatar,Cover) values(" + AccountID + ",'img/df.jpg','img/df_cover.png');";
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }
    
//    public static void main(String[] args) {
//        PersonDAO personDAO = new PersonDAO();
//        Person p = personDAO.getPersonByAcountID(1);
//        System.out.println(p);
//    }
}
