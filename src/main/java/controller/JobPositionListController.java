package controller;

import domain.CircularDoublyLinkedList;
import domain.JobPosition;
import domain.ListException;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import ucr.laboratorio5.HelloApplication;
import util.Utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JobPositionListController {
    @FXML
    private BorderPane bp;

    @FXML
    private TableView<List<String>> jobOptionTableView;

    @FXML
    private TableColumn<List<String>, String> descriptionTableColumn;

    @FXML
    private TableColumn<List<String>, String> hourlyWageTableColumn;

    @FXML
    private TableColumn<List<String>, String> idTableColumn;

    @FXML
    private TableColumn<List<String>, String> monthlyWageTableColumn;

    @FXML
    private TableColumn<List<String>, String> totalHoursTableColumn;
    CircularDoublyLinkedList jobPositionList;

    Alert alert;

    @FXML
    public void initialize() {
        //Carga la lista
        this.jobPositionList = util.Utility.getJobPositionList();
        this.idTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<List<String>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyObjectWrapper<>(data.getValue().get(0));
            }
        });
        this.descriptionTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<List<String>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyObjectWrapper<>(data.getValue().get(1));
            }
        });
        this.hourlyWageTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<List<String>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyObjectWrapper<>(data.getValue().get(2));
            }
        });
        this.totalHoursTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<List<String>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyObjectWrapper<>(data.getValue().get(3));
            }
        });
        this.monthlyWageTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<List<String>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyObjectWrapper<>(data.getValue().get(4));
            }
        });
        alert = util.FXUtility.alert("Job position List", "Display");
        alert.setAlertType(Alert.AlertType.ERROR);
        alert.showAndWait();
        //Lleno el table con los datos de la lista
        if (this.jobPositionList != null && this.jobPositionList.isEmpty()) {
            this.jobOptionTableView.setItems(getData());
        }

    }

    private ObservableList<List<String>> getData() {
        ObservableList<List<String>> data = FXCollections.observableArrayList();
        try {
            int n = this.jobPositionList.size();
            for (int i = 1; i <= n; i++) {
                JobPosition jp = (JobPosition) this.jobPositionList.getNode(i).data;
                int hours = util.Utility.random(40, 50);
                double mWage = jp.getSalary(hours);
                //defino un objeto tipo List<String>
                List<String> arrayList = new ArrayList<>();
                arrayList.add(String.valueOf(jp.getId()));
                arrayList.add(jp.getDescription());
                arrayList.add(String.valueOf(jp.getHourlyWage()));
                arrayList.add(String.valueOf(hours));
                arrayList.add("$" + util.Utility.format(mWage));
                //al final agregamos el arrayList a ObservableList<List<String>> data
                data.add(arrayList);
            }
        } catch (ListException e) {
            alert.setContentText("There was an error in the process");
            alert.showAndWait();
        }
        return data;
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
