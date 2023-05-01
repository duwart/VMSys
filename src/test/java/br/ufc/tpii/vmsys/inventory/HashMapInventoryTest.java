package br.ufc.tpii.vmsys.inventory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.ufc.tpii.vmsys.inventory.exceptions.*;

class HashMapInventoryTest {
	
	@Test
	void testAddItem() {
		
		HashMapInventory hm_inv = new HashMapInventory();
		Item it_1 = new Item("item01", 10.0, 2);
		Item it_2 = new Item("item01", 15.0, 6);
		
		try {
			hm_inv.addItem(it_1);
			assertEquals(hm_inv.getItem("item01"), it_1);
		} catch (Exception e) {
			fail(e);
		} 
		assertThrows(ItemAlreadyAdded.class, () -> {
			hm_inv.addItem(it_2);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			hm_inv.addItem(null);
		});

	}

	@Test
	void testRemoveItem() {
		
		HashMapInventory hm_inv = new HashMapInventory();
		Item it_1 = new Item("item01", 10.0, 2);
		Item it_2 = new Item("item02", 10.0, 2);

		try {
			hm_inv.addItem(it_1);
			hm_inv.addItem(it_2);
			hm_inv.removeItem("item01");
			assertEquals(hm_inv.numberOfItems(), 1);
		} catch (Exception e) {
			fail(e);
		}
		assertThrows(ItemNotFound.class, () -> {
			hm_inv.removeItem("item01");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			hm_inv.removeItem("");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			hm_inv.removeItem(null);
		});
		
	}

	@Test
	void testGetItem() {
		HashMapInventory hm_inv = new HashMapInventory();
		Item it_1 = new Item("item01", 10.0, 2);

		try {
			hm_inv.addItem(it_1); 
			assertEquals(hm_inv.getItem("item01"), it_1);
		} catch (Exception e) {
			fail(e);
		}
		
		assertThrows(ItemNotFound.class, () -> {
			hm_inv.getItem("item02");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			hm_inv.getItem("");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			hm_inv.getItem(null);
		});
	}

	@Test
	void testNumberOfItems() {

		HashMapInventory hm_inv = new HashMapInventory();
		Item it_1 = new Item("item01", 10.0, 2);
		Item it_2 = new Item("item02", 10.0, 2);
		Item it_3 = new Item("item03", 10.0, 2);

		try {
			hm_inv.addItem(it_1);
			hm_inv.addItem(it_2);
			assertEquals(hm_inv.numberOfItems(), 2);
			hm_inv.addItem(it_3);
			assertEquals(hm_inv.numberOfItems(), 3);
			hm_inv.removeItem("item01");
			assertEquals(hm_inv.numberOfItems(), 2);
		} catch (Exception e) {
			fail(e);
		}
	}

}