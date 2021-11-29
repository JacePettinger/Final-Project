package com.pettinger;

import java.time.LocalDate;
import java.util.ResourceBundle;

public class Car implements Comparable<Car> {
    private static Language language = new Language();
    private static ResourceBundle messages = language.getMessages();
    private String licensePlate;
    private String make;
    private String model;
    private int modelYear;

    public static final String DEFAULT_LICENSE_PLATE = "XXX-XXX";
    public static final String DEFAULT_MAKE = "UNKNOWN";
    public static final String DEFAULT_MODEL = "UNKNOWN";
    public static final int DEFAULT_MODEL_YEAR = LocalDate.now().getYear();
    public static final int MINIMUM_MODEL_YEAR = 1884;
    public static final int MAXIMUM_MODEL_YEAR = LocalDate.now().getYear() + 1;
    public static final int MAXIMUM_LICENSE_PLATE_LENGTH = 8;

    public Car() {
        this(DEFAULT_LICENSE_PLATE, DEFAULT_MAKE, DEFAULT_MODEL, DEFAULT_MODEL_YEAR);
    }

    public Car(String licensePlate, String make, String model, int modelYear) {
        validateLicensePlate(licensePlate);
        validateMake(make);
        validateModel(model);
        validateModelYear(modelYear);
        this.licensePlate = licensePlate;
        this.make = make;
        this.model = model;
        this.modelYear = modelYear;
    }

    public Car(Car other){
        this.licensePlate = other.getLicensePlate();
        this.make = other.getMake();
        this.model = other.getModel();
        this.modelYear = other.getModelYear();
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        validateLicensePlate(licensePlate);
        this.licensePlate = licensePlate;
    }

    public void validateLicensePlate(String licensePlate) {
        if (licensePlate == null) {
            throw new NullPointerException(messages.getString("license-plate-null"));
        } else if(licensePlate.length() > MAXIMUM_LICENSE_PLATE_LENGTH){
            throw new IllegalArgumentException(messages.getString("license-over-max") + " " +
                    + MAXIMUM_LICENSE_PLATE_LENGTH + " " + (messages.getString("characters")));
        }
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        validateMake(make);
        this.make = make;
    }

    public void validateMake(String make) {
        if (make == null) {
            throw new NullPointerException(messages.getString("make-null"));
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        validateModel(model);
        this.model = model;
    }

    public void validateModel(String model) {
        if (model == null) {
            throw new NullPointerException(messages.getString("Model-null"));
        }
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        validateModelYear(modelYear);
        this.modelYear = modelYear;
    }

    private void validateModelYear(int modelYear){
        if(modelYear < MINIMUM_MODEL_YEAR){
            throw new IllegalArgumentException(messages.getString("model-under-min") + " " +
                    + MINIMUM_MODEL_YEAR + ".");
        }
        else if(modelYear > MAXIMUM_MODEL_YEAR){
            throw new IllegalArgumentException("model-over-max" + " " +
                    + MAXIMUM_MODEL_YEAR + ".");
        }
    }

    @Override
    public String toString() {
        return messages.getString("car") + "{" +
                messages.getString("license-plate") + " = " + licensePlate +
                ", " + messages.getString("make")+ " = " + make +
                ", " + messages.getString("model")+ " = " + model +
                ", " + messages.getString("model-year")+ " = " +  modelYear +
                '}';
    }

    @Override
    public int compareTo(Car other) {
        // Order first by model year in descending order
        int result = (this.modelYear - other.modelYear) * -1;
        if(result == 0) {
            // Order second by make in alphabetical order
            result = this.make.compareToIgnoreCase(other.make);
            if(result == 0) {
                // Order third by model in alphabetical order
                result = this.model.compareToIgnoreCase(other.model);
                if(result == 0) {
                    // Order fourth by license plate in alphabetical order
                    result = this.licensePlate.compareToIgnoreCase(other.licensePlate);
                }
            }
        }
        return result;
    }
}

