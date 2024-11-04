/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author Duc Anh
 */
public class DataAccessHelper {
    public static Connection conn = null;
    private static final String URL = "jdbc:mysql://localhost:3306/quan_ly_thu_vien";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Mật khẩu mặc định là rỗng trong XAMPP
     public void connectDatabase() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
    }
    public void closeDatabase() throws SQLException {
        conn.close();
    }
}
