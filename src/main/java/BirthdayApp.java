import java.time.LocalDate;
import java.util.List;

public class BirthdayApp {
    private final List<BirthdayDto> birthdayDtoList;

    public BirthdayApp(List<BirthdayDto> birthdayDtoList) {
        this.birthdayDtoList = birthdayDtoList;
    }

    public List<BirthdayDto> getTodaysBirthdays() {
        LocalDate today = LocalDate.now();
        return birthdayDtoList.stream()
                .filter(birthdayDto -> birthdayDto.sameBirthday(today))
                .toList();
    }
}
