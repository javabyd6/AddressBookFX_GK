package pl.sda.addressbook.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pl.sda.addressbook.controller.model.Person;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RootViewController implements Initializable {

    @FXML
    private TableView <Person> personTableView;

    @FXML
    private TableColumn <Person, String> nameCol;

    @FXML
    private TableColumn <Person, String> lastNameCol;

    @FXML
    private Label name;

    @FXML
    private Label lastName;

    @FXML
    private Label address;

    @FXML
    private Label postalCode;

    @FXML
    private Label telephoneNumber;

    @FXML
    private Label city;

    @FXML
    private Button newPerson;

    @FXML
    private Button edit;

    @FXML
    private Button delete;

    @FXML
    private Button save;

    private Main main;

    private Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void loadPerson(){
        System.out.println(getMain().getPersonList());
        personTableView.setItems(getMain().getPersonList());
        nameCol.setCellValueFactory(c -> c.getValue().nameProperty());
        lastNameCol.setCellValueFactory(c -> c.getValue().lastNameProperty());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        System.out.println(this.main.getPersonList());
    }

    public Person selectedPerson() {
        Person person = personTableView.getSelectionModel().getSelectedItem();
        name.setText(person.getName());
        lastName.setText(person.getLastName());
        address.setText(person.getAddress());
        postalCode.setText(person.getPostalCode());
        telephoneNumber.setText(person.getTelephoneNumber());
        city.setText(person.getCity());
        System.out.println(person);
        return person;
    }


    public void addNewPerson() throws Exception {
        Stage secondStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/addNew.fxml"));
        loader.load();

        Parent root = loader.getRoot();
        AddNewController newPersonViewController = loader.getController();
        newPersonViewController.setMain(main);

        secondStage.setScene(new Scene(root));
        secondStage.show();
    }

    public void deletePerson() {
        main.getPersonList().remove(selectedPerson());

    }


    public void edit(MouseEvent mouseEvent) throws IOException {
        Stage thirdStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/EditViewController.fxml"));
        loader.load();

        Parent root = loader.getRoot();
        EditViewController editViewController = loader.getController();
        editViewController.setMain(main);

        thirdStage.setScene(new Scene(root));
        thirdStage.show();


    }
}