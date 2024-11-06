import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class NotificationServiceTest {


    private final NotificationServiceEmail notificationService = new NotificationServiceEmail();

    @Test
    @DisplayName("GIVEN jon's birthday WHEN send THEN correct email has been sent")
    void test_send_01() {
        String firstName = "John";
        String email = "john.doe@foobar.com";
        List<BirthdayEmail> expectedSentEmails = List.of(new BirthdayEmail(email, "Happy Birthday!", "Happy birthday, dear " + firstName + "!"));
        List<BirthdayDto> birthdayDtoList = List.of(new BirthdayDto("Doe", firstName, LocalDate.of(1982, 10, 8), email));

        boolean success = notificationService.send(birthdayDtoList);

        assertTrue(success);
        assertEquals(expectedSentEmails, notificationService.getSentEmails());
    }

}
