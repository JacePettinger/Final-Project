package com.pettinger;

import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Language language = new Language();
        language.setLocale(Language.Option.US);
        ResourceBundle messages = language.getMessages();
        CarDAO dao = CarDAOFactory.getCarDAO();
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        while (true) {
            String menuTitle = messages.getString("main-menu");
            String prompt = messages.getString("prompt");
            String[] menuOptions = {
                    messages.getString("add-car"),
                    messages.getString("find-car"),
                    messages.getString("show-cars"),
                    messages.getString("update-car"),
                    messages.getString("delete-car"),
                    messages.getString("change-language")
            };
            choice = UIUtility.showMenuOptions(menuTitle, prompt, menuOptions, scanner, messages);
            if (choice == 0)
                continue;
            if (choice == menuOptions.length + 1)
                break;
            UIUtility.showSectionTitle(menuOptions[Integer.valueOf(choice) - 1]);
            switch (choice) {
              case 1 -> new AddCar().handleTask(dao, scanner, messages);

              case 2 -> new FindCar().handleTask(dao, scanner, messages);

              case 3 -> new ShowAllCars().handleTask(dao, scanner, messages);

              case 4 -> new UpdateCar().handleTask(dao, scanner, messages);

              case 5 -> new DeleteCar().handleTask(dao, scanner, messages);

              case 6 -> { language.changeLanguage(scanner, messages);
                            messages = language.getMessages();}
            }
            UIUtility.pressEnterToContinue(scanner, messages);
        }
        System.out.println("\n" + messages.getString("end") +"\n");
        scanner.close();
    }
}
