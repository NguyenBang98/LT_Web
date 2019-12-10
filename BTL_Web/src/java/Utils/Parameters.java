/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author trung
 */
public class Parameters {
    
    
    // username login SQL server
    public static String userName = "sa";
    public static String passWord = "12101998";
    public static String dbClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // SQL
    
    public static String dbName = "db_LTWeb";
    public static String host =  "127.0.0.1";
    public static String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=db_LTWeb";
    public static int port = 1433; 
    public static String sqlServerURL = "jdbc:sqlserver://"+ host +":"+port+";" + "DatabaseName=" + dbName + ";";
    
    public static int STTBV   = 700;
    public static int STTSP   = 700;
    public static int STTBVSP = 700;
    public static int STTNMD  = 700;
    
}
