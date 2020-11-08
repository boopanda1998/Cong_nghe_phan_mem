/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class HangHoaBUS {
    private HangHoaDAO HangHoaDAO = null;

    public HangHoaBUS() {
        this.HangHoaDAO = new HangHoaDAO();
    }

    public  ArrayList<HangHoaDTO> getList() {
        return HangHoaDAO.getList();
    }

    public int Insert(HangHoaDTO HangHoaDTO) {
        return HangHoaDAO.Insert(HangHoaDTO);
    }

    public int Delete(String maHang) {
        return HangHoaDAO.Delete(maHang);
    }

    public int Update(HangHoaDTO HangHoaDTO) {
        return HangHoaDAO.Update(HangHoaDTO);
    }
}
