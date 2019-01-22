/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tak.toe;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

/**
 *
 * @author Ziad
 */
public class FXMLDocumentController implements Initializable {
    ObservableList<String> ModeList = FXCollections.observableArrayList("Easy","Medium","Impossible","Play against a friend");
    private Label label;
    public ComboBox ModeBox;
    private void handleButtonAction(ActionEvent event) {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ModeBox.setValue("Easy");
        ModeBox.setItems(ModeList);
    }    
    
}
