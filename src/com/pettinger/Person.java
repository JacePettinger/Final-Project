package com.pettinger;

import java.time.LocalDate;

public abstract class Person {
    private String firstName;
    private String lastName;
    private LocalDate birthday;

    public static String DEFAULT_FIRST_NAME = "UNKNOWN";
    public static String DEFAULT_LAST_NAME = "UNKNOWN";
    public static LocalDate DEFAULT_BIRTHDAY = LocalDate.now();
    public static LocalDate MIN_BIRTHDAY_DATE = LocalDate.MIN;
    public static LocalDate MAX_BIRTHDAY_DATE = LocalDate.now();

    public Person() {
        this(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_BIRTHDAY);
    }

    public Person(String firstName, String lastName, LocalDate birthday) {
        validateFirstName(firstName);
        validateLastName(lastName);
        validateBirthday(birthday);
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public void validateFirstName(String firstName) {
        // not null
        if (firstName == null) {
            throw new NullPointerException("First name cannot be null");
        }
    }

    public void validateLastName(String lastName) {
        // not null
        if (lastName == null) {
            throw new NullPointerException("Last name cannot be null");
        }
    }

    public void validateBirthday(LocalDate birthday) {
        // not after current day or before min
        if (birthday == null) {
            throw new NullPointerException("Birthday cannot be null");
        } else if(birthday.isAfter(MAX_BIRTHDAY_DATE) || birthday.isBefore(MIN_BIRTHDAY_DATE)){
            throw new IllegalArgumentException("Birthday cannot be after today's date or before " + MIN_BIRTHDAY_DATE);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public abstract int compareTo(President other);
}
