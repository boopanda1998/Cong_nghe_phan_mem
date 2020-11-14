/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BUS.ChatLieuBUS;
import BUS.HangHoaBUS;
import BUS.NhaCungCapBUS;
import BUS.NhanVienBUS;
import BUS.ChiTietHoaDonBUS;
import BUS.ChiTietPhieuNhapBUS;
import DTO.ChatLieuDTO;
import DTO.ChiTietHoaDonDTO;
import DTO.NhaCungCapDTO;
import DTO.NhanVienDTO;
import DTO.ChiTietHoaDonDTO;
import DTO.ChiTietPhieuNhapDTO;
import DTO.NhapHangDTO;
import Utility.ClassTableChiTietHoaDon;
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
public class ChiTietHoaDonController {
    
    private JPanel jpnView2;
    private JButton btnThem2;
    private JButton btnSua2;
    private JButton btnXoa2;
    private JButton btnCapnhat2;
    
    private JTextField jtfTimkiem1,jtfMapn;
    private JLabel jlbThongbao1,jlbTongtien2,jlbMapn;
    private  JComboBox jcbMahang,jcbMaloai,jcbMacl;
    boolean khoa = false;
    
    private JTextField jtfSoluong,jtfDongia;
    private ClassTableChiTietHoaDon classTableModel = null;
 
    private final String[] COLUMNS = {"Mã PN", "Mã Hàng", "Mã Loại", "Mã CL","Số Lượng","Đơn giá","Tổng tiền"};
 
    private ChiTietHoaDonBUS chiTietHoaDonBUS = null;
   
 
    private TableRowSorter<TableModel> rowSorter = null;

    public ChiTietHoaDonController(JPanel jpnView2, JButton btnThem2, JButton btnSua2, JButton btnXoa2, JButton btnCapnhat2, JTextField jtfTimkiem1, JLabel jlbThongbao1, JLabel jlbTongtien2, JLabel jlbMapn, JComboBox jcbMahang, JComboBox jcbMaloai, JComboBox jcbMacl, JTextField jtfSoluong, JTextField jtfDongia,JTextField jtfMapn) {
        this.jpnView2 = jpnView2;
        this.btnThem2 = btnThem2;
        this.btnSua2 = btnSua2;
        this.btnXoa2 = btnXoa2;
        this.btnCapnhat2 = btnCapnhat2;
        this.jtfTimkiem1 = jtfTimkiem1;
        this.jlbThongbao1 = jlbThongbao1;
        this.jlbTongtien2 = jlbTongtien2;
        this.jlbMapn = jlbMapn;
        this.jcbMahang = jcbMahang;
        this.jcbMaloai = jcbMaloai;
        this.jcbMacl = jcbMacl;
        this.jtfSoluong = jtfSoluong;
        this.jtfDongia = jtfDongia;
        this.jtfMapn = jtfMapn;
    
        this.classTableModel = new ClassTableChiTietHoaDon();
        this.chiTietHoaDonBUS = new ChiTietHoaDonBUS();
    }


   

    
 ///Button tim kiem them sua xoa thoat cap nhat set event
    public void setDataToTable() {
        ArrayList<ChatLieuDTO> chatLieuDTO= ChatLieuBUS.getList();
        
        
        for (ChatLieuDTO mahang : chatLieuDTO) {
            jcbMahang.addItem(mahang.getMahang()); 
        }
        for (ChatLieuDTO maloai : chatLieuDTO) {
            jcbMaloai.addItem(maloai.getMahang()); 
        }
        for (ChatLieuDTO macl : chatLieuDTO) {
            jcbMacl.addItem(macl.getMahang()); 
        }

        
        
 //////////////////////////////////       
        ArrayList<ChiTietHoaDonDTO> listItem = chiTietHoaDonBUS.getList();
        DefaultTableModel model = classTableModel.setTableChiTietHoaDon(listItem, COLUMNS);
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
        
        jtfMapn.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfMapn.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
 
            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfMapn.getText();
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
        
        
        btnXoa2.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {                   
                 try {
                    if (!checkNotNull()) {
                        jlbThongbao1.setText("Vui lòng chọn 1 dòng để xóa");
                    } else {
                        ChiTietHoaDonDTO chiTietHoaDonDTO = new ChiTietHoaDonDTO();   
                        
                        chiTietHoaDonDTO.setMahd(jlbMapn.getText());
                        chiTietHoaDonDTO.setMahang(jcbMahang.getSelectedItem().toString());
                        chiTietHoaDonDTO.setMaloai(jcbMaloai.getSelectedItem().toString());
                        chiTietHoaDonDTO.setMacl(jcbMacl.getSelectedItem().toString());

                        
                        if(YesOrNo()){
                        
                           int KiemTra = chiTietHoaDonBUS.Delete(chiTietHoaDonDTO);
                            if(KiemTra!=0){
                            int  i=table.getSelectedRow();System.out.println("----------gia tri cot chon xoa i= "+i);
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
                btnXoa2.setBackground(new Color(0, 200, 83));
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                btnXoa2.setBackground(new Color(100, 221, 23));
            }
        });
        
        btnSua2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

               try {
                    if (!checkNotNull()) {
                        jlbThongbao1.setText("Vui lòng chọn 1 dòng để cập nhật dữ liệu!");
                    } else {
                        
                        //reset du lieu DTO de chuan bi nap du lieu tu textfield
                        ChiTietHoaDonDTO chiTietHoaDonDTO = new ChiTietHoaDonDTO();
                        
                        chiTietHoaDonDTO.setMahd(jlbMapn.getText());
                        chiTietHoaDonDTO.setMahang(jcbMahang.getSelectedItem().toString());
                        chiTietHoaDonDTO.setMaloai(jcbMaloai.getSelectedItem().toString());
                        chiTietHoaDonDTO.setMacl(jcbMacl.getSelectedItem().toString());
                        chiTietHoaDonDTO.setSoluong(jtfSoluong.getText());
                        chiTietHoaDonDTO.setDongia(jtfDongia.getText());
                        
                        Long soluong = Long.valueOf(jtfSoluong.getText());
                        Long dongia = Long.valueOf(jtfDongia.getText());
                        Long tong = soluong*dongia;
                        
                        jlbTongtien2.setText(String.valueOf(tong));
                        chiTietHoaDonDTO.setTongtien(jlbTongtien2.getText());
                        
                        //
                        if(YesOrNo()){
                        
                        int KiemTra = chiTietHoaDonBUS.Update(chiTietHoaDonDTO);
                        if(KiemTra!= 0){
                        jlbThongbao1.setText("Sửa thành công.");
                        int  i=table.getSelectedRow();
                            if (i>=0)
                            {   
                                
                                model.setValueAt(jlbMapn.getText(), i, 0);
                                System.out.println(jcbMahang.getSelectedItem().toString());
                                model.setValueAt(jcbMahang.getSelectedItem().toString(), i, 1);
                                model.setValueAt(jcbMaloai.getSelectedItem().toString(), i, 2);
                                model.setValueAt(jcbMacl.getSelectedItem().toString(), i, 3);
                                model.setValueAt(jtfSoluong.getText(), i, 4);
                                model.setValueAt(jtfDongia.getText(), i, 5);
                                model.setValueAt(jlbTongtien2.getText(), i, 6);

                                
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
                btnSua2.setBackground(new Color(0, 200, 83));
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                btnSua2.setBackground(new Color(100, 221, 23));
            }
        });
        btnCapnhat2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
//                setDataToTable();
                        jlbMapn.setText(jtfMapn.getText());
                        jtfSoluong.setText("");
                        jtfDongia.setText("");
                        jlbTongtien2.setText("");
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
                btnCapnhat2.setBackground(new Color(0, 200, 83));
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                btnCapnhat2.setBackground(new Color(100, 221, 23));
            }
        });

        btnThem2.addMouseListener(new MouseAdapter() {
            
            
            public void mouseClicked(MouseEvent e) {

                try {
                        
                    if (!checkNotNull()) {
                        jlbThongbao1.setText("Vui lòng nhập dữ liệu bắt buộc!");
                    } else {
                        System.out.println("Kiem tra ma phieunhap da dc them vao dto chua--"+jlbMapn.getText());
                        
                        //reset du lieu DTO de chuan bi nap du lieu tu textfield
                        ChiTietHoaDonDTO chiTietHoaDonDTO = new ChiTietHoaDonDTO();
                        
                        
                        chiTietHoaDonDTO.setMahd(jlbMapn.getText());
                        chiTietHoaDonDTO.setMahang(jcbMahang.getSelectedItem().toString());
                        chiTietHoaDonDTO.setMaloai(jcbMaloai.getSelectedItem().toString());
                        chiTietHoaDonDTO.setMacl(jcbMacl.getSelectedItem().toString());
                       chiTietHoaDonDTO.setSoluong(jtfSoluong.getText());
                        chiTietHoaDonDTO.setDongia(jtfDongia.getText());
                        
                      
                        
                        ArrayList<ChiTietPhieuNhapDTO> chiTietPhieuNhapDTO = ChiTietPhieuNhapBUS.getList();
                            
                            for (ChiTietPhieuNhapDTO all : chiTietPhieuNhapDTO){
                            if(all.getMahang().equals(chiTietHoaDonDTO.getMahang())&&
                                            all.getMaloai().equals(chiTietHoaDonDTO.getMaloai())&&
                                                    all.getMacl().equals(chiTietHoaDonDTO.getMacl())
                                
                                            )
                                    {
                                     Long soluongdanhap= Long.valueOf(all.getSoluong());
                                     Long soluongnhap = soluongdanhap;
                                     Long soluongban= Long.valueOf(chiTietHoaDonDTO.getSoluong()); 
                                     
                                            if(soluongban > soluongnhap){
                                                jlbThongbao1.setText("Trong kho còn lại "+soluongnhap+"Sản phẩm.");
                                            }else{
                                                soluongnhap = soluongnhap-soluongban;
                                              
                                                chiTietHoaDonDTO.setSoluong(String.valueOf(soluongban));
                                                khoa= true;
                                                                  }
                                    }else{
                                jlbThongbao1.setText("Trong kho chưa có sản phẩm này.");
                            }
                                    
                            }
                        Long soluong = Long.valueOf(jtfSoluong.getText());
                        Long dongia = Long.valueOf(jtfDongia.getText());
                        Long tong = soluong*dongia;
                        jlbTongtien2.setText(String.valueOf(tong));
                        
                        chiTietHoaDonDTO.setTongtien(String.valueOf(tong));
                        
                        
                   
                            if(YesOrNo()){
                        //them du lieu den BUS de truyen len DAO
                                
                                if( khoa == true){
    
                                    int KiemTra = chiTietHoaDonBUS.Insert(chiTietHoaDonDTO);
                                        if (KiemTra != 0) {
                                            //them du lieu vao bang table Arraylist hien thi
                                            listItem.add(chiTietHoaDonDTO); // them vao danh sach nhan vien
                                            showResult();// moi lan them goi show de hien thi
                                            jlbThongbao1.setText("Thêm thành công.");
                                            khoa = false;
                                            
                                                } 
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
                btnThem2.setBackground(new Color(0, 200, 83));
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                btnThem2.setBackground(new Color(100, 221, 23));
            }
        

            private void showResult() {
                                    {
                ChiTietHoaDonDTO s = listItem.get(listItem.size()-1);// lay file cuoi cung de hien thi
                    model.addRow(new Object[]{
                         s.getMahd(),s.getMahang(),s.getMaloai(),s.getMacl(),s.getSoluong(),s.getDongia(),s.getTongtien()
            
                         });
                                    }
                        }
        });
                               
 
        

        //table click
     table.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
             if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    //Lay gia trị hang dang chọn
                    int selectedRowIndex = table.getSelectedRow();
                    
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                    //dua du lieu vao DTO
                    ChiTietHoaDonDTO chiTietHoaDonDTO = new ChiTietHoaDonDTO();
                    
                    chiTietHoaDonDTO.setMahd(model.getValueAt(selectedRowIndex, 0).toString());
                    chiTietHoaDonDTO.setMahang(model.getValueAt(selectedRowIndex, 1).toString());
                    chiTietHoaDonDTO.setMaloai(model.getValueAt(selectedRowIndex, 2).toString());
                    chiTietHoaDonDTO.setMacl(model.getValueAt(selectedRowIndex, 3).toString());
                    chiTietHoaDonDTO.setSoluong(model.getValueAt(selectedRowIndex, 4).toString());
                    chiTietHoaDonDTO.setDongia(model.getValueAt(selectedRowIndex, 5).toString());
                    chiTietHoaDonDTO.setTongtien(model.getValueAt(selectedRowIndex, 6).toString());
                    
                    //Show du lieu tu DTO ra Textfied
                    jlbMapn.setText(chiTietHoaDonDTO.getMahd());
                    ////
                    jcbMahang.setSelectedItem(chiTietHoaDonDTO.getMahang());
                    jcbMaloai.setSelectedItem(chiTietHoaDonDTO.getMaloai());
                    jcbMacl.setSelectedItem(chiTietHoaDonDTO.getMacl());
                    ///
                    jtfSoluong.setText(chiTietHoaDonDTO.getSoluong());
                    jtfDongia.setText(chiTietHoaDonDTO.getDongia());
                    jlbTongtien2.setText(chiTietHoaDonDTO.getTongtien());

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
        jpnView2.removeAll();
        jpnView2.setLayout(new CardLayout());
        jpnView2.add(scroll);
        jpnView2.validate();
        jpnView2.repaint();
    }
    
    public void setEvent() {

        

           
}  
 //Kiem tra khoan trang
    private boolean checkNotNull() {
        return jlbMapn.getText() != null && !jlbMapn.getText().equalsIgnoreCase("") ;
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