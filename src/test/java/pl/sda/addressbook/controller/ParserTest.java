package pl.sda.addressbook.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.*;
import org.junit.Test;
import pl.sda.addressbook.controller.model.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class ParserTest {


    //teraz test jest zalezny od konkretnego pliku, lepiej by bylo przebudowac tak zeby dzialal jakos na obiektach

    private Path file = Paths.get("D:\\_SDA_JAVA\\AddressBook\\src\\main\\resources\\test_file.csv");
    private ObservableList<Person> personList = FXCollections.observableArrayList();
    private ObservableList<Person> testPersonList = FXCollections.observableArrayList();

    List<String> listaTestowa = Files.readAllLines(file);
    Parser parser = new Parser();


    public ParserTest() throws IOException {

        for (int i = 1 ; i < listaTestowa.size() ; i++)
        {
            String[] split = listaTestowa.get(i).split(",");
            testPersonList.add(new Person( split[0],split[1],split[2],split[3],split[4],split[5]));
        }
    }


    @Test
    public void dataAccuracyName () {

           for (int i = 1; i < listaTestowa.size()-1; i++) {
            Assertions.assertEquals(testPersonList.get(i).getName(), parser.readFile(personList).get(i).getName() );
        }
    }

    @Test
    public void dataAccuracyLastName () {

        for (int i = 1; i < listaTestowa.size()-1; i++) {
            Assertions.assertEquals(testPersonList.get(i).getLastName(), parser.readFile(personList).get(i).getLastName() );
        }
    }


}