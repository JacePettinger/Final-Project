package com.pettinger;

import java.time.LocalDate;

public class President extends Person {
        private int inaugurationAge_Years;
        private int inaugurationAge_Days;

        public static int DEFAULT_INAUGURATION_AGE_YEARS = 35;
        public static int DEFAULT_INAUGURATION_AGE_DAYS = 1;

        public static int MIN_INAUGURATION_AGE_YEARS = 35;
        public static int MAX_INAUGURATION_AGE_YEARS = 100;

        public static int MIN_INAUGURATION_AGE_DAYS = 1;
        public static int MAX_INAUGURATION_AGE_DAYS = 365;

        public President() {
                super(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_BIRTHDAY);
                this.inaugurationAge_Years = DEFAULT_INAUGURATION_AGE_YEARS;
                this.inaugurationAge_Days = DEFAULT_INAUGURATION_AGE_DAYS;
        }

        public President(String firstName, String lastName, LocalDate birthday,
                         int inaugurationAge_Years, int inaugurationAge_Days) {
                super(firstName, lastName, birthday);
                validateInaugurationAgeYears(inaugurationAge_Years);
                validateInaugurationAgeDays(inaugurationAge_Days);
                this.inaugurationAge_Years = inaugurationAge_Years;
                this.inaugurationAge_Days = inaugurationAge_Days;
        }

        public void validateInaugurationAgeYears(int inaugurationAge_Years) {
                // cannot be lower than 35 and no higher than 100.
                if (inaugurationAge_Years < MIN_INAUGURATION_AGE_YEARS) {
                        throw new NullPointerException(
                                "The Inauguration Age Years cannot be less than " + MIN_INAUGURATION_AGE_YEARS);
                } else if (inaugurationAge_Years > MAX_INAUGURATION_AGE_YEARS) {
                        throw new NullPointerException(
                                "The Inauguration Age Years cannot be more than " + MAX_INAUGURATION_AGE_YEARS);
                }
        }

        public void validateInaugurationAgeDays(int inaugurationAge_Days) {
                // cannot be lower than 1 and no higher than 365.
                if (inaugurationAge_Days < MIN_INAUGURATION_AGE_DAYS) {
                        throw new NullPointerException(
                                "The Inauguration Age Days cannot be less than " + MIN_INAUGURATION_AGE_DAYS);
                } else if (inaugurationAge_Days > MAX_INAUGURATION_AGE_DAYS) {
                        throw new NullPointerException(
                                "The Inauguration Age Days cannot be more than " + MAX_INAUGURATION_AGE_DAYS);
                }
        }

        public int getInaugurationAge_Years() {
                return inaugurationAge_Years;
        }

        public void setInaugurationAge_Years(int inaugurationAge_Years) {
                validateInaugurationAgeYears(inaugurationAge_Years);
                this.inaugurationAge_Years = inaugurationAge_Years;
        }

        public int getInaugurationAge_Days() {
                return inaugurationAge_Days;
        }

        public void setInaugurationAge_Days(int inaugurationAge_Days) {
                validateInaugurationAgeDays(inaugurationAge_Days);
                this.inaugurationAge_Days = inaugurationAge_Days;
        }

        @Override
        public String toString() {
                return "President{" +
                        "inaugurationAge_Years=" + inaugurationAge_Years +
                        ", inaugurationAge_Days=" + inaugurationAge_Days +
                        '}';
        }

        @Override
        public int compareTo(President other) {
                //  a compareTo method that orders first by "inaugurationAge_Years" in descending order, second by
                //  "inaugurationAge_Days" in descending order, and third by "lastName" is ascending order.
                int result = (this.inaugurationAge_Years - other.inaugurationAge_Years) * -1;
                if (result == 0) {
                        result = (this.inaugurationAge_Days - other.inaugurationAge_Days) * -1;
                        if (result == 0) {
                                result = this.getLastName().compareToIgnoreCase(other.getLastName());
                        }
                }
                return result;
        }
}