/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.GiamGiaDAO;
import DTO.GiamGiaDTO;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class GiamGiaBUS {
     private GiamGiaDAO giamgiaDAO = null;

    public GiamGiaBUS() {
        this.giamgiaDAO = new GiamGiaDAO();
    }
    
    public static ArrayList<GiamGiaDTO> getList(){
        return GiamGiaDAO.getList();
    }
  //  public int Update(GiamGiaDTO nhanVienDTO){
    //    return GiamGiaDAO.Update(nhanVienDTO);
  //  }

    public int Insert(GiamGiaDTO nhanVienDTO){
        return GiamGiaDAO.Insert(nhanVienDTO);
    }
    public int Delete(String manv){
        return GiamGiaDAO.Delete(manv);
    }
    
    public int Update(GiamGiaDTO nhanVienDTO){
        return GiamGiaDAO.Update(nhanVienDTO);
    }

    
}
