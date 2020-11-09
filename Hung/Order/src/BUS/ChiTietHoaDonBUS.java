/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ChiTietHoaDonDAO;
import DTO.ChiTietHoaDonDTO;
import java.util.List;

/**
 *
 * @author Windows 10
 */
public class ChiTietHoaDonBUS {
    private ChiTietHoaDonDAO cthdDAO;

    public ChiTietHoaDonBUS() {
        cthdDAO = new ChiTietHoaDonDAO();
    }
    
    public List<ChiTietHoaDonDTO> getDSChiTiet(int mahd){
        return cthdDAO.getDSChiTiet(mahd);
    }
    
    public int insertChiTietHoaDon(ChiTietHoaDonDTO CTHD){
        return cthdDAO.insertChiTietHoaDon(CTHD);
    }
    
    public int deleteChiTietHoaDon(int macthd){
        return cthdDAO.deleteChiTietHoaDon(macthd);
    }
    
    public int updateHoaDon(ChiTietHoaDonDTO CTHD){
        return cthdDAO.updateChiTietHoaDon(CTHD);
    }
    public int getTong(int mahd){
        return cthdDAO.getTong(mahd);
    }
}
