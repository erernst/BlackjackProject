package com.erernst.blackjack;

public class Player {
	private String name;
	private Hand hand;
	private double wallet;
	public Player(String name, Hand hand, double wallet) {
		super();
		this.name = name;
		this.hand = hand;
		this.wallet = wallet;
	}

	public Player(String name2, Hand hand2, Double wallet2) {
		
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void getHand() {
		
	}
	public void setHand(Hand hand) {
		this.hand = hand;
	}
	public double getWallet() {
		return wallet;
	}
	public void setWallet(double wallet) {
		this.wallet = wallet;
	}
	private void placeWager(int wager) {
		
	}
}
