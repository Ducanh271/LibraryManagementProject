/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package common.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;


/**
 *
 * @author lenhh
 */
public class Homepage extends javax.swing.JFrame {
 private String tennm,manm,theloai,tensach,masach,email;
  private int soluong;
    DefaultTableModel model;
    public Homepage() {
         initComponents();
         loadnguoimuon();
         loadsach();
         loadThongKe();
    }

     public void loadnguoimuon(){
        try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quan_ly_thu_vien","root","");
         java.sql.Statement st = con.createStatement();
         java.sql.ResultSet rs= st.executeQuery("select * from sinhvien");
         while(rs.next()){
         String masv = rs.getString("maSV");
         String tensv = rs.getString("tenSV");
         String email = rs.getString("email");
         String nienkhoa =rs.getString("nienKhoa");
         String nganhhoc =rs.getString("nganhHoc");
         Object[] ob = {masv,tensv,email,nienkhoa,nganhhoc};
         model =(DefaultTableModel) tblnguoimuon.getModel();
         model.addRow(ob);
         }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadsach(){
        try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quan_ly_thu_vien","root","");
         java.sql.Statement st = con.createStatement();
         java.sql.ResultSet rs= st.executeQuery("select * from sach");
         while(rs.next()){
         String masach = rs.getString("maSach");
         String tensach = rs.getString("tenSach");
         String theloai = rs.getString("theLoai");
         int soluong = rs.getInt("soLuong");
         Object[] sach = {masach,tensach,theloai,soluong};
         model =(DefaultTableModel) tblsach.getModel();
         model.addRow(sach);
         }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadThongKe() {
    Connection con = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quan_ly_thu_vien", "root", "");
        String querySoSach = "SELECT COUNT(maBanSao) FROM bansaosach";
        java.sql.PreparedStatement psSoSach = con.prepareStatement(querySoSach);
        java.sql.ResultSet rsSoSach = psSoSach.executeQuery();
        int soSach = 0;
        if (rsSoSach.next()) {
            soSach = rsSoSach.getInt(1);
            txtsosach.setText(String.valueOf(soSach));
        }
        String querySoNguoiMuon = "SELECT COUNT(DISTINCT maNM) FROM thongtinmuontrasach where trangThai =1 ";
        java.sql.PreparedStatement psSoNguoiMuon = con.prepareStatement(querySoNguoiMuon);
        java.sql.ResultSet rsSoNguoiMuon = psSoNguoiMuon.executeQuery();
        int soNguoiMuon = 0;
        if (rsSoNguoiMuon.next()) {
            soNguoiMuon = rsSoNguoiMuon.getInt(1);
            txtnguoimuon.setText(String.valueOf(soNguoiMuon));
        }
        String querySoDangMuon = "SELECT COUNT(DISTINCT maBanSao) FROM thongtinmuontrasach where trangThai =1";
        java.sql.PreparedStatement psSoDangMuon = con.prepareStatement(querySoDangMuon);
        java.sql.ResultSet rsSoDangMuon = psSoDangMuon.executeQuery();
        int soDangMuon = 0;
        if (rsSoDangMuon.next()) {
            soDangMuon = rsSoDangMuon.getInt(1);
            txtdangmuon.setText(String.valueOf(soDangMuon));
        }
        int soConLai = soSach - soDangMuon;
        txtconlai.setText(String.valueOf(soConLai));
        DefaultPieDataset barDataset = new DefaultPieDataset( );
      barDataset.setValue("số đang mượn" , Double.valueOf(Integer.parseInt(txtdangmuon.getText())));  
      barDataset.setValue("Số còn lại" , Double.valueOf(Integer.parseInt(txtconlai.getText())));    
      
      //create chart
       JFreeChart piechart = ChartFactory.createPieChart("Thống kê sách",barDataset, false,true,false);//explain
      
        PiePlot piePlot =(PiePlot) piechart.getPlot();
      
       //changing pie chart blocks colors
       piePlot.setSectionPaint("Số đang mượn", new Color(255,255,102));
        piePlot.setSectionPaint("Số còn lại", new Color(102,255,102));

      
       
        piePlot.setBackgroundPaint(Color.white);
        
        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        chart.removeAll();
        chart.add(barChartPanel, BorderLayout.CENTER);
        chart.validate();

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        jPanel44 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        jPanel46 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        jPanel48 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jPanel49 = new javax.swing.JPanel();
        jPanel50 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jPanel51 = new javax.swing.JPanel();
        jPanel52 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jPanel53 = new javax.swing.JPanel();
        jPanel54 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jPanel55 = new javax.swing.JPanel();
        jPanel56 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jPanel57 = new javax.swing.JPanel();
        jPanel58 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jPanel59 = new javax.swing.JPanel();
        jPanel60 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jPanel61 = new javax.swing.JPanel();
        jPanel62 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jPanel63 = new javax.swing.JPanel();
        jPanel64 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jPanel65 = new javax.swing.JPanel();
        jPanel66 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jPanel67 = new javax.swing.JPanel();
        jPanel68 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jPanel69 = new javax.swing.JPanel();
        jPanel70 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jPanel71 = new javax.swing.JPanel();
        jPanel72 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jPanel73 = new javax.swing.JPanel();
        jPanel74 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jPanel75 = new javax.swing.JPanel();
        jPanel76 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jPanel77 = new javax.swing.JPanel();
        jPanel78 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jPanel79 = new javax.swing.JPanel();
        jPanel80 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jPanel81 = new javax.swing.JPanel();
        jPanel82 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jPanel83 = new javax.swing.JPanel();
        jPanel84 = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jPanel85 = new javax.swing.JPanel();
        jPanel86 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jPanel87 = new javax.swing.JPanel();
        jPanel88 = new javax.swing.JPanel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jPanel89 = new javax.swing.JPanel();
        jPanel90 = new javax.swing.JPanel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jPanel91 = new javax.swing.JPanel();
        txtsosach = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jPanel92 = new javax.swing.JPanel();
        txtnguoimuon = new javax.swing.JLabel();
        jPanel93 = new javax.swing.JPanel();
        txtdangmuon = new javax.swing.JLabel();
        jPanel94 = new javax.swing.JPanel();
        txtconlai = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblnguoimuon = new rojeru_san.complementos.RSTableMetro();
        jLabel95 = new javax.swing.JLabel();
        chart = new javax.swing.JPanel();
        jPanel95 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblsach = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 106, 106));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_menu_48px_1.png"))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 21)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Trang chủ");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/male_user_50px.png"))); // NOI18N
        jLabel3.setText("Xin chào,ad");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1043, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(45, 45, 45))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1440, 70));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 52, 51));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel6.setText(" Trang chủ");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Books_26px.png"))); // NOI18N
        jLabel9.setText("Quản lý bản sao");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(255, 52, 51));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel10.setText(" Trang chủ");
        jPanel10.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel11.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel11.setText("Chức năng");
        jPanel9.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel5.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 160, 40));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 180, 40));

        jPanel7.setBackground(new java.awt.Color(255, 52, 51));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel7.setText(" Trang chủ");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel8.setBackground(new java.awt.Color(255, 52, 51));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel8.setText(" Trang chủ");
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 190, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Các chức năng");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jPanel11.setBackground(new java.awt.Color(102, 102, 255));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
        });
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(255, 52, 51));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel12.setText(" Trang chủ");
        jPanel12.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel11.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel13.setBackground(new java.awt.Color(102, 102, 255));
        jLabel13.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Exit_26px_2.png"))); // NOI18N
        jLabel13.setText("Đăng xuất");
        jPanel11.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel13.setBackground(new java.awt.Color(51, 51, 51));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(255, 52, 51));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel14.setText(" Trang chủ");
        jPanel14.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel13.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel15.setText("Chức năng");
        jPanel13.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel11.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 160, 40));

        jPanel15.setBackground(new java.awt.Color(51, 51, 51));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel16.setBackground(new java.awt.Color(255, 52, 51));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel16.setText(" Trang chủ");
        jPanel16.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel15.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel17.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel17.setText("Chức năng");
        jPanel15.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel17.setBackground(new java.awt.Color(51, 51, 51));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel18.setBackground(new java.awt.Color(255, 52, 51));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel18.setText(" Trang chủ");
        jPanel18.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel17.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel19.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel19.setText("Chức năng");
        jPanel17.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel15.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 160, 40));

        jPanel11.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 160, 40));

        jPanel19.setBackground(new java.awt.Color(51, 51, 51));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel20.setBackground(new java.awt.Color(255, 52, 51));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel20.setText(" Trang chủ");
        jPanel20.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel19.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel21.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 204, 204));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel21.setText("Quản lý sách");
        jPanel19.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel21.setBackground(new java.awt.Color(51, 51, 51));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel22.setBackground(new java.awt.Color(255, 52, 51));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel22.setText(" Trang chủ");
        jPanel22.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel21.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel23.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel23.setText("Chức năng");
        jPanel21.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel19.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 160, 40));

        jPanel23.setBackground(new java.awt.Color(51, 51, 51));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel24.setBackground(new java.awt.Color(255, 52, 51));
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel24.setText(" Trang chủ");
        jPanel24.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel23.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel25.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel25.setText("Chức năng");
        jPanel23.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel25.setBackground(new java.awt.Color(51, 51, 51));
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel26.setBackground(new java.awt.Color(255, 52, 51));
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel26.setText(" Trang chủ");
        jPanel26.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel25.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel27.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel27.setText("Chức năng");
        jPanel25.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel23.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 160, 40));

        jPanel19.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 160, 40));

        jPanel11.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 160, 40));

        jPanel4.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 190, 40));

        jPanel27.setBackground(new java.awt.Color(51, 51, 51));
        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel28.setBackground(new java.awt.Color(255, 52, 51));
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel28.setText(" Trang chủ");
        jPanel28.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel27.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel29.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(204, 204, 204));
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Book_26px.png"))); // NOI18N
        jLabel29.setText("Quản lý sách");
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
        });
        jPanel27.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel29.setBackground(new java.awt.Color(51, 51, 51));
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel30.setBackground(new java.awt.Color(255, 52, 51));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel30.setText(" Trang chủ");
        jPanel30.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel29.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel31.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel31.setText("Chức năng");
        jPanel29.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel27.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 160, 40));

        jPanel31.setBackground(new java.awt.Color(51, 51, 51));
        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel32.setBackground(new java.awt.Color(255, 52, 51));
        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel32.setText(" Trang chủ");
        jPanel32.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel31.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel33.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel33.setText("Chức năng");
        jPanel31.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel33.setBackground(new java.awt.Color(51, 51, 51));
        jPanel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel34.setBackground(new java.awt.Color(255, 52, 51));
        jPanel34.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel34.setText(" Trang chủ");
        jPanel34.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel33.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel35.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel35.setText("Chức năng");
        jPanel33.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel31.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 160, 40));

        jPanel27.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 160, 40));

        jPanel35.setBackground(new java.awt.Color(51, 51, 51));
        jPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel36.setBackground(new java.awt.Color(255, 52, 51));
        jPanel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel36.setText(" Trang chủ");
        jPanel36.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel35.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel37.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(204, 204, 204));
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel37.setText("Quản lý sách");
        jPanel35.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel37.setBackground(new java.awt.Color(51, 51, 51));
        jPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel38.setBackground(new java.awt.Color(255, 52, 51));
        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel38.setText(" Trang chủ");
        jPanel38.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel37.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel39.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel39.setText("Chức năng");
        jPanel37.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel35.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 160, 40));

        jPanel39.setBackground(new java.awt.Color(51, 51, 51));
        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel40.setBackground(new java.awt.Color(255, 52, 51));
        jPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel40.setText(" Trang chủ");
        jPanel40.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel39.add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel41.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel41.setText("Chức năng");
        jPanel39.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel41.setBackground(new java.awt.Color(51, 51, 51));
        jPanel41.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel42.setBackground(new java.awt.Color(255, 52, 51));
        jPanel42.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel42.setText(" Trang chủ");
        jPanel42.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel41.add(jPanel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel43.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel43.setText("Chức năng");
        jPanel41.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel39.add(jPanel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 160, 40));

        jPanel35.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 160, 40));

        jPanel27.add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 160, 40));

        jPanel4.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 180, 40));

        jPanel43.setBackground(new java.awt.Color(51, 51, 51));
        jPanel43.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel44.setBackground(new java.awt.Color(255, 52, 51));
        jPanel44.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel44.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel44.setText(" Trang chủ");
        jPanel44.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel43.add(jPanel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel45.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(204, 204, 204));
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        jLabel45.setText("Mượn sách");
        jLabel45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel45MouseClicked(evt);
            }
        });
        jPanel43.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, -1));

        jPanel45.setBackground(new java.awt.Color(51, 51, 51));
        jPanel45.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel46.setBackground(new java.awt.Color(255, 52, 51));
        jPanel46.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel46.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel46.setText(" Trang chủ");
        jPanel46.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel45.add(jPanel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel47.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel47.setText("Chức năng");
        jPanel45.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel43.add(jPanel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 160, 40));

        jPanel47.setBackground(new java.awt.Color(51, 51, 51));
        jPanel47.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel48.setBackground(new java.awt.Color(255, 52, 51));
        jPanel48.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel48.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel48.setText(" Trang chủ");
        jPanel48.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel47.add(jPanel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel49.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel49.setText("Chức năng");
        jPanel47.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel49.setBackground(new java.awt.Color(51, 51, 51));
        jPanel49.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel50.setBackground(new java.awt.Color(255, 52, 51));
        jPanel50.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel50.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel50.setText(" Trang chủ");
        jPanel50.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel49.add(jPanel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel51.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel51.setText("Chức năng");
        jPanel49.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel47.add(jPanel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 160, 40));

        jPanel43.add(jPanel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 160, 40));

        jPanel51.setBackground(new java.awt.Color(51, 51, 51));
        jPanel51.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel52.setBackground(new java.awt.Color(255, 52, 51));
        jPanel52.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel52.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel52.setText(" Trang chủ");
        jPanel52.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel51.add(jPanel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel53.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(204, 204, 204));
        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel53.setText("Quản lý sách");
        jPanel51.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel53.setBackground(new java.awt.Color(51, 51, 51));
        jPanel53.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel54.setBackground(new java.awt.Color(255, 52, 51));
        jPanel54.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel54.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel54.setText(" Trang chủ");
        jPanel54.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel53.add(jPanel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel55.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel55.setText("Chức năng");
        jPanel53.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel51.add(jPanel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 160, 40));

        jPanel55.setBackground(new java.awt.Color(51, 51, 51));
        jPanel55.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel56.setBackground(new java.awt.Color(255, 52, 51));
        jPanel56.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel56.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel56.setText(" Trang chủ");
        jPanel56.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel55.add(jPanel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel57.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel57.setText("Chức năng");
        jPanel55.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel57.setBackground(new java.awt.Color(51, 51, 51));
        jPanel57.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel58.setBackground(new java.awt.Color(255, 52, 51));
        jPanel58.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel58.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel58.setText(" Trang chủ");
        jPanel58.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel57.add(jPanel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel59.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel59.setText("Chức năng");
        jPanel57.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel55.add(jPanel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 160, 40));

        jPanel51.add(jPanel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 160, 40));

        jPanel43.add(jPanel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 160, 40));

        jPanel4.add(jPanel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 180, 40));

        jPanel59.setBackground(new java.awt.Color(51, 51, 51));
        jPanel59.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel60.setBackground(new java.awt.Color(255, 52, 51));
        jPanel60.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel60.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel60.setText(" Trang chủ");
        jPanel60.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel59.add(jPanel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel61.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(204, 204, 204));
        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_View_Details_26px.png"))); // NOI18N
        jLabel61.setText("Thông tin mượn trả");
        jLabel61.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel61MouseClicked(evt);
            }
        });
        jPanel59.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 180, -1));

        jPanel61.setBackground(new java.awt.Color(51, 51, 51));
        jPanel61.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel62.setBackground(new java.awt.Color(255, 52, 51));
        jPanel62.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel62.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel62.setText(" Trang chủ");
        jPanel62.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel61.add(jPanel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel63.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel63.setText("Chức năng");
        jPanel61.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel59.add(jPanel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 160, 40));

        jPanel63.setBackground(new java.awt.Color(51, 51, 51));
        jPanel63.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel64.setBackground(new java.awt.Color(255, 52, 51));
        jPanel64.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel64.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel64.setText(" Trang chủ");
        jPanel64.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel63.add(jPanel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel65.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel65.setText("Chức năng");
        jPanel63.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel65.setBackground(new java.awt.Color(51, 51, 51));
        jPanel65.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel66.setBackground(new java.awt.Color(255, 52, 51));
        jPanel66.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel66.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel66.setText(" Trang chủ");
        jPanel66.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel65.add(jPanel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel67.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel67.setText("Chức năng");
        jPanel65.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel63.add(jPanel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 160, 40));

        jPanel59.add(jPanel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 160, 40));

        jPanel67.setBackground(new java.awt.Color(51, 51, 51));
        jPanel67.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel68.setBackground(new java.awt.Color(255, 52, 51));
        jPanel68.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel68.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel68.setText(" Trang chủ");
        jPanel68.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel67.add(jPanel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel69.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(204, 204, 204));
        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel69.setText("Quản lý sách");
        jPanel67.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel69.setBackground(new java.awt.Color(51, 51, 51));
        jPanel69.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel70.setBackground(new java.awt.Color(255, 52, 51));
        jPanel70.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel70.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel70.setText(" Trang chủ");
        jPanel70.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel69.add(jPanel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel71.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel71.setText("Chức năng");
        jPanel69.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel67.add(jPanel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 160, 40));

        jPanel71.setBackground(new java.awt.Color(51, 51, 51));
        jPanel71.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel72.setBackground(new java.awt.Color(255, 52, 51));
        jPanel72.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel72.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel72.setText(" Trang chủ");
        jPanel72.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel71.add(jPanel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel73.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel73.setText("Chức năng");
        jPanel71.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel73.setBackground(new java.awt.Color(51, 51, 51));
        jPanel73.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel74.setBackground(new java.awt.Color(255, 52, 51));
        jPanel74.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel74.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel74.setText(" Trang chủ");
        jPanel74.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel73.add(jPanel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel75.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel75.setText("Chức năng");
        jPanel73.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel71.add(jPanel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 160, 40));

        jPanel67.add(jPanel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 160, 40));

        jPanel59.add(jPanel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 160, 40));

        jPanel4.add(jPanel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 160, 40));

        jPanel75.setBackground(new java.awt.Color(51, 51, 51));
        jPanel75.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel76.setBackground(new java.awt.Color(255, 52, 51));
        jPanel76.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel76.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel76.setText(" Trang chủ");
        jPanel76.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel75.add(jPanel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel77.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(204, 204, 204));
        jLabel77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Return_Purchase_26px.png"))); // NOI18N
        jLabel77.setText("Trả sách");
        jLabel77.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel77MouseClicked(evt);
            }
        });
        jPanel75.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel77.setBackground(new java.awt.Color(51, 51, 51));
        jPanel77.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel78.setBackground(new java.awt.Color(255, 52, 51));
        jPanel78.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel78.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel78.setText(" Trang chủ");
        jPanel78.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel77.add(jPanel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel79.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel79.setText("Chức năng");
        jPanel77.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel75.add(jPanel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 160, 40));

        jPanel79.setBackground(new java.awt.Color(51, 51, 51));
        jPanel79.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel80.setBackground(new java.awt.Color(255, 52, 51));
        jPanel80.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel80.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jLabel80.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel80.setText(" Trang chủ");
        jPanel80.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel79.add(jPanel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel81.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(255, 255, 255));
        jLabel81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel81.setText("Chức năng");
        jPanel79.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel81.setBackground(new java.awt.Color(51, 51, 51));
        jPanel81.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel82.setBackground(new java.awt.Color(255, 52, 51));
        jPanel82.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel82.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel82.setText(" Trang chủ");
        jPanel82.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel81.add(jPanel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel83.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel83.setText("Chức năng");
        jPanel81.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel79.add(jPanel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 160, 40));

        jPanel75.add(jPanel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 160, 40));

        jPanel83.setBackground(new java.awt.Color(51, 51, 51));
        jPanel83.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel84.setBackground(new java.awt.Color(255, 52, 51));
        jPanel84.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel84.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(255, 255, 255));
        jLabel84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel84.setText(" Trang chủ");
        jPanel84.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel83.add(jPanel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel85.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(204, 204, 204));
        jLabel85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel85.setText("Quản lý sách");
        jPanel83.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel85.setBackground(new java.awt.Color(51, 51, 51));
        jPanel85.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel86.setBackground(new java.awt.Color(255, 52, 51));
        jPanel86.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel86.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(255, 255, 255));
        jLabel86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel86.setText(" Trang chủ");
        jPanel86.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel85.add(jPanel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel87.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(255, 255, 255));
        jLabel87.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel87.setText("Chức năng");
        jPanel85.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel83.add(jPanel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 160, 40));

        jPanel87.setBackground(new java.awt.Color(51, 51, 51));
        jPanel87.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel88.setBackground(new java.awt.Color(255, 52, 51));
        jPanel88.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel88.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(255, 255, 255));
        jLabel88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel88.setText(" Trang chủ");
        jPanel88.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel87.add(jPanel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel89.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(255, 255, 255));
        jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel89.setText("Chức năng");
        jPanel87.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel89.setBackground(new java.awt.Color(51, 51, 51));
        jPanel89.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel90.setBackground(new java.awt.Color(255, 52, 51));
        jPanel90.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel90.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(255, 255, 255));
        jLabel90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel90.setText(" Trang chủ");
        jPanel90.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel89.add(jPanel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 40));

        jLabel91.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(255, 255, 255));
        jLabel91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel91.setText("Chức năng");
        jPanel89.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel87.add(jPanel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 160, 40));

        jPanel83.add(jPanel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 160, 40));

        jPanel75.add(jPanel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 160, 40));

        jPanel4.add(jPanel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 180, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 190, 820));

        jPanel91.setBackground(new java.awt.Color(204, 204, 204));
        jPanel91.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        jPanel91.setForeground(new java.awt.Color(255, 255, 255));

        txtsosach.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtsosach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Book_Shelf_50px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel91Layout = new javax.swing.GroupLayout(jPanel91);
        jPanel91.setLayout(jPanel91Layout);
        jPanel91Layout.setHorizontalGroup(
            jPanel91Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel91Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(txtsosach, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel91Layout.setVerticalGroup(
            jPanel91Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel91Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(txtsosach)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 160, 90));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Số sách còn lại");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 80, 140, 30));

        jLabel92.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel92.setText("Số lượng sách");
        jPanel1.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 130, 30));

        jLabel93.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel93.setText("Thông tin sinh viên mượn sách:");
        jPanel1.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, -1, -1));

        jLabel94.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel94.setText("Số sách đang mượn");
        jPanel1.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 80, 170, 30));

        jPanel92.setBackground(new java.awt.Color(204, 204, 204));
        jPanel92.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 0, 0, 0, new java.awt.Color(102, 102, 255)));
        jPanel92.setForeground(new java.awt.Color(255, 255, 255));

        txtnguoimuon.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtnguoimuon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_People_50px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel92Layout = new javax.swing.GroupLayout(jPanel92);
        jPanel92.setLayout(jPanel92Layout);
        jPanel92Layout.setHorizontalGroup(
            jPanel92Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel92Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtnguoimuon, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel92Layout.setVerticalGroup(
            jPanel92Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel92Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtnguoimuon)
                .addGap(17, 17, 17))
        );

        jPanel1.add(jPanel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, 170, 90));

        jPanel93.setBackground(new java.awt.Color(204, 204, 204));
        jPanel93.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        jPanel93.setForeground(new java.awt.Color(255, 255, 255));

        txtdangmuon.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtdangmuon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Sell_50px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel93Layout = new javax.swing.GroupLayout(jPanel93);
        jPanel93.setLayout(jPanel93Layout);
        jPanel93Layout.setHorizontalGroup(
            jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel93Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(txtdangmuon, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel93Layout.setVerticalGroup(
            jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel93Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(txtdangmuon)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 110, 170, 90));

        jPanel94.setBackground(new java.awt.Color(204, 204, 204));
        jPanel94.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 0, 0, 0, new java.awt.Color(102, 102, 255)));
        jPanel94.setForeground(new java.awt.Color(255, 255, 255));

        txtconlai.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtconlai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_List_of_Thumbnails_50px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel94Layout = new javax.swing.GroupLayout(jPanel94);
        jPanel94.setLayout(jPanel94Layout);
        jPanel94Layout.setHorizontalGroup(
            jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel94Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtconlai, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel94Layout.setVerticalGroup(
            jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel94Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(txtconlai)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 110, 160, 90));

        tblnguoimuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sinh viên", "Tên sinh viên", "Email", "Niên khóa", "Ngành học"
            }
        ));
        tblnguoimuon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tblnguoimuon.setRowHeight(40);
        jScrollPane2.setViewportView(tblnguoimuon);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 700, 210));

        jLabel95.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel95.setText("Số sinh viên mượn");
        jPanel1.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 160, 30));

        chart.setBackground(new java.awt.Color(255, 255, 255));
        chart.setLayout(new java.awt.BorderLayout());
        jPanel1.add(chart, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 340, 320, 400));

        jPanel95.setBackground(new java.awt.Color(0, 106, 106));
        jPanel95.setForeground(new java.awt.Color(0, 106, 106));

        tblsach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sách", "Tên sách", "Thể loại", "Số lượng"
            }
        ));
        tblsach.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tblsach.setRowHeight(40);
        jScrollPane1.setViewportView(tblsach);

        javax.swing.GroupLayout jPanel95Layout = new javax.swing.GroupLayout(jPanel95);
        jPanel95.setLayout(jPanel95Layout);
        jPanel95Layout.setHorizontalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel95Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(479, Short.MAX_VALUE))
        );
        jPanel95Layout.setVerticalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel95Layout.createSequentialGroup()
                .addContainerGap(346, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        jPanel1.add(jPanel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 1250, 630));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1440, 900));

        setSize(new java.awt.Dimension(1455, 902));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
      CopyBookControl cp = new CopyBookControl();
      this.setVisible(false);
      cp.setVisible(true);
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        CopyBookControl cp = new CopyBookControl();
      this.setVisible(false);
      cp.setVisible(true);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
      ManageBooks mg = new ManageBooks();
      this.setVisible(false);
      mg.setVisible(true);
    }//GEN-LAST:event_jLabel29MouseClicked

    private void jLabel45MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MouseClicked
       IssueBook is = new IssueBook();
       this.setVisible(false);
       is.showIssueBookScreen();
    }//GEN-LAST:event_jLabel45MouseClicked

    private void jLabel61MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel61MouseClicked
        IssuedBookDetail is = new IssuedBookDetail();
        this.setVisible(false);
        is.showManHinh();
    }//GEN-LAST:event_jLabel61MouseClicked

    private void jLabel77MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel77MouseClicked
        ReturnBook r = new ReturnBook();
        this.setVisible(false);
        r.setVisible(true);
    }//GEN-LAST:event_jLabel77MouseClicked

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
        Login lg = new Login();
        this.setVisible(false);
        lg.setVisible(true);
    }//GEN-LAST:event_jPanel11MouseClicked

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
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Homepage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel chart;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel73;
    private javax.swing.JPanel jPanel74;
    private javax.swing.JPanel jPanel75;
    private javax.swing.JPanel jPanel76;
    private javax.swing.JPanel jPanel77;
    private javax.swing.JPanel jPanel78;
    private javax.swing.JPanel jPanel79;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel80;
    private javax.swing.JPanel jPanel81;
    private javax.swing.JPanel jPanel82;
    private javax.swing.JPanel jPanel83;
    private javax.swing.JPanel jPanel84;
    private javax.swing.JPanel jPanel85;
    private javax.swing.JPanel jPanel86;
    private javax.swing.JPanel jPanel87;
    private javax.swing.JPanel jPanel88;
    private javax.swing.JPanel jPanel89;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel90;
    private javax.swing.JPanel jPanel91;
    private javax.swing.JPanel jPanel92;
    private javax.swing.JPanel jPanel93;
    private javax.swing.JPanel jPanel94;
    private javax.swing.JPanel jPanel95;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private rojeru_san.complementos.RSTableMetro tblnguoimuon;
    private rojeru_san.complementos.RSTableMetro tblsach;
    private javax.swing.JLabel txtconlai;
    private javax.swing.JLabel txtdangmuon;
    private javax.swing.JLabel txtnguoimuon;
    private javax.swing.JLabel txtsosach;
    // End of variables declaration//GEN-END:variables
}
