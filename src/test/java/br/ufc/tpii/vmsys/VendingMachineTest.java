package br.ufc.tpii.vmsys;

import br.ufc.tpii.vmsys.inventory.HashMapInventory;
import br.ufc.tpii.vmsys.inventory.Item;
import br.ufc.tpii.vmsys.exceptions.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VendingMachineTest {

	@Test
	void testAddCoins() {
		HashMapInventory inv = new HashMapInventory();
		VendingMachine vm = new VendingMachine(inv);
		vm.addCoins(10.0);
		assertEquals(vm.howManyCoinsLeft(), 10.0);
		vm.addCoins(0.0);
		assertEquals(vm.howManyCoinsLeft(), 10.0);
		
		assertThrows(IllegalArgumentException.class, () -> {
			vm.addCoins(-10.0);
		});
		
	}

	@Test
	void testWithdrawRemainingCoins() {
		HashMapInventory inv = new HashMapInventory();
		VendingMachine vm = new VendingMachine(inv);
		vm.addCoins(10.0);
		assertEquals(vm.withdrawRemainingCoins(), 10.0);
		assertEquals(vm.howManyCoinsLeft(), 0.0);
	}

	@Test
	void testHowManyCoinsLeft() {
		HashMapInventory inv = new HashMapInventory();
		VendingMachine vm = new VendingMachine(inv);
		vm.addCoins(10.0);
		assertEquals(vm.howManyCoinsLeft(), 10.0);
		vm.addCoins(10.0);
		assertEquals(vm.howManyCoinsLeft(), 20.0);
		vm.withdrawRemainingCoins();
		assertEquals(vm.howManyCoinsLeft(), 0.0);
	}

	@Test
	void testVend() {
		Item it0 = new Item("item01", 10.0, 3);
		Item it1 = new Item("item02", 10.0, 1);
		Item it2 = new Item("item03", 10.0, 2);
		HashMapInventory inv = new HashMapInventory();
		try {
			inv.addItem(it0);
			inv.addItem(it1);
			inv.addItem(it2);
			VendingMachine vm = new VendingMachine(inv);
			vm.addCoins(20.0);
			vm.vend("item01");
			assertEquals(vm.howManyCoinsLeft(), 10.0);
			vm.vend("item01");
			assertEquals(vm.howManyCoinsLeft(), 0.0);
		} catch (Exception e) {
			fail(e);
		}
		
		assertThrows(InvalidSelection.class, () -> {
			VendingMachine vm1 = new VendingMachine(new HashMapInventory());
			vm1.vend("item01");
		});
		
		assertThrows(OutOfStock.class, () -> {
			VendingMachine vm1 = new VendingMachine(inv);
			vm1.addCoins(200.0);
			vm1.vend("item02");
			vm1.vend("item02");
		});
		
		assertThrows(InsufficientFunds.class, () -> {
			VendingMachine vm1 = new VendingMachine(inv);
			vm1.vend("item03");
		});
	}

}