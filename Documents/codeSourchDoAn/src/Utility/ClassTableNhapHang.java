/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import DTO.HangHoaDTO;
import DTO.NhapHangDTO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author boopa
 */
public class ClassTableNhapHang {
    
    public DefaultTableModel setTableNhapHang(ArrayList<NhapHangDTO> listItem, String[] listColumn) {
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
        NhapHangDTO nhapHangDTO = null;
        for (int i = 0; i < num; i++) {
            nhapHangDTO = listItem.get(i);
            obj = new Object[columns];
            obj[0] = nhapHangDTO.getMancc();
            obj[1] = nhapHangDTO.getManv();
            obj[2] = nhapHangDTO.getMapn();
            obj[3] = nhapHangDTO.getTongtien();
            obj[4] = nhapHangDTO.getNgaynhap();
            obj[5] = nhapHangDTO.getGhichu();
//            obj[6] = nhapHangDTO.getInhoadon();
            
            dtm.addRow(obj);
//            System.out.println(nhapHangDTO.getManv());
        }
        return dtm;
    }}
