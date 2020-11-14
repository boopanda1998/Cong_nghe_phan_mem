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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author boopa
 */

    
public class DangKyController {

    private Dialog dialog;
    private JButton btnDangky;
    private JTextField jtfTendangnhap;
    private JTextField jtfMatkhau,jtfNhaplaiMK;
    private JLabel jlbThongBao;
    
    TaiKhoanBUS taiKhoanBUS = new TaiKhoanBUS();


    public DangKyController(Dialog dialog, JButton btnDangky, JTextField jtfTendangnhap, JTextField jtfMatkhau, JTextField jtfNhaplaiMK, JLabel jlbThongBao) {
        this.dialog = dialog;
        this.btnDangky = btnDangky;
        this.jtfTendangnhap = jtfTendangnhap;
        this.jtfMatkhau = jtfMatkhau;
        this.jtfNhaplaiMK = jtfNhaplaiMK;
        this.jlbThongBao = jlbThongBao;
    
        TaiKhoanBUS taiKhoanBUS = new TaiKhoanBUS();
    }

    public void setEvent() {
        btnDangky.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    if (jtfTendangnhap.getText().length() == 0
                            || jtfMatkhau.getText().length() == 0
                                || jtfNhaplaiMK.getText().length() == 0) {
                        jlbThongBao.setText("Vui lòng nhập dữ liệu bắt buộc!");
                    } 
                    else {
                        TaiKhoanDTO taiKhoanDTO = TaiKhoanBUS.login(jtfTendangnhap.getText(), jtfMatkhau.getText());
                         if (taiKhoanDTO == null) {
                                if(jtfMatkhau.getText().equals(jtfNhaplaiMK.getText())){
                                    TaiKhoanDTO taiKhoanDTO2 = new TaiKhoanDTO();
                                    
                                    taiKhoanDTO2.setMataikhoan("");
                                    taiKhoanDTO2.setTendangnhap(jtfTendangnhap.getText());
                                    taiKhoanDTO2.setMatkhau(jtfMatkhau.getText());;

                                    //them du lieu den BUS de truyen len DAO
                                     taiKhoanBUS.Insert(taiKhoanDTO2);
                                    //mở giao dien dang nhap hay khong? 
                                            if(YesOrNo()){
                                                    dialog.dispose();
                                                    MainJFrame frame = new MainJFrame();
                                                    frame.setVisible(true);
                                            }else{
                                                    DangNhapJDialog dialog = new DangNhapJDialog(null,true);
                                                    dialog.setTitle("Đăng nhập hệ thống");
                                                    
                                                    dialog.setResizable(false);
                                                     dialog.setLocationRelativeTo(null);
                                                     dialog.setVisible(true);
                                                }
                                
                                } else {jlbThongBao.setText("Mật khẩu không trùng khớp với nhập lại mật khẩu!");
                                        System.out.println(jtfMatkhau.getText()+"ssss"+jtfNhaplaiMK.getText());
                                        }
 
                            } else {
                                    jlbThongBao.setText("Tên tài khoản đã tồn tại.");
                            }
                        }
                    }
                 catch (Exception ex) {
                    jlbThongBao.setText(ex.toString());
                }
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
        private boolean YesOrNo() {
        int YesOrNo = JOptionPane.showConfirmDialog(null,
                "Đăng ký thành công,bạn có muốn đăng nhập luôn hay không?","Thông Báo",JOptionPane.YES_NO_OPTION);
        return YesOrNo == JOptionPane.YES_NO_OPTION;
    }
}

