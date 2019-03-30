package pl.sda.addressbook.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.sda.addressbook.controller.model.Person;

import java.net.URL;
import java.util.ResourceBundle;

public class AddNewController implements Initializable {

    @FXML
    private TextField newName;
    @FXML
    private TextField newLastName;
    @FXML
    private TextField newAddress;
    @FXML
    private TextField newTelephoneNumber;
    @FXML
    private TextField newPostalCode;
    @FXML
    private TextField newCity;

    @FXML
    private Button newSaveButton;
    @FXML
    private Button newCancelButton;

    private Main main;

    private Main getMain() {
        return main;
    }

    void setMain(Main main) {
        this.main = main;
    }

    public void saveNewPerson(){
        Person person = new Person(newName.getText(), newLastName.getText(), newAddress.getText(), newTelephoneNumber.getText(), newPostalCode.getText(),newCity.getText());
        main.getPersonList().add(person);
        Stage stage = (Stage) newSaveButton.getScene().getWindow();
        stage.close();
    }
    public void escape(){
        Stage stage = (Stage) newCancelButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}