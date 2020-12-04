/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChiTietHoaDonDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author boopa
 */
public class ChiTietHoaDonDAO {
       
    public static ArrayList<ChiTietHoaDonDTO> getList() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM chitiethoadon";
        ArrayList<ChiTietHoaDonDTO> list = new ArrayList<ChiTietHoaDonDTO>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietHoaDonDTO chiTietHoaDonDTO = new ChiTietHoaDonDTO();
                
                chiTietHoaDonDTO.setMahd(rs.getString("mahd"));
                chiTietHoaDonDTO.setMahang(rs.getString("mahang"));
                chiTietHoaDonDTO.setMaloai(rs.getString("maloai"));
                chiTietHoaDonDTO.setMacl(rs.getString("macl"));
                chiTietHoaDonDTO.setSoluong(rs.getString("soluong"));
                chiTietHoaDonDTO.setDongia(rs.getString("dongia"));
                chiTietHoaDonDTO.setTongtien(rs.getString("tongtien"));
                
                list.add(chiTietHoaDonDTO);
            }
            
            ps.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    

  public static int  Insert(ChiTietHoaDonDTO chiTietHoaDonDTO){
      try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO chitiethoadon(mahd, mahang, maloai, macl, soluong, dongia, tongtien) "
                    + "VALUES ( ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = cons.prepareStatement(sql);
            
            System.out.println("kiem tra ma ctpn da nhan du lieu tu GUI --" +chiTietHoaDonDTO.getMahd());
            ps.setString(1, chiTietHoaDonDTO.getMahd());
            ps.setString(2, chiTietHoaDonDTO.getMahang());
            ps.setString(3, chiTietHoaDonDTO.getMaloai());
            ps.setString(4, chiTietHoaDonDTO.getMacl());
            ps.setString(5, chiTietHoaDonDTO.getSoluong());
            ps.setString(6, chiTietHoaDonDTO.getDongia());
            ps.setString(7, chiTietHoaDonDTO.getTongtien());

            
            int insert = ps.executeUpdate();
            System.out.println((insert!=0)? (insert + " chitiethoadon insert") : " insert Something wrong! Check the input values");
            
            ps.close();
            cons.close();
            return insert;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
  public static int Delete(ChiTietHoaDonDTO chiTietHoaDonDTO){
        try {
            Connection cons = DBConnect.getConnection();
            String sql ="DELETE FROM `chitiethoadon` WHERE mahd=? and mahang=? and maloai=? and macl=?";
            
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, chiTietHoaDonDTO.getMahd());
            ps.setString(2, chiTietHoaDonDTO.getMahang());
            ps.setString(3, chiTietHoaDonDTO.getMaloai());
            ps.setString(4, chiTietHoaDonDTO.getMacl());
            
            int deleted = ps.executeUpdate();
            System.out.println((deleted!=0)? (deleted + " chitiethoadon deleted") : " deleted Something wrong! Check the input values");
            
            ps.close();
            cons.close();
            return deleted;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

  public static int Update(ChiTietHoaDonDTO chiTietHoaDonDTO){
        try {
            Connection cons = DBConnect.getConnection();
            String sql="UPDATE chitiethoadon SET soluong=?,dongia=?,tongtien=? WHERE mahd=? and mahang=? and maloai=? and macl=?";
            
            PreparedStatement ps = cons.prepareStatement(sql);
            
            ps.setString(1, chiTietHoaDonDTO.getSoluong());
            ps.setString(2, chiTietHoaDonDTO.getDongia());
            ps.setString(3, chiTietHoaDonDTO.getTongtien());
            ps.setString(4, chiTietHoaDonDTO.getMahd());
            ps.setString(5, chiTietHoaDonDTO.getMahang());
            ps.setString(6, chiTietHoaDonDTO.getMaloai());
            ps.setString(7, chiTietHoaDonDTO.getMacl());
            
            
            int update = ps.executeUpdate();
            System.out.println((update!=0)? (update + " chitiethoadon  updated") : " updatedSomething wrong! Check the input values");
            
            ps.close();
            cons.close();
            return update;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}