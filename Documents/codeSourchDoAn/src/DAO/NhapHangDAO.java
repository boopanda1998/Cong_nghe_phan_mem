/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NhapHangDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author boopa
 */
public class NhapHangDAO {
       
    public static ArrayList<NhapHangDTO> getList() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM nhaphang";
        ArrayList<NhapHangDTO> list = new ArrayList<NhapHangDTO>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhapHangDTO nhapHangDTO = new NhapHangDTO();
                
                nhapHangDTO.setMancc(rs.getString("mancc"));
                nhapHangDTO.setManv(rs.getString("manv"));
                nhapHangDTO.setMapn(rs.getString("mapn"));
                nhapHangDTO.setTongtien(rs.getString("tongtien"));
                nhapHangDTO.setNgaynhap(rs.getString("ngaynhap"));
                nhapHangDTO.setGhichu(rs.getString("ghichu"));
                nhapHangDTO.setInhoadon(rs.getString("inhoadon"));
                
                list.add(nhapHangDTO);
            }
            
            ps.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    

  public static int  Insert(NhapHangDTO nhapHangDTO){
      try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO nhaphang(mancc, manv, mapn, tongtien, ngaynhap, ghichu,inhoadon) "
                    + "VALUES ( ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = cons.prepareStatement(sql);
            
            System.out.println("kiem tra ma pn da nhan du lieu tu GUI --" +nhapHangDTO.getMapn());
            System.out.println("Kiem Tra tong tien --" +nhapHangDTO.getTongtien());
            ps.setString(1, nhapHangDTO.getMancc());
            ps.setString(2, nhapHangDTO.getManv());
            ps.setString(3, nhapHangDTO.getMapn());
            ps.setString(4, nhapHangDTO.getTongtien());
            ps.setString(5, nhapHangDTO.getNgaynhap());
            ps.setString(6, nhapHangDTO.getGhichu());
            ps.setString(7, nhapHangDTO.getInhoadon());

            
            int insert = ps.executeUpdate();
            System.out.println((insert!=0)? (insert + " phieu nhap insert") : " insert Something wrong! Check the input values");
            
            ps.close();
            cons.close();
            return insert;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
  public static int Delete (String mapn){
        try {
            Connection cons = DBConnect.getConnection();
            String sql ="DELETE FROM `nhaphang` WHERE mapn=?";
            
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, mapn);
            
            int deleted = ps.executeUpdate();
            System.out.println((deleted!=0)? (deleted + " phieu nhap hang deleted") : " deleted Something wrong! Check the input values");
            
            ps.close();
            cons.close();
            return deleted;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

  public static int Update(NhapHangDTO nhapHangDTO){
        try {
            Connection cons = DBConnect.getConnection();
            String sql="UPDATE nhaphang SET mancc=?,manv=?,tongtien=?,ngaynhap=?,ghichu=?,inhoadon=? WHERE mapn=?";
            
            PreparedStatement ps = cons.prepareStatement(sql);
            
            
            ps.setString(1, nhapHangDTO.getMancc());
            ps.setString(2, nhapHangDTO.getManv());
            ps.setString(3, nhapHangDTO.getTongtien());
            ps.setString(4, nhapHangDTO.getNgaynhap());System.out.println("----------------"+nhapHangDTO.getNgaynhap());
            ps.setString(5, nhapHangDTO.getGhichu());
            ps.setString(6, nhapHangDTO.getInhoadon());System.out.println("----------------"+nhapHangDTO.getInhoadon());
            ps.setString(7, nhapHangDTO.getMapn());System.out.println("----------------"+nhapHangDTO.getMapn());
            
            
            int update = ps.executeUpdate();
            System.out.println((update!=0)? (update + " phieunhap updated") : " updatedSomething wrong! Check the input values");
            
            ps.close();
            cons.close();
            return update;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}


