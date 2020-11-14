/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.NhaCungCapDAO;
import DTO.NhaCungCapDTO;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class NhaCungCapBUS {
     private NhaCungCapDAO nhacungcapDAO = null;

    public NhaCungCapBUS() {
        this.nhacungcapDAO = new NhaCungCapDAO();
    }
    
    public static ArrayList<NhaCungCapDTO> getList(){
        return NhaCungCapDAO.getList();
    }
  //  public int Update(NhaCungCapDTO nhacungcapDTO){
    //    return NhaCungCapDAO.Update(nhacungcapDTO);
  //  }

    public int Insert(NhaCungCapDTO nhacungcapDTO){
        return NhaCungCapDAO.Insert(nhacungcapDTO);
    }
    public int Delete(String mancc){
        return NhaCungCapDAO.Delete(mancc);
    }
    
    public int Update(NhaCungCapDTO nhacungcapDTO){
        return NhaCungCapDAO.Update(nhacungcapDTO);
    }

    
}
