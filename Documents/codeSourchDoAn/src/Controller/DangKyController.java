/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BUS.NhanVienBUS;

import BUS.TaiKhoanBUS;
import DTO.NhanVienDTO;
import DTO.TaiKhoanDTO;
import GUI.DangNhapGUI;




import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author boopa
 */

    
public class DangKyController {

    private Dialog dialog;
    private JButton btnDangky,btnDangnhap;
    private JTextField jtfManv;
    private JTextField jtfTaikhoan;
    private JTextField jtfMatkhau,jtfNhaplaimatkhau;
    private JLabel jlbThongbao;
    private JLabel jlbHo,jlbTen,jlbGioitinh,jlbNgaysinh,jlbDiachi,jlbChucvu;
    
    TaiKhoanBUS taiKhoanBUS = null;
    //

    public DangKyController(Dialog dialog,JButton btnDangky, JButton btnDangnhap, JTextField jtfManv, JTextField jtfTaikhoan, JTextField jtfMatkhau, JTextField jtfNhaplaimatkhau, JLabel jlbThongbao, JLabel jlbHo, JLabel jlbTen, JLabel jlbGioitinh, JLabel jlbNgaysinh, JLabel jlbDiachi, JLabel jlbChucvu) {
        this.dialog = dialog;
        this.btnDangky = btnDangky;
        this.btnDangnhap = btnDangnhap;
        this.jtfManv = jtfManv;
        this.jtfTaikhoan = jtfTaikhoan;
        this.jtfMatkhau = jtfMatkhau;
        this.jtfNhaplaimatkhau = jtfNhaplaimatkhau;
        this.jlbThongbao = jlbThongbao;
        this.jlbHo = jlbHo;
        this.jlbTen = jlbTen;
        this.jlbGioitinh = jlbGioitinh;
        this.jlbNgaysinh = jlbNgaysinh;
        this.jlbDiachi = jlbDiachi;
        this.jlbChucvu = jlbChucvu;
    //
        TaiKhoanBUS taiKhoanBUS = new TaiKhoanBUS();
    }
    public void setEvent() {
        btnDangky.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    if (!CheckNotNull()){
                        jlbThongbao.setText("Vui lòng nhập dữ liệu bắt buộc!");
                    } 
                    else {
                        ArrayList<TaiKhoanDTO> ManvTK = TaiKhoanBUS.getList();
                        ArrayList<NhanVienDTO> ManvNV = NhanVienBUS.getList();
                        
                        for (NhanVienDTO manvNV : ManvNV){
                            if(jtfManv.getText().equals(manvNV.getManv())){
                                jlbHo.setText(manvNV.getHo());
                                jlbTen.setText(manvNV.getTen());
                                jlbGioitinh.setText(manvNV.getGioitinh());
                                jlbNgaysinh.setText(manvNV.getNgaysinh());
                                jlbDiachi.setText(manvNV.getDiachi());
                                jlbChucvu.setText(manvNV.getChucvu());
                                
                            for (TaiKhoanDTO manvTK : ManvTK){
                                    if(jtfTaikhoan.getText().equals(manvTK.getTaikhoan())){
                                        jlbThongbao.setText("Tài khoản đã tồn tại.");
                                    }else{
                                        TaiKhoanDTO taiKhoanDTO2 = new TaiKhoanDTO();
                                          //
                                        taiKhoanDTO2.setManv(jtfManv.getText());
                                        taiKhoanDTO2.setTaikhoan(jtfTaikhoan.getText());
                                        taiKhoanDTO2.setMatkhau(jtfMatkhau.getText());
                                        taiKhoanDTO2.setPhanquyen("");
                                        taiKhoanDTO2.setTrangthai("Đăng ký mới");
                                        
                                        if(jtfMatkhau.getText().equals(jtfNhaplaimatkhau.getText())){
                                             //them du lieu den BUS de truyen len DAO
                                            if(taiKhoanBUS.Insert(taiKhoanDTO2)!=0){
                                                jlbThongbao.setText("Đăng ký thành công.");
                                                //
                                                
                                                
                                                //
                                            }else{
                                                jlbThongbao.setText("Đăng ký không thành công.Lỗi kết nối.)");
                                            };
                                        }else{
                                            jlbThongbao.setText("Nhập lại mật khâu không đúng vui lòng kiểm tra lại");
                                        }
                                           
                                    }
                                }
                            }else{
                                jlbThongbao.setText("Mã nhân viên không tồn tại.");
                                        }
                        }

                }
                    }catch (Exception ex) {
                    jlbThongbao.setText("lỗi kết nối");
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
        btnDangnhap.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                   
                  dialog.dispose();
                  DangNhapGUI dialog = new DangNhapGUI(null,true);
                  dialog.setVisible(true);                                   

            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
 
            @Override
            public void mouseReleased(MouseEvent e) {
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



    }
    private boolean CheckNotNull(){
        
        return true;
    }
        private boolean YesOrNo() {
        int YesOrNo = JOptionPane.showConfirmDialog(null,
                "Đăng ký thành công,bạn có muốn đăng nhập luôn hay không?","Thông Báo",JOptionPane.YES_NO_OPTION);
        return YesOrNo == JOptionPane.YES_NO_OPTION;
    }
}

