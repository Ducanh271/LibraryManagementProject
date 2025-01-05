/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package common.view;

import ConnectDatabase.DatabaseConnection;
import com.sun.source.tree.BreakTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.*; // Import tất cả các thành phần Swing
import java.sql.*; // Import các thư viện liên quan đến SQL
import javax.swing.JOptionPane;



public class ManageBooks extends javax.swing.JFrame {

    /**
     * Creates new form ManageBooks
     */
    
    String tenSach, theLoai, maSach, tenTacGia;
    int  maNhaPhatHanh;
    DefaultTableModel model;
            
    public ManageBooks() {
        initComponents();
        setBookDetailsToTable();
        loadPublishersToComboBox();
        ThemNhaPH.setVisible(false);
        
    }
    
    //dien thong tin sach vao bang
    public final void setBookDetailsToTable(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quan_ly_thu_vien", "root", "");
            Statement  st = con.createStatement();
             String sql = "SELECT sach.maSach, sach.tenSach, sach.theLoai, sach.soLuong, tacgia.tenTacGia FROM sach "
                + "JOIN chitiettacgia ON sach.maSach = chitiettacgia.maSach "
                + "JOIN tacgia ON chitiettacgia.maTacGia = tacgia.maTacGia  ";  
            ResultSet rs =  st.executeQuery(sql);
            
            
            while(rs.next()){
                String BookId = rs.getString("maSach");
                String BookName = rs.getString("tenSach");
                String Type = rs.getString("theLoai");
                String AuthrName = rs.getString("tenTacGia");
                int Quantity = rs.getInt("soLuong");
                
                
                Object[] obj = {BookId,BookName,Type,AuthrName,Quantity};
                model = (DefaultTableModel) tbl_BookDetail.getModel();
                model.addRow(obj);
            }
                rs.close();
                st.close();
                con.close();
        } catch (Exception e) {
            System.out.println("Failed Connection");
            
        }
    }
    
    //cap nhat so luong sach
        public void updateBookQuantities() {
        String sql = "UPDATE sach " +
                 "SET soLuong = (" +
                 "    SELECT COUNT(*) " +
                 "    FROM bansaosach " +
                 "    WHERE bansaosach.maSach = sach.maSach" +
                 ")";
                     
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) { 
              pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //phieu dien them tac gia 
    private JDialog addDialog; 
     public void openAddBookDialog() {
        addDialog = new JDialog(this, "Thêm NPH", true);
        addDialog.setSize(400, 300);
        addDialog.setLocationRelativeTo(this);
        
        
        
        addDialog.add(ThemNhaPH);
        ThemNhaPH.setVisible(true);
        addDialog.setVisible(true);
    }
     
     private void savePubToDatabase(int PubID, String PubName) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quan_ly_thu_vien", "root", "");
            String sql = "INSERT INTO nhaphathanh (maNhaPhatHanh, tenNhaPhatHanh) VALUES (?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, PubID);
            pst.setString(2, PubName);
            int rowCount = pst.executeUpdate();

            if (rowCount > 0) {
                JOptionPane.showMessageDialog(null, "NPH đã được thêm thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Thêm NPH thất bại!");
            }

            pst.close();
            con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Không thể kết nối cơ sở dữ liệu!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
//
    private void loadPublishersToComboBox() {
        try {
            // Kết nối đến cơ sở dữ liệu
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/quan_ly_thu_vien", "root", ""
            );

            // Truy vấn dữ liệu nhà phát hành
            String sql = "SELECT * FROM nhaphathanh";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            // Xóa các mục cũ trong comboBox
            jComboBox1.removeAllItems();

            // Thêm dữ liệu vào JComboBox
            while (rs.next()) {
                String publisherName = rs.getString("tenNhaPhatHanh");
                String publisherId = rs.getString("maNhaPhatHanh");
                String PublishFull = publisherId + " - "+publisherName;
                
                jComboBox1.addItem(PublishFull);
            }
        
            // Đóng kết nối
            rs.close();
            pst.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Không thể kết nối cơ sở dữ liệu!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    //kiem tra tac gia
    public int getOrAddAuthor(String tenTacGia) {
    int maTacGia = -1; // Mặc định là -1 nếu không tìm thấy
    try {
        Connection con = DatabaseConnection.getConnection();

        // Kiểm tra xem tác giả đã tồn tại chưa
        String checkSql = "SELECT maTacGia FROM tacgia WHERE tenTacGia = ?";
        PreparedStatement checkPst = con.prepareStatement(checkSql);
        checkPst.setString(1, tenTacGia);
        ResultSet rs = checkPst.executeQuery();

        if (rs.next()) {
            // Tác giả đã tồn tại, lấy mã tác giả
            maTacGia = rs.getInt("maTacGia");
        } else {
            // Tác giả chưa tồn tại, thêm mới
            String insertSql = "INSERT INTO tacgia (tenTacGia) VALUES (?)";
            PreparedStatement insertPst = con.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
            insertPst.setString(1, tenTacGia);
            int rowAffected = insertPst.executeUpdate();

            if (rowAffected > 0) {
                maTacGia = rs.getInt("maTacGia");
            }
            insertPst.close();
        }
        rs.close();
        checkPst.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return maTacGia;
    }

    //kiem tra ma sach
    
    private boolean isBookIdExists(String maSach) {
    boolean exists = false;
    try {
        // Kết nối cơ sở dữ liệu
        Connection con = DatabaseConnection.getConnection();
        String sql = "SELECT COUNT(*) FROM sach WHERE maSach = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, maSach);

        // Thực thi câu lệnh
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            int count = rs.getInt(1);
            exists = (count > 0); // Nếu count > 0 thì mã sách đã tồn tại
        }

        // Đóng kết nối
        rs.close();
        pst.close();
        con.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return exists;
    }

    
    //them sach vao bang
    public boolean addBook(){
        boolean isAdded = false;
        maSach = txt_bookid.getText();
        tenSach = txt_bookName.getText();
        theLoai = txt_type.getText();
        maNhaPhatHanh = Integer.parseInt(txt_IDpublish.getText());
        tenTacGia = txt_author.getText();
        getOrAddAuthor(tenTacGia);
        try {
              // Lấy hoặc thêm mới tác giả
        int maTacGia = getOrAddAuthor(tenTacGia);
         if (isBookIdExists(maSach)) {
            JOptionPane.showMessageDialog(null, "Mã sách đã tồn tại! Vui lòng nhập lại.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (maTacGia == -1) {
            JOptionPane.showMessageDialog(null, "Không thể thêm sách vì lỗi khi xử lý tác giả!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
            Connection con = DatabaseConnection.getConnection();
            String sql = "insert into sach (maSach, tenSach, theLoai, maNhaPhatHanh, soLuong) values(?,?,?,?,?)";
            String sql01 = "insert into chitiettacgia (maSach, maTacGia) values(?,?)";
            
            
            PreparedStatement pst = con.prepareStatement(sql);
            PreparedStatement pst01 = con.prepareStatement(sql01);
            pst.setString(1, maSach);
            pst.setString(2, tenSach);
            pst.setString(3, theLoai);
            pst.setInt(4, maNhaPhatHanh);
            pst.setInt(5, 0);
            pst01.setString(1, maSach);
            pst01.setInt(2,maTacGia);
            
            
            int rowCount = pst.executeUpdate();
            int rowCount01 = pst01.executeUpdate();
            if (rowCount > 0 && rowCount01 > 0) {
                isAdded = true;
            } else{
                isAdded = false;
            }
        } catch (Exception e) {
            System.out.println("Failed Connection");
            e.printStackTrace();      
        }
        
        return isAdded;
    }

    
    //Sửa sách 
    public boolean updateBook(){
         boolean isUpdated = false;
        maSach = txt_bookid.getText();
        tenSach = txt_bookName.getText();
        theLoai = txt_type.getText();
        tenTacGia = txt_author.getText();
        
        try {
            Connection con = DatabaseConnection.getConnection();
            String sql = "update sach set tenSach = ?, theLoai = ? where maSach = ?";
            String sql01 = "UPDATE tacgia JOIN chitiettacgia ON tacgia.maTacGia = chitiettacgia.maTacGia SET tacgia.tenTacGia = ? WHERE chitiettacgia.maSach = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            PreparedStatement pst01 = con.prepareStatement(sql01);
            pst.setString(1, tenSach);
            pst.setString(2, theLoai);
            pst.setString(3, maSach);
            pst01.setString(1, tenTacGia);
            pst01.setString(2, maSach);
            
            int rowCount = pst.executeUpdate();
            int rowCount01 = pst01.executeUpdate();
            if (rowCount > 0 || rowCount01 > 0) {
                isUpdated = true;
            } else {
                isUpdated = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed Connection");
        }
        return isUpdated;
    }
    
    //Xoá sách
    public boolean deletebook(){
        boolean isDeleted = false;
        maSach = txt_bookid.getText();
        tenTacGia = txt_author.getText();
        
        JOptionPane.showMessageDialog(this, "Bạn có chắc muốn xoá?");
        try {
            Connection con = DatabaseConnection.getConnection();
            String sql = "delete from sach where maSach = ?";
            String sql01 = "delete from chitiettacgia where maSach = ?";
            String sql02 = "delete from tacgia where tenTacGia = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            PreparedStatement pst01 = con.prepareStatement(sql01);
            PreparedStatement pst02 = con.prepareStatement(sql02);
            pst.setString(1, maSach);
            pst01.setString(1, maSach);
            pst02.setString(1, tenTacGia);
            
            int rowCount = pst.executeUpdate();
            int rowCount2 = pst02.executeUpdate();
            isDeleted = rowCount > 0 || rowCount2 > 0 ;
        } catch (SQLException e) {
        }
        return isDeleted;
    }
    
    //Tìm kiếm sách theo Thể loại và Tên
    public void findbook() {
        
        //bien xac nhan
        boolean hasData = false;
        
    // Lấy giá trị từ các trường nhập liệu
    tenSach = txt_bookName.getText();
    theLoai = txt_type.getText();
    tenTacGia = txt_author.getText();
    

    // Kết nối cơ sở dữ liệu và thực hiện truy vấn
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quan_ly_thu_vien", "root", "")) {
        
        
        String sql = "SELECT sach.maSach, sach.tenSach, sach.theLoai, sach.soLuong, tacgia.tenTacGia FROM sach "
                + "JOIN chitiettacgia ON sach.maSach = chitiettacgia.maSach "
                + "JOIN tacgia ON chitiettacgia.maTacGia = tacgia.maTacGia  "
                + "WHERE sach.tenSach = ? OR sach.theLoai = ? OR tacgia.tenTacGia = ?";        
        PreparedStatement pst = con.prepareStatement(sql);
       
        
        
        pst.setString(1, tenSach);
        pst.setString(2, theLoai);
        pst.setString(3, tenTacGia);
        
       
        try (ResultSet rs = pst.executeQuery()) {
            
    while(rs.next())  {

        String BookId = rs.getString("maSach");
        String BookName = rs.getString("tenSach");
        String Type = rs.getString("theLoai");
        String AuthrName = rs.getString("tenTacGia");
        int Quantity = rs.getInt("soLuong");


        Object[] obj = {BookId,BookName,Type,AuthrName,Quantity};
        model = (DefaultTableModel) tbl_BookDetail.getModel();
        model.addRow(obj);
        hasData = true;
    } 
    if (!hasData) {
        setBookDetailsToTable();
        JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }
        }
                con.close();
        } catch (Exception e) {
            System.out.println("Failed Connection");
        }
}


    //xoa bang tao trc do
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel) tbl_BookDetail.getModel();
        model.setRowCount(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar5 = new javax.swing.JMenuBar();
        jMenu9 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_bookName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txt_author = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txt_bookid = new javax.swing.JTextField();
        txt_IDpublish = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        txt_type = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_BookDetail = new rojeru_san.complementos.RSTableMetro();
        ThemNhaPH = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        txt_publishadd = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_IDpublishadd = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("File");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar3.add(jMenu6);

        jMenu7.setText("File");
        jMenuBar4.add(jMenu7);

        jMenu8.setText("Edit");
        jMenuBar4.add(jMenu8);

        jMenuItem1.setText("jMenuItem1");

        jMenu9.setText("File");
        jMenuBar5.add(jMenu9);

        jMenu10.setText("Edit");
        jMenuBar5.add(jMenu10);

        jMenu11.setText("jMenu11");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, -1, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));
        jPanel3.setToolTipText("");
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));

        jPanel6.setBackground(new java.awt.Color(255, 51, 51));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel7.setText("Quay lại");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(0, 8, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 50));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jLabel2.setText(" Mã Sách");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 190, 40));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jLabel3.setText(" Tên Sách");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 190, 40));

        txt_bookName.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        txt_bookName.setDragEnabled(true);
        txt_bookName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookNameActionPerformed(evt);
            }
        });
        jPanel3.add(txt_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 380, 40));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jLabel4.setText(" Thể loại");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 190, 40));

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Thêm");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 730, 110, 40));

        jButton3.setBackground(new java.awt.Color(255, 51, 51));
        jButton3.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Sửa");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 730, 110, 40));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jLabel8.setText("Tác Giả");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 190, 40));

        txt_author.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        txt_author.setDragEnabled(true);
        txt_author.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_authorActionPerformed(evt);
            }
        });
        jPanel3.add(txt_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 380, 40));

        jButton9.setBackground(new java.awt.Color(255, 51, 51));
        jButton9.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Xoá");
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 730, 110, 40));

        jButton4.setBackground(new java.awt.Color(255, 51, 51));
        jButton4.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Tìm kiếm");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 730, 110, 40));

        txt_bookid.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        txt_bookid.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_bookid.setDragEnabled(true);
        txt_bookid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookidActionPerformed(evt);
            }
        });
        jPanel3.add(txt_bookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 380, 40));

        txt_IDpublish.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        txt_IDpublish.setDragEnabled(true);
        txt_IDpublish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_IDpublishActionPerformed(evt);
            }
        });
        jPanel3.add(txt_IDpublish, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 550, 380, 40));

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jLabel10.setText("Nhà phát hành");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 610, 220, 40));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 660, 380, 40));

        jButton6.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jButton6.setText("+");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 660, 40, 30));

        txt_type.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        txt_type.setDragEnabled(true);
        txt_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_typeActionPerformed(evt);
            }
        });
        jPanel3.add(txt_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 380, 40));

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jLabel11.setText("Mã Nhà phát hành");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 500, 190, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 830));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(102, 102, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 35)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("X");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel10.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 40, 30));

        jPanel5.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 0, 90, 50));
        jPanel5.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, -1, -1));

        jPanel7.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 550, 5));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Verdana", 1, 35)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 51));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel6.setText("  Quản lí Sách");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 380, 60));

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Reset Bảng");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 670, -1, 40));

        tbl_BookDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sách", "Tên Sách", "Thể loại", "Tác giả", "Số lượng"
            }
        ));
        tbl_BookDetail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tbl_BookDetail.setRowHeight(40);
        jScrollPane2.setViewportView(tbl_BookDetail);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 1000, 250));

        ThemNhaPH.setBackground(new java.awt.Color(51, 51, 255));
        ThemNhaPH.setPreferredSize(new java.awt.Dimension(600, 240));
        ThemNhaPH.setLayout(null);

        jButton7.setBackground(new java.awt.Color(255, 51, 51));
        jButton7.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Lưu");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        ThemNhaPH.add(jButton7);
        jButton7.setBounds(260, 200, 72, 29);

        txt_publishadd.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        txt_publishadd.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_publishadd.setDragEnabled(true);
        txt_publishadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_publishaddActionPerformed(evt);
            }
        });
        ThemNhaPH.add(txt_publishadd);
        txt_publishadd.setBounds(40, 150, 310, 40);

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jLabel9.setText("Tên NPH");
        ThemNhaPH.add(jLabel9);
        jLabel9.setBounds(40, 110, 190, 40);

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jLabel13.setText("Mã NPH");
        ThemNhaPH.add(jLabel13);
        jLabel13.setBounds(40, 20, 190, 40);

        txt_IDpublishadd.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        txt_IDpublishadd.setDragEnabled(true);
        txt_IDpublishadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_IDpublishaddActionPerformed(evt);
            }
        });
        ThemNhaPH.add(txt_IDpublishadd);
        txt_IDpublishadd.setBounds(40, 60, 310, 40);

        jPanel5.add(ThemNhaPH, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, 400, 240));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jLabel12.setText("Mã Nhà phát hành");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(-110, 400, 292, 40));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 1110, 830));

        setSize(new java.awt.Dimension(1724, 824));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_bookNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookNameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        clearTable();
        updateBookQuantities();
        setBookDetailsToTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (addBook() == true) {
            
            JOptionPane.showMessageDialog(this, "Thêm sách thành công");
            clearTable();
            setBookDetailsToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm sách thất bại\nVui lòng thực hiện lại");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (updateBook() == true) {
            
            JOptionPane.showMessageDialog(this, "Sửa sách thành công");
            clearTable();
            setBookDetailsToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Sửa sách thất bại\nVui lòng thực hiện lại");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        Homepage home = new Homepage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txt_authorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_authorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_authorActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if (deletebook() == true) {
            
            JOptionPane.showMessageDialog(this, "Xoá sách thành công");
            clearTable();
            setBookDetailsToTable();
        } else{
            JOptionPane.showMessageDialog(this, "Xoá sách thất bại\nVui lòng thực hiện lại");
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
            clearTable();
            findbook();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txt_bookidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookidActionPerformed

    private void txt_IDpublishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_IDpublishActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_IDpublishActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

         loadPublishersToComboBox();
          
       
//                // Lấy giá trị được chọn
//                String selectedItem = (String) jComboBox1.getSelectedItem();
//                JOptionPane.showMessageDialog(null, "Bạn đã chọn: " + selectedItem);
            
    
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
            openAddBookDialog();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // Xử lý sự kiện khi nhấn nút Lưu
        
                int PubID = 0;
                PubID = Integer.parseInt(txt_IDpublishadd.getText());
   
                String PubName = txt_publishadd.getText();

                if (PubID > 0 && !PubName.isEmpty()) {
                    savePubToDatabase(PubID, PubName);
                    addDialog.dispose();  // Gọi dispose() để đóng addDialog
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void txt_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_typeActionPerformed

    private void txt_publishaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_publishaddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_publishaddActionPerformed

    private void txt_IDpublishaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_IDpublishaddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_IDpublishaddActionPerformed

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
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageBooks().setVisible(true);
            }
             
        
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ThemNhaPH;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuBar jMenuBar5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private rojeru_san.complementos.RSTableMetro tbl_BookDetail;
    private javax.swing.JTextField txt_IDpublish;
    private javax.swing.JTextField txt_IDpublishadd;
    private javax.swing.JTextField txt_author;
    private javax.swing.JTextField txt_bookName;
    private javax.swing.JTextField txt_bookid;
    private javax.swing.JTextField txt_publishadd;
    private javax.swing.JTextField txt_type;
    // End of variables declaration//GEN-END:variables
}
