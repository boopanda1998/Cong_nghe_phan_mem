/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BUS.HoaDonBUS;
import DTO.HoaDonDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Windows 10
 */
public class HoaDonController {

    private JButton addBtn;
    private JButton editBtn,deleteBtn;
    private JButton exportExcelBtn,importExcelBtn;
    private JButton refreshBtn;  
    private JTextField txtSearch,txtTongTien,txtGhiChu;
    private JComboBox txtMaNV,txtMaKH;
    private JDateChooser txtNgayNhap;
    private JLabel lableMaHD,lableMaHD2;
    private JTable tableHoaDon; 
    private JTable tableChiTietHoaDon; 
    private DefaultTableModel dtm;
    private DefaultTableModel dtm2;
    int maHD;
    HoaDonBUS hoadonBUS;
    HoaDonDTO hoadonDTO;

    public HoaDonController(JButton addBtn, JButton editBtn, JButton deleteBtn, JButton refreshBtn, JButton exportExcelBtn,JButton importExcelBtn,
                            JTextField txtSearch, JTextField txtTongTien, JComboBox txtMaNV,  JDateChooser txtNgayNhap,
                            JTextField txtGhiChu, JComboBox txtMaKH, JLabel lableMaHD,JLabel lableMaHD2, JTable tableHoaDon ,JTable tableChiTietHoaDon) {
        this.addBtn = addBtn;
        this.importExcelBtn = importExcelBtn;
        this.editBtn = editBtn;
        this.deleteBtn = deleteBtn;
        this.refreshBtn = refreshBtn;
        this.txtSearch = txtSearch;
        this.txtTongTien = txtTongTien;
        this.txtMaNV = txtMaNV;
        this.txtNgayNhap = txtNgayNhap;
        this.txtGhiChu = txtGhiChu;
        this.txtMaKH = txtMaKH;
        this.lableMaHD = lableMaHD;
        this.lableMaHD2 = lableMaHD2;
        this.tableHoaDon = tableHoaDon;
        this.tableChiTietHoaDon = tableChiTietHoaDon;
        this.exportExcelBtn = exportExcelBtn;
        
    }

    public HoaDonController() {
    }
     
    String combo[] = {"Vui lòng chọn","1","2","3","4","5","6","7","8","9","10"};
    Border canhbao = BorderFactory.createLineBorder(Color.red);
    public void setEvent(){
        
        for(int i=0 ; i<=10;i++){
            txtMaNV.addItem(combo[i]);
            txtMaKH.addItem(combo[i]);
        }      
        
        txtTongTien.setEnabled(false);
        hoadonBUS = new HoaDonBUS();
        //Them dong va cot cho table
        dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row,int column){
                    return false;
                }
        };
        
        dtm2 = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row,int column){
                    return false;
                }
        };
        
        tableHoaDon.setModel(dtm);
        
        dtm.addColumn("Mã HĐ");
        dtm.addColumn("Mã KH");
        dtm.addColumn("Mã NV");
        dtm.addColumn("Tổng tiền");
        dtm.addColumn("Ngày bán");
        dtm.addColumn("Ghi chú");
        
        setDataTable(hoadonBUS.getDSHoaDon());
        
        //Khi nhan vao btn add
        addBtn.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if(txtMaKH.getSelectedIndex()==0||txtMaNV.getSelectedIndex()==0){
                    JOptionPane.showMessageDialog(null, "Hãy nhập đầy đủ dữ liệu");
                    if(txtMaKH.getSelectedIndex()==0){
                        txtMaKH.setBorder(canhbao);
                    }else{
                        txtMaKH.setBorder(null);
                    }
                    if(txtMaNV.getSelectedIndex()==0){
                        txtMaNV.setBorder(canhbao);
                    }else{
                        txtMaKH.setBorder(null);
                    }
                }else{
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    String date = sdf.format(txtNgayNhap.getDate());

                    HoaDonDTO hoadonDTO = new HoaDonDTO();           
                    hoadonDTO.setMakh(txtMaKH.getSelectedItem().toString());
                    hoadonDTO.setManv(txtMaNV.getSelectedItem().toString());
                    hoadonDTO.setTongtien(String.valueOf(0));
                    hoadonDTO.setNgayban(date);
                    hoadonDTO.setGhichu(txtGhiChu.getText());

                    if(message()){
                        int check = hoadonBUS.insertHoaDon(hoadonDTO);
                        if(check!=0){
                            JOptionPane.showMessageDialog(null, "Thành công");
                            dtm.setRowCount(0);
                            setDataTable(hoadonBUS.getDSHoaDon());

                            txtMaKH.setSelectedIndex(0);
                            txtMaNV.setSelectedIndex(0);
                            txtTongTien.setText("");
                            txtGhiChu.setText("");
                        }else{
                            JOptionPane.showMessageDialog(null, "Thất bại khi kết nối với cơ sở dữ liệu");
                        }
                    }
                }               
            }
        }); 
        
        //Khi nhan vao btn sua
        editBtn.addMouseListener(new MouseAdapter() {
            DefaultTableModel tblModel = (DefaultTableModel)tableHoaDon.getModel();
            
            @Override
            public void mouseClicked(MouseEvent e) {
                    HoaDonDTO hoadonDTO = new HoaDonDTO();
            
                if(tableHoaDon.getSelectedRowCount() == 1){
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    String date = sdf.format(txtNgayNhap.getDate());
                    
                    hoadonDTO.setMakh(txtMaKH.getSelectedItem().toString());
                    hoadonDTO.setManv(txtMaNV.getSelectedItem().toString());
                    hoadonDTO.setTongtien(txtTongTien.getText());
                    hoadonDTO.setNgayban(date);
                    hoadonDTO.setGhichu(txtGhiChu.getText());
                    hoadonDTO.setMahd(String.valueOf(maHD));
            
                    if(message()){
                        int check = hoadonBUS.updateHoaDon(hoadonDTO);
                        if(check!=0){
                            JOptionPane.showMessageDialog(null, "Thành công");
                    
                            tblModel.setValueAt(txtMaKH.getSelectedItem().toString(), tableHoaDon.getSelectedRow(), 1);
                            tblModel.setValueAt(txtMaKH.getSelectedItem().toString(), tableHoaDon.getSelectedRow(), 2);
                            editText(txtTongTien,3,tblModel);
                            tblModel.setValueAt(date, tableHoaDon.getSelectedRow(), 4);
                            editText(txtGhiChu,5,tblModel);
                            dtm.setRowCount(0);
                            //Dua bang ve trang thai ban dau
                            setDataTable(hoadonBUS.getDSHoaDon());
                        }else{
                            JOptionPane.showMessageDialog(null, "Thất bại khi kết nối với cơ sở dữ liệu");
                        }
                    }                       
                }else{
                    if(tableHoaDon.getRowCount() == 0){
                        JOptionPane.showMessageDialog(null, "Bảng trống !");
                    }else{
                        JOptionPane.showMessageDialog(null, "Hãy chọn một cột cần sửa !");
                    }
                }
            }  
        });
        
        deleteBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tableHoaDon.getSelectedRow();
                if(row == -1){
                    JOptionPane.showMessageDialog(null,"Vui lòng chọn dòng cần xóa !","Lỗi",JOptionPane.ERROR_MESSAGE);
                }else{
                    int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa! Nếu bạn xóa tất cả sản phẩm đặt hàng cũng sẽ bị xóa");
                    if(confirm == JOptionPane.YES_OPTION){
                        int mahd = Integer.valueOf(String.valueOf(tableHoaDon.getValueAt(row, 0)));
                        int check = hoadonBUS.deleteHoaDon(mahd);
                        if(check!=0){
                            JOptionPane.showMessageDialog(null, "Thành công");
                            dtm.setRowCount(0);
                            setDataTable(hoadonBUS.getDSHoaDon());
                        }
                    }
                }
            }    
        });
        
        refreshBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dtm.setRowCount(0);
                //Dua bang ve trang thai ban dau
                setDataTable(hoadonBUS.getDSHoaDon());
        
                //Lam moi textfield
                txtMaKH.setSelectedIndex(0);
                txtMaNV.setSelectedIndex(0);
                lableMaHD.setText("Mã HĐ: ");
                txtTongTien.setText("");
                txtGhiChu.setText(""); 
                }
        });
        
        tableHoaDon.addMouseListener(new MouseAdapter() {
                        
            @Override
            public void mouseClicked(MouseEvent e) {

                DefaultTableModel tblModel = (DefaultTableModel)tableHoaDon.getModel();
                
                maHD =  Integer.parseInt(tblModel.getValueAt(tableHoaDon.getSelectedRow(), 0).toString());
                
                txtMaKH.setSelectedItem(tblModel.getValueAt(tableHoaDon.getSelectedRow(), 1).toString());
                txtMaNV.setSelectedItem(tblModel.getValueAt(tableHoaDon.getSelectedRow(), 2).toString());
                setTextTable(txtTongTien,3,tblModel);
                SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
                try {
                    Date ngaynhap = date.parse(tblModel.getValueAt(tableHoaDon.getSelectedRow(), 4).toString());
                    txtNgayNhap.setDate(ngaynhap);
                } catch (ParseException ex) {
                    Logger.getLogger(HoaDonController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                setTextTable(txtGhiChu,5,tblModel);
                
                lableMaHD.setText("Mã hóa đơn: "+maHD);
                lableMaHD2.setText("Mã hóa đơn: "+maHD);

            }        
        });
        
        txtSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                DefaultTableModel table = (DefaultTableModel) tableHoaDon.getModel();
                String search = txtSearch.getText();
                TableRowSorter<DefaultTableModel> sort = new TableRowSorter<>(table);
                tableHoaDon.setRowSorter(sort);
                sort.setRowFilter(RowFilter.regexFilter(search));
            }
            
        });
        
        exportExcelBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                JFileChooser excelFileChooser = new JFileChooser("C:\\Users\\Windows 10\\Desktop\\Export");
                
                excelFileChooser.setDialogTitle("Save As");
                DefaultTableModel table = (DefaultTableModel) tableHoaDon.getModel();
                FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls","xlsx","xlsm");
                excelFileChooser.setFileFilter(fnef);
                int excelChooser = excelFileChooser.showSaveDialog(null);
                
                if(excelChooser == JFileChooser.APPROVE_OPTION){
                    
                    FileOutputStream excelFOU = null;
                    BufferedOutputStream excelBOU = null;
                    XSSFWorkbook excelExporter = null;
                    
                    try {
                        excelExporter = new XSSFWorkbook();
                        XSSFSheet excelSheet = excelExporter.createSheet("hoadon");
                        XSSFRow excelRow =null;
                        XSSFCell excelCell = null;
                        
                        excelRow = excelSheet.createRow(0);
                        excelCell = excelRow.createCell(0,CellType.STRING);
                        excelCell.setCellValue("MaHD");
                        excelCell = excelRow.createCell(1,CellType.STRING);
                        excelCell.setCellValue("MaKH");
                        excelCell = excelRow.createCell(2,CellType.STRING);
                        excelCell.setCellValue("MaNV");
                        excelCell = excelRow.createCell(3,CellType.STRING);
                        excelCell.setCellValue("Thành tiền");
                        excelCell = excelRow.createCell(4,CellType.STRING);
                        excelCell.setCellValue("Ngày bán");
                        excelCell = excelRow.createCell(5,CellType.STRING);
                        excelCell.setCellValue("Ghi chú");
                        
                        for(int i =0 ;i<table.getRowCount();i++){
                            excelRow = excelSheet.createRow(i+1);
                            for(int j=0;j<table.getColumnCount();j++){
                                excelCell = excelRow.createCell(j);
                                excelCell.setCellValue(table.getValueAt(i, j).toString());
                            }
                        }   
                        excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile()+".xlsx");
                        excelBOU = new BufferedOutputStream(excelFOU);
                        excelExporter.write(excelBOU);
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } finally {
                        try {
                            if(excelFOU!=null){
                                excelFOU.close();
                            }          
                            if(excelBOU!=null){
                                excelBOU.close();
                            }    
                            if(excelExporter!=null){
                                excelExporter.close();
                            }   
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });
        
        importExcelBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                File excelFile;
                String defaultCurrentDirectoryPath ="C:\\Users\\Windows 10\\Desktop\\Import";
                FileInputStream excelFIS = null;
                BufferedInputStream excelBIS = null;
                XSSFWorkbook excelImportToJTable = null;
                JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
                excelFileChooser.setDialogTitle("Select Excel File");
                FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
                excelFileChooser.setFileFilter(fnef);
                int excelChooser = excelFileChooser.showOpenDialog(null);
                if (excelChooser == JFileChooser.APPROVE_OPTION){
                    try {
                        excelFile = excelFileChooser.getSelectedFile();
                        excelFIS = new FileInputStream(excelFile);
                        excelBIS = new BufferedInputStream(excelFIS);
                        excelImportToJTable = new XSSFWorkbook(excelBIS);
                        XSSFSheet excelSheet = excelImportToJTable.getSheetAt(0);
 
                        for (int row = 1; row<=excelSheet.getLastRowNum();row++) {
                            XSSFRow excelRow = excelSheet.getRow(row);

                            XSSFCell excelMaKH = excelRow.getCell(1);
                            XSSFCell excelMaNV = excelRow.getCell(2);
                            XSSFCell excelTongTien = excelRow.getCell(3);
                            XSSFCell excelNgayBan = excelRow.getCell(4);
                            XSSFCell excelGhiChu = excelRow.getCell(5);
 
                            hoadonDTO = new HoaDonDTO();
                            hoadonDTO.setMakh(excelMaKH.toString());
                            hoadonDTO.setManv(excelMaNV.toString());
                            hoadonDTO.setTongtien(excelTongTien.toString());
                            hoadonDTO.setNgayban(excelNgayBan.toString());
                            hoadonDTO.setGhichu(excelGhiChu.toString());
                            
                            hoadonBUS = new HoaDonBUS();
                            hoadonBUS.insertHoaDon(hoadonDTO);
                        }
                        JOptionPane.showMessageDialog(null, "Imported Successfully !!.....");
                    } catch (IOException iOException) {
                        JOptionPane.showMessageDialog(null, iOException.getMessage());
                    } finally {
                        try {
                                if (excelFIS != null) {
                                    excelFIS.close();
                                }
                                if (excelBIS != null) {
                                    excelBIS.close();
                                }
                                if (excelImportToJTable != null) {
                                    excelImportToJTable.close();
                                }
                            } catch (IOException iOException) {
                                JOptionPane.showMessageDialog(null, iOException.getMessage());
                        }
                    }
                }
                dtm.setRowCount(0);
                //Dua bang ve trang thai ban dau
                setDataTable(hoadonBUS.getDSHoaDon());
            }
            
            
        });
    }
    
    //Truyen du lieu vao bang du lieu
    private void setDataTable(List<HoaDonDTO> dsHoaDon){
        for(HoaDonDTO hoadon : dsHoaDon){
            dtm.addRow(new Object[]{
                hoadon.getMahd(),
                hoadon.getMakh(),
                hoadon.getManv(),     
                hoadon.getTongtien(),
                hoadon.getNgayban(),
                hoadon.getGhichu()
            });
        }
    }
    
        
    private boolean message(){
        int Check = JOptionPane.showConfirmDialog(null, "Bạn muốn cập nhật dữ liệu?","Thông báo",JOptionPane.YES_NO_OPTION);
        return Check == JOptionPane.YES_NO_OPTION;
    }
    
    private void editText(JTextField text,int id,DefaultTableModel tblModel){
        tblModel.setValueAt(text.getText(), tableHoaDon.getSelectedRow(), id);
    }
    
    private void setTextTable(JTextField text,int id,DefaultTableModel tblModel){
        text.setText(tblModel.getValueAt(tableHoaDon.getSelectedRow(), id).toString());
    }
    
}
