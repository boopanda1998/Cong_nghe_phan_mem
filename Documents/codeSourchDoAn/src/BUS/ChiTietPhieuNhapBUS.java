/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ChiTietPhieuNhapDAO;
import DTO.HangHoaDTO;
import DTO.ChiTietPhieuNhapDTO;
import java.util.ArrayList;

/**
 *
 * @author boopa
 */
public class ChiTietPhieuNhapBUS {
    private ChiTietPhieuNhapDAO chiTietPhieuNhapDAO = null;

    public ChiTietPhieuNhapBUS() {
        this.chiTietPhieuNhapDAO = new ChiTietPhieuNhapDAO();
    }
    
    public static ArrayList<ChiTietPhieuNhapDTO> getList(){
        return ChiTietPhieuNhapDAO.getList();
    }
    public int Insert(ChiTietPhieuNhapDTO chiTietPhieuNhapDTO){
        return ChiTietPhieuNhapDAO.Insert(chiTietPhieuNhapDTO);
    }
    public int Delete(ChiTietPhieuNhapDTO chiTietPhieuNhapDTO){
        return ChiTietPhieuNhapDAO.Delete(chiTietPhieuNhapDTO);
    }
    
    public int Update(ChiTietPhieuNhapDTO chiTietPhieuNhapDTO){
        return ChiTietPhieuNhapDAO.Update(chiTietPhieuNhapDTO);
    }
}
