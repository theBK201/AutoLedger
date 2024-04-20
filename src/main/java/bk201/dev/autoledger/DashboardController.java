package bk201.dev.autoledger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Arrays;
import java.util.List;

public class DashboardController {
    @FXML
    private TextField txfFirstName;
    @FXML
    private TextField txfLastName;
    @FXML
    private TextField txfStreet;
    @FXML
    private TextField txfCity;
    @FXML
    private TextField txfZipCode;
    @FXML
    private TextField txfEmail;
    @FXML
    private TextField txfTelNumber;
    @FXML
    private Button btnSave;
    @FXML private TableView<clients> tblViewClients;
    @FXML private TableColumn<clients, String> clFirstName;
    @FXML private TableColumn<clients, String> clLastName;
    @FXML private TableColumn<clients, String> clStreet;
    @FXML private TableColumn<clients, String> clCity;
    @FXML private TableColumn<clients, String> clZCode;
    @FXML private TableColumn<clients, String> clEmail;
    @FXML private TableColumn<clients, String> clNumber;
    @FXML private TableColumn<clients, String> clClientID;

    @FXML private ListView lvInvoiceItems;

    DAL dal = new DAL();

    @FXML private void initialize(){

        clFirstName.setCellValueFactory(new PropertyValueFactory<>("clFirstName"));
        clLastName.setCellValueFactory(new PropertyValueFactory<>("clLastName"));
        clStreet.setCellValueFactory(new PropertyValueFactory<>("clStreet"));
        clCity.setCellValueFactory(new PropertyValueFactory<>("clCity"));
        clZCode.setCellValueFactory(new PropertyValueFactory<>("clZCode"));
        clEmail.setCellValueFactory(new PropertyValueFactory<>("clEmail"));
        clNumber.setCellValueFactory(new PropertyValueFactory<>("clNumber"));
        clClientID.setCellValueFactory(new PropertyValueFactory<>("clClientID"));

        tblViewClients.getItems().setAll(parseClients());

        lvInvoiceItems.getItems().add("Item 1");
        lvInvoiceItems.getItems().add("Item 1");
        lvInvoiceItems.getItems().add("Item 1");
        lvInvoiceItems.getItems().add("Item 1");
        lvInvoiceItems.getItems().add("Item 1");
        lvInvoiceItems.getItems().add("Item 1");
        lvInvoiceItems.getItems().add("Item 1");
        lvInvoiceItems.getItems().add("Item 1");
        lvInvoiceItems.getItems().add("Item 1");
        lvInvoiceItems.getItems().add("Item 1");
        lvInvoiceItems.getItems().add("Item 1");
        lvInvoiceItems.getItems().add("Item 1");
        lvInvoiceItems.getItems().add("Item 1");

    }

    public void onSaveButtonClick(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        if(txfFirstName.getText().isEmpty() || txfLastName.getText().isEmpty() || txfStreet.getText().isEmpty() ||
            txfCity.getText().isEmpty() || txfZipCode.getText().isEmpty() || txfTelNumber.getText().isEmpty()){

            alert.setTitle("Information Dialog");
            alert.setHeaderText("Angaben fehlen, bitte alle Felder ausfüllen!");
        }else {
            dal.insertNewClient(txfLastName.getText(),txfFirstName.getText(),txfStreet.getText(),txfCity.getText(),txfZipCode.getText(),
                    txfTelNumber.getText(),txfEmail.getText());
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Kunde gespeichert!");
        }
        alert.showAndWait();
    }

    public void loadClients(){
        List clients = dal.getAllClients();
    }

    private ObservableList<clients> parseClients(){
        List<clients> clientsList = dal.getAllClients();
        for (int i = 0; i < clientsList.size(); i++){
            System.out.println(clientsList.get(i));
        }
        clients clients = new clients("test", "lstName","street","city","9990","mail.com", "9213","1");
        return FXCollections.observableArrayList(clients);
    }
}