package sender;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import core.Person;


import java.util.List;

public class SmsSender implements Sender {    // Ersetze diese Werte durch deine Twilio-Konto-SID und Auth-Token
    public static final String ACCOUNT_SID = "your_account_sid";
    public static final String AUTH_TOKEN = "your_auth_token";
    public static final String SENDER_NUMBER = "+041234567890";

    public boolean sendMessage(List<Person> persons) {        // Initialisiere Twilio mit deiner Konto-SID und Auth-Token
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        for (Person person : persons) {            // Erstelle und sende die SMS
            Message message = Message.creator(person.getNumber(), // Empfänger-Telefonnummer
                    SENDER_NUMBER, // Deine Twilio-Telefonnummer
                    "Happy birthday, dear " + person.getFirstName() + "!").create();
            System.out.println("SMS gesendet mit SID: " + message.getSid());
        }        // Ausgabe der Nachricht SID
        return true;
    }
}