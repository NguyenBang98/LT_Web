/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trung
 */
public class DAO {
    
    private Connection connection;

    public DAO() {
        
    }
    public Connection getConnection() {
        try {
            // nap Driver
            Class.forName(Utils.Parameters.dbClass);
               
            // thiết lập kết nối
            connection = DriverManager.getConnection(Utils.Parameters.sqlServerURL
                    , Utils.Parameters.userName, Utils.Parameters.passWord);
//            if (connection!= null) System.out.println("Kết nối thành công!");  
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
                System.out.println("Kết nối không thành công!");
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }    
 
}
