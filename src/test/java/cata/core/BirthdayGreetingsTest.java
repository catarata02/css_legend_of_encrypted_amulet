package cata.core;

import core.BirthdayGreetings;
import data.CsvReader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sender.EMailSender;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static cata.TestDataFactory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BirthdayGreetingsTest {

    @Mock
    CsvReader csvReader;
    @Mock
    EMailSender emailSender;

    @Test
    void birthdayGreetingsTest_when_EinFreundGeburtstag_then_EineNachricht() {
        // arrange
        BirthdayGreetings testee = new BirthdayGreetings(csvReader, emailSender, LocalDate.of(2024, 8, 15));
        when(csvReader.readPersons(any())).thenReturn(Collections.singletonList(MARC_SCHULER));
        // act
        int notifed = testee.birthdayGreetings("freunde");
        // assert
        assertEquals(1, notifed);
    }

    @Test
    void birthdayGreetingsTest_when_ZweiFreundeGeburtstagWobeiEiner29Zweiter_then_EineNachricht() {
        // arrange
        BirthdayGreetings testee = new BirthdayGreetings(csvReader, emailSender, LocalDate.of(2023, 2, 28));
        when(csvReader.readPersons(any())).thenReturn(List.of(MARC_SCHULER, RAPHAEL_ZUMSTEIN, DOMINIC_BUERGIN, MARKUS_SENTI));
        // act
        int notifed = testee.birthdayGreetings("freunde");
        // assert
        assertEquals(2, notifed);
    }
}
