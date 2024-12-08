package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import Model.Album;

public class InventoryController {
  @FXML
    private TableView<Album> albumTable;

    @FXML
    private TableColumn<Album, String> colAlbumName;

    @FXML
    private TableColumn<Album, String> colArtist;

    @FXML
    private TableColumn<Album, Integer> colTotal;

    @FXML
    private TableColumn<Album, Integer> colAvailable;

    @FXML
    private TextField txtAlbumName;

    @FXML
    private TextField txtArtist;

    @FXML
    private TextField txtTotal;

    @FXML
    private TextField txtAvailable;

    private ObservableList<Album> albums = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        colAlbumName.setCellValueFactory(new PropertyValueFactory<>("albumName"));
        colArtist.setCellValueFactory(new PropertyValueFactory<>("artist"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        colAvailable.setCellValueFactory(new PropertyValueFactory<>("available"));
        albumTable.setItems(albums);
    }

    @FXML
    void onAddButtonClick() {
        try {
            String albumName = txtAlbumName.getText();
            String artist = txtArtist.getText();
            int total = Integer.parseInt(txtTotal.getText());
            int available = Integer.parseInt(txtAvailable.getText());

            albums.add(new Album(albumName, artist, total, available));

            showAlert("Success", "Album added successfully!");
        } catch (NumberFormatException e) {
            showError("Invalid input! Please enter correct data.");
        }
    }

    @FXML
    void onDeleteButtonClick() {
        Album selectedAlbum = albumTable.getSelectionModel().getSelectedItem();
        if (selectedAlbum != null) {
            albums.remove(selectedAlbum);
            showAlert("Success", "Album deleted successfully!");
        } else {
            showError("No album selected!");
        }
    }

    @FXML
    void onUpdateButtonClick() {
        Album selectedAlbum = albumTable.getSelectionModel().getSelectedItem();
        if (selectedAlbum != null) {
            try {
                selectedAlbum.setAlbumName(txtAlbumName.getText());
                selectedAlbum.setArtist(txtArtist.getText());
                selectedAlbum.setTotal(Integer.parseInt(txtTotal.getText()));
                selectedAlbum.setAvailable(Integer.parseInt(txtAvailable.getText()));

                albumTable.refresh();
                showAlert("Success", "Album updated successfully!");
            } catch (NumberFormatException e) {
                showError("Invalid input! Please enter correct data.");
            }
        } else {
            showError("No album selected!");
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Input Error");
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}