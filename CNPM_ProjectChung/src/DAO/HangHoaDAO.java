/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class HangHoaDAO {
    public static ArrayList<HangHoaDTO> getList() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM hanghoa";
        ArrayList<HangHoaDTO> list = new ArrayList<HangHoaDTO>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HangHoaDTO HangHoaDTO = new HangHoaDTO();
                HangHoaDTO.setMaHang(rs.getString("MaH"));
                HangHoaDTO.setMaCL(rs.getString("MaCl"));
                HangHoaDTO.setTenHang(rs.getString("TenHang"));
                HangHoaDTO.setSoLuong(rs.getString("SoLuong"));
                HangHoaDTO.setDonGia(rs.getString("DonGia"));    
                HangHoaDTO.setGhiChu(rs.getString("Ghichu"));    
                list.add(HangHoaDTO);
            }
            
            ps.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    
  public static int  Insert(HangHoaDTO HangHoaDTO){
      try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO hanghoa(MaH,MaCl,TenHang,SoLuong,DonGia,GhiChu) "
                    + "VALUES ( ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = cons.prepareStatement(sql);
            
            System.out.println("HangHoa Dao:kiem tra ma hang hoa da nhan du lieu tu GUI --" +HangHoaDTO.getMaHang());
            ps.setString(1, HangHoaDTO.getMaHang());
            ps.setString(2, HangHoaDTO.getMaCL());
            ps.setString(3, HangHoaDTO.getTenHang());
            ps.setString(4, HangHoaDTO.getSoLuong());
            ps.setString(5, HangHoaDTO.getDonGia());
            ps.setString(6, HangHoaDTO.getGhiChu());
           
            
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
  public static int Delete (String maHang){
        try {
            Connection cons = DBConnect.getConnection();
            String sql ="DELETE FROM hanghoa WHERE maH=?";
            
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, maHang);
            
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

  public static int Update(HangHoaDTO HangHoaDTO){
        try {
            Connection cons = DBConnect.getConnection();
            String sql="UPDATE hanghoa SET TenHang=?,DonGia=?,GhiChu=? WHERE MaH=?";
            
            PreparedStatement ps = cons.prepareStatement(sql);
            
            ps.setString(1, HangHoaDTO.getTenHang());
            ps.setString(2, HangHoaDTO.getDonGia());
            ps.setString(3, HangHoaDTO.getGhiChu());
            ps.setString(4, HangHoaDTO.getMaHang());
            
            
            
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
