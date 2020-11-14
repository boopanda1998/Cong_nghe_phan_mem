/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import DTO.KhachHangDTO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author huynh
 */
public class ClassTableKhachHang {
   public DefaultTableModel setTableKhachHang(ArrayList<KhachHangDTO> listItem, String[] listColumn) {
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
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        KhachHangDTO khachhangDTO = null;
        for (int i = 0; i < num; i++) {
            khachhangDTO = listItem.get(i);
            obj = new Object[columns];
            obj[0] = khachhangDTO.getMakh();
            obj[1] = khachhangDTO.getHo();
            obj[2] = khachhangDTO.getTen();
            obj[3] = khachhangDTO.getSodt();
            obj[4] = khachhangDTO.getNgaysinh();
            obj[5] = khachhangDTO.getGioitinh();
            
            dtm.addRow(obj);
//            System.out.println(khachhangDTO.getManv());
        }
        return dtm;
    }
//    public static void main(String [] args){
//        System.out.println("dsfadfas");
//        ClassTableModel tb = new ClassTableModel();
//        System.out.println(tb);
//    }

}
