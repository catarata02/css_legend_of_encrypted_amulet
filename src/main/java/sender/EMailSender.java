package sender;

import core.Person;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

public class EMailSender implements Sender {
    private static final String USERNAME = "your-email@gmail.com";
    private static final String PASSWORD = "your-email-password";

    @Override
    public boolean sendMessage(List<Person> persons) {
        Properties smtpProperties = getSmtpProperties();        // Erstelle eine Session mit Authentifizierung
        Session session = Session.getInstance(smtpProperties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });
        for (Person person : persons) {
            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(USERNAME));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(person.getEMail()));
                message.setSubject("Happy Birthday");
                message.setText("Happy birthday, dear " + person.getFirstName() + "!");                // Sende die E-Mail
                Transport.send(message);
                System.out.println("E-Mail wurde erfolgreich gesendet!");
                return true;
            } catch (MessagingException e) {
                System.out.println("E-Mail an " + person.getFirstName() + " " + person.getLastName() + " konnte nicht gesendet werden: " + e.getMessage());
                return false;
            }
        }
        return true;
    }

    private static Properties getSmtpProperties() {        // SMTP-Server-Einstellungen
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        return props;
    }
}