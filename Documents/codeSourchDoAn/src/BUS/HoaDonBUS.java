/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.HoaDonDAO;
import DTO.HangHoaDTO;
import DTO.HoaDonDTO;
import java.util.ArrayList;

/**
 *
 * @author boopa
 */
public class HoaDonBUS {
    private HoaDonDAO hoaDonDAO = null;

    public HoaDonBUS() {
        this.hoaDonDAO = new HoaDonDAO();
    }
    
    public static ArrayList<HoaDonDTO> getList(){
        return HoaDonDAO.getList();
    }
    public int Insert(HoaDonDTO nhapHangDTO){
        return HoaDonDAO.Insert(nhapHangDTO);
    }
    public int Delete(String mapn){
        return HoaDonDAO.Delete(mapn);
    }
    
    public int Update(HoaDonDTO nhapHangDTO){
        return HoaDonDAO.Update(nhapHangDTO);
    }
}
