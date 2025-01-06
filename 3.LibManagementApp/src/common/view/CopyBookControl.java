package common.view;

import common.view.Homepage;
import java.awt.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CopyBookControl extends javax.swing.JFrame {

    public CopyBookControl() {
        initComponents();

        setSize(new java.awt.Dimension(1272, 895));
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btn_timkiembansao1 = new javax.swing.JToggleButton();
        btn_fillall = new javax.swing.JToggleButton();
        txtTimkiembansao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_mbs_end = new javax.swing.JTextField();
        txtMabansao = new javax.swing.JTextField();
        txtLoaibansao = new javax.swing.JTextField();
        txtGiabansao = new javax.swing.JTextField();
        txtTrangthai = new javax.swing.JTextField();
        btnThemmoibansao = new javax.swing.JButton();
        btn_capnhat = new javax.swing.JButton();
        btn_xoabansao = new javax.swing.JButton();
        txtMasach = new javax.swing.JTextField();
        txt_mbs_begin = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        addnew_hangloat = new javax.swing.JButton();
        update_hangloat = new javax.swing.JButton();
        delete_hangloat = new javax.swing.JButton();
        back_home_btn = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_bansao = new rojeru_san.complementos.RSTableMetro();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(255, 153, 0));

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));

        btn_timkiembansao1.setBackground(new java.awt.Color(0, 102, 102));
        btn_timkiembansao1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_timkiembansao1.setForeground(new java.awt.Color(255, 255, 255));
        btn_timkiembansao1.setText("Tìm kiếm");
        btn_timkiembansao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiembansao1ActionPerformed(evt);
            }
        });

        btn_fillall.setBackground(new java.awt.Color(0, 102, 102));
        btn_fillall.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_fillall.setForeground(new java.awt.Color(255, 255, 255));
        btn_fillall.setText("Xem toàn bộ");
        btn_fillall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fillallActionPerformed(evt);
            }
        });

        txtTimkiembansao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimkiembansaoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setText("QUẢN LÝ BẢN SAO SÁCH");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel3.setText("Nhập mã");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel4.setText("  ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtTimkiembansao, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(btn_timkiembansao1)
                .addGap(35, 35, 35)
                .addComponent(btn_fillall))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(196, 196, 196))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(368, 368, 368))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_timkiembansao1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimkiembansao, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_fillall, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(29, 29, 29))
        );

        jPanel3.setBackground(new java.awt.Color(255, 51, 51));
        jPanel3.setPreferredSize(new java.awt.Dimension(420, 810));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Nhập hàng loạt");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 120, -1));

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("MBS End : ");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Loại bản sao :");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, -1, -1));

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Giá bản sao :");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 640, -1, -1));

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Trạng thái :");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 700, 120, -1));
        jPanel3.add(txt_mbs_end, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 179, 40));
        jPanel3.add(txtMabansao, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 510, 179, 40));
        jPanel3.add(txtLoaibansao, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 570, 179, 40));
        jPanel3.add(txtGiabansao, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 630, 179, 40));
        jPanel3.add(txtTrangthai, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 690, 179, 40));

        btnThemmoibansao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThemmoibansao.setText("Thêm mới");
        btnThemmoibansao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemmoibansaoActionPerformed(evt);
            }
        });
        jPanel3.add(btnThemmoibansao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 780, -1, -1));

        btn_capnhat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_capnhat.setText("Cập nhật");
        btn_capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capnhatActionPerformed(evt);
            }
        });
        jPanel3.add(btn_capnhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 780, -1, -1));

        btn_xoabansao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_xoabansao.setText("Xóa bản sao");
        btn_xoabansao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoabansaoActionPerformed(evt);
            }
        });
        jPanel3.add(btn_xoabansao, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 780, -1, -1));
        jPanel3.add(txtMasach, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 450, 179, 40));
        jPanel3.add(txt_mbs_begin, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 179, 40));

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Mã sách : ");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, -1, -1));

        jLabel16.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Nhập chi tiết");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 120, -1));

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Mã bản sao : ");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, -1, -1));

        jLabel18.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("MBS Begin : ");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        addnew_hangloat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addnew_hangloat.setText("Add New HL");
        addnew_hangloat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addnew_hangloatActionPerformed(evt);
            }
        });
        jPanel3.add(addnew_hangloat, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        update_hangloat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        update_hangloat.setText("Update HL");
        update_hangloat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_hangloatActionPerformed(evt);
            }
        });
        jPanel3.add(update_hangloat, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, -1, -1));

        delete_hangloat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        delete_hangloat.setText("Delete HL");
        delete_hangloat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_hangloatActionPerformed(evt);
            }
        });
        jPanel3.add(delete_hangloat, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, -1, -1));

        back_home_btn.setBackground(new java.awt.Color(0, 106, 106));

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 153));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel9.setText("HOMEPAGE");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout back_home_btnLayout = new javax.swing.GroupLayout(back_home_btn);
        back_home_btn.setLayout(back_home_btnLayout);
        back_home_btnLayout.setHorizontalGroup(
            back_home_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(back_home_btnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        back_home_btnLayout.setVerticalGroup(
            back_home_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, back_home_btnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
        );

        jPanel3.add(back_home_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 60));

        table_bansao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã sách", "Mã bản sao", "Loại bản sao", "Giá bản sao", "Trạng thái"
            }
        ));
        table_bansao.setColorBackgoundHead(new java.awt.Color(0, 106, 106));
        table_bansao.setColorBordeFilas(new java.awt.Color(0, 106, 106));
        table_bansao.setColorBordeHead(new java.awt.Color(255, 255, 255));
        table_bansao.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        table_bansao.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        table_bansao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        table_bansao.setFuenteFilas(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        table_bansao.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        table_bansao.setRowHeight(40);
        table_bansao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                table_bansaoFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(table_bansao);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 849, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table_bansaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_table_bansaoFocusLost

    }//GEN-LAST:event_table_bansaoFocusLost

    private void btn_xoabansaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoabansaoActionPerformed
        String maSach = txtMasach.getText().trim();
        String maBanSao = txtMabansao.getText().trim();
        // Kiểm tra nếu các trường dữ liệu không trống
        if (maSach.isEmpty() || maBanSao.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sách và mã bản sao.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // Kết nối cơ sở dữ liệu và thực hiện kiểm tra mã sách và mã bản sao
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String URL = "jdbc:mysql://localhost:3306/quan_ly_thu_vien";
            String USER = "root";
            String PASSWORD = "";
            // Tạo kết nối tới cơ sở dữ liệu
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            // Kiểm tra xem mã sách và mã bản sao có tồn tại trong cơ sở dữ liệu không
            String checkSQL = "SELECT * FROM bansaosach WHERE maSach = ? AND maBanSao = ?";
            pstmt = conn.prepareStatement(checkSQL);
            pstmt.setString(1, maSach);
            pstmt.setString(2, maBanSao);
            rs = pstmt.executeQuery();
            // Nếu không tìm thấy bản sao tương ứng, thông báo và dừng lại
            if (!rs.next()) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy mã sách và mã bản sao trong cơ sở dữ liệu.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
            // Câu lệnh SQL để xóa bản sao
            String deleteSQL = "DELETE FROM bansaosach WHERE maSach = ? AND maBanSao = ?";
            pstmt = conn.prepareStatement(deleteSQL);
            pstmt.setString(1, maSach);
            pstmt.setString(2, maBanSao);
            int rowsDeleted = pstmt.executeUpdate();
            // Kiểm tra nếu xóa thành công
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(this, "Xóa bản sao thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                // Reset bảng JTable và hiển thị lại dữ liệu
                resetTable(maSach); // Hàm reset bảng với dữ liệu mới theo mã sách
            } else {
                JOptionPane.showMessageDialog(this, "Xóa không thành công. Vui lòng thử lại.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            // Xử lý ngoại lệ
            JOptionPane.showMessageDialog(this, "Lỗi khi kết nối cơ sở dữ liệu: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Đóng kết nối và các tài nguyên
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    // Hàm reset bảng với dữ liệu mới theo mã sách

    private void resetTableJ(String maSach) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String URL = "jdbc:mysql://localhost:3306/quan_ly_thu_vien";
            String USER = "root";
            String PASSWORD = "";
            // Tạo kết nối tới cơ sở dữ liệu
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            // Lệnh SQL để lấy dữ liệu theo mã sách
            String sql = "SELECT * FROM bansaosach WHERE maSach = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, maSach);
            rs = pstmt.executeQuery();
            // Lấy mô hình bảng của JTable
            DefaultTableModel model = (DefaultTableModel) table_bansao.getModel();
            // Xóa dữ liệu cũ trong bảng trước khi đổ dữ liệu mới
            model.setRowCount(0);
            // Duyệt qua ResultSet và thêm từng dòng dữ liệu vào JTable
            while (rs.next()) {
                String maSachFromDB = rs.getString("maSach");
                String maBanSao = rs.getString("maBanSao");
                int loaiBanSao = rs.getInt("loaiBanSao");
                int gia = rs.getInt("gia");
                int trangThai = rs.getInt("trangThai");
                // Thêm dòng dữ liệu vào model của JTable
                model.addRow(new Object[]{maSachFromDB, maBanSao, loaiBanSao, gia, trangThai});
            }
        } catch (SQLException e) {
            // Xử lý ngoại lệ
            JOptionPane.showMessageDialog(this, "Lỗi khi kết nối cơ sở dữ liệu: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Đóng kết nối và các tài nguyên
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_xoabansaoActionPerformed

    private void btn_capnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capnhatActionPerformed
        // TODO add your handling code here:
        // Lấy giá trị từ các ô nhập
        String maSach = txtMasach.getText();
        String maBanSao = txtMabansao.getText();
        String loaiBanSaoStr = txtLoaibansao.getText();
        String giaStr = txtGiabansao.getText().trim();
        String trangThaiStr = txtTrangthai.getText();
        // Kiểm tra nếu các trường dữ liệu không trống
        if (maSach.isEmpty() || maBanSao.isEmpty() || loaiBanSaoStr.isEmpty() || giaStr.isEmpty() || trangThaiStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // Kiểm tra trạng thái (chỉ có thể là 0 hoặc 1)
        int trangThai;
        try {
            trangThai = Integer.parseInt(trangThaiStr);
            if (trangThai != 0 && trangThai != 1) {
                JOptionPane.showMessageDialog(this, "Trạng thái chỉ có thể là 0 hoặc 1.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Trạng thái phải là một số (0 hoặc 1).", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // Kiểm tra loại bản sao (chỉ được nhập số nguyên)
        int loaiBanSao;
        try {
            loaiBanSao = Integer.parseInt(loaiBanSaoStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Loại bản sao phải là một số nguyên.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // Kiểm tra giá bản sao (chỉ được nhập số nguyên)
        int gia;
        try {
            gia = Integer.parseInt(giaStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Giá bản sao phải là một số nguyên.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // Kết nối cơ sở dữ liệu và thực hiện kiểm tra mã sách và mã bản sao
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String URL = "jdbc:mysql://localhost:3306/quan_ly_thu_vien";
            String USER = "root";
            String PASSWORD = "";
            // Tạo kết nối tới cơ sở dữ liệu
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            // Kiểm tra xem mã sách và mã bản sao có tồn tại trong cơ sở dữ liệu không
            String checkSQL = "SELECT * FROM bansaosach WHERE maSach = ? AND maBanSao = ?";
            pstmt = conn.prepareStatement(checkSQL);
            pstmt.setString(1, maSach);
            pstmt.setString(2, maBanSao);
            rs = pstmt.executeQuery();
            // Nếu không tìm thấy bản sao tương ứng, thông báo và dừng lại
            if (!rs.next()) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy mã sách và mã bản sao trong cơ sở dữ liệu.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
            // Cập nhật dữ liệu vào bảng
            String updateSQL = "UPDATE bansaosach SET loaiBanSao = ?, gia = ?, trangThai = ? WHERE maSach = ? AND maBanSao = ?";
            pstmt = conn.prepareStatement(updateSQL);
            pstmt.setInt(1, loaiBanSao);
            pstmt.setInt(2, gia);
            pstmt.setInt(3, trangThai);
            pstmt.setString(4, maSach);
            pstmt.setString(5, maBanSao);
            int rowsUpdated = pstmt.executeUpdate();
            // Kiểm tra nếu cập nhật thành công
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Cập nhật thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                // Reset bảng JTable và hiển thị lại dữ liệu đã cập nhật
                resetTable(maSach); // Hàm reset bảng với dữ liệu mới theo mã sách
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật không thành công. Vui lòng thử lại.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            // Xử lý ngoại lệ
            JOptionPane.showMessageDialog(this, "Lỗi khi kết nối cơ sở dữ liệu: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Đóng kết nối và các tài nguyên
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    // Hàm reset bảng với dữ liệu mới theo mã sách

    private void resetTable(String maSach) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String URL = "jdbc:mysql://localhost:3306/quan_ly_thu_vien";
            String USER = "root";
            String PASSWORD = "";

            // Tạo kết nối tới cơ sở dữ liệu
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Lệnh SQL để lấy dữ liệu theo mã sách
            String sql = "SELECT * FROM bansaosach WHERE maSach = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, maSach);
            rs = pstmt.executeQuery();

            // Lấy mô hình bảng của JTable
            DefaultTableModel model = (DefaultTableModel) table_bansao.getModel();

            // Xóa dữ liệu cũ trong bảng trước khi đổ dữ liệu mới
            model.setRowCount(0);

            // Duyệt qua ResultSet và thêm từng dòng dữ liệu vào JTable
            while (rs.next()) {
                String maSachFromDB = rs.getString("maSach");
                String maBanSao = rs.getString("maBanSao");
                int loaiBanSao = rs.getInt("loaiBanSao");
                int gia = rs.getInt("gia");
                int trangThai = rs.getInt("trangThai");

                // Thêm dòng dữ liệu vào model của JTable
                model.addRow(new Object[]{maSachFromDB, maBanSao, loaiBanSao, gia, trangThai});
            }
        } catch (SQLException e) {
            // Xử lý ngoại lệ
            JOptionPane.showMessageDialog(this, "Lỗi khi kết nối cơ sở dữ liệu: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Đóng kết nối và các tài nguyên
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_capnhatActionPerformed

    private void btnThemmoibansaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemmoibansaoActionPerformed

        String masach = txtMasach.getText();
        String mabansao = txtMabansao.getText();
        String loaibansao = txtLoaibansao.getText();
        String giabansao = txtGiabansao.getText();
        String trangthai = txtTrangthai.getText();

        if (masach.isEmpty() || mabansao.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ Mã Sách và Mã bản sao.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (loaibansao.isEmpty() || giabansao.isEmpty() || trangthai.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin cho bản sao sách ", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/quan_ly_thu_vien";
            String USER = "root";
            String PASSWORD = "";

            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement st = conn.createStatement();

            // Kiểm tra xem mã sách có tồn tại không
            String checkMaSachQuery = "SELECT COUNT(*) AS count FROM sach WHERE maSach = '" + masach + "'";
            ResultSet rsMaSach = st.executeQuery(checkMaSachQuery);

            rsMaSach.next();
            int maSachCount = rsMaSach.getInt("count");

            if (maSachCount == 0) {
                JOptionPane.showMessageDialog(this, "Mã sách không tồn tại ! Xin kiểm tra lại mã sách.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return; // Dừng thao tác nếu mã sách không tồn tại
            }

            // Kiểm tra xem maBanSao đã tồn tại chưa
            String checkMaBanSaoQuery = "SELECT COUNT(*) AS count FROM bansaosach WHERE maBanSao = '" + mabansao + "'";
            ResultSet rsBanSao = st.executeQuery(checkMaBanSaoQuery);

            rsBanSao.next();
            int maBanSaoCount = rsBanSao.getInt("count");

            if (maBanSaoCount > 0) {
                System.out.println("Mã bản sao đã tồn tại!");
                JOptionPane.showMessageDialog(this, "Mã bản sao đã tồn tại! Vui lòng nhập mã khác!");
            } else {
                // Thực hiện thêm mới nếu không trùng lặp
                String insertQuery = "INSERT INTO bansaosach (maSach, maBanSao, loaiBanSao, gia, trangThai) VALUES ('"
                        + masach + "', '" + mabansao + "', "
                        + Integer.parseInt(loaibansao) + ", "
                        + Integer.parseInt(giabansao) + ", "
                        + Integer.parseInt(trangthai) + ")";

                st.executeUpdate(insertQuery);
                JOptionPane.showMessageDialog(this, "Thêm mới bản sao sách thành công!");
            }

            conn.close();

        } catch (Exception e) {
            System.out.println("Kết nối thất bại: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
        }
    }//GEN-LAST:event_btnThemmoibansaoActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        Homepage homepage = new Homepage();
        homepage.show();
        dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void txtTimkiembansaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimkiembansaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimkiembansaoActionPerformed

    private void btn_fillallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fillallActionPerformed
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Thông tin kết nối cơ sở dữ liệu
            String URL = "jdbc:mysql://localhost:3306/quan_ly_thu_vien";
            String USER = "root";
            String PASSWORD = "";

            // Tạo kết nối tới cơ sở dữ liệu
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Lệnh SQL để lấy tất cả dữ liệu từ bảng bansaosach
            String sql = "SELECT * FROM bansaosach";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            // Lấy mô hình bảng của JTable
            DefaultTableModel model = (DefaultTableModel) table_bansao.getModel();

            // Xóa dữ liệu cũ trong bảng trước khi đổ dữ liệu mới
            model.setRowCount(0);

            // Duyệt qua ResultSet và thêm từng dòng dữ liệu vào JTable
            while (rs.next()) {
                // Lấy dữ liệu từ ResultSet
                String maSach = rs.getString("maSach");
                String maBanSao = rs.getString("maBanSao");
                int loaiBanSao = rs.getInt("loaiBanSao");
                int gia = rs.getInt("gia");
                int trangThai = rs.getInt("trangThai");

                // Thêm dòng dữ liệu vào model của JTable
                model.addRow(new Object[]{maSach, maBanSao, loaiBanSao, gia, trangThai});
            }
        } catch (SQLException e) {
            // Xử lý ngoại lệ
            JOptionPane.showMessageDialog(this, "Lỗi khi kết nối cơ sở dữ liệu: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Đóng kết nối và các tài nguyên
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_fillallActionPerformed

    private void btn_timkiembansao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiembansao1ActionPerformed
        // TODO add your handling code here:
        // Lấy giá trị mã sách và mã bản sao từ ô tìm kiếm (một ô nhập cho cả mã sách và mã bản sao)
        String maTimKiem = txtTimkiembansao.getText().trim(); // Lấy giá trị nhập vào (có thể là mã sách hoặc mã bản sao)

        // Kiểm tra nếu ô tìm kiếm trống, thông báo cho người dùng
        if (maTimKiem.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sách hoặc mã bản sao để tìm kiếm.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Kết nối cơ sở dữ liệu
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Thông tin kết nối cơ sở dữ liệu
            String URL = "jdbc:mysql://localhost:3306/quan_ly_thu_vien";
            String USER = "root";
            String PASSWORD = "";

            // Tạo kết nối tới cơ sở dữ liệu
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Lệnh SQL để tìm kiếm theo mã sách và mã bản sao (cả hai trường)
            String sql = "SELECT * FROM bansaosach WHERE maSach LIKE ? OR maBanSao LIKE ?";

            pstmt = conn.prepareStatement(sql);

            // Đặt giá trị vào PreparedStatement cho tham số tìm kiếm
            pstmt.setString(1, "%" + maTimKiem + "%");  // Tìm kiếm mã sách
            pstmt.setString(2, "%" + maTimKiem + "%");  // Tìm kiếm mã bản sao

            rs = pstmt.executeQuery();

            // Lấy mô hình bảng của JTable
            DefaultTableModel model = (DefaultTableModel) table_bansao.getModel();

            // Xóa dữ liệu cũ trong bảng trước khi đổ dữ liệu mới
            model.setRowCount(0);

            // Duyệt qua ResultSet và thêm từng dòng dữ liệu vào JTable
            while (rs.next()) {
                // Lấy dữ liệu từ ResultSet
                String maSach = rs.getString("maSach");
                String maBanSao = rs.getString("maBanSao");
                int loaiBanSao = rs.getInt("loaiBanSao");
                int gia = rs.getInt("gia");
                int trangThai = rs.getInt("trangThai");

                // Thêm dòng dữ liệu vào model của JTable
                model.addRow(new Object[]{maSach, maBanSao, loaiBanSao, gia, trangThai});
            }

            // Nếu không có kết quả, thông báo cho người dùng
            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy kết quả khớp với tìm kiếm.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException e) {
            // Xử lý ngoại lệ
            JOptionPane.showMessageDialog(this, "Lỗi khi kết nối cơ sở dữ liệu: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Đóng kết nối và các tài nguyên
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_timkiembansao1ActionPerformed

    private void addnew_hangloatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addnew_hangloatActionPerformed
        // Lấy thông tin từ các ô nhập liệu
        String maSach = txtMasach.getText().trim();
        String loaiBanSao = txtLoaibansao.getText().trim();
        String giaBanSao = txtGiabansao.getText().trim();
        String trangThai = txtTrangthai.getText().trim();
        String mbsBeginStr = txt_mbs_begin.getText().trim();
        String mbsEndStr = txt_mbs_end.getText().trim();

        // Kiểm tra dữ liệu nhập hợp lệ
        if (maSach.isEmpty() || loaiBanSao.isEmpty() || giaBanSao.isEmpty() || trangThai.isEmpty()
                || mbsBeginStr.isEmpty() || mbsEndStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int mbsBegin, mbsEnd;
        try {
            mbsBegin = Integer.parseInt(mbsBeginStr);
            mbsEnd = Integer.parseInt(mbsEndStr);
            if (mbsEnd <= mbsBegin) {
                JOptionPane.showMessageDialog(this, "Số kết thúc phải lớn hơn số bắt đầu!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số bắt đầu và số kết thúc phải là số nguyên!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // Kết nối cơ sở dữ liệu
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/quan_ly_thu_vien";
            String USER = "root";
            String PASSWORD = "";

            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement st = conn.createStatement();

            // Kiểm tra xem mã sách có tồn tại không
            String checkMaSachQuery = "SELECT COUNT(*) AS count FROM bansaosach WHERE maSach = '" + maSach + "'";
            ResultSet rsCheck = st.executeQuery(checkMaSachQuery);
            rsCheck.next();
            int maSachCount = rsCheck.getInt("count");
            if (maSachCount == 0) {
                JOptionPane.showMessageDialog(this, "Mã sách không tồn tại trong cơ sở dữ liệu!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                conn.close();
                return;
            }

            // Lặp qua các mã bản sao cần tạo
            StringBuilder duplicateMessages = new StringBuilder();
            for (int i = mbsBegin; i <= mbsEnd; i++) {
                String maBanSao = maSach + "-" + String.format("%02d", i);

                // Kiểm tra xem mã bản sao đã tồn tại chưa
                String checkMaBanSaoQuery = "SELECT COUNT(*) AS count FROM bansaosach WHERE maBanSao = '" + maBanSao + "'";
                ResultSet rs = st.executeQuery(checkMaBanSaoQuery);
                rs.next();
                int count = rs.getInt("count");

                if (count > 0) {
                    duplicateMessages.append(maBanSao).append("\n");
                } else {
                    // Thêm mới mã bản sao vào cơ sở dữ liệu
                    String insertQuery = "INSERT INTO bansaosach (maSach, maBanSao, loaiBanSao, gia, trangThai) VALUES ("
                            + "'" + maSach + "', '" + maBanSao + "', "
                            + Integer.parseInt(loaiBanSao) + ", "
                            + Integer.parseInt(giaBanSao) + ", "
                            + Integer.parseInt(trangThai) + ")";
                    st.executeUpdate(insertQuery);
                }
            }

            // Hiển thị thông báo kết quả
            if (duplicateMessages.length() > 0) {
                JOptionPane.showMessageDialog(this, "Đã thêm mới các bản sao thỏa mãn \n" + "Các mã bản sao sau đã tồn tại và không được thêm mới:\n" + duplicateMessages, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Thêm mới hàng loạt mã bản sao thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }

            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage(), "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addnew_hangloatActionPerformed

    private void update_hangloatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_hangloatActionPerformed
        // Lấy giá trị từ các ô nhập liệu
        String maSach = txtMasach.getText().trim();
        String maBanSaoBeginStr = txt_mbs_begin.getText().trim();
        String maBanSaoEndStr = txt_mbs_end.getText().trim();
        String loaiBanSaoStr = txtLoaibansao.getText().trim();
        String giaStr = txtGiabansao.getText().trim();
        String trangThaiStr = txtTrangthai.getText().trim();

        // Kiểm tra nếu các trường mã sách, mã bản sao bắt đầu và mã bản sao kết thúc không được để trống
        if (maSach.isEmpty() || maBanSaoBeginStr.isEmpty() || maBanSaoEndStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ mã sách và phạm vi mã bản sao.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Kiểm tra định dạng và chuyển đổi các giá trị
        int maBanSaoBegin, maBanSaoEnd;
        try {
            maBanSaoBegin = Integer.parseInt(maBanSaoBeginStr);
            maBanSaoEnd = Integer.parseInt(maBanSaoEndStr);
            if (maBanSaoBegin > maBanSaoEnd) {
                JOptionPane.showMessageDialog(this, "Phạm vi mã bản sao không hợp lệ (Begin phải nhỏ hơn hoặc bằng End).", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Mã bản sao bắt đầu và kết thúc phải là số nguyên.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Integer loaiBanSao = null, gia = null, trangThai = null;

        if (!loaiBanSaoStr.isEmpty()) {
            try {
                loaiBanSao = Integer.parseInt(loaiBanSaoStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Loại bản sao phải là một số nguyên.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }

        if (!giaStr.isEmpty()) {
            try {
                gia = Integer.parseInt(giaStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Giá bản sao phải là một số nguyên.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }

        if (!trangThaiStr.isEmpty()) {
            try {
                trangThai = Integer.parseInt(trangThaiStr);
                if (trangThai != 0 && trangThai != 1) {
                    JOptionPane.showMessageDialog(this, "Trạng thái chỉ có thể là 0 hoặc 1.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Trạng thái phải là một số (0 hoặc 1).", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }

        // Kết nối cơ sở dữ liệu và thực hiện cập nhật
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            String URL = "jdbc:mysql://localhost:3306/quan_ly_thu_vien";
            String USER = "root";
            String PASSWORD = "";

            // Tạo kết nối tới cơ sở dữ liệu
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            int rowsUpdated = 0;

            for (int i = maBanSaoBegin; i <= maBanSaoEnd; i++) {
                // Tạo mã bản sao (định dạng "IT1000-02", "IT1000-03", ...)
                String maBanSao = maSach + "-" + String.format("%02d", i);

                // Chuẩn bị câu lệnh SQL động chỉ cập nhật các trường có giá trị
                StringBuilder updateSQL = new StringBuilder("UPDATE bansaosach SET ");
                if (loaiBanSao != null) {
                    updateSQL.append("loaiBanSao = ").append(loaiBanSao).append(", ");
                }
                if (gia != null) {
                    updateSQL.append("gia = ").append(gia).append(", ");
                }
                if (trangThai != null) {
                    updateSQL.append("trangThai = ").append(trangThai).append(", ");
                }

                // Xóa dấu phẩy cuối cùng và thêm điều kiện WHERE
                updateSQL.setLength(updateSQL.length() - 2);
                updateSQL.append(" WHERE maSach = ? AND maBanSao = ?");

                pstmt = conn.prepareStatement(updateSQL.toString());
                pstmt.setString(1, maSach);
                pstmt.setString(2, maBanSao);

                rowsUpdated += pstmt.executeUpdate();
            }

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Cập nhật hàng loạt thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                // Reset bảng JTable và hiển thị lại dữ liệu đã cập nhật
                resetTable(maSach);
            } else {
                JOptionPane.showMessageDialog(this, "Không có bản ghi nào được cập nhật. Vui lòng kiểm tra lại.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi kết nối cơ sở dữ liệu: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Đóng kết nối và các tài nguyên
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_update_hangloatActionPerformed

    private void delete_hangloatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_hangloatActionPerformed
        // Lấy thông tin từ các ô nhập liệu
        String maSach = txtMasach.getText().trim();
        String mbsBeginStr = txt_mbs_begin.getText().trim();
        String mbsEndStr = txt_mbs_end.getText().trim();

        // Kiểm tra dữ liệu nhập hợp lệ
        if (maSach.isEmpty() || mbsBeginStr.isEmpty() || mbsEndStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sách, số bắt đầu và số kết thúc.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int mbsBegin, mbsEnd;
        try {
            mbsBegin = Integer.parseInt(mbsBeginStr);
            mbsEnd = Integer.parseInt(mbsEndStr);
            if (mbsEnd <= mbsBegin) {
                JOptionPane.showMessageDialog(this, "Số kết thúc phải lớn hơn số bắt đầu!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số bắt đầu và số kết thúc phải là số nguyên!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // Kết nối cơ sở dữ liệu
            String URL = "jdbc:mysql://localhost:3306/quan_ly_thu_vien";
            String USER = "root";
            String PASSWORD = "";

            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement pstmtCheck = null;
            PreparedStatement pstmtDelete = null;
            ResultSet rs = null;

            // Kiểm tra xem mã sách có tồn tại không
            String checkMaSachSQL = "SELECT COUNT(*) AS count FROM bansaosach WHERE maSach = ?";
            pstmtCheck = conn.prepareStatement(checkMaSachSQL);
            pstmtCheck.setString(1, maSach);
            rs = pstmtCheck.executeQuery();
            rs.next();
            int maSachCount = rs.getInt("count");
            if (maSachCount == 0) {
                JOptionPane.showMessageDialog(this, "Mã sách không tồn tại trong cơ sở dữ liệu!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                conn.close();
                return;
            }

            // Lặp qua các mã bản sao cần xóa
            StringBuilder notFoundMessages = new StringBuilder();
            int totalDeleted = 0;
            for (int i = mbsBegin; i <= mbsEnd; i++) {
                String maBanSao = maSach + "-" + String.format("%02d", i);

                // Kiểm tra xem mã bản sao có tồn tại không
                String checkMaBanSaoSQL = "SELECT COUNT(*) AS count FROM bansaosach WHERE maSach = ? AND maBanSao = ?";
                pstmtCheck = conn.prepareStatement(checkMaBanSaoSQL);
                pstmtCheck.setString(1, maSach);
                pstmtCheck.setString(2, maBanSao);
                rs = pstmtCheck.executeQuery();
                rs.next();
                int count = rs.getInt("count");

                if (count == 0) {
                    notFoundMessages.append(maBanSao).append("\n");
                } else {
                    // Xóa mã bản sao
                    String deleteSQL = "DELETE FROM bansaosach WHERE maSach = ? AND maBanSao = ?";
                    pstmtDelete = conn.prepareStatement(deleteSQL);
                    pstmtDelete.setString(1, maSach);
                    pstmtDelete.setString(2, maBanSao);
                    totalDeleted += pstmtDelete.executeUpdate();
                }
            }

            // Hiển thị thông báo kết quả
            if (totalDeleted > 0) {
                JOptionPane.showMessageDialog(this, "Đã xóa thành công " + totalDeleted + " bản sao.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
            if (notFoundMessages.length() > 0) {
                JOptionPane.showMessageDialog(this, "Các mã bản sao sau không tồn tại và không được xóa:\n" + notFoundMessages, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }

            // Cập nhật lại bảng JTable
            resetTable(maSach);

            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage(), "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_delete_hangloatActionPerformed

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
            java.util.logging.Logger.getLogger(CopyBookControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CopyBookControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CopyBookControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CopyBookControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CopyBookControl().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addnew_hangloat;
    private javax.swing.JPanel back_home_btn;
    private javax.swing.JButton btnThemmoibansao;
    private javax.swing.JButton btn_capnhat;
    private javax.swing.JToggleButton btn_fillall;
    private javax.swing.JToggleButton btn_timkiembansao1;
    private javax.swing.JButton btn_xoabansao;
    private javax.swing.JButton delete_hangloat;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private rojeru_san.complementos.RSTableMetro table_bansao;
    private javax.swing.JTextField txtGiabansao;
    private javax.swing.JTextField txtLoaibansao;
    private javax.swing.JTextField txtMabansao;
    private javax.swing.JTextField txtMasach;
    private javax.swing.JTextField txtTimkiembansao;
    private javax.swing.JTextField txtTrangthai;
    private javax.swing.JTextField txt_mbs_begin;
    private javax.swing.JTextField txt_mbs_end;
    private javax.swing.JButton update_hangloat;
    // End of variables declaration//GEN-END:variables
}
