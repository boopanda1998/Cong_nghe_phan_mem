/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import Bean.KhachHangBean;
import java.util.List;

/**
 *
 * @author User
 */
public interface ThongKeBUS {
   
    
    public List<KhachHangBean> getListByKhachHang();
    
    //public List<KhoaHocBean> getListByKhoaHoc();
    
}
    

