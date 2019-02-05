package Modules;
import DBConnect.*;
import java.sql.*;
public class BillUpdate {
	public void ArrReturn(Item i, String User)
	{
		DBConnection db = new DBConnection();
		Invoice c = new Invoice(i,User);
		int s = c.total();
		String u = c.UN();
     	db.billingUpdate(u,s);
	}
}
