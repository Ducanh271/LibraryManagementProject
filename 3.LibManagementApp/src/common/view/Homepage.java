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
         java.sql.ResultSet rs= st.executeQuery("select * from nguoimuon");
         while(rs.next()){
         String manm = rs.getString("maNM");
         String tennm = rs.getString("tenNM");
         String email = rs.getString("email");
         Object[] ob = {manm,tennm,email};
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
        String querySoSach = "SELECT SUM(soLuong) FROM sach";
        java.sql.PreparedStatement psSoSach = con.prepareStatement(querySoSach);
        java.sql.ResultSet rsSoSach = psSoSach.executeQuery();
        int soSach = 0;
        if (rsSoSach.next()) {
            soSach = rsSoSach.getInt(1);
            txtsosach.setText(String.valueOf(soSach));
        }
        String querySoNguoiMuon = "SELECT COUNT(maNM) FROM nguoimuon";
        java.sql.PreparedStatement psSoNguoiMuon = con.prepareStatement(querySoNguoiMuon);
        java.sql.ResultSet rsSoNguoiMuon = psSoNguoiMuon.executeQuery();
        int soNguoiMuon = 0;
        if (rsSoNguoiMuon.next()) {
            soNguoiMuon = rsSoNguoiMuon.getInt(1);
            txtnguoimuon.setText(String.valueOf(soNguoiMuon));
        }
        String querySoDangMuon = "SELECT COUNT(maThongTinMuonSach) FROM chitietmuonsach";
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


 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel230 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jPanel94 = new javax.swing.JPanel();
        jLabel94 = new javax.swing.JLabel();
        jPanel95 = new javax.swing.JPanel();
        jLabel95 = new javax.swing.JLabel();
        jPanel96 = new javax.swing.JPanel();
        jLabel96 = new javax.swing.JLabel();
        jPanel97 = new javax.swing.JPanel();
        jLabel97 = new javax.swing.JLabel();
        jPanel98 = new javax.swing.JPanel();
        jLabel98 = new javax.swing.JLabel();
        jPanel99 = new javax.swing.JPanel();
        jLabel99 = new javax.swing.JLabel();
        jPanel100 = new javax.swing.JPanel();
        jLabel100 = new javax.swing.JLabel();
        jPanel101 = new javax.swing.JPanel();
        jLabel101 = new javax.swing.JLabel();
        jPanel102 = new javax.swing.JPanel();
        jLabel102 = new javax.swing.JLabel();
        jPanel103 = new javax.swing.JPanel();
        jLabel103 = new javax.swing.JLabel();
        jPanel104 = new javax.swing.JPanel();
        jLabel104 = new javax.swing.JLabel();
        jPanel105 = new javax.swing.JPanel();
        jLabel105 = new javax.swing.JLabel();
        jPanel106 = new javax.swing.JPanel();
        jLabel106 = new javax.swing.JLabel();
        jPanel107 = new javax.swing.JPanel();
        jLabel107 = new javax.swing.JLabel();
        jPanel108 = new javax.swing.JPanel();
        jLabel108 = new javax.swing.JLabel();
        jPanel109 = new javax.swing.JPanel();
        jLabel109 = new javax.swing.JLabel();
        jPanel110 = new javax.swing.JPanel();
        jLabel110 = new javax.swing.JLabel();
        jPanel111 = new javax.swing.JPanel();
        jLabel111 = new javax.swing.JLabel();
        jPanel112 = new javax.swing.JPanel();
        jLabel112 = new javax.swing.JLabel();
        jPanel113 = new javax.swing.JPanel();
        jLabel113 = new javax.swing.JLabel();
        jPanel114 = new javax.swing.JPanel();
        jLabel114 = new javax.swing.JLabel();
        jPanel115 = new javax.swing.JPanel();
        jLabel115 = new javax.swing.JLabel();
        jPanel116 = new javax.swing.JPanel();
        jLabel116 = new javax.swing.JLabel();
        jPanel117 = new javax.swing.JPanel();
        jLabel117 = new javax.swing.JLabel();
        jPanel118 = new javax.swing.JPanel();
        jLabel118 = new javax.swing.JLabel();
        jPanel119 = new javax.swing.JPanel();
        jLabel119 = new javax.swing.JLabel();
        jPanel120 = new javax.swing.JPanel();
        jLabel120 = new javax.swing.JLabel();
        jPanel121 = new javax.swing.JPanel();
        jLabel121 = new javax.swing.JLabel();
        jPanel122 = new javax.swing.JPanel();
        jLabel122 = new javax.swing.JLabel();
        jPanel123 = new javax.swing.JPanel();
        jLabel123 = new javax.swing.JLabel();
        jPanel124 = new javax.swing.JPanel();
        jLabel124 = new javax.swing.JLabel();
        jPanel125 = new javax.swing.JPanel();
        jLabel125 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jPanel49 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jPanel50 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jPanel51 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jPanel70 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jPanel71 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jPanel72 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jPanel73 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jPanel74 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        jPanel75 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jPanel76 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jPanel77 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jPanel78 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jPanel79 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        jPanel80 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jPanel81 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jPanel82 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        jPanel83 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        jPanel84 = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        jPanel85 = new javax.swing.JPanel();
        jLabel85 = new javax.swing.JLabel();
        jPanel86 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        jPanel87 = new javax.swing.JPanel();
        jLabel87 = new javax.swing.JLabel();
        jPanel88 = new javax.swing.JPanel();
        jLabel88 = new javax.swing.JLabel();
        jPanel89 = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        jPanel90 = new javax.swing.JPanel();
        jLabel90 = new javax.swing.JLabel();
        jPanel91 = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        jPanel92 = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        jPanel93 = new javax.swing.JPanel();
        jLabel93 = new javax.swing.JLabel();
        jPanel60 = new javax.swing.JPanel();
        jPanel61 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jPanel62 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel63 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jPanel64 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jPanel65 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jPanel66 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel67 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jPanel158 = new javax.swing.JPanel();
        jLabel158 = new javax.swing.JLabel();
        jPanel159 = new javax.swing.JPanel();
        jLabel159 = new javax.swing.JLabel();
        jPanel160 = new javax.swing.JPanel();
        jLabel160 = new javax.swing.JLabel();
        jPanel161 = new javax.swing.JPanel();
        jLabel161 = new javax.swing.JLabel();
        jPanel162 = new javax.swing.JPanel();
        jLabel162 = new javax.swing.JLabel();
        jPanel163 = new javax.swing.JPanel();
        jLabel163 = new javax.swing.JLabel();
        jPanel164 = new javax.swing.JPanel();
        jLabel164 = new javax.swing.JLabel();
        jPanel165 = new javax.swing.JPanel();
        jLabel165 = new javax.swing.JLabel();
        jPanel166 = new javax.swing.JPanel();
        jLabel166 = new javax.swing.JLabel();
        jPanel167 = new javax.swing.JPanel();
        jLabel167 = new javax.swing.JLabel();
        jPanel168 = new javax.swing.JPanel();
        jLabel168 = new javax.swing.JLabel();
        jPanel169 = new javax.swing.JPanel();
        jLabel169 = new javax.swing.JLabel();
        jPanel170 = new javax.swing.JPanel();
        jLabel170 = new javax.swing.JLabel();
        jPanel171 = new javax.swing.JPanel();
        jLabel171 = new javax.swing.JLabel();
        jPanel172 = new javax.swing.JPanel();
        jLabel172 = new javax.swing.JLabel();
        jPanel173 = new javax.swing.JPanel();
        jLabel173 = new javax.swing.JLabel();
        jPanel174 = new javax.swing.JPanel();
        jLabel174 = new javax.swing.JLabel();
        jPanel175 = new javax.swing.JPanel();
        jLabel175 = new javax.swing.JLabel();
        jPanel176 = new javax.swing.JPanel();
        jLabel176 = new javax.swing.JLabel();
        jPanel177 = new javax.swing.JPanel();
        jLabel177 = new javax.swing.JLabel();
        jPanel178 = new javax.swing.JPanel();
        jLabel178 = new javax.swing.JLabel();
        jPanel179 = new javax.swing.JPanel();
        jLabel179 = new javax.swing.JLabel();
        jPanel180 = new javax.swing.JPanel();
        jLabel180 = new javax.swing.JLabel();
        jPanel181 = new javax.swing.JPanel();
        jLabel181 = new javax.swing.JLabel();
        jPanel182 = new javax.swing.JPanel();
        jLabel182 = new javax.swing.JLabel();
        jPanel183 = new javax.swing.JPanel();
        jLabel183 = new javax.swing.JLabel();
        jPanel184 = new javax.swing.JPanel();
        jLabel184 = new javax.swing.JLabel();
        jPanel185 = new javax.swing.JPanel();
        jLabel185 = new javax.swing.JLabel();
        jPanel186 = new javax.swing.JPanel();
        jLabel186 = new javax.swing.JLabel();
        jPanel187 = new javax.swing.JPanel();
        jLabel187 = new javax.swing.JLabel();
        jPanel188 = new javax.swing.JPanel();
        jLabel188 = new javax.swing.JLabel();
        jPanel189 = new javax.swing.JPanel();
        jLabel189 = new javax.swing.JLabel();
        jPanel190 = new javax.swing.JPanel();
        jLabel190 = new javax.swing.JLabel();
        jPanel191 = new javax.swing.JPanel();
        jLabel191 = new javax.swing.JLabel();
        jPanel192 = new javax.swing.JPanel();
        jLabel192 = new javax.swing.JLabel();
        jPanel193 = new javax.swing.JPanel();
        jLabel193 = new javax.swing.JLabel();
        jPanel194 = new javax.swing.JPanel();
        jLabel194 = new javax.swing.JLabel();
        jPanel195 = new javax.swing.JPanel();
        jLabel195 = new javax.swing.JLabel();
        jPanel196 = new javax.swing.JPanel();
        jLabel196 = new javax.swing.JLabel();
        jPanel197 = new javax.swing.JPanel();
        jLabel197 = new javax.swing.JLabel();
        jPanel198 = new javax.swing.JPanel();
        jLabel198 = new javax.swing.JLabel();
        jPanel199 = new javax.swing.JPanel();
        jLabel199 = new javax.swing.JLabel();
        jPanel200 = new javax.swing.JPanel();
        jLabel200 = new javax.swing.JLabel();
        jPanel201 = new javax.swing.JPanel();
        jLabel201 = new javax.swing.JLabel();
        jPanel202 = new javax.swing.JPanel();
        jLabel202 = new javax.swing.JLabel();
        jPanel203 = new javax.swing.JPanel();
        jLabel203 = new javax.swing.JLabel();
        jPanel204 = new javax.swing.JPanel();
        jLabel204 = new javax.swing.JLabel();
        jPanel205 = new javax.swing.JPanel();
        jLabel205 = new javax.swing.JLabel();
        jPanel206 = new javax.swing.JPanel();
        jLabel206 = new javax.swing.JLabel();
        jPanel207 = new javax.swing.JPanel();
        jLabel207 = new javax.swing.JLabel();
        jPanel208 = new javax.swing.JPanel();
        jLabel208 = new javax.swing.JLabel();
        jPanel209 = new javax.swing.JPanel();
        jLabel209 = new javax.swing.JLabel();
        jPanel210 = new javax.swing.JPanel();
        jLabel210 = new javax.swing.JLabel();
        jPanel211 = new javax.swing.JPanel();
        jLabel211 = new javax.swing.JLabel();
        jPanel212 = new javax.swing.JPanel();
        jLabel212 = new javax.swing.JLabel();
        jPanel213 = new javax.swing.JPanel();
        jLabel213 = new javax.swing.JLabel();
        jPanel214 = new javax.swing.JPanel();
        jLabel214 = new javax.swing.JLabel();
        jPanel215 = new javax.swing.JPanel();
        jLabel215 = new javax.swing.JLabel();
        jPanel216 = new javax.swing.JPanel();
        jLabel216 = new javax.swing.JLabel();
        jPanel217 = new javax.swing.JPanel();
        jLabel217 = new javax.swing.JLabel();
        jPanel218 = new javax.swing.JPanel();
        jLabel218 = new javax.swing.JLabel();
        jPanel219 = new javax.swing.JPanel();
        jLabel219 = new javax.swing.JLabel();
        jPanel220 = new javax.swing.JPanel();
        jLabel220 = new javax.swing.JLabel();
        jPanel221 = new javax.swing.JPanel();
        jLabel221 = new javax.swing.JLabel();
        jLabel222 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel69 = new javax.swing.JPanel();
        jPanel226 = new javax.swing.JPanel();
        jPanel52 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jPanel53 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jPanel54 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jPanel55 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jPanel56 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jPanel57 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jPanel58 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jPanel59 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jPanel126 = new javax.swing.JPanel();
        jLabel126 = new javax.swing.JLabel();
        jPanel127 = new javax.swing.JPanel();
        jLabel127 = new javax.swing.JLabel();
        jPanel128 = new javax.swing.JPanel();
        jLabel128 = new javax.swing.JLabel();
        jPanel129 = new javax.swing.JPanel();
        jLabel129 = new javax.swing.JLabel();
        jPanel130 = new javax.swing.JPanel();
        jLabel130 = new javax.swing.JLabel();
        jPanel131 = new javax.swing.JPanel();
        jLabel131 = new javax.swing.JLabel();
        jPanel132 = new javax.swing.JPanel();
        jLabel132 = new javax.swing.JLabel();
        jPanel133 = new javax.swing.JPanel();
        jLabel133 = new javax.swing.JLabel();
        jPanel134 = new javax.swing.JPanel();
        jLabel134 = new javax.swing.JLabel();
        jPanel135 = new javax.swing.JPanel();
        jLabel135 = new javax.swing.JLabel();
        jPanel136 = new javax.swing.JPanel();
        jLabel136 = new javax.swing.JLabel();
        jPanel137 = new javax.swing.JPanel();
        jLabel137 = new javax.swing.JLabel();
        jPanel138 = new javax.swing.JPanel();
        jLabel138 = new javax.swing.JLabel();
        jPanel139 = new javax.swing.JPanel();
        jLabel139 = new javax.swing.JLabel();
        jPanel140 = new javax.swing.JPanel();
        jLabel140 = new javax.swing.JLabel();
        jPanel141 = new javax.swing.JPanel();
        jLabel141 = new javax.swing.JLabel();
        jPanel142 = new javax.swing.JPanel();
        jLabel142 = new javax.swing.JLabel();
        jPanel143 = new javax.swing.JPanel();
        jLabel143 = new javax.swing.JLabel();
        jPanel144 = new javax.swing.JPanel();
        jLabel144 = new javax.swing.JLabel();
        jPanel145 = new javax.swing.JPanel();
        jLabel145 = new javax.swing.JLabel();
        jPanel146 = new javax.swing.JPanel();
        jLabel146 = new javax.swing.JLabel();
        jPanel147 = new javax.swing.JPanel();
        jLabel147 = new javax.swing.JLabel();
        jPanel148 = new javax.swing.JPanel();
        jLabel148 = new javax.swing.JLabel();
        jPanel149 = new javax.swing.JPanel();
        jLabel149 = new javax.swing.JLabel();
        jPanel150 = new javax.swing.JPanel();
        jLabel150 = new javax.swing.JLabel();
        jPanel151 = new javax.swing.JPanel();
        jLabel151 = new javax.swing.JLabel();
        jPanel152 = new javax.swing.JPanel();
        jLabel152 = new javax.swing.JLabel();
        jPanel153 = new javax.swing.JPanel();
        jLabel153 = new javax.swing.JLabel();
        jPanel154 = new javax.swing.JPanel();
        jLabel154 = new javax.swing.JLabel();
        jPanel155 = new javax.swing.JPanel();
        jLabel155 = new javax.swing.JLabel();
        jPanel156 = new javax.swing.JPanel();
        jLabel156 = new javax.swing.JLabel();
        jPanel157 = new javax.swing.JPanel();
        jLabel157 = new javax.swing.JLabel();
        jPanel227 = new javax.swing.JPanel();
        jLabel223 = new javax.swing.JLabel();
        jPanel228 = new javax.swing.JPanel();
        jLabel227 = new javax.swing.JLabel();
        jPanel229 = new javax.swing.JPanel();
        jLabel228 = new javax.swing.JLabel();
        jPanel230 = new javax.swing.JPanel();
        jLabel233 = new javax.swing.JLabel();
        jPanel231 = new javax.swing.JPanel();
        jLabel234 = new javax.swing.JLabel();
        jPanel232 = new javax.swing.JPanel();
        jLabel235 = new javax.swing.JLabel();
        jPanel233 = new javax.swing.JPanel();
        jLabel236 = new javax.swing.JLabel();
        jPanel234 = new javax.swing.JPanel();
        jLabel237 = new javax.swing.JLabel();
        jPanel235 = new javax.swing.JPanel();
        jLabel238 = new javax.swing.JLabel();
        jPanel236 = new javax.swing.JPanel();
        jLabel239 = new javax.swing.JLabel();
        jPanel237 = new javax.swing.JPanel();
        jLabel240 = new javax.swing.JLabel();
        jPanel238 = new javax.swing.JPanel();
        jLabel241 = new javax.swing.JLabel();
        jPanel239 = new javax.swing.JPanel();
        jLabel242 = new javax.swing.JLabel();
        jPanel240 = new javax.swing.JPanel();
        jLabel243 = new javax.swing.JLabel();
        jPanel241 = new javax.swing.JPanel();
        jLabel244 = new javax.swing.JLabel();
        jPanel242 = new javax.swing.JPanel();
        jLabel245 = new javax.swing.JLabel();
        jPanel243 = new javax.swing.JPanel();
        jLabel246 = new javax.swing.JLabel();
        jPanel244 = new javax.swing.JPanel();
        jLabel247 = new javax.swing.JLabel();
        jPanel245 = new javax.swing.JPanel();
        jLabel248 = new javax.swing.JLabel();
        jPanel246 = new javax.swing.JPanel();
        jLabel249 = new javax.swing.JLabel();
        jPanel247 = new javax.swing.JPanel();
        jLabel250 = new javax.swing.JLabel();
        jPanel248 = new javax.swing.JPanel();
        jLabel251 = new javax.swing.JLabel();
        jPanel249 = new javax.swing.JPanel();
        jLabel252 = new javax.swing.JLabel();
        jPanel250 = new javax.swing.JPanel();
        jLabel253 = new javax.swing.JLabel();
        jPanel251 = new javax.swing.JPanel();
        jLabel254 = new javax.swing.JLabel();
        jPanel252 = new javax.swing.JPanel();
        jLabel255 = new javax.swing.JLabel();
        jPanel253 = new javax.swing.JPanel();
        jLabel256 = new javax.swing.JLabel();
        jPanel254 = new javax.swing.JPanel();
        jLabel257 = new javax.swing.JLabel();
        jPanel255 = new javax.swing.JPanel();
        jLabel258 = new javax.swing.JLabel();
        jPanel256 = new javax.swing.JPanel();
        jLabel259 = new javax.swing.JLabel();
        jPanel257 = new javax.swing.JPanel();
        jLabel260 = new javax.swing.JLabel();
        jPanel258 = new javax.swing.JPanel();
        jLabel261 = new javax.swing.JLabel();
        jPanel259 = new javax.swing.JPanel();
        jLabel262 = new javax.swing.JLabel();
        jPanel260 = new javax.swing.JPanel();
        jLabel263 = new javax.swing.JLabel();
        jPanel261 = new javax.swing.JPanel();
        jLabel264 = new javax.swing.JLabel();
        jPanel262 = new javax.swing.JPanel();
        jLabel265 = new javax.swing.JLabel();
        jPanel263 = new javax.swing.JPanel();
        jLabel266 = new javax.swing.JLabel();
        jPanel264 = new javax.swing.JPanel();
        jLabel267 = new javax.swing.JLabel();
        jPanel265 = new javax.swing.JPanel();
        jLabel268 = new javax.swing.JLabel();
        jPanel266 = new javax.swing.JPanel();
        jLabel269 = new javax.swing.JLabel();
        jPanel68 = new javax.swing.JPanel();
        jPanel222 = new javax.swing.JPanel();
        txtsosach = new javax.swing.JLabel();
        jPanel223 = new javax.swing.JPanel();
        txtnguoimuon = new javax.swing.JLabel();
        jPanel224 = new javax.swing.JPanel();
        txtconlai = new javax.swing.JLabel();
        jPanel225 = new javax.swing.JPanel();
        txtdangmuon = new javax.swing.JLabel();
        jLabel224 = new javax.swing.JLabel();
        jLabel225 = new javax.swing.JLabel();
        jLabel226 = new javax.swing.JLabel();
        jLabel229 = new javax.swing.JLabel();
        jLabel231 = new javax.swing.JLabel();
        jLabel232 = new javax.swing.JLabel();
        chart = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblnguoimuon = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblsach = new javax.swing.JTable();

        jLabel230.setText("jLabel230");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_menu_48px_1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 50, 30));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 5, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/male_user_50px.png"))); // NOI18N
        jLabel2.setText("Xin chào");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, -1, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Quản lý thư viện");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 60));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(61, 61, 61));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Tính năng");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 51, 0));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(61, 61, 61));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel6.setText("Homepage");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel6.setBackground(new java.awt.Color(255, 51, 0));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(61, 61, 61));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel7.setText("Homepage");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel7.setBackground(new java.awt.Color(255, 51, 0));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(61, 61, 61));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel8.setText("Homepage");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel8.setBackground(new java.awt.Color(255, 51, 0));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(61, 61, 61));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel9.setText("Homepage");
        jPanel8.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel9.setBackground(new java.awt.Color(255, 51, 0));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(61, 61, 61));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel10.setText("Homepage");
        jPanel9.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel10.setBackground(new java.awt.Color(255, 51, 0));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(61, 61, 61));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel11.setText("Homepage");
        jPanel10.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel11.setBackground(new java.awt.Color(255, 51, 0));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(61, 61, 61));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel12.setText("Homepage");
        jPanel11.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel10.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel8.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel4.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel20.setBackground(new java.awt.Color(255, 51, 0));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setBackground(new java.awt.Color(61, 61, 61));
        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel21.setText("Homepage");
        jPanel20.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel21.setBackground(new java.awt.Color(255, 51, 0));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setBackground(new java.awt.Color(61, 61, 61));
        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel22.setText("Homepage");
        jPanel21.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel20.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel22.setBackground(new java.awt.Color(255, 51, 0));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setBackground(new java.awt.Color(61, 61, 61));
        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel23.setText("Homepage");
        jPanel22.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel23.setBackground(new java.awt.Color(255, 51, 0));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setBackground(new java.awt.Color(61, 61, 61));
        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel24.setText("Homepage");
        jPanel23.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel22.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel20.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel24.setBackground(new java.awt.Color(255, 51, 0));
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setBackground(new java.awt.Color(61, 61, 61));
        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel25.setText("Homepage");
        jPanel24.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel25.setBackground(new java.awt.Color(255, 51, 0));
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setBackground(new java.awt.Color(61, 61, 61));
        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel26.setText("Homepage");
        jPanel25.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel24.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel26.setBackground(new java.awt.Color(255, 51, 0));
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setBackground(new java.awt.Color(61, 61, 61));
        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel27.setText("Homepage");
        jPanel26.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel27.setBackground(new java.awt.Color(255, 51, 0));
        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setBackground(new java.awt.Color(61, 61, 61));
        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel28.setText("Homepage");
        jPanel27.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel26.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel24.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel20.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel4.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 150, 40));

        jPanel28.setBackground(new java.awt.Color(255, 51, 0));
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setBackground(new java.awt.Color(61, 61, 61));
        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel29.setText("Homepage");
        jPanel28.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel29.setBackground(new java.awt.Color(255, 51, 0));
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setBackground(new java.awt.Color(61, 61, 61));
        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel30.setText("Homepage");
        jPanel29.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel28.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel30.setBackground(new java.awt.Color(255, 51, 0));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setBackground(new java.awt.Color(61, 61, 61));
        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel31.setText("Homepage");
        jPanel30.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel31.setBackground(new java.awt.Color(255, 51, 0));
        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setBackground(new java.awt.Color(61, 61, 61));
        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel32.setText("Homepage");
        jPanel31.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel30.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel28.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel32.setBackground(new java.awt.Color(255, 51, 0));
        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setBackground(new java.awt.Color(61, 61, 61));
        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel33.setText("Homepage");
        jPanel32.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel33.setBackground(new java.awt.Color(255, 51, 0));
        jPanel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setBackground(new java.awt.Color(61, 61, 61));
        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel34.setText("Homepage");
        jPanel33.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel32.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel34.setBackground(new java.awt.Color(255, 51, 0));
        jPanel34.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setBackground(new java.awt.Color(61, 61, 61));
        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel35.setText("Homepage");
        jPanel34.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel35.setBackground(new java.awt.Color(255, 51, 0));
        jPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setBackground(new java.awt.Color(61, 61, 61));
        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel36.setText("Homepage");
        jPanel35.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel34.add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel32.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel28.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel36.setBackground(new java.awt.Color(255, 51, 0));
        jPanel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setBackground(new java.awt.Color(61, 61, 61));
        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel37.setText("Homepage");
        jPanel36.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel37.setBackground(new java.awt.Color(255, 51, 0));
        jPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setBackground(new java.awt.Color(61, 61, 61));
        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel38.setText("Homepage");
        jPanel37.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel36.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel38.setBackground(new java.awt.Color(255, 51, 0));
        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setBackground(new java.awt.Color(61, 61, 61));
        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel39.setText("Homepage");
        jPanel38.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel39.setBackground(new java.awt.Color(255, 51, 0));
        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setBackground(new java.awt.Color(61, 61, 61));
        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel40.setText("Homepage");
        jPanel39.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel38.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel36.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel40.setBackground(new java.awt.Color(255, 51, 0));
        jPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setBackground(new java.awt.Color(61, 61, 61));
        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel41.setText("Homepage");
        jPanel40.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel41.setBackground(new java.awt.Color(255, 51, 0));
        jPanel41.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setBackground(new java.awt.Color(61, 61, 61));
        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel42.setText("Homepage");
        jPanel41.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel40.add(jPanel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel42.setBackground(new java.awt.Color(255, 51, 0));
        jPanel42.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel43.setBackground(new java.awt.Color(61, 61, 61));
        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel43.setText("Homepage");
        jPanel42.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel43.setBackground(new java.awt.Color(255, 51, 0));
        jPanel43.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel44.setBackground(new java.awt.Color(61, 61, 61));
        jLabel44.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel44.setText("Homepage");
        jPanel43.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel42.add(jPanel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel40.add(jPanel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel36.add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel28.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 150, 40));

        jPanel4.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 150, 40));

        jPanel94.setBackground(new java.awt.Color(255, 51, 0));
        jPanel94.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel94.setBackground(new java.awt.Color(61, 61, 61));
        jLabel94.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(255, 255, 255));
        jLabel94.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel94.setText("Trang chủ");
        jPanel94.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel95.setBackground(new java.awt.Color(255, 51, 0));
        jPanel95.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel95.setBackground(new java.awt.Color(61, 61, 61));
        jLabel95.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(255, 255, 255));
        jLabel95.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel95.setText("Homepage");
        jPanel95.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel94.add(jPanel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel96.setBackground(new java.awt.Color(255, 51, 0));
        jPanel96.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel96.setBackground(new java.awt.Color(61, 61, 61));
        jLabel96.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(255, 255, 255));
        jLabel96.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel96.setText("Homepage");
        jPanel96.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel97.setBackground(new java.awt.Color(255, 51, 0));
        jPanel97.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel97.setBackground(new java.awt.Color(61, 61, 61));
        jLabel97.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(255, 255, 255));
        jLabel97.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel97.setText("Homepage");
        jPanel97.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel96.add(jPanel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel94.add(jPanel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel98.setBackground(new java.awt.Color(255, 51, 0));
        jPanel98.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel98.setBackground(new java.awt.Color(61, 61, 61));
        jLabel98.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(255, 255, 255));
        jLabel98.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel98.setText("Homepage");
        jPanel98.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel99.setBackground(new java.awt.Color(255, 51, 0));
        jPanel99.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel99.setBackground(new java.awt.Color(61, 61, 61));
        jLabel99.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(255, 255, 255));
        jLabel99.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel99.setText("Homepage");
        jPanel99.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel98.add(jPanel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel100.setBackground(new java.awt.Color(255, 51, 0));
        jPanel100.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel100.setBackground(new java.awt.Color(61, 61, 61));
        jLabel100.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(255, 255, 255));
        jLabel100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel100.setText("Homepage");
        jPanel100.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel101.setBackground(new java.awt.Color(255, 51, 0));
        jPanel101.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel101.setBackground(new java.awt.Color(61, 61, 61));
        jLabel101.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(255, 255, 255));
        jLabel101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel101.setText("Homepage");
        jPanel101.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel100.add(jPanel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel98.add(jPanel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel94.add(jPanel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel102.setBackground(new java.awt.Color(255, 51, 0));
        jPanel102.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel102.setBackground(new java.awt.Color(61, 61, 61));
        jLabel102.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(255, 255, 255));
        jLabel102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel102.setText("Trang chủ");
        jPanel102.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel103.setBackground(new java.awt.Color(255, 51, 0));
        jPanel103.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel103.setBackground(new java.awt.Color(61, 61, 61));
        jLabel103.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(255, 255, 255));
        jLabel103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel103.setText("Homepage");
        jPanel103.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel102.add(jPanel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel104.setBackground(new java.awt.Color(255, 51, 0));
        jPanel104.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel104.setBackground(new java.awt.Color(61, 61, 61));
        jLabel104.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(255, 255, 255));
        jLabel104.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel104.setText("Homepage");
        jPanel104.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel105.setBackground(new java.awt.Color(255, 51, 0));
        jPanel105.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel105.setBackground(new java.awt.Color(61, 61, 61));
        jLabel105.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(255, 255, 255));
        jLabel105.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel105.setText("Homepage");
        jPanel105.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel104.add(jPanel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel102.add(jPanel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel106.setBackground(new java.awt.Color(255, 51, 0));
        jPanel106.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel106.setBackground(new java.awt.Color(61, 61, 61));
        jLabel106.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(255, 255, 255));
        jLabel106.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel106.setText("Homepage");
        jPanel106.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel107.setBackground(new java.awt.Color(255, 51, 0));
        jPanel107.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel107.setBackground(new java.awt.Color(61, 61, 61));
        jLabel107.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(255, 255, 255));
        jLabel107.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel107.setText("Homepage");
        jPanel107.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel106.add(jPanel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel108.setBackground(new java.awt.Color(255, 51, 0));
        jPanel108.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel108.setBackground(new java.awt.Color(61, 61, 61));
        jLabel108.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(255, 255, 255));
        jLabel108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel108.setText("Homepage");
        jPanel108.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel109.setBackground(new java.awt.Color(255, 51, 0));
        jPanel109.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel109.setBackground(new java.awt.Color(61, 61, 61));
        jLabel109.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(255, 255, 255));
        jLabel109.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel109.setText("Homepage");
        jPanel109.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel108.add(jPanel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel106.add(jPanel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel102.add(jPanel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel94.add(jPanel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 210, 40));

        jPanel110.setBackground(new java.awt.Color(255, 51, 0));
        jPanel110.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel110.setBackground(new java.awt.Color(61, 61, 61));
        jLabel110.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(255, 255, 255));
        jLabel110.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel110.setText("Trang chủ");
        jPanel110.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel111.setBackground(new java.awt.Color(255, 51, 0));
        jPanel111.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel111.setBackground(new java.awt.Color(61, 61, 61));
        jLabel111.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(255, 255, 255));
        jLabel111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel111.setText("Homepage");
        jPanel111.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel110.add(jPanel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel112.setBackground(new java.awt.Color(255, 51, 0));
        jPanel112.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel112.setBackground(new java.awt.Color(61, 61, 61));
        jLabel112.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(255, 255, 255));
        jLabel112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel112.setText("Homepage");
        jPanel112.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel113.setBackground(new java.awt.Color(255, 51, 0));
        jPanel113.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel113.setBackground(new java.awt.Color(61, 61, 61));
        jLabel113.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(255, 255, 255));
        jLabel113.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel113.setText("Homepage");
        jPanel113.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel112.add(jPanel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel110.add(jPanel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel114.setBackground(new java.awt.Color(255, 51, 0));
        jPanel114.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel114.setBackground(new java.awt.Color(61, 61, 61));
        jLabel114.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(255, 255, 255));
        jLabel114.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel114.setText("Homepage");
        jPanel114.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel115.setBackground(new java.awt.Color(255, 51, 0));
        jPanel115.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel115.setBackground(new java.awt.Color(61, 61, 61));
        jLabel115.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(255, 255, 255));
        jLabel115.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel115.setText("Homepage");
        jPanel115.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel114.add(jPanel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel116.setBackground(new java.awt.Color(255, 51, 0));
        jPanel116.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel116.setBackground(new java.awt.Color(61, 61, 61));
        jLabel116.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(255, 255, 255));
        jLabel116.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel116.setText("Homepage");
        jPanel116.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel117.setBackground(new java.awt.Color(255, 51, 0));
        jPanel117.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel117.setBackground(new java.awt.Color(61, 61, 61));
        jLabel117.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(255, 255, 255));
        jLabel117.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel117.setText("Homepage");
        jPanel117.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel116.add(jPanel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel114.add(jPanel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel110.add(jPanel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel118.setBackground(new java.awt.Color(255, 51, 0));
        jPanel118.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel118.setBackground(new java.awt.Color(61, 61, 61));
        jLabel118.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel118.setForeground(new java.awt.Color(255, 255, 255));
        jLabel118.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel118.setText("Trang chủ");
        jPanel118.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel119.setBackground(new java.awt.Color(255, 51, 0));
        jPanel119.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel119.setBackground(new java.awt.Color(61, 61, 61));
        jLabel119.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(255, 255, 255));
        jLabel119.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel119.setText("Homepage");
        jPanel119.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel118.add(jPanel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel120.setBackground(new java.awt.Color(255, 51, 0));
        jPanel120.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel120.setBackground(new java.awt.Color(61, 61, 61));
        jLabel120.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel120.setForeground(new java.awt.Color(255, 255, 255));
        jLabel120.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel120.setText("Homepage");
        jPanel120.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel121.setBackground(new java.awt.Color(255, 51, 0));
        jPanel121.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel121.setBackground(new java.awt.Color(61, 61, 61));
        jLabel121.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(255, 255, 255));
        jLabel121.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel121.setText("Homepage");
        jPanel121.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel120.add(jPanel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel118.add(jPanel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel122.setBackground(new java.awt.Color(255, 51, 0));
        jPanel122.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel122.setBackground(new java.awt.Color(61, 61, 61));
        jLabel122.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel122.setForeground(new java.awt.Color(255, 255, 255));
        jLabel122.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel122.setText("Homepage");
        jPanel122.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel123.setBackground(new java.awt.Color(255, 51, 0));
        jPanel123.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel123.setBackground(new java.awt.Color(61, 61, 61));
        jLabel123.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(255, 255, 255));
        jLabel123.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel123.setText("Homepage");
        jPanel123.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel122.add(jPanel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel124.setBackground(new java.awt.Color(255, 51, 0));
        jPanel124.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel124.setBackground(new java.awt.Color(61, 61, 61));
        jLabel124.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel124.setForeground(new java.awt.Color(255, 255, 255));
        jLabel124.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel124.setText("Homepage");
        jPanel124.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel125.setBackground(new java.awt.Color(255, 51, 0));
        jPanel125.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel125.setBackground(new java.awt.Color(61, 61, 61));
        jLabel125.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel125.setForeground(new java.awt.Color(255, 255, 255));
        jLabel125.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel125.setText("Homepage");
        jPanel125.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel124.add(jPanel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel122.add(jPanel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel118.add(jPanel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel110.add(jPanel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 210, 40));

        jPanel94.add(jPanel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 210, 40));

        jPanel4.add(jPanel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 210, 40));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 210, 40));

        jPanel12.setBackground(new java.awt.Color(51, 51, 51));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBackground(new java.awt.Color(255, 51, 0));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setBackground(new java.awt.Color(61, 61, 61));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel14.setText("Homepage");
        jPanel13.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel12.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel14.setBackground(new java.awt.Color(255, 51, 0));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setBackground(new java.awt.Color(61, 61, 61));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel15.setText("Homepage");
        jPanel14.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel15.setBackground(new java.awt.Color(255, 51, 0));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setBackground(new java.awt.Color(61, 61, 61));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel16.setText("Homepage");
        jPanel15.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel14.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel12.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel16.setBackground(new java.awt.Color(255, 51, 0));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setBackground(new java.awt.Color(61, 61, 61));
        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel17.setText("Homepage");
        jPanel16.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel17.setBackground(new java.awt.Color(255, 51, 0));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setBackground(new java.awt.Color(61, 61, 61));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel18.setText("Homepage");
        jPanel17.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel16.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel18.setBackground(new java.awt.Color(255, 51, 0));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setBackground(new java.awt.Color(61, 61, 61));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel19.setText("Homepage");
        jPanel18.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel19.setBackground(new java.awt.Color(255, 51, 0));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setBackground(new java.awt.Color(61, 61, 61));
        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel20.setText("Homepage");
        jPanel19.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel18.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel16.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel12.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jLabel69.setBackground(new java.awt.Color(61, 61, 61));
        jLabel69.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(153, 153, 153));
        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Books_26px.png"))); // NOI18N
        jLabel69.setText("Quản lý bản sao");
        jPanel12.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel3.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 210, 40));

        jPanel44.setBackground(new java.awt.Color(255, 51, 0));
        jPanel44.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setBackground(new java.awt.Color(61, 61, 61));
        jLabel45.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel45.setText("Trang chủ");
        jPanel44.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel45.setBackground(new java.awt.Color(255, 51, 0));
        jPanel45.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel46.setBackground(new java.awt.Color(61, 61, 61));
        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel46.setText("Homepage");
        jPanel45.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel44.add(jPanel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel46.setBackground(new java.awt.Color(255, 51, 0));
        jPanel46.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel47.setBackground(new java.awt.Color(61, 61, 61));
        jLabel47.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel47.setText("Homepage");
        jPanel46.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel47.setBackground(new java.awt.Color(255, 51, 0));
        jPanel47.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel48.setBackground(new java.awt.Color(61, 61, 61));
        jLabel48.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel48.setText("Homepage");
        jPanel47.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel46.add(jPanel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel44.add(jPanel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel48.setBackground(new java.awt.Color(255, 51, 0));
        jPanel48.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel49.setBackground(new java.awt.Color(61, 61, 61));
        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel49.setText("Homepage");
        jPanel48.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel49.setBackground(new java.awt.Color(255, 51, 0));
        jPanel49.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel50.setBackground(new java.awt.Color(61, 61, 61));
        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel50.setText("Homepage");
        jPanel49.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel48.add(jPanel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel50.setBackground(new java.awt.Color(255, 51, 0));
        jPanel50.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel51.setBackground(new java.awt.Color(61, 61, 61));
        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel51.setText("Homepage");
        jPanel50.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel51.setBackground(new java.awt.Color(255, 51, 0));
        jPanel51.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel52.setBackground(new java.awt.Color(61, 61, 61));
        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel52.setText("Homepage");
        jPanel51.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel50.add(jPanel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel48.add(jPanel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel44.add(jPanel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel70.setBackground(new java.awt.Color(255, 51, 0));
        jPanel70.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel70.setBackground(new java.awt.Color(61, 61, 61));
        jLabel70.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel70.setText("Trang chủ");
        jPanel70.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel71.setBackground(new java.awt.Color(255, 51, 0));
        jPanel71.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel71.setBackground(new java.awt.Color(61, 61, 61));
        jLabel71.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel71.setText("Homepage");
        jPanel71.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel70.add(jPanel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel72.setBackground(new java.awt.Color(255, 51, 0));
        jPanel72.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel72.setBackground(new java.awt.Color(61, 61, 61));
        jLabel72.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel72.setText("Homepage");
        jPanel72.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel73.setBackground(new java.awt.Color(255, 51, 0));
        jPanel73.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel73.setBackground(new java.awt.Color(61, 61, 61));
        jLabel73.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel73.setText("Homepage");
        jPanel73.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel72.add(jPanel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel70.add(jPanel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel74.setBackground(new java.awt.Color(255, 51, 0));
        jPanel74.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel74.setBackground(new java.awt.Color(61, 61, 61));
        jLabel74.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel74.setText("Homepage");
        jPanel74.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel75.setBackground(new java.awt.Color(255, 51, 0));
        jPanel75.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel75.setBackground(new java.awt.Color(61, 61, 61));
        jLabel75.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel75.setText("Homepage");
        jPanel75.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel74.add(jPanel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel76.setBackground(new java.awt.Color(255, 51, 0));
        jPanel76.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel76.setBackground(new java.awt.Color(61, 61, 61));
        jLabel76.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel76.setText("Homepage");
        jPanel76.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel77.setBackground(new java.awt.Color(255, 51, 0));
        jPanel77.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel77.setBackground(new java.awt.Color(61, 61, 61));
        jLabel77.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel77.setText("Homepage");
        jPanel77.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel76.add(jPanel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel74.add(jPanel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel70.add(jPanel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel44.add(jPanel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 210, 40));

        jPanel78.setBackground(new java.awt.Color(255, 51, 0));
        jPanel78.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel78.setBackground(new java.awt.Color(61, 61, 61));
        jLabel78.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel78.setText("Trang chủ");
        jPanel78.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel79.setBackground(new java.awt.Color(255, 51, 0));
        jPanel79.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel79.setBackground(new java.awt.Color(61, 61, 61));
        jLabel79.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel79.setText("Homepage");
        jPanel79.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel78.add(jPanel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel80.setBackground(new java.awt.Color(255, 51, 0));
        jPanel80.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel80.setBackground(new java.awt.Color(61, 61, 61));
        jLabel80.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jLabel80.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel80.setText("Homepage");
        jPanel80.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel81.setBackground(new java.awt.Color(255, 51, 0));
        jPanel81.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel81.setBackground(new java.awt.Color(61, 61, 61));
        jLabel81.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(255, 255, 255));
        jLabel81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel81.setText("Homepage");
        jPanel81.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel80.add(jPanel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel78.add(jPanel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel82.setBackground(new java.awt.Color(255, 51, 0));
        jPanel82.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel82.setBackground(new java.awt.Color(61, 61, 61));
        jLabel82.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel82.setText("Homepage");
        jPanel82.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel83.setBackground(new java.awt.Color(255, 51, 0));
        jPanel83.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel83.setBackground(new java.awt.Color(61, 61, 61));
        jLabel83.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel83.setText("Homepage");
        jPanel83.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel82.add(jPanel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel84.setBackground(new java.awt.Color(255, 51, 0));
        jPanel84.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel84.setBackground(new java.awt.Color(61, 61, 61));
        jLabel84.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(255, 255, 255));
        jLabel84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel84.setText("Homepage");
        jPanel84.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel85.setBackground(new java.awt.Color(255, 51, 0));
        jPanel85.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel85.setBackground(new java.awt.Color(61, 61, 61));
        jLabel85.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel85.setText("Homepage");
        jPanel85.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel84.add(jPanel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel82.add(jPanel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel78.add(jPanel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel86.setBackground(new java.awt.Color(255, 51, 0));
        jPanel86.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel86.setBackground(new java.awt.Color(61, 61, 61));
        jLabel86.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(255, 255, 255));
        jLabel86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel86.setText("Trang chủ");
        jPanel86.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel87.setBackground(new java.awt.Color(255, 51, 0));
        jPanel87.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel87.setBackground(new java.awt.Color(61, 61, 61));
        jLabel87.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(255, 255, 255));
        jLabel87.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel87.setText("Homepage");
        jPanel87.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel86.add(jPanel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel88.setBackground(new java.awt.Color(255, 51, 0));
        jPanel88.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel88.setBackground(new java.awt.Color(61, 61, 61));
        jLabel88.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(255, 255, 255));
        jLabel88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel88.setText("Homepage");
        jPanel88.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel89.setBackground(new java.awt.Color(255, 51, 0));
        jPanel89.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel89.setBackground(new java.awt.Color(61, 61, 61));
        jLabel89.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(255, 255, 255));
        jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel89.setText("Homepage");
        jPanel89.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel88.add(jPanel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel86.add(jPanel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel90.setBackground(new java.awt.Color(255, 51, 0));
        jPanel90.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel90.setBackground(new java.awt.Color(61, 61, 61));
        jLabel90.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(255, 255, 255));
        jLabel90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel90.setText("Homepage");
        jPanel90.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel91.setBackground(new java.awt.Color(255, 51, 0));
        jPanel91.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel91.setBackground(new java.awt.Color(61, 61, 61));
        jLabel91.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(255, 255, 255));
        jLabel91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel91.setText("Homepage");
        jPanel91.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel90.add(jPanel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel92.setBackground(new java.awt.Color(255, 51, 0));
        jPanel92.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel92.setBackground(new java.awt.Color(61, 61, 61));
        jLabel92.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(255, 255, 255));
        jLabel92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel92.setText("Homepage");
        jPanel92.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel93.setBackground(new java.awt.Color(255, 51, 0));
        jPanel93.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel93.setBackground(new java.awt.Color(61, 61, 61));
        jLabel93.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(255, 255, 255));
        jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel93.setText("Homepage");
        jPanel93.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel92.add(jPanel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel90.add(jPanel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel86.add(jPanel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel78.add(jPanel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 210, 40));

        jPanel44.add(jPanel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 210, 40));

        jPanel3.add(jPanel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 210, 40));

        jPanel60.setBackground(new java.awt.Color(51, 51, 51));
        jPanel60.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel61.setBackground(new java.awt.Color(255, 51, 0));
        jPanel61.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel62.setBackground(new java.awt.Color(61, 61, 61));
        jLabel62.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel62.setText("Homepage");
        jPanel61.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel60.add(jPanel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel62.setBackground(new java.awt.Color(255, 51, 0));
        jPanel62.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel63.setBackground(new java.awt.Color(61, 61, 61));
        jLabel63.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel63.setText("Homepage");
        jPanel62.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel63.setBackground(new java.awt.Color(255, 51, 0));
        jPanel63.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel64.setBackground(new java.awt.Color(61, 61, 61));
        jLabel64.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel64.setText("Homepage");
        jPanel63.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel62.add(jPanel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel60.add(jPanel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel64.setBackground(new java.awt.Color(255, 51, 0));
        jPanel64.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel65.setBackground(new java.awt.Color(61, 61, 61));
        jLabel65.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel65.setText("Homepage");
        jPanel64.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel65.setBackground(new java.awt.Color(255, 51, 0));
        jPanel65.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel66.setBackground(new java.awt.Color(61, 61, 61));
        jLabel66.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel66.setText("Homepage");
        jPanel65.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel64.add(jPanel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel66.setBackground(new java.awt.Color(255, 51, 0));
        jPanel66.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel67.setBackground(new java.awt.Color(61, 61, 61));
        jLabel67.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel67.setText("Homepage");
        jPanel66.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel67.setBackground(new java.awt.Color(255, 51, 0));
        jPanel67.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel68.setBackground(new java.awt.Color(61, 61, 61));
        jLabel68.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel68.setText("Homepage");
        jPanel67.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel66.add(jPanel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel64.add(jPanel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel60.add(jPanel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel158.setBackground(new java.awt.Color(255, 51, 0));
        jPanel158.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel158.setBackground(new java.awt.Color(61, 61, 61));
        jLabel158.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel158.setForeground(new java.awt.Color(255, 255, 255));
        jLabel158.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel158.setText("Trang chủ");
        jPanel158.add(jLabel158, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel159.setBackground(new java.awt.Color(255, 51, 0));
        jPanel159.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel159.setBackground(new java.awt.Color(61, 61, 61));
        jLabel159.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel159.setForeground(new java.awt.Color(255, 255, 255));
        jLabel159.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel159.setText("Homepage");
        jPanel159.add(jLabel159, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel158.add(jPanel159, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel160.setBackground(new java.awt.Color(255, 51, 0));
        jPanel160.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel160.setBackground(new java.awt.Color(61, 61, 61));
        jLabel160.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel160.setForeground(new java.awt.Color(255, 255, 255));
        jLabel160.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel160.setText("Homepage");
        jPanel160.add(jLabel160, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel161.setBackground(new java.awt.Color(255, 51, 0));
        jPanel161.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel161.setBackground(new java.awt.Color(61, 61, 61));
        jLabel161.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel161.setForeground(new java.awt.Color(255, 255, 255));
        jLabel161.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel161.setText("Homepage");
        jPanel161.add(jLabel161, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel160.add(jPanel161, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel158.add(jPanel160, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel162.setBackground(new java.awt.Color(255, 51, 0));
        jPanel162.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel162.setBackground(new java.awt.Color(61, 61, 61));
        jLabel162.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel162.setForeground(new java.awt.Color(255, 255, 255));
        jLabel162.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel162.setText("Homepage");
        jPanel162.add(jLabel162, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel163.setBackground(new java.awt.Color(255, 51, 0));
        jPanel163.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel163.setBackground(new java.awt.Color(61, 61, 61));
        jLabel163.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel163.setForeground(new java.awt.Color(255, 255, 255));
        jLabel163.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel163.setText("Homepage");
        jPanel163.add(jLabel163, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel162.add(jPanel163, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel164.setBackground(new java.awt.Color(255, 51, 0));
        jPanel164.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel164.setBackground(new java.awt.Color(61, 61, 61));
        jLabel164.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel164.setForeground(new java.awt.Color(255, 255, 255));
        jLabel164.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel164.setText("Homepage");
        jPanel164.add(jLabel164, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel165.setBackground(new java.awt.Color(255, 51, 0));
        jPanel165.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel165.setBackground(new java.awt.Color(61, 61, 61));
        jLabel165.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel165.setForeground(new java.awt.Color(255, 255, 255));
        jLabel165.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel165.setText("Homepage");
        jPanel165.add(jLabel165, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel164.add(jPanel165, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel162.add(jPanel164, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel158.add(jPanel162, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel166.setBackground(new java.awt.Color(255, 51, 0));
        jPanel166.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel166.setBackground(new java.awt.Color(61, 61, 61));
        jLabel166.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel166.setForeground(new java.awt.Color(255, 255, 255));
        jLabel166.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel166.setText("Trang chủ");
        jPanel166.add(jLabel166, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel167.setBackground(new java.awt.Color(255, 51, 0));
        jPanel167.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel167.setBackground(new java.awt.Color(61, 61, 61));
        jLabel167.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel167.setForeground(new java.awt.Color(255, 255, 255));
        jLabel167.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel167.setText("Homepage");
        jPanel167.add(jLabel167, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel166.add(jPanel167, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel168.setBackground(new java.awt.Color(255, 51, 0));
        jPanel168.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel168.setBackground(new java.awt.Color(61, 61, 61));
        jLabel168.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel168.setForeground(new java.awt.Color(255, 255, 255));
        jLabel168.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel168.setText("Homepage");
        jPanel168.add(jLabel168, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel169.setBackground(new java.awt.Color(255, 51, 0));
        jPanel169.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel169.setBackground(new java.awt.Color(61, 61, 61));
        jLabel169.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel169.setForeground(new java.awt.Color(255, 255, 255));
        jLabel169.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel169.setText("Homepage");
        jPanel169.add(jLabel169, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel168.add(jPanel169, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel166.add(jPanel168, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel170.setBackground(new java.awt.Color(255, 51, 0));
        jPanel170.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel170.setBackground(new java.awt.Color(61, 61, 61));
        jLabel170.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel170.setForeground(new java.awt.Color(255, 255, 255));
        jLabel170.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel170.setText("Homepage");
        jPanel170.add(jLabel170, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel171.setBackground(new java.awt.Color(255, 51, 0));
        jPanel171.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel171.setBackground(new java.awt.Color(61, 61, 61));
        jLabel171.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel171.setForeground(new java.awt.Color(255, 255, 255));
        jLabel171.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel171.setText("Homepage");
        jPanel171.add(jLabel171, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel170.add(jPanel171, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel172.setBackground(new java.awt.Color(255, 51, 0));
        jPanel172.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel172.setBackground(new java.awt.Color(61, 61, 61));
        jLabel172.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel172.setForeground(new java.awt.Color(255, 255, 255));
        jLabel172.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel172.setText("Homepage");
        jPanel172.add(jLabel172, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel173.setBackground(new java.awt.Color(255, 51, 0));
        jPanel173.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel173.setBackground(new java.awt.Color(61, 61, 61));
        jLabel173.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel173.setForeground(new java.awt.Color(255, 255, 255));
        jLabel173.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel173.setText("Homepage");
        jPanel173.add(jLabel173, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel172.add(jPanel173, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel170.add(jPanel172, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel166.add(jPanel170, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel158.add(jPanel166, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 210, 40));

        jPanel174.setBackground(new java.awt.Color(255, 51, 0));
        jPanel174.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel174.setBackground(new java.awt.Color(61, 61, 61));
        jLabel174.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel174.setForeground(new java.awt.Color(255, 255, 255));
        jLabel174.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel174.setText("Trang chủ");
        jPanel174.add(jLabel174, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel175.setBackground(new java.awt.Color(255, 51, 0));
        jPanel175.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel175.setBackground(new java.awt.Color(61, 61, 61));
        jLabel175.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel175.setForeground(new java.awt.Color(255, 255, 255));
        jLabel175.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel175.setText("Homepage");
        jPanel175.add(jLabel175, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel174.add(jPanel175, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel176.setBackground(new java.awt.Color(255, 51, 0));
        jPanel176.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel176.setBackground(new java.awt.Color(61, 61, 61));
        jLabel176.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel176.setForeground(new java.awt.Color(255, 255, 255));
        jLabel176.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel176.setText("Homepage");
        jPanel176.add(jLabel176, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel177.setBackground(new java.awt.Color(255, 51, 0));
        jPanel177.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel177.setBackground(new java.awt.Color(61, 61, 61));
        jLabel177.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel177.setForeground(new java.awt.Color(255, 255, 255));
        jLabel177.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel177.setText("Homepage");
        jPanel177.add(jLabel177, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel176.add(jPanel177, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel174.add(jPanel176, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel178.setBackground(new java.awt.Color(255, 51, 0));
        jPanel178.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel178.setBackground(new java.awt.Color(61, 61, 61));
        jLabel178.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel178.setForeground(new java.awt.Color(255, 255, 255));
        jLabel178.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel178.setText("Homepage");
        jPanel178.add(jLabel178, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel179.setBackground(new java.awt.Color(255, 51, 0));
        jPanel179.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel179.setBackground(new java.awt.Color(61, 61, 61));
        jLabel179.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel179.setForeground(new java.awt.Color(255, 255, 255));
        jLabel179.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel179.setText("Homepage");
        jPanel179.add(jLabel179, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel178.add(jPanel179, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel180.setBackground(new java.awt.Color(255, 51, 0));
        jPanel180.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel180.setBackground(new java.awt.Color(61, 61, 61));
        jLabel180.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel180.setForeground(new java.awt.Color(255, 255, 255));
        jLabel180.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel180.setText("Homepage");
        jPanel180.add(jLabel180, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel181.setBackground(new java.awt.Color(255, 51, 0));
        jPanel181.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel181.setBackground(new java.awt.Color(61, 61, 61));
        jLabel181.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel181.setForeground(new java.awt.Color(255, 255, 255));
        jLabel181.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel181.setText("Homepage");
        jPanel181.add(jLabel181, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel180.add(jPanel181, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel178.add(jPanel180, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel174.add(jPanel178, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel182.setBackground(new java.awt.Color(255, 51, 0));
        jPanel182.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel182.setBackground(new java.awt.Color(61, 61, 61));
        jLabel182.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel182.setForeground(new java.awt.Color(255, 255, 255));
        jLabel182.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel182.setText("Trang chủ");
        jPanel182.add(jLabel182, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel183.setBackground(new java.awt.Color(255, 51, 0));
        jPanel183.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel183.setBackground(new java.awt.Color(61, 61, 61));
        jLabel183.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel183.setForeground(new java.awt.Color(255, 255, 255));
        jLabel183.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel183.setText("Homepage");
        jPanel183.add(jLabel183, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel182.add(jPanel183, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel184.setBackground(new java.awt.Color(255, 51, 0));
        jPanel184.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel184.setBackground(new java.awt.Color(61, 61, 61));
        jLabel184.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel184.setForeground(new java.awt.Color(255, 255, 255));
        jLabel184.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel184.setText("Homepage");
        jPanel184.add(jLabel184, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel185.setBackground(new java.awt.Color(255, 51, 0));
        jPanel185.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel185.setBackground(new java.awt.Color(61, 61, 61));
        jLabel185.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel185.setForeground(new java.awt.Color(255, 255, 255));
        jLabel185.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel185.setText("Homepage");
        jPanel185.add(jLabel185, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel184.add(jPanel185, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel182.add(jPanel184, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel186.setBackground(new java.awt.Color(255, 51, 0));
        jPanel186.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel186.setBackground(new java.awt.Color(61, 61, 61));
        jLabel186.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel186.setForeground(new java.awt.Color(255, 255, 255));
        jLabel186.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel186.setText("Homepage");
        jPanel186.add(jLabel186, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel187.setBackground(new java.awt.Color(255, 51, 0));
        jPanel187.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel187.setBackground(new java.awt.Color(61, 61, 61));
        jLabel187.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel187.setForeground(new java.awt.Color(255, 255, 255));
        jLabel187.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel187.setText("Homepage");
        jPanel187.add(jLabel187, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel186.add(jPanel187, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel188.setBackground(new java.awt.Color(255, 51, 0));
        jPanel188.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel188.setBackground(new java.awt.Color(61, 61, 61));
        jLabel188.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel188.setForeground(new java.awt.Color(255, 255, 255));
        jLabel188.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel188.setText("Homepage");
        jPanel188.add(jLabel188, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel189.setBackground(new java.awt.Color(255, 51, 0));
        jPanel189.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel189.setBackground(new java.awt.Color(61, 61, 61));
        jLabel189.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel189.setForeground(new java.awt.Color(255, 255, 255));
        jLabel189.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel189.setText("Homepage");
        jPanel189.add(jLabel189, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel188.add(jPanel189, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel186.add(jPanel188, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel182.add(jPanel186, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel174.add(jPanel182, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 210, 40));

        jPanel158.add(jPanel174, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 210, 40));

        jPanel60.add(jPanel158, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 210, 40));

        jPanel190.setBackground(new java.awt.Color(255, 51, 0));
        jPanel190.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel190.setBackground(new java.awt.Color(61, 61, 61));
        jLabel190.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel190.setForeground(new java.awt.Color(255, 255, 255));
        jLabel190.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel190.setText("Trang chủ");
        jPanel190.add(jLabel190, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel191.setBackground(new java.awt.Color(255, 51, 0));
        jPanel191.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel191.setBackground(new java.awt.Color(61, 61, 61));
        jLabel191.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel191.setForeground(new java.awt.Color(255, 255, 255));
        jLabel191.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel191.setText("Homepage");
        jPanel191.add(jLabel191, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel190.add(jPanel191, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel192.setBackground(new java.awt.Color(255, 51, 0));
        jPanel192.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel192.setBackground(new java.awt.Color(61, 61, 61));
        jLabel192.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel192.setForeground(new java.awt.Color(255, 255, 255));
        jLabel192.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel192.setText("Homepage");
        jPanel192.add(jLabel192, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel193.setBackground(new java.awt.Color(255, 51, 0));
        jPanel193.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel193.setBackground(new java.awt.Color(61, 61, 61));
        jLabel193.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel193.setForeground(new java.awt.Color(255, 255, 255));
        jLabel193.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel193.setText("Homepage");
        jPanel193.add(jLabel193, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel192.add(jPanel193, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel190.add(jPanel192, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel194.setBackground(new java.awt.Color(255, 51, 0));
        jPanel194.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel194.setBackground(new java.awt.Color(61, 61, 61));
        jLabel194.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel194.setForeground(new java.awt.Color(255, 255, 255));
        jLabel194.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel194.setText("Homepage");
        jPanel194.add(jLabel194, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel195.setBackground(new java.awt.Color(255, 51, 0));
        jPanel195.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel195.setBackground(new java.awt.Color(61, 61, 61));
        jLabel195.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel195.setForeground(new java.awt.Color(255, 255, 255));
        jLabel195.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel195.setText("Homepage");
        jPanel195.add(jLabel195, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel194.add(jPanel195, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel196.setBackground(new java.awt.Color(255, 51, 0));
        jPanel196.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel196.setBackground(new java.awt.Color(61, 61, 61));
        jLabel196.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel196.setForeground(new java.awt.Color(255, 255, 255));
        jLabel196.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel196.setText("Homepage");
        jPanel196.add(jLabel196, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel197.setBackground(new java.awt.Color(255, 51, 0));
        jPanel197.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel197.setBackground(new java.awt.Color(61, 61, 61));
        jLabel197.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel197.setForeground(new java.awt.Color(255, 255, 255));
        jLabel197.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel197.setText("Homepage");
        jPanel197.add(jLabel197, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel196.add(jPanel197, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel194.add(jPanel196, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel190.add(jPanel194, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel198.setBackground(new java.awt.Color(255, 51, 0));
        jPanel198.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel198.setBackground(new java.awt.Color(61, 61, 61));
        jLabel198.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel198.setForeground(new java.awt.Color(255, 255, 255));
        jLabel198.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel198.setText("Trang chủ");
        jPanel198.add(jLabel198, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel199.setBackground(new java.awt.Color(255, 51, 0));
        jPanel199.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel199.setBackground(new java.awt.Color(61, 61, 61));
        jLabel199.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel199.setForeground(new java.awt.Color(255, 255, 255));
        jLabel199.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel199.setText("Homepage");
        jPanel199.add(jLabel199, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel198.add(jPanel199, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel200.setBackground(new java.awt.Color(255, 51, 0));
        jPanel200.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel200.setBackground(new java.awt.Color(61, 61, 61));
        jLabel200.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel200.setForeground(new java.awt.Color(255, 255, 255));
        jLabel200.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel200.setText("Homepage");
        jPanel200.add(jLabel200, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel201.setBackground(new java.awt.Color(255, 51, 0));
        jPanel201.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel201.setBackground(new java.awt.Color(61, 61, 61));
        jLabel201.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel201.setForeground(new java.awt.Color(255, 255, 255));
        jLabel201.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel201.setText("Homepage");
        jPanel201.add(jLabel201, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel200.add(jPanel201, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel198.add(jPanel200, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel202.setBackground(new java.awt.Color(255, 51, 0));
        jPanel202.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel202.setBackground(new java.awt.Color(61, 61, 61));
        jLabel202.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel202.setForeground(new java.awt.Color(255, 255, 255));
        jLabel202.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel202.setText("Homepage");
        jPanel202.add(jLabel202, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel203.setBackground(new java.awt.Color(255, 51, 0));
        jPanel203.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel203.setBackground(new java.awt.Color(61, 61, 61));
        jLabel203.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel203.setForeground(new java.awt.Color(255, 255, 255));
        jLabel203.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel203.setText("Homepage");
        jPanel203.add(jLabel203, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel202.add(jPanel203, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel204.setBackground(new java.awt.Color(255, 51, 0));
        jPanel204.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel204.setBackground(new java.awt.Color(61, 61, 61));
        jLabel204.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel204.setForeground(new java.awt.Color(255, 255, 255));
        jLabel204.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel204.setText("Homepage");
        jPanel204.add(jLabel204, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel205.setBackground(new java.awt.Color(255, 51, 0));
        jPanel205.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel205.setBackground(new java.awt.Color(61, 61, 61));
        jLabel205.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel205.setForeground(new java.awt.Color(255, 255, 255));
        jLabel205.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel205.setText("Homepage");
        jPanel205.add(jLabel205, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel204.add(jPanel205, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel202.add(jPanel204, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel198.add(jPanel202, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel190.add(jPanel198, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 210, 40));

        jPanel206.setBackground(new java.awt.Color(255, 51, 0));
        jPanel206.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel206.setBackground(new java.awt.Color(61, 61, 61));
        jLabel206.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel206.setForeground(new java.awt.Color(255, 255, 255));
        jLabel206.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel206.setText("Trang chủ");
        jPanel206.add(jLabel206, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel207.setBackground(new java.awt.Color(255, 51, 0));
        jPanel207.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel207.setBackground(new java.awt.Color(61, 61, 61));
        jLabel207.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel207.setForeground(new java.awt.Color(255, 255, 255));
        jLabel207.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel207.setText("Homepage");
        jPanel207.add(jLabel207, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel206.add(jPanel207, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel208.setBackground(new java.awt.Color(255, 51, 0));
        jPanel208.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel208.setBackground(new java.awt.Color(61, 61, 61));
        jLabel208.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel208.setForeground(new java.awt.Color(255, 255, 255));
        jLabel208.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel208.setText("Homepage");
        jPanel208.add(jLabel208, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel209.setBackground(new java.awt.Color(255, 51, 0));
        jPanel209.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel209.setBackground(new java.awt.Color(61, 61, 61));
        jLabel209.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel209.setForeground(new java.awt.Color(255, 255, 255));
        jLabel209.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel209.setText("Homepage");
        jPanel209.add(jLabel209, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel208.add(jPanel209, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel206.add(jPanel208, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel210.setBackground(new java.awt.Color(255, 51, 0));
        jPanel210.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel210.setBackground(new java.awt.Color(61, 61, 61));
        jLabel210.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel210.setForeground(new java.awt.Color(255, 255, 255));
        jLabel210.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel210.setText("Homepage");
        jPanel210.add(jLabel210, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel211.setBackground(new java.awt.Color(255, 51, 0));
        jPanel211.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel211.setBackground(new java.awt.Color(61, 61, 61));
        jLabel211.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel211.setForeground(new java.awt.Color(255, 255, 255));
        jLabel211.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel211.setText("Homepage");
        jPanel211.add(jLabel211, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel210.add(jPanel211, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel212.setBackground(new java.awt.Color(255, 51, 0));
        jPanel212.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel212.setBackground(new java.awt.Color(61, 61, 61));
        jLabel212.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel212.setForeground(new java.awt.Color(255, 255, 255));
        jLabel212.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel212.setText("Homepage");
        jPanel212.add(jLabel212, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel213.setBackground(new java.awt.Color(255, 51, 0));
        jPanel213.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel213.setBackground(new java.awt.Color(61, 61, 61));
        jLabel213.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel213.setForeground(new java.awt.Color(255, 255, 255));
        jLabel213.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel213.setText("Homepage");
        jPanel213.add(jLabel213, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel212.add(jPanel213, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel210.add(jPanel212, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel206.add(jPanel210, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel214.setBackground(new java.awt.Color(255, 51, 0));
        jPanel214.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel214.setBackground(new java.awt.Color(61, 61, 61));
        jLabel214.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel214.setForeground(new java.awt.Color(255, 255, 255));
        jLabel214.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel214.setText("Trang chủ");
        jPanel214.add(jLabel214, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel215.setBackground(new java.awt.Color(255, 51, 0));
        jPanel215.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel215.setBackground(new java.awt.Color(61, 61, 61));
        jLabel215.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel215.setForeground(new java.awt.Color(255, 255, 255));
        jLabel215.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel215.setText("Homepage");
        jPanel215.add(jLabel215, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel214.add(jPanel215, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel216.setBackground(new java.awt.Color(255, 51, 0));
        jPanel216.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel216.setBackground(new java.awt.Color(61, 61, 61));
        jLabel216.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel216.setForeground(new java.awt.Color(255, 255, 255));
        jLabel216.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel216.setText("Homepage");
        jPanel216.add(jLabel216, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel217.setBackground(new java.awt.Color(255, 51, 0));
        jPanel217.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel217.setBackground(new java.awt.Color(61, 61, 61));
        jLabel217.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel217.setForeground(new java.awt.Color(255, 255, 255));
        jLabel217.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel217.setText("Homepage");
        jPanel217.add(jLabel217, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel216.add(jPanel217, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel214.add(jPanel216, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel218.setBackground(new java.awt.Color(255, 51, 0));
        jPanel218.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel218.setBackground(new java.awt.Color(61, 61, 61));
        jLabel218.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel218.setForeground(new java.awt.Color(255, 255, 255));
        jLabel218.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel218.setText("Homepage");
        jPanel218.add(jLabel218, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel219.setBackground(new java.awt.Color(255, 51, 0));
        jPanel219.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel219.setBackground(new java.awt.Color(61, 61, 61));
        jLabel219.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel219.setForeground(new java.awt.Color(255, 255, 255));
        jLabel219.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel219.setText("Homepage");
        jPanel219.add(jLabel219, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel218.add(jPanel219, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel220.setBackground(new java.awt.Color(255, 51, 0));
        jPanel220.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel220.setBackground(new java.awt.Color(61, 61, 61));
        jLabel220.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel220.setForeground(new java.awt.Color(255, 255, 255));
        jLabel220.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel220.setText("Homepage");
        jPanel220.add(jLabel220, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel221.setBackground(new java.awt.Color(255, 51, 0));
        jPanel221.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel221.setBackground(new java.awt.Color(61, 61, 61));
        jLabel221.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel221.setForeground(new java.awt.Color(255, 255, 255));
        jLabel221.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel221.setText("Homepage");
        jPanel221.add(jLabel221, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel220.add(jPanel221, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel218.add(jPanel220, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel214.add(jPanel218, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel206.add(jPanel214, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 210, 40));

        jPanel190.add(jPanel206, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 210, 40));

        jPanel60.add(jPanel190, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 210, 40));

        jLabel222.setBackground(new java.awt.Color(61, 61, 61));
        jLabel222.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel222.setForeground(new java.awt.Color(153, 153, 153));
        jLabel222.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Conference_26px.png"))); // NOI18N
        jLabel222.setText("Quản lý người mượn");
        jPanel60.add(jLabel222, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 210, 40));

        jPanel3.add(jPanel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 150, 40));

        jLabel13.setBackground(new java.awt.Color(61, 61, 61));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Exit_26px_2.png"))); // NOI18N
        jLabel13.setText("Đăng xuất");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, -1, -1));

        jPanel69.setBackground(new java.awt.Color(102, 102, 255));
        jPanel69.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel69MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel69Layout = new javax.swing.GroupLayout(jPanel69);
        jPanel69.setLayout(jPanel69Layout);
        jPanel69Layout.setHorizontalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        jPanel69Layout.setVerticalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 210, 40));

        jPanel52.setBackground(new java.awt.Color(51, 51, 51));
        jPanel52.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel53.setBackground(new java.awt.Color(61, 61, 61));
        jLabel53.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(153, 153, 153));
        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Book_26px.png"))); // NOI18N
        jLabel53.setText("Quản lý sách");
        jPanel52.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 120, -1));

        jPanel53.setBackground(new java.awt.Color(255, 51, 0));
        jPanel53.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel54.setBackground(new java.awt.Color(61, 61, 61));
        jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel54.setText("Homepage");
        jPanel53.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel52.add(jPanel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel54.setBackground(new java.awt.Color(255, 51, 0));
        jPanel54.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel55.setBackground(new java.awt.Color(61, 61, 61));
        jLabel55.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel55.setText("Homepage");
        jPanel54.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel55.setBackground(new java.awt.Color(255, 51, 0));
        jPanel55.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel56.setBackground(new java.awt.Color(61, 61, 61));
        jLabel56.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel56.setText("Homepage");
        jPanel55.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel54.add(jPanel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel52.add(jPanel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel56.setBackground(new java.awt.Color(255, 51, 0));
        jPanel56.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel57.setBackground(new java.awt.Color(61, 61, 61));
        jLabel57.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel57.setText("Homepage");
        jPanel56.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel57.setBackground(new java.awt.Color(255, 51, 0));
        jPanel57.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel58.setBackground(new java.awt.Color(61, 61, 61));
        jLabel58.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel58.setText("Homepage");
        jPanel57.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel56.add(jPanel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel58.setBackground(new java.awt.Color(255, 51, 0));
        jPanel58.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel59.setBackground(new java.awt.Color(61, 61, 61));
        jLabel59.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel59.setText("Homepage");
        jPanel58.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel59.setBackground(new java.awt.Color(255, 51, 0));
        jPanel59.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel60.setBackground(new java.awt.Color(61, 61, 61));
        jLabel60.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel60.setText("Homepage");
        jPanel59.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel58.add(jPanel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel56.add(jPanel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel52.add(jPanel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel126.setBackground(new java.awt.Color(255, 51, 0));
        jPanel126.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel126.setBackground(new java.awt.Color(61, 61, 61));
        jLabel126.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel126.setForeground(new java.awt.Color(255, 255, 255));
        jLabel126.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel126.setText("Trang chủ");
        jPanel126.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel127.setBackground(new java.awt.Color(255, 51, 0));
        jPanel127.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel127.setBackground(new java.awt.Color(61, 61, 61));
        jLabel127.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel127.setForeground(new java.awt.Color(255, 255, 255));
        jLabel127.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel127.setText("Homepage");
        jPanel127.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel126.add(jPanel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel128.setBackground(new java.awt.Color(255, 51, 0));
        jPanel128.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel128.setBackground(new java.awt.Color(61, 61, 61));
        jLabel128.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel128.setForeground(new java.awt.Color(255, 255, 255));
        jLabel128.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel128.setText("Homepage");
        jPanel128.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel129.setBackground(new java.awt.Color(255, 51, 0));
        jPanel129.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel129.setBackground(new java.awt.Color(61, 61, 61));
        jLabel129.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel129.setForeground(new java.awt.Color(255, 255, 255));
        jLabel129.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel129.setText("Homepage");
        jPanel129.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel128.add(jPanel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel126.add(jPanel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel130.setBackground(new java.awt.Color(255, 51, 0));
        jPanel130.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel130.setBackground(new java.awt.Color(61, 61, 61));
        jLabel130.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel130.setForeground(new java.awt.Color(255, 255, 255));
        jLabel130.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel130.setText("Homepage");
        jPanel130.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel131.setBackground(new java.awt.Color(255, 51, 0));
        jPanel131.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel131.setBackground(new java.awt.Color(61, 61, 61));
        jLabel131.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel131.setForeground(new java.awt.Color(255, 255, 255));
        jLabel131.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel131.setText("Homepage");
        jPanel131.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel130.add(jPanel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel132.setBackground(new java.awt.Color(255, 51, 0));
        jPanel132.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel132.setBackground(new java.awt.Color(61, 61, 61));
        jLabel132.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel132.setForeground(new java.awt.Color(255, 255, 255));
        jLabel132.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel132.setText("Homepage");
        jPanel132.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel133.setBackground(new java.awt.Color(255, 51, 0));
        jPanel133.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel133.setBackground(new java.awt.Color(61, 61, 61));
        jLabel133.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel133.setForeground(new java.awt.Color(255, 255, 255));
        jLabel133.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel133.setText("Homepage");
        jPanel133.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel132.add(jPanel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel130.add(jPanel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel126.add(jPanel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel134.setBackground(new java.awt.Color(255, 51, 0));
        jPanel134.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel134.setBackground(new java.awt.Color(61, 61, 61));
        jLabel134.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel134.setForeground(new java.awt.Color(255, 255, 255));
        jLabel134.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel134.setText("Trang chủ");
        jPanel134.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel135.setBackground(new java.awt.Color(255, 51, 0));
        jPanel135.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel135.setBackground(new java.awt.Color(61, 61, 61));
        jLabel135.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel135.setForeground(new java.awt.Color(255, 255, 255));
        jLabel135.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel135.setText("Homepage");
        jPanel135.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel134.add(jPanel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel136.setBackground(new java.awt.Color(255, 51, 0));
        jPanel136.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel136.setBackground(new java.awt.Color(61, 61, 61));
        jLabel136.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel136.setForeground(new java.awt.Color(255, 255, 255));
        jLabel136.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel136.setText("Homepage");
        jPanel136.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel137.setBackground(new java.awt.Color(255, 51, 0));
        jPanel137.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel137.setBackground(new java.awt.Color(61, 61, 61));
        jLabel137.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel137.setForeground(new java.awt.Color(255, 255, 255));
        jLabel137.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel137.setText("Homepage");
        jPanel137.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel136.add(jPanel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel134.add(jPanel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel138.setBackground(new java.awt.Color(255, 51, 0));
        jPanel138.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel138.setBackground(new java.awt.Color(61, 61, 61));
        jLabel138.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel138.setForeground(new java.awt.Color(255, 255, 255));
        jLabel138.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel138.setText("Homepage");
        jPanel138.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel139.setBackground(new java.awt.Color(255, 51, 0));
        jPanel139.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel139.setBackground(new java.awt.Color(61, 61, 61));
        jLabel139.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel139.setForeground(new java.awt.Color(255, 255, 255));
        jLabel139.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel139.setText("Homepage");
        jPanel139.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel138.add(jPanel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel140.setBackground(new java.awt.Color(255, 51, 0));
        jPanel140.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel140.setBackground(new java.awt.Color(61, 61, 61));
        jLabel140.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel140.setForeground(new java.awt.Color(255, 255, 255));
        jLabel140.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel140.setText("Homepage");
        jPanel140.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel141.setBackground(new java.awt.Color(255, 51, 0));
        jPanel141.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel141.setBackground(new java.awt.Color(61, 61, 61));
        jLabel141.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel141.setForeground(new java.awt.Color(255, 255, 255));
        jLabel141.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel141.setText("Homepage");
        jPanel141.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel140.add(jPanel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel138.add(jPanel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel134.add(jPanel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel126.add(jPanel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 210, 40));

        jPanel142.setBackground(new java.awt.Color(255, 51, 0));
        jPanel142.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel142.setBackground(new java.awt.Color(61, 61, 61));
        jLabel142.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel142.setForeground(new java.awt.Color(255, 255, 255));
        jLabel142.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel142.setText("Trang chủ");
        jPanel142.add(jLabel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel143.setBackground(new java.awt.Color(255, 51, 0));
        jPanel143.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel143.setBackground(new java.awt.Color(61, 61, 61));
        jLabel143.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel143.setForeground(new java.awt.Color(255, 255, 255));
        jLabel143.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel143.setText("Homepage");
        jPanel143.add(jLabel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel142.add(jPanel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel144.setBackground(new java.awt.Color(255, 51, 0));
        jPanel144.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel144.setBackground(new java.awt.Color(61, 61, 61));
        jLabel144.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel144.setForeground(new java.awt.Color(255, 255, 255));
        jLabel144.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel144.setText("Homepage");
        jPanel144.add(jLabel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel145.setBackground(new java.awt.Color(255, 51, 0));
        jPanel145.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel145.setBackground(new java.awt.Color(61, 61, 61));
        jLabel145.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel145.setForeground(new java.awt.Color(255, 255, 255));
        jLabel145.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel145.setText("Homepage");
        jPanel145.add(jLabel145, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel144.add(jPanel145, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel142.add(jPanel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel146.setBackground(new java.awt.Color(255, 51, 0));
        jPanel146.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel146.setBackground(new java.awt.Color(61, 61, 61));
        jLabel146.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel146.setForeground(new java.awt.Color(255, 255, 255));
        jLabel146.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel146.setText("Homepage");
        jPanel146.add(jLabel146, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel147.setBackground(new java.awt.Color(255, 51, 0));
        jPanel147.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel147.setBackground(new java.awt.Color(61, 61, 61));
        jLabel147.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel147.setForeground(new java.awt.Color(255, 255, 255));
        jLabel147.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel147.setText("Homepage");
        jPanel147.add(jLabel147, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel146.add(jPanel147, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel148.setBackground(new java.awt.Color(255, 51, 0));
        jPanel148.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel148.setBackground(new java.awt.Color(61, 61, 61));
        jLabel148.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel148.setForeground(new java.awt.Color(255, 255, 255));
        jLabel148.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel148.setText("Homepage");
        jPanel148.add(jLabel148, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel149.setBackground(new java.awt.Color(255, 51, 0));
        jPanel149.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel149.setBackground(new java.awt.Color(61, 61, 61));
        jLabel149.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel149.setForeground(new java.awt.Color(255, 255, 255));
        jLabel149.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel149.setText("Homepage");
        jPanel149.add(jLabel149, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel148.add(jPanel149, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel146.add(jPanel148, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel142.add(jPanel146, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel150.setBackground(new java.awt.Color(255, 51, 0));
        jPanel150.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel150.setBackground(new java.awt.Color(61, 61, 61));
        jLabel150.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel150.setForeground(new java.awt.Color(255, 255, 255));
        jLabel150.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel150.setText("Trang chủ");
        jPanel150.add(jLabel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel151.setBackground(new java.awt.Color(255, 51, 0));
        jPanel151.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel151.setBackground(new java.awt.Color(61, 61, 61));
        jLabel151.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel151.setForeground(new java.awt.Color(255, 255, 255));
        jLabel151.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel151.setText("Homepage");
        jPanel151.add(jLabel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel150.add(jPanel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel152.setBackground(new java.awt.Color(255, 51, 0));
        jPanel152.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel152.setBackground(new java.awt.Color(61, 61, 61));
        jLabel152.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel152.setForeground(new java.awt.Color(255, 255, 255));
        jLabel152.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel152.setText("Homepage");
        jPanel152.add(jLabel152, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel153.setBackground(new java.awt.Color(255, 51, 0));
        jPanel153.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel153.setBackground(new java.awt.Color(61, 61, 61));
        jLabel153.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel153.setForeground(new java.awt.Color(255, 255, 255));
        jLabel153.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel153.setText("Homepage");
        jPanel153.add(jLabel153, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel152.add(jPanel153, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel150.add(jPanel152, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel154.setBackground(new java.awt.Color(255, 51, 0));
        jPanel154.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel154.setBackground(new java.awt.Color(61, 61, 61));
        jLabel154.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel154.setForeground(new java.awt.Color(255, 255, 255));
        jLabel154.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel154.setText("Homepage");
        jPanel154.add(jLabel154, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel155.setBackground(new java.awt.Color(255, 51, 0));
        jPanel155.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel155.setBackground(new java.awt.Color(61, 61, 61));
        jLabel155.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel155.setForeground(new java.awt.Color(255, 255, 255));
        jLabel155.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel155.setText("Homepage");
        jPanel155.add(jLabel155, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel154.add(jPanel155, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel156.setBackground(new java.awt.Color(255, 51, 0));
        jPanel156.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel156.setBackground(new java.awt.Color(61, 61, 61));
        jLabel156.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel156.setForeground(new java.awt.Color(255, 255, 255));
        jLabel156.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel156.setText("Homepage");
        jPanel156.add(jLabel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel157.setBackground(new java.awt.Color(255, 51, 0));
        jPanel157.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel157.setBackground(new java.awt.Color(61, 61, 61));
        jLabel157.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel157.setForeground(new java.awt.Color(255, 255, 255));
        jLabel157.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel157.setText("Homepage");
        jPanel157.add(jLabel157, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel156.add(jPanel157, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel154.add(jPanel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel150.add(jPanel154, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel142.add(jPanel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 210, 40));

        jPanel126.add(jPanel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 210, 40));

        jPanel52.add(jPanel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 210, 40));

        jPanel227.setBackground(new java.awt.Color(51, 51, 51));
        jPanel227.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel223.setBackground(new java.awt.Color(61, 61, 61));
        jLabel223.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel223.setForeground(new java.awt.Color(153, 153, 153));
        jLabel223.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Book_26px.png"))); // NOI18N
        jLabel223.setText("Quản lý sách");
        jPanel227.add(jLabel223, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 120, -1));

        jPanel228.setBackground(new java.awt.Color(255, 51, 0));
        jPanel228.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel227.setBackground(new java.awt.Color(61, 61, 61));
        jLabel227.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel227.setForeground(new java.awt.Color(255, 255, 255));
        jLabel227.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel227.setText("Homepage");
        jPanel228.add(jLabel227, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel227.add(jPanel228, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel229.setBackground(new java.awt.Color(255, 51, 0));
        jPanel229.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel228.setBackground(new java.awt.Color(61, 61, 61));
        jLabel228.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel228.setForeground(new java.awt.Color(255, 255, 255));
        jLabel228.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel228.setText("Homepage");
        jPanel229.add(jLabel228, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel230.setBackground(new java.awt.Color(255, 51, 0));
        jPanel230.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel233.setBackground(new java.awt.Color(61, 61, 61));
        jLabel233.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel233.setForeground(new java.awt.Color(255, 255, 255));
        jLabel233.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel233.setText("Homepage");
        jPanel230.add(jLabel233, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel229.add(jPanel230, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel227.add(jPanel229, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel231.setBackground(new java.awt.Color(255, 51, 0));
        jPanel231.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel234.setBackground(new java.awt.Color(61, 61, 61));
        jLabel234.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel234.setForeground(new java.awt.Color(255, 255, 255));
        jLabel234.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel234.setText("Homepage");
        jPanel231.add(jLabel234, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel232.setBackground(new java.awt.Color(255, 51, 0));
        jPanel232.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel235.setBackground(new java.awt.Color(61, 61, 61));
        jLabel235.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel235.setForeground(new java.awt.Color(255, 255, 255));
        jLabel235.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel235.setText("Homepage");
        jPanel232.add(jLabel235, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel231.add(jPanel232, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel233.setBackground(new java.awt.Color(255, 51, 0));
        jPanel233.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel236.setBackground(new java.awt.Color(61, 61, 61));
        jLabel236.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel236.setForeground(new java.awt.Color(255, 255, 255));
        jLabel236.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel236.setText("Homepage");
        jPanel233.add(jLabel236, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel234.setBackground(new java.awt.Color(255, 51, 0));
        jPanel234.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel237.setBackground(new java.awt.Color(61, 61, 61));
        jLabel237.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel237.setForeground(new java.awt.Color(255, 255, 255));
        jLabel237.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel237.setText("Homepage");
        jPanel234.add(jLabel237, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel233.add(jPanel234, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel231.add(jPanel233, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel227.add(jPanel231, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel235.setBackground(new java.awt.Color(255, 51, 0));
        jPanel235.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel238.setBackground(new java.awt.Color(61, 61, 61));
        jLabel238.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel238.setForeground(new java.awt.Color(255, 255, 255));
        jLabel238.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel238.setText("Trang chủ");
        jPanel235.add(jLabel238, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel236.setBackground(new java.awt.Color(255, 51, 0));
        jPanel236.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel239.setBackground(new java.awt.Color(61, 61, 61));
        jLabel239.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel239.setForeground(new java.awt.Color(255, 255, 255));
        jLabel239.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel239.setText("Homepage");
        jPanel236.add(jLabel239, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel235.add(jPanel236, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel237.setBackground(new java.awt.Color(255, 51, 0));
        jPanel237.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel240.setBackground(new java.awt.Color(61, 61, 61));
        jLabel240.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel240.setForeground(new java.awt.Color(255, 255, 255));
        jLabel240.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel240.setText("Homepage");
        jPanel237.add(jLabel240, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel238.setBackground(new java.awt.Color(255, 51, 0));
        jPanel238.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel241.setBackground(new java.awt.Color(61, 61, 61));
        jLabel241.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel241.setForeground(new java.awt.Color(255, 255, 255));
        jLabel241.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel241.setText("Homepage");
        jPanel238.add(jLabel241, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel237.add(jPanel238, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel235.add(jPanel237, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel239.setBackground(new java.awt.Color(255, 51, 0));
        jPanel239.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel242.setBackground(new java.awt.Color(61, 61, 61));
        jLabel242.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel242.setForeground(new java.awt.Color(255, 255, 255));
        jLabel242.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel242.setText("Homepage");
        jPanel239.add(jLabel242, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel240.setBackground(new java.awt.Color(255, 51, 0));
        jPanel240.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel243.setBackground(new java.awt.Color(61, 61, 61));
        jLabel243.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel243.setForeground(new java.awt.Color(255, 255, 255));
        jLabel243.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel243.setText("Homepage");
        jPanel240.add(jLabel243, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel239.add(jPanel240, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel241.setBackground(new java.awt.Color(255, 51, 0));
        jPanel241.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel244.setBackground(new java.awt.Color(61, 61, 61));
        jLabel244.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel244.setForeground(new java.awt.Color(255, 255, 255));
        jLabel244.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel244.setText("Homepage");
        jPanel241.add(jLabel244, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel242.setBackground(new java.awt.Color(255, 51, 0));
        jPanel242.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel245.setBackground(new java.awt.Color(61, 61, 61));
        jLabel245.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel245.setForeground(new java.awt.Color(255, 255, 255));
        jLabel245.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel245.setText("Homepage");
        jPanel242.add(jLabel245, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel241.add(jPanel242, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel239.add(jPanel241, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel235.add(jPanel239, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel243.setBackground(new java.awt.Color(255, 51, 0));
        jPanel243.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel246.setBackground(new java.awt.Color(61, 61, 61));
        jLabel246.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel246.setForeground(new java.awt.Color(255, 255, 255));
        jLabel246.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel246.setText("Trang chủ");
        jPanel243.add(jLabel246, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel244.setBackground(new java.awt.Color(255, 51, 0));
        jPanel244.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel247.setBackground(new java.awt.Color(61, 61, 61));
        jLabel247.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel247.setForeground(new java.awt.Color(255, 255, 255));
        jLabel247.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel247.setText("Homepage");
        jPanel244.add(jLabel247, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel243.add(jPanel244, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel245.setBackground(new java.awt.Color(255, 51, 0));
        jPanel245.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel248.setBackground(new java.awt.Color(61, 61, 61));
        jLabel248.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel248.setForeground(new java.awt.Color(255, 255, 255));
        jLabel248.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel248.setText("Homepage");
        jPanel245.add(jLabel248, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel246.setBackground(new java.awt.Color(255, 51, 0));
        jPanel246.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel249.setBackground(new java.awt.Color(61, 61, 61));
        jLabel249.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel249.setForeground(new java.awt.Color(255, 255, 255));
        jLabel249.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel249.setText("Homepage");
        jPanel246.add(jLabel249, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel245.add(jPanel246, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel243.add(jPanel245, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel247.setBackground(new java.awt.Color(255, 51, 0));
        jPanel247.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel250.setBackground(new java.awt.Color(61, 61, 61));
        jLabel250.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel250.setForeground(new java.awt.Color(255, 255, 255));
        jLabel250.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel250.setText("Homepage");
        jPanel247.add(jLabel250, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel248.setBackground(new java.awt.Color(255, 51, 0));
        jPanel248.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel251.setBackground(new java.awt.Color(61, 61, 61));
        jLabel251.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel251.setForeground(new java.awt.Color(255, 255, 255));
        jLabel251.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel251.setText("Homepage");
        jPanel248.add(jLabel251, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel247.add(jPanel248, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel249.setBackground(new java.awt.Color(255, 51, 0));
        jPanel249.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel252.setBackground(new java.awt.Color(61, 61, 61));
        jLabel252.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel252.setForeground(new java.awt.Color(255, 255, 255));
        jLabel252.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel252.setText("Homepage");
        jPanel249.add(jLabel252, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel250.setBackground(new java.awt.Color(255, 51, 0));
        jPanel250.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel253.setBackground(new java.awt.Color(61, 61, 61));
        jLabel253.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel253.setForeground(new java.awt.Color(255, 255, 255));
        jLabel253.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel253.setText("Homepage");
        jPanel250.add(jLabel253, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel249.add(jPanel250, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel247.add(jPanel249, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel243.add(jPanel247, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel235.add(jPanel243, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 210, 40));

        jPanel251.setBackground(new java.awt.Color(255, 51, 0));
        jPanel251.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel254.setBackground(new java.awt.Color(61, 61, 61));
        jLabel254.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel254.setForeground(new java.awt.Color(255, 255, 255));
        jLabel254.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel254.setText("Trang chủ");
        jPanel251.add(jLabel254, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel252.setBackground(new java.awt.Color(255, 51, 0));
        jPanel252.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel255.setBackground(new java.awt.Color(61, 61, 61));
        jLabel255.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel255.setForeground(new java.awt.Color(255, 255, 255));
        jLabel255.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel255.setText("Homepage");
        jPanel252.add(jLabel255, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel251.add(jPanel252, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel253.setBackground(new java.awt.Color(255, 51, 0));
        jPanel253.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel256.setBackground(new java.awt.Color(61, 61, 61));
        jLabel256.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel256.setForeground(new java.awt.Color(255, 255, 255));
        jLabel256.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel256.setText("Homepage");
        jPanel253.add(jLabel256, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel254.setBackground(new java.awt.Color(255, 51, 0));
        jPanel254.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel257.setBackground(new java.awt.Color(61, 61, 61));
        jLabel257.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel257.setForeground(new java.awt.Color(255, 255, 255));
        jLabel257.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel257.setText("Homepage");
        jPanel254.add(jLabel257, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel253.add(jPanel254, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel251.add(jPanel253, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel255.setBackground(new java.awt.Color(255, 51, 0));
        jPanel255.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel258.setBackground(new java.awt.Color(61, 61, 61));
        jLabel258.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel258.setForeground(new java.awt.Color(255, 255, 255));
        jLabel258.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel258.setText("Homepage");
        jPanel255.add(jLabel258, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel256.setBackground(new java.awt.Color(255, 51, 0));
        jPanel256.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel259.setBackground(new java.awt.Color(61, 61, 61));
        jLabel259.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel259.setForeground(new java.awt.Color(255, 255, 255));
        jLabel259.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel259.setText("Homepage");
        jPanel256.add(jLabel259, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel255.add(jPanel256, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel257.setBackground(new java.awt.Color(255, 51, 0));
        jPanel257.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel260.setBackground(new java.awt.Color(61, 61, 61));
        jLabel260.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel260.setForeground(new java.awt.Color(255, 255, 255));
        jLabel260.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel260.setText("Homepage");
        jPanel257.add(jLabel260, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel258.setBackground(new java.awt.Color(255, 51, 0));
        jPanel258.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel261.setBackground(new java.awt.Color(61, 61, 61));
        jLabel261.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel261.setForeground(new java.awt.Color(255, 255, 255));
        jLabel261.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel261.setText("Homepage");
        jPanel258.add(jLabel261, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel257.add(jPanel258, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel255.add(jPanel257, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel251.add(jPanel255, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel259.setBackground(new java.awt.Color(255, 51, 0));
        jPanel259.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel262.setBackground(new java.awt.Color(61, 61, 61));
        jLabel262.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel262.setForeground(new java.awt.Color(255, 255, 255));
        jLabel262.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel262.setText("Trang chủ");
        jPanel259.add(jLabel262, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel260.setBackground(new java.awt.Color(255, 51, 0));
        jPanel260.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel263.setBackground(new java.awt.Color(61, 61, 61));
        jLabel263.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel263.setForeground(new java.awt.Color(255, 255, 255));
        jLabel263.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel263.setText("Homepage");
        jPanel260.add(jLabel263, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel259.add(jPanel260, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel261.setBackground(new java.awt.Color(255, 51, 0));
        jPanel261.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel264.setBackground(new java.awt.Color(61, 61, 61));
        jLabel264.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel264.setForeground(new java.awt.Color(255, 255, 255));
        jLabel264.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel264.setText("Homepage");
        jPanel261.add(jLabel264, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel262.setBackground(new java.awt.Color(255, 51, 0));
        jPanel262.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel265.setBackground(new java.awt.Color(61, 61, 61));
        jLabel265.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel265.setForeground(new java.awt.Color(255, 255, 255));
        jLabel265.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel265.setText("Homepage");
        jPanel262.add(jLabel265, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel261.add(jPanel262, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel259.add(jPanel261, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel263.setBackground(new java.awt.Color(255, 51, 0));
        jPanel263.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel266.setBackground(new java.awt.Color(61, 61, 61));
        jLabel266.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel266.setForeground(new java.awt.Color(255, 255, 255));
        jLabel266.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel266.setText("Homepage");
        jPanel263.add(jLabel266, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel264.setBackground(new java.awt.Color(255, 51, 0));
        jPanel264.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel267.setBackground(new java.awt.Color(61, 61, 61));
        jLabel267.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel267.setForeground(new java.awt.Color(255, 255, 255));
        jLabel267.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel267.setText("Homepage");
        jPanel264.add(jLabel267, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel263.add(jPanel264, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel265.setBackground(new java.awt.Color(255, 51, 0));
        jPanel265.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel268.setBackground(new java.awt.Color(61, 61, 61));
        jLabel268.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel268.setForeground(new java.awt.Color(255, 255, 255));
        jLabel268.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel268.setText("Homepage");
        jPanel265.add(jLabel268, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel266.setBackground(new java.awt.Color(255, 51, 0));
        jPanel266.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel269.setBackground(new java.awt.Color(61, 61, 61));
        jLabel269.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel269.setForeground(new java.awt.Color(255, 255, 255));
        jLabel269.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/home_24px.png"))); // NOI18N
        jLabel269.setText("Homepage");
        jPanel266.add(jLabel269, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel265.add(jPanel266, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel263.add(jPanel265, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel259.add(jPanel263, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 40));

        jPanel251.add(jPanel259, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 210, 40));

        jPanel235.add(jPanel251, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 210, 40));

        jPanel227.add(jPanel235, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 210, 40));

        jPanel52.add(jPanel227, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 210, 40));

        javax.swing.GroupLayout jPanel226Layout = new javax.swing.GroupLayout(jPanel226);
        jPanel226.setLayout(jPanel226Layout);
        jPanel226Layout.setHorizontalGroup(
            jPanel226Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel226Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel226Layout.setVerticalGroup(
            jPanel226Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel226Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.add(jPanel226, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 210, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 210, 580));

        jPanel68.setBackground(new java.awt.Color(255, 255, 255));
        jPanel68.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel222.setBackground(new java.awt.Color(240, 240, 240));
        jPanel222.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        jPanel222.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtsosach.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txtsosach.setForeground(new java.awt.Color(0, 0, 0));
        txtsosach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Book_Shelf_50px.png"))); // NOI18N
        jPanel222.add(txtsosach, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, -1));

        jPanel68.add(jPanel222, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 140, 70));

        jPanel223.setBackground(new java.awt.Color(240, 240, 240));
        jPanel223.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 0, 0, 0, new java.awt.Color(102, 102, 255)));
        jPanel223.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtnguoimuon.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txtnguoimuon.setForeground(new java.awt.Color(0, 0, 0));
        txtnguoimuon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_People_50px.png"))); // NOI18N
        jPanel223.add(txtnguoimuon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, -1));

        jPanel68.add(jPanel223, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 120, 70));

        jPanel224.setBackground(new java.awt.Color(240, 240, 240));
        jPanel224.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        jPanel224.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtconlai.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txtconlai.setForeground(new java.awt.Color(0, 0, 0));
        txtconlai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_List_of_Thumbnails_50px.png"))); // NOI18N
        jPanel224.add(txtconlai, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 110, -1));

        jPanel68.add(jPanel224, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, 150, 70));

        jPanel225.setBackground(new java.awt.Color(240, 240, 240));
        jPanel225.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 0, 0, 0, new java.awt.Color(102, 102, 255)));
        jPanel225.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtdangmuon.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txtdangmuon.setForeground(new java.awt.Color(0, 0, 0));
        txtdangmuon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminIcons/icons8_Sell_50px.png"))); // NOI18N
        jPanel225.add(txtdangmuon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, -1));

        jPanel68.add(jPanel225, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 120, 70));

        jLabel224.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel224.setForeground(new java.awt.Color(0, 0, 0));
        jLabel224.setText("Sách còn lại");
        jPanel68.add(jLabel224, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 140, -1));

        jLabel225.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel225.setForeground(new java.awt.Color(0, 0, 0));
        jLabel225.setText("Sách đang cho mượn");
        jPanel68.add(jLabel225, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 190, -1));

        jLabel226.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel226.setForeground(new java.awt.Color(0, 0, 0));
        jLabel226.setText("Chi tiết sách");
        jPanel68.add(jLabel226, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 180, -1));

        jLabel229.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel229.setForeground(new java.awt.Color(0, 0, 0));
        jLabel229.setText("Người Mượn");
        jPanel68.add(jLabel229, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 140, -1));

        jLabel231.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel231.setForeground(new java.awt.Color(0, 0, 0));
        jLabel231.setText("Số Sách");
        jPanel68.add(jLabel231, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 90, -1));

        jLabel232.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel232.setForeground(new java.awt.Color(0, 0, 0));
        jLabel232.setText("Chi tiết người mượn");
        jPanel68.add(jLabel232, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 180, -1));

        chart.setBackground(new java.awt.Color(240, 240, 240));
        chart.setLayout(new java.awt.BorderLayout());
        jPanel68.add(chart, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 330, 420));

        tblnguoimuon.setBackground(new java.awt.Color(240, 240, 240));
        tblnguoimuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Người Mượn", "Tên Người Mượn", "Email"
            }
        ));
        jScrollPane3.setViewportView(tblnguoimuon);

        jPanel68.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 440, 170));

        tblsach.setBackground(new java.awt.Color(240, 240, 240));
        tblsach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sách", "Tên Sách", "Thể Loại", "Số Lượng"
            }
        ));
        jScrollPane4.setViewportView(tblsach);
        if (tblsach.getColumnModel().getColumnCount() > 0) {
            tblsach.getColumnModel().getColumn(3).setHeaderValue("Số Lượng");
        }

        jPanel68.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 440, 170));

        getContentPane().add(jPanel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 790, 580));

        setSize(new java.awt.Dimension(1008, 651));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel69MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel69MouseClicked
        this.setVisible(false);
        Login lg = new Login();
        lg.setVisible(true);
    }//GEN-LAST:event_jPanel69MouseClicked

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
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel187;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel195;
    private javax.swing.JLabel jLabel196;
    private javax.swing.JLabel jLabel197;
    private javax.swing.JLabel jLabel198;
    private javax.swing.JLabel jLabel199;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel200;
    private javax.swing.JLabel jLabel201;
    private javax.swing.JLabel jLabel202;
    private javax.swing.JLabel jLabel203;
    private javax.swing.JLabel jLabel204;
    private javax.swing.JLabel jLabel205;
    private javax.swing.JLabel jLabel206;
    private javax.swing.JLabel jLabel207;
    private javax.swing.JLabel jLabel208;
    private javax.swing.JLabel jLabel209;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel210;
    private javax.swing.JLabel jLabel211;
    private javax.swing.JLabel jLabel212;
    private javax.swing.JLabel jLabel213;
    private javax.swing.JLabel jLabel214;
    private javax.swing.JLabel jLabel215;
    private javax.swing.JLabel jLabel216;
    private javax.swing.JLabel jLabel217;
    private javax.swing.JLabel jLabel218;
    private javax.swing.JLabel jLabel219;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel220;
    private javax.swing.JLabel jLabel221;
    private javax.swing.JLabel jLabel222;
    private javax.swing.JLabel jLabel223;
    private javax.swing.JLabel jLabel224;
    private javax.swing.JLabel jLabel225;
    private javax.swing.JLabel jLabel226;
    private javax.swing.JLabel jLabel227;
    private javax.swing.JLabel jLabel228;
    private javax.swing.JLabel jLabel229;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel230;
    private javax.swing.JLabel jLabel231;
    private javax.swing.JLabel jLabel232;
    private javax.swing.JLabel jLabel233;
    private javax.swing.JLabel jLabel234;
    private javax.swing.JLabel jLabel235;
    private javax.swing.JLabel jLabel236;
    private javax.swing.JLabel jLabel237;
    private javax.swing.JLabel jLabel238;
    private javax.swing.JLabel jLabel239;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel240;
    private javax.swing.JLabel jLabel241;
    private javax.swing.JLabel jLabel242;
    private javax.swing.JLabel jLabel243;
    private javax.swing.JLabel jLabel244;
    private javax.swing.JLabel jLabel245;
    private javax.swing.JLabel jLabel246;
    private javax.swing.JLabel jLabel247;
    private javax.swing.JLabel jLabel248;
    private javax.swing.JLabel jLabel249;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel250;
    private javax.swing.JLabel jLabel251;
    private javax.swing.JLabel jLabel252;
    private javax.swing.JLabel jLabel253;
    private javax.swing.JLabel jLabel254;
    private javax.swing.JLabel jLabel255;
    private javax.swing.JLabel jLabel256;
    private javax.swing.JLabel jLabel257;
    private javax.swing.JLabel jLabel258;
    private javax.swing.JLabel jLabel259;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel260;
    private javax.swing.JLabel jLabel261;
    private javax.swing.JLabel jLabel262;
    private javax.swing.JLabel jLabel263;
    private javax.swing.JLabel jLabel264;
    private javax.swing.JLabel jLabel265;
    private javax.swing.JLabel jLabel266;
    private javax.swing.JLabel jLabel267;
    private javax.swing.JLabel jLabel268;
    private javax.swing.JLabel jLabel269;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
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
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel100;
    private javax.swing.JPanel jPanel101;
    private javax.swing.JPanel jPanel102;
    private javax.swing.JPanel jPanel103;
    private javax.swing.JPanel jPanel104;
    private javax.swing.JPanel jPanel105;
    private javax.swing.JPanel jPanel106;
    private javax.swing.JPanel jPanel107;
    private javax.swing.JPanel jPanel108;
    private javax.swing.JPanel jPanel109;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel110;
    private javax.swing.JPanel jPanel111;
    private javax.swing.JPanel jPanel112;
    private javax.swing.JPanel jPanel113;
    private javax.swing.JPanel jPanel114;
    private javax.swing.JPanel jPanel115;
    private javax.swing.JPanel jPanel116;
    private javax.swing.JPanel jPanel117;
    private javax.swing.JPanel jPanel118;
    private javax.swing.JPanel jPanel119;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel120;
    private javax.swing.JPanel jPanel121;
    private javax.swing.JPanel jPanel122;
    private javax.swing.JPanel jPanel123;
    private javax.swing.JPanel jPanel124;
    private javax.swing.JPanel jPanel125;
    private javax.swing.JPanel jPanel126;
    private javax.swing.JPanel jPanel127;
    private javax.swing.JPanel jPanel128;
    private javax.swing.JPanel jPanel129;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel130;
    private javax.swing.JPanel jPanel131;
    private javax.swing.JPanel jPanel132;
    private javax.swing.JPanel jPanel133;
    private javax.swing.JPanel jPanel134;
    private javax.swing.JPanel jPanel135;
    private javax.swing.JPanel jPanel136;
    private javax.swing.JPanel jPanel137;
    private javax.swing.JPanel jPanel138;
    private javax.swing.JPanel jPanel139;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel140;
    private javax.swing.JPanel jPanel141;
    private javax.swing.JPanel jPanel142;
    private javax.swing.JPanel jPanel143;
    private javax.swing.JPanel jPanel144;
    private javax.swing.JPanel jPanel145;
    private javax.swing.JPanel jPanel146;
    private javax.swing.JPanel jPanel147;
    private javax.swing.JPanel jPanel148;
    private javax.swing.JPanel jPanel149;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel150;
    private javax.swing.JPanel jPanel151;
    private javax.swing.JPanel jPanel152;
    private javax.swing.JPanel jPanel153;
    private javax.swing.JPanel jPanel154;
    private javax.swing.JPanel jPanel155;
    private javax.swing.JPanel jPanel156;
    private javax.swing.JPanel jPanel157;
    private javax.swing.JPanel jPanel158;
    private javax.swing.JPanel jPanel159;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel160;
    private javax.swing.JPanel jPanel161;
    private javax.swing.JPanel jPanel162;
    private javax.swing.JPanel jPanel163;
    private javax.swing.JPanel jPanel164;
    private javax.swing.JPanel jPanel165;
    private javax.swing.JPanel jPanel166;
    private javax.swing.JPanel jPanel167;
    private javax.swing.JPanel jPanel168;
    private javax.swing.JPanel jPanel169;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel170;
    private javax.swing.JPanel jPanel171;
    private javax.swing.JPanel jPanel172;
    private javax.swing.JPanel jPanel173;
    private javax.swing.JPanel jPanel174;
    private javax.swing.JPanel jPanel175;
    private javax.swing.JPanel jPanel176;
    private javax.swing.JPanel jPanel177;
    private javax.swing.JPanel jPanel178;
    private javax.swing.JPanel jPanel179;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel180;
    private javax.swing.JPanel jPanel181;
    private javax.swing.JPanel jPanel182;
    private javax.swing.JPanel jPanel183;
    private javax.swing.JPanel jPanel184;
    private javax.swing.JPanel jPanel185;
    private javax.swing.JPanel jPanel186;
    private javax.swing.JPanel jPanel187;
    private javax.swing.JPanel jPanel188;
    private javax.swing.JPanel jPanel189;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel190;
    private javax.swing.JPanel jPanel191;
    private javax.swing.JPanel jPanel192;
    private javax.swing.JPanel jPanel193;
    private javax.swing.JPanel jPanel194;
    private javax.swing.JPanel jPanel195;
    private javax.swing.JPanel jPanel196;
    private javax.swing.JPanel jPanel197;
    private javax.swing.JPanel jPanel198;
    private javax.swing.JPanel jPanel199;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel200;
    private javax.swing.JPanel jPanel201;
    private javax.swing.JPanel jPanel202;
    private javax.swing.JPanel jPanel203;
    private javax.swing.JPanel jPanel204;
    private javax.swing.JPanel jPanel205;
    private javax.swing.JPanel jPanel206;
    private javax.swing.JPanel jPanel207;
    private javax.swing.JPanel jPanel208;
    private javax.swing.JPanel jPanel209;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel210;
    private javax.swing.JPanel jPanel211;
    private javax.swing.JPanel jPanel212;
    private javax.swing.JPanel jPanel213;
    private javax.swing.JPanel jPanel214;
    private javax.swing.JPanel jPanel215;
    private javax.swing.JPanel jPanel216;
    private javax.swing.JPanel jPanel217;
    private javax.swing.JPanel jPanel218;
    private javax.swing.JPanel jPanel219;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel220;
    private javax.swing.JPanel jPanel221;
    private javax.swing.JPanel jPanel222;
    private javax.swing.JPanel jPanel223;
    private javax.swing.JPanel jPanel224;
    private javax.swing.JPanel jPanel225;
    private javax.swing.JPanel jPanel226;
    private javax.swing.JPanel jPanel227;
    private javax.swing.JPanel jPanel228;
    private javax.swing.JPanel jPanel229;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel230;
    private javax.swing.JPanel jPanel231;
    private javax.swing.JPanel jPanel232;
    private javax.swing.JPanel jPanel233;
    private javax.swing.JPanel jPanel234;
    private javax.swing.JPanel jPanel235;
    private javax.swing.JPanel jPanel236;
    private javax.swing.JPanel jPanel237;
    private javax.swing.JPanel jPanel238;
    private javax.swing.JPanel jPanel239;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel240;
    private javax.swing.JPanel jPanel241;
    private javax.swing.JPanel jPanel242;
    private javax.swing.JPanel jPanel243;
    private javax.swing.JPanel jPanel244;
    private javax.swing.JPanel jPanel245;
    private javax.swing.JPanel jPanel246;
    private javax.swing.JPanel jPanel247;
    private javax.swing.JPanel jPanel248;
    private javax.swing.JPanel jPanel249;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel250;
    private javax.swing.JPanel jPanel251;
    private javax.swing.JPanel jPanel252;
    private javax.swing.JPanel jPanel253;
    private javax.swing.JPanel jPanel254;
    private javax.swing.JPanel jPanel255;
    private javax.swing.JPanel jPanel256;
    private javax.swing.JPanel jPanel257;
    private javax.swing.JPanel jPanel258;
    private javax.swing.JPanel jPanel259;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel260;
    private javax.swing.JPanel jPanel261;
    private javax.swing.JPanel jPanel262;
    private javax.swing.JPanel jPanel263;
    private javax.swing.JPanel jPanel264;
    private javax.swing.JPanel jPanel265;
    private javax.swing.JPanel jPanel266;
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
    private javax.swing.JPanel jPanel96;
    private javax.swing.JPanel jPanel97;
    private javax.swing.JPanel jPanel98;
    private javax.swing.JPanel jPanel99;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblnguoimuon;
    private javax.swing.JTable tblsach;
    private javax.swing.JLabel txtconlai;
    private javax.swing.JLabel txtdangmuon;
    private javax.swing.JLabel txtnguoimuon;
    private javax.swing.JLabel txtsosach;
    // End of variables declaration//GEN-END:variables
}
