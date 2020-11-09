package com.nhacungcap.form;

public class NhaCungCapDTO {
    private String strTenNhaCungCap,strMaNhaCungCap,strDiaChiNhaCungCap,strSdtNhaCungCap;

    public NhaCungCapDTO(){
        this.strDiaChiNhaCungCap="";
        this.strMaNhaCungCap="";
        this.strTenNhaCungCap="";
        this.strSdtNhaCungCap="";
    }
    public NhaCungCapDTO(String strMaNhaCungCap,String strTenNhaCungCap,String strDiaChiNhaCungCap,String strSdtNhaCungCap){
        this.strMaNhaCungCap = strMaNhaCungCap;
        this.strTenNhaCungCap = strTenNhaCungCap;
        this.strDiaChiNhaCungCap = strDiaChiNhaCungCap;
        this.strSdtNhaCungCap = strSdtNhaCungCap;
    }

    public String getStrTenNhaCungCap() {
        return strTenNhaCungCap;
    }

    public void setStrTenNhaCungCap(String strTenNhaCungCap) {
        this.strTenNhaCungCap = strTenNhaCungCap;
    }

    public String getStrMaNhaCungCap() {
        return strMaNhaCungCap;
    }

    public void setStrMaNhaCungCap(String strMaNhaCungCap) {
        this.strMaNhaCungCap = strMaNhaCungCap;
    }

    public String getStrDiaChiNhaCungCap() {
        return strDiaChiNhaCungCap;
    }

    public void setStrDiaChiNhaCungCap(String strDiaChiNhaCungCap) {
        this.strDiaChiNhaCungCap = strDiaChiNhaCungCap;
    }

    public String getStrSdtNhaCungCap() {
        return strSdtNhaCungCap;
    }

    public void setStrSdtNhaCungCap(String strSdtNhaCungCap) {
        this.strSdtNhaCungCap = strSdtNhaCungCap;
    }
}
