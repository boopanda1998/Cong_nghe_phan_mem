package DTO;

public class KhachHangDTO {
    private String maKH, hoKH,tenKH, SDT;
    private boolean enable;

    public KhachHangDTO() {
    }

    public KhachHangDTO(String maKH, String hoKH, String tenKH, String SDT) {
        this.maKH = maKH;
        this.hoKH = hoKH;
        this.tenKH = tenKH;
        this.SDT = SDT;
        this.enable = true;
    }
    public KhachHangDTO(String maKH, String hoKH, String tenKH, String SDT, boolean enable) {
        this.maKH = maKH;
        this.hoKH = hoKH;
        this.tenKH = tenKH;
        this.SDT = SDT;
        this.enable = enable;
    }

    public String getMaKH() {
        return maKH;
    }

public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getHoKH() {
        return hoKH;
    }

    public void setHoKH(String hoKH) {
        this.hoKH = hoKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public boolean getEnable() {
        return enable;
    }
   
}
