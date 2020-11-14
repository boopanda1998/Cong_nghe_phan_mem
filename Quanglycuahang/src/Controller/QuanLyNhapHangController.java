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
import DTO.ChatLieuDTO;
import DTO.ChiTietPhieuNhapDTO;
import DTO.NhapHangDTO;
import DTO.NhaCungCapDTO;
import DTO.NhanVienDTO;
import DTO.NhapHangDTO;
import Utility.ClassTableNhapHang;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    
    private JPanel jpnView1;
    private JButton btnThem1;
    private JButton btnSua1;
    private JButton btnXoa1;
    private JButton btnCapnhat1;
    
    private JTextField jtfTimkiem1;
    private JLabel jlbThongbao1,jlbTongtien1;
    private  JComboBox jcbMancc,jcbManv;
    boolean khoa = false;
    
    private JTextField jtfMapn,jtfNgaynhap,jtfGhichu;
    private ClassTableNhapHang classTableModel = null;
 
    private final String[] COLUMNS = {"Mã NCC", "Mã NV", "Mã PN", "Tổng tiền","Ngày nhập","Ghi chú"};
 
    private NhapHangBUS nhapHangBUS = null;
   
    private JLabel jlbMapn;
    private TableRowSorter<TableModel> rowSorter = null;

    public QuanLyNhapHangController(JPanel jpnView1, JButton btnThem1, JButton btnSua1, JButton btnXoa1, JButton btnCapnhat1, JTextField jtfTimkiem1, JLabel jlbThongbao1, JLabel jlbTongtien1, JComboBox jcbMancc, JComboBox jcbManv, JTextField jtfMapn, JTextField jtfNgaynhap, JTextField jtfGhichu,JLabel jlbMapn) {
        this.jpnView1 = jpnView1;
        this.btnThem1 = btnThem1;
        this.btnSua1 = btnSua1;
        this.btnXoa1 = btnXoa1;
        this.btnCapnhat1 = btnCapnhat1;
       
        this.jtfTimkiem1 = jtfTimkiem1;
        this.jlbThongbao1 = jlbThongbao1;
        this.jlbTongtien1 = jlbTongtien1;
        this.jcbMancc = jcbMancc;
        this.jcbManv = jcbManv;
        this.jtfMapn = jtfMapn;
        this.jtfNgaynhap = jtfNgaynhap;
        this.jtfGhichu = jtfGhichu;
        this.jlbMapn = jlbMapn;
         
        this.classTableModel = new ClassTableNhapHang();
        this.nhapHangBUS = new NhapHangBUS();
    }


   

    
 ///Button tim kiem them sua xoa thoat cap nhat set event
    public void setDataToTable() {
        ArrayList<NhanVienDTO> nhanVienDTO= NhanVienBUS.getList();
        ArrayList<NhaCungCapDTO> nhaCungCapDTO=NhaCungCapBUS.getList();
        ArrayList<ChiTietPhieuNhapDTO> chiTietPhieuNhapDTO = ChiTietPhieuNhapBUS.getList();
        

        for (NhanVienDTO manv : nhanVienDTO) {
            jcbManv.addItem(manv.getManv()); 
        }
        for (NhaCungCapDTO mancc : nhaCungCapDTO) {
            jcbMancc.addItem(mancc.getMancc()); 
        }
        
        

        
 //////////////////////////////////       
        ArrayList<NhapHangDTO> listItem = NhapHangBUS.getList();
        DefaultTableModel model = classTableModel.setTableNhapHang(listItem, COLUMNS);
        JTable table = new JTable(model);
 
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
 
        jtfTimkiem1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfTimkiem1.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
 
            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfTimkiem1.getText();
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
        
        
        btnXoa1.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {                   
                 try {
                    if (!checkNotNull()) {
                        jlbThongbao1.setText("Vui lòng chọn 1 dòng để xóa");
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
                                jlbThongbao1.setText("Xóa thành công.");
                                }
                            }
                        else{
                            jlbThongbao1.setText("Không lưu được lên database.Kiểm tra kết nối!");
                        }}
                        else{
                        jlbThongbao1.setText("Thao tác Xóa đã bị hủy.");
                        }
                    }
                    
            } catch (Exception ex) {
                jlbThongbao1.setText("Kiểm tra kết nối.");
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
                btnXoa1.setBackground(new Color(0, 200, 83));
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                btnXoa1.setBackground(new Color(100, 221, 23));
            }
        });
        
        btnSua1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

               try {
                    if (!checkNotNull()) {
                        jlbThongbao1.setText("Vui lòng chọn 1 dòng để cập nhật dữ liệu!");
                    } else {
                        
                        //reset du lieu DTO de chuan bi nap du lieu tu textfield
                        NhapHangDTO nhapHangDTO = new NhapHangDTO();
                        
                        nhapHangDTO.setMancc( jcbMancc.getSelectedItem().toString());
                        nhapHangDTO.setManv(jcbManv.getSelectedItem().toString());
                        nhapHangDTO.setMapn(jtfMapn.getText());
                        nhapHangDTO.setTongtien(jlbTongtien1.getText());
                        nhapHangDTO.setNgaynhap(jtfNgaynhap.getText());
                        nhapHangDTO.setGhichu(jtfGhichu.getText());
                        
                        //
                        if(YesOrNo()){
                        
                        int KiemTra = nhapHangBUS.Update(nhapHangDTO);
                        if(KiemTra!= 0){
                        jlbThongbao1.setText("Sửa thành công.");
                        int  i=table.getSelectedRow();
                            if (i>=0)
                            {   
                                
                                model.setValueAt(jcbMancc.getSelectedItem().toString(), i, 0);
                                model.setValueAt(jcbManv.getSelectedItem().toString(), i, 1);
                                model.setValueAt(jtfMapn.getText(), i, 2);
                                model.setValueAt(jlbTongtien1.getText(), i, 3);
                                model.setValueAt(jtfNgaynhap.getText(), i, 4);
                                model.setValueAt(jtfGhichu.getText(), i, 5);
                                
                                table.setModel(model);
                             }
                        }else{
                            jlbThongbao1.setText("Không lưu được trên Database.Kiểm tra kết nối!");
                        }
                        }else{
                        jlbThongbao1.setText("Thao tác sửa đã bị hủy.");
                        }
                    }
                    
                } catch (Exception ex) {
                jlbThongbao1.setText("Kiểm tra kết nối.");
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
                btnSua1.setBackground(new Color(0, 200, 83));
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                btnSua1.setBackground(new Color(100, 221, 23));
            }
        });
        btnCapnhat1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                        jcbMancc.setSelectedItem("chon ma n");
                        jcbManv.setSelectedItem("chon ma nv");
                        jtfMapn.setText("");jtfMapn.setEditable(true);
                        jlbTongtien1.setText("");
                        jtfNgaynhap.setText("");
                        jtfGhichu.setText("");
                        jlbThongbao1.setText("");
                        
                        
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
 
            @Override
            public void mouseReleased(MouseEvent e) {
            }
 
            @Override
            public void mouseEntered(MouseEvent e) {
                btnCapnhat1.setBackground(new Color(0, 200, 83));
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                btnCapnhat1.setBackground(new Color(100, 221, 23));
            }
        });

        btnThem1.addMouseListener(new MouseAdapter() {
            
            
            public void mouseClicked(MouseEvent e) {

                try {
                        
                    if (!checkNotNull()) {
                        jlbThongbao1.setText("Vui lòng nhập dữ liệu bắt buộc!");
                    } else {
                        System.out.println("Kiem tra ma phieunhap da dc them vao dto chua--"+jtfMapn.getText());
                        
                        //reset du lieu DTO de chuan bi nap du lieu tu textfield
                        NhapHangDTO nhapHangDTO = new NhapHangDTO();
                        
                        nhapHangDTO.setMancc(jcbMancc.getSelectedItem().toString());
                        nhapHangDTO.setManv(jcbManv.getSelectedItem().toString());
                        nhapHangDTO.setMapn(jtfMapn.getText());
                        nhapHangDTO.setTongtien(jlbTongtien1.getText());
                        nhapHangDTO.setNgaynhap(jtfNgaynhap.getText());
                        nhapHangDTO.setGhichu(jtfGhichu.getText());
                        
                        //
                        if(YesOrNo()){
                        //them du lieu den BUS de truyen len DAO
                        int KiemTra = nhapHangBUS.Insert(nhapHangDTO);
                        if (KiemTra != 0) {
                            //them du lieu vao bang table Arraylist hien thi
                            listItem.add(nhapHangDTO); // them vao danh sach nhan vien
                            showResult();// moi lan them goi show de hien thi
                            jlbThongbao1.setText("Thêm thành công.");
                            khoa = false;
                                }else{
                                    jlbThongbao1.setText("Không lưu được trên database.Kiểm tra kết nối!");
                                    }   
                        }else{
                        jlbThongbao1.setText("Thao tác thêm đã bị hủy.");
                        }
                        
                    }
                    
                } catch (Exception ex) {
                jlbThongbao1.setText("Kiểm tra kết nối.");
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
                btnThem1.setBackground(new Color(0, 200, 83));
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                btnThem1.setBackground(new Color(100, 221, 23));
            }
        

            private void showResult() {
                                    {
                NhapHangDTO s = listItem.get(listItem.size()-1);// lay file cuoi cung de hien thi
                    model.addRow(new Object[]{
                         s.getMancc(),s.getManv(),s.getMapn(),s.getTongtien(),s.getNgaynhap(),s.getGhichu()
            
                         });
                                    }
                        }
        });
                               
 
        

        //table click
     table.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
             if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
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
                    
                    System.out.println("ma pn dang duoc chon"+jlbMapn.getText());
                        ArrayList<ChiTietPhieuNhapDTO> chiTietPhieuNhapDTO = ChiTietPhieuNhapBUS.getList();
                                long tong=0;
                                for (ChiTietPhieuNhapDTO mapn : chiTietPhieuNhapDTO){
                                    
                                        if(mapn.getMapn().equals(jlbMapn.getText())){

                                                Long tien = Long.valueOf(mapn.getTongtien());
                                                tong = tong+tien;
                                            }else{
                                                System.out.println("false"+tong);

                                        };
                                        String text = String.valueOf(tong);
                                         System.out.println("text : :"+text);
                                        jlbTongtien1.setText(text);
                                        
                                        ///
                                        int  i=table.getSelectedRow();
                                            if (i>=0)
                                            {   
                                                model.setValueAt(jlbTongtien1.getText(), i, 3);
                                                table.setModel(model);
                                             }

                                }
                    
                    nhapHangDTO.setTongtien(model.getValueAt(selectedRowIndex, 3).toString());
                    nhapHangDTO.setNgaynhap(model.getValueAt(selectedRowIndex, 4).toString());
                    nhapHangDTO.setGhichu(model.getValueAt(selectedRowIndex, 5).toString());
                    nhapHangBUS.Update(nhapHangDTO);
                    //Show du lieu tu DTO ra Textfied
                    jcbMancc.setSelectedItem(nhapHangDTO.getMancc());
                    jcbManv.setSelectedItem(nhapHangDTO.getManv());
                    jtfMapn.setText(nhapHangDTO.getMapn());jtfMapn.setEditable(false);
                    jlbMapn.setText(nhapHangDTO.getMapn());
                    jlbTongtien1.setText(nhapHangDTO.getTongtien());
                    jtfNgaynhap.setText(nhapHangDTO.getNgaynhap());
                    jtfGhichu.setText(nhapHangDTO.getGhichu());
                    jlbThongbao1.setText("Thông tin sản phẩm.");
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
        jpnView1.removeAll();
        jpnView1.setLayout(new CardLayout());
        jpnView1.add(scroll);
        jpnView1.validate();
        jpnView1.repaint();
    }
    long tong = 0;
    public void setEvent() {
      
}  
 //Kiem tra khoan trang
    private boolean checkNotNull() {
        return jcbManv.getSelectedItem().toString() != null && !jcbManv.getSelectedItem().toString().equalsIgnoreCase("") ;
//             &&txmacl.getText() != null && !txmacl.getText().equalsIgnoreCase("")
//                &&txmasp.getText() != null && !txmasp.getText().equalsIgnoreCase("");
             
    }
//kiem tra muon cap nhat hay k
    private boolean YesOrNo() {
        int YesOrNo = JOptionPane.showConfirmDialog(null,
                "Bạn muốn cập nhật dữ liệu hay không?","Thông Báo",JOptionPane.YES_NO_OPTION);
        return YesOrNo == JOptionPane.YES_NO_OPTION;
    }
    
}