/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BUS.ChamCongBUS;
import DTO.ChamCongDTO;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Min-NvT
 */
public class ChamCongController {

    private JButton BtnChamCong;
    private JComboBox<String> JcbPhep;
    private JLabel JlbTB;
    private JTable JtbChamCong;
    private JTextField JtfGhiChu;
    private JTextField JtfMaChamCong;
    private JTextField JtfMaNhanVien;
    private JTextField JtfNgay;
    private JPanel JpnTable;
    private ClassTableModel classTableModel = null;
    private final String[] COLUMNS = {"Mã chấm công", "Mã nhân viên", "Ngày làm", "Ngày nghỉ", "Ghi chú"};
    private ChamCongBUS chamCongBUS = null;
    private TableRowSorter<TableModel> rowSorter = null;

    public ChamCongController(
            JLabel JlbTB,
            JButton BtnChamCong,
            JComboBox<String> JcbPhep,
            JTable JtbChamCong,
            JTextField JtfGhiChu,
            JTextField JtfMaChamCong,
            JTextField JtfMaNhanVien,
            JTextField JtfNgay,
            JPanel JpnTable) {
        this.BtnChamCong = BtnChamCong;
        this.JcbPhep = JcbPhep;
        this.JlbTB = JlbTB;
        this.JtbChamCong = JtbChamCong;
        this.JtfGhiChu = JtfGhiChu;
        this.JtfMaChamCong = JtfMaChamCong;
        this.JtfMaNhanVien = JtfMaNhanVien;
        this.JtfNgay = JtfNgay;
        this.JpnTable = JpnTable;
        this.classTableModel = new ClassTableModel();
        this.chamCongBUS = new ChamCongBUS();
    }

    public ChamCongController() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public class ClassTableModel {

        public DefaultTableModel setTableNhanVien(ArrayList<ChamCongDTO> listItem, String[] listColumn) {
            int columns = listColumn.length;
            DefaultTableModel dtm = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return false;
                }

                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnIndex == 5 ? Boolean.class : String.class;
                }
            };
            dtm.setColumnIdentifiers(listColumn);
            Object[] obj;
            int num = listItem.size();
            ChamCongDTO chamCongDTO = null;
            for (int i = 0; i < num; i++) {
                chamCongDTO = listItem.get(i);
                obj = new Object[columns];
                obj[0] = chamCongDTO.getMacc();
                obj[1] = chamCongDTO.getManv();
                obj[2] = chamCongDTO.getNgaylam();
                obj[3] = chamCongDTO.getNghicophep();
                obj[4] = chamCongDTO.getGhichu();
                dtm.addRow(obj);
            }
            return dtm;
        }

        DefaultTableModel setTableNhanVien(ArrayList<ChamCongDTO> listItem, ArrayList<String> COLUMNS) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    public void setDataToTable() {
        ArrayList<ChamCongDTO> listItem = ChamCongBUS.getList();
        DefaultTableModel model = classTableModel.setTableNhanVien(listItem, COLUMNS);
        JtbChamCong.setModel(model);
        JtbChamCong.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        JtbChamCong.getTableHeader().setPreferredSize(new Dimension(100, 50));
        JtbChamCong.getTableHeader().setBackground(Color.red);
        JtbChamCong.getTableHeader().setBackground(new Color(232, 57, 99));
        JtbChamCong.getTableHeader().setForeground(Color.WHITE);
        JtbChamCong.setSelectionBackground(new Color(52, 152, 219));
        JtbChamCong.setRowHeight(50);
        JtbChamCong.validate();
        JtbChamCong.repaint();
        JtbChamCong.getColumnModel().getColumn(0).setMaxWidth(100);
        JtbChamCong.getColumnModel().getColumn(0).setMinWidth(90);
        JtbChamCong.getColumnModel().getColumn(0).setPreferredWidth(40);
        JtbChamCong.getColumnModel().getColumn(1).setMaxWidth(100);
        JtbChamCong.getColumnModel().getColumn(1).setMinWidth(60);
        JtbChamCong.getColumnModel().getColumn(1).setPreferredWidth(40);
        JtbChamCong.getColumnModel().getColumn(2).setMaxWidth(100);
        JtbChamCong.getColumnModel().getColumn(2).setMinWidth(40);
        JtbChamCong.getColumnModel().getColumn(2).setPreferredWidth(40);
        JtbChamCong.getColumnModel().getColumn(3).setMaxWidth(100);
        JtbChamCong.getColumnModel().getColumn(3).setMinWidth(40);
        JtbChamCong.getColumnModel().getColumn(3).setPreferredWidth(40);
        JtbChamCong.getColumnModel().getColumn(4).setMaxWidth(100);
        JtbChamCong.getColumnModel().getColumn(4).setMinWidth(40);
        JtbChamCong.getColumnModel().getColumn(4).setPreferredWidth(40);
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(JtbChamCong);
        scroll.setPreferredSize(new Dimension(600, 200));
        JpnTable.removeAll();
        JtbChamCong.removeAll();
        JpnTable.setLayout(new CardLayout());
        JtbChamCong.setLayout(new CardLayout());
        JpnTable.add(scroll);
        JpnTable.validate();
        JtbChamCong.validate();
        JpnTable.repaint();
        JtbChamCong.repaint();
        rowSorter = new TableRowSorter<>(JtbChamCong.getModel());
        JtbChamCong.setRowSorter(rowSorter);
        BtnChamCong.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    System.out.println("Kiem tra ma nhan vien da dc them vao dto chua--" + JtfMaNhanVien.getText());
                    ChamCongDTO chamCongDTO = new ChamCongDTO();
                    chamCongDTO.setMacc(JtfMaChamCong.getText());
                    chamCongDTO.setManv(JtfMaNhanVien.getText());
                    
                    Date date = new Date();// Return thời gian hiện tại với định dạng rất khó coi
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); // Định dạng lại date                                                                                           
                    JtfNgay.setText(sdf.format(date));
                    String i;
                    i=sdf.format(date);
                    chamCongDTO.setNgaylam(i);
                    chamCongDTO.setNghicophep(JcbPhep.getSelectedItem().toString());
                    chamCongDTO.setGhichu(JtfGhiChu.getText());
                    if (YesOrNo()) {
                        chamCongBUS.Insert(chamCongDTO);
                        listItem.add(chamCongDTO);
                        showResult();
                        JlbTB.setText("Thêm thành công.");
                    } else {
                        JlbTB.setText("Thao tác thêm đã bị hủy.");
                    }
                } catch (Exception ex) {
                    JlbTB.setText("Kiểm tra lỗi.");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            private void showResult() {
                {
                    ChamCongDTO s = listItem.get(listItem.size() - 1);
                    model.addRow(new Object[]{
                        s.getMacc(), s.getManv(), s.getNgaylam(), s.getNghicophep(), s.getGhichu()
                    });
                }
            }
        });
        JtbChamCong.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && JtbChamCong.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) JtbChamCong.getModel();
                    int selectedRowIndex = JtbChamCong.getSelectedRow();
                    selectedRowIndex = JtbChamCong.convertRowIndexToModel(selectedRowIndex);
                    ChamCongDTO chamCongDTO = new ChamCongDTO();
                    chamCongDTO.setMacc(model.getValueAt(selectedRowIndex, 0).toString());
                    chamCongDTO.setManv(model.getValueAt(selectedRowIndex, 1).toString());
                    chamCongDTO.setNgaylam(model.getValueAt(selectedRowIndex, 2).toString());
                    chamCongDTO.setNghicophep(model.getValueAt(selectedRowIndex, 3).toString());
                    chamCongDTO.setGhichu(model.getValueAt(selectedRowIndex, 4).toString());
                    JtfMaChamCong.setText("" + chamCongDTO.getMacc());
                    JtfMaChamCong.setEditable(false);
                    JtfMaNhanVien.setText(chamCongDTO.getManv());
                    JtfNgay.setText(chamCongDTO.getNgaylam());
                    JcbPhep.setSelectedItem(chamCongDTO.getNghicophep());
                    JtfGhiChu.setText(chamCongDTO.getGhichu());
                    JlbTB.setText("Thông tin nghỉ.");
                }
            }
        });
    }

    public void setEvent() {
    }

    private boolean YesOrNo() {
        int YesOrNo = JOptionPane.showConfirmDialog(null,
                "Bạn muốn cập nhật dữ liệu hay không?", "Thông Báo", JOptionPane.YES_NO_OPTION);
        return YesOrNo == JOptionPane.YES_NO_OPTION;
    }
}
