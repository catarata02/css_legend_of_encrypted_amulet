package cata.data;

import core.Person;
import data.CsvReader;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static cata.TestDataFactory.MARC_SCHULER;
import static cata.TestDataFactory.RAPHAEL_ZUMSTEIN;
import static org.junit.jupiter.api.Assertions.*;

public class CsvReaderTest {

    CsvReader testee = new CsvReader();

    @Test
    public void readPersons_when_FreundeListe_then_Returnfreunde() {
        // arrange
        List<Person> expected = new ArrayList<>();
        expected.add(MARC_SCHULER);
        expected.add(RAPHAEL_ZUMSTEIN);

        // act
        List result = testee.readPersons("src/test/resources/freunde.csv");

        // assert
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertTrue(result.containsAll(expected));
    }

    @Test
    public void testReadCSV() throws IOException {
        // Erstelle eine temporäre CSV-Datei
        File tempFile = File.createTempFile("test", ".csv");
        tempFile.deleteOnExit();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            writer.write("Schuler, Marc, 1990/08/15, marc.schuler@css.ch\n");
            writer.write("Zumstein, Raphael, 1990/08/15, raphael.zumstein@css.ch\n");
        }

        // Lese die Datei mit der Methode, die getestet werden soll
        List result = testee.readPersons(tempFile.getAbsolutePath());

        // Erwartete Ergebnisse
        List<Person> expected = new ArrayList<>();
        expected.add(MARC_SCHULER);
        expected.add(RAPHAEL_ZUMSTEIN);

        // Vergleiche die Ergebnisse
        assertEquals(expected.size(), result.size(), "Die Anzahl der Zeilen sollte übereinstimmen.");
        assertTrue(result.containsAll(expected));
    }
}
