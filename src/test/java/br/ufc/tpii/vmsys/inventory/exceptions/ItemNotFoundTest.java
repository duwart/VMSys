package br.ufc.tpii.vmsys.inventory.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ItemNotFoundTest {

	@Test
	void testItemNotFound() {
		assertThrows(ItemNotFound.class, () -> {
			throw new ItemNotFound();
		});
	}

	@Test
	void testItemNotFoundString() {
		assertThrows(ItemNotFound.class, () -> {
			throw new ItemNotFound("Item not found");
		});
	}
}
