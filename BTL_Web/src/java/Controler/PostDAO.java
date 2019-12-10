/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Person;
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
public class PostDAO extends DAO{
    
    private Connection connection;

    public PostDAO() {
        this.connection = getConnection();
    }
    
    public List<Post> getPostAll()
    {
        List<Post> list = new ArrayList<Post>();
        
        String cmd = "SELECT * FROM Posts";
        try {
            Statement preparedStatement = connection.createStatement();
            ResultSet resultSet = preparedStatement.executeQuery(cmd);
            Post p = new Post();
            PersonDAO pdao = new PersonDAO();
//            System.out.println("Add post to list");
            while(resultSet.next())
            {
                p = new Post(resultSet.getInt("PostID"),resultSet.getNString("Content"), resultSet.getNString("UrlImg"), 
                resultSet.getNString("Time"));
                
                p.setNBravo(resultSet.getInt("NBravo"));
                int PersonID = resultSet.getInt("PersonID"); 
                
//                System.out.println("Person" + PersonID);
                Person person = pdao.getPersonByID(PersonID);
                person.setPersonID(PersonID);
                p.setP(person);
                list.add(p);
//                System.out.println(p);
            }
            resultSet.close();
        }  
        catch (SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public void savePost(Post post)
    {
         try {
            Statement statement = this.connection.createStatement();
            String sql = "INSERT INTO Posts(Content,UrlImg,Time,PersonID ) VALUES ( N'" 
                + post.getContent() + "' , '" + post.getUrlImg() + "' , '" + post.getDate()
                    + "' , '" + post.getP().getPersonID() +"');";
            System.out.println(sql);
            
            int rs = statement.executeUpdate(sql);
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Post> getPostByID(String ID)
    {
        List<Post> list = new ArrayList<Post>();
        
        String cmd = "SELECT * FROM Posts WHERE PersonID = " + ID + ";";
        try {
            Statement preparedStatement = connection.createStatement();
            ResultSet resultSet = preparedStatement.executeQuery(cmd);
            Post p = new Post();
            PersonDAO pdao = new PersonDAO();
//            System.out.println("Add post to list");
            while(resultSet.next())
            {
                p = new Post(resultSet.getInt("PostID"),resultSet.getNString("Content"), resultSet.getNString("UrlImg"), 
                resultSet.getNString("Time"));
                p.setNBravo(resultSet.getInt("NBravo"));
                int PersonID = resultSet.getInt("PersonID"); 
                
//                System.out.println("Person" + PersonID);
                Person person = pdao.getPersonByID(PersonID);
                person.setPersonID(PersonID);
                p.setP(person);
                list.add(p);
//                System.out.println(p);
            }
            resultSet.close();
        }  
        catch (SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public void updatePost(Post post)
    {
        String cmd = "UPDATE Posts SET NBravo = " + post.getNBravo() + " WHERE PostID = " + post.getID() + " ;";
        
        try {
            Statement statement = this.connection.createStatement();
            System.out.println(cmd);
            statement.executeUpdate(cmd);
            
        } catch (SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public void deletePost(int PostID){
        
        
        String cmd = "DELETE FROM Posts WHERE PostID = " + PostID + ";";
        try {
            Statement statement = this.connection.createStatement();
            System.out.println(cmd);
            statement.executeUpdate(cmd);
            
        } catch (SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void updateBV (Post p)
    {
        String cmd =  "UPDATE Posts SET Content = " +  "'"  +p.getContent()+ "' WHERE PostID = " + p.getID() + ";";
        try {
            Statement statement = this.connection.createStatement();
            System.out.println(cmd);
            statement.executeUpdate(cmd);
            
        } catch (SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Post getPostByID(int PostID)
    {
        String cmd = "SELECT * FROM Posts WHERE PostID = " + PostID + ";";
        Post p = new Post();
        try {
            Statement preparedStatement = connection.createStatement();
            ResultSet resultSet = preparedStatement.executeQuery(cmd);
            
            PersonDAO pdao = new PersonDAO();
//            System.out.println("Add post to list");
            while(resultSet.next())
            {
                p = new Post(resultSet.getInt("PostID"),resultSet.getNString("Content"), resultSet.getNString("UrlImg"), 
                resultSet.getNString("Time"));
                p.setNBravo(resultSet.getInt("NBravo"));
                int PersonID = resultSet.getInt("PersonID"); 
                
//                System.out.println("Person" + PersonID);
                Person person = pdao.getPersonByID(PersonID);
                person.setPersonID(PersonID);
                p.setP(person);
            }
            
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
       return p;
        
    }
    
   
}
