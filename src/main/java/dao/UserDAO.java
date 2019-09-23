package dao;

import bean.User;

import java.sql.*;

public class UserDAO {
    public UserDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public User getUser(String name, String password) {
        User result=null;
        Connection c=null;
        Statement s=null;
        try {
            c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8", "root", "admin");
        //    String sql = "SELECT * FROM USER WHERE NAME = '" + name + "' AND PASSWORD = '" + password + "'";
//            s = c.createStatement();
//            ResultSet rs = s.executeQuery(sql);

            String sql="SELECT * FROM USER WHERE NAME = ? AND PASSWORD = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,password);
            ResultSet rs =ps.executeQuery();

            if (rs.next()) {
                result = new User();
                result.setId(rs.getInt(1));
                result.setName(rs.getString(2));
                result.setPassword(rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (s!=null) {
                try {
                    s.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(c!=null){
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

}
