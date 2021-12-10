package com.pettinger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarDAOCSV implements CarDAO {
    private static final String FILE_NAME = "cars.csv";
    private static List<Car> cars;

    @Override
    public void readInData() throws DataException {
        try(BufferedReader in = new BufferedReader(new FileReader("cars.csv"))){
            cars = new ArrayList<>();
            int lineCount = 0;
            String line;
            String[] fields;
            String licensePlate;
            String make;
            String model;
            int modelYear;
            while(true){
                lineCount++;
                line = in.readLine();
                if (line == null){
                    break;
                }
                if(lineCount > 1) {
                    fields = line.split(",");
                    licensePlate = fields[0];
                    make = fields[1];
                    model = fields[2];

                    try {
                        modelYear = Integer.parseInt(fields[3]);
                    } catch (NumberFormatException e) {
                        throw new DataException(e.getMessage() + " CSV line " + lineCount);
                    }
                    cars.add(new Car(licensePlate, make, model, modelYear));
                }
            }
        } catch(IOException e) {
            throw new DataException(e);
        }
    }

    private void saveToFile() throws DataException {
        try(PrintWriter writer = new PrintWriter(new File(FILE_NAME))){
            writer.println("licensePlate,make,model,modelYear");
            String line = "";
            for(Car car: cars) {
                line = car.getLicensePlate() + "," + car.getMake()
                        + "," + car.getModel() + "," + car.getModelYear();
                writer.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new DataException(e.getMessage());
        }
    }

    @Override
    public void verifyCarList() throws DataException {
        if(cars == null) {
            readInData();
        }
    }

    @Override
    public void createCarRecord(Car car) throws DataException {
        verifyCarList();
        cars.add(car);
        saveToFile();
    }

    @Override
    public Car getCarByLicensePlate(String licensePlate) throws DataException {
        Car car = null;

        return car;
    }

    @Override
    public List<Car> getAllCars() throws DataException {
        List<Car> cars = null;

        return cars;
    }

    @Override
    public void updateCar(Car original, Car updated) throws DataException {

    }

    @Override
    public void deleteCar(Car car) throws DataException {

    }

    @Override
    public void deleteCar(String licensePlate) throws DataException {

    }

}
