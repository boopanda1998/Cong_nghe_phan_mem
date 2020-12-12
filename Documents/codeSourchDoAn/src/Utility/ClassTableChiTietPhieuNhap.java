/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import DTO.HangHoaDTO;
import DTO.ChiTietPhieuNhapDTO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author boopa
 */
public class ClassTableChiTietPhieuNhap {
    
    public DefaultTableModel setTableChiTietPhieuNhap(ArrayList<ChiTietPhieuNhapDTO> listItem, String[] listColumn) {
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
        ChiTietPhieuNhapDTO chiTietPhieuNhapDTO = null;
        for (int i = 0; i < num; i++) {
            chiTietPhieuNhapDTO = listItem.get(i);
            obj = new Object[columns];
            obj[0] = chiTietPhieuNhapDTO.getMapn();
            obj[1] = chiTietPhieuNhapDTO.getMahang();
            obj[2] = chiTietPhieuNhapDTO.getMaloai();
            obj[3] = chiTietPhieuNhapDTO.getMacl();
            obj[4] = chiTietPhieuNhapDTO.getSoluong();
           // obj[5] = chiTietPhieuNhapDTO.getDongia();
            //obj[6] = chiTietPhieuNhapDTO.getTongtien();
            
            dtm.addRow(obj);
//            System.out.println(chiTietPhieuNhapDTO.getManv());
        }
        return dtm;
    }}
