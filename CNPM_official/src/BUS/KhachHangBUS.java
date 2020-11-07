package BUS;
import DAO.KhachHangDAO;
import DTO.KhachHangDTO;

import java.util.ArrayList;

public class KhachHangBUS {
    private ArrayList<KhachHangDTO> listKhachHang ;
    public KhachHangBUS()
    {
        refeshList();
    }
    public void refeshList()
    {
        KhachHangDAO KhachHangDAO = new KhachHangDAO();
        listKhachHang = new ArrayList<>();
        listKhachHang = KhachHangDAO.list();
    }
    public ArrayList<KhachHangDTO> getList() {
        ArrayList<KhachHangDTO> dskh = new ArrayList<>();
        for (KhachHangDTO KhachHangDTO : listKhachHang)
        {
            //System.out.println(KhachHangDTO.getEnable());
            if (KhachHangDTO.getEnable()) dskh.add(KhachHangDTO);
        }
        return dskh;
    }
    public ArrayList<KhachHangDTO> getFullList()
    {
        return listKhachHang;
    }
    public KhachHangDTO get(String MaKH)
    {     
        for(KhachHangDTO KhachHang : listKhachHang )
        {
            if(KhachHang.getMaKH().equals(MaKH))
            {
                return KhachHang;
            }
        }
        return null;
    } 
    public boolean add(KhachHangDTO kh)
    {
        KhachHangDAO khDAO = new KhachHangDAO();                 
        if (khDAO.add(kh)) {
            listKhachHang.add(kh);
            return true;
        }
        else return false;       
    }

    public boolean delete(String MaKH)
    {
        for(KhachHangDTO KhachHang : listKhachHang )
        {
            if(KhachHang.getMaKH().equals(MaKH))
            {
                KhachHangDAO KhachHangDAO = new KhachHangDAO();
                if (KhachHangDAO.delete(MaKH)) {
                    listKhachHang.remove(KhachHang);
                    return true;
                }
                else return false;
            }
        }
        return false;
    }
    public boolean set(KhachHangDTO KhachHang)
    {
        for(int i=0 ; i<listKhachHang.size() ; i++)
        {
            if(listKhachHang.get(i).getMaKH().equals(KhachHang.getMaKH()))
            {              
                KhachHangDAO KhachHangDAO = new KhachHangDAO();
                if (KhachHangDAO.set(KhachHang)) {
                    listKhachHang.set(i, KhachHang);  
                    return true;
                }
                else return false;             
            }
        }
        System.out.println("Không tìm thấy");
        return false;
    }
    public boolean check(String MaKH)
    {       
        for(KhachHangDTO KhachHang : listKhachHang)
        {
            if(KhachHang.getMaKH().equals(MaKH))
            {
                return true;
            }
        }
        return false;
    }
    public ArrayList<KhachHangDTO> search(String MaKH, String SDT, String Ho ,String Ten)
    {
        ArrayList<KhachHangDTO> search = new ArrayList<>();
        MaKH = MaKH.isBlank()? "" : MaKH;
        SDT = SDT.isBlank()? "" : SDT;
        Ho = Ho.isBlank()? "" : Ho;
        Ten = Ten.isBlank()? "" : Ten;
        
        for(KhachHangDTO KhachHang : listKhachHang)
        {
            if( KhachHang.getMaKH().contains(MaKH) && 
                KhachHang.getSDT().contains(SDT) &&
                KhachHang.getHoKH().contains(Ho) &&
                KhachHang.getTenKH().contains(Ten))
            {
                search.add(KhachHang);
            }
        }
        return search;
    }
}
