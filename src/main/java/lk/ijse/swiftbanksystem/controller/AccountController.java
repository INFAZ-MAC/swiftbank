
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

public class AccountController {
    
    
    @FXML
    private Button btnAccounts;

    @FXML
    private Button btnAtm;

    @FXML
    private Button btnCheques;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnClose;

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
    private Button btnOpen;

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
    private ComboBox<?> cmbAccountType;

    @FXML
    private ComboBox<?> cmbStatus;

    @FXML
    private TableColumn<?, ?> colAccountNo;

    @FXML
    private TableColumn<?, ?> colBalance;

    @FXML
    private TableColumn<?, ?> colCustomerId;

    @FXML
    private TableColumn<?, ?> colCustomerName;

    @FXML
    private TableColumn<?, ?> colOpened;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableColumn<?, ?> colType;

    @FXML
    private DatePicker dpOpened;

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
    private MenuItem miCurrent;

    @FXML
    private MenuItem miFixed;

    @FXML
    private MenuItem miSavings;

    @FXML
    private TableView<?> tblAccounts;

    @FXML
    private TextField txtAccountNo;

    @FXML
    private TextField txtBalance;

    @FXML
    private TextField txtCustomerId;

    @FXML
    private TextField txtRemarks;

    @FXML
    private TextField txtSearch;
}
