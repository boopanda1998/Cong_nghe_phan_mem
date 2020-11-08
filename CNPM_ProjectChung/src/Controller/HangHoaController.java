/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Admin
 */
public class HangHoaController {
    //cụm panel 1: nhập dữ liệu
    private JPanel jpnNhap;
    //private JComboBox jtfMahang,jtfMaCl;
    private JTextField jtfMaHang,jtfMaCl,jtfTenHang,jtfSoLuong,jtfDonGia,jtfGhiChu;
    private JButton btnThem,btnXoa,btnSua,btnCapNhat,btnNhapLai,btnThoat;
    private JLabel jlbThongBao;
            
    //cụm panel 2:tìm kiếm và xem dữ liệu
    private JPanel jpnHienThi;
    private JTextField jtfTimKiem;
    private JTable table;
    //table của cụm 2
    private ClassTableHangHoa classTableModel = null;
    private final String[] COLUMNS = {"Mã Hàng", "Mã Chất Liệu", "Tên Hàng", "Số Lượng","Đơn Giá","Ghi Chú"};
    
    //cụm panel 3: hiển thị trạng thái
    //private JLabel jlbTrangThai;
    
    private HangHoaBUS HangHoaBUS = null;
    
    private TableRowSorter<TableModel> rowSorter = null;
    
    boolean khoa =false;
    
    DefaultTableModel model;
    
    private Border normalBorder;
    
    
    public HangHoaController(JPanel jpnNhap, JTextField jtfMahang, JTextField jtfMaCl, JTextField jtfTenHang, JTextField jtfSoLuong, JTextField jtfDonGia, JTextField jtfGhiChu, JButton btnThem, JButton btnXoa, JButton btnSua, JButton btnCapNhat, JButton btnNhapLai, JLabel jlbThongBao, JPanel jpnHienThi, JTextField jtfTimKiem) {
        this.jpnNhap = jpnNhap;
        this.jtfMaHang = jtfMahang;
        this.jtfMaCl = jtfMaCl;
        this.jtfTenHang = jtfTenHang;
        this.jtfSoLuong = jtfSoLuong;
        this.jtfDonGia = jtfDonGia;
        this.jtfGhiChu = jtfGhiChu;
        this.btnThem = btnThem;
        this.btnXoa = btnXoa;
        this.btnSua = btnSua;
        this.btnCapNhat = btnCapNhat;
        this.btnNhapLai = btnNhapLai;
        this.jlbThongBao = jlbThongBao;
        this.jpnHienThi = jpnHienThi;
        this.jtfTimKiem = jtfTimKiem;
        //this.jlbTrangThai = jlbTrangThai;
        this.classTableModel = new ClassTableHangHoa();
 
        this.HangHoaBUS = new HangHoaBUS();
        
        normalBorder=jtfMaHang.getBorder();
    }


    
    
    
    //Button tim kiem them sua xoa thoat cap nhat them event
    public void setDataToTable() {
        ArrayList<HangHoaDTO> listItem = HangHoaBUS.getList();
        model = classTableModel.setTableHangHoa(listItem, COLUMNS);
        table = new JTable(model);
        //tim kiem va sap xep
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
//                ArrayList<HangHoaDTO> listItem = HangHoaBUS.getList();
//                DefaultTableModel model = classTableModel.setTableNhanVien(listItem, COLUMNS);
//                table = new JTable(model);
            }

            
        });
        
        
        //cập nhật copy lại setdatatotable chứ bó tay ko đổi model được
        btnCapNhat.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                ArrayList<HangHoaDTO> list = HangHoaBUS.getList();
                model = classTableModel.setTableHangHoa(list, COLUMNS);
                table =new JTable(model);
                //thêm tìm kiếm sắp xếp
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
//                ArrayList<HangHoaDTO> listItem = HangHoaBUS.getList();
//                DefaultTableModel model = classTableModel.setTableNhanVien(listItem, COLUMNS);
//                table = new JTable(model);
            }});
                //them sự kiện click vào dòng trên table
                table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    //Lay gia trị hang dang chọn
                    int selectedRowIndex = table.getSelectedRow();

                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                    //dua du lieu vao DTO
                    HangHoaDTO HangHoaDTO = new HangHoaDTO();
                    HangHoaDTO.setMaHang(model.getValueAt(selectedRowIndex, 0).toString());
                    HangHoaDTO.setMaCL(model.getValueAt(selectedRowIndex, 1).toString());
                    HangHoaDTO.setTenHang(model.getValueAt(selectedRowIndex, 2).toString());
                    HangHoaDTO.setSoLuong(model.getValueAt(selectedRowIndex, 3).toString());
                    HangHoaDTO.setDonGia(model.getValueAt(selectedRowIndex, 4).toString());
                    HangHoaDTO.setGhiChu(model.getValueAt(selectedRowIndex, 5).toString());



                    //Show du lieu tu DTO ra Textfied
                    jtfMaHang.setText(""+HangHoaDTO.getMaHang());
                    jtfMaHang.setEditable(false);//Khoa text filed k cho nhap du lieu
                    jtfMaCl.setText(HangHoaDTO.getMaCL());
                    jtfMaCl.setEditable(false);//khoa chat lieu
                    jtfTenHang.setText(HangHoaDTO.getTenHang());
                    jtfSoLuong.setText(HangHoaDTO.getSoLuong());
                    jtfSoLuong.setEditable(false);
                    jtfDonGia.setText(HangHoaDTO.getDonGia());
                    jtfGhiChu.setText(HangHoaDTO.getGhiChu());

                        //
                    jlbThongBao.setText("Thông tin hàng hoá.");
                    }
                 }

            });
              paintTable();
            }
        });
        
        
        //Xoa
        btnXoa.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                 try {
                    if (!checkAll()) {
                        jlbThongBao.setText("Vui lòng chọn 1 dòng để xóa");
                    } else {
                    if(Integer.parseInt(jtfSoLuong.getText())>0)
                        JOptionPane.showMessageDialog(null,"còn hàng trong kho không thể xoá." );
                    else{
                        String maH = jtfMaHang.getText();
                            HangHoaDTO HangHoaDTO = new HangHoaDTO();

                            if(YesOrNo()){

                               int KiemTra = HangHoaBUS.Delete(maH);
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
                //btnXoa.setBackground(new Color(0, 200, 83));
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                //btnXoa.setBackground(new Color(100, 221, 23));
            }
        });
        
        btnSua.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

               try {
                    if (!checkAll()) {
                        jlbThongBao.setText("Vui lòng chọn 1 dòng để cập nhật dữ liệu!");
                    } else {
                        
                        //reset du lieu DTO de chuan bi nap du lieu tu textfield
                        HangHoaDTO HangHoaDTO = new HangHoaDTO();
                        
                        HangHoaDTO.setMaHang(jtfMaHang.getText());
                        HangHoaDTO.setMaCL(jtfMaCl.getText());
                        HangHoaDTO.setTenHang(jtfTenHang.getText());
                        HangHoaDTO.setSoLuong(jtfSoLuong.getText());
                        HangHoaDTO.setDonGia(jtfDonGia.getText());
                        HangHoaDTO.setGhiChu(jtfGhiChu.getText());
    
                        
                        
                        //
                        if(YesOrNo()){
                        
                        int KiemTra = HangHoaBUS.Update(HangHoaDTO);
                        if(KiemTra!= 0){
                        jlbThongBao.setText("Sửa thành công.");
                        int  i=table.getSelectedRow();
                            if (i>=0)
                            {
                                model.setValueAt(jtfMaHang.getText(), i, 0);
                                model.setValueAt(jtfMaCl.getText(), i, 1);
                                model.setValueAt(jtfTenHang.getText(), i, 2);
                                model.setValueAt(jtfSoLuong.getText(), i, 3);
                                model.setValueAt(jtfDonGia.getText(), i, 4);
                                model.setValueAt(jtfGhiChu.getText(), i, 5);
                                
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
                //btnSua.setBackground(new Color(0, 200, 83));
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
               // btnSua.setBackground(new Color(100, 221, 23));
            }
        });
        btnNhapLai.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                        //mo khoa cho phep nhap textfile
                        jtfMaHang.setEditable(true);
                        jtfMaCl.setEditable(true);
                        jtfSoLuong.setEditable(true);
                        khoa = true;

                        jtfMaHang.setText("");
                        jtfMaCl.setText("");
                        jtfTenHang.setText("");
                        jtfSoLuong.setText("");
                        jtfDonGia.setText("");
                        jtfGhiChu.setText("");

            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
 
            @Override
            public void mouseReleased(MouseEvent e) {
            }
 
            @Override
            public void mouseEntered(MouseEvent e) {
                //btnNhapLai.setBackground(new Color(0, 200, 83));
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                //btnNhapLaisetBackground(new Color(100, 221, 23));
            }
        });

        btnThem.addMouseListener(new MouseAdapter() {
            
            
            public void mouseClicked(MouseEvent e) {
                if (jtfMaHang.isEditable()==false){
                //mo khoa cho phep nhap textfile
                    jtfMaHang.setEditable(true);
                    jtfMaCl.setEditable(true);
                    jtfSoLuong.setEditable(true);
                    jlbThongBao.setText("nhập dữ liệu muốn thêm");
                }else
                try {
                       
                        
                    if (!checkAll()) {
                        jlbThongBao.setText("Vui lòng nhập dữ liệu bắt buộc!");
                    } else {
                        System.out.println("Controllers: Kiem tra ma hang hoa da dc them vao dto chua--"+jtfMaHang.getText());
                        //reset du lieu DTO de chuan bi nap du lieu tu textfield
                        HangHoaDTO HangHoaDTO = new HangHoaDTO();
                        
                        HangHoaDTO.setMaHang(jtfMaHang.getText());
                        HangHoaDTO.setMaCL(jtfMaCl.getText());
                        HangHoaDTO.setTenHang(jtfTenHang.getText());;
                        HangHoaDTO.setSoLuong(jtfSoLuong.getText());
                        HangHoaDTO.setDonGia(jtfDonGia.getText());
                        HangHoaDTO.setGhiChu(jtfGhiChu.getText());
                        
                        
                        //
                        if(YesOrNo()){
                        //them du lieu den BUS de truyen len DAO
                        int KiemTra = HangHoaBUS.Insert(HangHoaDTO);
                        if (KiemTra != 0) {
                            //them du lieu vao bang table Arraylist hien thi
                            listItem.add(HangHoaDTO); // them vao danh sach nhan vien
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
                //btnThem.setBackground(new Color(0, 200, 83));
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                //btnThem.setBackground(new Color(100, 221, 23));
            }
        

            private void showResult() {
                                    {
                HangHoaDTO s = listItem.get(listItem.size()-1);// lay file cuoi cung de hien thi
                    model.addRow(new Object[]{
                         s.getMaHang(),s.getMaCL(),s.getTenHang(),s.getSoLuong(),s.getDonGia(),s.getGhiChu()
            
                         });
                                    }
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
        

        //table click
     table.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
             if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    //Lay gia trị hang dang chọn
                    int selectedRowIndex = table.getSelectedRow();
                    
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                    //dua du lieu vao DTO
                    HangHoaDTO HangHoaDTO = new HangHoaDTO();
                    HangHoaDTO.setMaHang(model.getValueAt(selectedRowIndex, 0).toString());
                    HangHoaDTO.setMaCL(model.getValueAt(selectedRowIndex, 1).toString());
                    HangHoaDTO.setTenHang(model.getValueAt(selectedRowIndex, 2).toString());
                    HangHoaDTO.setSoLuong(model.getValueAt(selectedRowIndex, 3).toString());
                    HangHoaDTO.setDonGia(model.getValueAt(selectedRowIndex, 4).toString());
                    HangHoaDTO.setGhiChu(model.getValueAt(selectedRowIndex, 5).toString());

                    
                    
                    //Show du lieu tu DTO ra Textfied
                    jtfMaHang.setText(""+HangHoaDTO.getMaHang());
                    jtfMaHang.setEditable(false);//Khoa text filed k cho nhap du lieu
                    jtfMaCl.setText(HangHoaDTO.getMaCL());
                    jtfMaCl.setEditable(false);
                    jtfTenHang.setText(HangHoaDTO.getTenHang());
                    jtfSoLuong.setText(HangHoaDTO.getSoLuong());
                    jtfSoLuong.setEditable(false);
                    jtfDonGia.setText(HangHoaDTO.getDonGia());
                    jtfGhiChu.setText(HangHoaDTO.getGhiChu());
                    
                    //
                    jlbThongBao.setText("Thông tin hàng hoá.");
                 }
                
             }

        });
        paintTable();
        
        //hien thi ghi chu cho button cap nhat
        btnCapNhat.setToolTipText("nút này để tải lại bảng hàng hoá");
        //tool tip - ghi chú kế textfield
        UIManager.put("ToolTip.background", Color.ORANGE);
        UIManager.put("ToolTip.font", new Font("tahoma", Font.BOLD, 18));
        javax.swing.ToolTipManager.sharedInstance().setInitialDelay(100);
    }

    public void setEvent() {
           
}  
    private void setRedBorder(JTextField jText){
        Border redBorder = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.RED);
        jText.setBorder(redBorder);
        jText.setToolTipText("hãy nhập dữ liệu.");
    }
    
    
    private void setNormalBorder(JTextField jText){
        jText.setBorder(normalBorder);
        jText.setToolTipText(null);
    }
    
    private boolean checkNotNull(JTextField jText){
        if (jText.getText() == null || jText.getText().equalsIgnoreCase("")){
            setRedBorder(jText);
            return false;
        }
        return true;
    }
    
    private boolean checkIsNumber(JTextField jText){
        String number="\\d+";
        if (!jText.getText().matches(number)){
            setRedBorder(jText);
            return false;
        }
        return true;
    }
    
    private boolean checkIsTextNoNumber(JTextField jText){
        String stringNoNumber=".*\\d.*";
        if (jText.getText().matches(stringNoNumber)){
            setRedBorder(jText);
            return false;
        }
        return true;
    }
    
    private boolean checkSpecialCharacters(JTextField jText){
        String stringNoNumber=".*\\d.*";
        if (jText.getText().matches(stringNoNumber)){
            setRedBorder(jText);
            return false;
        }
        return true;
    }
 //Kiem tra khoan trang và dữ liệu không hợp lệ
    private boolean checkAll() {
        boolean flag=true;
        
        String number="\\d+";
        String stringNoNumber=".*\\d.*";
        String KyTuDacBiet=".*\\W.*";
        String dauTrongTV=".*\\W^(\\p{L}).*";
        //check mọi thứ
        //check null
        if (jtfMaHang.getText() == null || jtfMaHang.getText().equalsIgnoreCase("")){
            setRedBorder(jtfMaHang);
            flag=false;
        }
        else{
            //check ký tự đặc biệt
            if(jtfMaHang.getText().matches(KyTuDacBiet)){
                setRedBorder(jtfMaHang);
                jtfMaHang.setToolTipText("chỉ được nhập chữ và số");
                flag=false;
            }
            else
            setNormalBorder(jtfMaHang);
        }
        //check null
        if(jtfMaCl.getText() == null || jtfMaCl.getText().equalsIgnoreCase("")){
            setRedBorder(jtfMaCl);
            flag=false;
        }
        else{
            //check ký tự đặc biệt
            if(jtfMaCl.getText().matches(KyTuDacBiet)){
                setRedBorder(jtfMaCl);
                jtfMaCl.setToolTipText("chỉ được nhập chữ và số");
                flag=false;
            }
            else
            setNormalBorder(jtfMaCl);
        }
        //check null
        if(jtfTenHang.getText() == null || jtfTenHang.getText().equalsIgnoreCase("")){
            setRedBorder(jtfTenHang);
            flag=false;
        }
        else{
            //check ký tự đặc biệt
            if(jtfTenHang.getText().matches(KyTuDacBiet)){
                setRedBorder(jtfTenHang);
                jtfTenHang.setToolTipText("chỉ được nhập chữ");
                flag=false;
            }
            else//check số
            if(jtfTenHang.getText().matches(stringNoNumber)){
                setRedBorder(jtfTenHang);
                jtfTenHang.setToolTipText("Tên hàng không được có số.");
                flag=false;
            }
            else
            setNormalBorder(jtfTenHang);
        }
        //check null
        if(jtfSoLuong.getText() == null || jtfSoLuong.getText().equalsIgnoreCase("")){
            setRedBorder(jtfSoLuong);
            flag=false;
        }
        else{
            //check ký tự đặc biệt
            if(jtfSoLuong.getText().matches(KyTuDacBiet)){
                setRedBorder(jtfSoLuong);
                jtfSoLuong.setToolTipText("chỉ được nhập số");
                flag=false;
            }
            else//check số
            if(!jtfSoLuong.getText().matches(number)){
                setRedBorder(jtfSoLuong);
                jtfSoLuong.setToolTipText("số lượng là số, nhập lại.");
                flag=false;
            }
            else
            setNormalBorder(jtfSoLuong);
        }
        //check null
        if(jtfDonGia.getText() == null || jtfDonGia.getText().equalsIgnoreCase("")){
            setRedBorder(jtfDonGia);
            flag=false;
        }
        else{
            //check ký tự đặc biệt
            if(jtfDonGia.getText().matches(KyTuDacBiet)){
                setRedBorder(jtfDonGia);
                jtfDonGia.setToolTipText("chỉ được nhập số");
                flag=false;
            }
            else//check số
            if(!jtfDonGia.getText().matches(number)){
                setRedBorder(jtfDonGia);
                jtfDonGia.setToolTipText("Đơn giá là số, nhập lại.");
                flag=false;
            }
            else
            setNormalBorder(jtfDonGia);
        }
        
        
        return flag;  
    }
    
//kiem tra muon cap nhat hay k
    private boolean YesOrNo() {
        int YesOrNo = JOptionPane.showConfirmDialog(null,
                "Bạn muốn cập nhật dữ liệu hay không?","Thông Báo",JOptionPane.YES_NO_OPTION);
        return YesOrNo == JOptionPane.YES_NO_OPTION;
    }
     private void paintTable(){
        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 20));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(30);
        table.validate();
        table.repaint();
        //Để tùy chỉnh độ rộng các cột bạn có thể thiết lập bởi thuộc tính setMaxWidth(), setMinWidth()
        table.getColumnModel().getColumn(1).setMaxWidth(168);
        table.getColumnModel().getColumn(1).setMinWidth(168);
        table.getColumnModel().getColumn(1).setPreferredWidth(168);
        table.setFont(new Font("Tahoma", Font.LAYOUT_LEFT_TO_RIGHT, 18));
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        
        scroll.setPreferredSize(new Dimension(1011,511));
        jpnHienThi.removeAll();
        jpnHienThi.setLayout(new CardLayout(0, 0));
        jpnHienThi.add(scroll);
        jpnHienThi.validate();
        jpnHienThi.repaint();
}
}
