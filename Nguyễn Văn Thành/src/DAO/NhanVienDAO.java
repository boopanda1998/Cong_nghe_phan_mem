/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Min-NvT
 */
import DTO.NhanVienDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 
public class NhanVienDAO{ 
    public static ArrayList<NhanVienDTO> getList() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM nhanvien WHERE trangthai=1";
        ArrayList<NhanVienDTO> list = new ArrayList<>();
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
                nhanVienDTO.setSdt(rs.getString("sdt"));
                nhanVienDTO.setTrangthai(rs.getString("trangthai"));
                list.add(nhanVienDTO);
            }
            ps.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static int Delete (NhanVienDTO nhanVienDTO){
        try {
            Connection cons = DBConnect.getConnection();
           String sql="UPDATE nhanvien SET ho=?,ten=?,gioitinh=?,ngaysinh=?,diachi=?,sdt=?,trangthai=0 WHERE manv=?";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(7, nhanVienDTO.getManv());
            ps.setString(1, nhanVienDTO.getHo());
            ps.setString(2, nhanVienDTO.getTen());
            ps.setString(3, nhanVienDTO.getGioitinh());
            ps.setString(4, nhanVienDTO.getNgaysinh());
            ps.setString(5, nhanVienDTO.getDiachi());
            ps.setString(6, nhanVienDTO.getSdt());
            int update = ps.executeUpdate();
            System.out.println((update!=0)? (update + " customers updated") : " xóa lỗi!NVDAO");
            ps.close();
            cons.close();
            return update;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    
            
 
  public static int  Insert(NhanVienDTO nhanVienDTO){
      try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO nhanvien(manv, ho, ten, gioitinh, ngaysinh, diachi, sdt,trangthai) "
                    + "VALUES ( ?, ?, ?, ?, ?, ?, ?, 1)";
            PreparedStatement ps = cons.prepareStatement(sql); 
            System.out.println("kiem tra ma nhan vien" +nhanVienDTO.getManv());
            ps.setString(1, nhanVienDTO.getManv());
            ps.setString(2, nhanVienDTO.getHo());
            ps.setString(3, nhanVienDTO.getTen());
            ps.setString(4, nhanVienDTO.getGioitinh());
            ps.setString(5, nhanVienDTO.getNgaysinh());
            ps.setString(6, nhanVienDTO.getDiachi());
            ps.setString(7, nhanVienDTO.getSdt());
            int insert = ps.executeUpdate();
            System.out.println((insert!=0)? (insert + " customers insert") : " Thêm nhân viên lỗi!NVDAO"); 
            ps.close();
            cons.close();
            return insert;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
   public static int Update(NhanVienDTO nhanVienDTO){
        try {
            Connection cons = DBConnect.getConnection();
           String sql="UPDATE nhanvien SET ho=?,ten=?,gioitinh=?,ngaysinh=?,diachi=?,sdt=? WHERE manv=?";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(7, nhanVienDTO.getManv());
            ps.setString(1, nhanVienDTO.getHo());
            ps.setString(2, nhanVienDTO.getTen());
            ps.setString(3, nhanVienDTO.getGioitinh());
            ps.setString(4, nhanVienDTO.getNgaysinh());
            ps.setString(5, nhanVienDTO.getDiachi());
            ps.setString(6, nhanVienDTO.getSdt());
            int update = ps.executeUpdate();
            System.out.println((update!=0)? (update + " customers updated") : " Sửa lỗi!NVDAO");
            ps.close();
            cons.close();
            return update;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}