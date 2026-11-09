
package lk.ijse.swiftbanksystem.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AtmController {
 
    
    @FXML
    private Button btnAccounts;

    @FXML
    private Button btnAtm;

    @FXML
    private Button btnCheques;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnDashboard;

    @FXML
    private Button btnLoans;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnNext;

    @FXML
    private Button btnPage1;

    @FXML
    private Button btnPage2;

    @FXML
    private Button btnPage3;

    @FXML
    private Button btnPrev;

    @FXML
    private Button btnQuick10000;

    @FXML
    private Button btnQuick20000;

    @FXML
    private Button btnQuick5000;

    @FXML
    private Button btnQuick50000;

    @FXML
    private Button btnTransactions;

    @FXML
    private Button btnWithdraw;

    @FXML
    private TableColumn<?, ?> colAccountNo;

    @FXML
    private TableColumn<?, ?> colAmount;

    @FXML
    private TableColumn<?, ?> colDateTime;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableColumn<?, ?> colTxnId;

    @FXML
    private Label lblBalance;

    @FXML
    private Label lblBranch;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblInitials;

    @FXML
    private Label lblLimit;

    @FXML
    private Label lblShowing;

    @FXML
    private Label lblTotal;

    @FXML
    private Label lblUserName;

    @FXML
    private Label lblUserRole;

    @FXML
    private MenuButton mbFilter;

    @FXML
    private MenuItem miAll;

    @FXML
    private MenuItem miFailed;

    @FXML
    private MenuItem miToday;

    @FXML
    private TableView<?> tblWithdrawals;

    @FXML
    private TextField txtAccountNo;

    @FXML
    private TextField txtAmount;

    @FXML
    private PasswordField txtPin;

    @FXML
    private TextField txtSearch;
}
