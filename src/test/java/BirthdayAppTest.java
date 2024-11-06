import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BirthdayAppTest {
   

    private BirthdayApp birthdayApp;

    @Test
    @DisplayName("GIVEN today is somebody's birthday WHEN getTodaysBirthdays THEN list of today's birthdays are returned")
    void test_getTodaysBirthdays_01(){
        LocalDate now = LocalDate.now();
        BirthdayDto todaysBirthdayDto = new BirthdayDto("Doe", "John", LocalDate.of(1982, now.getMonth(), now.getDayOfMonth()), "john.doe@foobar.com");
        List<BirthdayDto> birthdayDtoList = Arrays.asList(
                todaysBirthdayDto,
                new BirthdayDto("Ann", "Mary", LocalDate.of(1975, 9, 11), "mary.ann@foobar.com")
                );
        birthdayApp = new BirthdayApp(birthdayDtoList);
        
        List<BirthdayDto> result = birthdayApp.getTodaysBirthdays();
        
        assertEquals(Arrays.asList(todaysBirthdayDto), result);
    }

}
