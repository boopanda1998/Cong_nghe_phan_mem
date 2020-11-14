/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BUS.KhachHangBUS;
import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import GUI.DangKyJDialog;
import GUI.DangNhapJDialog;
import GUI.KhachHangGUI;

import Utility.ClassTableKhachHang;
import com.sun.rowset.internal.Row;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
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
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author huynh
 */
public class QuanLyKhachHangController {
    private JPanel jpnView;
    //
    private JTextField jtfTimKiem;
    private JButton btnTimKiem;
    //
    private JLabel jlbThongBao;
    boolean khoa = false;
    //
    private JButton btnThem,btnSua,btnXoa,btnNhaplai,btnNhapexcel,btnXuatexcel;
    private JTextField jtfMakh,jtfHo,jtfTen,jtfSodt,jtfNgaysinh,jtfGioitinh;
    private JLabel jlbTbmakhachhang,jlbTbho,jlbTbten,jlbTbsodienthoai,jlbTbgioitinh,jlbTbngaysinh;
    private JComboBox jcbLocdanhsach;
    //
    
    private ClassTableKhachHang classTableModel = null;
    private final String[] COLUMNS = {"Mã khách hàng", "Họ", "Tên", "SĐT" , "Ngày sinh", "Giới tính"};
    private TableRowSorter<TableModel> rowSorter = null;
    //
    private KhachHangBUS khachhangBUS = null;
    //

    public QuanLyKhachHangController(JPanel jpnView, JTextField jtfTimKiem, JButton btnTimKiem, JLabel jlbThongBao, JButton btnThem, JButton btnSua, JButton btnXoa, JButton btnNhaplai, JButton btnNhapexcel, JButton btnXuatexcel, JTextField jtfMakh, JTextField jtfHo, JTextField jtfTen,
            JTextField jtfSodt, JTextField jtfNgaysinh, JTextField jtfGioitinh,
            JLabel jlbTbmakhachhang, JLabel jlbTbho, JLabel jlbTbten, 
            JLabel jlbTbsodienthoai, JLabel jlbTbgioitinh, JLabel jlbTbngaysinh, JComboBox jcbLocdanhsach) {
        this.jpnView = jpnView;
        this.jtfTimKiem = jtfTimKiem;
        this.btnTimKiem = btnTimKiem;
        this.jlbThongBao = jlbThongBao;
        this.btnThem = btnThem;
        this.btnSua = btnSua;
        this.btnXoa = btnXoa;
        this.btnNhaplai = btnNhaplai;
        this.btnNhapexcel = btnNhapexcel;
        this.btnXuatexcel = btnXuatexcel;
        this.jtfMakh = jtfMakh;
        this.jtfHo = jtfHo;
        this.jtfTen = jtfTen;
        this.jtfSodt = jtfSodt;
        this.jtfNgaysinh = jtfNgaysinh;
        this.jtfGioitinh = jtfGioitinh;
        this.jlbTbmakhachhang = jlbTbmakhachhang;
        this.jlbTbho = jlbTbho;
        this.jlbTbten = jlbTbten;
        this.jlbTbsodienthoai = jlbTbsodienthoai;
        this.jlbTbgioitinh = jlbTbgioitinh;
        this.jlbTbngaysinh = jlbTbngaysinh;
        this.jcbLocdanhsach = jcbLocdanhsach;
        //
        this.classTableModel = new ClassTableKhachHang();
        this.khachhangBUS = new KhachHangBUS();
    }

 ///Button tim kiem them sua xoa thoat cap nhat set event
    public void setDataToTable() {
        ArrayList<KhachHangDTO> listItem = KhachHangBUS.getList();
        DefaultTableModel model = classTableModel.setTableKhachHang(listItem, COLUMNS);
        JTable table = new JTable(model);
        //
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
 //tìm kiếm tương đối
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
// tìm kiếm tuyệt đối 

//b
        btnXoa.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                 try {
                    if (!checkNotNull()) {
                        jlbThongBao.setText("Vui lòng chọn 1 dòng để xóa");
                    } else {
                    String makh = jtfMakh.getText();
                    //
                    KhachHangDTO khachhangDTO = new KhachHangDTO();
                    //
                        if(YesOrNo()){
                            int KiemTra = khachhangBUS.Delete(makh);
                            if(KiemTra!=0){
                                int  i=table.getSelectedRow();
                                if (i>=0){
                                    model.removeRow(i);
                                    table.setModel(model);
                                    jlbThongBao.setText("Xóa thành công.");
                                    }
                            }else{
                            jlbThongBao.setText("Xóa không thành công.Vui lòng kiểm tra lại.");
                                }
                        }else{
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
                        KhachHangDTO khachhangDTO = new KhachHangDTO();
                        //
                        jtfMakh.setEditable(false);
                        khachhangDTO.setMakh(jtfMakh.getText());
                        khachhangDTO.setHo(jtfHo.getText());
                        khachhangDTO.setTen(jtfTen.getText());;
                        khachhangDTO.setSodt(jtfSodt.getText());
                        //khachhangDTO.setDiachi(jtfDiachi.getText());
                        khachhangDTO.setNgaysinh(jtfNgaysinh.getText());
                        khachhangDTO.setGioitinh(jtfGioitinh.getText());;
                        
                        //
                        if(YesOrNo()){
                        int KiemTra = khachhangBUS.Update(khachhangDTO);
                        System.out.println("kiem tra"+ KiemTra);
                            if(KiemTra > 0){
                                jlbThongBao.setText("Sửa thành công.");
                                int  i=table.getSelectedRow();
                                    if (i>=0)
                                    {
                                        model.setValueAt(jtfMakh.getText(), i, 0);
                                        model.setValueAt(jtfHo.getText(), i, 1);
                                        model.setValueAt(jtfTen.getText(), i, 2);
                                        model.setValueAt(jtfSodt.getText(), i, 3);
                                        //model.setValueAt(jtfDiachi.getText(), i, 4);
                                        model.setValueAt(jtfNgaysinh.getText(), i, 5);
                                        model.setValueAt(jtfGioitinh.getText(), i, 6);
                                        table.setModel(model);
                                     }
                            }else{
                            jlbThongBao.setText("Sửa không thành công.Vui lòng kiểm tra lại.");
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
        btnNhaplai.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                //mo khoa cho phep nhap textfile
                jtfMakh.setEditable(true);
        //
            setTextspace();
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
 
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                btnNhaplai.setBackground(new Color(0, 200, 83));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnNhaplai.setBackground(new Color(100, 221, 23));
            }
        });
        //
        btnThem.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                 //mo khoa cho phep nhap textfile
                    jtfMakh.setEditable(true);
                    boolean tt = checkNotNull();
                    if (tt == false) {
                        jlbThongBao.setText("Vui lòng nhập dữ liệu bắt buộc!");
                        }else{
                        //                       
                        System.out.println("Kiem tra ma khach hang da dc them vao dto chua--"+jtfMakh.getText());
                        //reset du lieu DTO de chuan bi nap du lieu tu textfield
                        KhachHangDTO khachhangDTO = new KhachHangDTO();
                        //
                        khachhangDTO.setMakh(jtfMakh.getText());
                        khachhangDTO.setHo(jtfHo.getText());
                        khachhangDTO.setTen(jtfTen.getText());;
                        khachhangDTO.setSodt(jtfSodt.getText());
                        //khachhangDTO.setDiachi(jtfDiachi.getText());
                        khachhangDTO.setNgaysinh(jtfNgaysinh.getText());
                        khachhangDTO.setGioitinh(jtfGioitinh.getText());;
                        //
                        if(YesOrNo()){
                        //them du lieu den BUS de truyen len DAO
                        int KiemTra = khachhangBUS.Insert(khachhangDTO);
                            if (KiemTra != 0) {
                                //them du lieu vao bang table Arraylist hien thi
                                listItem.add(khachhangDTO); // them vao danh sach nhan vien
                                showResult();// moi lan them goi show de hien thi
                                
                                jlbThongBao.setText("Thêm thành công.");
                                //
                                setTextspace();
                                    }else{
                                        jlbThongBao.setText("Thêm không thành công.Vui lòng kiểm tra lại");
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
            //
            private void showResult() {
                // lay file cuoi cung de hien thi
                KhachHangDTO s = listItem.get(listItem.size()-1);
                // model
                    model.addRow(new Object[]
                    {s.getMakh(),s.getHo(),s.getTen(),s.getSodt(),s.getNgaysinh(),s.getGioitinh()
                });
            }
});
                               
//        btnThoat.addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent e) {
//             System.exit(0);  
//            }
//            @Override
//            public void mousePressed(MouseEvent e) {
//            }
// 
//            @Override
//            public void mouseReleased(MouseEvent e) {
//            }
// 
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                btnThoat.setBackground(new Color(0, 200, 83));
//            }
// 
//            @Override
//            public void mouseExited(MouseEvent e) {
//                btnThoat.setBackground(new Color(100, 221, 23));
//            }
//        });
                //nhập xuất excel


        //table click
     table.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
             if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    //Lay gia trị hang dang chọn
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                    //dua du lieu vao DTO
                    KhachHangDTO khachhangDTO = new KhachHangDTO();
                    khachhangDTO.setMakh(model.getValueAt(selectedRowIndex, 0).toString());
                    khachhangDTO.setHo(model.getValueAt(selectedRowIndex, 1).toString());
                    khachhangDTO.setTen(model.getValueAt(selectedRowIndex, 2).toString());
                    khachhangDTO.setSodt(model.getValueAt(selectedRowIndex, 3).toString());
                    //khachhangDTO.setDiachi(model.getValueAt(selectedRowIndex, 4).toString());
                    khachhangDTO.setNgaysinh(model.getValueAt(selectedRowIndex, 4).toString());
                    khachhangDTO.setGioitinh(model.getValueAt(selectedRowIndex, 5).toString());
                    
                    //Show du lieu tu DTO ra Textfied
                    jtfMakh.setText(""+khachhangDTO.getMakh());
                    jtfMakh.setEditable(false);//Khoa text filed k cho nhap du lieu
                    jtfHo.setText(khachhangDTO.getHo());
                    jtfTen.setText(khachhangDTO.getTen());
                    jtfSodt.setText(khachhangDTO.getSodt());
                    //jtfDiachi.setText(khachhangDTO.getDiachi());
                    jtfNgaysinh.setText(khachhangDTO.getNgaysinh());
                    jtfGioitinh.setText(khachhangDTO.getGioitinh());
                    //
                    jlbThongBao.setText("Thông tin khách hàng.");
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
        table.getColumnModel().getColumn(1).setMaxWidth(80);
        table.getColumnModel().getColumn(1).setMinWidth(80);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        //
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350,400));
        //
        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }

    public void setEvent() {
           
}  
 //Kiem tra khoan trang
    public boolean checkNotNull() {
        
        int checkTest = 0;
        System.out.println("1:"+jtfMakh.getText());
        if(jtfMakh.getText().isBlank()){
            System.out.println("2:"+jtfMakh.getText());
            jtfMakh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 50), 1));
            checkTest = checkTest;
            }else  {
            System.out.println("3:"+jtfMakh.getText());
                    if(jtfMakh.getText().length() > 10){
                        jtfMakh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 50), 1));
                        jlbTbmakhachhang.setText("Mã khách hàng quá 10 ký tự");
                        checkTest = checkTest;
                    }else{
                        System.out.println("4:"+jtfMakh.getText());
                        jtfMakh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
                        jlbTbmakhachhang.setText(" ");
                        checkTest = +1;
                    }
            }
        if(jtfHo.getText().isBlank()){
            jtfHo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 50), 1));
             checkTest = checkTest;
            }else  {
                    if(jtfHo.getText().length() > 10){
                        jtfMakh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 50), 1));
                        jlbTbho.setText("Quá dài");
                        checkTest = checkTest;
                    }else{
                        jtfHo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
                        jlbTbho.setText(" ");
                        checkTest = checkTest + 1;
                    }
            }
        if(jtfTen.getText().isBlank()){
            jtfTen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 50), 1));
            checkTest = checkTest;
            }else  {
                    jtfTen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 50), 1));
                    if(jtfTen.getText().length() > 10){
                        jlbTbten.setText("Quá dài");
                        checkTest = checkTest;
                    }else{
                        jtfTen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
                        jlbTbten.setText(" ");
                        checkTest = checkTest +1;
                    }
            }
        if(jtfSodt.getText().isBlank()){
            jtfSodt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 50), 1));
            checkTest = checkTest;
            }else  {
                    jtfSodt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 50), 1));
                    if(jtfSodt.getText().length() > 10){
                        jlbTbsodienthoai.setText("Quá dài");
                        checkTest = checkTest;
                    }else{
                        jtfSodt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
                        jlbTbsodienthoai.setText(" ");
                        checkTest = checkTest+1;
                    }
            } 
        if(jtfGioitinh.getText().isBlank()){
            jtfGioitinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 50), 1));
            checkTest = checkTest;
            }else  {
                    jtfGioitinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 50), 1));
                    if(jtfGioitinh.getText().length() > 10){
                        jlbTbgioitinh.setText("Quá dài");
                        checkTest = checkTest;
                    }else{
                        jtfGioitinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
                        jlbTbgioitinh.setText(" ");
                        checkTest = checkTest+1;
                    }
            }
        if(jtfNgaysinh.getText().isBlank()){
            jtfNgaysinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 50), 1));
            checkTest = checkTest;
            }else  {
                    jtfNgaysinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 50), 1));
                    if(jtfNgaysinh.getText().length() > 10){
                        jlbTbngaysinh.setText("Quá dài");
                        checkTest = checkTest;
                    }else{
                        jtfNgaysinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
                        jlbTbngaysinh.setText("");
                        checkTest = checkTest +1;
                    }
            }
        System.out.println("check test = "+ checkTest);
        if( checkTest == 6)
        {
            return true;
        }else{
        return false;
        }
     
}
//kiem tra muon cap nhat hay k
    private boolean YesOrNo() {
        int YesOrNo = JOptionPane.showConfirmDialog(null,
                "Bạn muốn cập nhật dữ liệu hay không?","Thông Báo",JOptionPane.YES_NO_OPTION);
        return YesOrNo == JOptionPane.YES_NO_OPTION;
    }
public void setTextspace(){
                jtfMakh.setText("");
                jtfHo.setText("");
                jtfTen.setText("");
                jtfSodt.setText("");
                //jtfDiachi.setText("");
                jtfNgaysinh.setText("");
                jtfGioitinh.setText(""); 
}

    
}


            
              