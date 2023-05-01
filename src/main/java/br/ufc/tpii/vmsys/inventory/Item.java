package br.ufc.tpii.vmsys.inventory;

public class Item {
	private String name;
	private double price = 0.0;
	private int count = 0;

	public Item(String name, double price, int count) {
		this.setPrice(price);
		if (name.length() == 0 || name == null) {
			throw new IllegalArgumentException("Name is a empty or null string");
		}
		this.name = name;
		if (count < 0) {
			throw new IllegalArgumentException("Count value is invalid");
		}
		this.count = count;
	}

	public String getName() {
		return this.name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		if (price <= 0.0) {
			throw new IllegalArgumentException("Price is invalid");
		}
		this.price = price;
	}

	public int getCount() {
		return this.count;
	}

	public void decCount() {
		// this.count++;
		if (this.count == 0) {
			throw new IllegalArgumentException("Number of items is zero");
		}
		this.count--;
	}

	public void incCount() {
		// this.count--;
		this.count++;
	}
}