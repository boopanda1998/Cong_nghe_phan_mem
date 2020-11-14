/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import DTO.GiamGiaDTO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class ClassTableGiamGia {
     public DefaultTableModel setTableGiamGia(ArrayList<GiamGiaDTO> listItem, String[] listColumn) {
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
        GiamGiaDTO giamgiaDTO = null;
        for (int i = 0; i < num; i++) {
            giamgiaDTO = listItem.get(i);
            obj = new Object[columns];
            obj[0] = giamgiaDTO.getMagg();
            obj[1] = giamgiaDTO.getLoaigg();
            obj[2] = giamgiaDTO.getThongtingg();
            obj[3] = giamgiaDTO.getThoigiangg();
            
            
            dtm.addRow(obj);
//            System.out.println(giamgiaDTO.getManv());
        }
        return dtm;
    }
    
}
