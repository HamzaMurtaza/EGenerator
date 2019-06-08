package controllers;

import beans.ChemstryC8;
import beans.Settings;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import dao.Dao;
import java.util.ArrayList;
import java.util.Random;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.Tab;
import javafx.scene.control.TableRow;
import javafx.scene.control.TextField;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import main.EnterRecord;
import main.NewWindow;
import main.SwapWindow;

public class MainController implements Initializable {

    @FXML
    public TableView<ChemstryC8> table1;
    @FXML
    public TableView<ChemstryC8> table2;
    @FXML
    public TableView<ChemstryC8> table3;

    @FXML
    public MenuItem menuNew;
    @FXML
    public MenuItem menuEnterRecord;

    @FXML
    public TextField choice1, choice2, choice3, choice4, choice5;

    @FXML
    private Button mainSwap;

    @FXML
    private Button buttonDelete;

    @FXML
    private Tab tabA;
    @FXML
    private Tab tabB;
    @FXML
    private Tab tabC;

    public List<ChemstryC8> remainingA = new ArrayList();
    public List<ChemstryC8> remainingB = new ArrayList();
    public List<ChemstryC8> remainingC = new ArrayList();

    public Dao dao = new Dao();

    int sliderValue = 0;

    public static Stage stg;
    public ObservableList<ChemstryC8> list = observableArrayList();
    public ObservableList<ChemstryC8> tableList = observableArrayList();
    public FXMLLoader newWindowLoader = new FXMLLoader();
    public List<ChemstryC8> sectionB;
    public static DataFormat SERIALIZED_MIME_TYPE = new DataFormat("application/x-java-serialized-object");

//    Loo
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        mainSwap.setDisable(true);
        buttonDelete.setDisable(true);

//        if(table1.idProperty().isEmpty()){}
        //table1.setRowFactory(value);
        table1.setRowFactory(tv -> {

            TableRow<ChemstryC8> row = new TableRow<>();
            
            row.setOnMouseClicked(event -> {
                buttonDelete.setDisable(false);
            });

            row.setOnDragDetected(event -> {
                if (!row.isEmpty()) {
                    Integer index = row.getIndex();
                    Dragboard db = row.startDragAndDrop(TransferMode.MOVE);
                    db.setDragView(row.snapshot(null, null));
                    ClipboardContent cc = new ClipboardContent();
                    cc.put(SERIALIZED_MIME_TYPE, index);
                    db.setContent(cc);
                    event.consume();
                }
            });

            row.setOnDragOver(event -> {
                Dragboard db = event.getDragboard();
                if (db.hasContent(SERIALIZED_MIME_TYPE)) {
                    if (row.getIndex() != ((Integer) db.getContent(SERIALIZED_MIME_TYPE)).intValue()) {
                        event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                        event.consume();
                    }
                }
            });

            row.setOnDragDropped(event -> {
                Dragboard db = event.getDragboard();
                if (db.hasContent(SERIALIZED_MIME_TYPE)) {
                    int draggedIndex = (Integer) db.getContent(SERIALIZED_MIME_TYPE);
                    ChemstryC8 draggedPerson = table1.getItems().remove(draggedIndex);

                    int dropIndex;

                    if (row.isEmpty()) {
                        dropIndex = table1.getItems().size();
                    } else {
                        dropIndex = row.getIndex();
                    }

                    table1.getItems().add(dropIndex, draggedPerson);

                    tableList = table1.getItems();
                    int count = 0;
                    for (ChemstryC8 item : table1.getItems()) {

                        tableList.get(count).setId(count + 1);
                        count++;
                    }

                    event.setDropCompleted(true);
                    table1.getSelectionModel().select(dropIndex);
                    event.consume();
                }
            });

            return row;
        });

        //table1.get
        table2.setRowFactory(tv -> {

            TableRow<ChemstryC8> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                buttonDelete.setDisable(false);
            });
            row.setOnDragDetected(event -> {
                if (!row.isEmpty()) {
                    Integer index = row.getIndex();
                    Dragboard db = row.startDragAndDrop(TransferMode.MOVE);
                    db.setDragView(row.snapshot(null, null));
                    ClipboardContent cc = new ClipboardContent();
                    cc.put(SERIALIZED_MIME_TYPE, index);
                    db.setContent(cc);
                    event.consume();
                }
            });

            row.setOnDragOver(event -> {
                Dragboard db = event.getDragboard();
                if (db.hasContent(SERIALIZED_MIME_TYPE)) {
                    if (row.getIndex() != ((Integer) db.getContent(SERIALIZED_MIME_TYPE)).intValue()) {
                        event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                        event.consume();
                    }
                }
            });

            row.setOnDragDropped(event -> {
                Dragboard db = event.getDragboard();
                if (db.hasContent(SERIALIZED_MIME_TYPE)) {
                    int draggedIndex = (Integer) db.getContent(SERIALIZED_MIME_TYPE);
                    ChemstryC8 draggedPerson = table2.getItems().remove(draggedIndex);

                    int dropIndex;

                    if (row.isEmpty()) {
                        dropIndex = table2.getItems().size();
                    } else {
                        dropIndex = row.getIndex();
                    }

                    table2.getItems().add(dropIndex, draggedPerson);

                    tableList = table2.getItems();
                    int count = 0;
                    for (ChemstryC8 item : table2.getItems()) {

                        tableList.get(count).setId(count + 1);
                        count++;
                    }

                    event.setDropCompleted(true);
                    table2.getSelectionModel().select(dropIndex);
                    event.consume();
                }
            });

            return row;
        });

        table3.setRowFactory(tv -> {

            TableRow<ChemstryC8> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                buttonDelete.setDisable(false);
            });
            row.setOnDragDetected(event -> {
                if (!row.isEmpty()) {
                    Integer index = row.getIndex();
                    Dragboard db = row.startDragAndDrop(TransferMode.MOVE);
                    db.setDragView(row.snapshot(null, null));
                    ClipboardContent cc = new ClipboardContent();
                    cc.put(SERIALIZED_MIME_TYPE, index);
                    db.setContent(cc);
                    event.consume();
                }
            });

            row.setOnDragOver(event -> {
                Dragboard db = event.getDragboard();
                if (db.hasContent(SERIALIZED_MIME_TYPE)) {
                    if (row.getIndex() != ((Integer) db.getContent(SERIALIZED_MIME_TYPE)).intValue()) {
                        event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                        event.consume();
                    }
                }
            });

            row.setOnDragDropped(event -> {
                Dragboard db = event.getDragboard();
                if (db.hasContent(SERIALIZED_MIME_TYPE)) {
                    int draggedIndex = (Integer) db.getContent(SERIALIZED_MIME_TYPE);
                    ChemstryC8 draggedPerson = table3.getItems().remove(draggedIndex);

                    int dropIndex;

                    if (row.isEmpty()) {
                        dropIndex = table3.getItems().size();
                    } else {
                        dropIndex = row.getIndex();
                    }

                    table3.getItems().add(dropIndex, draggedPerson);

                    tableList = table3.getItems();
                    int count = 0;
                    for (ChemstryC8 item : table3.getItems()) {

                        tableList.get(count).setId(count + 1);
                        count++;
                    }

                    event.setDropCompleted(true);
                    table3.getSelectionModel().select(dropIndex);
                    event.consume();
                }
            });

            return row;
        });

        //    menuNew.
//        table1.setEditable(true);
//
//        column1.setCellValueFactory(new PropertyValueFactory("id"));
//        column2.setCellValueFactory(new PropertyValueFactory("question"));
////        TableColumn t = (TableColumn) table1.getColumns().get(0);
////        t.setCellValueFactory(new PropertyValueFactory("id"));
//
////        TableColumn t1 = (TableColumn) table1.getColumns().get(1);
////        t1.setCellValueFactory(new PropertyValueFactory("question"));
//        ObservableList<ChemstryC8> list = observableArrayList();
//        list.add(new ChemstryC8(1, "this is the question"));
//        list.add(new ChemstryC8(1, "this is the question"));
//        list.add(new ChemstryC8(1, "this is the question"));
//
//        table1.setItems(list);
//        table1.
//        slider.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
//
//            sliderValue = newValue.intValue();
//            // System.out.println(sliderValue) ;
//
//        });
    }

    @FXML
    void handleButtonAction(ActionEvent event) {
        if (event.getSource() == mainSwap) {

            SwapWindow swapWindow = new SwapWindow();
            swapWindow.display();

        }

        if (event.getSource() == buttonDelete) {

            if (tabA.isSelected()) {

                ChemstryC8 item = table1.getSelectionModel().getSelectedItem();
                table1.getItems().remove(table1.getSelectionModel().getSelectedIndex());
                remainingA.add(item);
                int count=1;
                for (ChemstryC8 items : table1.getItems()) {
                            items.setId(count++);
                            //table1.get(count).setId(count + 1);
                            //count++;
                        }

            } else if (tabB.isSelected()) {
                ChemstryC8 item = table2.getSelectionModel().getSelectedItem();
                table2.getItems().remove(table2.getSelectionModel().getSelectedIndex());
                remainingB.add(item);
                
                  int count=1;
                for (ChemstryC8 items : table1.getItems()) {
                            items.setId(count++);
                            //table1.get(count).setId(count + 1);
                            //count++;
                        }
            } else if (tabC.isSelected()) {
                ChemstryC8 item = table3.getSelectionModel().getSelectedItem();
                table3.getItems().remove(table3.getSelectionModel().getSelectedIndex());
                remainingC.add(item);
                  int count=1;
                for (ChemstryC8 items : table1.getItems()) {
                            items.setId(count++);
                            //table1.get(count).setId(count + 1);
                            //count++;
                        }
            }

            //if any table becomes empty then disable delete button 
            //also if a person deletes a selected value then it should be added in the list of avalible swapable things
      //the swap table keeps increasing the same value , fix it
        }

    }

    @FXML
    private void handleMenuAction(ActionEvent e) {

        if (e.getSource() == menuNew) {

            NewWindow newWindow = new NewWindow();
            newWindow.display();
        }

        if (e.getSource() == menuEnterRecord) {

            EnterRecord enterRecord = new EnterRecord();
            enterRecord.display();
        }

    }

    public void populateTable(List tableData1, List tableData2, List tableData3) throws IOException, NoSuchFieldException, InstantiationException, IllegalAccessException {

        try {

//            System.out.println(this.getClass().getClassLoader().toString());
            if (tableData1 != null) {
                int count = 0;
                for (Iterator<ChemstryC8> it = tableData1.iterator(); it.hasNext();) {
                    ChemstryC8 i = it.next();

                    count++;
//      System.out.println(i.getId());
                    //     System.out.println(i.getQuestion());

                    //list.add(new ChemstryC8(count, i.getQuestion()));
                    i.setId(count);
                    list.add(i);

                }

                table1.setEditable(true);

                TableColumn secAcol1 = (TableColumn) table1.getColumns().get(0);
                secAcol1.setCellValueFactory(new PropertyValueFactory("id"));
                TableColumn secAcol2 = (TableColumn) table1.getColumns().get(1);
                secAcol2.setCellValueFactory(new PropertyValueFactory("question"));
                TableColumn secAcol3 = (TableColumn) table1.getColumns().get(2);
                secAcol3.setCellValueFactory(new PropertyValueFactory("description"));

                table1.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

                    //   ChemstryC8 table1column = (ChemstryC8) tableData1.get(table1.getSelectionModel().getSelectedIndex());
//                    ChemstryC8 table1column = (ChemstryC8) tableData1.get(table1.getSelectionModel().getSelectedItem().getId());
                    int index = tableData1.indexOf(table1.getSelectionModel().getSelectedItem());
                    System.out.println(index);
                    ChemstryC8 table1column = (ChemstryC8) tableData1.get(index);

                    if (table1column.getChoice1() != null) {
                        choice1.setText(table1column.getChoice1());
                    }
                    if (table1column.getChoice2() != null) {
                        choice2.setText(table1column.getChoice2());
                    }
                    if (table1column.getChoice3() != null) {
                        choice3.setText(table1column.getChoice3());
                    }
                    if (table1column.getChoice4() != null) {
                        choice4.setText(table1column.getChoice4());
                    }
                    if (table1column.getChoice5() != null) {
                        choice5.setText(table1column.getChoice5());
                    }
                });

                table1.setItems(list);

            }

            if (tableData2 != null) {
                list = observableArrayList();

                int count = 0;
                for (Iterator<ChemstryC8> it = tableData2.iterator(); it.hasNext();) {
                    ChemstryC8 i = it.next();
                    //   System.out.println(i.getId());
                    //   System.out.println(i.getQuestion());
                    count++;
                    i.setId(count);
                    // list.add(new ChemstryC8(count, i.getQuestion()));
                    list.add(i);
                }

                table2.setEditable(true);

                TableColumn secBcol1 = (TableColumn) table2.getColumns().get(0);
                secBcol1.setCellValueFactory(new PropertyValueFactory("id"));

                TableColumn secBcol2 = (TableColumn) table2.getColumns().get(1);
                secBcol2.setCellValueFactory(new PropertyValueFactory("question"));
                
                TableColumn secAcol3 = (TableColumn) table2.getColumns().get(2);
                secAcol3.setCellValueFactory(new PropertyValueFactory("description"));

                table2.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

                    //ChemstryC8 table2column = (ChemstryC8) tableData2.get(table2.getSelectionModel().getSelectedIndex());
                    int index = tableData2.indexOf(table2.getSelectionModel().getSelectedItem());
                    ChemstryC8 table2column = (ChemstryC8) tableData2.get(index);

                    if (table2column.getChoice1() != null) {
                        choice1.setText(table2column.getChoice1());
                    }
                    if (table2column.getChoice2() != null) {
                        choice2.setText(table2column.getChoice2());
                    }
                    if (table2column.getChoice3() != null) {
                        choice3.setText(table2column.getChoice3());
                    }
                    if (table2column.getChoice4() != null) {
                        choice4.setText(table2column.getChoice4());
                    }
                    if (table2column.getChoice5() != null) {
                        choice5.setText(table2column.getChoice5());
                    }
                });

                table2.setItems(list);

            }

            if (tableData3 != null) {
                list = observableArrayList();

                int count = 0;
                for (Iterator<ChemstryC8> it = tableData3.iterator(); it.hasNext();) {
                    ChemstryC8 i = it.next();
//                    System.out.println(i.getId());
                    //                  System.out.println(i.getQuestion());

                    count++;
                    i.setId(count);
                    //   list.add(new ChemstryC8(count, i.getQuestion()));
                    list.add(i);
                }

                table3.setEditable(true);

                TableColumn secCcol1 = (TableColumn) table3.getColumns().get(0);
                secCcol1.setCellValueFactory(new PropertyValueFactory("id"));

                TableColumn secCcol = (TableColumn) table3.getColumns().get(1);
                secCcol.setCellValueFactory(new PropertyValueFactory("question"));
                
                TableColumn secAcol3 = (TableColumn) table3.getColumns().get(2);
                secAcol3.setCellValueFactory(new PropertyValueFactory("description"));

                table3.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

                    //ChemstryC8 table3column = (ChemstryC8) tableData3.get(table3.getSelectionModel().getSelectedIndex());
                    int index = tableData3.indexOf(table3.getSelectionModel().getSelectedItem());
                    ChemstryC8 table3column = (ChemstryC8) tableData3.get(index);

                    if (table3column.getChoice1() != null) {
                        choice1.setText(table3column.getChoice1());
                    }
                    if (table3column.getChoice2() != null) {
                        choice2.setText(table3column.getChoice2());
                    }
                    if (table3column.getChoice3() != null) {
                        choice3.setText(table3column.getChoice3());
                    }
                    if (table3column.getChoice4() != null) {
                        choice4.setText(table3column.getChoice4());
                    }
                    if (table3column.getChoice5() != null) {
                        choice5.setText(table3column.getChoice5());
                    }
                });

                table3.setItems(list);

            }

            mainSwap.setDisable(false);

        } catch (SecurityException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createLogic(String clas, String subjet, String qurter, Settings settingA, Settings settingB, Settings settingC) {

//        if (settingA != null) {
//            System.out.println(settingA.toString());
//            System.out.println(settingB.toString());
//            System.out.println(settingC.toString());
//        }
        try {
            //Section A logic

            if (settingA == null) {

                settingA = defaultSettingsA(clas, subjet, qurter);

            }

            List<ChemstryC8> sectionA = sectionA(clas, subjet, qurter);
           
            List<ChemstryC8> refinedA = new ArrayList();
            remainingA = sectionA;

            
            List<ChemstryC8> priority1 =new ArrayList();
            List<ChemstryC8> priority2 =new ArrayList();
            List<ChemstryC8> priority3 =new ArrayList();
                   
            
            for(int i=0;i<sectionA.size();i++){
            
                switch(sectionA.get(i).getPriority()){
                    case 1: priority1.add(sectionA.get(i));
                    case 2:  priority2.add(sectionA.get(i));
                    case 3: priority3.add(sectionA.get(i));
            }
                
            }   
//            if(sectionA.get(i).getPriority()==1){
//            priority1=(List<ChemstryC8>) sectionA.get(i);
//            }
//            if(sectionA.get(i).getPriority()==2){
//            priority2=(List<ChemstryC8>) sectionA.get(i);
//            }
//            if(sectionA.get(i).getPriority()==3){
//            priority3=(List<ChemstryC8>) sectionA.get(i);
//            }
//            
            
            
//      

// NEW WORK:I am first getting all the percentages of the  

           int numOfQuesAP1= (int) Math.floor(settingA.getPriorityPercent1()/settingA.getNumberOfQuestions());
           int numOfQuesAP2= (int) Math.floor(settingA.getPriorityPercent2()/settingA.getNumberOfQuestions());
           int numOfQuesAP3= (int) Math.floor(settingA.getPriorityPercent3()/settingA.getNumberOfQuestions());
           
//           Math.floor( settingA.getNumberOfQuestions()/settingA.getPriorityPercent1());

            Random randA = new Random();
            int nA;

//            for (int i = 0; i < settingA.getNumberOfQuestions(); i++) {
////                nA = randA.nextInt(sectionA.size()) + 0;
////                refinedA.add(sectionA.get(nA));//problme here , null pointer, invocation problem
//
//                nA = randA.nextInt(remainingA.size()) + 0;
//                refinedA.add(remainingA.get(nA));//problme here , null pointer, invocation problem
//                remainingA.remove(nA);
//
//            }

              for (int i = 0; i < numOfQuesAP1; i++) {
                nA = randA.nextInt(priority1.size()) + 0;
                refinedA.add(priority1.get(nA));//problme here , null pointer, invocation problem
                remainingA.remove(nA);
                priority1.remove(nA);
              }
              for (int i = 0; i < numOfQuesAP2; i++) {
                nA = randA.nextInt(priority2.size()) + 0;
                refinedA.add(priority2.get(nA));//problme here , null pointer, invocation problem
                remainingA.remove(nA);
                priority2.remove(nA);
              }
              for (int i = 0; i < numOfQuesAP3; i++) {
                nA = randA.nextInt(priority3.size()) + 0;
                refinedA.add(priority3.get(nA));//problme here , null pointer, invocation problem
                remainingA.remove(nA);
                priority3.remove(nA);
              }
              
              
              
//            System.out.println(sectionA.get(0));
//            System.out.println(randA.nextInt(sectionA.size()) + 1);
            // refinedA.add(sectionA.get(0));
            //refinedA.add(0,sectionA.get(0) );
            //  settingA.getNumberOfQuestions();
//            Collections.sort(sectionA, (ChemstryC8 o1, ChemstryC8 o2) -> {
//
//                return o1.getPriority() < o2.getPriority() ? -1 : o1.getPriority() == o2.getPriority() ? 0 : 1;
//            }
//            );
//            sectionA.forEach((sectionA1) -> {
//                System.out.println(sectionA1.getPriority());
//            });
            //  String yearsUsd = ""; //last year: 1 ,2 ,3 ,4 ,5    //not used for class 1 to 8
            //  boolean usedLastyearPercentage = false;   //not used for class 1 to 8
            //Date currentYear= new Date();
            /// int year = Year.now().getValue();
            //  year--;
            //   sectionA.forEach((sectionA1) -> {
//                System.out.println(sectionA1.getPriority());
//            if(sectionA1.getPriority()== priorA1 ){
//            
//              //  if(){
//                
//               // }
//            
//            }
            //sectionA1
            //     });
            
            
            //Section B logic
            System.out.println("SECTION B");

            if (settingB == null) {

                settingB = defaultSettingsB(clas, subjet, qurter);

            }
// if (!sectionB.isEmpty()){
            sectionB = sectionB(clas, subjet, qurter);
            List<ChemstryC8> refinedB = new ArrayList();
            remainingB = sectionB;

            Random randB = new Random();
            int nB;

            for (int i = 0; i < settingB.getNumberOfQuestions(); i++) {
                //  settingB.getNumberOfQuestions();
//                nB = randB.nextInt(sectionB.size()) + 0;
//                refinedB.add(sectionB.get(i));//problme here , null pointer, invocation problem
                // remainingB.remove(nB);
                nB = randB.nextInt(remainingB.size()) + 0;
                refinedB.add(remainingB.get(nB));//problme here , null pointer, invocation problem
                remainingB.remove(nB);
            }

//            Collections.sort(sectionB, (ChemstryC8 o1, ChemstryC8 o2) -> {
//
//                return o1.getPriority() < o2.getPriority() ? -1 : o1.getPriority() == o2.getPriority() ? 0 : 1;
//            });
//
//            sectionB.forEach((sectionB1) -> {
//                System.out.println(sectionB1.getPriority());
//            });

 
//SectionC logic
            if (settingC == null) {

                settingC = defaultSettingsC(clas, subjet, qurter);

            }
            

            List<ChemstryC8> sectionC = sectionC(clas, subjet, qurter);

            List<ChemstryC8> refinedC = new ArrayList(); //problem problem 
            remainingC = sectionC;

            Random randC = new Random();
            int nC;

            for (int i = 0; i < settingC.getNumberOfQuestions(); i++) {
//                nC = randC.nextInt(sectionC.size()) + 0;
//                refinedC.add(sectionC.get(i));
                // refinedC.add(sectionC.get(i));//problme here , null pointer, invocation problem
                //remainingC.remove(nC);
                nC = randC.nextInt(remainingC.size()) + 0;
                refinedC.add(remainingC.get(nC));//problme here , null pointer, invocation problem
                remainingC.remove(nC);
            }

            populateTable(refinedA, refinedB, refinedC);

        } catch (IOException | NoSuchFieldException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List sectionA(String clas, String subjet, String qurter) {

        return dao.getChemDat(clas, "A", qurter, subjet);

    }

    public List sectionB(String clas, String subjet, String qurter) {

        return dao.getChemDat(clas, "B", qurter, subjet);

    }

    public List sectionC(String clas, String subjet, String qurter) {

        return dao.getChemDat(clas, "C", qurter, subjet);

    }

    @FXML
    public void cleanChoices() {
        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        choice5.setText("");
    }

    public Settings defaultSettingsA(String clas, String subjet, String qurter) {
        Settings setting = new Settings();
        if ("Class 8".equals(clas) && "Chemstry".equals(subjet) && "First".equals(qurter)) {
            setting.setNumberOfQuestions(10);
            setting.setPriorityPercent1(70);
            setting.setPriorityPercent2(20);
            setting.setPriorityPercent3(10);

        }

        return setting;

    }

    public Settings defaultSettingsB(String clas, String subjet, String qurter) {
        Settings setting = new Settings();
        if ("Class 8".equals(clas) && "Chemstry".equals(subjet) && "First".equals(qurter)) {
            setting.setNumberOfQuestions(14);
            setting.setPriorityPercent1(70);
            setting.setPriorityPercent2(20);
            setting.setPriorityPercent3(10);

        }

        return setting;

    }

    public Settings defaultSettingsC(String clas, String subjet, String qurter) {
        Settings setting = new Settings();
        if ("Class 8".equals(clas) && "Chemstry".equals(subjet) && "First".equals(qurter)) {
            setting.setNumberOfQuestions(6);
            setting.setPriorityPercent1(70);
            setting.setPriorityPercent2(20);
            setting.setPriorityPercent3(10);

        }

        return setting;

    }

}

//            System.out.println("new form menu is pressed");
//
//            stg = new Stage();
//            stg.initModality(Modality.APPLICATION_MODAL);
//
//            try {
//                newWindowLoader.setLocation(getClass().getResource("/fxml/NewWindow.fxml"));
//
//                Parent root2 = newWindowLoader.load();
//                Scene scene2 = new Scene(root2);
//
//                stg.resizableProperty().setValue(Boolean.FALSE);
//                stg.setScene(scene2);
//                stg.showAndWait();
//
//            } catch (IOException ex) {
//                Logger.getLogger(JavaFXFirst.class.getName()).log(Level.SEVERE, null, ex);
//            }
