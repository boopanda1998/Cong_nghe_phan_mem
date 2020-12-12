/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.NhapHangDAO;
import DTO.HangHoaDTO;
import DTO.NhapHangDTO;
import java.util.ArrayList;

/**
 *
 * @author boopa
 */
public class NhapHangBUS {
    private NhapHangDAO nhapHangDAO = null;

    public NhapHangBUS() {
        this.nhapHangDAO = new NhapHangDAO();
    }
    
    public static ArrayList<NhapHangDTO> getList(){
        return NhapHangDAO.getList();
    }
    public int Insert(NhapHangDTO nhapHangDTO){
        return NhapHangDAO.Insert(nhapHangDTO);
    }
    public int Delete(String mapn){
        return NhapHangDAO.Delete(mapn);
    }
    
    public int Update(NhapHangDTO nhapHangDTO){
        return NhapHangDAO.Update(nhapHangDTO);
    }
}
