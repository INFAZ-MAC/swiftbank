package lk.ijse.swiftbanksystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class DashboardController {

        @FXML private HBox rootBox;
    @FXML private Button btnAccounts;
    @FXML private Button btnAtm;
    @FXML private Button btnCheques;
    @FXML private Button btnCustomers;
    @FXML private Button btnDashboard;
    @FXML private Button btnExport;
    @FXML private Button btnLoans;
    @FXML private Button btnLogout;
    @FXML private Button btnNext;
    @FXML private Button btnPage1;
    @FXML private Button btnPage2;
    @FXML private Button btnPage3;
    @FXML private Button btnPrev;
    @FXML private Button btnQuickAccount;
    @FXML private Button btnQuickAtm;
    @FXML private Button btnQuickCustomer;
    @FXML private Button btnQuickLoan;
    @FXML private Button btnQuickTxn;
    @FXML private Button btnTransactions;

    @FXML private BarChart<?, ?> chartWeekly;

    @FXML private TableColumn<?, ?> colAmount;
    @FXML private TableColumn<?, ?> colDate;
    @FXML private TableColumn<?, ?> colFrom;
    @FXML private TableColumn<?, ?> colStatus;
    @FXML private TableColumn<?, ?> colTo;
    @FXML private TableColumn<?, ?> colTxnId;
    @FXML private TableColumn<?, ?> colType;

    @FXML private Label lblAccounts;
    @FXML private Label lblAccountsSub;
    @FXML private Label lblCustomers;
    @FXML private Label lblCustomersSub;
    @FXML private Label lblDate;
    @FXML private Label lblInitials;
    @FXML private Label lblLoans;
    @FXML private Label lblLoansSub;
    @FXML private Label lblShowing;
    @FXML private Label lblTotal;
    @FXML private Label lblTxnToday;
    @FXML private Label lblTxnTodaySub;
    @FXML private Label lblUserName;
    @FXML private Label lblUserRole;

    @FXML private MenuButton mbFilter;
    @FXML private MenuItem miAll;
    @FXML private MenuItem miDeposits;
    @FXML private MenuItem miTransfers;
    @FXML private MenuItem miWithdrawals;

    @FXML private TableView<?> tblRecent;
    @FXML private TextField txtSearch;

    // original dashboard main area, saved the first time a page is opened
    private Node homeContent;

    @FXML
    public void initialize() {
        // Connect buttons by fx:id (skips any button that has no fx:id)
        bind(btnDashboard, this::showDashboard);
        bind(btnCustomers, () -> loadPage("Customer.fxml"));
        bind(btnAccounts, () -> loadPage("Account.fxml"));
        bind(btnLoans, () -> loadPage("Loan.fxml"));
        bind(btnAtm, () -> loadPage("ATM.fxml"));
        bind(btnCheques, () -> loadPage("Cheque.fxml"));
        bind(btnTransactions, () -> loadPage("Transaction.fxml"));
        bind(btnLogout, this::logout);

        bind(btnQuickCustomer, () -> loadPage("Customer.fxml"));
        bind(btnQuickAccount, () -> loadPage("Account.fxml"));
        bind(btnQuickLoan, () -> loadPage("Loan.fxml"));
        bind(btnQuickAtm, () -> loadPage("ATM.fxml"));
        bind(btnQuickTxn, () -> loadPage("Transaction.fxml"));
    }

    private void bind(Button button, Runnable action) {
        if (button != null) {
            button.setOnAction(e -> action.run());
        }
    }

    // ---- Methods that Dashboard.fxml already points to (On Action) ----
    @FXML private void openDashboard(ActionEvent e)        { showDashboard(); }
    @FXML private void openCustomer(ActionEvent e)         { loadPage("Customer.fxml"); }
    @FXML private void openCustomers(ActionEvent e) { loadPage("Customer.fxml"); }
    @FXML private void openAccount(ActionEvent e)          { loadPage("Account.fxml"); }
    @FXML private void openLoan(ActionEvent e)             { loadPage("Loan.fxml"); }
    @FXML private void openAtm(ActionEvent e)              { loadPage("ATM.fxml"); }
    @FXML private void openCheque(ActionEvent e)           { loadPage("Cheque.fxml"); }
    @FXML private void openTransaction(ActionEvent e)      { loadPage("Transaction.fxml"); }
    @FXML private void handleLogout(ActionEvent e)         { logout(); }
    @FXML private void quickNewCustomer(ActionEvent e)     { loadPage("Customer.fxml"); }
    @FXML private void quickOpenAccount(ActionEvent e)     { loadPage("Account.fxml"); }
    @FXML private void quickApplyLoan(ActionEvent e)       { loadPage("Loan.fxml"); }
    @FXML private void quickAtmWithdrawal(ActionEvent e)   { loadPage("ATM.fxml"); }
    @FXML private void quickNewTransaction(ActionEvent e)  { loadPage("Transaction.fxml"); }

    // ---- Extra names (plural) so old FXML names still match ----
    @FXML private void openAccounts(ActionEvent e)     { loadPage("Account.fxml"); }
    @FXML private void openLoans(ActionEvent e)        { loadPage("Loan.fxml"); }
    @FXML private void openCheques(ActionEvent e)      { loadPage("Cheque.fxml"); }
    @FXML private void openTransactions(ActionEvent e) { loadPage("Transaction.fxml"); }    
// ---- Navigation ----
    private HBox findRootBox() {
        HBox found = null;
        Node n = btnDashboard;
        while (n != null) {
            if (n instanceof HBox) {
                found = (HBox) n;
            }
            n = n.getParent();
        }
        return found;
    }

    private void showDashboard() {
        HBox box = findRootBox();
        if (box != null && homeContent != null) {
            box.getChildren().set(1, homeContent);
        }
    }

       private void loadPage(String fxmlName) {
        try {
            HBox box = findRootBox();
            if (homeContent == null) {
                homeContent = box.getChildren().get(1);
            }
            Parent page = FXMLLoader.load(getClass().getResource("/view/" + fxmlName));

            // keep only the main area of the page, skip its own sidebar
            Node main = page;
            HBox pageBox = findFirstHBox(page);
            if (pageBox != null && pageBox.getChildren().size() >= 2) {
                main = pageBox.getChildren().get(1);
                pageBox.getChildren().remove(main);
            }

            HBox.setHgrow(main, Priority.ALWAYS);
            box.getChildren().set(1, main);
        } catch (Exception ex) {
            ex.printStackTrace();
            Throwable root = ex;
            while (root.getCause() != null) {
                root = root.getCause();
            }
            new Alert(Alert.AlertType.ERROR, "Cannot open " + fxmlName + ": " + root).show();
        }
    }

    // finds the first HBox inside a loaded page (the one holding sidebar + main area)
    private HBox findFirstHBox(Node node) {
        if (node instanceof HBox) {
            return (HBox) node;
        }
        if (node instanceof Parent) {
            for (Node child : ((Parent) node).getChildrenUnmodifiable()) {
                HBox found = findFirstHBox(child);
                if (found != null) {
                    return found;
                }
            }
        }
        return null;
    }

    private void logout() {
        try {
            UserSession.getInstance().clear();
            Stage stage = (Stage) btnLogout.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/view/login.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}