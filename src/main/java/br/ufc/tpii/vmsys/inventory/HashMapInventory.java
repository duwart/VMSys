package br.ufc.tpii.vmsys.inventory;

import java.util.HashMap;

import br.ufc.tpii.vmsys.inventory.exceptions.*;

public class HashMapInventory implements Inventory {

	private HashMap<String, Item> inventory;

	public HashMapInventory() {
		this.inventory = new HashMap<String, Item>();
	}

	public void addItem(Item item) throws ItemAlreadyAdded {
		if (item == null) {
			throw new IllegalArgumentException("Invalid iten: null");
		}
		
		if (this.inventory.containsKey(item.getName())) {
			throw new ItemAlreadyAdded("Item already added: " + item.getName());
		}

		this.inventory.put(item.getName(), item);
	}

	public void removeItem(String itemName) throws ItemNotFound {
		if (itemName == null || itemName.length() == 0) {
			throw new IllegalArgumentException("Invalid item name");
		}
		
		if (!this.inventory.containsKey(itemName)) {
			throw new ItemNotFound("Item not found: " + itemName);
		}

		this.inventory.remove(itemName);
	}

	public Item getItem(String itemName) throws ItemNotFound {
		if (itemName == null || itemName.length() == 0) {
			throw new IllegalArgumentException("Invalid item name");
		}
		
		if (!this.inventory.containsKey(itemName)) {
			throw new ItemNotFound("Item not found: " + itemName);
		}

		return this.inventory.get(itemName);
	}

	public int numberOfItems() {
		return this.inventory.size();
	}
}