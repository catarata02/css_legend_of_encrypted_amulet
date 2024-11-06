package ch.css.kata.birthdaygreetings.datastorage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FriendsDataRetrieverTest {

    private FriendsDataRetriever testee;

    @BeforeEach
    void setUp() {
        testee = new FriendsDataRetriever();
    }

    @Test
    void parseFriendsData_whenFileNotFound_then_throwRuntimeException() {
        // arrange
        LocalDate date = LocalDate.now();

        // act + assert
        assertThrows(RuntimeException.class, () -> testee.getFriendsData(date));
    }
}
