import java.util.ArrayList;
import java.util.List;

public class NotificationServiceEmail implements NotificationService {

    
    private final List<BirthdayEmail> sentEmails = new ArrayList<>();

    @Override
    public boolean send(List<BirthdayDto> birthdayDtoList) {
        birthdayDtoList.forEach(this::sendEmailToReceiver);
        return true;
    }

    private void sendEmailToReceiver(BirthdayDto birthdayDto) {
        String emailContent = getEmailContent(birthdayDto.firstName());
        BirthdayEmail birthdayEmail = new BirthdayEmail(birthdayDto.email(), "Happy Birthday!", emailContent);
        sentEmails.add(birthdayEmail);
    }

    private String getEmailContent(String firstName) {
        return "Happy birthday, dear " + firstName + "!";
    }

    public List<BirthdayEmail> getSentEmails() {
        return sentEmails;
    }
}
