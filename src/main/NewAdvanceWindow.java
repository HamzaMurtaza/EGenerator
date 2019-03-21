/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class NewAdvanceWindow {

    public static Stage stg3;
    public FXMLLoader loader3 = new FXMLLoader();

    public void display() {

        stg3 = new Stage();
        stg3.initModality(Modality.APPLICATION_MODAL);

        try {
            loader3.setLocation(getClass().getResource("/fxml/NewAdvanceWindow.fxml"));
            Parent root2 = loader3.load();
            Scene scene2 = new Scene(root2);
stg3.setOnCloseRequest(e -> closeWindow());
            stg3.resizableProperty().setValue(Boolean.FALSE);
            stg3.setScene(scene2);
            stg3.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void closeWindow() {
        stg3.close();
    }

}
