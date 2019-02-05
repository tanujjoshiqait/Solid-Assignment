package Modules;

public class Invoice {
	public String User;
	public int sum = 0;
	public Invoice(Item i, String Username) {
		System.out.println("Invoice Generated:");
		System.out.println("Product Name\t|\tProduct Price\t|\tProduct Quantity");
		System.out.println(i.getName() + "\t\t\t" + i.getPrice() + "\t\t\t" + i.getQty());
		sum += i.getPrice() * i.getQty();
		System.out.println("\nTotal : " + sum);
		this.User = Username;
	}
	public int total() {
		return sum;
	}
	public String UN() {
		return User;
	}
}
