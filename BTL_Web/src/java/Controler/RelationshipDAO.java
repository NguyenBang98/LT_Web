/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Person;
import Model.Relation;
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
public class RelationshipDAO extends DAO{
    
    private Connection connection;

    public RelationshipDAO() {
        this.connection = getConnection();
    }
    
    public boolean checkRelationShip(Relation r) 
    {
        int ID1 = r.getP1().getPersonID();
        int ID2 = r.getP2().getPersonID();
        String cmd = "SELECT * FROM RELATIONSHIP AS Num WHERE (PersonID1 = " +ID1  + " AND PersonID2 =" +ID2 + ");"   ;
        
        Statement preparedStatement;
        try {
            preparedStatement = connection.createStatement();
            ResultSet resultSet = preparedStatement.executeQuery(cmd);
            
            while(resultSet.next())
            {
//                int n = resultSet.getInt("Num");
//                System.out.println(n);
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RelationshipDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean checkRelationShip(int ID1, int ID2) 
    {
        String cmd = "SELECT * FROM RELATIONSHIP AS Num WHERE (PersonID1 = " +ID1  + " AND PersonID2 =" +ID2 + ");"   ;
        
        Statement preparedStatement;
        try {
            preparedStatement = connection.createStatement();
            ResultSet resultSet = preparedStatement.executeQuery(cmd);
            
            while(resultSet.next())
            {
//                int n = resultSet.getInt("Num");
//                System.out.println(n);
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RelationshipDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public void createRelation(Relation r){
        
        try {
            Statement statement = this.connection.createStatement();
            String sql = "INSERT INTO RELATIONSHIP(PersonID1, PersonID2 ) VALUES ( " + r.getP1().getPersonID() 
                    + "," + r.getP2().getPersonID() + ");";
            System.out.println(sql);
            
            int rs = statement.executeUpdate(sql);
//            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void deleteRelation(Relation r)
    {
        int ID1 = r.getP1().getPersonID();
        int ID2 = r.getP2().getPersonID();
        String cmd = "DELETE FROM RELATIONSHIP WHERE (PersonID1 = " +ID1  + " AND PersonID2 =" +ID2 + ") OR " 
                + "(PersonID2 = " + ID1  + " AND PersonID1 =" +ID2 + ");"   ;
       System.out.println(cmd);
        try {
            Statement statement = this.connection.createStatement();
            statement.executeUpdate(cmd);
        } catch (SQLException ex) {
            Logger.getLogger(RelationshipDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public List<Person> getFollower(int PersonID) {

        String query = "SELECT * FROM RELATIONSHIP WHERE PersonID2 = " + PersonID + ";";

        Relation relation = new Relation();
        PersonDAO personDAO = new PersonDAO();
        Person person = new Person();

        List<Person> listFollower = new ArrayList<Person>();
        try {
            Statement preparedStatement = connection.createStatement();
            ResultSet resultSet = preparedStatement.executeQuery(query);

            while (resultSet.next()) {
                person = personDAO.getPersonByID(resultSet.getInt("PersonID1"));
                person.setPersonID(resultSet.getInt("PersonID1"));
                
                listFollower.add(person);

            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listFollower;
    }
    
    public List<Person> getFollowing(int PersonID) {

        String query = "SELECT * FROM RELATIONSHIP WHERE PersonID1 = " + PersonID + ";";

        Relation relation = new Relation();
        PersonDAO personDAO = new PersonDAO();
        Person person = new Person();

        List<Person> listFollowing = new ArrayList<Person>();
        try {
            Statement preparedStatement = connection.createStatement();
            ResultSet resultSet = preparedStatement.executeQuery(query);

            while (resultSet.next()) {
                person = personDAO.getPersonByID(resultSet.getInt("PersonID2"));
                person.setPersonID(resultSet.getInt("PersonID2"));
                
                listFollowing.add(person);

            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listFollowing;
    }
//    public static void main(String[] args) {
//        RelationshipDAO r = new RelationshipDAO();
//        
//    }
       
        
}
