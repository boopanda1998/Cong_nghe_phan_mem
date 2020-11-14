/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;


import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;

/**
 *
 * @author boopa
 */
public class TaiKhoanBUS {
    
    private TaiKhoanDAO taiKhoanDAO = null;
 
    public TaiKhoanBUS() {
        taiKhoanDAO = new TaiKhoanDAO();
    }
 
    public static TaiKhoanDTO login(String tenDangNhap, String matKhau) {
        return TaiKhoanDAO.login(tenDangNhap, matKhau);
    }
     public static int  Insert(TaiKhoanDTO taiKhoanDTO){
         return TaiKhoanDAO.Insert(taiKhoanDTO);
     }
}
