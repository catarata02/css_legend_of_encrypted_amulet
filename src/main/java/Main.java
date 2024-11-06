import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import core.BirthdayGreetings;
import data.CsvReader;
import sender.EMailSender;

import java.time.LocalDate;


public class Main {

    public static void main(String[] args) {
        System.out.println("Geburtstagserinnerungssoftware!");

        BirthdayGreetings birthdayGreetings = new BirthdayGreetings(new CsvReader(), new EMailSender(), LocalDate.now());
        int notified = birthdayGreetings.birthdayGreetings("src/main/resources/freunde.csv");

        System.out.println("Es wurden: " + notified + " benachrichtigt");
    }


}
