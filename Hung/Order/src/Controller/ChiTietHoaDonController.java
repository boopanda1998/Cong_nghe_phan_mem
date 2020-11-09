/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BUS.ChiTietHoaDonBUS;
import DTO.ChiTietHoaDonDTO;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Windows 10
 */
public class ChiTietHoaDonController {
    private JTable tableHoaDon,tableChiTiet;
    private JLabel txtThanhTien;
    private JTextField txtDonGia;
    private JComboBox txtLoai,txtSP,txtCL;
    private JSpinner SoLuong;
    private JButton addBtn,editBtn,deleteBtn,importExcelBtn,exportExcelBtn;
    ChiTietHoaDonBUS cthdBUS;
    ChiTietHoaDonDTO cthdDTO;
    private DefaultTableModel dtm;
    int maHoaDon;
    public ChiTietHoaDonController(JTable tableHoaDon,JTable tableChiTiet, JLabel txtThanhTien, JComboBox txtLoai, 
                                    JComboBox txtSP, JComboBox txtCL, JTextField txtDonGia, 
                                    JSpinner SoLuong, JButton addBtn, JButton editBtn, JButton deleteBtn, JButton importExcelBtn,JButton exportExcelBtn) {
        this.tableHoaDon = tableHoaDon;
        this.tableChiTiet=tableChiTiet;
        this.txtThanhTien = txtThanhTien;
        this.txtLoai = txtLoai;
        this.txtSP = txtSP;
        this.txtCL = txtCL;
        this.txtDonGia = txtDonGia;
        this.SoLuong = SoLuong;
        this.addBtn = addBtn;
        this.editBtn = editBtn;
        this.deleteBtn = deleteBtn;
        this.importExcelBtn = importExcelBtn;
        this.cthdBUS = new ChiTietHoaDonBUS();
        this.dtm = new DefaultTableModel();
        this.exportExcelBtn = exportExcelBtn;
    }

    public ChiTietHoaDonController(JTable tableChiTiet) {
        this.tableChiTiet = tableChiTiet;
    }
    
    String combo[] = {"Vui lòng chọn","1","2","3","4","5","6","7","8","9","10"};
    Border canhbao = BorderFactory.createLineBorder(Color.red);
    public void setTable(int maHD){
        cthdBUS= new ChiTietHoaDonBUS();
        dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row,int column){
                    return false;
                }
        };

        setDataTable(cthdBUS.getDSChiTiet(maHD));
        
    }
    
    private void setDataTable(List<ChiTietHoaDonDTO> dsSanPham){
        
        tableChiTiet.setModel(dtm);
        
        dtm.setColumnCount(0);
        dtm.addColumn("ID");
        dtm.addColumn("Mã SP");
        dtm.addColumn("Mã Loại");
        dtm.addColumn("Mã CL");
        dtm.addColumn("Đơn giá");
        dtm.addColumn("Số lượng");
        dtm.addColumn("Thành tiền");
        
        for(ChiTietHoaDonDTO sanpham : dsSanPham){
            dtm.addRow(new Object[]{
                sanpham.getMacthd(),
                sanpham.getMasp(),
                sanpham.getMaloai(),
                sanpham.getMacl(),
                sanpham.getDongia(),
                sanpham.getSoluong(),               
                sanpham.getTongtien()
            });
        }
    }
    
    public void setEvent(){
        
        for(int i=0 ; i<=10;i++){
            txtLoai.addItem(combo[i]);
            txtSP.addItem(combo[i]);
            txtCL.addItem(combo[i]);
        } 
        
        addBtn.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) { 
                if(tableHoaDon.getSelectedRow() < 0){
                    JOptionPane.showMessageDialog(null, "Hãy chọn hóa đơn cần thêm sản phẩm");
                }else{
                    if(txtSP.getSelectedIndex()==0||txtLoai.getSelectedIndex()==0||txtCL.getSelectedIndex()==0||txtDonGia.equals("")||Integer.parseInt(SoLuong.getValue().toString())==0){
                        JOptionPane.showMessageDialog(null, "Vui lòng điền vào đầy đủ thông tin");
                        if(txtSP.getSelectedIndex()==0){
                            txtSP.setBorder(canhbao);
                        }else{
                            txtSP.setBorder(null);
                        }
                        if(txtLoai.getSelectedIndex()==0){
                            txtLoai.setBorder(canhbao);
                        }else{
                            txtLoai.setBorder(null);
                        }
                        if(txtCL.getSelectedIndex()==0){
                            txtCL.setBorder(canhbao);
                        }else{
                            txtCL.setBorder(null);
                        }
                        if(txtDonGia.equals("")){
                            txtDonGia.setBorder(canhbao);
                        }else{
                            txtDonGia.setBorder(null);
                        }
                        if(Integer.parseInt(SoLuong.getValue().toString())==0){
                            SoLuong.setBorder(canhbao);
                        }else{
                            SoLuong.setBorder(null);
                        }
                    }else{
                        dtm = new DefaultTableModel();
                        cthdDTO = new ChiTietHoaDonDTO();             

                        cthdDTO.setMahd(String.valueOf(maHoaDon));
                        cthdDTO.setMasp(txtSP.getSelectedItem().toString());
                        cthdDTO.setMaloai(txtLoai.getSelectedItem().toString());
                        cthdDTO.setMacl(txtCL.getSelectedItem().toString());
                        cthdDTO.setDongia(txtDonGia.getText());
                        cthdDTO.setSoluong(String.valueOf(SoLuong.getValue()));

                        if(message()){

                            int check = cthdBUS.insertChiTietHoaDon(cthdDTO);
                            if(check!=0){
                                JOptionPane.showMessageDialog(null, "Thành công");
                                tableChiTiet.setModel(dtm);
                                dtm.setRowCount(0);
                                setDataTable(cthdBUS.getDSChiTiet(maHoaDon));

                                txtSP.setSelectedIndex(0);
                                txtLoai.setSelectedIndex(0);
                                txtCL.setSelectedIndex(0);
                                txtDonGia.setText("");
                                SoLuong.setValue(0);
                                txtThanhTien.setText("Thành tiền: ");
                                cthdBUS.getTong(maHoaDon);
                            }else{
                                JOptionPane.showMessageDialog(null, "Thất bại khi kết nối với cơ sở dữ liệu");
                            }   
                        }
                    }                  
                }     
            }          
        });
        
        editBtn.addMouseListener(new MouseAdapter() {
            DefaultTableModel tblModel = (DefaultTableModel)tableChiTiet.getModel();
            
            @Override
            public void mouseClicked(MouseEvent e) {
                cthdDTO = new ChiTietHoaDonDTO();
                
                if(tableChiTiet.getSelectedRowCount() == 1){
                    
                    int macthd = Integer.valueOf(String.valueOf(tableChiTiet.getValueAt(tableChiTiet.getSelectedRow(), 0)));
                    cthdDTO.setMacthd(macthd);
                    cthdDTO.setMahd(String.valueOf(maHoaDon));
                    cthdDTO.setMasp(txtSP.getSelectedItem().toString());
                    cthdDTO.setMaloai(txtLoai.getSelectedItem().toString());
                    cthdDTO.setMacl(txtCL.getSelectedItem().toString());
                    cthdDTO.setDongia(txtDonGia.getText());
                    cthdDTO.setSoluong(String.valueOf(SoLuong.getValue()));
                    
                    if(message()){
                        int check = cthdBUS.updateHoaDon(cthdDTO);
                        if(check!=0){
                            JOptionPane.showMessageDialog(null, "Thành công");
                            
                            setTable(maHoaDon);
                            cthdBUS.getTong(maHoaDon);
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
                dtm = new DefaultTableModel();

                int row = tableChiTiet.getSelectedRow();
                if(row == -1){
                    JOptionPane.showMessageDialog(null,"Vui lòng chọn dòng cần xóa !","Lỗi",JOptionPane.ERROR_MESSAGE);
                }else{
                    int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa!");
                    if(confirm == JOptionPane.YES_OPTION){
                        int macthd = Integer.valueOf(String.valueOf(tableChiTiet.getValueAt(row, 0)));
                
                        int check = cthdBUS.deleteChiTietHoaDon(macthd);
                        if(check!=0){
                            JOptionPane.showMessageDialog(null, "Thành công");
                            dtm.setRowCount(0);
                            cthdBUS.getTong(maHoaDon);
                    setDataTable(cthdBUS.getDSChiTiet(maHoaDon));
                }
            }
        }
       
            }   
        });
        
        
        tableChiTiet.addMouseListener(new MouseAdapter() {
 
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 1 && tableChiTiet.getSelectedRow()!= -1){
                    int row = tableChiTiet.getSelectedRow();

                    cthdDTO = new ChiTietHoaDonDTO();
                    int macthd = Integer.valueOf(String.valueOf(tableChiTiet.getValueAt(row, 0)));
                    cthdDTO.setMacthd(macthd);
                    cthdDTO.setMasp(dtm.getValueAt(row, 1).toString());
                    cthdDTO.setMaloai(dtm.getValueAt(row,2).toString());
                    cthdDTO.setMacl(dtm.getValueAt(row, 3).toString());
                    cthdDTO.setDongia(dtm.getValueAt(row, 4).toString());
                    cthdDTO.setSoluong(dtm.getValueAt(row, 5).toString());
                    cthdDTO.setTongtien(dtm.getValueAt(row, 6).toString());

                    txtSP.setSelectedItem(cthdDTO.getMasp());
                    txtLoai.setSelectedItem(cthdDTO.getMaloai());
                    txtCL.setSelectedItem(cthdDTO.getMacl());
                    txtDonGia.setText(cthdDTO.getDongia());
                    SoLuong.setValue(Integer.parseInt(cthdDTO.getSoluong()));
                    txtThanhTien.setText("Thành tiền: "+cthdDTO.getTongtien());
                        }
               
               
            }
        });
        
        tableHoaDon.addMouseListener(new MouseAdapter() {
            
            DefaultTableModel tblModel = (DefaultTableModel)tableHoaDon.getModel();
            
            @Override
            public void mouseClicked(MouseEvent e) {

                maHoaDon =  Integer.parseInt(tblModel.getValueAt(tableHoaDon.getSelectedRow(), 0).toString());
                       tableChiTiet.setModel(dtm);
        //Tao cac cot
        dtm.setColumnCount(0);
        dtm.setRowCount(0);
        
        txtSP.setSelectedIndex(0);
        txtLoai.setSelectedIndex(0);
        txtCL.setSelectedIndex(0);
        txtDonGia.setText("");
        SoLuong.setValue(0);
        txtThanhTien.setText("Thành tiền: ");
        
        //Them du lieu vao bang
        setTable(maHoaDon);
            }        
        });
        
        exportExcelBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                if(tableHoaDon.getSelectedRow()<-1){
                    JOptionPane.showMessageDialog(null, "Hãy chọn một hóa đơn!");
                }  
                else{
                    JFileChooser excelFileChooser = new JFileChooser("C:\\Users\\Windows 10\\Desktop");
                
                excelFileChooser.setDialogTitle("Save As");
                DefaultTableModel table = (DefaultTableModel) tableChiTiet.getModel();
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
                        excelCell.setCellValue("Mã Hóa Đơn: "+maHoaDon);
                        
                        excelRow = excelSheet.createRow(1);
                        excelCell = excelRow.createCell(0,CellType.STRING);
                        excelCell.setCellValue("ID");
                        excelCell = excelRow.createCell(1,CellType.STRING);
                        excelCell.setCellValue("MaSP");
                        excelCell = excelRow.createCell(2,CellType.STRING);
                        excelCell.setCellValue("MaLoai");
                        excelCell = excelRow.createCell(3,CellType.STRING);
                        excelCell.setCellValue("MACL");
                        excelCell = excelRow.createCell(4,CellType.STRING);
                        excelCell.setCellValue("Đơn giá");
                        excelCell = excelRow.createCell(5,CellType.STRING);
                        excelCell.setCellValue("Số lượng ");
                        excelCell = excelRow.createCell(6,CellType.STRING);
                        excelCell.setCellValue("Thành tiền");
                        
                        for(int i =0 ;i<table.getRowCount();i++){
                            excelRow = excelSheet.createRow(i+2);
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
                
            }
        });
        
        importExcelBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(tableHoaDon.getSelectedRow()<-1){
                    JOptionPane.showMessageDialog(null, "Hãy chọn một hóa đơn!");
                }  else{
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
 
                        for (int row = 2; row<=excelSheet.getLastRowNum();row++) {
                            XSSFRow excelRow = excelSheet.getRow(row);

                            XSSFCell excelMaSP = excelRow.getCell(1);
                            XSSFCell excelMaLoai = excelRow.getCell(2);
                            XSSFCell excelMaCL = excelRow.getCell(3);
                            XSSFCell excelDonGia = excelRow.getCell(4);
                            XSSFCell excelSoLuong = excelRow.getCell(5);
 
                            cthdDTO = new ChiTietHoaDonDTO();
                            cthdDTO.setMahd(String.valueOf(maHoaDon));
                            cthdDTO.setMasp(excelMaSP.toString());
                            cthdDTO.setMaloai(excelMaLoai.toString());
                            cthdDTO.setMacl(excelMaCL.toString());
                            cthdDTO.setDongia(excelDonGia.toString());
                            cthdDTO.setSoluong(excelSoLuong.toString());
                            
                            cthdBUS = new ChiTietHoaDonBUS();
                            cthdBUS.insertChiTietHoaDon(cthdDTO);
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
                setDataTable(cthdBUS.getDSChiTiet(maHoaDon));
                cthdBUS.getTong(maHoaDon);
                }     
            }           
            
        });
        
    }
    
    private boolean message(){
        int Check = JOptionPane.showConfirmDialog(null, "Bạn muốn cập nhật dữ liệu?","Thông báo",JOptionPane.YES_NO_OPTION);
        return Check == JOptionPane.YES_NO_OPTION;
    }
    
    private void setTextTable(JTextField text,int id,DefaultTableModel tblModel){
        text.setText(tblModel.getValueAt(tableChiTiet.getSelectedRow(), id).toString());
    }
}
