package pl.sda.addressbook.controller;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.sda.addressbook.controller.model.Person;

public class Main extends Application {

    private ObservableList <Person> personList = FXCollections.observableArrayList();


    public static void main(String[] args) {
        launch(args);
    }

    public Main() {

        personList.add(new Person("Jan", "Kowalski", "ul. Jakastam 12", "85-794", "523437291", "Bydgoszcz"));
        personList.add(new Person("Bob", "Oklahoma", "ul. Inna 13", "85-666", "523437291", "Toruń"));
        personList.add(new Person("Tom", "Smith", "ul. JeszczeInsza 13", "85-666", "523437291", "Toruń"));

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

//        Parent root = FXMLLoader.load(getClass().getResource("/root.fxml"));

        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

}
