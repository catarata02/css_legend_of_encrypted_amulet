import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NotificationServiceEmail implements NotificationService {

    
    private List<BirthdayEmail> sentEmails = new ArrayList<>();

    public NotificationServiceEmail() {
    }

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
