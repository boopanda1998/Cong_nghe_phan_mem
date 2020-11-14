/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import DTO.ChatLieuDTO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author User
 */
public class ClassTableChatLieu {
    
    public DefaultTableModel setTableNhanVien(ArrayList<ChatLieuDTO> listItem, String[] listColumn) {
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
        ChatLieuDTO chatlieuDTO = null;
        for (int i = 0; i < num; i++) {
            chatlieuDTO = listItem.get(i);
            obj = new Object[columns];
            obj[0] = chatlieuDTO.getMacl();
            obj[1] = chatlieuDTO.getMaloai();
            obj[2] = chatlieuDTO.getMahang();
            obj[3] = chatlieuDTO.getTenhang();
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
