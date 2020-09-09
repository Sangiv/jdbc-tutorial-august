package com.qa.main;

import java.sql.SQLException;
import java.util.Scanner;

public class Runner {
	
	private static Scanner scan = new Scanner(System.in); 
	
    public static void main(String[] args) throws SQLException {
        DatabaseConnector db = new DatabaseConnector();
        db.readAllActors();
        System.out.println("");
        System.out.println("");
        System.out.println("");
        
        String action = getAction();
        
        while(!action.equals("exit")) {
            switch(action) {
            case "create":
            	System.out.println("Enter a first_name");
            	String first_name = scan.nextLine();
            	System.out.println("Enter a last_name");
            	String last_name = scan.nextLine();
            	db.createActor(first_name, last_name);
            	break;
            case "read":
            	db.readAllActors();
            	break;
            case "update":
            	System.out.println("Please enter first_name of actor you want to change");
            	String first_name_old = scan.nextLine();
            	System.out.println("and their last_name?");
            	String last_name_old = scan.nextLine();
            	System.out.println("Now enter the updated first_name");
            	String first_name_new = scan.nextLine();
            	System.out.println("and now the updated last_name");
            	String last_name_new = scan.nextLine();
            	db.updateActor(first_name_new, last_name_new, first_name_old, last_name_old);
            	break;
            case "delete":
            	System.out.println("Please enter first_name of actor you want to delete");
            	String first_name_d = scan.nextLine();
            	System.out.println("and their last_name?");
            	String last_name_d = scan.nextLine();
            	db.deleteActor(first_name_d, last_name_d);
            	break;
            default:
            	System.out.println("Not a valid action");
            }
            
            action = getAction();
            if(action.equals("exit")) {
            	System.out.println("Bye!");
            }
        }
    }

    private static String getAction() {
    	   	
    	System.out.println("What would you like to do? - create, read, update or delete?");
    	return scan.nextLine();
    }
    
}
