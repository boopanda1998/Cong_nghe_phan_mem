/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BUS.NhanVienBUS;
import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import javax.swing.JFileChooser;

import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Min-NvT
 */
public class QuanLyNhanVienController {
    private JTable Jtb;
    private JButton BtnSua;
    private JButton BtnXoa;
    private JButton BtnCapNhat;
    private JButton BtnXuatExcel;
    private JButton BtnNhapExcel;
    private JButton BtnThem;
    private JButton BtnTimKiem;
    private JLabel JlbThongBao;
    private JPanel JpnTable;
    boolean khoa = false;
    private JTextField JtfMaNhanVien, JtfHoNhanVien, JtfTenNhanVien, JtfNgaySinh, JtfDiaChi, JtfTimKiem,JtfSdt;
    private JComboBox JcbGioiTinh;
    private ClassTableModel classTableModel = null;
    private final String[] COLUMNS = {"Mã nhân viên", "Họ", "Tên", "Giới tính", "Ngày Sinh", "Địa chỉ", "Sdt"};
    private NhanVienBUS nhanVienBUS = null;
    private TableRowSorter<TableModel> rowSorter = null;

    public QuanLyNhanVienController(JTable Jtb, JPanel JpnTable, JButton BtnThem, JButton BtnSua, JButton BtnXoa, JButton BtnCapNhat, 
            JButton BtnXuatExcel, JTextField JtfTimKiem, JButton BtnTimKiem, JTextField JtfMaNhanVien, JTextField JtfHoNhanVien,
            JTextField JtfTenNhanVien, JComboBox JcbGioiTinh, JTextField JtfNgaySinh, JTextField JtfDiaChi,  JLabel JlbThongBao, 
            JButton BtnNhapExcel, JTextField JtfSdt) {
        this.Jtb=Jtb;
        this.JpnTable = JpnTable;
        this.BtnThem = BtnThem;
        this.BtnSua = BtnSua;
        this.BtnXoa = BtnXoa;
        this.BtnCapNhat = BtnCapNhat;
        this.BtnXuatExcel = BtnXuatExcel;
        this.JtfTimKiem = JtfTimKiem;
        this.BtnTimKiem = BtnTimKiem;
        this.JtfMaNhanVien = JtfMaNhanVien;
        this.JtfHoNhanVien = JtfHoNhanVien;
        this.JtfTenNhanVien = JtfTenNhanVien;
        this.JcbGioiTinh = JcbGioiTinh;
        this.JtfNgaySinh = JtfNgaySinh;
        this.JtfDiaChi = JtfDiaChi;
        this.JlbThongBao = JlbThongBao;
        this.BtnNhapExcel = BtnNhapExcel;
        this.JtfSdt = JtfSdt;
        this.classTableModel = new ClassTableModel();
        this.nhanVienBUS = new NhanVienBUS();
    }

    public QuanLyNhanVienController() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public class ClassTableModel {

        public DefaultTableModel setTableNhanVien(ArrayList<NhanVienDTO> listItem, String[] listColumn) {
            int columns = listColumn.length;
            DefaultTableModel dtm = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return false;
                }

                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnIndex == 7 ? Boolean.class : String.class;
                }
            };
            dtm.setColumnIdentifiers(listColumn);
            Object[] obj;
            int num = listItem.size();
            NhanVienDTO nhanVienDTO = null;
            for (int i = 0; i < num; i++) {
                nhanVienDTO = listItem.get(i);
                obj = new Object[columns];
               
                obj[0] = nhanVienDTO.getManv();
                obj[1] = nhanVienDTO.getHo();
                obj[2] = nhanVienDTO.getTen();
                obj[3] = nhanVienDTO.getGioitinh();
                obj[4] = nhanVienDTO.getNgaysinh();
                obj[5] = nhanVienDTO.getDiachi();
                obj[6] = nhanVienDTO.getSdt();
                dtm.addRow(obj);
               
            }
            return dtm;
        }

        DefaultTableModel setTableNhanVien(ArrayList<NhanVienDTO> listItem, ArrayList<String> COLUMNS) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    public void setDataToTable() {
        ArrayList<NhanVienDTO> listItem = NhanVienBUS.getList();
        DefaultTableModel model = classTableModel.setTableNhanVien(listItem, COLUMNS);
        //JTable table = new JTable(model);
        
        Jtb.setModel(model);
        Jtb.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        Jtb.getTableHeader().setPreferredSize(new Dimension(100, 50));
        Jtb.getTableHeader().setBackground(Color.red);
        // table.getTableHeader().setBorder();
        Jtb.getTableHeader().setBackground(new Color(232, 57, 99));
        Jtb.getTableHeader().setForeground(Color.WHITE);
        Jtb.setSelectionBackground(new Color(52, 152, 219));
        Jtb.setRowHeight(50);
        Jtb.validate();
        Jtb.repaint();
        Jtb.getColumnModel().getColumn(0).setMaxWidth(100);
        Jtb.getColumnModel().getColumn(0).setMinWidth(90);
        Jtb.getColumnModel().getColumn(0).setPreferredWidth(40);
        Jtb.getColumnModel().getColumn(1).setMaxWidth(100);
        Jtb.getColumnModel().getColumn(1).setMinWidth(60);
        Jtb.getColumnModel().getColumn(1).setPreferredWidth(40);
        Jtb.getColumnModel().getColumn(2).setMaxWidth(100);
        Jtb.getColumnModel().getColumn(2).setMinWidth(40);
        Jtb.getColumnModel().getColumn(2).setPreferredWidth(40);
        Jtb.getColumnModel().getColumn(3).setMaxWidth(100);
        Jtb.getColumnModel().getColumn(3).setMinWidth(40);
        Jtb.getColumnModel().getColumn(3).setPreferredWidth(40);
        Jtb.getColumnModel().getColumn(4).setMaxWidth(100);
        Jtb.getColumnModel().getColumn(4).setMinWidth(40);
        Jtb.getColumnModel().getColumn(4).setPreferredWidth(40);
        Jtb.getColumnModel().getColumn(5).setMaxWidth(160);
        Jtb.getColumnModel().getColumn(5).setMinWidth(40);
        Jtb.getColumnModel().getColumn(5).setPreferredWidth(40);
        Jtb.getColumnModel().getColumn(6).setMaxWidth(100);
        Jtb.getColumnModel().getColumn(6).setMinWidth(40);
        Jtb.getColumnModel().getColumn(6).setPreferredWidth(40);
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(Jtb);

        scroll.setPreferredSize(new Dimension(1100, 500));
        JpnTable.removeAll();
        Jtb.removeAll();
        JpnTable.setLayout(new CardLayout());
        Jtb.setLayout(new CardLayout());
        JpnTable.add(scroll);

        JpnTable.validate();
        Jtb.validate();
        JpnTable.repaint();
        Jtb.repaint();
        rowSorter = new TableRowSorter<>(Jtb.getModel());
        Jtb.setRowSorter(rowSorter);
        BtnThem.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    if (!ncheckNotNull()) {
                        JtfMaNhanVien.setEditable(true);
                        if (!checkNotNull()) {

                            JlbThongBao.setText("Nhập thông tin nhân viên!");
                        }
                        JlbThongBao.setText("thiếu thông tin hay thông tin quá dài!");
                    } else {
                        System.out.println("Kiem tra ma nhan vien da dc them vao dto chua--" + JtfMaNhanVien.getText());
                        NhanVienDTO nhanVienDTO = new NhanVienDTO();
                        if(JtfMaNhanVien.getText() == ""){
                            String manv="NV009";
                                    String[] i = manv.split("V");
                                   String i1 = i[1];
                                   int a = Integer.parseInt(i1);                                
                            nhanVienDTO.setManv("NV"+ a++);
                               
                                }else{
                        nhanVienDTO.setManv("NV"+JtfMaNhanVien.getText());
                        };
                        nhanVienDTO.setHo(JtfHoNhanVien.getText());
                        nhanVienDTO.setTen(JtfTenNhanVien.getText());
                        nhanVienDTO.setGioitinh(JcbGioiTinh.getSelectedItem().toString());
                        nhanVienDTO.setNgaysinh(JtfNgaySinh.getText());                       
                        nhanVienDTO.setDiachi(JtfDiaChi.getText());
                        nhanVienDTO.setSdt(JtfSdt.getText());
                        nhanVienDTO.setTrangthai("1");
                        if (YesOrNo()) {
                            int KiemTra = nhanVienBUS.Insert(nhanVienDTO);
                            if (KiemTra != 0) {
                                listItem.add(nhanVienDTO);
                                showResult();
                                JlbThongBao.setText("Thêm thành công.");
                                khoa = false;
                            } else {
                                JlbThongBao.setText("Thêm thất bại");
                            }
                        } else {
                            JlbThongBao.setText("Thao tác thêm đã bị hủy.");
                        }
                    }
                } catch (Exception ex) {
                    JlbThongBao.setText("Kiểm tra lỗi.");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            private void showResult() {
                {
                    NhanVienDTO s = listItem.get(listItem.size() - 1);
                    model.addRow(new Object[]{
                        s.getManv(), s.getHo(), s.getTen(), s.getGioitinh(), s.getNgaysinh(),s.getDiachi(),  s.getSdt()

                    });
                }
            }
        });

        BtnXoa.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e) {
                try {
                    
                    if (!checkNotNull()) {

                        JlbThongBao.setText("Vui lòng chọn 1 dòng để xóa dữ liệu!");
                    } else {
                        NhanVienDTO nhanVienDTO = new NhanVienDTO();
                        nhanVienDTO.setManv(JtfMaNhanVien.getText());
                        nhanVienDTO.setHo(JtfHoNhanVien.getText());
                        nhanVienDTO.setTen(JtfTenNhanVien.getText());
                        nhanVienDTO.setGioitinh(JcbGioiTinh.getSelectedItem().toString());
                        nhanVienDTO.setNgaysinh(JtfNgaySinh.getText());
                        nhanVienDTO.setDiachi(JtfDiaChi.getText());
                        nhanVienDTO.setSdt(JtfSdt.getText());
                        if (YesOrNo()) {
                            int KiemTra = nhanVienBUS.Delete(nhanVienDTO);
                            if (KiemTra != 0) {
                                JlbThongBao.setText("xóa thành công.");
                                int i = Jtb.getSelectedRow();
                                if (i >= 0) {
                                    model.setValueAt(JtfMaNhanVien.getText(), i, 0);
                                    model.setValueAt(JtfHoNhanVien.getText(), i, 1);
                                    model.setValueAt(JtfTenNhanVien.getText(), i, 2);
                                    model.setValueAt(JcbGioiTinh.getSelectedItem().toString(), i, 3);
                                    model.setValueAt(JtfNgaySinh.getText(), i, 4);
                                    model.setValueAt(JtfDiaChi.getText(), i, 5);
                                    model.setValueAt(JtfSdt.getText(), i, 6);
                                    
                                    model.removeRow(i);
                                    Jtb.setModel(model);
                                    Jtb.setModel(model);
                                    JlbThongBao.setText("Xóa thành công.");
                                
                                    //table.setModel(model);
                                    Jtb.setModel(model);
                                }
                            } else {
                                JlbThongBao.setText("Lỗi!Xóa");
                            }
                        } else {
                            JlbThongBao.setText("Thao tác đã hủy");
                        }
                    }
                } catch (Exception ex) {
                    JlbThongBao.setText("Kiểm tra kết nối.");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

        });
        BtnSua.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    if (!ncheckNotNull()) {
                        if (!checkNotNull()) {
                            JlbThongBao.setText("Nhập thông tin nhân viên!");
                        }
                        JlbThongBao.setText("thiếu thông tin hay thông tin quá dài!");
                    }
                    if (!checkNotNull()) {

                        JlbThongBao.setText("Vui lòng chọn 1 dòng để cập nhật dữ liệu!");
                    } else {
                        NhanVienDTO nhanVienDTO = new NhanVienDTO();
                        nhanVienDTO.setManv(JtfMaNhanVien.getText());
                        nhanVienDTO.setHo(JtfHoNhanVien.getText());
                        nhanVienDTO.setTen(JtfTenNhanVien.getText());
                        nhanVienDTO.setGioitinh(JcbGioiTinh.getSelectedItem().toString());
                        nhanVienDTO.setNgaysinh(JtfNgaySinh.getText());
                        nhanVienDTO.setDiachi(JtfDiaChi.getText());
                        nhanVienDTO.setSdt(JtfSdt.getText());
                        if (YesOrNo()) {
                            int KiemTra = nhanVienBUS.Update(nhanVienDTO);
                            if (KiemTra != 0) {
                                JlbThongBao.setText("Sửa thành công.");
                                int i = Jtb.getSelectedRow();
                                if (i >= 0) {
                                    model.setValueAt(JtfMaNhanVien.getText(), i, 0);
                                    model.setValueAt(JtfHoNhanVien.getText(), i, 1);
                                    model.setValueAt(JtfTenNhanVien.getText(), i, 2);
                                    model.setValueAt(JcbGioiTinh.getSelectedItem().toString(), i, 3);
                                    model.setValueAt(JtfNgaySinh.getText(), i, 4);
                                    model.setValueAt(JtfDiaChi.getText(), i, 5);
                                    model.setValueAt(JtfSdt.getText(), i, 6);
                                    //table.setModel(model);
                                    Jtb.setModel(model);
                                }
                            } else {
                                JlbThongBao.setText("Lỗi!Sửa");
                            }
                        } else {
                            JlbThongBao.setText("Thao tác đã hủy");
                        }
                    }
                } catch (Exception ex) {
                    JlbThongBao.setText("Kiểm tra kết nối.");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }
        });
        BtnXuatExcel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    XSSFWorkbook workbook = new XSSFWorkbook();
                    XSSFSheet spreadsheet = workbook.createSheet("Nhân viên");
                    XSSFRow row = null;
                    Cell cell = null;
                    row = spreadsheet.createRow((short) 2);
                    row.setHeight((short) 500);
                    cell = row.createCell(0, CellType.STRING);
                    cell.setCellValue("Danh sách nhân viên");
                    row = spreadsheet.createRow((short) 3);
                    row.setHeight((short) 500);
                    cell = row.createCell(0, CellType.STRING);
                    cell.setCellValue("STT");
                    cell = row.createCell(1, CellType.STRING);
                    cell.setCellValue("Mã nhân viên");
                    cell = row.createCell(2, CellType.STRING);
                    cell.setCellValue("Họ nhân viên");
                    cell = row.createCell(3, CellType.STRING);
                    cell.setCellValue("Tên nhân viên");
                    cell = row.createCell(4, CellType.STRING);
                    cell.setCellValue("Giới tính");
                    cell = row.createCell(5, CellType.STRING);
                    cell.setCellValue("Ngày sinh");
                    cell = row.createCell(6, CellType.STRING);
                    cell.setCellValue("Địa chỉ");
                     cell = row.createCell(7, CellType.STRING);
                    cell.setCellValue("SDT");
                    java.util.List<NhanVienDTO> listItem = NhanVienDAO.getList();
                    for (int i = 0; i < listItem.size(); i++) {
                        NhanVienDTO nhanvien = listItem.get(i);
                        row = spreadsheet.createRow((short) 4 + i);
                        row.setHeight((short) 400);
                        row.createCell(0).setCellValue(i + 1);
                        row.createCell(1).setCellValue(nhanvien.getManv());
                        row.createCell(2).setCellValue(nhanvien.getHo());
                        row.createCell(3).setCellValue(nhanvien.getTen());
                        row.createCell(4).setCellValue(nhanvien.getGioitinh());
                        row.createCell(5).setCellValue(nhanvien.getNgaysinh());
                        row.createCell(6).setCellValue(nhanvien.getDiachi());
                        row.createCell(7).setCellValue(nhanvien.getSdt());
                    }
                    JFileChooser fileChooser = new JFileChooser();
                    FileNameExtensionFilter xlsx = new FileNameExtensionFilter("xlsx", "xlsx");
                    fileChooser.setFileFilter(xlsx);
                    fileChooser.setMultiSelectionEnabled(false);
                    int x = fileChooser.showDialog(BtnXuatExcel, "chọn file");
                    if (x == JFileChooser.APPROVE_OPTION) {
                        File f = fileChooser.getSelectedFile();
                        FileOutputStream out = new FileOutputStream(f);
                        workbook.write(out);
                        out.close();
                    }
                    JlbThongBao.setText("Đã xuất file Excel.");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JlbThongBao.setText("Không xuất được file Excel.");
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
        });
          BtnNhapExcel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    JFileChooser fileChooser = new JFileChooser();
                    FileNameExtensionFilter xlsx = new FileNameExtensionFilter("xlsx", "xlsx");
                    fileChooser.setFileFilter(xlsx);
                    fileChooser.setMultiSelectionEnabled(false);
                    int x = fileChooser.showDialog(BtnNhapExcel, "chọn file");
                    File f = fileChooser.getSelectedFile();
                    FileInputStream excelFile = new FileInputStream(f);
                    Workbook workbook = new XSSFWorkbook(excelFile);
                    Sheet datatypeSheet = workbook.getSheetAt(0);
                    DataFormatter fmt = new DataFormatter();
                    Iterator<Row> iterator = datatypeSheet.iterator();
                    Row firstRow = iterator.next();
                    Cell secondCell = firstRow.getCell(0);
                    System.out.println(secondCell.getStringCellValue());
                    java.util.List<NhanVienDTO> DSNhanVienDTO = new ArrayList<NhanVienDTO>();
                    while (iterator.hasNext()) {
                        Row currentRow = iterator.next();
                        NhanVienDTO nhanVienDTO = new NhanVienDTO();
                        nhanVienDTO.setManv(currentRow.getCell(1).getStringCellValue());
                        nhanVienDTO.setHo(currentRow.getCell(2).getStringCellValue());
                        nhanVienDTO.setTen(currentRow.getCell(3).getStringCellValue());
                        nhanVienDTO.setGioitinh(currentRow.getCell(4).getStringCellValue());
                        nhanVienDTO.setNgaysinh(currentRow.getCell(5).getStringCellValue());
                        nhanVienDTO.setDiachi(currentRow.getCell(6).getStringCellValue());
                        nhanVienDTO.setSdt(currentRow.getCell(7).getStringCellValue());
                        DSNhanVienDTO.add(nhanVienDTO);
                    }
                    for (NhanVienDTO nhanVienDTO : DSNhanVienDTO) {
                        NhanVienBUS nhanVienBUS = new NhanVienBUS();
                        nhanVienBUS.Insert(nhanVienDTO);
                        listItem.add(nhanVienDTO);
                        showResult();
                    }
                    workbook.close();
                    JlbThongBao.setText("Đã Nhập file Excel.");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JlbThongBao.setText("Không Nhập được file Excel.");
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            private void showResult() {
                {
                    NhanVienDTO s = listItem.get(listItem.size() - 1);// lay file cuoi cung de hien thi
                    model.addRow(new Object[]{
                        s.getManv(), s.getHo(), s.getTen(), s.getGioitinh(), s.getNgaysinh(),  s.getDiachi(),s.getSdt()
                    });
                }
            }
        });
        BtnTimKiem.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                String text = JtfTimKiem.getText();
                //rowSorter.setRowFilter(RowFilter.regexFilter(text.replaceAll("\\s+", " ")));
                
                
                
            }
            
        });
        JtfTimKiem.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = JtfTimKiem.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = JtfTimKiem.getText();
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
        BtnCapNhat.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JtfMaNhanVien.setEditable(true);
                khoa = true;
                JtfMaNhanVien.setText("");
                JtfHoNhanVien.setText("");
                JtfTenNhanVien.setText("");
                JtfNgaySinh.setText("");              
                JtfDiaChi.setText("");
                JtfSdt.setText("");
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }
        });

        Jtb.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && Jtb.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) Jtb.getModel();
                    int selectedRowIndex = Jtb.getSelectedRow();
                    selectedRowIndex = Jtb.convertRowIndexToModel(selectedRowIndex);
                    NhanVienDTO nhanVienDTO = new NhanVienDTO();
                    nhanVienDTO.setManv(model.getValueAt(selectedRowIndex, 0).toString());
                    nhanVienDTO.setHo(model.getValueAt(selectedRowIndex, 1).toString());
                    nhanVienDTO.setTen(model.getValueAt(selectedRowIndex, 2).toString());
                    nhanVienDTO.setGioitinh(model.getValueAt(selectedRowIndex, 3).toString());
                    nhanVienDTO.setNgaysinh(model.getValueAt(selectedRowIndex, 4).toString());
                    nhanVienDTO.setDiachi(model.getValueAt(selectedRowIndex, 5).toString());
                    nhanVienDTO.setSdt(model.getValueAt(selectedRowIndex, 6).toString());
                    JtfMaNhanVien.setText("" + nhanVienDTO.getManv());
                    JtfMaNhanVien.setEditable(false);
                    JtfHoNhanVien.setText(nhanVienDTO.getHo());
                    JtfTenNhanVien.setText(nhanVienDTO.getTen());
                    JcbGioiTinh.setSelectedItem(nhanVienDTO.getGioitinh());
                    JtfNgaySinh.setText(nhanVienDTO.getNgaysinh());
                    JtfDiaChi.setText(nhanVienDTO.getDiachi());
                    JtfSdt.setText(nhanVienDTO.getSdt());
                    JlbThongBao.setText("Thông tin nhân viên.");
                }
            }
        });

    }

    /* public void chonfile(int i){     
            JFileChooser fileChooser =new JFileChooser();
        FileNameExtensionFilter xlsx =new FileNameExtensionFilter("file excel","xlsx");
        fileChooser.setFileFilter(xlsx);
        fileChooser.setMultiSelectionEnabled(false);
        int x =fileChooser.showDialog(i,"chọn file");
        if (x == JFileChooser.APPROVE_OPTION)
        {
            File f =fileChooser.getSelectedFile();
            
        }
            }
     */
    public void setEvent() {
    }

    private boolean checkNotNull() {
        return JtfMaNhanVien.getText() != null
                && !JtfMaNhanVien.getText().equalsIgnoreCase("");
    }

    public boolean ncheckNotNull() {

        boolean kiemTra;
        if (JtfMaNhanVien.getText().isEmpty()) {
            JtfMaNhanVien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 50), 1));
            kiemTra = false;
        } else {
            if (JtfMaNhanVien.getText().length() > 10) {
                //JlbTB.setText("Mã khách hàng quá 10 ký tự");
                kiemTra = false;
            } else {
                JtfMaNhanVien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
                //JlbTB.setText("");
                kiemTra = true;
            }
        }
        if (JtfHoNhanVien.getText().isEmpty()) {
            JtfHoNhanVien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 50), 1));
            kiemTra = false;
        } else {
            if (JtfHoNhanVien.getText().length() > 10) {
                //JlbTB.setText("Quá dài");
                kiemTra = false;
            } else {
                JtfHoNhanVien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
                //JlbTB.setText("");
                kiemTra = true;
            }
        }
        if (JtfTenNhanVien.getText().isEmpty()) {
            JtfTenNhanVien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 50), 1));
            kiemTra = false;
        } else {
            if (JtfTenNhanVien.getText().length() > 10) {
                //JlbTB.setText("Quá dài");
                kiemTra = false;
            } else {
                JtfTenNhanVien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
                //JlbTB.setText("");
                kiemTra = true;
            }
        }
       
        if (JtfDiaChi.getText().isEmpty()) {
            JtfDiaChi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 50), 1));
            kiemTra = false;
        } else {
            if (JtfDiaChi.getText().length() > 10) {
                //JlbTB.setText("Quá dài");
                kiemTra = false;
            } else {
                JtfDiaChi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
                //JlbTB.setText("");
                kiemTra = true;
            }
        }
        if (JtfNgaySinh.getText().isEmpty()) {
            JtfNgaySinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 50), 1));
            kiemTra = false;
        } else {
            if (JtfNgaySinh.getText().length() > 10) {
                //JlbTB.setText("Quá dài");
                kiemTra = false;
            } else {
                JtfNgaySinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
                //JlbTB.setText("");
                kiemTra = true;
            }
        }
       
                if (JtfSdt.getText().isEmpty()) {
            JtfSdt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 50), 1));
            kiemTra = false;
        } else {
            if ((JtfSdt.getText().length() < 9) && (JtfSdt.getText().length() > 11)) {
                //JlbTB.setText("Quá dài");
                kiemTra = false;
            } else {
                JtfSdt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
                //JlbTB.setText("");
                kiemTra = true;
            }
        }
       
        return kiemTra;

    }

    private boolean YesOrNo() {
        int YesOrNo = JOptionPane.showConfirmDialog(null,
                "Bạn muốn cập nhật dữ liệu hay không?", "Thông Báo", JOptionPane.YES_NO_OPTION);
        return YesOrNo == JOptionPane.YES_NO_OPTION;
    }

  

}
