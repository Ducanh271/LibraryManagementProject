/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToXamp {
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Kết nối tới MySQL
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Kết nối thành công tới database!");
        } catch (SQLException e) {
            System.out.println("Kết nối thất bại: " + e.getMessage());
        }
        return connection;
    }

    public static void main(String[] args) {
        // Kiểm tra kết nối
        Connection conn = getConnection();
        if (conn != null) {
            try {
                conn.close(); // Đóng kết nối sau khi kiểm tra
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
