/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BUS.TaiKhoanBUS;
import BUS.TaiKhoanBUS;
import DTO.TaiKhoanDTO;
import GUI.DangKyJDialog;
import GUI.DangNhapJDialog;
import GUI.MainJFrame;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author boopa
 */

    
public class DangNhapController {

    private Dialog dialog;
    private JButton btnDangnhap,btnDangky;
    private JTextField jtfTendangnhap;
    private JTextField jtfMatkhau;
    private JLabel jlbThongBao;

    private TaiKhoanBUS taiKhoangBUS = null;

    public DangNhapController(Dialog dialog, JButton btnDangnhap, JTextField jtfTendangnhap, JTextField jtfMatkhau, JLabel jlbThongBao,JButton btnDangky) {
        this.dialog = dialog;
        this.btnDangnhap = btnDangnhap;
        this.jtfTendangnhap = jtfTendangnhap;
        this.jtfMatkhau = jtfMatkhau;
        this.jlbThongBao = jlbThongBao;
        this.btnDangky = btnDangky;
    

        TaiKhoanBUS taiKhoanBUS = new TaiKhoanBUS();
    }

    public void setEvent() {
        btnDangnhap.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {

                    if (jtfTendangnhap.getText().length() == 0
                            || jtfMatkhau.getText().length() == 0) {
                        jlbThongBao.setText("Vui lòng nhập dữ liệu bắt buộc!");
                    } 
                    else {
                        TaiKhoanDTO taiKhoanDTO = TaiKhoanBUS.login(jtfTendangnhap.getText(), jtfMatkhau.getText());
                        if (taiKhoanDTO == null) {
                            jlbThongBao.setText("Tên đăng nhập và mật khẩu không đúng!");
//                        }else {
//                            if (!taiKhoanDTO.isTinh_trang()) {
//                                jlbMsg.setText("Tài khoản của bạn đang bị tạm khóa!");
                            } else {
                                dialog.dispose();
                                MainJFrame frame = new MainJFrame();
                                
                                frame.setVisible(true);
                            }
                        }
                    }
                 catch (Exception ex) {
                    jlbThongBao.setText(ex.toString());
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnDangnhap.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnDangnhap.setBackground(new Color(100, 221, 23));
            }
            
        });
        btnDangky.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                dialog.dispose();
                DangKyJDialog dialog = new DangKyJDialog(null,true);
                    dialog.setTitle("Đăng Ký Thông Tin");
                    dialog.setResizable(false);
                    dialog.setLocationRelativeTo(null);
                    dialog.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnDangky.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnDangky.setBackground(new Color(100, 221, 23));
            }
            
        });

    }
}

