
package lk.ijse.swiftbanksystem.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class TransactionController {
    
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
    private Button btnExport;

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
    private Button btnSubmit;

    @FXML
    private Button btnTransactions;

    @FXML
    private ComboBox<?> cmbType;

    @FXML
    private TableColumn<?, ?> colAmount;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colFrom;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableColumn<?, ?> colTo;

    @FXML
    private TableColumn<?, ?> colTxnId;

    @FXML
    private TableColumn<?, ?> colType;

    @FXML
    private DatePicker dpDate;

    @FXML
    private Label lblBranch;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblInitials;

    @FXML
    private Label lblSelected;

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
    private MenuItem miDeposits;

    @FXML
    private MenuItem miTransfers;

    @FXML
    private MenuItem miWithdrawals;

    @FXML
    private TableView<?> tblTransactions;

    @FXML
    private TextField txtAmount;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtFromAccount;

    @FXML
    private TextField txtSearch;

    @FXML
    private TextField txtToAccount;

    @FXML
    private TextField txtTxnId;
    
}
