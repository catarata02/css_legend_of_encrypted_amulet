package core;

import data.Reader;
import sender.Sender;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

public class BirthdayGreetings {

    Reader reader;
    Sender sender;
    LocalDate today;

    public BirthdayGreetings(Reader reader, Sender sender, LocalDate today) {
        this.reader = reader;
        this.sender = sender;
        this.today = today;
    }

    public int birthdayGreetings(String filename) {
        List<Person> freunde = reader.readPersons(filename);
        List<Person> notify = toNotify(freunde);
        sender.sendMessage(notify);
        return notify.size();
    }

    private List<Person> toNotify(List<Person> freunde) {
        return freunde.stream().filter(this::hasBirthday).collect(Collectors.toList());
    }

    private boolean hasBirthday(Person person) {
        boolean hasBirthday = false;
        Month month = person.getDateOfBirth().getMonth();
        int day = person.getDateOfBirth().getDayOfMonth();

        if(today.getMonth().equals(Month.FEBRUARY) && today.getDayOfMonth() == 28) {
            hasBirthday = today.getMonth().equals(month) && 29 == day;
        }
        return hasBirthday || today.getMonth().equals(month) && today.getDayOfMonth() == day;
    }
}
