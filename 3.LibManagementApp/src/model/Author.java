/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// Có hàm lấy tên tác giả từ mà tác giả và hàm thêm mới tác giả vào hệ thống
package model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Duc Anh
 */
public class Author extends DataAccessHelper {
    private int idAuthor;
    private String nameAuthor;
    private final String GET_LIST_AUTHOR = "SELECT * FROM quan_ly_thu_vien.tacgia";
    private final String GET_MAX_ID = "SELECT Max(maTacGia) FROM quan_ly_thu_vien.tacgia";
    private final String ADD_AUTHOR = "INSERT INTO quan_ly_thu_vien.tacgia VALUES (?,?)";

    public Author() {
    }

    public Author(int idAuthor, String nameAuthor) {
        this.idAuthor = idAuthor;
        this.nameAuthor = nameAuthor;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }
      /**
     * Hàm này lấy ra tên tác giả từ mã tác giả
     * @param idAuthor mã tác giả bạn muốn lấy tên
     * @return tên tác giả
     * @throws ClassNotFoundException
     * @throws SQLException
     */
   public String getNameAuthorByIdAuthor(int idAuthor) throws ClassNotFoundException, SQLException {
        String nameAuthor = "";
        connectDatabase();
        PreparedStatement st = conn.prepareStatement("SELECT * FROM quan_ly_thu_vien.tacgia where maTacGia =?");
        st.setInt(1, idAuthor);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            nameAuthor = rs.getString("tenTacGia");
        }
        closeDatabase();
        return nameAuthor;
    }
   /**
     * Hàm này lấy ra danh sách các tác giả có trong hệ thống.
     * @return danh sách các tác giả có trong hệ thống
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ArrayList<Author> getListAuthor() throws ClassNotFoundException, SQLException{
        ArrayList<Author> authors = new ArrayList<>();
        connectDatabase();
        PreparedStatement ps = conn.prepareStatement(GET_LIST_AUTHOR);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            int idAuthor = rs.getInt("maTacGia");
            String nameAuthor = rs.getString("tenTacGia");
            authors.add(new Author(idAuthor, nameAuthor));
        }
        closeDatabase();
        return authors;
    }
 /**
     * Hàm này lấy ra mã lớn nhất của các tác giả có trong hệ thống.
     * @return mã lớn nhất của tác giả có trong hệ thống
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public int getMaxIdAuthor() throws ClassNotFoundException, SQLException {
        int maxId = 0;
        connectDatabase();
        PreparedStatement ps = conn.prepareStatement(GET_MAX_ID);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            maxId = rs.getInt(1);
        }
        closeDatabase();
        return maxId;
    }

      /**
     * Hàm này thêm mới một tác giả vào trong hệ thống.
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void addAuthor() throws ClassNotFoundException, SQLException {
        connectDatabase();
        PreparedStatement ps = conn.prepareStatement(ADD_AUTHOR);
        ps.setInt(1, idAuthor);
        ps.setString(2, nameAuthor);
        ps.executeUpdate();
        closeDatabase();
    }


}
