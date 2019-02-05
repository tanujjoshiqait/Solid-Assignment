package Main;
import java.sql.*;
import java.util.Scanner;
import DBConnect.*;
import Modules.*;
public class ViewClass {
public static void main(String []args) {
	Category ct = new Category(); 
	System.out.println("Enter Username: ");
	Scanner sc = new Scanner(System.in);
	String Username = sc.nextLine();
	DBConnection db = new DBConnection(); 
	System.out.println(" Currently Available Product Categories: ");
	db.retrieveCategory();
	System.out.println("Please Choose product to Buy:\r");
	int choice = sc.nextInt(); 
	switch (choice) {
		case 1:
			ct.category(Username,db,"Fruit");
			break;
		case 2:
			ct.category(Username,db,"Furniture");
			break;
		case 3:
			ct.category(Username,db,"Elect");;
			break;
		default:
			System.out.println("Entered product is not available now");
			break;
	 	}
	}
}