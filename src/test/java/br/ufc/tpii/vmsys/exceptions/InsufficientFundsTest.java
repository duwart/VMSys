package br.ufc.tpii.vmsys.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InsufficientFundsTest {

	@Test
	void testInsufficientFunds() {
		assertThrows(InsufficientFunds.class, () -> {
			throw new InsufficientFunds();
		});
	}

	@Test
	void testInsufficientFundsString() {
		assertThrows(InsufficientFunds.class, () -> {
			throw new InsufficientFunds("Insufficient coins to by");
		});
	}

}
