
package controllers;

import dao.Dao;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javax.swing.text.PlainDocument;
import others.DigitFilter;

/**
 *
 * @author Hamza
 */
public class EnterRecordController implements Initializable {

    @FXML
    private Button add;

    @FXML
    private Button cancel;

    @FXML
    private ChoiceBox subject;

    @FXML
    private ChoiceBox section;

    @FXML
    private TextArea questin;

    @FXML
    private ChoiceBox marks;

    @FXML
    private ChoiceBox type;

    @FXML
    private ChoiceBox priority;

    @FXML
    private ChoiceBox grade;

    @FXML
    private ChoiceBox quarter;
    
     @FXML
    private TextArea description;

    @FXML
    private TextField choice5;

    @FXML
    private TextField choice3;

    @FXML
    private TextField choice4;

    @FXML
    private TextField choice1;

    @FXML
    private TextField choice2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        populateChoiceBoxes();
        
//         PlainDocument document = (PlainDocument) choice3.get;
//    document.setDocumentFilter(new DigitFilter());

questin.setOnKeyPressed((KeyEvent event) -> {
//    KeyCode

        DigitFilter filter=new DigitFilter();
        filter.revise(event.getCharacter());
    
//    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }//            @Override
//            public void handle(Event event) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
        );

    }

    @FXML
    private void handleButtonAction(ActionEvent event) {

        if (event.getSource() == add) {
            System.out.println("in hweeerer");
            Dao dao = new Dao();
            
           Double d = Double.parseDouble((String) marks.getValue());
            int b = Integer.parseInt((String) priority.getValue());
            dao.addRecord((String) grade.getValue(), (String) subject.getValue(), (String) quarter.getValue(), (String) section.getValue(), (String) type.getValue(),  Double.parseDouble((String) marks.getValue()),  Integer.parseInt((String) priority.getValue()), questin.getText(),description.getText(), choice1.getText(), choice2.getText(), choice3.getText(), choice4.getText(), choice5.getText());

        }

    }
        @FXML
    void validation(ActionEvent event) {
questin.getText();
//        DigitFilter filter=new DigitFilter();
//        filter.revise(text);
        
    }

    private void populateChoiceBoxes() {

        grade.getItems().addAll("Class 1", "Class 2", "Class 3", "Class 4", "Class 5", "Class 6", "Class 7", "Class 8 ", "Class 9", "Class 10");
        subject.getItems().addAll("Chemstry", "Physics", "Mathematics", "Pakistan Studies");
        quarter.getItems().addAll("First", "Mid", "Third", "Final");
        section.getItems().addAll("A", "B", "C");
        type.getItems().addAll("blank", "short question", "long question");
        marks.getItems().addAll("1", "5", "10");
        priority.getItems().addAll("1", "2", "3");

    }

}
