import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BirthdayAppTest {
   

    private BirthdayApp birthdayApp;
    private NotificationServiceEmail notificationServiceEmail;

    @Test
    @DisplayName("GIVEN today is somebody's birthday WHEN getTodaysBirthdays THEN list of today's birthdays are returned")
    void test_getTodaysBirthdays_01(){
        LocalDate now = LocalDate.now();
        BirthdayDto todaysBirthdayDto = new BirthdayDto("Doe", "John", LocalDate.of(1982, now.getMonth(), now.getDayOfMonth()), "john.doe@foobar.com");
        List<BirthdayDto> birthdayDtoList = Arrays.asList(
                todaysBirthdayDto,
                new BirthdayDto("Ann", "Mary", LocalDate.of(1975, 9, 11), "mary.ann@foobar.com")
                );
        notificationServiceEmail = new NotificationServiceEmail();
        birthdayApp = new BirthdayApp(birthdayDtoList, notificationServiceEmail);
        
        List<BirthdayDto> result = birthdayApp.getTodaysBirthdays();
        
        assertEquals(Arrays.asList(todaysBirthdayDto), result);
    }

    @Test
    @DisplayName("GIVEN today is somebody's birthday WHEN sendEmail THEN list of today's birthdays are returned")
    void test_sendEmailToBirthdayPersons_01(){
        LocalDate now = LocalDate.now();
        String expectedFirstName = "John";
        String exptectedEmail = "john.doe@foobar.com";
        BirthdayDto todaysBirthdayDto = new BirthdayDto("Doe", expectedFirstName, LocalDate.of(1982, now.getMonth(), now.getDayOfMonth()), exptectedEmail);
        List<BirthdayDto> birthdayDtoList = Arrays.asList(
                todaysBirthdayDto,
                new BirthdayDto("Ann", "Mary", LocalDate.of(1975, 9, 11), "mary.ann@foobar.com")
        );
        List<BirthdayEmail> expectedSentEmails = List.of(new BirthdayEmail(exptectedEmail, "Happy Birthday!", "Happy birthday, dear " + expectedFirstName + "!"));
        notificationServiceEmail = new NotificationServiceEmail();

        birthdayApp = new BirthdayApp(birthdayDtoList, notificationServiceEmail);
        
        boolean success = birthdayApp.sendEmailToBirthdayPersons();
        
        assertTrue(success);
        assertEquals(expectedSentEmails, notificationServiceEmail.getSentEmails());
    }

}
