package bk201.dev.autoledger;

import javafx.collections.ObservableList;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class DAL {

    private Connection connect(){
        Connection conn = null;
        String url = "jdbc:sqlite:Database/AutoLedger";
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public List getAllClients(){
        String sql = "SELECT * FROM clients ORDER BY client_id";
        List clientsList = new LinkedList();

        try (Connection conn = this.connect()){
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()){
                clientsList.add(rs);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return clientsList;
    }

//    public ObservableList<clients> getClientsForTableView(){
//
//    }

    public void insertNewClient(String lName, String fName, String address, String zCode, String City, String telNumber, String email){
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd-HH:mm");
        String formattedString = zonedDateTime.format(formatter);

        System.out.println(formattedString);

        String sql = "INSERT INTO clients (client_last_name,client_first_name," +
                "client_address,client_zip_code,client_city,client_telephone_number,client_email,created_at) " +
                "VALUES(?,?,?,?,?,?,?,?)";

        try (Connection conn = this.connect()){
            PreparedStatement prepStatement = conn.prepareStatement(sql);

            prepStatement.setString(1, lName);
            prepStatement.setString(2, fName);
            prepStatement.setString(3, address);
            prepStatement.setString(4, zCode);
            prepStatement.setString(5, City);
            prepStatement.setString(6, telNumber);
            prepStatement.setString(7, email);
            prepStatement.setString(8, formattedString);
            prepStatement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
