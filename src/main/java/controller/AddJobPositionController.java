package controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import ucr.laboratorio5.HelloApplication;

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

    @javafx.fxml.FXML
    public void initialize() {
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

}