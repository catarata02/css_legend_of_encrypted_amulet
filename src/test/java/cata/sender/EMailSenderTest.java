package cata.sender;

import org.junit.jupiter.api.Test;
import sender.EMailSender;
import java.util.Collections;

import static cata.TestDataFactory.MARC_SCHULER;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class EMailSenderTest {

    EMailSender testee = new EMailSender();

    @Test
    void test2() {
        // act
        boolean result = testee.sendMessage(Collections.singletonList(MARC_SCHULER));

        // assert
        assertFalse(result); // Fake Mail geht natürlich nicht
    }
}
