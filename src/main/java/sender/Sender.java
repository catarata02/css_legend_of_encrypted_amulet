package sender;

import core.Person;

import java.util.List;

public interface Sender {
    public boolean sendMessage(List<Person> persons);
}
