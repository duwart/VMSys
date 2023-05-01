package br.ufc.tpii.vmsys.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OutOfStockTest {

	@Test
	void testOutOfStock() {
		assertThrows(OutOfStock.class, () -> {
			throw new OutOfStock();
		});
	}

	@Test
	void testOutOfStockString() {
		assertThrows(OutOfStock.class, () -> {
			throw new OutOfStock("Item out of stock");
		});
	}
}