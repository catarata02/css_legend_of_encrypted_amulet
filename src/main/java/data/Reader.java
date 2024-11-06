package data;

import core.Person;

import java.util.List;

public interface Reader {
    List<Person> readPersons(String filename);
}
