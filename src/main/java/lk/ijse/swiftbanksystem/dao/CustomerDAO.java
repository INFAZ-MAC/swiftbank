
package lk.ijse.swiftbanksystem.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.swiftbanksystem.db.DBConnection;
import lk.ijse.swiftbanksystem.model.Customer;

public class CustomerDAO {

    private Connection con() throws SQLException {
        return DBConnection.getInstance().getConnection();
    }

    private Customer map(ResultSet rs) throws SQLException {
        Date d = rs.getDate("dob");
        return new Customer(
                rs.getInt("customer_id"),
                rs.getString("full_name"),
                rs.getString("nic"),
                d == null ? null : d.toLocalDate(),
                rs.getString("phone"),
                rs.getString("email"),
                rs.getString("address"));
    }

    public int save(Customer c) throws SQLException {
        String sql = "INSERT INTO customer (full_name, nic, dob, phone, email, address) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement ps = con().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, c.getFullName());
            ps.setString(2, c.getNic());
            ps.setDate(3, c.getDob() == null ? null : Date.valueOf(c.getDob()));
            ps.setString(4, c.getPhone());
            ps.setString(5, c.getEmail());
            ps.setString(6, c.getAddress());
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                return keys.next() ? keys.getInt(1) : 0;
            }
        }
    }

    public boolean update(Customer c) throws SQLException {
        String sql = "UPDATE customer SET full_name=?, nic=?, dob=?, phone=?, email=?, address=? WHERE customer_id=?";
        try (PreparedStatement ps = con().prepareStatement(sql)) {
            ps.setString(1, c.getFullName());
            ps.setString(2, c.getNic());
            ps.setDate(3, c.getDob() == null ? null : Date.valueOf(c.getDob()));
            ps.setString(4, c.getPhone());
            ps.setString(5, c.getEmail());
            ps.setString(6, c.getAddress());
            ps.setInt(7, c.getCustomerId());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean delete(int id) throws SQLException {
        try (PreparedStatement ps = con().prepareStatement("DELETE FROM customer WHERE customer_id=?")) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public List<Customer> getAll() throws SQLException {
        return query("SELECT * FROM customer ORDER BY customer_id DESC", null);
    }

    public List<Customer> getRecent() throws SQLException {
        return query("SELECT * FROM customer ORDER BY created_at DESC, customer_id DESC LIMIT 10", null);
    }

    public List<Customer> search(String text) throws SQLException {
        String like = "%" + text + "%";
        String sql = "SELECT * FROM customer WHERE full_name LIKE ? OR nic LIKE ? OR phone LIKE ? "
                   + "OR CAST(customer_id AS CHAR) LIKE ? ORDER BY customer_id DESC";
        return query(sql, new String[]{like, like, like, like});
    }

    public int count() throws SQLException {
        try (PreparedStatement ps = con().prepareStatement("SELECT COUNT(*) FROM customer");
             ResultSet rs = ps.executeQuery()) {
            return rs.next() ? rs.getInt(1) : 0;
        }
    }

    private List<Customer> query(String sql, String[] params) throws SQLException {
        List<Customer> list = new ArrayList<>();
        try (PreparedStatement ps = con().prepareStatement(sql)) {
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    ps.setString(i + 1, params[i]);
                }
            }
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(map(rs));
                }
            }
        }
        return list;
    }
}
