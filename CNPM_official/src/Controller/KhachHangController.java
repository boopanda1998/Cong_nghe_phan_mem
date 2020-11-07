package Controller;
import BUS.KhachHangBUS;
import DTO.KhachHangDTO;
import GUI.KhachHangGUI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class KhachHangController {
    private JButton btnSua;
    private JButton btnThem;
    private JButton btnTimKiem;
    private JButton btnXoa;
    private JScrollPane jScrollPane;
    private JLabel jlbHo;
    private JLabel jlbMaKH;
    private JLabel jlbSDT;
    private JLabel jlbTen;
    private JTable jtbDanhSachKhachHang;
    private JTextField jtfHo;
    private JTextField jtfMaKH;
    private JTextField jtfSDT;
    private JTextField jtfTen;

    private KhachHangBUS KhachHangBUS = null;
    private DefaultTableModel TableModel;
    public KhachHangController(JButton btnSua, JButton btnThem, JButton btnTimKiem, JButton btnXoa, JScrollPane jScrollPane, JLabel jlbHo, JLabel jlbMakh, JLabel jlbSDT, JLabel jlbTen, JTable jtbDanhSachKhachHang, JTextField jtfHo, JTextField jtfMakh, JTextField jtfSDT, JTextField jtfTen) {
       
        this.btnSua = btnSua;
        this.btnThem = btnThem;
        this.btnTimKiem = btnTimKiem;
        this.btnXoa = btnXoa;
        this.jScrollPane = jScrollPane;
        this.jlbHo = jlbHo;
        this.jlbMaKH = jlbMakh;
        this.jlbSDT = jlbSDT;
        this.jlbTen = jlbTen;
        this.jtbDanhSachKhachHang = jtbDanhSachKhachHang;
        this.jtfHo = jtfHo;
        this.jtfMaKH = jtfMakh;
        this.jtfSDT = jtfSDT;
        this.jtfTen = jtfTen;
        
        this.KhachHangBUS = new KhachHangBUS();
        
        //tabindex
        this.jtfMaKH.setNextFocusableComponent(this.jtfSDT);
        this.jtfSDT.setNextFocusableComponent(this.jtfHo);
        this.jtfHo.setNextFocusableComponent(this.jtfTen);
        this.jtfTen.setNextFocusableComponent(this.btnThem);
        this.btnThem.setNextFocusableComponent(this.btnSua);
        this.btnSua.setNextFocusableComponent(this.btnXoa);
        this.btnXoa.setNextFocusableComponent(this.btnTimKiem);
        this.btnTimKiem.setNextFocusableComponent(this.jScrollPane);
        this.jScrollPane.setNextFocusableComponent(this.jtbDanhSachKhachHang);
        
        setDataToTable();
    }
    
    public void setDataToTable() {     
        Vector tableHeader = new Vector();
        tableHeader.add("Mã khách hàng");
        tableHeader.add("Họ");
        tableHeader.add("Tên");
        tableHeader.add("SĐT"); 
        TableModel = new DefaultTableModel(tableHeader, 0);
        xuatTable(TableModel, KhachHangBUS.getList());
       
        btnThem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {            
                short checkInput = checkInput(jtfSDT.getText(), jtfHo.getText(), jtfTen.getText());
                boolean flag = true;
                if (checkInput==3 || checkInput==8 || checkInput==13 || checkInput==18) {
                    JOptionPane.showMessageDialog(null, "Số điện thoại là bắt buộc!", "Waring!", JOptionPane.INFORMATION_MESSAGE);
                    flag = false;
                }
                else if (checkInput==4 || checkInput==9 || checkInput==14 || checkInput==19) {
                    JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ!", "Waring!", JOptionPane.INFORMATION_MESSAGE);
                    flag = false;
                }
                if (checkInput==10 || checkInput==13 || checkInput==14 || checkInput==15 || checkInput==18 || checkInput==19) {
                    JOptionPane.showMessageDialog(null, "Tên không thể trống!", "Waring!", JOptionPane.INFORMATION_MESSAGE);
                    flag = false;
                }
                if (flag) {
                    KhachHangDTO KhachHang = new KhachHangDTO();
                    KhachHang.setMaKH(sinhIDKhachHang());
                    KhachHang.setHoKH(jtfHo.getText());
                    KhachHang.setTenKH(jtfTen.getText());
                    KhachHang.setSDT(jtfSDT.getText());
                    if (!KhachHangBUS.add(KhachHang)) JOptionPane.showMessageDialog(null, "Không thể thêm vào cơ sở dữ liệu!", "Waring!", JOptionPane.INFORMATION_MESSAGE);
                }
                
                cleanTextField(jtfMaKH, jtfSDT, jtfHo, jtfTen);
                KhachHangBUS.refeshList();
                xuatTable(TableModel, KhachHangBUS.getList());
            }
        }
        );
        
        btnSua.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e) {
                String MaKH = formatMaKH(jtfMaKH.getText());
                if (MaKH.equals("-1") || MaKH.equals("0")) JOptionPane.showMessageDialog(null, "Mã khách hàng không hợp lệ!", "Waring!", JOptionPane.INFORMATION_MESSAGE);
                else if (KhachHangBUS.check(MaKH)){                    
                    short checkInput = checkInput(jtfSDT.getText(), jtfHo.getText(), jtfTen.getText());
                    if (checkInput==4 || checkInput==9 || checkInput==14 || checkInput==19)
                    {
                        JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ", "Waring!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        boolean sdtTrong=false, sdtSai=false, hoTrong=false, tenTrong=false;
                        switch (checkInput) {
                            case 3:
                                sdtTrong = true;
                                break;
                            case 5:
                                hoTrong = true;
                                break;
                            case 10:
                                tenTrong = true;
                                break;
                            case 8:
                                sdtTrong = true;
                                hoTrong = true;
                                break;
                            case 13:
                                sdtTrong = true;
                                tenTrong = true;
                                break;
                            case 15:
                                hoTrong = true;
                                tenTrong = true;
                                break;
                            case 18:
                                sdtTrong = true;
                                hoTrong = true;
                                tenTrong = true;
                                break;
                        }
                        
                        KhachHangDTO KhachHangDTO = KhachHangBUS.get(MaKH);
                        String SDT=jtfSDT.getText(), Ho=jtfHo.getText(), Ten= jtfTen.getText();
                        if (sdtTrong) SDT = KhachHangDTO.getSDT();
                        if (hoTrong) Ho = KhachHangDTO.getHoKH();
                        if (tenTrong) Ten = KhachHangDTO.getTenKH();
                        KhachHangDTO = new KhachHangDTO();
                        KhachHangDTO.setMaKH(MaKH);
                        KhachHangDTO.setSDT(SDT);
                        KhachHangDTO.setHoKH(Ho);
                        KhachHangDTO.setTenKH(Ten);
                        if (KhachHangBUS.set(KhachHangDTO)) {
                            cleanTextField(jtfMaKH, jtfSDT, jtfHo, jtfTen);
                            KhachHangBUS.refeshList();
                            xuatTable(TableModel, KhachHangBUS.getList());
                        } else JOptionPane.showMessageDialog(null, "Không thể sửa!", "Waring!", JOptionPane.INFORMATION_MESSAGE);
                    
                    }
                } else JOptionPane.showMessageDialog(null, "Mã khách hàng không tồn tại", "Waring!", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        btnXoa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e) {
                String MaKH = formatMaKH(jtfMaKH.getText());
                if (MaKH.equals("-1") || MaKH.equals("0")) JOptionPane.showMessageDialog(null, "Mã khách hàng không hợp lệ!", "Waring!", JOptionPane.INFORMATION_MESSAGE);
                else if (KhachHangBUS.check(MaKH))
                    {
                        if (KhachHangBUS.delete(MaKH)) {
                        KhachHangBUS.refeshList();
                        xuatTable(TableModel, KhachHangBUS.getList());
                        cleanTextField(jtfMaKH, jtfSDT, jtfHo, jtfTen);                   
                        } else {
                            JOptionPane.showMessageDialog(null, "Không thể xóa!", "Waring!", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else JOptionPane.showMessageDialog(null, "Mã khách hàng không tồn tại", "Waring!", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        btnTimKiem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e) {
                if (!checkMaKH(jtfMaKH.getText())) JOptionPane.showMessageDialog(null, "Mã khách hàng không hợp lệ!", "Waring!", JOptionPane.INFORMATION_MESSAGE);
                else
                {
                    if (!checkSDT(jtfSDT.getText())) JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ!", "Waring!", JOptionPane.INFORMATION_MESSAGE);
                    else
                    {
                        xuatTable(TableModel, KhachHangBUS.search(jtfMaKH.getText(), jtfSDT.getText(), jtfHo.getText(), jtfTen.getText()));
                    }
                }
            }
        });
    }
    
    public void xuatTable(DefaultTableModel TableModel, ArrayList<KhachHangDTO> listKhachHang) // xuất ra danh sách khách hàng
    {
        Vector tableData;
        TableModel.setRowCount(0);
        for(KhachHangDTO KhachHang:listKhachHang)
        {
            tableData = new Vector();
            tableData.add(KhachHang.getMaKH());
            tableData.add(KhachHang.getHoKH());
            tableData.add(KhachHang.getTenKH());
            tableData.add(KhachHang.getSDT());
            TableModel.addRow(tableData);      
        }
        jtbDanhSachKhachHang.setModel(TableModel);
    }
    
    public void cleanTextField(JTextField jtf1, JTextField jtf2, JTextField jtf3, JTextField jtf4) {
        jtf1.setText("");
        jtf2.setText("");
        jtf3.setText("");
        jtf4.setText("");
    }
    public void cleanTextField(JTextField jtf) {
        jtf.setText("");
    }
    
    public String sinhIDKhachHang() {
        System.out.println("start sinhIDKhachHang");
        short IDKhachHang=0, max=0;
        KhachHangBUS.refeshList();
        for (KhachHangDTO KhachHang: KhachHangBUS.getFullList()) 
        {
            IDKhachHang = Short.parseShort(KhachHang.getMaKH());
            if (IDKhachHang > max) max=IDKhachHang;
        }
        max++;
        String ID;
        if (max<10) ID = "00"+max;
        else if (max<100) ID = "0"+max;
        else ID = ""+max;
        System.out.println("end sinhIDKhachHang");
        return ID;
    }
    public String formatMaKH(String MaKH) {
        if (MaKH.isBlank()) return "0";
        try {
            short maKH = Short.parseShort(MaKH);
            if(maKH<0 || maKH>999) {
                cleanTextField(jtfMaKH);
                return "-1";
            } else {
                String ID;
                if (maKH<10) ID = "00"+maKH;
                else if (maKH<100) ID = "0"+maKH;
                else ID = ""+maKH;
                return ID;
            }
        } catch (NumberFormatException e) {
            System.out.println(e);
            cleanTextField(jtfMaKH);
            return "-1";
        }
    }
    public short checkInput(String SDT,String Ho, String Ten) {
        short sdtTrong=0, sdtSai=0, hoTrong=0, tenTrong=0;
        if (SDT.isBlank()) sdtTrong = 3 ;  //SDT trống                      
        else { //SDT sai
            try {
                if (Integer.parseInt(SDT) < 0) sdtSai = 4;
            } catch (NumberFormatException e) {
                System.out.println(e);
                cleanTextField(jtfSDT);
                sdtSai = 4;
            }
        }
        if (Ho.isBlank()) hoTrong = 5; //Họ trống
        if (Ten.isBlank()) tenTrong = 10; //Tên trống
        return (short)(sdtTrong+sdtSai+hoTrong+tenTrong);//Kết quả
    }
    public boolean checkMaKH(String MaKH)
    {
        if (MaKH.isBlank()) return true;
        try 
        {
            short Ma = Short.parseShort(MaKH);
            if (Ma>0 && Ma<1000) return true;            
        } catch (NumberFormatException e)
        {
            System.out.println(e);
            jtfMaKH.setText("");
            return false;
        }
        return false;
    }
    public boolean checkSDT (String SDT)
    {
        if (SDT.isBlank()) return true;
        try
        {
            long sdt = Long.parseLong(SDT);
            if (sdt<100000000000L && sdt>0L) return true;
        } catch (NumberFormatException e) {
            System.out.println(e);
            jtfSDT.setText("");
            return false;
        }
        return false;
    }
}
