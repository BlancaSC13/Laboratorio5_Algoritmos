package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import ucr.laboratorio5.HelloApplication;

import java.io.IOException;

public class JobPositionListController {
    @FXML
    private BorderPane bp;

    @FXML
    private TableView courseTableView;

    @FXML
    private TableColumn descriptionTableColumn;

    @FXML
    private TableColumn hourlyWageTableColumn;

    @FXML
    private TableColumn idTableColumn;

    @FXML
    private TableColumn monthlyWageTableColumn;

    @FXML
    private TableColumn totalHoursTableColumn;

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
    void addSortByName(ActionEvent event) {

    }

    @FXML
    void btClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        loadPage("addJobPosition.fxml");
    }

    @FXML
    void btnContainsOnAction(ActionEvent event) {

    }

    @FXML
    void btnGetNextOnAction(ActionEvent event) {

    }

    @FXML
    void btnGetPrevOnAction(ActionEvent event) {

    }

    @FXML
    void btnRemoveLastOnAction(ActionEvent event) {

    }

    @FXML
    void btnRemoveOnAction(ActionEvent event) {

    }

    @FXML
    void btnSizeOnAction(ActionEvent event) {

    }

    @FXML
    void btnSortByHour(ActionEvent event) {

    }

}
