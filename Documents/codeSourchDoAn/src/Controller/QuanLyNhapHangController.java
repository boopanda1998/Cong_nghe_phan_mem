/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BUS.ChatLieuBUS;
import BUS.ChiTietPhieuNhapBUS;
import BUS.HangHoaBUS;
import BUS.NhaCungCapBUS;
import BUS.NhanVienBUS;
import BUS.NhapHangBUS;
import BUS.TaiKhoanBUS;
import DTO.ChatLieuDTO;
import DTO.ChiTietPhieuNhapDTO;
import DTO.NhapHangDTO;
import DTO.NhaCungCapDTO;
import DTO.NhanVienDTO;
import DTO.NhapHangDTO;
import DTO.TaiKhoanDTO;
import Utility.ClassTableNhapHang;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author boopa
 */
public class QuanLyNhapHangController {
    
    private JPanel jpnView;
    private JButton btnThem;
    private JButton btnSua;
    private JButton btnXoa;
    private JButton btnCapnhat;
    private JButton btnInhoadon;
    
    private JTextField jtfTimkiem;
    private JLabel jlbThongbao,jlbTongtien,jlbNgaynhap,jlbManv;
    private  JComboBox jcbMancc;
    boolean khoa = false;
    
    private JTextField jtfMapn,jtfGhichu;
    private ClassTableNhapHang classTableModel = null;
 
    private final String[] COLUMNS = {"Mã NCC", "Mã NV", "Mã PN", "Tổng tiền","Ngày nhập","Ghi chú"};
 
    private NhapHangBUS nhapHangBUS = null;
   
    private JLabel jlbMapn;
    private TableRowSorter<TableModel> rowSorter = null;
    
    public QuanLyNhapHangController(JPanel jpnView, JButton btnThem, JButton btnSua, JButton btnXoa, JButton btnCapnhat, JTextField jtfTimkiem, JLabel jlbThongbao,
            JLabel jlbTongtien, JComboBox jcbMancc, JLabel jlbManv, JTextField jtfMapn, 
            JLabel jlbNgaynhap, JTextField jtfGhichu,JLabel jlbMapn,JButton btnInhoadon) {
        this.jpnView = jpnView;
        this.btnThem = btnThem;
        this.btnSua = btnSua;
        this.btnXoa = btnXoa;
        this.btnCapnhat = btnCapnhat;
        this.jtfTimkiem = jtfTimkiem;
        this.jlbThongbao = jlbThongbao;
        this.jlbTongtien = jlbTongtien;
        this.jcbMancc = jcbMancc;
        this.jlbManv = jlbManv;
        this.jtfMapn = jtfMapn;
        this.jlbNgaynhap = jlbNgaynhap;
        this.jtfGhichu = jtfGhichu;
        this.jlbMapn = jlbMapn;
        this.btnInhoadon = btnInhoadon;
         
        this.classTableModel = new ClassTableNhapHang();
        this.nhapHangBUS = new NhapHangBUS();
    }
 ///Button tim kiem them sua xoa thoat cap nhat set event
    public void setDataToTable() {
        
        ArrayList<NhaCungCapDTO> nhaCungCapDTO=NhaCungCapBUS.getList();
        ArrayList<ChiTietPhieuNhapDTO> chiTietPhieuNhapDTO = ChiTietPhieuNhapBUS.getList();

        for (NhaCungCapDTO mancc : nhaCungCapDTO) {
            jcbMancc.addItem(mancc.getMancc()); 
        }
 //////////////////////////////////       
        ArrayList<NhapHangDTO> listItem = NhapHangBUS.getList();
        DefaultTableModel model = classTableModel.setTableNhapHang(listItem, COLUMNS);
        JTable table = new JTable(model);
        //
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
 //
        jtfTimkiem.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfTimkiem.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfTimkiem.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        
        btnThem.addMouseListener(new MouseAdapter() {
 
            public void mouseClicked(MouseEvent e) {
                try {
                    if (!checkNotNull()) {
                        jlbThongbao.setText("Vui lòng nhập dữ liệu bắt buộc!");
                    } else {
                        System.out.println("Kiem tra ma phieunhap da dc them vao dto chua--"+jtfMapn.getText());
       //
                            jlbNgaynhap.setText(NgayGioNhap());
                            jtfMapn.setText(TaoMaPhieuNhap());
                            jtfMapn.setEditable(false);
                            jlbMapn.setText(jtfMapn.getText());
                            MaNhanVien();
                            //
//                            TaiKhoanDTO taiKhoanDTO = TaiKhoanBUS.getlist();
//                            System.out.print(taiKhoanDTO.getTendangnhap());
//                            jlbManv.setText(taiKhoanDTO.getTendangnhap());
                            //
                        //reset du lieu DTO de chuan bi nap du lieu tu textfield
                        NhapHangDTO nhapHangDTO = new NhapHangDTO();
                        
                        nhapHangDTO.setMancc(jcbMancc.getSelectedItem().toString());
                        nhapHangDTO.setManv(jlbManv.getText().toString());
                        nhapHangDTO.setMapn(jtfMapn.getText());
                        nhapHangDTO.setTongtien(jlbTongtien.getText());
                        nhapHangDTO.setNgaynhap(jlbNgaynhap.getText());
                        nhapHangDTO.setGhichu(jtfGhichu.getText());
                        nhapHangDTO.setInhoadon("ChuaInhoadon");
                        //
                        if(YesOrNo()){
                        //them du lieu den BUS de truyen len DAO
                        int KiemTra = nhapHangBUS.Insert(nhapHangDTO);
                        if (KiemTra != 0) {
                            //them du lieu vao bang table Arraylist hien thi
                            listItem.add(nhapHangDTO); // them vao danh sach nhan vien
                            showResult();// moi lan them goi show de hien thi
                            jlbThongbao.setText("Thêm thành công.");
                            khoa = false;
                                }else{
                                    jlbThongbao.setText("Không lưu được trên database.Kiểm tra kết nối!");
                                    }   
                        }else{
                        jlbThongbao.setText("Thao tác thêm đã bị hủy.");
                        }
                    }
                } catch (Exception ex) {
                jlbThongbao.setText("Kiểm tra kết nối.");
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                btnThem.setBackground(new Color(0, 200, 83));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnThem.setBackground(new Color(100, 221, 23));
            }
    private void showResult() {
        NhapHangDTO s = listItem.get(listItem.size()-1);// lay file cuoi cung de hien thi
            model.addRow(new Object[]{
                 s.getMancc(),s.getManv(),s.getMapn(),s.getTongtien(),s.getNgaynhap(),s.getGhichu()

        });
    }
});

        btnXoa.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {                   
                 try {
                    if (!checkNotNull()) {
                        jlbThongbao.setText("Vui lòng chọn 1 dòng để xóa");
                    } else {
                              
                    String mapn = jtfMapn.getText();
                        NhapHangDTO nhapHangDTO = new NhapHangDTO();

                        if(YesOrNo()){
                        
                           int KiemTra = nhapHangBUS.Delete(mapn);
                            if(KiemTra!=0){
                            int  i=table.getSelectedRow();
                            if (i>=0){
                                model.removeRow(i);
                                table.setModel(model);
                                jlbThongbao.setText("Xóa thành công.");
                                }
                            }
                        else{
                            jlbThongbao.setText("Không lưu được lên database.Kiểm tra kết nối!");
                        }}
                        else{
                        jlbThongbao.setText("Thao tác Xóa đã bị hủy.");
                        }
                    }
                    
            } catch (Exception ex) {
                jlbThongbao.setText("Kiểm tra kết nối.");
            }
        }
            
            @Override
            public void mousePressed(MouseEvent e) {
            }
 
            @Override
            public void mouseReleased(MouseEvent e) {
            }
 
            @Override
            public void mouseEntered(MouseEvent e) {
                btnXoa.setBackground(new Color(0, 200, 83));
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                btnXoa.setBackground(new Color(100, 221, 23));
            }
        });
        
        btnSua.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

               try {
                    if(CheckHoaDon()){
                    if (!checkNotNull()) {
                        jlbThongbao.setText("Vui lòng chọn 1 dòng để cập nhật dữ liệu!");
                    } else {
                        
                        //reset du lieu DTO de chuan bi nap du lieu tu textfield
                        NhapHangDTO nhapHangDTO = new NhapHangDTO();
                        
                        nhapHangDTO.setMancc( jcbMancc.getSelectedItem().toString());
                        nhapHangDTO.setManv(jlbManv.getText());
                        nhapHangDTO.setMapn(jtfMapn.getText());
                        nhapHangDTO.setTongtien(jlbTongtien.getText());
                        nhapHangDTO.setNgaynhap(jlbNgaynhap.getText());
                        nhapHangDTO.setGhichu(jtfGhichu.getText());
                        nhapHangDTO.setInhoadon("ChuaInhoadon");
                        
                        
                        //
                        if(YesOrNo()){
                        
                        int KiemTra = nhapHangBUS.Update(nhapHangDTO);
                        if(KiemTra!= 0){
                        jlbThongbao.setText("Sửa thành công.");
                        int  i=table.getSelectedRow(); 
                                
                                model.setValueAt(jcbMancc.getSelectedItem().toString(), i, 0);
                                model.setValueAt(jlbManv.getText().toString(), i, 1);
                                model.setValueAt(jtfMapn.getText(), i, 2);
                                model.setValueAt(jlbTongtien.getText(), i, 3);
                                model.setValueAt(jlbNgaynhap.getText(), i, 4);
                                model.setValueAt(jtfGhichu.getText(), i, 5);
                                table.setModel(model);
                             
                        }else{
                            jlbThongbao.setText("Không lưu được trên Database.Kiểm tra kết nối!");
                        }
                        }else{
                        jlbThongbao.setText("Thao tác sửa đã bị hủy.");
                        }
                    }
                }else{
                    jlbThongbao.setText("Đã In hóa đơn.");
                    }
                    
            } catch (Exception ex) {
            jlbThongbao.setText("Kiểm tra kết nối.");
            }
     
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
 
            @Override
            public void mouseReleased(MouseEvent e) {
            }
 
            @Override
            public void mouseEntered(MouseEvent e) {
                btnSua.setBackground(new Color(0, 200, 83));
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                btnSua.setBackground(new Color(100, 221, 23));
            }
        });
        btnInhoadon.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

               try {
                    if (!checkNotNull()) {
                        jlbThongbao.setText("Vui lòng chọn 1 dòng để in hóa đơn");
                    } else {
                        
                        //reset du lieu DTO de chuan bi nap du lieu tu textfield
                        NhapHangDTO nhapHangDTO = new NhapHangDTO();
                        
                        nhapHangDTO.setMancc( jcbMancc.getSelectedItem().toString());
                        nhapHangDTO.setManv(jlbManv.getText().toString());
                        nhapHangDTO.setMapn(jtfMapn.getText());
                        nhapHangDTO.setTongtien(jlbTongtien.getText());
                        nhapHangDTO.setNgaynhap(jlbNgaynhap.getText());
                        nhapHangDTO.setGhichu(jtfGhichu.getText());
                        nhapHangDTO.setInhoadon("DaInhoadon");
                        
                        //
                        if(YesOrNo()){
                        
                        int KiemTra = nhapHangBUS.Update(nhapHangDTO);
                        if(KiemTra!= 0){
                        jlbThongbao.setText("In thành công.");
                        int  i=table.getSelectedRow();
                            if (i>=0)
                            {   
                                
                                model.setValueAt(jcbMancc.getSelectedItem().toString(), i, 0);
                                model.setValueAt(jlbManv.getText().toString(), i, 1);
                                model.setValueAt(jtfMapn.getText(), i, 2);
                                model.setValueAt(jlbTongtien.getText(), i, 3);
                                model.setValueAt(jlbNgaynhap.getText(), i, 4);
                                model.setValueAt(jtfGhichu.getText(), i, 5);
                                
                                table.setModel(model);
                             }
                        }else{
                            jlbThongbao.setText("Không lưu được trên Database.Kiểm tra kết nối!");
                        }
                        }else{
                        jlbThongbao.setText("Thao tác sửa đã bị hủy.");
                        }
                    }
                    
                } catch (Exception ex) {
                jlbThongbao.setText("Kiểm tra kết nối.");
                }
     
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
 
            @Override
            public void mouseReleased(MouseEvent e) {
            }
 
            @Override
            public void mouseEntered(MouseEvent e) {
                btnInhoadon.setBackground(new Color(0, 200, 83));
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                btnInhoadon.setBackground(new Color(100, 221, 23));
            }
        });
        btnCapnhat.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                        jcbMancc.setSelectedItem("chon ma n");
                        jlbManv.setText("");
                        jtfMapn.setText("");jtfMapn.setEditable(true);
                        jlbTongtien.setText("");
                        jlbNgaynhap.setText("");
                        jtfGhichu.setText("");
                        jlbThongbao.setText("");
                        
                        
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
 
            @Override
            public void mouseReleased(MouseEvent e) {
            }
 
            @Override
            public void mouseEntered(MouseEvent e) {
                btnCapnhat.setBackground(new Color(0, 200, 83));
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                btnCapnhat.setBackground(new Color(100, 221, 23));
            }
        });

                               
 
        

        //table click
     table.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
             if (e.getClickCount() == 1 && table.getSelectedRow() != -1) {
//                    long tong=0;
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    //Lay gia trị hang dang chọn
                    int selectedRowIndex = table.getSelectedRow();
                    
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                    
                    //dua du lieu vao DTO
                    NhapHangDTO nhapHangDTO = new NhapHangDTO();

                    nhapHangDTO.setMancc(model.getValueAt(selectedRowIndex, 0).toString());
                    nhapHangDTO.setManv(model.getValueAt(selectedRowIndex, 1).toString());
                    nhapHangDTO.setMapn(model.getValueAt(selectedRowIndex, 2).toString());
                    
                    System.out.println("ma pn dang duoc chon"+jtfMapn.getText());
                        ArrayList<ChiTietPhieuNhapDTO> chiTietPhieuNhapDTO = ChiTietPhieuNhapBUS.getList();
                                long tong=0;
                                for (ChiTietPhieuNhapDTO mapn : chiTietPhieuNhapDTO){
                                        if(mapn.getMapn().equals(jtfMapn.getText())){
                                                Long tien = Long.valueOf(mapn.getTongtien());
                                                tong = tong+tien;
                                            }else{
                                                System.out.println("false"+tong);
                                        };
                                        String text = String.valueOf(tong);
                                         System.out.println("text : :"+text);
                                        jlbTongtien.setText(text);
                                        ///
                                        int  i=table.getSelectedRow();
                                            if (i>=0)
                                            {   
                                                model.setValueAt(jlbTongtien.getText(), i, 3);
                                                table.setModel(model);
                                             }
                                }
                    nhapHangDTO.setTongtien(model.getValueAt(selectedRowIndex, 3).toString());
                    nhapHangDTO.setNgaynhap(model.getValueAt(selectedRowIndex, 4).toString());
                    nhapHangDTO.setGhichu(model.getValueAt(selectedRowIndex, 5).toString());
//                    nhapHangBUS.Update(nhapHangDTO);
                    //Show du lieu tu DTO ra Textfied
                    jcbMancc.setSelectedItem(nhapHangDTO.getMancc());
                    jlbManv.setText(nhapHangDTO.getManv());
                    jtfMapn.setText(nhapHangDTO.getMapn());
                    jtfMapn.setEditable(false);//không cho phép nhập khác hàm enabled vô hiệu hóa
                    jlbMapn.setText(nhapHangDTO.getMapn());
                    jlbTongtien.setText(nhapHangDTO.getTongtien());
                    jlbNgaynhap.setText(nhapHangDTO.getNgaynhap());
                    jtfGhichu.setText(nhapHangDTO.getGhichu());
                    jlbThongbao.setText("Thông tin sản phẩm.");
                    
                    
                 }
                
             }

        });
        // design
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        //Để tùy chỉnh độ rộng các cột bạn có thể thiết lập bởi thuộc tính setMaxWidth(), setMinWidth()
//       // table.getColumnModel().getColumn(1).setMaxWidth(80);
//        table.getColumnModel().getColumn(1).setMinWidth(80);
//        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        
        scroll.setPreferredSize(new Dimension(458, 31));
        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }
    long tong = 0;
    public void setEvent() {
      
}  
 //Kiem tra khoan trang
    private boolean checkNotNull() {
        return true;
        
    }
//kiem tra muon cap nhat hay k
    private boolean YesOrNo() {
        int YesOrNo = JOptionPane.showConfirmDialog(null,
                "Bạn muốn cập nhật dữ liệu hay không?","Thông Báo",JOptionPane.YES_NO_OPTION);
        return YesOrNo == JOptionPane.YES_NO_OPTION;
    }
    public String NgayGioNhap(){
        LocalDateTime datetime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        String formatDateTime = datetime.format(format);   
        System.out.println("After Formatting: " + formatDateTime ); 
        String str = formatDateTime.toString();
        return str;
    }
    public String TaoMaPhieuNhap(){
        ArrayList<NhapHangDTO> MaPhieuNhap = NhapHangBUS.getList();
            int max=0;
            String taomaphieunhap = null;
            for (NhapHangDTO mapn : MaPhieuNhap){
                taomaphieunhap = mapn.getMapn().replace("PN", "");
                int  min = Integer.valueOf(taomaphieunhap);
                if(max < min){
                    max = min;
                }   
        }
        if(taomaphieunhap == null){
            taomaphieunhap = "PN1";
            }else{    
            taomaphieunhap = "PN"+ String.valueOf(max+1); 
            }
        return taomaphieunhap; 
        
    }
    public boolean CheckHoaDon(){
        ArrayList<NhapHangDTO> MaPhieuNhap = NhapHangBUS.getList();
        //
        boolean check = true;
        for (NhapHangDTO mapn : MaPhieuNhap){
        if(jtfMapn.getText().equals(mapn.getMapn())){
            if(mapn.getInhoadon().equals("DaInhoadon")){
               check = false;
            }else{
               check = true;
            }
        }
        }
  return check;
    }
   public void MaNhanVien(){
       ArrayList<TaiKhoanDTO> TrangThai = TaiKhoanBUS.getList();
       for (TaiKhoanDTO trangthai : TrangThai){
           if(trangthai.getTrangthai().equals("Đang đăng nhập")){
               jlbManv.setText(trangthai.getManv());
           }
       }
       
   }
}
        