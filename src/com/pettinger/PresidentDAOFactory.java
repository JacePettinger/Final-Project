package com.pettinger;

public class PresidentDAOFactory {
   private static final String DAO_SOURCE = "CSV";

    public static PresidentDAO getPresidentDAO(){
     PresidentDAO dao = null;
        switch(DAO_SOURCE){
            case "CSV":
                dao = new PresidentDAOCSV();
                break;
            case "XML":
           //    dao = new PresidentDAOXML();
                break;
            case "MYSQL":
            //    dao = new PresidentDAOMySQL();
                break;
            default:
        }
        return dao;
    }
}
