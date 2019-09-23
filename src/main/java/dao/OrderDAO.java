package dao;

import bean.Order;

import java.sql.*;

public class OrderDAO {
    public OrderDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insert(Order o) {
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8", "root", "admin");
            String sql = "insert into order_ values(null,?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, o.getUser().getId());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                o.setId(id);
            }
            ps.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
