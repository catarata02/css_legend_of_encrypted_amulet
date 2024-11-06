import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}