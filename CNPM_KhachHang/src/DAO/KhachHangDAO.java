package DAO;

import DTO.KhachHangDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KhachHangDAO {
    private  MySQLConnect mySQL = new MySQLConnect();
    public KhachHangDAO() {
    }
    public ArrayList<KhachHangDTO> list()
    {
        ArrayList<KhachHangDTO> listKhachHang = new ArrayList<>();
        try {          
            String sql = "SELECT * FROM khachhang";
            ResultSet result = mySQL.executeQuery(sql);
            while(result.next())
            {
                String MaKH = result.getString("MaKhachHang");
                String HoKH = result.getString("Ho");
                String TenKH = result.getString("Ten");
                String SDT = result.getString("SDT");
                boolean enable = result.getBoolean("enable");

                KhachHangDTO KhachHang = new KhachHangDTO(MaKH, HoKH, TenKH, SDT, enable);
                listKhachHang.add(KhachHang);
            }
            result.close();
            mySQL.disConnect();
            return listKhachHang;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }        
    }

    public boolean set(KhachHangDTO kh) {
            MySQLConnect mySQL = new MySQLConnect();
            String sql = "UPDATE `khachhang` SET ";
            sql += "`Ho` = '"+kh.getHoKH()+"', ";
            sql += "`Ten` = '"+kh.getTenKH()+"', ";
            sql += "`SDT` = '"+kh.getSDT()+"' ";
            sql += "WHERE `khachhang`.`MaKhachHang` = '"+kh.getMaKH()+"'";
            System.out.println(sql);                      
            if (mySQL.executeUpdate(sql)) return true;
            else return false;
    }

public boolean add(KhachHangDTO kh)
{
   
        MySQLConnect mySQL = new MySQLConnect();
        
        String sql = "INSERT INTO `khachhang`(`MaKhachHang`, `Ho`, `Ten`, `SDT`, `enable`) VALUES (";
            sql+= "'"+kh.getMaKH()+"',";
            sql+= " '"+kh.getHoKH()+"',";
            sql+= " '"+kh.getTenKH()+"',";
            sql+= " '"+kh.getSDT()+"',";
            sql+= " 1)";
        System.out.println(sql);
        if (mySQL.executeUpdate(sql))   return true;
        else return false;      
}
    public boolean delete(String MaKH)
    {
        MySQLConnect mySQL = new MySQLConnect();
        String sql = "UPDATE khachhang SET `enable` = '0' WHERE `khachhang`.`MaKhachHang` = '"+MaKH+"'";
        System.out.println(sql);
        if (mySQL.executeUpdate(sql)) return true;
        else return false;
    }
}
