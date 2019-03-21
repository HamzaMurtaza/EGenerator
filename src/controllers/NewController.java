package controllers;

import beans.Settings;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import main.MainWindow;
import main.NewAdvanceWindow;
import main.NewWindow;

public class NewController implements Initializable {

    @FXML
    private Button generate;
    @FXML
    private Button cancel;
    @FXML
    private Label error;
    
    @FXML
    private Button advance;

    public String tests = "test";
    
    public Settings settingA=null,settingB=null,settingC=null;

    @FXML
    ChoiceBox clas, subject, quarter; //method:populateChoiceBoxes();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //populate choice boxes in newWindow
        populateChoiceBoxes();

    }

    @FXML
    private void handleButtonAction(ActionEvent event) {

        if (event.getSource() == generate) {

            if (clas.getValue() == null) {
                error.setText("Please Select a Class");
                System.out.println("Please Select a Class");
            } else if (subject.getValue() == null) {
                error.setText("Please Select a Subject");
                System.out.println("Please Select a Subject");
            } else if (quarter.getValue() == null) {
                error.setText("Please Select a Quarter");
                System.out.println("Please Select Quarter");
            } else {
                error.setText("");
               // System.out.println("sending data to database");
//if(settingA != null){
//                System.out.println(settingA.toString());
//                System.out.println(settingB.toString());
//                System.out.println(settingC.toString());
//}               
               
//                MainWindow.myControllerHandle.createLogic((String) clas.getValue(), (String) subject.getValue(), (String) quarter.getValue());

                MainWindow.myControllerHandle.createLogic((String) clas.getValue(), (String) subject.getValue(), (String) quarter.getValue(),settingA,settingB,settingC);

                NewWindow.closeWindow();

            }

        } else if (event.getSource() == cancel) {

            System.out.println("You clicked me!" + event.getSource());
        }
        else if(event.getSource() == advance){
        
        NewAdvanceWindow newadvancecontroller= new NewAdvanceWindow();
        newadvancecontroller.display();
        
        }
    }

    private void populateChoiceBoxes() {

        clas.getItems().addAll("Class 1", "Class 2", "Class 3", "Class 4", "Class 5", "Class 6", "Class 7", "Class 8", "Class 9", "Class 10");
        subject.getItems().addAll("Chemstry", "Physics", "Mathematics", "Pakistan Studies");
        quarter.getItems().addAll("First", "Mid", "Third", "Final");

    }
    
    public void settings(Settings settingA,Settings settingB,Settings settingC){
        
    this.settingA=settingA;
    this.settingB=settingB;
    this.settingC=settingC;
    
    }

}
