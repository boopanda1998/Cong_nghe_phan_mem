/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author huynh
 */
public class KhachHangBUS {
    private KhachHangDAO khachhangDAO = null;

    public KhachHangBUS() {
        this.khachhangDAO = new KhachHangDAO();
    }
    
    public static ArrayList<KhachHangDTO> getList(){
        return KhachHangDAO.getList();
    }
    public int Insert(KhachHangDTO khachhangDTO){
        return KhachHangDAO.Insert(khachhangDTO);
    }
    public int Delete(String makh){
        return KhachHangDAO.Delete(makh);
    }
    
    public int Update(KhachHangDTO khachhangDTO){
        return KhachHangDAO.Update(khachhangDTO);
    }
}
