package com.pettinger;

import java.util.List;

public class PresidentDAOMySQL implements PresidentDAO{
    @Override
    public void readInData() throws DataException {

    }

    @Override
    public void verifyPresidentList() throws DataException {

    }

    @Override
    public void createPresidentRecord(President president) throws DataException {

    }

    @Override
    public President getPresidentByNumber(String licensePlate) throws DataException {
        return null;
    }

    @Override
    public List<President> getAllPresidents() throws DataException {
        return null;
    }

    @Override
    public void updatePresident(President original, President updated) throws DataException {

    }

    @Override
    public void deletePresident(President president) throws DataException {

    }

    @Override
    public void deletePresident(String licensePlate) throws DataException {

    }
}
