/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.shop.addBook;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class FXMLDocumentController implements Initializable {

    private static Connection conn = null;
    private static Statement stmt = null;

    @FXML
    private TextField tensach;
    @FXML
    private TextField theloaisach;
    @FXML
    private TextField tacgia;
    @FXML
    private TextField nhaxuatban;
    @FXML
    private TextField giasach;
    @FXML
    private Button savebutton;
    @FXML
    private Button cancelbutton;
    @FXML
    private ComboBox<String> danhmuc;
    
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        danhmuc.setItems(FXCollections.observableArrayList(fillComboBox()));
    }

    @FXML
    private void addBook(ActionEvent event) {
        createConn();
        
        
              
        String name = tensach.getText();       
        String type = danhmuc.getValue();
        String author = tacgia.getText();
        String publisher = nhaxuatban.getText();
        int price = Integer.parseInt(giasach.getText());

        if (name.isEmpty() || type.isEmpty() || author.isEmpty() || author.isEmpty() || publisher.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng điền đầy đủ");
            alert.showAndWait();
            return;
        }
        String qu = "INSERT SACH(ten,tacgia,theloai,nhaxuatban,giaban) VALUES ("
                + "'" + name + "',"
                + "'" + author + "',"
                + "'" + type + "',"
                + "'" + publisher + "',"
                + "'" + price + "'"
                + ")";
        System.out.println(qu);
        if (execAction(qu)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Đã thêm");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Thêm thất bại");
            alert.showAndWait();
        }
    }

    @FXML
    private void cancel(ActionEvent event) {

    }

//Database
    public void createConn() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop", "root", "");

        } catch (SQLException e) {
        }
    }

    public ResultSet execQuery(String query) {
        ResultSet result;
        try {
            stmt = conn.createStatement();
            result = stmt.executeQuery(query);
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
        return result;
    }

    public boolean execAction(String qu) {

        try {
            stmt = conn.createStatement();
            stmt.execute(qu);
            
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage(), "Error Occured", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getLocalizedMessage());
            return false;
        } finally {
        }

    }

    public List<String> fillComboBox() {
        
        List<String> options = new ArrayList<>();
        
        try {
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop", "root", "");
            String query = "SELECT ten FROM danhmuc;";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {                
                options.add(result.getString("ten"));
            }
            statement.close();
            result.close();
            return options;
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }
}
