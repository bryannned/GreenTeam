/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project2;

import Project2.DataBase.DatabaseConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author bentinck
 */
public class LoginController extends DatabaseConnection implements Initializable {
    
    
       
    private static Stage stage;

    public static Stage getStage() {
        return stage;
    }

       
    @FXML
    private TextField typeUsername;

    @FXML
    private PasswordField typePassword;

    @FXML
    private Label errorMessage;

    @FXML
    ImageView logo;

    @FXML
    private void login(ActionEvent event) throws IOException, SQLException {

        if (typeUsername.getText().length() == 0 || typePassword.getText().length() == 0) {// Checking for empty field 
            errorMessage.setText("Error - Incorrect Username or Password");

        }
                
        openConnection();
        
        String username = "a";
        String password = "a";
        Statement stmt1 = conn.createStatement();
        Statement stmt2 = conn.createStatement();
        //   Statement stmt2 = conn.createStatement();
        ResultSet rs1 = stmt1.executeQuery("SELECT COOR_USERNAME from COORDINATOR");
        ResultSet rs2 = stmt2.executeQuery("SELECT COOR_PASSWORD from COORDINATOR");
        while (rs1.next()) {
            username = rs1.getString("COOR_USERNAME");
            System.out.println("in rs1 loop");
            while (rs2.next()) {
                password = rs2.getString("COOR_PASSWORD");

                System.out.println("in rs2 loop");
                if (username.equals(typeUsername.getText()) && password.equals(typePassword.getText())) {//&& password == typePassword.getText()) {
                    System.out.println(username + "in the if");
                    Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = Project2.getStage();
                    stage.setScene(scene);
                }
            }
        }
    }
            
        /**
         * Initializes the controller class.
         */
        @Override
        public void initialize
        (URL url, ResourceBundle rb
   ) {

    }
}
