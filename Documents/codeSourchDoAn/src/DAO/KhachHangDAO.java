/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.KhachHangDTO;

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
 * @author huynh
 */
public class KhachHangDAO {
    
   public static ArrayList<KhachHangDTO> getList() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM khachhang";
        ArrayList<KhachHangDTO> list = new ArrayList<KhachHangDTO>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHangDTO khachhangDTO = new KhachHangDTO();
                khachhangDTO.setMakh(rs.getString("makh"));
                khachhangDTO.setHo(rs.getString("ho"));
                khachhangDTO.setTen(rs.getString("ten"));
                khachhangDTO.setSodt(rs.getString("sodt"));
                //khachhangDTO.setDiachi(rs.getString("diachi"));
                khachhangDTO.setNgaysinh(rs.getString("ngaysinh"));
                khachhangDTO.setGioitinh(rs.getString("gioitinh"));

                
                list.add(khachhangDTO);
            }
            
            ps.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    

  public static int  Insert(KhachHangDTO khachhangDTO){
      try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO khachhang(makh, ho, ten, sodt, ngaysinh, gioitinh) "
                    + "VALUES ( ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = cons.prepareStatement(sql);
            
            System.out.println("kiem tra ma khach hang da nhan du lieu tu GUI --" +khachhangDTO.getMakh());
            ps.setString(1, khachhangDTO.getMakh());
            ps.setString(2, khachhangDTO.getHo());
            ps.setString(3, khachhangDTO.getTen());
            ps.setString(4, khachhangDTO.getSodt());
            //ps.setString(5, khachhangDTO.getDiachi());
            ps.setString(5, khachhangDTO.getNgaysinh());
            ps.setString(6, khachhangDTO.getGioitinh());
            ps.execute();
            
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
  public static int Delete (String makh){
        try {
            Connection cons = DBConnect.getConnection();
            String sql ="DELETE FROM `khachhang` WHERE makh=?";
            
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, makh);
            
            int deleted = ps.executeUpdate();
            System.out.println((deleted!=0)? (deleted + " customers deleted") : " deleted Something wrong! Check the input values");
            
            ps.close();
            cons.close();
            return deleted;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

  public static int Update(KhachHangDTO khachhangDTO){
        try {
            Connection cons = DBConnect.getConnection();
            String sql="UPDATE khachhang SET ho=?,ten=?,sodt=?,ngaysinh=?,gioitinh=? WHERE makh=?";
            
            PreparedStatement ps = cons.prepareStatement(sql);
            
            
            ps.setString(6, khachhangDTO.getMakh());
            ps.setString(1, khachhangDTO.getHo());
            ps.setString(2, khachhangDTO.getTen());
            ps.setString(3, khachhangDTO.getSodt());
            //ps.setString(4, khachhangDTO.getDiachi());
            ps.setString(4, khachhangDTO.getNgaysinh());
            ps.setString(5, khachhangDTO.getGioitinh());

            
            
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
