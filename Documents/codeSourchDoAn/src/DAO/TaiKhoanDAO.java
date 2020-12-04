/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.TaiKhoanDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.time.Clock.system;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.DropMode.INSERT;
/**
 *
 * @author PC
 */
public class TaiKhoanDAO {
    
    public static ArrayList<TaiKhoanDTO> getList() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM taikhoan";
        ArrayList<TaiKhoanDTO> list = new ArrayList<TaiKhoanDTO>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TaiKhoanDTO taiKhoanDTO = new TaiKhoanDTO();
                taiKhoanDTO.setManv(rs.getString("manv"));
                taiKhoanDTO.setTaikhoan(rs.getString("taikhoan"));
                taiKhoanDTO.setMatkhau(rs.getString("matkhau"));
                taiKhoanDTO.setPhanquyen(rs.getString("phanquyen"));    
                taiKhoanDTO.setTrangthai(rs.getString("trangthai"));    
                list.add(taiKhoanDTO);
            }
            
            ps.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    

  public static int  Insert(TaiKhoanDTO taiKhoanDTO){
      try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO taikhoan(manv, taikhoan, matkhau, phanquyen,trangthai) "
                    + "VALUES ( ?, ?, ?, ?,?)";
            
            PreparedStatement ps = cons.prepareStatement(sql);
            
            System.out.println("kiem tra ma chat lieu da nhan du lieu tu GUI --" +taiKhoanDTO.getManv());
            ps.setString(1, taiKhoanDTO.getManv());
            ps.setString(2, taiKhoanDTO.getTaikhoan());
            ps.setString(3, taiKhoanDTO.getMatkhau());
            ps.setString(4, taiKhoanDTO.getPhanquyen());
            ps.setString(5, taiKhoanDTO.getTrangthai());
           
            
            int insert = ps.executeUpdate();
            System.out.println((insert!=0)? (insert + " customers insert") : " insert Something wrong! Check the input values");
            
            ps.close();
            cons.close();
            return insert;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

  //
  public static int Update(TaiKhoanDTO taiKhoanDTO){
        try {
            Connection cons = DBConnect.getConnection();
            String sql="UPDATE taikhoan SET manv=?,matkhau=?,phanquyen=?,trangthai=? WHERE taikhoan=?";
            
            PreparedStatement ps = cons.prepareStatement(sql);
            
            
            ps.setString(1, taiKhoanDTO.getManv());
            ps.setString(2, taiKhoanDTO.getMatkhau());
            ps.setString(3, taiKhoanDTO.getPhanquyen());
            ps.setString(4, taiKhoanDTO.getTrangthai());
            
            ps.setString(5, taiKhoanDTO.getTaikhoan());
                        System.out.println(taiKhoanDTO.getTaikhoan());

            ;
            
            
            
            int update = ps.executeUpdate();
            System.out.println((update!=0)? (update + " customers updated") : " updatedSomething wrong! Check the input values");
            
            ps.close();
            cons.close();
            return update;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

}
