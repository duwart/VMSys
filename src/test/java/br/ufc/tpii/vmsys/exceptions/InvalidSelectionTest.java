package br.ufc.tpii.vmsys.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class InvalidSelectionTest {

	@Test
	void testInvalidSelection() {
		assertThrows(InvalidSelection.class, () -> {
			throw new InvalidSelection();
		});
	}

	@Test
	void testInvalidSelectionString() {
		assertThrows(InvalidSelection.class, () -> {
			throw new InvalidSelection("Invalid item selection");
		});
	}

}
