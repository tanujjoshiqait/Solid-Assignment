package Modules;
public class Item {
	private String name;
	private int qty;
	private double price;
	public void setName(String name) {
		this.name=name;
	}
	public void setPrice(double price) {
		this.price=price;
	}
	public void setQty(int qty) {
		this.qty=qty;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public int getQty() {
		return qty;
	}
}