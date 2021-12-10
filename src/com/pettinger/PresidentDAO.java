package com.pettinger;

import java.util.List;

public interface PresidentDAO {
     // Read in data from the data source
    void readInData() throws DataException;

    // Verify that the data has been read in and assigned to an ArrayList
    void verifyPresidentList() throws DataException;

    // Creates a new president record based on the values in the supplied President object
    void createPresidentRecord(President president) throws DataException;

    // Returns the President record associated with the number or null if there is no such President.
    President getPresidentByNumber(String licensePlate) throws DataException;

    // Returns a list of all the current President records.
    List<President> getAllPresidents() throws DataException;

    // Looks for the original President and updates it to match the updated President.
    // If the original President cannot be found, the method will throw an Exception.
    void updatePresident(President original, President updated) throws DataException;

    // Permanently deletes the supplied President record
    void deletePresident(President president) throws DataException;

    // Permanently deletes the President record with the supplied number.
    void deletePresident(String licensePlate) throws DataException;
}
