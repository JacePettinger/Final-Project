package com.pettinger;

import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class UIUtility {
    /**
     * Displays a menu and the prompt, returning the String entered by the user.
     *
     * @param menuTitle the title of the menu
     * @param prompt the prompt for input
     * @param menuOptions the list of menu options to display
     * @param in a Scanner object
     * @param messages a ResourceBundle object
     * @return the user's response
     */
    public static int showMenuOptions(String menuTitle, String prompt, String[] menuOptions, Scanner in, ResourceBundle messages) {
        showMenuTitle().accept(menuTitle);
        int count = 1;
        for (String menuOption : menuOptions) {
            System.out.println(count++ + ": " + menuOption);
        }
        System.out.println(count + ": " + messages.getString("exit"));
        System.out.print("\n" + prompt + ": ");
        String input = in.nextLine().trim();
        int result = validateIntInput(input, menuOptions.length + 1, in, messages);
        return result;
    }

    /**
     * Displays a properly formatted menu title.
     */
    public static Consumer<String> showMenuTitle(){
        return (menuTitle) -> System.out.println("\n" + "xxx " + menuTitle + " xxx\n");
    }

    /*
     * A string is converted to an integer. If invalid, a message will display.
     *
     * @param input The string representing an integer
     * @param in a Scanner object
     * @param messages a ResourceBundle object
     * @return The string converted to an integer, or 0 if invalid
     */

    public static int validateIntInput(String input, int highBound, Scanner in, ResourceBundle messages) {
        int intInput = 0;
        try {
            intInput = Integer.parseInt(input);
            if (intInput < 1 || intInput > highBound) {
                intInput = 0;
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            showErrorMessage(messages.getString("invalid-input"), in, messages);
        }
        return intInput;
    }

    /**
     * Displays the supplied message.  If waitForAcknowledement is true, will
     * also call pressEnterToContinue().
     *
     * @param message The error message
     * @param in a Scanner object
     * @param messages a ResourceBundle object
     */

    public static void showErrorMessage(String message, Scanner in, ResourceBundle messages) {
        System.out.println(messages.getString("error") + message);
        pressEnterToContinue().accept(in, messages);
    }

    /**
     * Displays a wait prompt and waits for the user to hit the enter key.
     */
    public static BiConsumer<Scanner, ResourceBundle> pressEnterToContinue() {
        return (in, messages) -> {
            System.out.print("\n" + messages.getString("press-enter"));
            in.nextLine();
        };
    }

    /**
     * Displays the supplied title text in a consistently formatted manner.
     */
    public static Consumer<String> showSectionTitle(){
        return (title) -> System.out.println("\\n\" + \"*** \" + title + \" ***\\n");
    }
}