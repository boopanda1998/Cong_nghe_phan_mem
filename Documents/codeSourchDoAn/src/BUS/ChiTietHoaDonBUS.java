/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ChiTietHoaDonDAO;
import DTO.HangHoaDTO;
import DTO.ChiTietHoaDonDTO;
import java.util.ArrayList;

/**
 *
 * @author boopa
 */
public class ChiTietHoaDonBUS {
    private ChiTietHoaDonDAO chiTietHoaDonDAO = null;

    public ChiTietHoaDonBUS() {
        this.chiTietHoaDonDAO = new ChiTietHoaDonDAO();
    }
    
    public static ArrayList<ChiTietHoaDonDTO> getList(){
        return ChiTietHoaDonDAO.getList();
    }
    public int Insert(ChiTietHoaDonDTO chiTietPhieuNhapDTO){
        return ChiTietHoaDonDAO.Insert(chiTietPhieuNhapDTO);
    }
    public int Delete(ChiTietHoaDonDTO chiTietPhieuNhapDTO){
        return ChiTietHoaDonDAO.Delete(chiTietPhieuNhapDTO);
    }
    
    public int Update(ChiTietHoaDonDTO chiTietPhieuNhapDTO){
        return ChiTietHoaDonDAO.Update(chiTietPhieuNhapDTO);
    }
}
