/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.HoaDonDAO;
import DTO.HoaDonDTO;
import java.util.List;

/**
 *
 * @author Windows 10
 */
public class HoaDonBUS {
    private final HoaDonDAO hoadonDAO ;

    public HoaDonBUS() {
        hoadonDAO = new HoaDonDAO();
    }
    
    public List<HoaDonDTO> getDSHoaDon(){
        return hoadonDAO.getDSHoaDon();
    }
    
    public int insertHoaDon(HoaDonDTO hoadon){
        return hoadonDAO.insertHoaDon(hoadon);
    }
    
    public int deleteHoaDon(int mahd){
        return hoadonDAO.deleteHoaDon(mahd);
    }
    
    public int updateHoaDon(HoaDonDTO hoadon){
        return hoadonDAO.updateHoaDon(hoadon);
    }
}
