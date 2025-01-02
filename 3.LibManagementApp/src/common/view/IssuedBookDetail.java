/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package common.view;

import ConnectDatabase.DatabaseConnection;
import com.mysql.cj.xdevapi.Statement;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Duc Anh
 */
public class IssuedBookDetail extends javax.swing.JFrame {

    /**
     * Creates new form IssuedBookDetail
     */
    public IssuedBookDetail() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Back = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        date_FromDate = new rojeru_san.componentes.RSDateChooser();
        jLabel19 = new javax.swing.JLabel();
        date_ToDate = new rojeru_san.componentes.RSDateChooser();
        jLabel20 = new javax.swing.JLabel();
        but_searchByIssuedDay = new javax.swing.JButton();
        but_ResetTable = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_IssuedBookInfo = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1270, 740));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 106, 106));
        jPanel2.setPreferredSize(new java.awt.Dimension(1270, 400));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Back.setBackground(new java.awt.Color(255, 51, 51));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel6.setText("Back");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout BackLayout = new javax.swing.GroupLayout(Back);
        Back.setLayout(BackLayout);
        BackLayout.setHorizontalGroup(
            BackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        BackLayout.setVerticalGroup(
            BackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackLayout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel2.setText("     Thông tin mượn sách");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 410, 120));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 150, 370, 5));

        date_FromDate.setColorBackground(new java.awt.Color(255, 51, 51));
        date_FromDate.setColorButtonHover(new java.awt.Color(0, 106, 106));
        date_FromDate.setColorForeground(new java.awt.Color(255, 51, 51));
        jPanel2.add(date_FromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 270, -1));

        jLabel19.setBackground(new java.awt.Color(0, 106, 106));
        jLabel19.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("To");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, -1, -1));

        date_ToDate.setColorBackground(new java.awt.Color(255, 51, 51));
        date_ToDate.setColorButtonHover(new java.awt.Color(0, 106, 106));
        date_ToDate.setColorForeground(new java.awt.Color(255, 51, 51));
        jPanel2.add(date_ToDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 200, 270, -1));

        jLabel20.setBackground(new java.awt.Color(0, 106, 106));
        jLabel20.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("From:");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        but_searchByIssuedDay.setBackground(new java.awt.Color(255, 51, 51));
        but_searchByIssuedDay.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        but_searchByIssuedDay.setForeground(new java.awt.Color(255, 255, 255));
        but_searchByIssuedDay.setText("Tìm kiếm");
        but_searchByIssuedDay.setBorder(null);
        but_searchByIssuedDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_searchByIssuedDayActionPerformed(evt);
            }
        });
        jPanel2.add(but_searchByIssuedDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 200, 130, 40));

        but_ResetTable.setBackground(new java.awt.Color(255, 51, 51));
        but_ResetTable.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        but_ResetTable.setForeground(new java.awt.Color(255, 255, 255));
        but_ResetTable.setText("Reset");
        but_ResetTable.setBorder(null);
        but_ResetTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_ResetTableActionPerformed(evt);
            }
        });
        jPanel2.add(but_ResetTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 200, 130, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 260));

        tbl_IssuedBookInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã mượn", "ID sách", "Tên sách", "Mã sinh viên", "Tên sinh viên", "Ngày mượn ", "Hạn trả", "Ngày trả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_IssuedBookInfo.setColorBackgoundHead(new java.awt.Color(0, 106, 106));
        tbl_IssuedBookInfo.setColorBordeFilas(new java.awt.Color(0, 106, 106));
        tbl_IssuedBookInfo.setColorBordeHead(new java.awt.Color(255, 255, 255));
        tbl_IssuedBookInfo.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_IssuedBookInfo.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_IssuedBookInfo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbl_IssuedBookInfo.setFuenteFilas(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tbl_IssuedBookInfo.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tbl_IssuedBookInfo.setRowHeight(40);
        tbl_IssuedBookInfo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tbl_IssuedBookInfoFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_IssuedBookInfo);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 1500, 480));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Hiển thị thông tin mượn sách lên table

    public void setIssuedBookInfoToTable() {
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement pst = con.prepareStatement("""
            SELECT 
                t.maMuon, 
                t.maBanSao, 
                s.tenSach, 
                sv.maSV, 
                sv.tenSV, 
                t.ngayMuon, 
                t.hanTra, 
                t.ngayTra 
            FROM 
                thongtinmuontrasach t
            JOIN 
                bansaosach bs ON t.maBanSao = bs.maBanSao
            JOIN 
                sach s ON bs.maSach = s.maSach
            JOIN 
                sinhvien sv ON t.maNM = sv.maSV;
        """)) {

            ResultSet rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) tbl_IssuedBookInfo.getModel();
            model.setRowCount(0); // Xóa dữ liệu cũ

            while (rs.next()) {
                String maMuon = rs.getString("maMuon");
                String maBanSaoSach = rs.getString("maBanSao");
                String tenSach = rs.getString("tenSach");
                String maNM = rs.getString("maSV");
                String tenNM = rs.getString("tenSV");
                String ngayMuon = rs.getString("ngayMuon");
                String hanTra = rs.getString("hanTra");
                String ngayTra = rs.getString("ngayTra");

                model.addRow(new Object[]{maMuon, maBanSaoSach, tenSach, maNM, tenNM, ngayMuon, hanTra, ngayTra});
            }

        } catch (SQLException e) {
            Logger.getLogger(IssuedBookDetail.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Lỗi khi tải dữ liệu: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // lọc thông tin qua ngày tháng
    public void search() throws SQLException {
    Date uFromDate = date_FromDate.getDatoFecha();
    Date uToDate = date_ToDate.getDatoFecha();

    if (uFromDate == null || uToDate == null) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày bắt đầu và ngày kết thúc!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        return;
    }

    long l1 = uFromDate.getTime();
    long l2 = uToDate.getTime();
    Date fromDate = new Date(l1);
    Date toDate = new Date(l2);

    try (Connection con = DatabaseConnection.getConnection()) {
        String sql = "SELECT t.maMuon, t.maBanSao, s.tenSach, sv.maSV, sv.tenSV, t.ngayMuon, t.hanTra, t.ngayTra " +
                     "FROM thongtinmuontrasach t " +
                     "JOIN bansaosach bs ON t.maBanSao = bs.maBanSao " +
                     "JOIN sach s ON bs.maSach = s.maSach " +
                     "JOIN sinhvien sv ON t.maNM = sv.maSV " +
                     "WHERE t.ngayMuon BETWEEN ? AND ?";
        
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setDate(1, new java.sql.Date(fromDate.getTime()));
        pst.setDate(2, new java.sql.Date(toDate.getTime()));

        ResultSet rs = pst.executeQuery();
        DefaultTableModel model = (DefaultTableModel) tbl_IssuedBookInfo.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ

        boolean found = false;
        while (rs.next()) {
            found = true;
            String maMuon = rs.getString("maMuon");
            String maBanSaoSach = rs.getString("maBanSao");
            String tenSach = rs.getString("tenSach");
            String maNM = rs.getString("maSV");
            String tenNM = rs.getString("tenSV");
            String ngayMuon = rs.getString("ngayMuon");
            String hanTra = rs.getString("hanTra");
            String ngayTra = rs.getString("ngayTra");

            model.addRow(new Object[]{maMuon, maBanSaoSach, tenSach, maNM, tenNM, ngayMuon, hanTra, ngayTra});
        }

        if (!found) {
            JOptionPane.showMessageDialog(this, "Không có bản ghi nào.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi truy vấn dữ liệu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
}

    private void tbl_IssuedBookInfoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tbl_IssuedBookInfoFocusLost
    }//GEN-LAST:event_tbl_IssuedBookInfoFocusLost

    private void but_searchByIssuedDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_searchByIssuedDayActionPerformed
        try {
            search();
        } catch (SQLException ex) {
            Logger.getLogger(IssuedBookDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_but_searchByIssuedDayActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        Homepage hp = new Homepage();
        this.setVisible(false);
        hp.setVisible(true);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void but_ResetTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_ResetTableActionPerformed
        date_FromDate.setDatoFecha(null);
        date_ToDate.setDatoFecha(null);
        setIssuedBookInfoToTable();
    }//GEN-LAST:event_but_ResetTableActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void showManHinh() {
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
            java.util.logging.Logger.getLogger(IssuedBookDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssuedBookDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssuedBookDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssuedBookDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                IssuedBookDetail detail = new IssuedBookDetail();
                detail.setLocationRelativeTo(null);
                detail.setIssuedBookInfoToTable();
                detail.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Back;
    private javax.swing.JButton but_ResetTable;
    private javax.swing.JButton but_searchByIssuedDay;
    private rojeru_san.componentes.RSDateChooser date_FromDate;
    private rojeru_san.componentes.RSDateChooser date_ToDate;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private rojeru_san.complementos.RSTableMetro tbl_IssuedBookInfo;
    // End of variables declaration//GEN-END:variables
}
