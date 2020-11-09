/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;


import DTO.HoaDonDTO;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author boopa
 */
public class ClassTableHoaDon {
    
    public DefaultTableModel setTableHoaDon(List<HoaDonDTO> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 6 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        HoaDonDTO hoaDonDTO = null;
        for (int i = 0; i < num; i++) {
            hoaDonDTO = listItem.get(i);
            obj = new Object[columns];
            obj[0] = hoaDonDTO.getMakh();
            obj[1] = hoaDonDTO.getManv();
            obj[2] = hoaDonDTO.getMahd();
            obj[3] = hoaDonDTO.getTongtien();
            obj[4] = hoaDonDTO.getNgayban();
            obj[5] = hoaDonDTO.getGhichu();
            
            dtm.addRow(obj);
//            System.out.println(hoaDonDTO.getManv());
        }
        return dtm;
    }}
