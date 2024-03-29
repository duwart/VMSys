package br.ufc.tpii.vmsys;

import br.ufc.tpii.vmsys.exceptions.*;
import br.ufc.tpii.vmsys.inventory.*;
import br.ufc.tpii.vmsys.inventory.exceptions.*;

public class VendingMachine {

	private double coinsDeposited = 0.0;

	private Inventory inventory;

	public VendingMachine(Inventory inventory) {
		this.inventory = inventory;
	}

	public void addCoins(double coins) {
		if (coins < 0) {
			throw new IllegalArgumentException("Invalid value");
		}
		this.coinsDeposited += coins;
	}

	public double withdrawRemainingCoins() {
		double remainingCoins = this.coinsDeposited;
		this.coinsDeposited = 0.0;
		return remainingCoins;
	}

	public double howManyCoinsLeft() {
		return this.coinsDeposited;
	}

	public void vend(String itemName) throws InvalidSelection, OutOfStock, InsufficientFunds {
		Item item = null;

		try {
			item = inventory.getItem(itemName);

		} catch (ItemNotFound inf) {
			throw new InvalidSelection("Invalid item selection: " + itemName);
		}

		if (item.getCount() == 0) {
			throw new OutOfStock("Item out of stock: " + itemName);
		}

		if (item.getPrice() > this.coinsDeposited) {
			throw new InsufficientFunds("Insufficient coins to by " + itemName + ": " + this.coinsDeposited);
		}

		this.coinsDeposited -= item.getPrice();

		item.decCount();
	}
}