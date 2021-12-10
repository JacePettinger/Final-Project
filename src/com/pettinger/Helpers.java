package com.pettinger;

import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.function.BiFunction;

public class Helpers {

    /** Prints the contents of an array of integers
     * @param arr an array of integers
     */
    public static <T>void printArray(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static <T>void printList(List<T> list) {
        list.forEach(System.out::println);
    }

    public static <T>void printMap(Map<T, T> map) {
        map.keySet().forEach(System.out::println);
    }

    /**
     * Prompts the user for a String and returns whatever was entered.
     *
     * @return the String entered by the user
     */
    public static BiFunction<String, Scanner, String> getUserString() {
        return(prompt, in) -> {
            System.out.print(prompt + ": ");
            return in.nextLine().trim();
        };
    }

    /**
     * Prompts the user for a whole number between the low bound (inclusive) and
     * the high bound (inclusive).
     *
     * @param prompt the text of the user prompt
     * @param lowBound the lower boundary of the range, inclusive
     * @param highBound the upper boundary of the range, inclusive
     * @param in a Scanner object
     * @return the entered whole number
     */
    public static int getUserIntInRange(String prompt, int lowBound, int highBound, Scanner in, ResourceBundle messages) {
        int value = -1;
        boolean needed = true;
        while (needed) {
            value = getUserInt(prompt, in, messages);
            if (value < lowBound || value > highBound) {
                UIUtility.showErrorMessage(messages.getString("not-in-range-error") + " " + lowBound + " - " + highBound + ".", in, messages);
            } else {
                needed = false;
            }
        }
        return value;
    }

    /**
     * Prompts the user to enter a whole number. If the value is not a whole
     * number, prints the notIntMessage and tries again. Otherwise, returns the
     * int that was entered.
     *
     * @param prompt the prompt text for the user
     * @param in a Scanner object
     * @return the int entered
     */
    public static int getUserInt(String prompt, Scanner in, ResourceBundle messages){
        int value = 0;
        String input;
        boolean needed = true;
        while(needed){
            System.out.print(prompt + ": ");
            input = in.nextLine().trim();
            try{
                value = Integer.parseInt(input);
                needed = false;
            }catch(NumberFormatException nfe){
                UIUtility.showErrorMessage(messages.getString("int-error"), in, messages);
            }
        }
        return value;
    }
}
