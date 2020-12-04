/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import DTO.NhaCungCapDTO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author huynh
 */
public class ClassTableNhaCungCap {
    public DefaultTableModel setTableNhaCungCap(ArrayList<NhaCungCapDTO> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 4 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        NhaCungCapDTO nhacungcapDTO = null;
        for (int i = 0; i < num; i++) {
            nhacungcapDTO = listItem.get(i);
            obj = new Object[columns];
            obj[0] = nhacungcapDTO.getMancc();
            obj[1] = nhacungcapDTO.getTenncc();
            obj[2] = nhacungcapDTO.getDiachi();
            obj[3] = nhacungcapDTO.getSodt();
            
            
            dtm.addRow(obj);
//            System.out.println(nhacungcapDTO.getManv());
        }
        return dtm;
    }
}
