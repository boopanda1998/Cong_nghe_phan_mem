/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.HoaDonDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author boopa
 */
public class HoaDonDAO {
       
    public static ArrayList<HoaDonDTO> getList() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM hoadon";
        ArrayList<HoaDonDTO> list = new ArrayList<HoaDonDTO>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonDTO hoaDonDTO = new HoaDonDTO();
                
                hoaDonDTO.setMakh(rs.getString("makh"));
                hoaDonDTO.setManv(rs.getString("manv"));
                hoaDonDTO.setMahd(rs.getString("mahd"));
                hoaDonDTO.setTongtien(rs.getString("tongtien"));
                hoaDonDTO.setNgayban(rs.getString("ngayban"));
                hoaDonDTO.setGhichu(rs.getString("ghichu"));
                list.add(hoaDonDTO);
            }
            
            ps.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    

  public static int  Insert(HoaDonDTO hoaDonDTO){
      try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO hoadon(makh, manv, mahd, tongtien, ngayban, ghichu) "
                    + "VALUES ( ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = cons.prepareStatement(sql);
            
            System.out.println("kiem tra ma pn da nhan du lieu tu GUI --" +hoaDonDTO.getMahd());
            System.out.println("Kiem Tra tong tien --" +hoaDonDTO.getTongtien());
            ps.setString(1, hoaDonDTO.getMakh());
            ps.setString(2, hoaDonDTO.getManv());
            ps.setString(3, hoaDonDTO.getMahd());
            ps.setString(4, hoaDonDTO.getTongtien());
            ps.setString(5, hoaDonDTO.getNgayban());
            ps.setString(6, hoaDonDTO.getGhichu());

            
            int insert = ps.executeUpdate();
            System.out.println((insert!=0)? (insert + " hoadon insert") : " insert Something wrong! Check the input values");
            
            ps.close();
            cons.close();
            return insert;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
  public static int Delete (String mahd){
        try {
            Connection cons = DBConnect.getConnection();
            String sql ="DELETE FROM `hoadon` WHERE mahd=?";
            
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, mahd);
            
            int deleted = ps.executeUpdate();
            System.out.println((deleted!=0)? (deleted + " hoa don hang deleted") : " deleted Something wrong! Check the input values");
            
            ps.close();
            cons.close();
            return deleted;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

  public static int Update(HoaDonDTO hoaDonDTO){
        try {
            Connection cons = DBConnect.getConnection();
            String sql="UPDATE hoadon SET makh=?,manv=?,tongtien=?,ngayban=?,ghichu=? WHERE mahd=?";
            
            PreparedStatement ps = cons.prepareStatement(sql);
            
            
            ps.setString(1, hoaDonDTO.getMakh());
            ps.setString(2, hoaDonDTO.getManv());
            ps.setString(3, hoaDonDTO.getTongtien());
            ps.setString(4, hoaDonDTO.getNgayban());System.out.println("----------------"+hoaDonDTO.getNgayban());
            ps.setString(5, hoaDonDTO.getGhichu());
            ps.setString(6, hoaDonDTO.getMahd());
            
            int update = ps.executeUpdate();
            System.out.println((update!=0)? (update + " hoa don updated") : " updatedSomething wrong! Check the input values");
            
            ps.close();
            cons.close();
            return update;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}


