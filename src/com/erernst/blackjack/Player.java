package com.erernst.blackjack;

public class Player {
	private String name;
	private Hand hand;
	private int wallet;
	public Player(String name, Hand hand, int wallet) {
		super();
		this.name = name;
		this.setHand(hand);
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
	public int getWallet() {
		return wallet;
	}
	public void setWallet(int wallet) {
		this.wallet = wallet;
	}
	private void placeWager(int wager) {
		
	}

	public void hitOrStay(Deck deck, Hand hd, int s) {
		// TODO Auto-generated method stub
		
	}
}
