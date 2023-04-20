package controller;

import domain.CircularDoublyLinkedList;
import domain.JobPosition;
import domain.ListException;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import ucr.laboratorio5.HelloApplication;
import util.Utility;

import java.io.IOException;

public class AddJobPositionController {
    @javafx.fxml.FXML
    private BorderPane bp;
    @javafx.fxml.FXML
    private TextField txtJobPositionID;
    @javafx.fxml.FXML
    private TextField txtDescription;
    @javafx.fxml.FXML
    private TextField txtHourlyWage;

    CircularDoublyLinkedList jobPositionList;
    Alert alert;

    @javafx.fxml.FXML
    public void initialize() {
        //Carga la lista
        this.jobPositionList = Utility.getJobPositionList();
        this.txtJobPositionID.setText(String.valueOf(getMaxID(jobPositionList)));
        txtJobPositionID.setEditable(false);
    }

    private int getMaxID(CircularDoublyLinkedList jobPositionList) {
        int maxValue = 0;
        try {
            int n = jobPositionList.size();
            for (int i = 1; i <= n; i++) {
                JobPosition jp = (JobPosition) jobPositionList.getNode(i).data;
                if(maxValue<jp.getId()){
                    maxValue = jp.getId();
                }
            }
        } catch (ListException e) {
            System.out.println(e.getMessage());
        }
        return maxValue + 1;
    }

    private void loadPage(String page) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(page));
        try {
            this.bp.setCenter(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnAdd(ActionEvent event) {
        if (isValid()) {
            Double hourlyWage = Double.parseDouble(
                    this.txtHourlyWage.getText()
            );
            String name = this.txtDescription.getText();
            int id = Integer.parseInt(this.txtJobPositionID.getText());
            if (this.jobPositionList!=null){
                this.jobPositionList.add(new JobPosition(name,hourlyWage));
                alert.setAlertType(Alert.AlertType.INFORMATION);
                alert.setContentText("Jop Position was added to the list");
                //Actualizo la lista global
                util.Utility.setJobPositionList(this.jobPositionList);
                alert.showAndWait();
                this.txtJobPositionID.getText();
                this.txtDescription.clear();
                this.txtHourlyWage.clear();
            }
        }
    }

    @FXML
    void btnClean(ActionEvent event) {
        txtDescription.clear();
        txtJobPositionID.clear();
        txtHourlyWage.clear();
    }

    @FXML
    void btnCloseOnAction(ActionEvent event) {
        loadPage("jobPositionList.fxml");
    }

    @FXML
    void onKeyTypeCreditsValidation(KeyEvent event) {

    }

    private boolean isValid() {
        return !this.txtJobPositionID.getText().isEmpty();
    }

}