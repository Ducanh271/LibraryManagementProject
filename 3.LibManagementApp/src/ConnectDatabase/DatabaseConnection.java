/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnectDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Duc Anh
 */
public class DatabaseConnection {
   
    private static final String URL = "jdbc:mysql://localhost:3306/quan_ly_thu_vien";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Mật khẩu mặc định là rỗng trong XAMPP

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Kết nối thất bại: " + e.getMessage());
            return null;
        }
    }

}
