/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controllers.NewController;
import controllers.SwapController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class SwapWindow {

    public static Stage stg;
    public FXMLLoader loader = new FXMLLoader();
    public static SwapController myControllerHandle;

    public void display() {

        stg = new Stage();
        stg.initModality(Modality.APPLICATION_MODAL);

        try {
            loader.setLocation(getClass().getResource("/fxml/SwapWindow.fxml"));
            Parent root2 = loader.load();
            Scene scene2 = new Scene(root2);
            myControllerHandle = (SwapController) loader.getController();
            stg.resizableProperty().setValue(Boolean.TRUE);
            stg.setScene(scene2);
            stg.setOnCloseRequest(e -> closeWindow());
            stg.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void closeWindow() {
        stg.close();
    }

}
