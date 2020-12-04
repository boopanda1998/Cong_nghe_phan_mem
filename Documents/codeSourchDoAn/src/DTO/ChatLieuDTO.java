/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import java.util.logging.Logger;

/**
 *
 * @author huynh
 */
public class ChatLieuDTO implements Serializable {
    private String macl;
    private String maloai;
    private String mahang;
    private String tenhang;

    public String getMacl() {
        return macl;
    }

    public String getMaloai() {
        return maloai;
    }

    public String getMahang() {
        return mahang;
    }

    public String getTenhang() {
        return tenhang;
    }

    public void setMacl(String macl) {
        this.macl = macl;
    }

    public void setMaloai(String maloai) {
        this.maloai = maloai;
    }

    public void setMahang(String mahang) {
        this.mahang = mahang;
    }

    public void setTenhang(String tenhang) {
        this.tenhang = tenhang;
    }

    
    
    
}
