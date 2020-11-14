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
import DTO.GiamGiaDTO;

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
 
public class GiamGiaDAO{


 
    
    public static ArrayList<GiamGiaDTO> getList() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM giamgia";
        ArrayList<GiamGiaDTO> list = new ArrayList<GiamGiaDTO>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GiamGiaDTO giamgiaDTO = new GiamGiaDTO();
                giamgiaDTO.setMagg(rs.getString("magg"));
                giamgiaDTO.setLoaigg(rs.getString("loaigg"));
                giamgiaDTO.setThongtingg(rs.getString("thongtingg"));
                giamgiaDTO.setThoigiangg(rs.getString("thoigiangg"));
               
                list.add(giamgiaDTO);
            }
            
            ps.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    

  public static int  Insert(GiamGiaDTO giamgiaDTO){
      try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO giamgia(magg, loaigg, thongtingg, thoigiangg) "
                    + "VALUES ( ?, ?, ?, ?)";
            
            PreparedStatement ps = cons.prepareStatement(sql);
            
            System.out.println("kiem tra ma giam gia da nhan du lieu tu GUI --" +giamgiaDTO.getMagg());
            ps.setString(1, giamgiaDTO.getMagg());
            ps.setString(2, giamgiaDTO.getLoaigg());
            ps.setString(3, giamgiaDTO.getThongtingg());
            ps.setString(4, giamgiaDTO.getThoigiangg());
           
            
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
  public static int Delete (String magg){
        try {
            Connection cons = DBConnect.getConnection();
            String sql ="DELETE FROM `giamgia` WHERE magg=?";
            
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, magg);
            
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

  public static int Update(GiamGiaDTO giamgiaDTO){
        try {
            Connection cons = DBConnect.getConnection();
            String sql="UPDATE giamgia SET loaigg=?,thongtingg=?,thoigiangg=? WHERE magg=?";
            
            PreparedStatement ps = cons.prepareStatement(sql);
            
            
            ps.setString(4, giamgiaDTO.getMagg());
            ps.setString(1, giamgiaDTO.getLoaigg());
            ps.setString(2, giamgiaDTO.getThongtingg());
            ps.setString(3, giamgiaDTO.getThoigiangg());
           
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