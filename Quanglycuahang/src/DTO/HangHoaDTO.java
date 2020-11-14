/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author huynh
 */
public class HangHoaDTO {
    private String mahang;
    private String tenhang;
    private String macl;
    private String soluong;
    private String dongia;

    public String getMahang() {
        return mahang;
    }

    public String getTenhang() {
        return tenhang;
    }

    public String getMacl() {
        return macl;
    }

    public String getSoluong() {
        return soluong;
    }

    public String getDongia() {
        return dongia;
    }

    public void setMahang(String mahang) {
        this.mahang = mahang;
    }

    public void setTenhang(String tenhang) {
        this.tenhang = tenhang;
    }

    public void setMacl(String macl) {
        this.macl = macl;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    public void setDongia(String dongia) {
        this.dongia = dongia;
    }
    
}
