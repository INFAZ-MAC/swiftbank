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

public class LoanController {
     @FXML
    private Button btnAccounts;

    @FXML
    private Button btnApply;

    @FXML
    private Button btnAtm;

    @FXML
    private Button btnCalculate;

    @FXML
    private Button btnCheques;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnDashboard;

    @FXML
    private Button btnDelete;

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
    private Button btnTransactions;

    @FXML
    private Button btnUpdate;

    @FXML
    private ComboBox<?> cmbLoanType;

    @FXML
    private TableColumn<?, ?> colAmount;

    @FXML
    private TableColumn<?, ?> colCustomerId;

    @FXML
    private TableColumn<?, ?> colInstallment;

    @FXML
    private TableColumn<?, ?> colLoanId;

    @FXML
    private TableColumn<?, ?> colRate;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableColumn<?, ?> colTerm;

    @FXML
    private TableColumn<?, ?> colType;

    @FXML
    private DatePicker dpStart;

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
    private MenuItem miActive;

    @FXML
    private MenuItem miAll;

    @FXML
    private MenuItem miPending;

    @FXML
    private MenuItem miSettled;

    @FXML
    private TableView<?> tblLoans;

    @FXML
    private TextField txtAmount;

    @FXML
    private TextField txtCustomerId;

    @FXML
    private TextField txtDuration;

    @FXML
    private TextField txtInstallment;

    @FXML
    private TextField txtLoanId;

    @FXML
    private TextField txtRate;

    @FXML
    private TextField txtSearch;
}
