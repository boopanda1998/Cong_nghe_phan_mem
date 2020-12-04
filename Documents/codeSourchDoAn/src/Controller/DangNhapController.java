/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import BUS.TaiKhoanBUS;
import DTO.TaiKhoanDTO;
import GUI.DangKyGUI;
import GUI.DangNhapGUI;

import GUI.MainJFrame;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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
    public JTextField jtfTaikhoan;
    public JTextField jtfMatkhau;
    private JLabel jlbThongbao;

    private TaiKhoanBUS taikhoanBUS = null;
//

    public DangNhapController(Dialog dialog, JButton btnDangnhap, JButton btnDangky, JTextField jtfTaikhoan, JTextField jtfMatkhau, JLabel jlbThongbao) {
        this.dialog = dialog;
        this.btnDangnhap = btnDangnhap;
        this.btnDangky = btnDangky;
        this.jtfTaikhoan = jtfTaikhoan;
        this.jtfMatkhau = jtfMatkhau;
        this.jlbThongbao = jlbThongbao;
    
    //  
        
        this.taikhoanBUS = new TaiKhoanBUS();
    }



    public void setEvent() {
        btnDangnhap.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    if(CheckNotNull()){
                        System.out.print("1");
                        
                        ArrayList<TaiKhoanDTO> ManvTK = TaiKhoanBUS.getList();
                       
                        for(TaiKhoanDTO kiemtra : ManvTK){
                                                    
                            
                            if(jtfTaikhoan.getText().equals(kiemtra.getTaikhoan())&&
                                jtfMatkhau.getText().equals(kiemtra.getMatkhau())){
                                
                                System.out.print("2");
                                //
                                TaiKhoanDTO taikhoanDTO = new TaiKhoanDTO();
                                taikhoanDTO.setManv(kiemtra.getManv());
                                taikhoanDTO.setTaikhoan(kiemtra.getTaikhoan());
                                taikhoanDTO.setMatkhau(kiemtra.getMatkhau());
                                taikhoanDTO.setPhanquyen(kiemtra.getPhanquyen());
                                
                                taikhoanDTO.setTrangthai("Đã đăng nhâp");
                               
                                taikhoanBUS.Update(taikhoanDTO);
                                //
                                dialog.dispose();
                                MainJFrame frame = new MainJFrame();
                                frame.setVisible(true);
                                //
                               
                                
                            }else{
                                jlbThongbao.setText("Tài khoản và mật khẩu không đúng.");
                                                        System.out.print("3");

                            }
                            
                        }
                    } 
                    else {
                        jlbThongbao.setText("Vui lòng nhập đầy đủ thông tin.");
                                                System.out.print("4");

                    }
                }
                 catch (Exception ex) {
                    jlbThongbao.setText("Lỗi kết nối.Đăng nhập");
                                            System.out.print("5");

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
                DangKyGUI dialog = new DangKyGUI(null,true);
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
    private boolean CheckNotNull(){
        return true;
    }
}

