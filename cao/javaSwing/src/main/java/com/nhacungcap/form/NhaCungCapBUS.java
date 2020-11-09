package com.nhacungcap.form;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NhaCungCapBUS {
    public static List<NhaCungCapDTO> layDanhSach() {
        //Khai báo 1 danh sách
        List<NhaCungCapDTO> lstNhaCungCap = new ArrayList();

        //Khai báo kết nối
        Connection conn = null;
        try {

            conn =DBConnect.getConnection();

            //Khai báo 1 công việc
            String strSQL = "Select ma_nha_cung_cap, ten_nha_cung_cap, dia_chi_nha_cung_cap, sdt_nha_cung_cap"
                    + " from nhacungcap";

            Statement comm = conn.createStatement();

            //Thực hiện và trả về kết quả
            ResultSet rs = comm.executeQuery(strSQL);

            //Khai báo đối tượng
            NhaCungCapDTO objNhaCungCap = null;
            //Đọc từng dòng thông tin
            while (rs.next()) {
                //Khởi tạo đối tượng
                objNhaCungCap = new NhaCungCapDTO();
                //Gán giá trị cho các thuộc tính
                objNhaCungCap.setStrMaNhaCungCap(rs.getString("ma_nha_cung_cap"));
                objNhaCungCap.setStrTenNhaCungCap(rs.getString("ten_nha_cung_cap"));
                objNhaCungCap.setStrDiaChiNhaCungCap(rs.getString("dia_chi_nha_cung_cap"));
                objNhaCungCap.setStrSdtNhaCungCap(rs.getString("sdt_nha_cung_cap"));
                //Thêm vào danh sách
                lstNhaCungCap.add(objNhaCungCap);
            }

        } catch (SQLException ex) {
            System.out.println("Có lỗi xảy ra trong quá trình làm việc với mysql. "
                    + "Chi tiết: " + ex.getMessage());
        } finally {
            try {
                //Đóng kết nối
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhaCungCapBUS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lstNhaCungCap;
    }
    public static List<NhaCungCapDTO> layDanhSachTheoDieuKien(String dieukien,String giatri) {
        //Khai báo 1 danh sách
        List<NhaCungCapDTO> lstNhaCungCap = new ArrayList();

        //Khai báo kết nối
        Connection conn = null;
        try {

            conn =DBConnect.getConnection();

            //Khai báo 1 công việc
            String strSQL = "";
          //  if(dieukien == "Ten_nha_cung_cap"){
                strSQL = "Select ma_nha_cung_cap, ten_nha_cung_cap, dia_chi_nha_cung_cap, sdt_nha_cung_cap"
                        + " from nhacungcap where "+dieukien+" LIKE'%"+giatri+"%'";
          //  }
//            else{
//                strSQL = "Select ma_nha_cung_cap, ten_nha_cung_cap, dia_chi_nha_cung_cap, sdt_nha_cung_cap"
//                        + " from nhacungcap where "+dieukien+"='"+giatri+"'";
//            }

            Statement comm = conn.createStatement();

            //Thực hiện và trả về kết quả
            ResultSet rs = comm.executeQuery(strSQL);

            //Khai báo đối tượng
            NhaCungCapDTO objNhaCungCap = null;
            //Đọc từng dòng thông tin
            while (rs.next()) {
                //Khởi tạo đối tượng
                objNhaCungCap = new NhaCungCapDTO();
                //Gán giá trị cho các thuộc tính
                objNhaCungCap.setStrMaNhaCungCap(rs.getString("ma_nha_cung_cap"));
                objNhaCungCap.setStrTenNhaCungCap(rs.getString("ten_nha_cung_cap"));
                objNhaCungCap.setStrDiaChiNhaCungCap(rs.getString("dia_chi_nha_cung_cap"));
                objNhaCungCap.setStrSdtNhaCungCap(rs.getString("sdt_nha_cung_cap"));
                //Thêm vào danh sách
                lstNhaCungCap.add(objNhaCungCap);
            }

        } catch (SQLException ex) {
            System.out.println("Có lỗi xảy ra trong quá trình làm việc với mysql. "
                    + "Chi tiết: " + ex.getMessage());
        } finally {
            try {
                //Đóng kết nối
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhaCungCapBUS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lstNhaCungCap;
    }
}
