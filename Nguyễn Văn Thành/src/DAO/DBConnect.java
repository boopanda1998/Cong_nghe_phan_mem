/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author boopa
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DBConnect {

    public static Connection getConnection() {
        Connection cons = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cons = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/doanbandienthoai", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cons;
    }

    ResultSet executeQuery(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}