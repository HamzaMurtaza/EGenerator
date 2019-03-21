package controllers;

import beans.ChemstryC8;
import static controllers.MainController.SERIALIZED_MIME_TYPE;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import main.MainWindow;
import main.SwapWindow;

public class SwapController implements Initializable {

    @FXML
    private TableView<ChemstryC8> tableC;

    @FXML
    private Button buttonCancel;

    @FXML
    private TableView<ChemstryC8> tableB;

    @FXML
    private TableView<ChemstryC8> tableA;

    @FXML
    private Tab tabC;

    @FXML
    private TableView<ChemstryC8> tableSwap;

    @FXML
    private Tab tabA;

    @FXML
    private Button buttonOk;

    @FXML
    private Tab tabB;

    @FXML
    private Button buttonSwap;

    @FXML
    private TextField choice3;

    @FXML
    private TextField choice4;

    @FXML
    private TextField choice1;

    @FXML
    private TextField choice2;
    @FXML
    private TextField choice5;

    //private DataFormat SERIALIZED_MIME_TYPE1 = 
    // DataFormat fd= new DataFormat();
    public ObservableList<ChemstryC8> swapTableA = observableArrayList();
    public ObservableList<ChemstryC8> swapTableB = observableArrayList();
    public ObservableList<ChemstryC8> swapTableC = observableArrayList();

    public ObservableList<ChemstryC8> swapTableADefault = observableArrayList();
    public ObservableList<ChemstryC8> swapTableBDefault = observableArrayList();
    public ObservableList<ChemstryC8> swapTableCDefault = observableArrayList();

    public ObservableList<ChemstryC8> tableList = observableArrayList();

    List<ChemstryC8> swapTableListA;
    List<ChemstryC8> swapTableListB;
    List<ChemstryC8> swapTableListC;

    ObservableList<ChemstryC8> tableListA;
    ObservableList<ChemstryC8> tableListB;
    ObservableList<ChemstryC8> tableListC;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //changing the content of tableSwap on the selected tab
        tabA.setOnSelectionChanged(e -> {
            tableSwap.setItems(swapTableA); //they become one here
            cleanChoices();

        });
        tabB.setOnSelectionChanged(e -> {
            tableSwap.setItems(swapTableB);
            cleanChoices();
        });
        tabC.setOnSelectionChanged(e -> {
            tableSwap.setItems(swapTableC);
            cleanChoices();
        });

        // setting Section A default values along with event handling for choices
        tableListA = MainWindow.myControllerHandle.table1.getItems();

        TableColumn secAcolA1 = (TableColumn) tableA.getColumns().get(0);
        secAcolA1.setCellValueFactory(new PropertyValueFactory("id"));
        TableColumn secAcolA2 = (TableColumn) tableA.getColumns().get(1);
        secAcolA2.setCellValueFactory(new PropertyValueFactory("question"));
         TableColumn secAcolA3 = (TableColumn) tableA.getColumns().get(2);
        secAcolA3.setCellValueFactory(new PropertyValueFactory("description"));
        
        
        swapTableADefault.addAll(tableListA);
        tableA.setItems(tableListA); //they become one here as well ,
        //which explains why it changes the list in live time, and maybe there is a refersh thing in these table
        //which is refreshed when the observable list changes
        tableA.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

            ChemstryC8 item = tableA.getSelectionModel().getSelectedItem();

            if (item.getChoice1() != null) {
                choice1.setText(item.getChoice1());
            }
            if (item.getChoice2() != null) {
                choice2.setText(item.getChoice2());
            }
            if (item.getChoice3() != null) {
                choice3.setText(item.getChoice3());
            }
            if (item.getChoice4() != null) {
                choice4.setText(item.getChoice4());
            }
            if (item.getChoice5() != null) {
                choice5.setText(item.getChoice5());
            }

        });

        // setting Section B default values along with event handling for choices
        tableListB = MainWindow.myControllerHandle.table2.getItems();

        TableColumn secAcolB1 = (TableColumn) tableB.getColumns().get(0);
        secAcolB1.setCellValueFactory(new PropertyValueFactory("id"));
        TableColumn secAcolB2 = (TableColumn) tableB.getColumns().get(1);
        secAcolB2.setCellValueFactory(new PropertyValueFactory("question"));
             TableColumn secAcolB3 = (TableColumn) tableB.getColumns().get(2);
        secAcolB3.setCellValueFactory(new PropertyValueFactory("description"));
        swapTableBDefault.addAll(tableListB);
        tableB.setItems(tableListB);

        tableB.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

            ChemstryC8 item = tableB.getSelectionModel().getSelectedItem();

            if (item.getChoice1() != null) {
                choice1.setText(item.getChoice1());
            }
            if (item.getChoice2() != null) {
                choice2.setText(item.getChoice2());
            }
            if (item.getChoice3() != null) {
                choice3.setText(item.getChoice3());
            }
            if (item.getChoice4() != null) {
                choice4.setText(item.getChoice4());
            }
            if (item.getChoice5() != null) {
                choice5.setText(item.getChoice5());
            }

        });

        //settin Section C default values along with event handling for choices    
        tableListC = MainWindow.myControllerHandle.table3.getItems();

        TableColumn secAcolC1 = (TableColumn) tableC.getColumns().get(0);
        secAcolC1.setCellValueFactory(new PropertyValueFactory("id"));
        TableColumn secAcolC2 = (TableColumn) tableC.getColumns().get(1);
        secAcolC2.setCellValueFactory(new PropertyValueFactory("question"));
             TableColumn secAcolC3 = (TableColumn) tableC.getColumns().get(2);
        secAcolC3.setCellValueFactory(new PropertyValueFactory("description"));
        swapTableCDefault.addAll(tableListC);
        tableC.setItems(tableListC);

        tableC.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

            ChemstryC8 item = tableC.getSelectionModel().getSelectedItem();

            if (item.getChoice1() != null) {
                choice1.setText(item.getChoice1());
            }
            if (item.getChoice2() != null) {
                choice2.setText(item.getChoice2());
            }
            if (item.getChoice3() != null) {
                choice3.setText(item.getChoice3());
            }
            if (item.getChoice4() != null) {
                choice4.setText(item.getChoice4());
            }
            if (item.getChoice5() != null) {
                choice5.setText(item.getChoice5());
            }

        });

        //making list for sectionA remaining items (also converting from LIST to Observable List)
        swapTableListA = MainWindow.myControllerHandle.remainingA;
        int countA = 1;
        for (Iterator<ChemstryC8> it = swapTableListA.iterator(); it.hasNext();) {
            ChemstryC8 swapTableListA1 = it.next();
            swapTableListA1.setId(countA);
            swapTableA.add(swapTableListA1); //magic here
            countA++;
        }

        //making list for sectionB remaining items (also converting from LIST to Observable List)
        swapTableListB = MainWindow.myControllerHandle.remainingB;
        int countB = 1;
        for (Iterator<ChemstryC8> it = swapTableListB.iterator(); it.hasNext();) {
            ChemstryC8 swapTableListB1 = it.next();
            swapTableListB1.setId(countB);
            swapTableB.add(swapTableListB1);
            countB++;
        }

        //making list for sectionC remaining items (also converting from LIST to Observable List)
        swapTableListC = MainWindow.myControllerHandle.remainingC;
        int countC = 1;
        for (Iterator<ChemstryC8> it = swapTableListC.iterator(); it.hasNext();) {
            ChemstryC8 swapTableListC1 = it.next();
            swapTableListC1.setId(countC);
            swapTableC.add(swapTableListC1);
            countC++;
        }

        //Setting the tableSwap default items along with event handler for choices
        TableColumn secAcolS1 = (TableColumn) tableSwap.getColumns().get(0);
        secAcolS1.setCellValueFactory(new PropertyValueFactory("id"));
        TableColumn secAcolS2 = (TableColumn) tableSwap.getColumns().get(1);
        secAcolS2.setCellValueFactory(new PropertyValueFactory("question"));
             TableColumn secAcolS3 = (TableColumn) tableSwap.getColumns().get(2);
        secAcolS3.setCellValueFactory(new PropertyValueFactory("description"));

        tableSwap.setItems(swapTableA);

        tableSwap.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

            ChemstryC8 item = tableSwap.getSelectionModel().getSelectedItem();

            if (item.getChoice1() != null) {
                choice1.setText(item.getChoice1());
            }
            if (item.getChoice2() != null) {
                choice2.setText(item.getChoice2());
            }
            if (item.getChoice3() != null) {
                choice3.setText(item.getChoice3());
            }
            if (item.getChoice4() != null) {
                choice4.setText(item.getChoice4());
            }
            if (item.getChoice5() != null) {
                choice5.setText(item.getChoice5());
            }

        });

        //Setting the event handling for moving columns
        tableA.setRowFactory(tv -> {

            TableRow<ChemstryC8> row = new TableRow<>();

            row.setOnDragDetected(event -> {
                if (!row.isEmpty()) {
                    Integer index = row.getIndex();
                    Dragboard db = row.startDragAndDrop(TransferMode.MOVE);
                    db.setDragView(row.snapshot(null, null));
                    ClipboardContent cc = new ClipboardContent();
                    String table = "table A item";
                    cc.putString(table);
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
                    ChemstryC8 draggedPerson;

                    int dropIndex;

                    if (row.isEmpty()) {
                        dropIndex = tableA.getItems().size();
                    } else {
                        dropIndex = row.getIndex();
                    }

                    int count = 0;
                    if ("table swap item".equals(db.getString())) {

                        draggedPerson = tableSwap.getItems().remove(draggedIndex);
                        tableA.getItems().add(dropIndex, draggedPerson);
                        tableList = tableSwap.getItems();
                        // count = 0;
                        for (ChemstryC8 item : tableSwap.getItems()) {

                            tableList.get(count).setId(count + 1);
                            count++;
                        }

                    } else {
                        draggedPerson = tableA.getItems().remove(draggedIndex);
                        tableA.getItems().add(dropIndex, draggedPerson);
                    }

                    tableList = tableA.getItems();
                    count = 0;
                    for (ChemstryC8 item : tableA.getItems()) {

                        tableList.get(count).setId(count + 1);
                        count++;
                    }

                    event.setDropCompleted(true);
                    tableA.getSelectionModel().select(dropIndex);
                    event.consume();
                }
            });

            return row;

        });

        //Setting the event handling for moving columns
        tableB.setRowFactory(tv -> {

            TableRow<ChemstryC8> row = new TableRow<>();

            row.setOnDragDetected(event -> {
                if (!row.isEmpty()) {
                    Integer index = row.getIndex();
                    Dragboard db = row.startDragAndDrop(TransferMode.MOVE);
                    db.setDragView(row.snapshot(null, null));
                    ClipboardContent cc = new ClipboardContent();
                    String table = "table B item";
                    cc.putString(table);
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
                    ChemstryC8 draggedPerson;

                    int dropIndex;

                    if (row.isEmpty()) {
                        dropIndex = tableB.getItems().size();
                    } else {
                        dropIndex = row.getIndex();
                    }

                    int count = 0;
                    if ("table swap item".equals(db.getString())) {

                        draggedPerson = tableSwap.getItems().remove(draggedIndex);
                        tableB.getItems().add(dropIndex, draggedPerson);
                        tableList = tableSwap.getItems();
                        // count = 0;
                        for (ChemstryC8 item : tableSwap.getItems()) {

                            tableList.get(count).setId(count + 1);
                            count++;
                        }

                    } else {

                        draggedPerson = tableB.getItems().remove(draggedIndex);
                        tableB.getItems().add(dropIndex, draggedPerson);
                    }
                    tableList = tableB.getItems();
                    count = 0;
                    for (ChemstryC8 item : tableB.getItems()) {

                        tableList.get(count).setId(count + 1);
                        count++;
                    }

                    event.setDropCompleted(true);
                    tableB.getSelectionModel().select(dropIndex);
                    event.consume();
                }
            });

            return row;

        });

        //Setting the event handling for moving columns
        tableC.setRowFactory(tv -> {

            TableRow<ChemstryC8> row = new TableRow<>();

            row.setOnDragDetected(event -> {
                if (!row.isEmpty()) {
                    Integer index = row.getIndex();
                    Dragboard db = row.startDragAndDrop(TransferMode.MOVE);
                    db.setDragView(row.snapshot(null, null));
                    ClipboardContent cc = new ClipboardContent();
                    String table = "table C item";
                    cc.putString(table);
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
                    ChemstryC8 draggedPerson;

                    int dropIndex;

                    if (row.isEmpty()) {
                        dropIndex = tableC.getItems().size();
                    } else {
                        dropIndex = row.getIndex();
                    }

                    int count = 0;
                    if ("table swap item".equals(db.getString())) {

                        draggedPerson = tableSwap.getItems().remove(draggedIndex);
                        tableC.getItems().add(dropIndex, draggedPerson);
                        tableList = tableSwap.getItems();
                        // count = 0;
                        for (ChemstryC8 item : tableSwap.getItems()) {

                            tableList.get(count).setId(count + 1);
                            count++;
                        }

                    } else {

                        draggedPerson = tableC.getItems().remove(draggedIndex);
                        tableC.getItems().add(dropIndex, draggedPerson);
                    }

                    tableList = tableC.getItems();
                    count = 0;
                    for (ChemstryC8 item : tableC.getItems()) {

                        tableList.get(count).setId(count + 1);
                        count++;
                    }

                    event.setDropCompleted(true);
                    tableC.getSelectionModel().select(dropIndex);
                    event.consume();
                }
            });

            return row;

        });

        //Setting the event handling for moving columns
        tableSwap.setRowFactory(tv -> {

            TableRow<ChemstryC8> row = new TableRow<>();

            row.setOnDragDetected(event -> {
                if (!row.isEmpty()) {
                    Integer index = row.getIndex();
                    Dragboard db = row.startDragAndDrop(TransferMode.MOVE);
                    db.setDragView(row.snapshot(null, null));
                    ClipboardContent cc = new ClipboardContent();
                    cc.put(SERIALIZED_MIME_TYPE, index);
                    cc.putString("table swap item");
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
                    ChemstryC8 draggedPerson;

                    int dropIndex;

                    if (row.isEmpty()) {
                        dropIndex = tableSwap.getItems().size();
                    } else {
                        dropIndex = row.getIndex();
                    }
                    int count = 0;

                    if ("table A item".equals(db.getString())) {

                        draggedPerson = tableA.getItems().remove(draggedIndex);

                        tableSwap.getItems().add(dropIndex, draggedPerson);
                        tableList = tableA.getItems();
                        // count = 0;
                        for (ChemstryC8 item : tableA.getItems()) {

                            tableList.get(count).setId(count + 1);
                            count++;
                        }

                    } else if ("table B item".equals(db.getString())) {
                        draggedPerson = tableB.getItems().remove(draggedIndex);

                        tableSwap.getItems().add(dropIndex, draggedPerson);
                        tableList = tableB.getItems();
                        // count = 0;
                        for (ChemstryC8 item : tableB.getItems()) {

                            tableList.get(count).setId(count + 1);
                            count++;
                        }

                    } else if ("table C item".equals(db.getString())) {
                        draggedPerson = tableC.getItems().remove(draggedIndex);

                        tableSwap.getItems().add(dropIndex, draggedPerson);
                        tableList = tableC.getItems();
                        // count = 0;
                        for (ChemstryC8 item : tableC.getItems()) {

                            tableList.get(count).setId(count + 1);
                            count++;
                        }

                    } else {
                        draggedPerson = tableSwap.getItems().remove(draggedIndex);
                        tableSwap.getItems().add(dropIndex, draggedPerson);
                    }

//                    System.out.println(row.getTableView().idProperty().getValue());
                    tableList = tableSwap.getItems();
                    count = 0;
                    for (ChemstryC8 item : tableSwap.getItems()) {

                        tableList.get(count).setId(count + 1);
                        count++;
                    }

                    event.setDropCompleted(true);
                    tableSwap.getSelectionModel().select(dropIndex);
                    event.consume();
                }
            });

            return row;

        });

    }

    public void cleanChoices() {
        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        choice5.setText("");
    }

    //set an ok button and in that ok button make the values of remaingA,B,C set to the values in swapTableA,B,C
    @FXML
    void buttonHandler(ActionEvent event) {

        if (event.getSource() == buttonOk) {

            swapTableListA.clear();
            swapTableListA.addAll(swapTableA);

            swapTableListB.clear();
            swapTableListB.addAll(swapTableB);

            swapTableListC.clear();
            swapTableListC.addAll(swapTableC);

            SwapWindow.closeWindow();
        }
        if (event.getSource() == buttonCancel) {

            //every thing must remain same
//        swapTableCDefault
            tableListA.setAll(swapTableADefault);
            tableListB.setAll(swapTableBDefault);
            tableListC.setAll(swapTableCDefault);
            
            int count = 1;
            for (ChemstryC8 item : tableListA) {
                item.setId(count++);
            }
            count=1;
             for (ChemstryC8 item : tableListB) {
                item.setId(count++);
            }
            count=1;
              for (ChemstryC8 item : tableListC) {
                item.setId(count++);
            }

            SwapWindow.closeWindow();
        }
    }

}
