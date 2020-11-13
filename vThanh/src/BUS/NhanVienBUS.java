/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
/**
 *
 * @author Min-NvT
 */
import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.util.ArrayList;
 
public class NhanVienBUS {
    
    private NhanVienDAO nhanVienDAO = null;
    private Iterable<NhanVienDTO> list;

    public NhanVienBUS() {
        this.nhanVienDAO = new NhanVienDAO();
    }
   /* public NhanVienBUS()
    {
        
    }*/
  /* public NhanVienDTO get(String manv)
    {
        for(NhanVienDTO nv : getList() )
        {
            if(nv.getManv().equals(manv))
            {
                return nv;
            }
        }
        return null;
    }
 
    public ArrayList<NhanVienDTO> search(String manv,String ho,String ten,String gioitinh)
    {
        ArrayList<NhanVienDTO> search = new ArrayList<>();
        manv = manv.isEmpty()?manv = "": manv;
        ho = ho.isEmpty()?ho = "": ho;
        ten = ten.isEmpty()?ten = "": ten;
        for(NhanVienDTO nv : list)
        {
            if( nv.getManv().contains(manv) && 
                nv.getHo().contains(ho) &&
                nv.getTen().contains(ten) &&
                nv.getGioitinh().contains(gioitinh))
            {
                search.add(nv);
            }
        }
        return search;
    }
   */


    public static ArrayList<NhanVienDTO> getList(){
        return NhanVienDAO.getList();
    }
    public int Insert(NhanVienDTO nhanVienDTO){
        return NhanVienDAO.Insert(nhanVienDTO);
    }
    public int Delete(String manv){
        return NhanVienDAO.Delete(manv);
    }
    
    public int Update(NhanVienDTO nhanVienDTO){
        return NhanVienDAO.Update(nhanVienDTO);
    }
 }

    
    /* BtnXuatExcel.addMouseListener(new MouseAdapter() {
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
                    cell.setCellValue("Lương");
                    cell = row.createCell(8, CellType.STRING);
                    cell.setCellValue("Chức vụ");
                    cell = row.createCell(9, CellType.STRING);
                    cell.setCellValue("Kinh Nghiệm");
                    cell = row.createCell(10, CellType.STRING);
                    cell.setCellValue("Phòng Ban");
                    cell = row.createCell(11, CellType.STRING);
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
                        row.createCell(7).setCellValue(nhanvien.getLuong());
                        row.createCell(8).setCellValue(nhanvien.getChucvu());
                        row.createCell(9).setCellValue(nhanvien.getKinhnghiem());
                        row.createCell(10).setCellValue(nhanvien.getPhongban());
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
                    Cell firstCell = firstRow.getCell(0);
                    System.out.println(firstCell.getStringCellValue());
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
                        nhanVienDTO.setLuong(currentRow.getCell(7).getStringCellValue());
                        nhanVienDTO.setChucvu(currentRow.getCell(8).getStringCellValue());
                        nhanVienDTO.setKinhnghiem(currentRow.getCell(9).getStringCellValue());
                        nhanVienDTO.setPhongban(currentRow.getCell(10).getStringCellValue());
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
                        s.getManv(), s.getHo(), s.getTen(), s.getGioitinh(), s.getNgaysinh(), s.getChucvu(), s.getLuong(), s.getDiachi(), s.getKinhnghiem(), s.getPhongban()
                    });
                }
            }
        });
        BtnTimKiem.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                String text = JtfTimKiem.getText().trim();
                rowSorter.setRowFilter(RowFilter.regexFilter(text.replaceAll("\\s+", " ")));
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
//*/
