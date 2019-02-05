package Modules;
import java.util.Scanner;
import DBConnect.DBConnection;
public class Quantity {
	public static void getQuantity(String Username, String cat, DBConnection db) {
		Scanner quan = new Scanner(System.in);
		System.out.println("Enter the number of Quantaties: \r");
		int Quantity = quan.nextInt();
		int cmpQuant = db.retrieveQuantity(cat);
		if(Quantity < cmpQuant)
		{
			int price = db.updatedb((cmpQuant-Quantity),cat);
			Item i = new Item();
			i.setName(cat);
			i.setPrice(price);
			i.setQty(Quantity);
			BillUpdate bu = new BillUpdate();
			bu.ArrReturn(i, Username);
		}
		else
			System.out.println("Sorry!! Out of Stock");
	}
}
