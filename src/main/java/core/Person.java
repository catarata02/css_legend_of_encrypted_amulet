package core;

import com.twilio.type.PhoneNumber;

import java.time.LocalDate;
import java.util.Objects;

public class Person {
    private String lastName;
    private String firstName;
    private String eMail;
    private LocalDate dateOfBirth;

    public Person(String lastName, String firstName, LocalDate dateOfBirth, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.eMail = email;
        this.dateOfBirth = dateOfBirth;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEMail() {
        return eMail;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return lastName.equals(person.lastName) &&
                firstName.equals(person.firstName) &&
                eMail.equals(person.eMail) &&
                dateOfBirth.equals(person.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, eMail, dateOfBirth);
    }

    public PhoneNumber getNumber() {
        return null;
    }
}