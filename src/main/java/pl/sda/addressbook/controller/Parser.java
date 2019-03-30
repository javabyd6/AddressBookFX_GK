package pl.sda.addressbook.controller;

import javafx.collections.ObservableList;
import pl.sda.addressbook.controller.model.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Parser {

    private Path file = Paths.get("D:\\_SDA_JAVA\\AddressBook\\src\\main\\resources\\file.csv");

    public ObservableList <Person> readFile(ObservableList<Person> personList) {

        try
        {
            List<String> lista = Files.readAllLines(file);

            for (int i = 1 ; i < lista.size() ; i++)
            {
                String[] split = lista.get(i).split(",");
                personList.add(new Person( split[0],split[1],split[2],split[3],split[4],split[5]));

            }


        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return personList;
    }



}
