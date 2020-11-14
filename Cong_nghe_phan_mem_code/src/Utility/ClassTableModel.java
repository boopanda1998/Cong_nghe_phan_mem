/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;



import DTO.NhanVienDTO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ClassTableModel {

    public DefaultTableModel setTableNhanVien(ArrayList<NhanVienDTO> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 8 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        NhanVienDTO nhanVienDTO = null;
        for (int i = 0; i < num; i++) {
            nhanVienDTO = listItem.get(i);
            obj = new Object[columns];
            obj[0] = nhanVienDTO.getManv();
            obj[1] = nhanVienDTO.getHo();
            obj[2] = nhanVienDTO.getTen();
            obj[3] = nhanVienDTO.getGioitinh();
            obj[4] = nhanVienDTO.getNgaysinh();
            obj[5] = nhanVienDTO.getChucvu();
            obj[6] = nhanVienDTO.getLuong();
            obj[7] = nhanVienDTO.getDiachi();
            
            dtm.addRow(obj);
//            System.out.println(nhanVienDTO.getManv());
        }
        return dtm;
    }
//    public static void main(String [] args){
//        System.out.println("dsfadfas");
//        ClassTableModel tb = new ClassTableModel();
//        System.out.println(tb);
//    }

}