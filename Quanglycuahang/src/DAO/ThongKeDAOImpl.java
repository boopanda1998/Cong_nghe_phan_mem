/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.KhachHangBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class ThongKeDAOImpl implements ThongKeDAO {
 
    public List<KhachHangBean> getListByKhachHang() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT gioitinh, COUNT(*) as so_luong FROM khachhang  GROUP BY gioitinh;";
        List<KhachHangBean> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHangBean khachhangBean = new KhachHangBean();
                khachhangBean.setGioitinh(rs.getString("gioitinh"));
                khachhangBean.setSo_luong_hoc_vien(rs.getInt("so_luong"));
                list.add(khachhangBean);
            }
            ps.close();
            cons.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
       
    
}
