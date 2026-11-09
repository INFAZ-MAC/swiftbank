package lk.ijse.swiftbanksystem.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.swiftbanksystem.db.DBConnection;

public class LoginController {

    @FXML private Button btnLogin;
    @FXML private Button btnTogglePassword;
    @FXML private CheckBox chkRemember;
    @FXML private Hyperlink hlForgot;
    @FXML private Label lblError;
    @FXML private PasswordField txtPassword;
    @FXML private TextField txtPasswordVisible;
    @FXML private TextField txtUsername;

    @FXML
    public void initialize() {
        // Enter in username moves to password
        txtUsername.setOnAction(e -> txtPassword.requestFocus());
        // Enter in password logs in
        txtPassword.setOnAction(e -> btnLogin.fire());
    }

    @FXML
    private void handleLogin(ActionEvent event) {
        String user = txtUsername.getText().trim();
        String pass = txtPassword.isVisible() ? txtPassword.getText() : txtPasswordVisible.getText();

        if (user.isEmpty() || pass.isEmpty()) {
            lblError.setText("Enter username and password");
            return;
        }

        if (authenticate(user, pass)) {
            try {
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/view/Dashboard.fxml"));
                stage.setScene(new Scene(root));
                stage.show();
                        } catch (Exception e) {
                e.printStackTrace();
                Throwable root = e;
                while (root.getCause() != null) {
                    root = root.getCause();
                }
                new javafx.scene.control.Alert(
                        javafx.scene.control.Alert.AlertType.ERROR,
                        "Dashboard failed: " + root).show();
            }
        } else {
            lblError.setText("Invalid username or password");
        }
    }

    @FXML
    private void handleTogglePassword(ActionEvent event) {
        boolean showing = txtPasswordVisible.isVisible();
        if (showing) {
            txtPassword.setText(txtPasswordVisible.getText());
            txtPassword.setVisible(true);
            txtPasswordVisible.setVisible(false);
        } else {
            txtPasswordVisible.setText(txtPassword.getText());
            txtPasswordVisible.setVisible(true);
            txtPassword.setVisible(false);
        }
    }

    private boolean authenticate(String user, String pass) {
        String sql = "SELECT user_id, username FROM user_account "
                   + "WHERE username = ? AND password_hash = SHA2(?, 256) AND active = 1";
        try {
            Connection con = DBConnection.getInstance().getConnection();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, user);
                ps.setString(2, pass);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        UserSession.getInstance().init(rs.getInt("user_id"), rs.getString("username"));
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            lblError.setText("Database error, check the Output window");
        }
        return false;
    }
}