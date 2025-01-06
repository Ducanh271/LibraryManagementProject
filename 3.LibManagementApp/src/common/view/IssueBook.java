/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package common.view;

import ConnectDatabase.DatabaseConnection;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Duc Anh
 */
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
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

        panel_main = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Back = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_StatusOfCopyBook = new javax.swing.JLabel();
        lbl_bookID = new javax.swing.JLabel();
        lbl_copyID = new javax.swing.JLabel();
        lbl_bookName = new javax.swing.JLabel();
        lbl_author = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_bookError = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbl_NumbersOfBook = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        lbl_studentID = new javax.swing.JLabel();
        lbl_studentName = new javax.swing.JLabel();
        lbl_course = new javax.swing.JLabel();
        lbl_email = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbl_studentError = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbl_branch = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_StudentID = new javax.swing.JTextField();
        txt_CopyBookID = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btn_IssueBook1 = new necesario.RSMaterialButtonCircle();
        date_dueDate = new rojeru_san.componentes.RSDateChooser();
        date_issueDate = new rojeru_san.componentes.RSDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_main.setBackground(new java.awt.Color(255, 255, 255));
        panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(420, 810));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Back.setBackground(new java.awt.Color(0, 106, 106));

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

        jPanel1.add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel2.setText("     Thông tin sách");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 310, 120));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, 5));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mã sách: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mã bản sao: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tên sách:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tác giả:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, -1, -1));

        lbl_StatusOfCopyBook.setBackground(new java.awt.Color(255, 255, 255));
        lbl_StatusOfCopyBook.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbl_StatusOfCopyBook.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_StatusOfCopyBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 570, 190, 30));

        lbl_bookID.setBackground(new java.awt.Color(255, 255, 255));
        lbl_bookID.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbl_bookID.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_bookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 190, 30));

        lbl_copyID.setBackground(new java.awt.Color(255, 255, 255));
        lbl_copyID.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbl_copyID.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_copyID, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 190, 30));

        lbl_bookName.setBackground(new java.awt.Color(255, 255, 255));
        lbl_bookName.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbl_bookName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 410, 190, 30));

        lbl_author.setBackground(new java.awt.Color(255, 255, 255));
        lbl_author.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbl_author.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 460, 190, 30));

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Trạng thái: ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, 110, -1));

        lbl_bookError.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(255, 255, 255));
        lbl_bookError.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lbl_bookErrorFocusLost(evt);
            }
        });
        jPanel1.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 600, 280, 50));

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Số lượng:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 90, -1));

        lbl_NumbersOfBook.setBackground(new java.awt.Color(255, 255, 255));
        lbl_NumbersOfBook.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbl_NumbersOfBook.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_NumbersOfBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 520, 190, 30));

        panel_main.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 740));

        jPanel3.setBackground(new java.awt.Color(0, 106, 106));
        jPanel3.setPreferredSize(new java.awt.Dimension(420, 810));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, 5));

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Tên sinh viên");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Niên khóa: ");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        label.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        label.setForeground(new java.awt.Color(255, 255, 255));
        label.setText("Email:");
        jPanel3.add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 110, -1));

        lbl_studentID.setBackground(new java.awt.Color(255, 255, 255));
        lbl_studentID.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbl_studentID.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbl_studentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 190, 30));

        lbl_studentName.setBackground(new java.awt.Color(255, 255, 255));
        lbl_studentName.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbl_studentName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbl_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 190, 30));

        lbl_course.setBackground(new java.awt.Color(255, 255, 255));
        lbl_course.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbl_course.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, 190, 30));

        lbl_email.setBackground(new java.awt.Color(255, 255, 255));
        lbl_email.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbl_email.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbl_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 510, 190, 30));

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Mã sinh viên:");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        jLabel19.setBackground(new java.awt.Color(102, 102, 255));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel19.setText("  Thông tin sinh viên");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 310, 120));

        lbl_studentError.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbl_studentError.setForeground(new java.awt.Color(255, 255, 255));
        lbl_studentError.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lbl_studentErrorFocusLost(evt);
            }
        });
        jPanel3.add(lbl_studentError, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 600, 270, 40));

        jLabel16.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Ngành học: ");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 110, -1));

        lbl_branch.setBackground(new java.awt.Color(255, 255, 255));
        lbl_branch.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbl_branch.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbl_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 460, 190, 30));

        panel_main.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 400, 740));

        jPanel5.setBackground(new java.awt.Color(0, 106, 106));

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

        panel_main.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 240, -1, -1));

        jLabel10.setBackground(new java.awt.Color(0, 106, 106));
        jLabel10.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 106, 106));
        jLabel10.setText("Hạn trả:");
        panel_main.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 460, -1, -1));

        jLabel15.setBackground(new java.awt.Color(0, 106, 106));
        jLabel15.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 106, 106));
        jLabel15.setText("Mã sinh viên:");
        panel_main.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 300, -1, -1));

        jLabel17.setBackground(new java.awt.Color(0, 106, 106));
        jLabel17.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 106, 106));
        jLabel17.setText("Mã bản sao:");
        panel_main.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 350, -1, -1));

        jLabel18.setBackground(new java.awt.Color(0, 106, 106));
        jLabel18.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 106, 106));
        jLabel18.setText("Ngày mượn:");
        panel_main.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 410, -1, -1));

        txt_StudentID.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_StudentID.setForeground(new java.awt.Color(0, 106, 106));
        txt_StudentID.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 106, 106)));
        txt_StudentID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_StudentIDFocusLost(evt);
            }
        });
        txt_StudentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_StudentIDActionPerformed(evt);
            }
        });
        panel_main.add(txt_StudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 290, 270, 30));

        txt_CopyBookID.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_CopyBookID.setForeground(new java.awt.Color(0, 106, 106));
        txt_CopyBookID.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 106, 106)));
        txt_CopyBookID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_CopyBookIDFocusLost(evt);
            }
        });
        txt_CopyBookID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CopyBookIDActionPerformed(evt);
            }
        });
        panel_main.add(txt_CopyBookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 350, 270, 30));

        jLabel9.setBackground(new java.awt.Color(102, 102, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 106, 106));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel9.setText("  Thông tin sinh viên");
        panel_main.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 100, 310, 120));

        btn_IssueBook1.setBackground(new java.awt.Color(0, 106, 106));
        btn_IssueBook1.setText("Cho mượn");
        btn_IssueBook1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_IssueBook1ActionPerformed(evt);
            }
        });
        panel_main.add(btn_IssueBook1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 570, 280, 60));

        date_dueDate.setColorBackground(new java.awt.Color(0, 106, 106));
        date_dueDate.setColorButtonHover(new java.awt.Color(0, 106, 106));
        date_dueDate.setColorForeground(new java.awt.Color(0, 106, 106));
        panel_main.add(date_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 460, 270, -1));

        date_issueDate.setColorBackground(new java.awt.Color(0, 106, 106));
        date_issueDate.setColorButtonHover(new java.awt.Color(0, 106, 106));
        date_issueDate.setColorForeground(new java.awt.Color(0, 106, 106));
        panel_main.add(date_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 400, 270, -1));

        getContentPane().add(panel_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_StudentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_StudentIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_StudentIDActionPerformed

    private void txt_CopyBookIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CopyBookIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CopyBookIDActionPerformed

    private void txt_StudentIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_StudentIDFocusLost

        if (!txt_StudentID.getText().equals("")) {
            getStudentDetails();
        }

    }//GEN-LAST:event_txt_StudentIDFocusLost

    private void txt_CopyBookIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_CopyBookIDFocusLost
        if (!txt_CopyBookID.getText().equals("")) {

            getBookDetails();
        }
    }//GEN-LAST:event_txt_CopyBookIDFocusLost

    private void btn_IssueBook1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_IssueBook1ActionPerformed
        if (lendingBook() == true) {
            JOptionPane.showMessageDialog(this, "cho mượn thành công");
        }
        else{
            JOptionPane.showMessageDialog(this, "sách đang không có sẵn, cho mượn thất bại");
        }
    }//GEN-LAST:event_btn_IssueBook1ActionPerformed

    private void lbl_bookErrorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl_bookErrorFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_bookErrorFocusLost

    private void lbl_studentErrorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl_studentErrorFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_studentErrorFocusLost

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        Homepage hp = new Homepage();
        this.setVisible(false);
        hp.setVisible(true);
    }//GEN-LAST:event_jLabel6MouseClicked
    // hàm kiểm tra mã bản sao có tồn tại hay không
    public boolean isCopyExist(String maBanSao) throws Exception {
        String sql = "SELECT 1 FROM bansaosach WHERE maBanSao = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, maBanSao); // Đặt giá trị cho tham số `?`
            try (ResultSet rs = pst.executeQuery()) {
                // Trả về true nếu tồn tại, false nếu không tồn tại
                return rs.next();
            }
        }
    }
// hàm này sẽ được cho vào model
    int status = 0;
    boolean exits = false;
    public void getBookDetails() {
        String copOfBookID = txt_CopyBookID.getText();
        try {
             exits = isCopyExist(copOfBookID);

            if (exits) {
                String bookID = copOfBookID.length() >= 6 ? copOfBookID.substring(0, 6) : copOfBookID;

                try (Connection con = DatabaseConnection.getConnection()) {
                    String query0 = "select trangThai from bansaosach where maBanSao = ?";
                    try (PreparedStatement pst0 = con.prepareStatement(query0)) {
                        pst0.setString(1, copOfBookID);
                        ResultSet rs = pst0.executeQuery();
                        if(rs.next()){
                            status = rs.getInt("trangThai");
                            System.out.println(status);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    String query1 = "select * from sach where maSach = ?";
                    try (PreparedStatement pst = con.prepareStatement(query1)) {
                        pst.setString(1, bookID);
                        try (ResultSet rs = pst.executeQuery()) {
                            if (rs.next()) {
                                lbl_copyID.setText(copOfBookID);
                                lbl_bookID.setText(rs.getString("maSach"));
                                lbl_bookName.setText(rs.getString("tenSach"));
                                lbl_NumbersOfBook.setText(rs.getString("soLuong"));
                                lbl_bookError.setText("");
                                if(status  == 1){
                                    lbl_StatusOfCopyBook.setText("Đang mượn");
                                }
                                else{
                                    lbl_StatusOfCopyBook.setText("Có sẵn");                                  
                                }
                                
                            } else {
                                lbl_copyID.setText("");
                                lbl_bookID.setText("");
                                lbl_bookName.setText("");
                                lbl_NumbersOfBook.setText("");
                                lbl_bookError.setText("Mã bản sao không hợp lệ");
                            }
                        }
                    }

                    String query2 = "SELECT tacgia.tenTacGia FROM tacgia "
                            + "JOIN chitiettacgia ON tacgia.maTacGia = chitiettacgia.maTacGia "
                            + "WHERE chitiettacgia.maSach = ?";
                    try (PreparedStatement pst2 = con.prepareStatement(query2)) {
                        pst2.setString(1, bookID);
                        try (ResultSet rs2 = pst2.executeQuery()) {
                            if (rs2.next()) {
                                lbl_author.setText(rs2.getString("tenTacGia"));
                            }

                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    // Thêm thông báo lỗi cho người dùng ở đây
                }
            } else {
                lbl_copyID.setText("");
                lbl_bookID.setText("");
                lbl_bookName.setText("");
                lbl_NumbersOfBook.setText("");
                lbl_author.setText("");
                lbl_StatusOfCopyBook.setText("");
                lbl_bookError.setText("Mã bản sao không hợp lệ");
            }
        } catch (Exception ex) {
            Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // hàm này sẽ được cho vào model
    public void getStudentDetails() {
        String studentID = txt_StudentID.getText();
        try (Connection con = DatabaseConnection.getConnection()) {
            String query1 = "select * from sinhvien where maSV = ?";
            try (PreparedStatement pst = con.prepareStatement(query1)) {
                pst.setString(1, studentID);
                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        lbl_studentID.setText(rs.getString("maSV"));
                        lbl_studentName.setText(rs.getString("tenSV"));
                        lbl_course.setText(rs.getString("nienKhoa"));
                        lbl_branch.setText(rs.getString("nganhHoc"));
                        lbl_email.setText(rs.getString("email"));
                        lbl_studentError.setText("");
                    } else {
                        lbl_studentID.setText("");
                        lbl_studentName.setText("");
                        lbl_course.setText("");
                        lbl_branch.setText("");
                        lbl_email.setText("");
                        lbl_studentError.setText("Không tồn tại sinh viên này");
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Thêm thông báo lỗi cho người dùng ở đây
        }

    }
    // hàm thêm thông tin mượn sách vào database

    public boolean lendingBook() {
        Boolean isIssued = false;  // Đặt mặc định là false
        String copyID = txt_CopyBookID.getText();
        String studentID = txt_StudentID.getText();
        String bookName = lbl_bookName.getText();
        String studentName = lbl_studentName.getText();
        String studentEmail = lbl_email.getText();
        Date uIssueDate = date_issueDate.getDatoFecha();
        Date uDueDate = date_dueDate.getDatoFecha();

        long l1 = uIssueDate.getTime(); // Sửa lại dòng này để lấy ngày mượn
        long l2 = uDueDate.getTime();

        java.sql.Date sIssueDate = new java.sql.Date(l1);
        java.sql.Date sDueDate = new java.sql.Date(l2);
        if(status == 0 && exits){
        try (Connection con = DatabaseConnection.getConnection()) {
            // Câu lệnh SQL để thêm thông tin mượn sách
            String sql = "INSERT INTO thongtinmuontrasach (maMuon, ngayMuon, hanTra, trangThai, maNM, maBanSao) VALUES (?, ?, ?, ?, ?, ?)";
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                // Sinh UUID ngẫu nhiên và lấy 4 ký tự đầu
                String issueID = "TQB" + uuid.substring(0, 4); // TQB + 4 ký tự đầu
                pst.setString(1, issueID);
                pst.setDate(2, sIssueDate);
                pst.setDate(3, sDueDate);
                pst.setInt(4, 1); // Trang thái: 1 có thể là "Đang mượn"
                pst.setString(5, studentID);
                pst.setString(6, copyID);

                int rowCount = pst.executeUpdate(); // Thực thi câu lệnh insert

                if (rowCount > 0) { // Nếu có dòng bị ảnh hưởng
                    isIssued = true;

                } else {
                    isIssued = false;
                }
            } catch (Exception e) {
                e.printStackTrace(); // In lỗi nếu có
                isIssued = false;
            }
            String sql1= "UPDATE bansaosach SET trangThai = 1 WHERE maBanSao = ?";
            String sql2= "UPDATE thongtinmuontrasach SET trangThai = 1 WHERE maBanSao = ?";
            try (PreparedStatement pst = con.prepareStatement(sql1)){
                pst.setString(1, copyID);
                int rs = pst.executeUpdate();
                if(rs>0){
                    System.out.println("cập nhật thành cônng");
                }
                else{
                    System.out.println("cập nhật thất bại");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
           try (PreparedStatement pst = con.prepareStatement(sql2)){
                pst.setString(1, copyID);
                int rs = pst.executeUpdate();
                if(rs>0){
                    System.out.println("cập nhật thành cônng");
                }
                else{
                    System.out.println("cập nhật thất bại");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace(); // In lỗi kết nối nếu có
            isIssued = false;
        }
        }

        return isIssued; // Trả về true nếu mượn thành công, false nếu có lỗi
    }

    /**
     * @param args the command line arguments
     */
    public static void showIssueBookScreen() {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                IssueBook issueBook = new IssueBook();
                issueBook.setLocationRelativeTo(null);
                issueBook.setVisible(true);

            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Back;
    private necesario.RSMaterialButtonCircle btn_IssueBook1;
    private rojeru_san.componentes.RSDateChooser date_dueDate;
    private rojeru_san.componentes.RSDateChooser date_issueDate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel label;
    private javax.swing.JLabel lbl_NumbersOfBook;
    private javax.swing.JLabel lbl_StatusOfCopyBook;
    private javax.swing.JLabel lbl_author;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JLabel lbl_bookID;
    private javax.swing.JLabel lbl_bookName;
    private javax.swing.JLabel lbl_branch;
    private javax.swing.JLabel lbl_copyID;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_studentError;
    private javax.swing.JLabel lbl_studentID;
    private javax.swing.JLabel lbl_studentName;
    private javax.swing.JPanel panel_main;
    private javax.swing.JTextField txt_CopyBookID;
    private javax.swing.JTextField txt_StudentID;
    // End of variables declaration//GEN-END:variables
}
