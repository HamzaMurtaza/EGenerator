package controllers;

import beans.Settings;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javax.swing.JTextPane;
import main.NewAdvanceWindow;
import main.NewWindow;
//imort javafx.scene.input;


//IMPROVEMENT: if there was no number in textbox, give an error/ make this error handling good
public class NewAdvanceController implements Initializable {

    private boolean error = false;

    @FXML
    private TextField noOfQuestionA, noOfQuestionC, noOfQuestionB;

    @FXML
    private Label sliderValueB1, sliderValueC2, sliderValueC1;

    @FXML
    private CheckBox checkBoxB;

    @FXML
    private CheckBox checkBoxA;

    @FXML
    private CheckBox checkBoxC;

    @FXML
    private Slider slider3A;

    @FXML
    private Slider slider1C;

    @FXML
    private Button buttonCancel;

    @FXML
    private Slider slider1A;

    @FXML
    private Slider slider2B;

    @FXML
    private Slider slider3C;

    @FXML
    private Slider slider2A;

    @FXML
    private Label sliderValueA3;

    @FXML
    private Slider slider1B;

    @FXML
    private Slider slider2C;

    @FXML
    private Label sliderValueA2;

    @FXML
    private Label sliderValueB3;

    @FXML
    private Label sliderValueA1;

    @FXML
    private Slider slider3B;

    @FXML
    private Label sliderValueB2;

    @FXML
    private Label sliderValueC3;

    @FXML
    private Button buttonOk;
          Settings settingA = new Settings();
          
     String lastSlider;     

//    @FXML
//    void textBoxHandler(ActionEvent event) {
//       
//        try{  
//        
//            if (checkBoxA.isSelected()) {
//                 if(Integer.parseInt(noOfQuestionA.getText())>4){
//                 //allow the sliders to work
//                 }
//                 
//            }
//        
//        }
//        catch (NumberFormatException e) {
//                    System.out.println(e.getMessage());
//                }
//        
//    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //CheckBoxes default Disabled
        noOfQuestionA.setDisable(true);
        noOfQuestionB.setDisable(true);
        noOfQuestionC.setDisable(true);

        slider1A.setDisable(true);
        slider2A.setDisable(true);
        slider3A.setDisable(true);

        slider1B.setDisable(true);
        slider2B.setDisable(true);
        slider3B.setDisable(true);

        slider1C.setDisable(true);
        slider2C.setDisable(true);
        slider3C.setDisable(true);

        buttonOk.setDisable(true);

        // noOfQuestionA.getOnAction((ActionEvent event) ->{});
        DecimalFormat df = new DecimalFormat("####0.0");

        slider1A.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            sliderValueA1.setText(df.format(newValue.doubleValue()));
//            int i=Numberobservable.getValue();
//observable.getValue().intValue();
//            int remain=Integer.parseInt(noOfQuestionA.getText())/observable.getValue().intValue();
//            slider2A.setValue(remain/2);
//            slider3A.setValue(remain/2);
            
            
//            if(lastSlider == null || "A".equals(lastSlider)){
//            
//            slider2A.setValue(Math.ceil(remain/2));
//            slider3A.setValue(Math.floor(remain/2));
//            }
//            else if("B".equals(lastSlider)){
////            slider2A.setValue(Math.ceil(remain/2));
//            slider3C.setValue(Integer.parseInt(noOfQuestionA.getText())-Integer.parseInt(sliderValueB1.getText())-Integer.parseInt(sliderValueA1.getText()));
//            
//            }
//            else if("C".equals(lastSlider)){
//            slider3B.setValue(Integer.parseInt(noOfQuestionA.getText())-Integer.parseInt(sliderValueC1.getText())-Integer.parseInt(sliderValueA1.getText()));
//            
//            }
//            lastSlider="A";
            
        });
        
        
        slider2A.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            sliderValueA2.setText(df.format(newValue.doubleValue()));
            
//            int remain=Integer.parseInt(noOfQuestionA.getText())/observable.getValue().intValue();
//            slider1A.setValue(remain/2);
//            slider3A.setValue(remain/2);
            
//                 int remain=Integer.parseInt(noOfQuestionA.getText())/newValue.intValue();
                 
//            if(lastSlider == null || "B".equals(lastSlider)){
//            
//            slider1A.setValue(Math.ceil(remain/2));
//            slider3A.setValue(Math.floor(remain/2));
//            }
//            else if("A".equals(lastSlider)){
////            slider2A.setValue(Math.ceil(remain/2));
//            slider3C.setValue( Integer.parseInt(noOfQuestionA.getText())-Integer.parseInt(sliderValueB1.getText())-Integer.parseInt(sliderValueA1.getText()));
//            
//            }
//            else if("C".equals(lastSlider)){
//            slider3B.setValue(Integer.parseInt(noOfQuestionA.getText())-Integer.parseInt(sliderValueC1.getText())-Integer.parseInt(sliderValueA1.getText()));
//            
//            }
//            lastSlider="B";
//            slider2A.setValue(Math.ceil(remain/2));
//            slider3A.setValue(Math.floor(remain/2));
            
        });
        slider3A.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            sliderValueA3.setText(df.format(newValue.doubleValue()));
//              int remain=Integer.parseInt(noOfQuestionA.getText())/observable.getValue().intValue();
//            slider1A.setValue(remain/2);
//            slider2A.setValue(remain/2);
            
            
        });

        slider1B.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            sliderValueB1.setText(df.format(newValue.doubleValue()));
        });
        slider2B.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            sliderValueB2.setText(df.format(newValue.doubleValue()));
        });
        slider3B.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            sliderValueB3.setText(df.format(newValue.doubleValue()));
        });

        slider1C.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            sliderValueC1.setText(df.format(newValue.doubleValue()));
        });

        slider2C.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            sliderValueC2.setText(df.format(newValue.doubleValue()));
        });

        slider3C.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            sliderValueC3.setText(df.format(newValue.doubleValue()));
        });

//        JTextPane textPane;
        
        
//        https://www.javaworld.com/article/2991463/javafx-improvements-in-java-se-8u40.html?page=4 (Perfect)
//        https://www.programcreek.com/java-api-examples/?api=javafx.scene.control.TextFormatter (Maybe  Helpful)
      UnaryOperator<TextFormatter.Change> filter;
      filter = (TextFormatter.Change change) -> {
//          System.out.println(change);
          String text = change.getText();
          for (int i = 0; i < text.length(); i++)
              if (!Character.isDigit(text.charAt(i)))
                  return null;
          
          
          
          return change;
        };
        
        noOfQuestionA.setTextFormatter(new TextFormatter(filter));
//        noOfQuestionA.addEventHandler(EventType.ROOT, eventHandler);
        
        noOfQuestionB.setTextFormatter(new TextFormatter(filter));
        noOfQuestionC.setTextFormatter(new TextFormatter(filter));
        
//        noOfQuestionA.addEventHandler(, eventHandler);
//        
         noOfQuestionA.addEventHandler(KeyEvent.KEY_RELEASED, event -> {
         
         if(!"".equals(noOfQuestionA.getText()) && noOfQuestionA.getText() != null){
             
             slider1A.setMax(Double.parseDouble(noOfQuestionA.getText()));
             slider2A.setMax(Double.parseDouble(noOfQuestionA.getText()));
             slider3A.setMax(Double.parseDouble(noOfQuestionA.getText()));
             
                slider1A.setDisable(false);
                slider2A.setDisable(false);
                slider3A.setDisable(false);
                buttonOk.setDisable(false);
         }else{
         
                slider1A.setDisable(true);
                slider2A.setDisable(true);
                slider3A.setDisable(true);
                buttonOk.setDisable(true);
         
         }
//             System.out.println(noOfQuestionA.getText());
         
         
         
         
         });
//             
////             event. 
//       KeyCode keyCode = event.getCode();
//           if (!keyCode.isDigitKey()){
////           event.consume();
////event
//noOfQuestionA.deletePreviousChar();
//            //   noOfQuestionA.setText("");
//           }
//
////         System.out.println("key pressed event fired");
//    
//    });
        
    }

    @FXML
    void checkBoxActionHandler(MouseEvent event) {

        if (event.getSource() == checkBoxA) {

            if (checkBoxA.isSelected()) {
                noOfQuestionA.setDisable(false);
//                slider1A.setDisable(false);
//                slider2A.setDisable(false);
//                slider3A.setDisable(false);
//                buttonOk.setDisable(false);
                noOfQuestionA.requestFocus();
//                        .requestFocusInWindow();
            } else {
                noOfQuestionA.setDisable(true);
                noOfQuestionA.setText("");
                
                slider1A.setDisable(true);
                slider2A.setDisable(true);
                slider3A.setDisable(true);
                

                if (checkBoxB.isSelected() == false && checkBoxC.isSelected() == false) {
                    buttonOk.setDisable(true);
                }

            }
        }

        if (event.getSource() == checkBoxB) {

            if (checkBoxB.isSelected()) {
                noOfQuestionB.setDisable(false);
                slider1B.setDisable(false);
                slider2B.setDisable(false);
                slider3B.setDisable(false);
                buttonOk.setDisable(false);
                noOfQuestionB.requestFocus();

            } else {
                noOfQuestionB.setDisable(true);
                noOfQuestionB.setText("");
                slider1B.setDisable(true);
                slider2B.setDisable(true);
                slider3B.setDisable(true);

                if (checkBoxA.isSelected() == false && checkBoxC.isSelected() == false) {
                    buttonOk.setDisable(true);
                }

            }
        }

        if (event.getSource() == checkBoxC) {

            if (checkBoxC.isSelected()) {
                noOfQuestionC.setDisable(false);
                noOfQuestionC.setText("");  
                slider1C.setDisable(false);
                slider2C.setDisable(false);
                slider3C.setDisable(false);
                buttonOk.setDisable(false);
                noOfQuestionC.requestFocus();
            } else {
                noOfQuestionC.setDisable(true);
                slider1C.setDisable(true);
                slider2C.setDisable(true);
                slider3C.setDisable(true);

                if (checkBoxA.isSelected() == false && checkBoxB.isSelected() == false) {
                    buttonOk.setDisable(true);
                }

            }

        }

    }

    @FXML
    void buttonHandler(ActionEvent event) {

        if (event.getSource() == buttonOk) {

             settingA = new Settings();
            if (checkBoxA.isSelected()) {
                try {
                    settingA.setNumberOfQuestions(Integer.parseInt(noOfQuestionA.getText()));
                    settingA.setPriorityPercent1(slider1A.getValue());
                    settingA.setPriorityPercent2(slider2A.getValue());
                    settingA.setPriorityPercent3(slider3A.getValue());
                    error = false;
                } catch (NumberFormatException e) {
                    error = true;
                    System.out.println(e.getMessage());
                }
            }
            Settings settingB = new Settings();
            if (checkBoxB.isSelected()) {
                try {
                    settingB.setNumberOfQuestions(Integer.parseInt(noOfQuestionB.getText()));
                    settingB.setPriorityPercent1(slider1B.getValue());
                    settingB.setPriorityPercent2(slider2B.getValue());
                    settingB.setPriorityPercent3(slider3B.getValue());
                    error = false;
                } catch (NumberFormatException e) {
                    error = true;
                    System.out.println(e.getMessage());
                }

            }
            Settings settingC = new Settings();
            if (checkBoxC.isSelected()) {
                try {
                    settingC.setNumberOfQuestions(Integer.parseInt(noOfQuestionC.getText()));
                    settingC.setPriorityPercent1(slider1C.getValue());
                    settingC.setPriorityPercent2(slider2C.getValue());
                    settingC.setPriorityPercent3(slider3C.getValue());
                    error = false;
                } catch (NumberFormatException e) {
                    error = true;
                    System.out.println(e.getMessage());
                }
                
            }
                if (!error) {
                    NewWindow.myControllerHandle.settings(settingA, settingB, settingC);

                    NewAdvanceWindow.closeWindow();
                }
            } else if (event.getSource() == buttonCancel) {

                NewAdvanceWindow.closeWindow();
            }

        }
    
   
   
    
    
    
//     @FXML
//    void keyPressed(ActionEvent event) {
//// displayInfo(event, "KEY PRESSED: ");
//
////        KeyCode keyCode = event.getCode();
////           if (!keyCode.isDigitKey()){
////           event.consume();
////               System.out.println(event.getCharacter());
////           }
//
//         System.out.println("key pressed event fired");
//    }

//    @FXML
//    void keyReleased(ActionEvent event) {
////displayInfo(event, "KEY RELEASED: ");
//    }
//
//    @FXML
//    void keyTyped(ActionEvent event) {
////displayInfo(event, "KEY TYPED: ");
//    }

//    @FXML
//    void onTextAction(ActionEvent event) {
//System.out.println("prseed");
//
//    }

//    @FXML
//    void textChanged(KeyEvent event) {
//        System.out.println("prseed");
//    }
    }
