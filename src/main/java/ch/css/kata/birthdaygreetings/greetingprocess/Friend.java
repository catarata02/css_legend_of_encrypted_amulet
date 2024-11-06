package ch.css.kata.birthdaygreetings.greetingprocess;

import java.time.LocalDate;


public class Friend {

    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;
    private final String email;

    public Friend(String firstName, String lastName, LocalDate dateOfBirth, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }
}
