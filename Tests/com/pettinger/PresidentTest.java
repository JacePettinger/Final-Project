package com.pettinger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class PresidentTest {
    private President president;

    @BeforeEach
    void setUp() {
        president = new President();
    }

    // test getInaugurationAge_Years
    @Test
    void getInaugurationAgeYears() {
        int expected = president.DEFAULT_INAUGURATION_AGE_YEARS;
        int actual = president.getInaugurationAge_Years();
        assertEquals(expected, actual);
    }

    // test getInaugurationAge_Days
    @Test
    void getInaugurationAgeDays() {
        int expected = president.DEFAULT_INAUGURATION_AGE_DAYS;
        int actual = president.getInaugurationAge_Days();
        assertEquals(expected, actual);
    }

    // test setInaugurationAge_Years good
    @Test
    void setInaugurationAgeYearsMinGood() {
        int expected = president.MIN_INAUGURATION_AGE_YEARS;
        president.setInaugurationAge_Years(president.MIN_INAUGURATION_AGE_YEARS);
        int actual = president.getInaugurationAge_Years();
        assertEquals(expected, actual);
    }

    @Test
    void setInaugurationAgeYearsMaxGood() {
        int expected = president.MAX_INAUGURATION_AGE_YEARS;
        president.setInaugurationAge_Years(president.MAX_INAUGURATION_AGE_YEARS);
        int actual = president.getInaugurationAge_Years();
        assertEquals(expected, actual);
    }

    // test setInaugurationAge_Years bad
    @Test
    void setInaugurationAgeYearsUnderMin() {
        int badValue = 0;
        Exception exception = assertThrows(NullPointerException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                president.setInaugurationAge_Years(badValue);
            }
        });
        String expectedMessage = "The Inauguration Age Years cannot be less than " + president.MIN_INAUGURATION_AGE_YEARS;
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void setInaugurationAgeYearsOverMax() {
        int badValue = 101;
        Exception exception = assertThrows(NullPointerException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                president.setInaugurationAge_Years(badValue);
            }
        });
        String expectedMessage = "The Inauguration Age Years cannot be more than " + president.MAX_INAUGURATION_AGE_YEARS;
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    // test setInaugurationAge_Days good
    @Test
    void setInaugurationAgeDaysMinGood() {
        int expected = president.MIN_INAUGURATION_AGE_DAYS;
        president.setInaugurationAge_Days(president.MIN_INAUGURATION_AGE_DAYS);
        int actual = president.getInaugurationAge_Days();
        assertEquals(expected, actual);
    }
    @Test
    void setInaugurationAgeDaysMaxGood() {
        int expected = president.MAX_INAUGURATION_AGE_DAYS;
        president.setInaugurationAge_Days(president.MAX_INAUGURATION_AGE_DAYS);
        int actual = president.getInaugurationAge_Days();
        assertEquals(expected, actual);
    }

    // test setInaugurationAge_Days bad
    @Test
    void setInaugurationAgeDaysUnderMin() {
        int badValue = 0;
        Exception exception = assertThrows(NullPointerException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                president.setInaugurationAge_Days(badValue);
            }
        });
        String expectedMessage = "The Inauguration Age Days cannot be less than " + president.MIN_INAUGURATION_AGE_DAYS;
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void setInaugurationAgeDaysOverMax() {
        int badValue = 366;
        Exception exception = assertThrows(NullPointerException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                president.setInaugurationAge_Days(badValue);
            }
        });
        String expectedMessage = "The Inauguration Age Days cannot be more than " + president.MAX_INAUGURATION_AGE_DAYS;
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    // test compareTo inaugurationAge_Years before other
    @Test
    void compareToInaugurationAgeYearsBeforeOther() {
        President president2 = new President();
        president.setInaugurationAge_Years(36);
        president2.setInaugurationAge_Years(37);
        assertTrue(president.compareTo(president2) > 0);
    }

    // test compareTo inaugurationAge_Years after other
    @Test
    void compareToInaugurationAgeYearsAfterOther() {
        President president2 = new President();
        president.setInaugurationAge_Years(37);
        president2.setInaugurationAge_Years(36);
        assertTrue(president.compareTo(president2) < 0);
    }

    // test inaugurationAge_Years same other InAugD before other
    @Test
    void compareToInaugurationAgeYearsSameInaugurationAgeDaysBeforeOther() {
        President president2 = new President();
        president.setInaugurationAge_Days(1);
        president2.setInaugurationAge_Days(2);
        assertTrue(president.compareTo(president2) > 0);
    }

    // test inaugurationAge_Years same other InAugD after other
    @Test
    void compareToInaugurationAgeYearsSameInaugurationAgeDaysAfterOther() {
        President president2 = new President();
        president.setInaugurationAge_Days(2);
        president2.setInaugurationAge_Days(1);
        assertTrue(president.compareTo(president2) < 0);
    }

    // test inaugurationAge_Years same other InAugD same other LN before other
    @Test
    void compareToInaugurationAgeYearsSameInaugurationAgeDaysSameLastNameBeforeOther() {
        President president2 = new President();
        president.setLastName("AAAAA");
        president2.setLastName("BBBBB");
        assertTrue(president.compareTo(president2) < 0);
    }
    // test inaugurationAge_Years same other InAugD same other LN after other
    @Test
    void compareToInaugurationAgeYearsSameInaugurationAgeDaysSameLastNameAfterOther() {
        President president2 = new President();
        president.setLastName("BBBBB");
        president2.setLastName("AAAAA");
        assertTrue(president.compareTo(president2) > 0);
    }
    // test toString
    @Test
    void testToString() {
        String expected = "President{" +
                "inaugurationAge_Years=" + president.getInaugurationAge_Years() +
                ", inaugurationAge_Days=" + president.getInaugurationAge_Days() +
                '}';
        String actual = president.toString();
        assertEquals(expected, actual);
    }
}