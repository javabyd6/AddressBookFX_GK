package pl.sda.addressbook.controller;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.sda.addressbook.controller.model.Person;

import java.io.IOException;


public class Main extends Application {

    private ObservableList <Person> personList = FXCollections.observableArrayList();


    public static void main(String[] args) {
        launch(args);
    }

    public Main() throws IOException {

//        personList.add(new Person("Jan", "Kowalski", "ul. Jakastam 12", "85-794", "523437291", "Bydgoszcz"));
//        personList.add(new Person("Bob", "Oklahoma", "ul. Inna 13", "85-666", "523437291", "Toruń"));
//        personList.add(new Person("Tom", "Smith", "ul. JeszczeInsza 13", "85-666", "523437291", "Toruń"));

    Parser parser = new Parser();
    parser.readFile(personList);


    }

    public ObservableList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ObservableList<Person> personList) {
        this.personList = personList;
    }

    public void start (Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/root.fxml"));

        loader.load();
        Parent root = loader.getRoot();
        RootViewController rootViewController = loader.getController();
        rootViewController.setMain(this);
        rootViewController.loadPerson();

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}
