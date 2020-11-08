/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class ClassTableHangHoa {
    public DefaultTableModel setTableHangHoa(ArrayList<HangHoaDTO> listItem, String[] listColumn){
        //check cột table
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 6 ? Boolean.class : String.class;
            }
        };
        //load dữ liệu lên table model
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        HangHoaDTO HangHoa = null;
        for (int i = 0; i < num; i++) {
            HangHoa = listItem.get(i);
            obj = new Object[columns];
            obj[0] = HangHoa.getMaHang();
            obj[1] = HangHoa.getMaCL();
            obj[2] = HangHoa.getTenHang();
            obj[3] = HangHoa.getSoLuong();
            obj[4] = HangHoa.getDonGia();
            obj[5] = HangHoa.getGhiChu();
            dtm.addRow(obj);
        }
        return dtm;
    }
}
