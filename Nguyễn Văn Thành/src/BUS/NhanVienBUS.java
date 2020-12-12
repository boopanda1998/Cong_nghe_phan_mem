/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
/**
 *
 * @author Min-NvT
 */
import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.util.ArrayList;
 
public class NhanVienBUS {
    
    private NhanVienDAO nhanVienDAO = null;
    private Iterable<NhanVienDTO> list;

    public NhanVienBUS() {
        this.nhanVienDAO = new NhanVienDAO();
    }
 
    
    public static ArrayList<NhanVienDTO> getList(){
        return NhanVienDAO.getList();
    }
    
    public int Insert(NhanVienDTO nhanVienDTO){
        return NhanVienDAO.Insert(nhanVienDTO);
    }
    public int Delete(NhanVienDTO nhanVienDTO){
        return NhanVienDAO.Delete(nhanVienDTO);
    }
    
    public int Update(NhanVienDTO nhanVienDTO){
        return NhanVienDAO.Update(nhanVienDTO);
    }
 }

    
    