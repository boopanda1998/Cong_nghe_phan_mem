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
import javax.swing.JOptionPane;

public class DBConnect {

    public static Connection getConnection() {
        String Host     ="localhost:3306";//thông tin host của database sever mình kết nối tới
 	String Username ="root";//Thông tin tên đăng nhập của database sever
 	String Password ="";//thông tin mật khẩu của database sever
 	String Database ="quanlycuahang";//Tên database muốn connect tới
//        
        Connection cons = null;
//        
        try {
                Class.forName("com.mysql.jdbc.Driver");
            cons = DriverManager.getConnection(
                    "jdbc:mysql://"+Host+"/"+Database,Username,Password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cons;
    }

//    public static void main(String[] args) {
//        System.out.println(getConnection());
//    }
    
}
