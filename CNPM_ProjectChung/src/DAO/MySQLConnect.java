package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MySQLConnect {
    private String user = "root";
    private String password="";
    private String url="jdbc:mysql://localhost:3308/cnpm?useUnicode=true&characterEncoding=UTF-8";
    private Connection connection = null;
    private Statement statement = null;
    
    public boolean Connect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected");
            return true; //Connect thành công
        } catch (ClassNotFoundException | SQLException ex) {
            //System.out.println(ex);
            System.out.println("Connect fail!");
            //Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(null, "Connect database thất bại!", "Waring!", JOptionPane.INFORMATION_MESSAGE);
            return false; //Connect thất bại
        }
    }
    public boolean disConnect()
    { 
        try{
            statement.close();
            connection.close();
            System.out.println("disconnected");
            return true; //Disconnect thành công
        }catch (SQLException e){
            return false; //Disconnect thất bại
        }
    }
    
    public ResultSet executeQuery(String sql)
    {
        ResultSet result = null;
        try {
            Connect();
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            System.out.println("Query complete!");
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnect.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Query fail!");
            return null;
        }    
    }
    
    public boolean executeUpdate(String sql)
    {
        try {
            if (Connect()) {
                statement = connection.createStatement();
                if (statement.executeUpdate(sql) == 0) {
                    System.out.println("Update that bai");
                    disConnect();
                    return false;
                }                
                System.out.println("Update thanh cong!");
                disConnect();
                return true;
            } else {
                System.out.println("Connect thất bại");
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnect.class.getName()).log(Level.SEVERE, null, ex);  
            System.out.println(ex);
            System.out.println("Update that bai");
            return false;
        }
    }
    public Connection getConnection()
    {
        Connect();
        return connection;
    }
    public boolean isConnect()
    {
        return connection!=null?true:false;
    }
    
    public static void main(String[] args) {
        MySQLConnect connection = new MySQLConnect();
        connection.Connect();
        connection.disConnect();
    }
}