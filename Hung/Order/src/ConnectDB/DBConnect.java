/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Windows 10
 */
public class DBConnect {
    public static Connection getConnection(){
        final String url = "jdbc:mysql://localhost:3306/quanlyhoadon?autoReconnect=true&useSSL=false";
        final String user = "root";
        final String password = "123456";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        }catch (Exception e) {
            System.out.println("Kết nối thất bại! "+e);
        }
        return null;
    }
    
    
 
}
