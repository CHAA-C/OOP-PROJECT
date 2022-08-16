package com.example.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;


public class HelloController<i> implements Initializable {

    @FXML
    private Label btnClose;     //  ปุ่มปิด

    @FXML
    private Button btnHERE;     // ปุ่มโง่ๆไว้ไปหน้ากรอกข้อมูล


    @FXML
    private TextField tfSEARCH;     // SEARCH BAR

    @FXML
    public TableView<User> tableView;

    @FXML
    public TableColumn<User, String> userCOVID;    // USER COVID STATUS COLUMN

    @FXML
    public TableColumn<User, String> userEMAIL;    // USER EMAIL COLUMN

    @FXML
    public TableColumn<User, Integer> userID;   // USER ID STATUS COLUMN

    @FXML
    public TableColumn<User, String> userNAME;     //  USER NAME COLUMN

    @FXML
    public TableColumn<User, String> userSURNAME;  //  USER SURNAME COLUMN

    @FXML
    void btnCloseClicked(MouseEvent event) {    //  Event ปุ่มกดปิด

        if( event.getSource() == btnClose )
        {
            System.exit(0);
        }

    }

    @FXML
    void btnHEREClicked(ActionEvent event) throws IOException {     //  Event ปุ่มไปหน้ากรอกข้อมูล

        Parent root = FXMLLoader.load(getClass().getResource("userFill.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }








    int a = 1;
    String b = "Name";
    String c = "Surname";
    String d = "mail@email";
    String e = "Status";



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try(Scanner scan = new Scanner(new File("UserFile.txt"))) {
            while (scan.hasNextLine()){
                String[] data = scan.nextLine().split(",");
                observableList.add(new User(data[0],data[1],data[2],data[4],data[3]));
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        userID.setCellValueFactory(new PropertyValueFactory<>("UserID"));
        userCOVID.setCellValueFactory(new PropertyValueFactory<>("UserCOVID"));
        userEMAIL.setCellValueFactory(new PropertyValueFactory<>("UserEMAIL"));
        userNAME.setCellValueFactory(new PropertyValueFactory<>("UserNAME"));
        userSURNAME.setCellValueFactory(new PropertyValueFactory<>("UserSURNAME"));
        tableView.setItems(observableList);

        // Search Bar

        FilteredList<User> filteredData = new FilteredList<>(observableList,h -> true);
        tfSEARCH.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(user -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }

                //compare first name and last name
                String lowerCaseFilter = newValue.toLowerCase();

                if(user.getUserNAME().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(user.getUserSURNAME().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(user.getUserCOVID().toLowerCase().indexOf(lowerCaseFilter) != -1)
                    return true;
                else
                    return false;
            });
        });

        SortedList<User> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(tableView.comparatorProperty());

        tableView.setItems(sortedData);

    }


    ObservableList<User>observableList= FXCollections.observableArrayList();

}
