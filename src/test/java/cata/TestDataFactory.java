package cata;

import core.Person;

import java.time.LocalDate;

public class TestDataFactory {

    public static final Person MARC_SCHULER = new Person("Schuler", "Marc", LocalDate.of(1990,8,15), "marc.schuler@css.ch");
    public static final Person RAPHAEL_ZUMSTEIN = new Person("Zumstein", "Raphael", LocalDate.of(1995,8,15), "raphael.zumstein@css.ch");
    public static final Person DOMINIC_BUERGIN = new Person("Bürgin", "Dominic", LocalDate.of(1996,2,29), "dominic.buergin@css.ch");
    public static final Person MARKUS_SENTI = new Person("Senti", "Markus", LocalDate.of(1980,2,28), "markus.senti@css.ch");
}
