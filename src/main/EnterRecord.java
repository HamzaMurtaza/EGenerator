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

/**
 *
 * @author Hamza
 */
public class EnterRecord {

    public static Stage stg;
    public FXMLLoader loader = new FXMLLoader();

    public void display() {

        stg = new Stage();
        stg.initModality(Modality.APPLICATION_MODAL);

        try {
            loader.setLocation(getClass().getResource("/fxml/EnterRecordWindow.fxml"));
            Parent root3 = loader.load();
            Scene scene3 = new Scene(root3);

            stg.setOnCloseRequest(e -> closeWindow());
            stg.resizableProperty().setValue(Boolean.FALSE);
            stg.setScene(scene3);
            stg.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void closeWindow() {
        stg.close();
    }

}
