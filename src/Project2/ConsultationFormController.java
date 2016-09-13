/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project2;

/**
 *
 * @author bentinck
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class ConsultationFormController implements Initializable {
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    
    
    @FXML
    private void okButtonPressed(ActionEvent event) throws IOException {
        
        
        //call insert method
        // will need to do imports of classes at the top
        
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = Project2.getStage();
        stage.setScene(scene);
    }
    
    
    @FXML
    private void cancelButtonPressed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = Project2.getStage();
        stage.setScene(scene);
    }
    
    
    }
    

