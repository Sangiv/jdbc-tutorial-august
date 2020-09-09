package com.qa.main;

import java.sql.SQLException;

public class Runner {

    public static void main(String[] args) throws SQLException {
        DatabaseConnector db = new DatabaseConnector();
        db.readAllActors();
        System.out.println("");
        System.out.println("");
        System.out.println("");
        
        db.createActor("SANGIV", "GIOVANNI");
        db.readAllActors();
        System.out.println("");
        System.out.println("");
        System.out.println("");
        
        db.deleteActor("SANGIV", "GIOVANNI");
        db.readAllActors();
        System.out.println("");
        System.out.println("");
        System.out.println("");
        
        db.updateActor("SANJAY", "GIOVANNI", "THORA", "TEMPLE");
        db.readAllActors();
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }

}
