package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import controllers.MainController;
import javafx.application.Platform;
import javafx.stage.Modality;

public class MainWindow extends Application {

    public FXMLLoader loader;
    public static MainController myControllerHandle;

    @Override
    public void start(Stage stage) throws Exception {

        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/MainWindow.fxml"));
        Parent root = loader.load();

        myControllerHandle = (MainController) loader.getController();

        Scene scene = new Scene(root);
        stage.setTitle("EGenerator");
        stage.setScene(scene);
        stage.setOnCloseRequest(e -> {
Platform.exit();
System.exit(0);
            stage.close();});
//        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
//   public static void closeWindow() {
//        stage.close();
//    }
}
