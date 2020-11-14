/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BUS.NhanVienBUS;
import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import GUI.DangKyJDialog;
import GUI.DangNhapJDialog;
import GUI.NhanVienGUI;

import Utility.ClassTableModel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author boopa
 */
public class QuanLyNhanVienController {
 
    private JPanel jpnView;
    private JButton btnThem;
    private JButton btnSua;
    private JButton btnXoa;
    private JButton btnCapNhat;
    private JButton btnThoat;
    private JButton btnNhapExcel;
    private JTextField jtfTimKiem;
    private JButton btnTimKiem;
    private JLabel jlbThongBao;
    boolean khoa = false;
    
    private JTextField jtfManv,jtfHo,jtfTen,jtfNgaysinh,jtfDiachi,jtfLuong;
    private JComboBox jcbGioitinh,jcbChucvu;
    
    private ClassTableModel classTableModel = null;
 
    private final String[] COLUMNS = {"Mã nhân viên", "Họ", "Tên", "Giới tính","Ngày Sinh" , "Chức vụ", "Lương","Địa chỉ"};
 
    private NhanVienBUS nhanVienBUS = null;
 
    private TableRowSorter<TableModel> rowSorter = null;

    public QuanLyNhanVienController(JPanel jpnView, JButton btnThem, JButton btnSua, JButton btnXoa, JButton btnCapNhat, JButton btnThoat, JTextField jtfTimKiem, JButton btnTimKiem, JTextField jtfManv, JTextField jtfHo, JTextField jtfTen,  JComboBox jcbGioitinh, JTextField jtfNgaysinh, JTextField jtfDiachi,JComboBox jcbChucvu, JTextField jtfLuong,JLabel jlbThongBao,JButton btnNhapExcel) {
        this.jpnView = jpnView;
        this.btnThem = btnThem;
        this.btnSua = btnSua;
        this.btnXoa = btnXoa;
        this.btnCapNhat = btnCapNhat;
        this.btnThoat = btnThoat;
        this.jtfTimKiem = jtfTimKiem;
        this.btnTimKiem = btnTimKiem;
        this.jtfManv = jtfManv;
        this.jtfHo = jtfHo;
        this.jtfTen = jtfTen;
        this.jcbGioitinh = jcbGioitinh;
        this.jtfNgaysinh = jtfNgaysinh;
        this.jtfDiachi = jtfDiachi;
        this.jcbChucvu = jcbChucvu;
        this.jtfLuong = jtfLuong;
        this.jlbThongBao = jlbThongBao;
        this.btnNhapExcel = btnNhapExcel;
     
    
        this.classTableModel = new ClassTableModel();
 
        this.nhanVienBUS = new NhanVienBUS();
    }
 ///Button tim kiem them sua xoa thoat cap nhat set event
    public void setDataToTable() {
        ArrayList<NhanVienDTO> listItem = NhanVienBUS.getList();
        DefaultTableModel model = classTableModel.setTableNhanVien(listItem, COLUMNS);
        JTable table = new JTable(model);
 
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        btnTimKiem.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {   
//       TableRowSorter sorter = new TableRowSorter(model);
//       table.setRowSorter(sorter);

           String text = jtfTimKiem.getText().trim();
        
       rowSorter.setRowFilter(RowFilter.regexFilter(text.replaceAll("\\s+"," ")));
      }});
        
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
                              
                    String manv = jtfManv.getText();
                        NhanVienDTO nhanVienDTO = new NhanVienDTO();

                        if(YesOrNo()){
                        
                           int KiemTra = nhanVienBUS.Delete(manv);
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
                        NhanVienDTO nhanVienDTO = new NhanVienDTO();
                        
                        nhanVienDTO.setManv(jtfManv.getText());
                        nhanVienDTO.setHo(jtfHo.getText());
                        nhanVienDTO.setTen(jtfTen.getText());;
                        nhanVienDTO.setGioitinh(jcbGioitinh.getSelectedItem().toString());
                        nhanVienDTO.setNgaysinh(jtfNgaysinh.getText());
                        nhanVienDTO.setLuong(jtfLuong.getText());
                        nhanVienDTO.setDiachi(jtfDiachi.getText());;
                        nhanVienDTO.setChucvu(jcbChucvu.getSelectedItem().toString());
                        
                        //
                        if(YesOrNo()){
                        
                        int KiemTra = nhanVienBUS.Update(nhanVienDTO);
                        if(KiemTra!= 0){
                        jlbThongBao.setText("Sửa thành công.");
                        int  i=table.getSelectedRow();
                            if (i>=0)
                            {
                                model.setValueAt(jtfManv.getText(), i, 0);
                                model.setValueAt(jtfHo.getText(), i, 1);
                                model.setValueAt(jtfTen.getText(), i, 2);
                                model.setValueAt(jcbGioitinh.getSelectedItem().toString(), i, 3);
                                model.setValueAt(jtfNgaysinh.getText(), i, 4);
                                model.setValueAt(jcbChucvu.getSelectedItem().toString(), i, 5);
                                model.setValueAt(jtfLuong.getText(), i, 6);
                                model.setValueAt(jtfDiachi.getText(), i, 7);
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
                        jtfManv.setEditable(true);
                        khoa = true;
                //
                        jtfManv.setText("");
                        jtfHo.setText("");
                        jtfTen.setText("");
//                        jcbGioitinh.setText("");
                        jtfNgaysinh.setText("");
                        jtfLuong.setText("");
                        jtfDiachi.setText("");
//                        jcbChucvu.setText(""); 
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
//                        jtfManv.setEditable(true);
                      
                try {
                        //mo khoa cho phep nhap textfile
                        jtfManv.setEditable(true);
                        
                    if (!checkNotNull()) {
                        jlbThongBao.setText("Vui lòng nhập dữ liệu bắt buộc!");
                    } else {
                        System.out.println("Kiem tra ma nhan vien da dc them vao dto chua--"+jtfManv.getText());
                        
                        //reset du lieu DTO de chuan bi nap du lieu tu textfield
                        NhanVienDTO nhanVienDTO = new NhanVienDTO();
                        
                        nhanVienDTO.setManv(jtfManv.getText());
                        nhanVienDTO.setHo(jtfHo.getText());
                        nhanVienDTO.setTen(jtfTen.getText());;
                        nhanVienDTO.setGioitinh(jcbGioitinh.getSelectedItem().toString());
                        nhanVienDTO.setNgaysinh(jtfNgaysinh.getText());
                        nhanVienDTO.setLuong(jtfLuong.getText());
                        nhanVienDTO.setDiachi(jtfDiachi.getText());;
                        nhanVienDTO.setChucvu(jcbChucvu.getSelectedItem().toString());
                        
                        //
                        if(YesOrNo()){
                        //them du lieu den BUS de truyen len DAO
                        int KiemTra = nhanVienBUS.Insert(nhanVienDTO);
                        if (KiemTra != 0) {
                            //them du lieu vao bang table Arraylist hien thi
                            listItem.add(nhanVienDTO); // them vao danh sach nhan vien
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
                NhanVienDTO s = listItem.get(listItem.size()-1);// lay file cuoi cung de hien thi
                    model.addRow(new Object[]{
                         s.getManv(),s.getHo(),s.getTen(),s.getGioitinh(),s.getNgaysinh(),s.getChucvu(),s.getLuong(),s.getDiachi()
            
                         });
                                    }
                        }
        });
                               
//        btnThoat.addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent e) {
//                        try {
//            XSSFWorkbook workbook = new XSSFWorkbook();
//            XSSFSheet spreadsheet = workbook.createSheet("Nhân viên");
// 
//            XSSFRow row = null;
//            Cell cell = null;
// 
//            row = spreadsheet.createRow((short) 2);
//            row.setHeight((short) 500);
//            cell = row.createCell(0, CellType.STRING);
//            cell.setCellValue("Danh sách nhân viên");
// 
//            row = spreadsheet.createRow((short) 3);
//            row.setHeight((short) 500);
//            cell = row.createCell(0, CellType.STRING);
//            cell.setCellValue("STT");
//            cell = row.createCell(1, CellType.STRING);
//            cell.setCellValue("Mã nhân viên");
//            cell = row.createCell(2, CellType.STRING);
//            cell.setCellValue("Họ nhân viên");
//            cell = row.createCell(3, CellType.STRING);
//            cell.setCellValue("Tên nhân viên");
//            
//            
//            cell = row.createCell(4, CellType.STRING);
//            cell.setCellValue("Giới tính");
//            cell = row.createCell(5, CellType.STRING);
//            cell.setCellValue("Ngày sinh");
//            cell = row.createCell(6, CellType.STRING);
//            cell.setCellValue("Địa chỉ");
//            cell = row.createCell(7, CellType.STRING);
//            cell.setCellValue("Lương");
//            cell = row.createCell(8, CellType.STRING);
//            cell.setCellValue("Chức vụ");
//            cell = row.createCell(9, CellType.STRING);
//            
//            NhanVienBUS khdao = new NhanVienBUS();
//            //HocVienService nhanvienService = new HocVienServiceImpl();
// 
//            java.util.List<NhanVienDTO> listItem = NhanVienDAO.getList();
// 
//            for (int i = 0; i < listItem.size(); i++) {
//                NhanVienDTO nhanvien = listItem.get(i);
//                row = spreadsheet.createRow((short) 4 + i);
//                row.setHeight((short) 400);
//                row.createCell(0).setCellValue(i + 1);
//                row.createCell(1).setCellValue(nhanvien.getManv());
//                row.createCell(2).setCellValue(nhanvien.getHo().toString());
//                row.createCell(3).setCellValue(nhanvien.getTen().toString());
//                row.createCell(4).setCellValue(nhanvien.getGioitinh());
//                row.createCell(5).setCellValue(nhanvien.getNgaysinh());
//                row.createCell(6).setCellValue(nhanvien.getDiachi());
//                row.createCell(7).setCellValue(nhanvien.getLuong());
//                row.createCell(8).setCellValue(nhanvien.getChucvu());
//                
//            }
// 
//            FileOutputStream out = new FileOutputStream(new File("D:/nhanvien.xlsx"));
//            workbook.write(out);
//            out.close();
//            jlbThongBao.setText("Đã xuất file Excel.");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            jlbThongBao.setText("Không xuất đượcfile Excel.");
//        }
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
//        
//        //
//        btnNhapExcel.addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent e) {
//    try {
//      FileInputStream excelFile = new FileInputStream(new File("D:/nhanvien_SQL.xlsx"));
//      Workbook workbook = new XSSFWorkbook(excelFile);
//      Sheet datatypeSheet = workbook.getSheetAt(0);
//      DataFormatter fmt = new DataFormatter();
//      Iterator<Row> iterator = datatypeSheet.iterator();
//      Row firstRow = iterator.next();
//      Cell firstCell = firstRow.getCell(0);
//      
//      System.out.println(firstCell.getStringCellValue());
//      
//      java.util.List<NhanVienDTO> DSNhanVienDTO = new ArrayList<NhanVienDTO>();
//      while (iterator.hasNext()) {
//        Row currentRow = iterator.next();
//        NhanVienDTO nhanVienDTO  = new NhanVienDTO();
//     
//        nhanVienDTO.setManv(currentRow.getCell(1).getStringCellValue());
//        nhanVienDTO.setHo(currentRow.getCell(2).getStringCellValue());
//        nhanVienDTO.setTen(currentRow.getCell(3).getStringCellValue());
//        nhanVienDTO.setGioitinh(currentRow.getCell(4).getStringCellValue());
//        nhanVienDTO.setNgaysinh(currentRow.getCell(5).getStringCellValue());
//        nhanVienDTO.setDiachi(currentRow.getCell(6).getStringCellValue());
//        nhanVienDTO.setLuong(currentRow.getCell(7).getStringCellValue());
//        nhanVienDTO.setChucvu(currentRow.getCell(8).getStringCellValue());
//        
//        DSNhanVienDTO.add(nhanVienDTO);
//      }
//      for (NhanVienDTO nhanVienDTO : DSNhanVienDTO) {
//        NhanVienBUS nhanVienBUS = new NhanVienBUS();
//        nhanVienBUS.Insert(nhanVienDTO);
//        listItem.add(nhanVienDTO); // them vao danh sach nhan vien
//        showResult();// moi lan them goi show de hien thi
//      }
//      workbook.close();
//      jlbThongBao.setText("Đã Nhập file Excel.");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            jlbThongBao.setText("Không Nhập đượcfile Excel.");
//        }
//   
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
//                btnNhapExcel.setBackground(new Color(0, 200, 83));
//            }
// 
//            @Override
//            public void mouseExited(MouseEvent e) {
//                btnNhapExcel.setBackground(new Color(100, 221, 23));
//            }
//                        private void showResult() {
//                                    {
//                NhanVienDTO s = listItem.get(listItem.size()-1);// lay file cuoi cung de hien thi
//                    model.addRow(new Object[]{
//                         s.getManv(),s.getHo(),s.getTen(),s.getNgaysinh(),s.getDiachi(),s.getLuong(),s.getChucvu(),s.getGioitinh()
//            
//                         });
//                                    }
//                        }
//        });
//        

        //table click
     table.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
             if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    //Lay gia trị hang dang chọn
                    int selectedRowIndex = table.getSelectedRow();
                    
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                    //dua du lieu vao DTO
                    NhanVienDTO nhanVienDTO = new NhanVienDTO();
                    nhanVienDTO.setManv(model.getValueAt(selectedRowIndex, 0).toString());
                    nhanVienDTO.setHo(model.getValueAt(selectedRowIndex, 1).toString());
                    nhanVienDTO.setTen(model.getValueAt(selectedRowIndex, 2).toString());
                    nhanVienDTO.setGioitinh(model.getValueAt(selectedRowIndex, 3).toString());
                    nhanVienDTO.setNgaysinh(model.getValueAt(selectedRowIndex, 4).toString());
                    nhanVienDTO.setChucvu(model.getValueAt(selectedRowIndex, 5).toString());
                    nhanVienDTO.setLuong(model.getValueAt(selectedRowIndex, 6).toString());
                    nhanVienDTO.setDiachi(model.getValueAt(selectedRowIndex, 7).toString());
                    
                    //Show du lieu tu DTO ra Textfied
                    jtfManv.setText(""+nhanVienDTO.getManv());
                    jtfManv.setEditable(false);//Khoa text filed k cho nhap du lieu
                    jtfHo.setText(nhanVienDTO.getHo());
                    jtfTen.setText(nhanVienDTO.getTen());
                    jcbGioitinh.setSelectedItem(nhanVienDTO.getGioitinh());
                    jtfNgaysinh.setText(nhanVienDTO.getNgaysinh());
                    jcbChucvu.setSelectedItem(nhanVienDTO.getChucvu());
                    jtfLuong.setText(nhanVienDTO.getLuong());
                    jtfDiachi.setText(nhanVienDTO.getDiachi());
                    //
                    jlbThongBao.setText("Thông tin nhân viên.");
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
        return jtfHo.getText() != null && !jtfHo.getText().equalsIgnoreCase("") 
             &&jtfTen.getText() != null && !jtfTen.getText().equalsIgnoreCase("")
                &&jtfManv.getText() != null && !jtfManv.getText().equalsIgnoreCase("");
             
    }
//kiem tra muon cap nhat hay k
    private boolean YesOrNo() {
        int YesOrNo = JOptionPane.showConfirmDialog(null,
                "Bạn muốn cập nhật dữ liệu hay không?","Thông Báo",JOptionPane.YES_NO_OPTION);
        return YesOrNo == JOptionPane.YES_NO_OPTION;
    }
    

}
