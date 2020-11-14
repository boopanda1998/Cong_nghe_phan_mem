/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NhanVienDTO;
import DTO.TaiKhoanDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author boopa
 */
public class TaiKhoanDAO {
    public static TaiKhoanDTO login(String tenDangNhap, String matKhau) {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM taikhoan WHERE tendangnhap LIKE ? AND matkhau LIKE ?";
        TaiKhoanDTO taiKhoanDTO = null;
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ps.setString(1, tenDangNhap);
            ps.setString(2, matKhau);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                taiKhoanDTO = new TaiKhoanDTO();
                taiKhoanDTO.setMataikhoan(rs.getString("mataikhoan"));
                taiKhoanDTO.setTendangnhap(rs.getString("tendangnhap"));
                taiKhoanDTO.setMatkhau(rs.getString("matkhau"));
                
            }
            ps.close();
            cons.close();
            return taiKhoanDTO;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
      public static int  Insert(TaiKhoanDTO taiKhoanDTO){
      try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO taikhoan(mataikhoan,tendangnhap,matkhau) "
                    + "VALUES ( ?, ?, ?)";
            
            PreparedStatement ps = cons.prepareStatement(sql);
            
            System.out.println("kiem tra tai khoang da nhan du lieu tu GUI --" +taiKhoanDTO.getMataikhoan());
            ps.setString(1, taiKhoanDTO.getMataikhoan());
            ps.setString(2, taiKhoanDTO.getTendangnhap());
            ps.setString(3, taiKhoanDTO.getMatkhau());

            ps.execute();
            
            int insert = ps.executeUpdate();
            System.out.println((insert!=0)? (insert + " taiKhoanDTO insert") : " insert Something wrong! Check the input values");
            
            ps.close();
            cons.close();
            return insert;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
 
}
