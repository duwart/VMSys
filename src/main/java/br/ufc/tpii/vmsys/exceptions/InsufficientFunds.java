package br.ufc.tpii.vmsys.exceptions;

public class InsufficientFunds extends Exception {

	private static final long serialVersionUID = 1L;

	public InsufficientFunds() {
		super();
	}

	public InsufficientFunds(String message) {
		super(message);
	}

}
