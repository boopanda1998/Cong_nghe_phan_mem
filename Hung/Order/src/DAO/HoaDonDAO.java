/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConnectDB.DBConnect;
import DTO.HoaDonDTO;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Windows 10
 */
public class HoaDonDAO {
    
    public List<HoaDonDTO> getDSHoaDon(){
        List<HoaDonDTO> list = new ArrayList<HoaDonDTO>();
        
        Connection connect = DBConnect.getConnection();
        String sql = "SELECT * FROM hoadon";
       
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                HoaDonDTO hoadon = new HoaDonDTO();
                
                hoadon.setMahd(String.valueOf(rs.getInt("mahd")));
                hoadon.setMakh(rs.getString("makh"));
                hoadon.setManv(rs.getString("manv"));
                hoadon.setTongtien(rs.getString("tongtien"));
                hoadon.setNgayban(rs.getString("ngaynhap"));
                hoadon.setGhichu(rs.getString("ghichu"));
                
                list.add(hoadon);
            }        
            
            ps.close();
            connect.close();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    
    public  int insertHoaDon(HoaDonDTO hoadon){
        try {
            Connection connect = DBConnect.getConnection();
            String sql = "INSERT INTO hoadon(manv,makh,tongtien,ngaynhap,ghichu)"+"VALUE(?,?,?,?,?)";
            
            PreparedStatement ps = connect.prepareStatement(sql);
            
            ps.setString(1, hoadon.getManv());
            ps.setString(2, hoadon.getMakh());
            ps.setString(3, hoadon.getTongtien());
            ps.setString(4, hoadon.getNgayban());
            ps.setString(5, hoadon.getGhichu());
            
            int insert = ps.executeUpdate();
            
            if(insert!=0){
                System.out.println(insert +" hóa đơn đã thêm!");
            }else{
                System.out.println("Lỗi!! Kiểm tra lại dữ liệu!");
            }
            
            ps.close();
            connect.close();
            return insert;
            
        } catch (Exception e) {
        }
        return 0;
    }
    
    public int deleteHoaDon(int mahd){
        try {
            Connection connect = DBConnect.getConnection();
            String sql = "DELETE hoadon,chitiethoadon FROM hoadon INNER JOIN chitiethoadon ON chitiethoadon.mahd = hoadon.mahd WHERE hoadon.mahd=?";
            String sql2 = "DELETE FROM hoadon WHERE mahd=?";   
            PreparedStatement ps = connect.prepareStatement(sql);
            PreparedStatement ps2 = connect.prepareStatement(sql2);   
            ps.setInt(1, mahd);
            ps2.setInt(1, mahd);

            int deleted = ps.executeUpdate();
            
            if(deleted!=0){
                System.out.println(deleted +" hóa đơn đã xóa!");
                return deleted;
            }else{
                int deleted2 = ps2.executeUpdate();
                if(deleted2!=0){
                    System.out.println(deleted2 +" hóa đơn đã xóa!");
                    return deleted2;
                }else{
                    System.out.println("Lỗi!! Kiểm tra lại dữ liệu!");
                }
                ps2.close();
            }
            
            ps.close();
            connect.close();
            
            
        } catch (Exception e) {
        }
        return 0;
    }
    
    public int updateHoaDon(HoaDonDTO hoadon){
        
        try {
            Connection connect = DBConnect.getConnection();
            String sql = "UPDATE hoadon SET manv=?,makh=?,tongtien=?,ngaynhap=?,ghichu=? WHERE mahd=?";
            
            PreparedStatement ps = connect.prepareStatement(sql);
            
            ps.setString(1, hoadon.getManv());
            ps.setString(2, hoadon.getMakh());
            ps.setString(3, hoadon.getTongtien());
            ps.setString(4, hoadon.getNgayban());
            ps.setString(5, hoadon.getGhichu());
            ps.setInt(6, Integer.valueOf(hoadon.getMahd()));
            
            int update = ps.executeUpdate();
            if(update!=0){
                System.out.println(update +" hóa đơn đã sửa!");
            }else{
                System.out.println("Lỗi!! Kiểm tra lại dữ liệu!");
            }
 
            ps.close();
            connect.close();
            return update;
        } catch (SQLException ex) {
        
        }
        return 0;
    }
}
