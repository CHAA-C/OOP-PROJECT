package com.example.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class userFillController {

    @FXML
    private Button btnBACK;     //  ปุ่มกลับไปหน้าหาข้อมูล


    @FXML
    private Label btnClose;     //  ปุ่มปิด

    @FXML
    private Label PleaseEnterAllDetail;

    @FXML
    private Button btnDONE;     //  ปุ่มยืนยันเพื่อกรอกข้อมูลลง Text file

    @FXML
    private TextField tfCOVID;  //  ช่องกรอกสถานะ

    @FXML
    private TextField tfEMAIL;  //  ช่องกรอก EMAIL

    @FXML
    private TextField tfID;     // ช่องกรอก ID

    @FXML
    private TextField tfName;   //  ช่องกรอกชื่อ

    @FXML
    private TextField tfSURNAME;    //  ช่องกรอกนามสกุล

    @FXML
    void btnBACKClicked(ActionEvent event) throws IOException {     //  Event ปุ่มกลับไปหน้าหาข้อมูล

        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void btnCloseClicked(MouseEvent event) {    //  Event ปุ่มปิด

        if( event.getSource() == btnClose )
        {
            System.exit(0);
        }

    }

    @FXML
    void btnDONEClicked(ActionEvent event) throws IOException {    //  Event ปุ่มยืนยันการกรอกข้อมูล

        if(tfID.getText().isEmpty() || tfName.getText().isEmpty() || tfSURNAME.getText().isEmpty() || tfEMAIL.getText().isEmpty() || tfCOVID.getText().isEmpty()){
            System.out.println("Please Enter the empty text");
            PleaseEnterAllDetail.setTextFill(Color.RED);
        }else{
            FileWriter file = new FileWriter("UserFile.txt",true);
            BufferedWriter b = new BufferedWriter(file);
            b.write(tfID.getText()+","+tfName.getText()+","+tfSURNAME.getText()+","+tfEMAIL.getText()+","+tfCOVID.getText());
            b.newLine();
            b.close();
            file.close();

            Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }


    }

}
