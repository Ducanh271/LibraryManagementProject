/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package common.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**
 *
 * @author lenhh
 */
public class ReturnBook extends javax.swing.JFrame {
   
    private Connection conn;
    /**
     * Creates new form ReturnBook
     */
    public ReturnBook() {
        initComponents();
        connectToDatabase();
    }
    private void connectToDatabase() {
        try {
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/quan_ly_thu_vien", // Thay "library" bằng tên CSDL của bạn
                "root",                                // Tên tài khoản
                ""                                     // Mật khẩu
            );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Kết nối cơ sở dữ liệu thất bại: " + e.getMessage());
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSButtonPane1 = new rojeru_san.complementos.RSButtonPane();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        masach = new javax.swing.JLabel();
        mabsao = new javax.swing.JLabel();
        tensach = new javax.swing.JLabel();
        ngaymuon = new javax.swing.JLabel();
        svmuon = new javax.swing.JLabel();
        hantra = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtmabs = new app.bolivia.swing.JCTextField();
        txtmasv = new app.bolivia.swing.JCTextField();
        jLabel11 = new javax.swing.JLabel();
        buttontimkiem = new javax.swing.JToggleButton();
        buttontrasach = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        txttienphat = new app.bolivia.swing.JCTextField();
        jLabel12 = new javax.swing.JLabel();
        txtlydo = new app.bolivia.swing.JCTextField();
        jLabel13 = new javax.swing.JLabel();

        javax.swing.GroupLayout rSButtonPane1Layout = new javax.swing.GroupLayout(rSButtonPane1);
        rSButtonPane1.setLayout(rSButtonPane1Layout);
        rSButtonPane1Layout.setHorizontalGroup(
            rSButtonPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        rSButtonPane1Layout.setVerticalGroup(
            rSButtonPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        rSMaterialButtonCircle1.setText("rSMaterialButtonCircle1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(994, 644));

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel1.setText("Thông tin sách");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mã sách:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mã bản sao:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tên sách:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Sinh viên mượn:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Ngày mượn:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Hạn trả:");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(289, 5));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 289, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        masach.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        masach.setForeground(new java.awt.Color(255, 255, 255));

        mabsao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        mabsao.setForeground(new java.awt.Color(255, 255, 255));

        tensach.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tensach.setForeground(new java.awt.Color(255, 255, 255));

        ngaymuon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ngaymuon.setForeground(new java.awt.Color(255, 255, 255));

        svmuon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        svmuon.setForeground(new java.awt.Color(255, 255, 255));

        hantra.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        hantra.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(mabsao, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(masach, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tensach, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(svmuon, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hantra, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ngaymuon, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(masach, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(jLabel3))
                    .addComponent(mabsao, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tensach, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(svmuon, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ngaymuon, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(hantra, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(128, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));
        jPanel4.setPreferredSize(new java.awt.Dimension(277, 5));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel8.setText("Trả sách");

        jLabel9.setForeground(new java.awt.Color(255, 51, 51));
        jLabel9.setText("Mã bản sao");

        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setText("Mã sinh viên: ");

        txtmabs.setBackground(new java.awt.Color(255, 255, 255));
        txtmabs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmabsActionPerformed(evt);
            }
        });

        txtmasv.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/library-3.png.png"))); // NOI18N

        buttontimkiem.setBackground(new java.awt.Color(0, 102, 102));
        buttontimkiem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttontimkiem.setForeground(new java.awt.Color(255, 255, 255));
        buttontimkiem.setText("Tìm kiếm");
        buttontimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttontimkiemActionPerformed(evt);
            }
        });

        buttontrasach.setBackground(new java.awt.Color(255, 51, 51));
        buttontrasach.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttontrasach.setForeground(new java.awt.Color(255, 255, 255));
        buttontrasach.setText("Trả Sách");
        buttontrasach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttontrasachActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Rewind_48px 1.png"))); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txttienphat.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setText("Tiền Phạt:");

        txtlydo.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("Lý do phạt");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtmasv, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                                    .addComponent(txtmabs, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                                    .addComponent(txttienphat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtlydo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(41, 41, 41))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(buttontimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(93, 93, 93))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(buttontrasach, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtmabs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtmasv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(buttontimkiem)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttienphat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtlydo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttontrasach)
                .addGap(63, 63, 63))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bttimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttimkiemActionPerformed
    
    }//GEN-LAST:event_bttimkiemActionPerformed

    private void bttrasachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttrasachActionPerformed
        
    }//GEN-LAST:event_bttrasachActionPerformed

    private void buttontrasachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttontrasachActionPerformed
  String mabs = txtmabs.getText().trim(); // Mã bản sao
    String masv = txtmasv.getText().trim(); // Mã sinh viên
    String tienPhat = txttienphat.getText().trim(); // Tiền phạt
    String lyDoPhat = txtlydo.getText().trim(); // Lý do phạt

    if (mabs.isEmpty() || masv.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ mã bản sao và mã sinh viên!");
        return;
    }

    if (!tienPhat.isEmpty() && lyDoPhat.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập lý do phạt!");
        return;
    }

    if (tienPhat.isEmpty() && !lyDoPhat.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập tiền phạt!");
        return;
    }

    try {
        // Kiểm tra mã bản sao và trạng thái trong bảng chitietmuonsach
        String sqlKiemTra = """
            SELECT trangThai
            FROM thongtinmuontrasach
            WHERE maNM = ? AND maBanSaoSach = ?
        """;
        PreparedStatement pstKiemTra = conn.prepareStatement(sqlKiemTra);
        pstKiemTra.setString(1, masv);
        pstKiemTra.setString(2, mabs);

        ResultSet rsKiemTra = pstKiemTra.executeQuery();
        if (rsKiemTra.next()) {
            int trangThai = rsKiemTra.getInt("trangThai");

            if (trangThai==0) {
                // Cập nhật trạng thái thành 2 trong bảng thongtinmuontrasach
                String sqlCapNhatThongTin = "UPDATE thongtinmuontrasach SET trangThai = 1 WHERE maNM = ?";
                PreparedStatement pstCapNhatThongTin = conn.prepareStatement(sqlCapNhatThongTin);
                pstCapNhatThongTin.setString(1, masv);
                pstCapNhatThongTin.executeUpdate();

                // Cập nhật trạng thái và tùy chọn cập nhật tienPhat và lyDoPhat
                String sqlCapNhatChiTiet;
                PreparedStatement pstCapNhatChiTiet = null;
                if (!tienPhat.isEmpty() && !lyDoPhat.isEmpty()) {
                    sqlCapNhatChiTiet = """
                        UPDATE thongtinmuontrasach 
                        SET trangThai = 1, tienPhat = ?, lyDoPhat = ?
                        WHERE maBanSaoSach = ?
                    """;
                    pstCapNhatChiTiet = conn.prepareStatement(sqlCapNhatChiTiet);
                    pstCapNhatChiTiet.setString(1, tienPhat);
                    pstCapNhatChiTiet.setString(2, lyDoPhat);
                }
                else {
    // Trường hợp không có tiền phạt hoặc lý do phạt
    sqlCapNhatChiTiet = """
        UPDATE thongtinmuontrasach 
        SET trangThai = 1
        WHERE maBanSaoSach = ?
    """;
    pstCapNhatChiTiet = conn.prepareStatement(sqlCapNhatChiTiet);
    pstCapNhatChiTiet.setString(1, mabs);
}
                pstCapNhatChiTiet.setString(pstCapNhatChiTiet.getParameterMetaData().getParameterCount(), mabs);
                pstCapNhatChiTiet.executeUpdate();

                // Đặt lại các trường nhập liệu về rỗng
                masach.setText("");
                mabsao.setText("");
                tensach.setText("");
                svmuon.setText("");
                ngaymuon.setText("");
                hantra.setText("");
                txttienphat.setText("");
                txtlydo.setText("");

                JOptionPane.showMessageDialog(this, "Trả sách thành công!");
            } else if (trangThai == 1) {
                JOptionPane.showMessageDialog(this, "Quyển sách chưa được mượn!");
            } else {
                JOptionPane.showMessageDialog(this, "Trạng thái không hợp lệ!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin mượn sách với mã bản sao và mã sinh viên này!");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Lỗi xử lý: " + e.getMessage());
    }

    }//GEN-LAST:event_buttontrasachActionPerformed

    private void buttontimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttontimkiemActionPerformed
        String mabs = txtmabs.getText().trim(); // Mã bản sao
    String masv = txtmasv.getText().trim(); // Mã sinh viên

    if (mabs.isEmpty() || masv.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ mã bản sao và mã sinh viên!");
        return;
    }

    try {
        // Bước 1: Kiểm tra mã bản sao trong bảng bansaosach
        String sqlBanSao = "SELECT maSach FROM bansaosach WHERE maBanSao = ?";
        PreparedStatement pstBanSao = conn.prepareStatement(sqlBanSao);
        pstBanSao.setString(1, mabs);

        ResultSet rsBanSao = pstBanSao.executeQuery();
        if (rsBanSao.next()) {
            String maSach = rsBanSao.getString("maSach");
            masach.setText(maSach); // Hiển thị mã sách lên label
            mabsao.setText(mabs);   // Hiển thị mã bản sao lên label

            // Bước 2: Lấy thông tin sách từ bảng sach
            String sqlSach = "SELECT tenSach FROM sach WHERE maSach = ?";
            PreparedStatement pstSach = conn.prepareStatement(sqlSach);
            pstSach.setString(1, maSach);

            ResultSet rsSach = pstSach.executeQuery();
            if (rsSach.next()) {
                tensach.setText(rsSach.getString("tenSach")); // Hiển thị tên sách lên label
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin sách!");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy mã bản sao!");
            return;
        }

        // Bước 3: Kiểm tra thông tin người mượn và mã thông tin mượn trả
        String sqlThongTinMuonTra = """
            SELECT maNM, ngayMuon, hanTra
            FROM thongtinmuontrasach 
            WHERE maNM = ? AND maBanSaoSach = ? AND trangThai = 0
        """;
        PreparedStatement pstThongTin = conn.prepareStatement(sqlThongTinMuonTra);
        pstThongTin.setString(1, masv);
        pstThongTin.setString(2, mabs);

        ResultSet rsThongTin = pstThongTin.executeQuery();
        if (rsThongTin.next()) {
            svmuon.setText(rsThongTin.getString("maNM"));       // Hiển thị mã người mượn
            ngaymuon.setText(rsThongTin.getString("ngayMuon")); // Hiển thị ngày mượn
            hantra.setText(rsThongTin.getString("hanTra"));     // Hiển thị hạn trả
        } else {
            JOptionPane.showMessageDialog(this, "Sinh viên mà bạn nhập không mượn bản sao trên!");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Lỗi tìm kiếm: " + e.getMessage());
    }
    }//GEN-LAST:event_buttontimkiemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Homepage hp = new Homepage();
        this.setVisible(false);
        hp.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtmabsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmabsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmabsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton buttontimkiem;
    private javax.swing.JToggleButton buttontrasach;
    private javax.swing.JLabel hantra;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel mabsao;
    private javax.swing.JLabel masach;
    private javax.swing.JLabel ngaymuon;
    private rojeru_san.complementos.RSButtonPane rSButtonPane1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private javax.swing.JLabel svmuon;
    private javax.swing.JLabel tensach;
    private app.bolivia.swing.JCTextField txtlydo;
    private app.bolivia.swing.JCTextField txtmabs;
    private app.bolivia.swing.JCTextField txtmasv;
    private app.bolivia.swing.JCTextField txttienphat;
    // End of variables declaration//GEN-END:variables
}
