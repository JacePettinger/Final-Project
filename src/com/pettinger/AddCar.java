package com.pettinger;

import java.util.ResourceBundle;
import java.util.Scanner;

public class AddCar implements CarDataHandler {
    private static Language language = new Language();
    private static ResourceBundle messages = language.getMessages();

    @Override
    public void handleTask(CarDAO dao, Scanner in, ResourceBundle messages) {
        Car car = new Car();
        boolean needed = true;
        while(needed) {
            try {
                car.setLicensePlate(Helpers.getUserString().apply(messages.getString("enter-license-plate"), in));
                needed = false;
            } catch (IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), in, messages);
            }
        }
        car.setMake(Helpers.getUserString().apply(messages.getString("enter-make"), in));
        car.setModel(Helpers.getUserString().apply(messages.getString("enter-model"), in));
        String prompt = messages.getString("enter-model-year");
        int modelYear;
        needed = true;
        while(needed){
            try{
                car.setModelYear(Helpers.getUserInt(prompt, in, messages));
                needed = false;
            } catch(IllegalArgumentException e){
                UIUtility.showErrorMessage(e.getMessage(), in, messages);
            }
        }

        try{
            dao.createCarRecord(car);
            System.out.println(messages.getString("added") + " " + car);
        } catch (DataException e) {
            UIUtility.showErrorMessage(e.getMessage(), in, messages);
        }
    }
}
