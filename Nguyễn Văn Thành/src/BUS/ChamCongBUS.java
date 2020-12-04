/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ChamCongDAO;
import DTO.ChamCongDTO;
import java.util.ArrayList;

/**
 *
 * @author Min-NvT
 */
public class ChamCongBUS {
    private ChamCongDAO chamCongDAO = null;
    private Iterable<ChamCongDTO> list;

    public ChamCongBUS() {
        this.chamCongDAO = new ChamCongDAO();
    }
    public static ArrayList<ChamCongDTO> getList(){
        return ChamCongDAO.getList();
    }
    public int Insert(ChamCongDTO nhanVienDTO){
        return ChamCongDAO.Insert(nhanVienDTO);
    }
    public int Delete(String manv){
        return ChamCongDAO.Delete(manv);
    }
    
    public int Update(ChamCongDTO nhanVienDTO){
        return ChamCongDAO.Update(nhanVienDTO);
    }
 }

