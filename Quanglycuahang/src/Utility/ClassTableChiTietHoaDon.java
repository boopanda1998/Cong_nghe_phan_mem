/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import DTO.ChiTietHoaDonDTO;
import DTO.HangHoaDTO;
import DTO.ChiTietPhieuNhapDTO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author boopa
 */
public class ClassTableChiTietHoaDon {
    
    public DefaultTableModel setTableChiTietHoaDon(ArrayList<ChiTietHoaDonDTO> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 7 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        ChiTietHoaDonDTO chiTietHoaDonDTO = null;
        for (int i = 0; i < num; i++) {
            chiTietHoaDonDTO = listItem.get(i);
            obj = new Object[columns];
            obj[0] = chiTietHoaDonDTO.getMahd();
            obj[1] = chiTietHoaDonDTO.getMahang();
            obj[2] = chiTietHoaDonDTO.getMaloai();
            obj[3] = chiTietHoaDonDTO.getMacl();
            obj[4] = chiTietHoaDonDTO.getSoluong();
            obj[5] = chiTietHoaDonDTO.getDongia();
            obj[6] = chiTietHoaDonDTO.getTongtien();
            
            dtm.addRow(obj);
//            System.out.println(chiTietHoaDonDTO.getManv());
        }
        return dtm;
    }}
