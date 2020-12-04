/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import Bean.KhachHangBean;
import DAO.ThongKeDAO;
import DAO.ThongKeDAOImpl;
import java.util.List;

/**
 *
 * @author User
 */
public class ThongKeBUSImpl implements ThongKeBUS{
   
 
    private ThongKeDAO thongKeDAO = null;
 
    public ThongKeBUSImpl() {
        this.thongKeDAO = new ThongKeDAOImpl();
    }
 
    @Override
    public List<KhachHangBean> getListByKhachHang() {
        return thongKeDAO.getListByKhachHang();
    }
 
   
 
}
    

