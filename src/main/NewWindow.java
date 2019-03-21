package main;

import controllers.NewController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NewWindow {

    public static Stage stg;
    public FXMLLoader loader = new FXMLLoader();
    public static NewController myControllerHandle;

    public void display() {

        stg = new Stage();
        stg.initModality(Modality.APPLICATION_MODAL);
        try {
            loader.setLocation(getClass().getResource("/fxml/NewWindow.fxml"));
            Parent root2 = loader.load();
            Scene scene2 = new Scene(root2);
            myControllerHandle = (NewController) loader.getController();
            stg.resizableProperty().setValue(Boolean.FALSE);
            stg.setOnCloseRequest(e -> closeWindow());
            stg.setScene(scene2);
            stg.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void closeWindow() {
        stg.close();
    }

}
