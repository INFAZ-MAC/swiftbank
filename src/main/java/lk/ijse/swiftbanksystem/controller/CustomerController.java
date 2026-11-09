
package lk.ijse.swiftbanksystem.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;



public class CustomerController {
    
    
      @FXML
    private Button btnAccounts;

    @FXML
    private Button btnAdd;

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
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colCustomerId;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colFullName;

    @FXML
    private TableColumn<?, ?> colNic;

    @FXML
    private TableColumn<?, ?> colPhone;

    @FXML
    private DatePicker dpDob;

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
    private Label lblTotalCustomers;

    @FXML
    private Label lblUserName;

    @FXML
    private Label lblUserRole;

    @FXML
    private MenuButton mbFilter;

    @FXML
    private MenuItem miAll;

    @FXML
    private MenuItem miRecent;

    @FXML
    private TableView<?> tblCustomers;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCustomerId;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFullName;

    @FXML
    private TextField txtNic;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtSearch;
}
