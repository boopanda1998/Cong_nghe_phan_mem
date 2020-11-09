package Form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import UTILS.ConnectionUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class FormDangKy extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenNhanVien;
	private JTextField txtDiaChi;
	private JTextField txtSoDT;
	private JTextField txtTenDangNhap;
	private JPasswordField txtPassword;
	private JLabel lblaCh;
	private JLabel lblSinThoi;
	private JLabel lblTnngNhp;
	private JLabel lblPassword;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormDangKy frame = new FormDangKy();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormDangKy() {
		setBounds(100, 100, 678, 565);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Registration");
		
		txtTenNhanVien = new JTextField();
		txtTenNhanVien.setBounds(369, 157, 281, 47);
		contentPane.add(txtTenNhanVien);
		txtTenNhanVien.setColumns(10);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(371, 222, 281, 47);
		contentPane.add(txtDiaChi);
		
		txtSoDT = new JTextField();
		txtSoDT.setColumns(10);
		txtSoDT.setBounds(371, 283, 281, 47);
		contentPane.add(txtSoDT);
		
		txtTenDangNhap = new JTextField();
		txtTenDangNhap.setColumns(10);
		txtTenDangNhap.setBounds(371, 344, 281, 47);
		contentPane.add(txtTenDangNhap);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(369, 403, 283, 47);
		contentPane.add(txtPassword);
		
		JLabel lblNewLabel = new JLabel("Tên Nhân Viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(254, 157, 105, 51);
		contentPane.add(lblNewLabel);
		
		lblaCh = new JLabel("Địa Chỉ");
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblaCh.setBounds(254, 218, 76, 51);
		contentPane.add(lblaCh);
		
		lblSinThoi = new JLabel("Sô Điện Thoại");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSinThoi.setBounds(254, 279, 105, 51);
		contentPane.add(lblSinThoi);
		
		lblTnngNhp = new JLabel("Tên tài khoản");
		lblTnngNhp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnngNhp.setBounds(254, 340, 111, 51);
		contentPane.add(lblTnngNhp);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(254, 399, 76, 51);
		contentPane.add(lblPassword);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				ConnectionUtil conUtil = new ConnectionUtil();
				Connection conn = conUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement("INSERT INTO `nhanvien`(`MaNhanVien`, `TenDangNhap`, `Password`, `TenNhanVien`, `NgayDK`, `DiaChi`, `SoDT`) VALUES (null,?,?,?,now(),?,?)");
				ps.setString(1,txtTenDangNhap.getText());
				ps.setString(2,txtPassword.getText());
				ps.setString(3,txtTenNhanVien.getText());
				ps.setString(4,txtDiaChi.getText());
				ps.setString(5,txtSoDT.getText());
				
				
				int x = ps.executeUpdate();
				if(x>0) JOptionPane.showMessageDialog(rootPane, "Đăng ký thành công");
				else JOptionPane.showMessageDialog(rootPane, "Đăng ký Không thành công");
			} catch(Exception e2) {
				System.out.println(e2);
			}}
		});
		btnNewButton.setBounds(452, 460, 198, 47);
		contentPane.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(FormDangKy.class.getResource("/Img/login.PNG")));
		lblNewLabel_1.setBounds(0, 0, 234, 517);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Sign Up");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Unispace", Font.BOLD, 30));
		lblNewLabel_2.setBounds(254, 0, 423, 127);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Welcome");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.GRAY);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBackground(Color.GRAY);
		lblNewLabel_3.setBounds(254, 85, 410, 62);
		contentPane.add(lblNewLabel_3);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormDangNhap formDN = new FormDangNhap();
				formDN.setVisible(true);
				setVisible(false);
			}
		});
		btnSignIn.setForeground(Color.WHITE);
		btnSignIn.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSignIn.setBackground(Color.DARK_GRAY);
		btnSignIn.setBounds(245, 460, 198, 47);
		contentPane.add(btnSignIn);
	}
}
