/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Notification;
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
public class NotificationDAO extends DAO{
    
    
    private Connection connection;

    public NotificationDAO() {
        this.connection = getConnection();
    }
    
    public List<Notification> getNotification(int PReceive){
        
        List<Notification> list = new ArrayList<>();
        String cmd = "SELECT * FROM Notice WHERE PReceive = " + PReceive + ";";
        
        try {
            Statement preparedStatement = connection.createStatement();
            ResultSet resultSet = preparedStatement.executeQuery(cmd);
            Notification notification = new Notification();
            PersonDAO pdao = new PersonDAO();
            PostDAO p = new PostDAO();

            while(resultSet.next())
            {
                int ID = resultSet.getInt("ID");
                int PSend = resultSet.getInt("PSend");
                int Preceive = resultSet.getInt("PReceive");
                String content = resultSet.getNString("Content");
                int postID =  resultSet.getInt("PostID");
                
                Person pSend = pdao.getPersonByID(PSend);
                Post post = p.getPostByID(postID);
                Person pReceive = post.getP();
                
                notification = new Notification(pSend, pReceive, content, post);
                notification.setID(ID);
                list.add(notification);
//                System.out.println(p);
            }
            resultSet.close();
        }  
        catch (SQLException ex) {
            Logger.getLogger(NotificationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        
    }
    
    public void saveNotice(Notification n){
        
         try {
            Statement statement = this.connection.createStatement();
            String sql = "INSERT INTO Notice(PSend, PReceive, Content, PostID ) VALUES (" +
                    n.getpSend().getPersonID()+ "," + n.getpReceive().getPersonID() + ", N'" + n.getContent() 
                    + "'," +n.getPost().getID() +  ");";
            System.out.println(sql);
            
            int rs = statement.executeUpdate(sql);
//            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(NotificationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void deleteNoti(int PostID){
        
        
        String cmd = "DELETE FROM Notice WHERE PostID = " + PostID + ";";
        try {
            Statement statement = this.connection.createStatement();
            System.out.println(cmd);
            statement.executeUpdate(cmd);
            
        } catch (SQLException ex) {
            Logger.getLogger(BravoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
//    public static void main(String[] args) {
//        NotificationDAO ndao = new NotificationDAO();
//        List<Notification> ns = ndao.getNotification(2);
//        for(Notification n: ns)
//        {
//            System.out.println(n);
//           
//        }
//    }
    
    
    
    
}
