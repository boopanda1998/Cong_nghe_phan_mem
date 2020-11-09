package com.nhacungcap.form;

import java.awt.*;
import java.io.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;

public class NhaCungCapDAO {
    private Connection conn =null;
    public static final int COLUMN_INDEX_ID         = 0;
    public static final int COLUMN_INDEX_TITLE      = 1;
    public static final int COLUMN_INDEX_PRICE      = 2;
    public static final int COLUMN_INDEX_QUANTITY   = 3;
    public static final int COLUMN_INDEX_TOTAL      = 4;
    private static CellStyle cellStyleFormatNumber = null;
    public boolean insertNhaCungCap(NhaCungCapDTO nhaCungCapDTO) throws SQLException {
        String maNhaCungcCap="",tenNhaCungcCap="",diaChiNhaCungcCap="",sdtNhaCungcCap="";
        String str=  "^\\s?((\\+[1-9]{1,4}[ \\-]*)|(\\([0-9]{2,3}\\)[ \\-]*)|([0-9]{2,4})[ \\-]*)*?[0-9]{3,4}?[ \\-]*[0-9]{3,4}?\\s?";
        maNhaCungcCap = nhaCungCapDTO.getStrMaNhaCungCap().toString();
        tenNhaCungcCap = nhaCungCapDTO.getStrTenNhaCungCap().toString();
        diaChiNhaCungcCap = nhaCungCapDTO.getStrDiaChiNhaCungCap().toString();
        sdtNhaCungcCap = nhaCungCapDTO.getStrSdtNhaCungCap().toString();
        if(maNhaCungcCap.isEmpty() || tenNhaCungcCap.isEmpty()||sdtNhaCungcCap.isEmpty()||diaChiNhaCungcCap.isEmpty()){
            JOptionPane.showMessageDialog(new Frame(), "Vui lòng nhập đầy đủ thông tin");
            return false;
        }
        else {
            if (!Pattern.compile(str).matcher(sdtNhaCungcCap).matches()) {
                JOptionPane.showMessageDialog(new Frame(), "SĐT không hợp lệ");
                return false;
            }
            else{
                String sql="insert into nhacungcap(ma_nha_cung_cap,ten_nha_cung_cap,dia_chi_nha_cung_cap,sdt_nha_cung_cap) values (?,?,?,?)";
                conn=DBConnect.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1,maNhaCungcCap);
                stmt.setString(2,tenNhaCungcCap);
                stmt.setString(3,diaChiNhaCungcCap);
                stmt.setString(4,sdtNhaCungcCap);
                try{
                    stmt.execute();
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(new Frame(), "Đã tồn tại mã nhà cung cấp là : '"+maNhaCungcCap+"' !\nVui lòng kiểm tra lại !");
                    return false;
                }
            }
        }
        return true;
    }
    public void deleteNhaCungCap(String MaNhaCungCap) throws SQLException {
        String sql="DELETE FROM nhacungcap WHERE ma_nha_cung_cap='"+MaNhaCungCap+"'";
        conn=DBConnect.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.execute();
        System.out.println("da xoa");
    }
    public void updateNhaCungCap(String ma, String ten, String diachi, String sdt) throws SQLException {
        String sql ="UPDATE nhacungcap SET ten_nha_cung_cap ='"+ten+"' ,dia_chi_nha_cung_cap = '"+diachi+"',sdt_nha_cung_cap ='"+sdt+"' where ma_nha_cung_cap ='"+ma+"'";
        conn=DBConnect.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.execute();
        System.out.println("da update");
    }
    public void xuatDanhSachNhaCungCapFileExcel(String pathName) throws IOException{
        System.out.println("Create file excel");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("DanhSachNhaCungCap");

        int rowNum = 0;
        Row firstRow = sheet.createRow(rowNum++);
        Cell firstCell = firstRow.createCell(0);
        firstCell.setCellValue("Mã nhà cung cấp");
        Cell secondCell = firstRow.createCell(1);
        secondCell.setCellValue("Tên nhà cung cấp");
        Cell thirthCell = firstRow.createCell(2);
        thirthCell.setCellValue("Địa chỉ");
        Cell fouthCell = firstRow.createCell(3);
        fouthCell.setCellValue("SĐT");

        List<NhaCungCapDTO> listOfCustomer = new ArrayList<NhaCungCapDTO>();
//        listOfCustomer.add(new NhaCungCapDTO("ádasd1", "Sylvester Stallone", "abc@gmail.com","0000"));
//        listOfCustomer.add(new NhaCungCapDTO("ádad2", "Tom Cruise", "xyz@yahoo.com","00asd"));
//        listOfCustomer.add(new NhaCungCapDTO("ádasd4", "Vin Diesel", "abc@hotmail.com","ádsad"));
        listOfCustomer = NhaCungCapBUS.layDanhSach();
        for (NhaCungCapDTO customer : listOfCustomer) {
            Row row = sheet.createRow(rowNum++);
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(customer.getStrMaNhaCungCap());
            Cell cell2 = row.createCell(1);
            cell2.setCellValue(customer.getStrTenNhaCungCap());
            Cell cell3 = row.createCell(2);
            cell3.setCellValue(customer.getStrDiaChiNhaCungCap());
            Cell cell4 = row.createCell(3);
            cell4.setCellValue(customer.getStrSdtNhaCungCap());
        }
        try {
            FileOutputStream outputStream = new FileOutputStream(pathName+"\\Danh_Sach_Nha_Cung_cap.xlsx");
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i=0;i<4;i++){
            sheet.autoSizeColumn(i);
        }
        System.out.println("Done");
    }
    public void nhapDanhSachNhaCungCapFileExcel(String pathFile) throws IOException, SQLException {
//        try {
//            FileInputStream excelFile = new FileInputStream(new File(pathFile));
//            Workbook workbook = new XSSFWorkbook(excelFile);
//            Sheet datatypeSheet = workbook.getSheetAt(0);
//            DataFormatter fmt = new DataFormatter();
//            Iterator<Row> iterator = datatypeSheet.iterator();
//                Row firstRow = iterator.next();
//            Cell firstCell = firstRow.getCell(0);
//            System.out.println(firstCell.getStringCellValue());
//            List<NhaCungCapDTO> listOfCustomer = new ArrayList<NhaCungCapDTO>();
//            while (iterator.hasNext()) {
//                Row currentRow = iterator.next();
//                NhaCungCapDTO customer = new NhaCungCapDTO();
//                customer.setStrMaNhaCungCap(currentRow.getCell(0).getStringCellValue());
//                customer.setStrTenNhaCungCap(currentRow.getCell(1).getStringCellValue());
//                customer.setStrDiaChiNhaCungCap(currentRow.getCell(2).getStringCellValue());
//                customer.setStrSdtNhaCungCap(currentRow.getCell(3).getStringCellValue());
//                listOfCustomer.add(customer);
//            }
//            for (NhaCungCapDTO customer : listOfCustomer) {
//                insertNhaCungCap(customer);
//            }
//            workbook.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        // Đọc một file XSL.
        FileInputStream inputStream = new FileInputStream(new File(pathFile));

        // Đối tượng workbook cho file XSL.
        //HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
        Workbook workbook = new XSSFWorkbook(inputStream);


        // Lấy ra sheet đầu tiên từ workbook
       // HSSFSheet sheet = workbook.getSheetAt(0);
        Sheet sheet = workbook.getSheetAt(0);


        // Lấy ra Iterator cho tất cả các dòng của sheet hiện tại.
        Iterator<Row> rowIterator = sheet.iterator();
        List<NhaCungCapDTO> listOfCustomer = new ArrayList<NhaCungCapDTO>();
        while (rowIterator.hasNext()) {
            int j = 5;
            Row row = rowIterator.next();
            if (row.getRowNum() > 0) {
                NhaCungCapDTO customer = new NhaCungCapDTO();
                customer.setStrMaNhaCungCap(row.getCell(0).getStringCellValue().toString());
                customer.setStrTenNhaCungCap(row.getCell(1).getStringCellValue().toString());
                customer.setStrDiaChiNhaCungCap(row.getCell(2).getStringCellValue().toString());
                customer.setStrSdtNhaCungCap(row.getCell(3).getStringCellValue().toString());
                insertNhaCungCap(customer);
            }

        }


//        while (rowIterator.hasNext()) {
//            Row row = rowIterator.next();
//
//            // Lấy Iterator cho tất cả các cell của dòng hiện tại.
//            Iterator<Cell> cellIterator = row.cellIterator();
//
//            while (cellIterator.hasNext()) {
//                Cell cell = cellIterator.next();
//               cell.setCellType(CellType.STRING);
//                // Đổi thành getCellType() nếu sử dụng POI 4.x
//                CellType cellType = cell.getCellTypeEnum();
//
//                Row currentRow = rowIterator.next();
//                NhaCungCapDTO customer = new NhaCungCapDTO();
//                customer.setStrMaNhaCungCap(currentRow.getCell(0).getStringCellValue().toString());
//                customer.setStrTenNhaCungCap(currentRow.getCell(1).getStringCellValue().toString());
//                customer.setStrDiaChiNhaCungCap(currentRow.getCell(2).getStringCellValue().toString());
//                customer.setStrSdtNhaCungCap(currentRow.getCell(3).getStringCellValue().toString());
//                listOfCustomer.add(customer);
//            }
//            for (NhaCungCapDTO customer : listOfCustomer) {
//                insertNhaCungCap(customer);
//            }
//
//            }
            System.out.println("Done");
        }
    }
