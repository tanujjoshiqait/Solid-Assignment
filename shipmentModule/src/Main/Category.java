package Main;
import java.util.Scanner;
import DBConnect.DBConnection;
import Modules.Quantity;
public class Category {
	public static void category(String Username,DBConnection db, String type) {
		Quantity qt = new Quantity();
		db.retrieveFruit(type);
		System.out.println("Select "+type+" To buy: ");
		Scanner ob = new Scanner(System.in);
		String cat = ob.nextLine();
		qt.getQuantity(Username,cat,db);
	}
}
