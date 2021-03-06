package com.pettinger;

import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class FindCar implements CarDataHandler{
    @Override
    public void handleTask(CarDAO dao, Scanner in, ResourceBundle messages) {
        try {
            List<Car> cars = dao.getAllCars();
            if(cars != null) {
                String licensePlate = Helpers.getUserString().apply("Enter the license plate", in);
                System.out.println("\nSearching for license plate " + licensePlate + "...");
                Car car = dao.getCarByLicensePlate(licensePlate);
                if (car == null) {
                    System.out.println("No car found with license plate: " + licensePlate);
                } else {
                    System.out.println("Retrieved: " + car);
                }
            } else {
                System.out.println("There are no cars available.");
            }
        } catch (DataException e) {
            UIUtility.showErrorMessage(e.getMessage(), in, messages);
        }
    }
}