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
import DTO.NhanVienDTO;

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
 
public class NhanVienDAO{


 
    
    public static ArrayList<NhanVienDTO> getList() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM nhanvien";
        ArrayList<NhanVienDTO> list = new ArrayList<NhanVienDTO>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVienDTO nhanVienDTO = new NhanVienDTO();
                nhanVienDTO.setManv(rs.getString("manv"));
                nhanVienDTO.setHo(rs.getString("ho"));
                nhanVienDTO.setTen(rs.getString("ten"));
                nhanVienDTO.setGioitinh(rs.getString("gioitinh"));
                nhanVienDTO.setNgaysinh(rs.getString("ngaysinh"));
                nhanVienDTO.setDiachi(rs.getString("diachi"));
                nhanVienDTO.setLuong(rs.getString("luong"));
                nhanVienDTO.setChucvu(rs.getString("chucvu"));
                
                list.add(nhanVienDTO);
            }
            
            ps.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    

  public static int  Insert(NhanVienDTO nhanVienDTO){
      try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO nhanvien(manv, ho, ten, gioitinh, ngaysinh, chucvu, luong, diachi) "
                    + "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = cons.prepareStatement(sql);
            
            System.out.println("kiem tra ma nhan vien da nhan du lieu tu GUI --" +nhanVienDTO.getManv());
            ps.setString(1, nhanVienDTO.getManv());
            ps.setString(2, nhanVienDTO.getHo());
            ps.setString(3, nhanVienDTO.getTen());
            ps.setString(4, nhanVienDTO.getGioitinh());
            ps.setString(5, nhanVienDTO.getNgaysinh());
            ps.setString(6, nhanVienDTO.getChucvu());
            ps.setString(7, nhanVienDTO.getLuong());
            ps.setString(8, nhanVienDTO.getDiachi());
            
            
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
  public static int Delete (String manv){
        try {
            Connection cons = DBConnect.getConnection();
            String sql ="DELETE FROM `nhanvien` WHERE manv=?";
            
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, manv);
            
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

  public static int Update(NhanVienDTO nhanVienDTO){
        try {
            Connection cons = DBConnect.getConnection();
            String sql="UPDATE nhanvien SET ho=?,ten=?,gioitinh=?,ngaysinh=?,chucvu=?,luong=?,diachi=? WHERE manv=?";
            
            PreparedStatement ps = cons.prepareStatement(sql);
            
            
            ps.setString(8, nhanVienDTO.getManv());
            ps.setString(1, nhanVienDTO.getHo());
            ps.setString(2, nhanVienDTO.getTen());
            ps.setString(3, nhanVienDTO.getGioitinh());
            ps.setString(4, nhanVienDTO.getNgaysinh());
            ps.setString(5, nhanVienDTO.getChucvu());
            ps.setString(6, nhanVienDTO.getLuong());
            ps.setString(7, nhanVienDTO.getDiachi());
            
            
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