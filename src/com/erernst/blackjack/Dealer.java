package com.erernst.blackjack;

public class Dealer extends Player {
	Hand hand;
	
	public Dealer(String name, Hand hand, Double wallet) {
		super(name, hand, wallet);
		
	}

	
	
//	private Hand dealHand(){
//		Hand userHand = new Hand();
//	for (int i = 0; i < 2; i++) {	
//		Card p = deck.dealCard();
//		System.out.println("You are dealt a " + p);
//		Card d = deck.dealCard();
//		userHand.addCard(p);
//		hand.addCard(d);
//		System.out.println("Dealer is dealt a " + d);}
//	return userHand;
//	}
	
}
