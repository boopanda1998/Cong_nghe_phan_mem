package GUI;

import Controller.QuanLyKhachHangController;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class KhachHangGUI extends javax.swing.JPanel {

      /**
     * Creates new form NhanVienGUI1
     */
    
 
    public KhachHangGUI() {
        initComponents();
 //       
        QuanLyKhachHangController controller = new QuanLyKhachHangController( 
               jpnView,
               jtfTimKiem,btnTimKiem,
                jlbThongBao,
                btnThem, btnSua, btnXoa,  btnNhaplai,  btnNhapexcel, btnXuatexcel,
                jtfMakh,  jtfHo,  jtfTen,  jtfSodt,  jtfNgaysinh,  jtfGioitinh, 
                jlbTbmakhachhang, jlbTbho,  jlbTbten,  jlbTbsodienthoai,  jlbTbgioitinh,  jlbTbngaysinh,
                jcbLocdanhsach);

        
 //
        controller.setDataToTable();
        controller.setEvent();
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpn1 = new javax.swing.JPanel();
        jtfTimKiem = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnNhaplai = new javax.swing.JButton();
        jlbMakh = new javax.swing.JLabel();
        jlbHo = new javax.swing.JLabel();
        jlbTen = new javax.swing.JLabel();
        jlbSodt = new javax.swing.JLabel();
        jtfMakh = new javax.swing.JTextField();
        jtfHo = new javax.swing.JTextField();
        jtfTen = new javax.swing.JTextField();
        jtfSodt = new javax.swing.JTextField();
        jlbNgaysinh = new javax.swing.JLabel();
        jlbGioitinh = new javax.swing.JLabel();
        jtfNgaysinh = new javax.swing.JTextField();
        jtfGioitinh = new javax.swing.JTextField();
        jlbThongBao = new javax.swing.JLabel();
        btnTimKiem = new javax.swing.JButton();
        jpnView = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlbTbmakhachhang = new javax.swing.JLabel();
        jlbTbho = new javax.swing.JLabel();
        jlbTbsodienthoai = new javax.swing.JLabel();
        jlbTbngaysinh = new javax.swing.JLabel();
        jlbTbten = new javax.swing.JLabel();
        jlbTbgioitinh = new javax.swing.JLabel();
        jcbLocdanhsach = new javax.swing.JComboBox<>();
        btnXuatexcel = new javax.swing.JButton();
        btnNhapexcel = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1050, 720));

        jpn1.setForeground(java.awt.Color.red);
        jpn1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jpn1.setPreferredSize(new java.awt.Dimension(1050, 720));

        jtfTimKiem.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jtfTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfTimKiemActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(153, 153, 153));
        btnThem.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setBorder(null);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(153, 153, 153));
        btnSua.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setBorder(null);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(153, 153, 153));
        btnXoa.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setBorder(null);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnNhaplai.setBackground(new java.awt.Color(153, 153, 153));
        btnNhaplai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnNhaplai.setText("Nhập lại");
        btnNhaplai.setBorder(null);
        btnNhaplai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhaplaiActionPerformed(evt);
            }
        });

        jlbMakh.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jlbMakh.setText("Mã khách hàng");
        jlbMakh.setToolTipText("");

        jlbHo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jlbHo.setText("Họ");
        jlbHo.setToolTipText("");

        jlbTen.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jlbTen.setText("Tên");
        jlbTen.setToolTipText("");

        jlbSodt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jlbSodt.setText("Số điện thoại");
        jlbSodt.setToolTipText("");

        jtfMakh.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jtfMakh.setToolTipText("");
        jtfMakh.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jtfMakh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfMakhActionPerformed(evt);
            }
        });

        jtfHo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jtfHo.setToolTipText("");
        jtfHo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jtfHo.setCaretColor(new java.awt.Color(204, 204, 204));

        jtfTen.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jtfTen.setToolTipText("");

        jtfSodt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jtfSodt.setToolTipText("");
        jtfSodt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfSodtActionPerformed(evt);
            }
        });

        jlbNgaysinh.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jlbNgaysinh.setText("Ngày sinh");
        jlbNgaysinh.setToolTipText("");

        jlbGioitinh.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jlbGioitinh.setText("Giới tính");
        jlbGioitinh.setToolTipText("");

        jtfNgaysinh.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jtfNgaysinh.setToolTipText("");

        jtfGioitinh.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jtfGioitinh.setToolTipText("");
        jtfGioitinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfGioitinhActionPerformed(evt);
            }
        });

        jlbThongBao.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jlbThongBao.setForeground(java.awt.Color.red);
        jlbThongBao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnTimKiem.setBackground(new java.awt.Color(153, 153, 153));
        btnTimKiem.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setBorder(null);
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        jpnView.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách Khách Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        jpnView.setPreferredSize(new java.awt.Dimension(1350, 500));

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1014, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 365, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Thông báo");

        jlbTbmakhachhang.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jlbTbmakhachhang.setForeground(new java.awt.Color(255, 0, 51));
        jlbTbmakhachhang.setText("jLabel2");

        jlbTbho.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jlbTbho.setForeground(new java.awt.Color(255, 0, 51));
        jlbTbho.setText("jLabel3");

        jlbTbsodienthoai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jlbTbsodienthoai.setForeground(new java.awt.Color(255, 0, 51));
        jlbTbsodienthoai.setText("jLabel4");

        jlbTbngaysinh.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jlbTbngaysinh.setForeground(new java.awt.Color(255, 0, 51));
        jlbTbngaysinh.setText("jLabel5");

        jlbTbten.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jlbTbten.setForeground(new java.awt.Color(255, 0, 51));
        jlbTbten.setText("jLabel6");

        jlbTbgioitinh.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jlbTbgioitinh.setForeground(new java.awt.Color(255, 0, 51));
        jlbTbgioitinh.setText("jLabel7");

        jcbLocdanhsach.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnXuatexcel.setText("xuất excel");

        btnNhapexcel.setText("Nhập excel");

        javax.swing.GroupLayout jpn1Layout = new javax.swing.GroupLayout(jpn1);
        jpn1.setLayout(jpn1Layout);
        jpn1Layout.setHorizontalGroup(
            jpn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jpn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbLocdanhsach, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jlbTen)
                        .addComponent(jlbHo)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                        .addComponent(jlbMakh)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpn1Layout.createSequentialGroup()
                        .addGroup(jpn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfHo, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                            .addComponent(jtfTen, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                            .addComponent(jlbTbmakhachhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlbTbho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlbTbten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfMakh))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jpn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpn1Layout.createSequentialGroup()
                                .addComponent(jlbSodt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfSodt, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlbTbsodienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jpn1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jpn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jlbGioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlbNgaysinh))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlbTbgioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpn1Layout.createSequentialGroup()
                                        .addGap(159, 159, 159)
                                        .addComponent(btnNhapexcel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(btnXuatexcel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jtfGioitinh, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jlbTbngaysinh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                                        .addComponent(jtfNgaysinh, javax.swing.GroupLayout.Alignment.LEADING)))))
                        .addGap(226, 226, 226))
                    .addGroup(jpn1Layout.createSequentialGroup()
                        .addGroup(jpn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jlbThongBao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpn1Layout.createSequentialGroup()
                                .addComponent(jtfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnNhaplai, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
            .addGroup(jpn1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnView, javax.swing.GroupLayout.PREFERRED_SIZE, 1026, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(275, Short.MAX_VALUE))
        );
        jpn1Layout.setVerticalGroup(
            jpn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn1Layout.createSequentialGroup()
                .addGroup(jpn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpn1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jpn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpn1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jpn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNhaplai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jlbThongBao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jpn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpn1Layout.createSequentialGroup()
                        .addGroup(jpn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbSodt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfSodt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(jlbTbsodienthoai)
                        .addGap(112, 112, 112)
                        .addComponent(jlbTbgioitinh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNhapexcel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXuatexcel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpn1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jpn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfMakh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbMakh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(jlbTbmakhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(jpn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfHo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbHo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jpn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbTbho)
                            .addComponent(jlbTbngaysinh))
                        .addGap(1, 1, 1)
                        .addGroup(jpn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfTen, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbTen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbGioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfGioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jpn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpn1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jlbTbten))
                            .addGroup(jpn1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jcbLocdanhsach, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jpnView, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpn1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 750, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void jtfGioitinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfGioitinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfGioitinhActionPerformed

    private void jtfSodtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSodtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfSodtActionPerformed

    private void jtfMakhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfMakhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfMakhActionPerformed

    private void btnNhaplaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhaplaiActionPerformed

    }//GEN-LAST:event_btnNhaplaiActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed

    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

    }//GEN-LAST:event_btnThemActionPerformed

    private void jtfTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfTimKiemActionPerformed

    }//GEN-LAST:event_jtfTimKiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNhapexcel;
    private javax.swing.JButton btnNhaplai;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuatexcel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> jcbLocdanhsach;
    private javax.swing.JLabel jlbGioitinh;
    private javax.swing.JLabel jlbHo;
    private javax.swing.JLabel jlbMakh;
    private javax.swing.JLabel jlbNgaysinh;
    private javax.swing.JLabel jlbSodt;
    private javax.swing.JLabel jlbTbgioitinh;
    private javax.swing.JLabel jlbTbho;
    private javax.swing.JLabel jlbTbmakhachhang;
    private javax.swing.JLabel jlbTbngaysinh;
    private javax.swing.JLabel jlbTbsodienthoai;
    private javax.swing.JLabel jlbTbten;
    private javax.swing.JLabel jlbTen;
    private javax.swing.JLabel jlbThongBao;
    private javax.swing.JPanel jpn1;
    private javax.swing.JPanel jpnView;
    private javax.swing.JTextField jtfGioitinh;
    private javax.swing.JTextField jtfHo;
    private javax.swing.JTextField jtfMakh;
    private javax.swing.JTextField jtfNgaysinh;
    private javax.swing.JTextField jtfSodt;
    private javax.swing.JTextField jtfTen;
    private javax.swing.JTextField jtfTimKiem;
    // End of variables declaration//GEN-END:variables
}
