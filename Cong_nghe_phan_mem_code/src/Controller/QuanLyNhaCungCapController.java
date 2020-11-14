/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BUS.NhaCungCapBUS;
import DTO.NhaCungCapDTO;
import GUI.DangKyJDialog;
import GUI.DangNhapJDialog;
import GUI.GiamGiaGUI;
import Utility.ClassTableGiamGia;

import Utility.ClassTableGiamGia;
import Utility.ClassTableNhaCungCap;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
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
 * @author huynh
 */
public class QuanLyNhaCungCapController {
 
    private JPanel jpnView;
    private JButton btnThem;
    private JButton btnSua;
    private JButton btnXoa;
    private JButton btnCapNhat;
    private JButton btnThoat;
    private JTextField jtfTimKiem;
    private JButton btnTimKiem;
    private JLabel jlbThongBao;
    boolean khoa = false;
    
    private JTextField txmancc,txdiachi,txten,txsdt;
    private ClassTableNhaCungCap classTableModel = null;
 
    private final String[] COLUMNS = {"Mã nhà cung cấp", "Tên", "Địa chỉ", "Số điện thoại"};
 
    private NhaCungCapBUS nhacungcapBUS = null;
 
    private TableRowSorter<TableModel> rowSorter = null;

    public QuanLyNhaCungCapController(JPanel jpnView, JButton btnThem, JButton btnSua, JButton btnXoa, JButton btnCapNhat, JButton btnThoat, JTextField jtfTimKiem, JButton btnTimKiem, JTextField txmancc, JTextField txten, JTextField txdiachi, JTextField txsdt,JLabel jlbThongBao) {
        this.jpnView = jpnView;
        this.btnThem = btnThem;
        this.btnSua = btnSua;
        this.btnXoa = btnXoa;
        this.btnCapNhat = btnCapNhat;
        this.btnThoat = btnThoat;
        this.jtfTimKiem = jtfTimKiem;
        this.btnTimKiem = btnTimKiem;
        this.txmancc = txmancc;
        this.txten = txten;
        this.txdiachi = txdiachi;
        this.txsdt = txsdt;
        this.jlbThongBao = jlbThongBao;
     
    
        this.classTableModel = new ClassTableNhaCungCap();
 
        this.nhacungcapBUS = new NhaCungCapBUS();
    }
 ///Button tim kiem them sua xoa thoat cap nhat set event
    public void setDataToTable() {
        ArrayList<NhaCungCapDTO> listItem = NhaCungCapBUS.getList();
        DefaultTableModel model = classTableModel.setTableNhaCungCap(listItem, COLUMNS);
        JTable table = new JTable(model);
 
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
 
        jtfTimKiem.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfTimKiem.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
 
            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfTimKiem.getText();
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
        
        
        btnXoa.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                    
                 try {
                    if (!checkNotNull()) {
                        jlbThongBao.setText("Vui lòng chọn 1 dòng để xóa");
                    } else {
                              
                    String mancc = txmancc.getText();
                        NhaCungCapDTO nhacungcapDTO = new NhaCungCapDTO();

                        if(YesOrNo()){
                        
                           int KiemTra = nhacungcapBUS.Delete(mancc);
                            if(KiemTra!=0){
                            int  i=table.getSelectedRow();
                            if (i>=0){
                                model.removeRow(i);
                                table.setModel(model);
                                jlbThongBao.setText("Xóa thành công.");
                                }
                            }
                        else{
                            jlbThongBao.setText("Không lưu được lên database.Kiểm tra kết nối!");
                        }}
                        else{
                        jlbThongBao.setText("Thao tác Xóa đã bị hủy.");
                        }
                    }
                    
            } catch (Exception ex) {
                jlbThongBao.setText("Kiểm tra kết nối.");
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
                    if (!checkNotNull()) {
                        jlbThongBao.setText("Vui lòng chọn 1 dòng để cập nhật dữ liệu!");
                    } else {
                        
                        //reset du lieu DTO de chuan bi nap du lieu tu textfield
                        NhaCungCapDTO nhacungcapDTO = new NhaCungCapDTO();
                        
                        nhacungcapDTO.setMancc(txmancc.getText());
                        nhacungcapDTO.setTenncc(txten.getText());
                        nhacungcapDTO.setDiachi(txdiachi.getText());;
                        nhacungcapDTO.setSodt(txsdt.getText());
                        
               
                        //
                        if(YesOrNo()){
                        
                        int KiemTra = nhacungcapBUS.Update(nhacungcapDTO);
                        if(KiemTra!= 0){
                        jlbThongBao.setText("Sửa thành công.");
                        int  i=table.getSelectedRow();
                            if (i>=0)
                            {
                                model.setValueAt(txmancc.getText(), i, 0);
                                model.setValueAt(txten.getText(), i, 1);
                                model.setValueAt(txdiachi.getText(), i, 2);
                                model.setValueAt(txsdt.getText(), i, 3);
                                
                                table.setModel(model);
                             }
                        }else{
                            jlbThongBao.setText("Không lưu được trên Database.Kiểm tra kết nối!");
                        }
                        }else{
                        jlbThongBao.setText("Thao tác sửa đã bị hủy.");
                        }
                    }
                    
                } catch (Exception ex) {
                jlbThongBao.setText("Kiểm tra kết nối.");
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
        btnCapNhat.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                        //mo khoa cho phep nhap textfile
                        txmancc.setEditable(true);
                        khoa = true;
                //
                        txmancc.setText("");
                        txten.setText("");
                        txdiachi.setText("");
                      
                        txsdt.setText("");
                     
                     
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
 
            @Override
            public void mouseReleased(MouseEvent e) {
            }
 
            @Override
            public void mouseEntered(MouseEvent e) {
                btnCapNhat.setBackground(new Color(0, 200, 83));
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                btnCapNhat.setBackground(new Color(100, 221, 23));
            }
        });

        btnThem.addMouseListener(new MouseAdapter() {
            
            
            public void mouseClicked(MouseEvent e) {
                
                        
//                        //mo khoa cho phep nhap textfile
//                        txmancc.setEditable(true);
                      
                try {
                        //mo khoa cho phep nhap textfile
                        txmancc.setEditable(true);
                        
                    if (!checkNotNull()) {
                        jlbThongBao.setText("Vui lòng nhập dữ liệu bắt buộc!");
                    } else {
                        System.out.println("Kiem tra ma nhan vien da dc them vao dto chua--"+txmancc.getText());
                        
                        //reset du lieu DTO de chuan bi nap du lieu tu textfield
                        NhaCungCapDTO nhacungcapDTO = new NhaCungCapDTO();
                        
                        nhacungcapDTO.setMancc(txmancc.getText());
                        nhacungcapDTO.setTenncc(txten.getText());
                        nhacungcapDTO.setDiachi(txdiachi.getText());;
                        nhacungcapDTO.setSodt(txsdt.getText());
                      
                        
                        //
                        if(YesOrNo()){
                        //them du lieu den BUS de truyen len DAO
                        int KiemTra = nhacungcapBUS.Insert(nhacungcapDTO);
                        if (KiemTra != 0) {
                            //them du lieu vao bang table Arraylist hien thi
                            listItem.add(nhacungcapDTO); // them vao danh sach nhan vien
                            showResult();// moi lan them goi show de hien thi
                            jlbThongBao.setText("Thêm thành công.");
                            khoa = false;
                                }else{
                                    jlbThongBao.setText("Không lưu được trên database.Kiểm tra kết nối!");
                                    }   
                        }else{
                        jlbThongBao.setText("Thao tác thêm đã bị hủy.");
                        }
                        
                    }
                    
                } catch (Exception ex) {
                jlbThongBao.setText("Kiểm tra kết nối.");
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
                                    {
                NhaCungCapDTO s = listItem.get(listItem.size()-1);// lay file cuoi cung de hien thi
                    model.addRow(new Object[]{
                         s.getMancc(),s.getTenncc(),s.getDiachi(),s.getSodt()
            
                         });
                                    }
                        }
        });
                               
        btnThoat.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
             System.exit(0);  
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
 
            @Override
            public void mouseReleased(MouseEvent e) {
            }
 
            @Override
            public void mouseEntered(MouseEvent e) {
                btnThoat.setBackground(new Color(0, 200, 83));
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                btnThoat.setBackground(new Color(100, 221, 23));
            }
        });
        

        //table click
     table.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
             if (e.getClickCount() == 1 && table.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    //Lay gia trị hang dang chọn
                    int selectedRowIndex = table.getSelectedRow();
                    
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                    //dua du lieu vao DTO
                    NhaCungCapDTO nhacungcapDTO = new NhaCungCapDTO();
                    nhacungcapDTO.setMancc(model.getValueAt(selectedRowIndex, 0).toString());
                    nhacungcapDTO.setTenncc(model.getValueAt(selectedRowIndex, 1).toString());
                    nhacungcapDTO.setDiachi(model.getValueAt(selectedRowIndex, 2).toString());
                    nhacungcapDTO.setSodt(model.getValueAt(selectedRowIndex, 3).toString());
                   
                    
                    //Show du lieu tu DTO ra Textfied
                    txmancc.setText(""+nhacungcapDTO.getMancc());
                    txmancc.setEditable(false);//Khoa text filed k cho nhap du lieu
                    txten.setText(nhacungcapDTO.getTenncc());
                    txdiachi.setText(nhacungcapDTO.getDiachi());
                    txsdt.setText(nhacungcapDTO.getSodt());
                    
                    jlbThongBao.setText("Thông tin giảm giá.");
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
//        table.getColumnModel().getColumn(1).setMaxWidth(80);
//        table.getColumnModel().getColumn(1).setMinWidth(80);
//        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        
        scroll.setPreferredSize(new Dimension(1350,400));
        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }

    public void setEvent() {
           
}  
 //Kiem tra khoan trang
    private boolean checkNotNull() {
        return txten.getText() != null && !txten.getText().equalsIgnoreCase("") 
             &&txdiachi.getText() != null && !txdiachi.getText().equalsIgnoreCase("")
                &&txmancc.getText() != null && !txmancc.getText().equalsIgnoreCase("");
             
    }
//kiem tra muon cap nhat hay k
    private boolean YesOrNo() {
        int YesOrNo = JOptionPane.showConfirmDialog(null,
                "Bạn muốn cập nhật dữ liệu hay không?","Thông Báo",JOptionPane.YES_NO_OPTION);
        return YesOrNo == JOptionPane.YES_NO_OPTION;
    }
    

}
