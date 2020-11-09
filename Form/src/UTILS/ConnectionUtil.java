package UTILS;

import java.sql.*;
import javax.swing.*;
import java.awt.*;

public class ConnectionUtil {
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banhang?useUnicode=true&characterEncoding=UTF-8","root","");
		return conn;
	}
}
