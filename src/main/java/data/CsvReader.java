package data;

import core.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader implements Reader {

    @Override
    public List<Person> readPersons(String filename) {
        String line;
        String csvSplitBy = ",";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        List<Person> personList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(csvSplitBy);
                LocalDate dateOfBirth = null;
                try {
                    dateOfBirth = LocalDate.parse(values[2].trim(), formatter);
                } catch (DateTimeParseException e) {
                    System.out.println("Das Datum konnte nicht geparst werden: " + e.getMessage());
                }
                personList.add(new Person(values[0].trim(), values[1].trim(), dateOfBirth, values[3].trim()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personList;
    }
}