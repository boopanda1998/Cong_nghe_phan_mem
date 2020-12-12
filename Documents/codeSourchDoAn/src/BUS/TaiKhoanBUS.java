/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author PC
 */
public class TaiKhoanBUS {
    
    private TaiKhoanDAO taiKhoanDAO = null;

    public TaiKhoanBUS() {
        this.taiKhoanDAO = new TaiKhoanDAO();
    }
    
    public static ArrayList<TaiKhoanDTO> getList(){
        return TaiKhoanDAO.getList();
    }
    public static int Insert(TaiKhoanDTO taiKhoanDTO){
        return TaiKhoanDAO.Insert(taiKhoanDTO);
    }
    public int Update(TaiKhoanDTO taiKhoanDTO){
        return TaiKhoanDAO.Update(taiKhoanDTO);
    }

}
