/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConnectDB.DBConnect;
import DTO.ChiTietHoaDonDTO;
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
public class ChiTietHoaDonDAO {
    public List<ChiTietHoaDonDTO> getDSChiTiet(int mahd){
        List<ChiTietHoaDonDTO> listCTHD = new ArrayList<ChiTietHoaDonDTO>();
        
        Connection connect = DBConnect.getConnection();
        String sql = "SELECT * FROM chitiethoadon WHERE mahd=?";
       
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
             ps.setInt(1,mahd );
            ResultSet rs = ps.executeQuery();
           
            while(rs.next()){
                ChiTietHoaDonDTO CTHD = new ChiTietHoaDonDTO();
                
                CTHD.setMacthd(rs.getInt("macthd"));
                CTHD.setMahd(String.valueOf(rs.getInt("mahd")));
                CTHD.setMasp(rs.getString("masp"));
                CTHD.setMaloai(rs.getString("maloai"));
                CTHD.setMacl(rs.getString("macl"));
                CTHD.setSoluong(String.valueOf(rs.getInt("soluong")));
                CTHD.setDongia(rs.getString("dongia"));    
                //Tinh thanh tien cua tung sp
                int sl = rs.getInt("soluong");
                int dongia = Integer.parseInt(rs.getString("dongia"));
                String tong = String.valueOf(sl*dongia);
                
                CTHD.setTongtien(tong);
                
                listCTHD.add(CTHD);
            }        
            
            ps.close();
            connect.close();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listCTHD;
    }
    
    public int getTong(int mahd){
        
        Connection connect = DBConnect.getConnection();
        String sql = "SELECT soluong,dongia,soluong*dongia AS amount FROM chitiethoadon WHERE mahd=?";
        String sql2 = "UPDATE hoadon SET tongtien=? WHERE mahd=?";
        
       
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            
            
            ps.setInt(1,mahd );
            ResultSet rs = ps.executeQuery();
            int tong = 0;
            while(rs.next()){
                ChiTietHoaDonDTO CTHD = new ChiTietHoaDonDTO();
           
                CTHD.setTongtien(rs.getString("amount"));
                int amount = Integer.parseInt(rs.getString("amount"));
                tong= tong+amount;
                
            }        
            ps.close();
            
            PreparedStatement ps2 = connect.prepareStatement(sql2);
            HoaDonDTO hoadon = new HoaDonDTO();
            hoadon.setTongtien(String.valueOf(tong));
            ps2.setString(1, hoadon.getTongtien());
            ps2.setInt(2, mahd);
            int update = ps2.executeUpdate();
            if(update!=0){
                System.out.println("Tổng tiền đã update!");
            }else{
                System.out.println("Lỗi!! Kiểm tra lại dữ liệu!");
            }
 
            ps2.close();

            connect.close();
        }catch(SQLException e){
            e.printStackTrace();
        }          
            
        return 0;
    }
    
    
    public int insertChiTietHoaDon(ChiTietHoaDonDTO CTHD){
        try {
            Connection connect = DBConnect.getConnection();
            String sql = "INSERT INTO chitiethoadon(mahd,masp,maloai,macl,soluong,dongia)"+"VALUE(?,?,?,?,?,?)";
            
            PreparedStatement ps = connect.prepareStatement(sql);
            
            ps.setString(1, CTHD.getMahd());
            ps.setString(2, CTHD.getMasp());
            ps.setString(3, CTHD.getMaloai());
            ps.setString(4, CTHD.getMacl());
            ps.setInt(5, Integer.parseInt(CTHD.getSoluong()));
            ps.setString(6, CTHD.getDongia());
            
            int insert = ps.executeUpdate();
            
            if(insert!=0){
                System.out.println(insert +" sản phẩm đã thêm!");
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
    
    public int deleteChiTietHoaDon(int macthd){
        try {
            Connection connect = DBConnect.getConnection();
            String sql = "DELETE FROM chitiethoadon WHERE macthd=?";
            
            PreparedStatement ps = connect.prepareStatement(sql);
     
            ps.setInt(1, macthd);
          
            int deleted = ps.executeUpdate();
            
            if(deleted!=0){
                System.out.println(deleted +" sản phẩm đã xóa!");
            }else{
                System.out.println("Lỗi!! Kiểm tra lại dữ liệu!");
            }
            
            ps.close();
            connect.close();
            return deleted;
            
        } catch (Exception e) {
        }
        return 0;
    }

    public int updateChiTietHoaDon(ChiTietHoaDonDTO sanpham){
        
        try {
            Connection connect = DBConnect.getConnection();
            String sql = "UPDATE chitiethoadon SET masp=?,maloai=?,macl=?,soluong=?,dongia=? WHERE macthd=?";
            
            PreparedStatement ps = connect.prepareStatement(sql);
            
            ps.setString(1, sanpham.getMasp());
            ps.setString(2, sanpham.getMaloai());
            ps.setString(3, sanpham.getMacl());
            ps.setString(4, sanpham.getSoluong());
            ps.setString(5, sanpham.getDongia());
            ps.setInt(6, sanpham.getMacthd());
            
            int update = ps.executeUpdate();
            if(update!=0){
                System.out.println(update +" sản phẩm đã sửa!");
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
