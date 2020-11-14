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
public class KhachHangDTO {
    private String makh,ho,ten,sodt,
            ngaysinh,gioitinh;
    public KhachHangDTO(String makh,String ho,String ten,String sodt,String ngaysinh,String gioitinh){
        this.makh=makh;
        this.ho=ho;
        this.ten=ten;
        this.sodt=sodt;
        //this.diachi=diachi;
        this.ngaysinh=ngaysinh;
        this.gioitinh=gioitinh;
    }
    public KhachHangDTO(){
        
    }

    public String getMakh() {
        return makh;
    }

    public String getHo() {
        return ho;
    }

    public String getTen() {
        return ten;
    }

    public String getSodt() {
        return sodt;
    }


    public String getNgaysinh() {
        return ngaysinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }
    
    public void setMakh(String makh) {
        this.makh = makh;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
    }


    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }
    
}


