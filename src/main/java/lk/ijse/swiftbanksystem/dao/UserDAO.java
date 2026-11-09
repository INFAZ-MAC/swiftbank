package lk.ijse.swiftbanksystem.dao;

import lk.ijse.swiftbanksystem.db.DBConnection;
import lk.ijse.swiftbanksystem.model.User;
import lk.ijse.swiftbanksystem.util.PasswordUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public User login(String username, String password) throws SQLException {
        String sql = "SELECT user_id, username, role FROM user_account "
                   + "WHERE username = ? AND password_hash = ? AND active = TRUE";

        Connection conn = DBConnection.getInstance().getConnection();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, PasswordUtil.hash(password));
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new User(
                            rs.getInt("user_id"),
                            rs.getString("username"),
                            rs.getString("role"));
                }
            }
        }
        return null;
    }
}