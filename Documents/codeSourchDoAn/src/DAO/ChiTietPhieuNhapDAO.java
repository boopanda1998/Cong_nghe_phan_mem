/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChiTietPhieuNhapDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author boopa
 */
public class ChiTietPhieuNhapDAO {
       
    public static ArrayList<ChiTietPhieuNhapDTO> getList() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM chitietphieunhap";
        ArrayList<ChiTietPhieuNhapDTO> list = new ArrayList<ChiTietPhieuNhapDTO>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietPhieuNhapDTO chiTietPhieuNhapDTO = new ChiTietPhieuNhapDTO();
                
                chiTietPhieuNhapDTO.setMapn(rs.getString("mapn"));
                chiTietPhieuNhapDTO.setMahang(rs.getString("mahang"));
                chiTietPhieuNhapDTO.setMaloai(rs.getString("maloai"));
                chiTietPhieuNhapDTO.setMacl(rs.getString("macl"));
                chiTietPhieuNhapDTO.setSoluong(rs.getString("soluong"));
                chiTietPhieuNhapDTO.setDongia(rs.getString("dongia"));
                chiTietPhieuNhapDTO.setTongtien(rs.getString("tongtien"));
                
                list.add(chiTietPhieuNhapDTO);
            }
            
            ps.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    

  public static int  Insert(ChiTietPhieuNhapDTO chiTietPhieuNhapDTO){
      try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO chitietphieunhap(mapn, mahang, maloai, macl, soluong, dongia, tongtien) "
                    + "VALUES ( ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = cons.prepareStatement(sql);
            
            System.out.println("kiem tra ma ctpn da nhan du lieu tu GUI --" +chiTietPhieuNhapDTO.getMapn());
            ps.setString(1, chiTietPhieuNhapDTO.getMapn());
            ps.setString(2, chiTietPhieuNhapDTO.getMahang());
            ps.setString(3, chiTietPhieuNhapDTO.getMaloai());
            ps.setString(4, chiTietPhieuNhapDTO.getMacl());
            ps.setString(5, chiTietPhieuNhapDTO.getSoluong());
            ps.setString(6, chiTietPhieuNhapDTO.getDongia());
            ps.setString(7, chiTietPhieuNhapDTO.getTongtien());

            
            int insert = ps.executeUpdate();
            System.out.println((insert!=0)? (insert + " ct phieu nhap insert") : " insert Something wrong! Check the input values");
            
            ps.close();
            cons.close();
            return insert;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
  public static int Delete(ChiTietPhieuNhapDTO chiTietPhieuNhapDTO){
        try {
            Connection cons = DBConnect.getConnection();
            String sql ="DELETE FROM `chitietphieunhap` WHERE mapn=? and mahang=? and maloai=? and macl=?";
            
            PreparedStatement ps = cons.prepareStatement(sql);
            
            ps.setString(1, chiTietPhieuNhapDTO.getMapn());
            ps.setString(2, chiTietPhieuNhapDTO.getMahang());
            ps.setString(3, chiTietPhieuNhapDTO.getMaloai());
            ps.setString(4, chiTietPhieuNhapDTO.getMacl());
            
            int deleted = ps.executeUpdate();
            System.out.println((deleted!=0)? (deleted + " ct phieu nhap hang deleted") : " deleted Something wrong! Check the input values");
            
            ps.close();
            cons.close();
            return deleted;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

  public static int Update(ChiTietPhieuNhapDTO chiTietPhieuNhapDTO){
        try {
            Connection cons = DBConnect.getConnection();
            String sql="UPDATE chitietphieunhap SET soluong=?,dongia=?,tongtien=? WHERE mapn=? and mahang=? and maloai=? and macl=?";
            
            PreparedStatement ps = cons.prepareStatement(sql);
            
            ps.setString(1, chiTietPhieuNhapDTO.getSoluong());
            ps.setString(2, chiTietPhieuNhapDTO.getDongia());
            ps.setString(3, chiTietPhieuNhapDTO.getTongtien());
            
            ps.setString(4, chiTietPhieuNhapDTO.getMapn());
            ps.setString(5, chiTietPhieuNhapDTO.getMahang());
            ps.setString(6, chiTietPhieuNhapDTO.getMaloai());
            ps.setString(7, chiTietPhieuNhapDTO.getMacl());
            
            
            int update = ps.executeUpdate();
            System.out.println((update!=0)? (update + " chitiet phieunhap updated") : " updatedSomething wrong! Check the input values");
            
            ps.close();
            cons.close();
            return update;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}