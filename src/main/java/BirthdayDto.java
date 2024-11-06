import java.time.LocalDate;

public record BirthdayDto(String lastName, String firstName, LocalDate birthday, String email) {
    public boolean sameBirthday(LocalDate otherBirthday) {
        return otherBirthday.getMonth() == birthday.getMonth() && otherBirthday.getDayOfMonth() == birthday.getDayOfMonth();
    }
}
