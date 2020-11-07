package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import UTILS.BDConnect;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;

public class DangNhapGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhapGUI frame = new DangNhapGUI();
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
	public DangNhapGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 447);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setTitle("Login");
		
		JLabel JLabel = new JLabel("Tên tài khoản");
		JLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabel.setBounds(302, 140, 92, 47);
		contentPane.add(JLabel);
		
		JLabel JLabel1 = new JLabel("Password");
		JLabel1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabel1.setBounds(302, 232, 92, 47);
		contentPane.add(JLabel1);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(302, 175, 373, 47);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(302, 267, 373, 54);
		contentPane.add(txtPassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setBounds(290, 340, 186, 47);
		contentPane.add(btnNewButton);
		
		JButton btnngK = new JButton("Sign Up");
		btnngK.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnngK.setForeground(Color.WHITE);
		btnngK.setBackground(Color.DARK_GRAY);
		btnngK.setBounds(489, 340, 186, 47);
		contentPane.add(btnngK);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(DangNhapGUI.class.getResource("/Img/login.PNG")));
		lblNewLabel.setBounds(0, 0, 261, 410);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sign In");
		lblNewLabel_1.setFont(new Font("Unispace", Font.BOLD, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(263, 3, 423, 127);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Welcome Back");
		lblNewLabel_2.setForeground(Color.GRAY);
		lblNewLabel_2.setBackground(Color.GRAY);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(263, 93, 423, 62);
		contentPane.add(lblNewLabel_2);
		
		
	}
	
}
