import java.time.LocalDate;
import java.util.List;

public class BirthdayApp {
    private final List<BirthdayDto> birthdayDtoList;
    private final NotificationServiceEmail notificationServiceEmail;

    public BirthdayApp(List<BirthdayDto> birthdayDtoList, NotificationServiceEmail notificationServiceEmail) {
        this.birthdayDtoList = birthdayDtoList;
        this.notificationServiceEmail = notificationServiceEmail;
    }

    public List<BirthdayDto> getTodaysBirthdays() {
        LocalDate today = LocalDate.now();
        return birthdayDtoList.stream()
                .filter(birthdayDto -> birthdayDto.sameBirthday(today))
                .toList();
    }

    public boolean sendEmailToBirthdayPersons() {
        List<BirthdayDto> todaysBirthdays = getTodaysBirthdays();
        return notificationServiceEmail.send(todaysBirthdays);
    }
}
