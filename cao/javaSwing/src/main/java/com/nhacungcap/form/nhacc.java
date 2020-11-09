package com.nhacungcap.form;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class nhacc extends JFrame {

	private JPanel contentPane;
	private JTextField jtfMaNhaCungCap;
	private JTextField jtfTenNhaCungCap;
	private JTextField jtfDiaChiNhaCungCap;
	private JTextField jtfSdtNhaCungCap;
	private JTable jtblDanhSachNhaCungCap;
	private JTextField jtfNhapThongTinNhaCungCap;
	private DefaultTableModel model;
	private int flag_hiden_button_update=1;
	private String ma_ncc,ten_ncc,dia_chi_ncc,sdt_ncc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nhacc frame = new nhacc();

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
	public nhacc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 530);
		setMinimumSize(new Dimension(635, 563));
		setTitle("Nhà Cung Cấp");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{152, 141, 182, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel jpnNhapThongTinNhaCungCap = new JPanel();
		jpnNhapThongTinNhaCungCap.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Nhập thông tin nhà cung cấp", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_jpnNhapThongTinNhaCungCap = new GridBagConstraints();
		gbc_jpnNhapThongTinNhaCungCap.insets = new Insets(0, 0, 5, 0);
		gbc_jpnNhapThongTinNhaCungCap.fill = GridBagConstraints.HORIZONTAL;
		gbc_jpnNhapThongTinNhaCungCap.gridx = 0;
		gbc_jpnNhapThongTinNhaCungCap.gridy = 0;
		contentPane.add(jpnNhapThongTinNhaCungCap, gbc_jpnNhapThongTinNhaCungCap);
		GridBagLayout gbl_jpnNhapThongTinNhaCungCap = new GridBagLayout();
		gbl_jpnNhapThongTinNhaCungCap.columnWidths = new int[]{87, 0, 0, 0, 0};
		gbl_jpnNhapThongTinNhaCungCap.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_jpnNhapThongTinNhaCungCap.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_jpnNhapThongTinNhaCungCap.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		jpnNhapThongTinNhaCungCap.setLayout(gbl_jpnNhapThongTinNhaCungCap);
		
		JLabel jlbMaNhaCungCap = new JLabel("Mã nhà cung cấp");
		GridBagConstraints gbc_jlbMaNhaCungCap = new GridBagConstraints();
		gbc_jlbMaNhaCungCap.insets = new Insets(0, 0, 5, 5);
		gbc_jlbMaNhaCungCap.anchor = GridBagConstraints.WEST;
		gbc_jlbMaNhaCungCap.gridx = 0;
		gbc_jlbMaNhaCungCap.gridy = 0;
		jpnNhapThongTinNhaCungCap.add(jlbMaNhaCungCap, gbc_jlbMaNhaCungCap);
		
		jtfMaNhaCungCap = new JTextField();

		GridBagConstraints gbc_jtfMaNhaCungCap = new GridBagConstraints();
		gbc_jtfMaNhaCungCap.gridwidth = 3;
		gbc_jtfMaNhaCungCap.insets = new Insets(0, 0, 5, 5);
		gbc_jtfMaNhaCungCap.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfMaNhaCungCap.gridx = 1;
		gbc_jtfMaNhaCungCap.gridy = 0;
		jpnNhapThongTinNhaCungCap.add(jtfMaNhaCungCap, gbc_jtfMaNhaCungCap);
		jtfMaNhaCungCap.setColumns(10);
		
		JLabel jlbTenNhaCungCap = new JLabel("Tên nhà cung cấp");
		GridBagConstraints gbc_jlbTenNhaCungCap = new GridBagConstraints();
		gbc_jlbTenNhaCungCap.anchor = GridBagConstraints.WEST;
		gbc_jlbTenNhaCungCap.insets = new Insets(0, 0, 5, 5);
		gbc_jlbTenNhaCungCap.gridx = 0;
		gbc_jlbTenNhaCungCap.gridy = 1;
		jpnNhapThongTinNhaCungCap.add(jlbTenNhaCungCap, gbc_jlbTenNhaCungCap);
		
		jtfTenNhaCungCap = new JTextField();
		GridBagConstraints gbc_jtfTenNhaCungCap = new GridBagConstraints();
		gbc_jtfTenNhaCungCap.gridwidth = 3;
		gbc_jtfTenNhaCungCap.insets = new Insets(0, 0, 5, 5);
		gbc_jtfTenNhaCungCap.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTenNhaCungCap.gridx = 1;
		gbc_jtfTenNhaCungCap.gridy = 1;
		jpnNhapThongTinNhaCungCap.add(jtfTenNhaCungCap, gbc_jtfTenNhaCungCap);
		jtfTenNhaCungCap.setColumns(10);
		
		final JLabel jlbDiaChiNhaCungCap = new JLabel("Địa chỉ");
		GridBagConstraints gbc_jlbDiaChiNhaCungCap = new GridBagConstraints();
		gbc_jlbDiaChiNhaCungCap.anchor = GridBagConstraints.WEST;
		gbc_jlbDiaChiNhaCungCap.insets = new Insets(0, 0, 5, 5);
		gbc_jlbDiaChiNhaCungCap.gridx = 0;
		gbc_jlbDiaChiNhaCungCap.gridy = 2;
		jpnNhapThongTinNhaCungCap.add(jlbDiaChiNhaCungCap, gbc_jlbDiaChiNhaCungCap);
		
		jtfDiaChiNhaCungCap = new JTextField();
		GridBagConstraints gbc_jtfDiaChiNhaCungCap = new GridBagConstraints();
		gbc_jtfDiaChiNhaCungCap.gridwidth = 3;
		gbc_jtfDiaChiNhaCungCap.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDiaChiNhaCungCap.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDiaChiNhaCungCap.gridx = 1;
		gbc_jtfDiaChiNhaCungCap.gridy = 2;
		jpnNhapThongTinNhaCungCap.add(jtfDiaChiNhaCungCap, gbc_jtfDiaChiNhaCungCap);
		jtfDiaChiNhaCungCap.setColumns(10);
		
		JLabel jlbSdtNhaCungCap = new JLabel("SĐT");
		GridBagConstraints gbc_jlbSdtNhaCungCap = new GridBagConstraints();
		gbc_jlbSdtNhaCungCap.anchor = GridBagConstraints.WEST;
		gbc_jlbSdtNhaCungCap.insets = new Insets(0, 0, 5, 5);
		gbc_jlbSdtNhaCungCap.gridx = 0;
		gbc_jlbSdtNhaCungCap.gridy = 3;
		jpnNhapThongTinNhaCungCap.add(jlbSdtNhaCungCap, gbc_jlbSdtNhaCungCap);
		
		jtfSdtNhaCungCap = new JTextField();
		GridBagConstraints gbc_jtfSdtNhaCungCap = new GridBagConstraints();
		gbc_jtfSdtNhaCungCap.gridwidth = 3;
		gbc_jtfSdtNhaCungCap.insets = new Insets(0, 0, 5, 5);
		gbc_jtfSdtNhaCungCap.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSdtNhaCungCap.gridx = 1;
		gbc_jtfSdtNhaCungCap.gridy = 3;
		jpnNhapThongTinNhaCungCap.add(jtfSdtNhaCungCap, gbc_jtfSdtNhaCungCap);
		jtfSdtNhaCungCap.setColumns(10);
		
		JButton btnThemNhaCungCap = new JButton("Thêm");
		GridBagConstraints gbc_btnThemNhaCungCap = new GridBagConstraints();
		gbc_btnThemNhaCungCap.insets = new Insets(0, 0, 0, 5);
		gbc_btnThemNhaCungCap.anchor = GridBagConstraints.WEST;
		gbc_btnThemNhaCungCap.gridx = 1;
		gbc_btnThemNhaCungCap.gridy = 4;
		jpnNhapThongTinNhaCungCap.add(btnThemNhaCungCap, gbc_btnThemNhaCungCap);
		
		JButton btnImportDanhSachNhaCungCap = new JButton("Import từ file excel");
		GridBagConstraints gbc_btnImportDanhSachNhaCungCap = new GridBagConstraints();
		gbc_btnImportDanhSachNhaCungCap.insets = new Insets(0, 0, 0, 5);
		gbc_btnImportDanhSachNhaCungCap.anchor = GridBagConstraints.WEST;
		gbc_btnImportDanhSachNhaCungCap.gridx = 2;
		gbc_btnImportDanhSachNhaCungCap.gridy = 4;
		jpnNhapThongTinNhaCungCap.add(btnImportDanhSachNhaCungCap, gbc_btnImportDanhSachNhaCungCap);
		
		final JButton btnUpdateNhaCungCap = new JButton("Update");
		GridBagConstraints gbc_btnUpdateNhaCungCap = new GridBagConstraints();
		gbc_btnUpdateNhaCungCap.anchor = GridBagConstraints.WEST;
		gbc_btnUpdateNhaCungCap.gridx = 3;
		gbc_btnUpdateNhaCungCap.gridy = 4;
		jpnNhapThongTinNhaCungCap.add(btnUpdateNhaCungCap, gbc_btnUpdateNhaCungCap);
		btnImportDanhSachNhaCungCap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("Excel file", "xls", "xlsx");
				fileChooser.setFileFilter(fileNameExtensionFilter);
				fileChooser.setMultiSelectionEnabled(false);
				int x = fileChooser.showDialog(new Frame(),"Chọn File");
				File f;String path_file_name="";
				if(x == JFileChooser.APPROVE_OPTION){
					f = fileChooser.getSelectedFile();
					path_file_name=f.getAbsolutePath().toString();
					path_file_name = path_file_name.replace("\\","/");
					System.out.println(path_file_name);
				}
				else {
					System.out.println("No Selection ");
				}
				NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAO();
				try {
					nhaCungCapDAO.nhapDanhSachNhaCungCapFileExcel(path_file_name);
					reloadDanhSachNhaCungCap();
				} catch (IOException | SQLException ex) {
					ex.printStackTrace();
				}
			}
		});

				btnThemNhaCungCap.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						NhaCungCapDTO nhaCungCapDTO = new NhaCungCapDTO();
						nhaCungCapDTO.setStrMaNhaCungCap(jtfMaNhaCungCap.getText().toString());
						nhaCungCapDTO.setStrTenNhaCungCap(jtfTenNhaCungCap.getText().toString());
						nhaCungCapDTO.setStrDiaChiNhaCungCap(jtfDiaChiNhaCungCap.getText().toString());
						nhaCungCapDTO.setStrSdtNhaCungCap(jtfSdtNhaCungCap.getText().toString());
						NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAO();
						try {
							if(nhaCungCapDTO.getStrMaNhaCungCap().length()<=10&nhaCungCapDTO.getStrTenNhaCungCap().length()<=100&nhaCungCapDTO.getStrDiaChiNhaCungCap().length()<=200&nhaCungCapDTO.getStrSdtNhaCungCap().length()<=10){
								boolean bl = nhaCungCapDAO.insertNhaCungCap(nhaCungCapDTO);
								System.out.println(bl);
								if(bl){
									jtfMaNhaCungCap.setText("");
									jtfTenNhaCungCap.setText("");
									jtfDiaChiNhaCungCap.setText("");
									jtfSdtNhaCungCap.setText("");
									JOptionPane.showMessageDialog(new Frame(), "Đã Thêm");
								}
								reloadDanhSachNhaCungCap();
							}
							else{
								JOptionPane.showMessageDialog(new JFrame("thong bao"),"Thông tin nhập quá dài");
							}
						} catch (SQLException ex) {
							ex.printStackTrace();
						}
					}
				});
		
		JPanel jpnTimKiemNhaCungCap = new JPanel();
		jpnTimKiemNhaCungCap.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tìm Kiếm Nhà Cung Cấp", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_jpnTimKiemNhaCungCap = new GridBagConstraints();
		gbc_jpnTimKiemNhaCungCap.insets = new Insets(0, 0, 5, 0);
		gbc_jpnTimKiemNhaCungCap.fill = GridBagConstraints.BOTH;
		gbc_jpnTimKiemNhaCungCap.gridx = 0;
		gbc_jpnTimKiemNhaCungCap.gridy = 1;
		contentPane.add(jpnTimKiemNhaCungCap, gbc_jpnTimKiemNhaCungCap);
		GridBagLayout gbl_jpnTimKiemNhaCungCap = new GridBagLayout();
		gbl_jpnTimKiemNhaCungCap.columnWidths = new int[]{200, 200, 200, 0};
		gbl_jpnTimKiemNhaCungCap.rowHeights = new int[]{30, 0, 0, 0, 0};
		gbl_jpnTimKiemNhaCungCap.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_jpnTimKiemNhaCungCap.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		jpnTimKiemNhaCungCap.setLayout(gbl_jpnTimKiemNhaCungCap);
		
		JLabel jlbTimKiemNhaCungCap = new JLabel("Nhập thông tin tìm kiếm nhà cung cấp");
		GridBagConstraints gbc_jlbTimKiemNhaCungCap = new GridBagConstraints();
		gbc_jlbTimKiemNhaCungCap.gridwidth = 3;
		gbc_jlbTimKiemNhaCungCap.anchor = GridBagConstraints.WEST;
		gbc_jlbTimKiemNhaCungCap.insets = new Insets(0, 0, 5, 0);
		gbc_jlbTimKiemNhaCungCap.gridx = 0;
		gbc_jlbTimKiemNhaCungCap.gridy = 0;
		jpnTimKiemNhaCungCap.add(jlbTimKiemNhaCungCap, gbc_jlbTimKiemNhaCungCap);
		
		jtfNhapThongTinNhaCungCap = new JTextField();
		GridBagConstraints gbc_jtfNhapThongTinNhaCungCap = new GridBagConstraints();
		gbc_jtfNhapThongTinNhaCungCap.gridwidth = 3;
		gbc_jtfNhapThongTinNhaCungCap.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNhapThongTinNhaCungCap.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNhapThongTinNhaCungCap.gridx = 0;
		gbc_jtfNhapThongTinNhaCungCap.gridy = 1;
		jpnTimKiemNhaCungCap.add(jtfNhapThongTinNhaCungCap, gbc_jtfNhapThongTinNhaCungCap);
		jtfNhapThongTinNhaCungCap.setColumns(10);
		
		final JRadioButton rbtnMaNhaCungCap = new JRadioButton("Mã nhà cung cấp");
		GridBagConstraints gbc_rbtnMaNhaCungCap = new GridBagConstraints();
		gbc_rbtnMaNhaCungCap.insets = new Insets(0, 0, 5, 5);
		gbc_rbtnMaNhaCungCap.gridx = 0;
		gbc_rbtnMaNhaCungCap.gridy = 2;
		jpnTimKiemNhaCungCap.add(rbtnMaNhaCungCap, gbc_rbtnMaNhaCungCap);
		
		final JRadioButton rbtnTenNhaCungCap = new JRadioButton("Tên nhà cung cấp");
		GridBagConstraints gbc_rbtnTenNhaCungCap = new GridBagConstraints();
		gbc_rbtnTenNhaCungCap.insets = new Insets(0, 0, 5, 5);
		gbc_rbtnTenNhaCungCap.gridx = 1;
		gbc_rbtnTenNhaCungCap.gridy = 2;
		jpnTimKiemNhaCungCap.add(rbtnTenNhaCungCap, gbc_rbtnTenNhaCungCap);
		
		final JRadioButton rbtnSdtNhaCungCap = new JRadioButton("SĐT nhà cung cấp");
		GridBagConstraints gbc_rbtnSdtNhaCungCap = new GridBagConstraints();
		gbc_rbtnSdtNhaCungCap.insets = new Insets(0, 0, 5, 0);
		gbc_rbtnSdtNhaCungCap.gridx = 2;
		gbc_rbtnSdtNhaCungCap.gridy = 2;
		jpnTimKiemNhaCungCap.add(rbtnSdtNhaCungCap, gbc_rbtnSdtNhaCungCap);

		final ButtonGroup GroupRadioButtonTimKiem = new ButtonGroup();
		GroupRadioButtonTimKiem.add(rbtnMaNhaCungCap);
		GroupRadioButtonTimKiem.add(rbtnSdtNhaCungCap);
		GroupRadioButtonTimKiem.add(rbtnTenNhaCungCap);

		JButton btnTimKiemNhaCungCap = new JButton("Tìm Kiếm");
		GridBagConstraints gbc_btnTimKiemNhaCungCap = new GridBagConstraints();
		gbc_btnTimKiemNhaCungCap.insets = new Insets(0, 0, 0, 5);
		gbc_btnTimKiemNhaCungCap.gridx = 1;
		gbc_btnTimKiemNhaCungCap.gridy = 3;
		jpnTimKiemNhaCungCap.add(btnTimKiemNhaCungCap, gbc_btnTimKiemNhaCungCap);
		
		JPanel jpnDanhSachNhaCungCap = new JPanel();
		jpnDanhSachNhaCungCap.setBorder(new TitledBorder(null, "Danh Sách Nhà Cung Cấp", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_jpnDanhSachNhaCungCap = new GridBagConstraints();
		gbc_jpnDanhSachNhaCungCap.insets = new Insets(0, 0, 5, 0);
		gbc_jpnDanhSachNhaCungCap.fill = GridBagConstraints.BOTH;
		gbc_jpnDanhSachNhaCungCap.gridx = 0;
		gbc_jpnDanhSachNhaCungCap.gridy = 2;
		contentPane.add(jpnDanhSachNhaCungCap, gbc_jpnDanhSachNhaCungCap);
		GridBagLayout gbl_jpnDanhSachNhaCungCap = new GridBagLayout();
		gbl_jpnDanhSachNhaCungCap.columnWidths = new int[]{0, 0};
		gbl_jpnDanhSachNhaCungCap.rowHeights = new int[]{0, 0};
		gbl_jpnDanhSachNhaCungCap.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_jpnDanhSachNhaCungCap.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		jpnDanhSachNhaCungCap.setLayout(gbl_jpnDanhSachNhaCungCap);
		
		JScrollPane jscrollPaneDanhSachNhaCungCap = new JScrollPane();
		GridBagConstraints gbc_jscrollPaneDanhSachNhaCungCap = new GridBagConstraints();
		gbc_jscrollPaneDanhSachNhaCungCap.fill = GridBagConstraints.BOTH;
		gbc_jscrollPaneDanhSachNhaCungCap.gridx = 0;
		gbc_jscrollPaneDanhSachNhaCungCap.gridy = 0;
		jpnDanhSachNhaCungCap.add(jscrollPaneDanhSachNhaCungCap, gbc_jscrollPaneDanhSachNhaCungCap);
		
		jtblDanhSachNhaCungCap = new JTable(){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};;
		jtblDanhSachNhaCungCap.setBorder(new LineBorder(new Color(0, 0, 0)));
		//jtblDanhSachNhaCungCap.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		TableColumnModel columnModel = jtblDanhSachNhaCungCap.getColumnModel();
		jscrollPaneDanhSachNhaCungCap.setViewportView(jtblDanhSachNhaCungCap);
		
		JPanel jpnMenuButtonNhaCungCap = new JPanel();
		GridBagConstraints gbc_jpnMenuButtonNhaCungCap = new GridBagConstraints();
		gbc_jpnMenuButtonNhaCungCap.anchor = GridBagConstraints.SOUTH;
		gbc_jpnMenuButtonNhaCungCap.fill = GridBagConstraints.HORIZONTAL;
		gbc_jpnMenuButtonNhaCungCap.gridx = 0;
		gbc_jpnMenuButtonNhaCungCap.gridy = 3;
		contentPane.add(jpnMenuButtonNhaCungCap, gbc_jpnMenuButtonNhaCungCap);
		GridBagLayout gbl_jpnMenuButtonNhaCungCap = new GridBagLayout();
		gbl_jpnMenuButtonNhaCungCap.columnWidths = new int[]{120, 120, 120, 120, 120, 0};
		gbl_jpnMenuButtonNhaCungCap.rowHeights = new int[]{0, 0};
		gbl_jpnMenuButtonNhaCungCap.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_jpnMenuButtonNhaCungCap.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		jpnMenuButtonNhaCungCap.setLayout(gbl_jpnMenuButtonNhaCungCap);
		
		JButton btnExportDanhSachNhaCungCap = new JButton("Export ra file excel");
		GridBagConstraints gbc_btnExportExcel = new GridBagConstraints();
		gbc_btnExportExcel.insets = new Insets(0, 0, 0, 5);
		gbc_btnExportExcel.gridx = 0;
		gbc_btnExportExcel.gridy = 0;
		jpnMenuButtonNhaCungCap.add(btnExportDanhSachNhaCungCap, gbc_btnExportExcel);
		btnExportDanhSachNhaCungCap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String path_name_of_folder="";
				NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAO();
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("Chọn Folder");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);
				if (chooser.showOpenDialog(new JFrame()) == JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					path_name_of_folder = file.getAbsolutePath().toString();
					System.out.println(path_name_of_folder);
				}
				else {
					System.out.println("No Selection ");
				}

				try {
					nhaCungCapDAO.xuatDanhSachNhaCungCapFileExcel(path_name_of_folder);
					reloadDanhSachNhaCungCap();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		
		final JButton btnXoaNhaCungCap = new JButton("Xóa");
		GridBagConstraints gbc_btnXoaNhaCungCap = new GridBagConstraints();
		gbc_btnXoaNhaCungCap.gridx = 4;
		gbc_btnXoaNhaCungCap.gridy = 0;
		jpnMenuButtonNhaCungCap.add(btnXoaNhaCungCap, gbc_btnXoaNhaCungCap);
		hienThiDanhSachNhaCungCap();

		btnUpdateNhaCungCap.setVisible(false);
		jtblDanhSachNhaCungCap.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row = jtblDanhSachNhaCungCap.rowAtPoint(evt.getPoint());
				int col = jtblDanhSachNhaCungCap.columnAtPoint(evt.getPoint());
				if (row >= 0 && col >= 0) {
					TableModel tableModel =jtblDanhSachNhaCungCap.getModel();
					int vitri = jtblDanhSachNhaCungCap.getSelectedRow();
					btnUpdateNhaCungCap.setVisible(true);
					jtfMaNhaCungCap.setText(tableModel.getValueAt(vitri,1).toString());
					jtfTenNhaCungCap.setText(tableModel.getValueAt(vitri,2).toString());
					jtfDiaChiNhaCungCap.setText(tableModel.getValueAt(vitri,3).toString());
					jtfSdtNhaCungCap.setText(tableModel.getValueAt(vitri,4).toString());
					jtfMaNhaCungCap.setEditable(false);
					if(jtfMaNhaCungCap.getText().equals(ma_ncc)){
						jtfMaNhaCungCap.setText("");
						jtfTenNhaCungCap.setText("");
						jtfDiaChiNhaCungCap.setText("");
						jtfSdtNhaCungCap.setText("");
						jtfMaNhaCungCap.setEditable(true);
						btnUpdateNhaCungCap.setVisible(false);
					}
					else{
						btnUpdateNhaCungCap.setVisible(true);
					}
					ma_ncc=jtfMaNhaCungCap.getText();
					ten_ncc = jtfTenNhaCungCap.getText();
					dia_chi_ncc = jtfDiaChiNhaCungCap.getText();
					sdt_ncc =  jtfSdtNhaCungCap.getText();
					System.out.println(jtfMaNhaCungCap.getText());
					System.out.println(ma_ncc);
				}
			}
		});
		btnUpdateNhaCungCap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAO();
				try {
					nhaCungCapDAO.updateNhaCungCap(jtfMaNhaCungCap.getText().toString(),jtfTenNhaCungCap.getText().toString(),jtfDiaChiNhaCungCap.getText().toString(),jtfSdtNhaCungCap.getText().toString());
					JOptionPane.showMessageDialog(new Frame(), "Đã update Mã nhà cung cấp : '"+jtfMaNhaCungCap.getText().toString()+"'");
					ma_ncc="";
					ten_ncc="";
					dia_chi_ncc="";
					sdt_ncc="";
					jtfDiaChiNhaCungCap.setText("");
					jtfMaNhaCungCap.setText("");
					jtfTenNhaCungCap.setText("");
					jtfSdtNhaCungCap.setText("");
					reloadDanhSachNhaCungCap();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}

			}
		});
		btnXoaNhaCungCap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int re = JOptionPane.showConfirmDialog (null, "Bạn có muốn xóa không","Warning",dialogButton);
				if(re == JOptionPane.YES_OPTION){
					// Saving code here
					if (jtblDanhSachNhaCungCap.getSelectedRow() != -1) {
						// remove selected row from the model
						NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAO();
						TableModel tableModel =jtblDanhSachNhaCungCap.getModel();
						int[] indexs = jtblDanhSachNhaCungCap.getSelectedRows();
						for(int i=0;i<indexs.length;i++){
							try {
								nhaCungCapDAO.deleteNhaCungCap(tableModel.getValueAt(indexs[i],1).toString());
								jtfDiaChiNhaCungCap.setText("");
								jtfMaNhaCungCap.setText("");
								jtfTenNhaCungCap.setText("");
								jtfSdtNhaCungCap.setText("");
								btnUpdateNhaCungCap.setVisible(false);

							} catch (SQLException ex) {
								ex.printStackTrace();
							}
						}
						reloadDanhSachNhaCungCap();
						//model.removeRow(jtblDanhSachNhaCungCap.getSelectedRow());
					}
				}

			}
		});
		btnTimKiemNhaCungCap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(GroupRadioButtonTimKiem.getSelection() != null){
					rbtnMaNhaCungCap.setActionCommand("MaNhaCungCap");
					rbtnSdtNhaCungCap.setActionCommand("SdtNhaCungCap");
					rbtnTenNhaCungCap.setActionCommand("TenNhaCungcap");
					String valueTimKiem = jtfNhapThongTinNhaCungCap.getText().toString();
					String getvalueRadioButtonTimKiem = GroupRadioButtonTimKiem.getSelection().getActionCommand();
					if(getvalueRadioButtonTimKiem=="MaNhaCungCap"){
						hienThiDanhSachTimKiemNhaCungCap("Ma_Nha_Cung_cap",valueTimKiem);
					}
					else{
						if(getvalueRadioButtonTimKiem == "TenNhaCungcap"){
							hienThiDanhSachTimKiemNhaCungCap("Ten_nha_cung_cap",valueTimKiem);
						}
						else{
							if(getvalueRadioButtonTimKiem == "SdtNhaCungCap"){
								hienThiDanhSachTimKiemNhaCungCap("Sdt_nha_cung_cap",valueTimKiem);
							}
							else {
								if(valueTimKiem == ""){
									hienThiDanhSachNhaCungCap();
								}
							}
						}
					}
				}
			}
		});
	}
	public void hienThiDanhSachNhaCungCap()
	{
		//Khai báo 1 đối tượng thuộc lớp SinhVienBusiness
		NhaCungCapBUS nhaCungCapBUS = new NhaCungCapBUS();

		//Lấy danh sách sinh viên từ db của mysql
		List<NhaCungCapDTO> lstNhaCungCap = NhaCungCapBUS.layDanhSach();

		//Khai báo các cột tiêu đề trên jtable
		String colTieuDe[] = new String[]{"STT","Mã nhà cung cấp", "Tên Nhà cung cấp", "Địa Chỉ", "SĐT"};

		//Khai báo 1 đối tượng để đưa dữ liệu vào jtable
		model = new DefaultTableModel(colTieuDe, 0);

		Object[] row;
		int i=1;
		for(NhaCungCapDTO ncc : lstNhaCungCap)
		{
			row = new Object[5];
			row[0] = i;
			row[1] = ncc.getStrMaNhaCungCap();
			row[2] = ncc.getStrTenNhaCungCap();
			row[3] = ncc.getStrDiaChiNhaCungCap();
			row[4] = ncc.getStrSdtNhaCungCap();
			//Thêm vào model
			model.addRow(row);
			i++;
		}
		//Hiển thị vào jTable
		this.jtblDanhSachNhaCungCap.setModel(model);
	}
	public void hienThiDanhSachTimKiemNhaCungCap(String dieuKien,String giaTriTim)
	{
		//Khai báo 1 đối tượng thuộc lớp SinhVienBusiness
		NhaCungCapBUS nhaCungCapBUS = new NhaCungCapBUS();

		//Lấy danh sách sinh viên từ db của mysql
		List<NhaCungCapDTO> lstNhaCungCap = NhaCungCapBUS.layDanhSachTheoDieuKien(dieuKien,giaTriTim);

		//Khai báo các cột tiêu đề trên jtable
		String colTieuDe[] = new String[]{"STT","Mã nhà cung cấp", "Tên Nhà cung cấp", "Địa Chỉ", "SĐT"};

		//Khai báo 1 đối tượng để đưa dữ liệu vào jtable
		model = new DefaultTableModel(colTieuDe, 0);

		Object[] row;
		int i=1;
		for(NhaCungCapDTO ncc : lstNhaCungCap)
		{
			row = new Object[5];
			row[0] = i;
			row[1] = ncc.getStrMaNhaCungCap();
			row[2] = ncc.getStrTenNhaCungCap();
			row[3] = ncc.getStrDiaChiNhaCungCap();
			row[4] = ncc.getStrSdtNhaCungCap();
			//Thêm vào model
			model.addRow(row);
			i++;
		}
		//Hiển thị vào jTable
		this.jtblDanhSachNhaCungCap.setModel(model);
	}
	public void reloadDanhSachNhaCungCap(){
		DefaultTableModel defaultTableModel = (DefaultTableModel)jtblDanhSachNhaCungCap.getModel();
		defaultTableModel.setColumnCount(0);
		hienThiDanhSachNhaCungCap();
	}
}
