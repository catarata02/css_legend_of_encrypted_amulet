import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BirthdayParserTestJava {

    private BirthdayParser birthdayParser = new BirthdayParser();

    @Test
    @DisplayName("GIVEN empty file WHEN parsing THEN empty list returned")
    void test_parse_01() {
        String fileContent = "";
        List<Birthday> result = birthdayParser.parse(fileContent);

        assertEquals(0, result.size());
    }

    @Test
    @DisplayName("GIVEN small dataset resource WHEN parsing THEN birthday dtos are successfully parsed")
    void test_parse_02() throws IOException {
        List<Birthday> expectedResult = Arrays.asList(
                new Birthday("Doe", "John", LocalDate.of(1982, 10, 8), "john.doe@foobar.com"),
                new Birthday("Ann", "Mary", LocalDate.of(1975, 9, 11), "mary.ann@foobar.com")
        );
        String fileContent = ResourceReader.readFileFromResources("small_dataset.csv", getClass());

        List<Birthday> result = birthdayParser.parse(fileContent);

        assertEquals(expectedResult, result);
    }

}