package br.ufc.tpii.vmsys.inventory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ItemTest {
	@Test
	void testItem() {
		Item it0 = new Item("item00", 10.0, 2);
		assertEquals(it0.getName(), "item00");
		assertEquals(it0.getPrice(), 10.0);
		assertEquals(it0.getCount(), 2);
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Item("", 10.0, 2);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Item(null, 10.0, 2);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Item("item02", -10.0, 2);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Item("item03", 10.0, -2);
		});
	}
	
	@Test
	void testGetName() {
		Item it = new Item("item01", 10.0, 2);
		assertEquals(it.getName(), "item01");
	}

	@Test
	void testGetPrice() {
		Item it = new Item("item01", 10.0, 2);
		assertEquals(it.getPrice(), 10.0);
	}

	@Test
	void testSetPrice() {
		Item it = new Item("item01", 10.0, 2);
		it.setPrice(20.0);
		assertEquals(it.getPrice(), 20.0);
		assertThrows(IllegalArgumentException.class, () -> {
			it.setPrice(-20.0);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			it.setPrice(0.0);
		});
	}

	@Test
	void testGetCount() {
		Item it = new Item("item01", 10.0, 2);
		assertEquals(it.getCount(), 2);
	}

	@Test
	void testDecCount() {
		Item it = new Item("item01", 10.0, 2);
		int aux = it.getCount();
		it.decCount();
		assertEquals(it.getCount(), aux - 1);
		it.decCount();
		assertEquals(it.getCount(), aux - 2);
		assertThrows(IllegalArgumentException.class, () -> {
			it.decCount();
		});
	}

	@Test
	void testIncCount() {
		Item it = new Item("item01", 10.0, 0);
		int aux = 0;
		for (int i=0; i < 10; i++) {
			aux = it.getCount();
			it.incCount();
			assertEquals(it.getCount(), aux + 1);
		}
	}

}
