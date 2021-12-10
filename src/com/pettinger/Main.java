package com.pettinger;

import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Language language = new Language();
        language.setLocale(Language.Option.US);
        ResourceBundle messages = language.getMessages();
        CarDAO carDAO = CarDAOFactory.getCarDAO();
        PresidentDAO presidentDAO = PresidentDAOFactory.getPresidentDAO();
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        while (true) {
            String menuTitle = messages.getString("main-menu");
            String prompt = messages.getString("prompt");
            String[] menuOptions = {
                    messages.getString("add-car"),
               //     messages.getString("add-president"),
                    messages.getString("find-car"),
               //     messages.getString("find-president"),
                    messages.getString("show-cars"),
               //     messages.getString("show-presidents"),
                    messages.getString("update-car"),
               //     messages.getString("update-president"),
                    messages.getString("delete-car"),
               //     messages.getString("delete-president"),
                    messages.getString("change-language")
            };
            choice = UIUtility.showMenuOptions(menuTitle, prompt, menuOptions, scanner, messages);
            if (choice == 0)
                continue;
            if (choice == menuOptions.length + 1)
                break;
            UIUtility.showSectionTitle().accept((menuOptions[Integer.valueOf(choice) - 1]));
            switch (choice) {
              case 1 -> new AddCar().handleTask(carDAO, scanner, messages);
             // case 1 -> new AddPresident().handleTask(presidentDAO, scanner, messages);

              case 2 -> new FindCar().handleTask(carDAO, scanner, messages);
             // case 2 -> new FindPresident().handleTask(presidentDAO, scanner, messages);

              case 3 -> new ShowAllCars().handleTask(carDAO, scanner, messages);
              // case 3 -> new ShowAllPresidents().handleTask(presidentDAO, scanner, messages);

              case 4 -> new UpdateCar().handleTask(carDAO, scanner, messages);
             // case 4 -> new UpdatePresident().handleTask(presidentDAO, scanner, messages);

              case 5 -> new DeleteCar().handleTask(carDAO, scanner, messages);
             // case 5 -> new DeletePresident().handleTask(presidentDAO, scanner, messages);

              case 6 -> { language.changeLanguage(scanner, messages);
                            messages = language.getMessages();}
            }
            UIUtility.pressEnterToContinue().accept(scanner, messages);
        }
        System.out.println("\n" + messages.getString("end") +"\n");
        scanner.close();
    }
}
