/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Comment;
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
public class CommentDAO extends DAO {

    private Connection connection;

    public CommentDAO() {
        this.connection = getConnection();
    }

    public List<Comment> getCmtByIDPost(int PostID) {

        List<Comment> list = new ArrayList<Comment>();

        String cmd = "SELECT * FROM Comments WHERE PostID = " + PostID + ";";

        try {
            Statement preparedStatement = connection.createStatement();
            ResultSet resultSet = preparedStatement.executeQuery(cmd);
            Post post = new Post();
            Person person = new Person();
            PersonDAO personDAO = new PersonDAO();
            PostDAO postDAO = new PostDAO();
            Comment comment = new Comment();
            while (resultSet.next()) {
                
                int personID = resultSet.getInt("PersonID");
                String content = resultSet.getNString("Content");
                int postID =  resultSet.getInt("PostID");
                
                person = personDAO.getPersonByID(personID);
                post = postDAO.getPostByID(postID);
                comment = new Comment(person, content, post);
                
                list.add(comment);
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }
    
    public void saveCmt(Comment c)
    {
        try {
            Statement statement = this.connection.createStatement();
            String sql = "INSERT INTO Comments(PersonID,Content,PostID) VALUES ( "+ c.getPerson().getPersonID() + 
                    ", N'" + c.getContent() +"'," + c.getPost().getID() + ");";
            System.out.println(sql);
            
            int rs = statement.executeUpdate(sql);
//            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deleteComment(int PostID){
        
        
        String cmd = "DELETE FROM Comments WHERE PostID = " + PostID + ";";
        try {
            Statement statement = this.connection.createStatement();
            System.out.println(cmd);
            statement.executeUpdate(cmd);
            
        } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
